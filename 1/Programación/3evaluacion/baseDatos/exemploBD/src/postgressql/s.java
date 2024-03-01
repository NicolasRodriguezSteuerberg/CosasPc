package chatserver;

import java.io.*;
import java.net.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatServer {

    private static final int PORT = 6666;
    private static final int MAX_CLIENTS = 10;

    private Set<PrintWriter> clientWriters = new HashSet<>();
    private boolean serverRunning = true;
    private int connectedClients=0;

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        chatServer.start();
    }

    //Funcion del servidor

    public void start() {
        ServerSocket serverSocket = null;
        String nickname = null;
        try {
            System.out.println("Creando socket servidor");
            serverSocket = new ServerSocket();

            System.out.println("Realizando el bind");
            InetSocketAddress addr = new InetSocketAddress("192.168.0.1", PORT);
            serverSocket.bind(addr);

            System.out.println("Aceptando conexiones...");

            while (serverRunning) {
                Socket socket = serverSocket.accept();
                PrintWriter writer = null;

                // Si no hay clientes conectados, mostrar el mensaje "Ningún cliente conectado"
                if (connectedClients==0) {
                    System.out.println("Ningún cliente conectado.");
                }

                if (clientWriters.size() < MAX_CLIENTS) {
                    connectedClients++;

                    // Obtener el nombre del cliente
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    nickname = reader.readLine();

                    // Agregar el escritor del cliente a la lista
                    writer = new PrintWriter(socket.getOutputStream(), true);
                    synchronized (clientWriters) {
                        clientWriters.add(writer);
                    }

                    // Mensaje de nuevo cliente conectado
                    System.out.println("Nuevo cliente conectado: " + nickname + ". Actualmente hay " + connectedClients + " usuario(s) conectados.");
                }

                // Iniciar el manejador de cliente
                new ClientHandler(socket, nickname, writer).start();
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            // Cerrar el socket del servidor
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    System.err.println("Error al cerrar el socket del servidor: " + e.getMessage());
                }
            }

            // Notificar que el servidor se ha desconectado
            System.out.println("El servidor se ha desconectado.");

            // Cerrar todas las conexiones de los clientes
            synchronized (clientWriters) {
                for (PrintWriter writer : clientWriters) {
                    writer.println("El servidor se ha desconectado.");
                    writer.close();
                }
            }
        }
    }

    //Hilo que maneja el/los Cliente(s)

    private class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter writer;
        private String nickname;

        public ClientHandler(Socket socket, String nickname, PrintWriter writer) {
            this.socket = socket;
            this.nickname = nickname;
            this.writer = writer;
        }

        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // Leer y retransmitir mensajes del cliente
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println(nickname + ": " + message);
                    synchronized (clientWriters) {
                        for (PrintWriter client : clientWriters) {
                            client.println(nickname + ": " + message);
                        }
                    }

                }
            } catch (IOException e) {
                System.err.println("AVISO: " + e);
            } finally {
                if (nickname != null) {
                    connectedClients--;
                    System.out.println(nickname + " dejó el chat.");

                    if(connectedClients==0){
                        System.out.println("Ningun cliente conectado");
                    }
                    synchronized (clientWriters) {
                        clientWriters.remove(writer);
                        for (PrintWriter client : clientWriters) {
                            client.println(nickname + " dejó el chat ");
                        }
                    }

                    // Preguntar al usuario si desea cerrar el servidor después de cada mensaje
                    System.out.println("¿Desea cerrar el servidor? (s/n)");
                    Scanner scanner = new Scanner(System.in);
                    String input = scanner.nextLine();
                    if (input.equalsIgnoreCase("s") && serverRunning) {
                        serverRunning=false;
                    }
                }

                // Si el servidor se desconecta, notificar a los clientes y cerrar sus conexiones
                if (!serverRunning) {
                    synchronized (clientWriters) {
                        for (PrintWriter client : clientWriters) {
                            client.println("El servidor se desconectó.");
                            client.close();
                        }
                        try {
                            socket.close();
                            System.out.println("Servidor desconectado");
                            System.exit(0);
                        } catch (IOException ex) {
                            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
    }
}