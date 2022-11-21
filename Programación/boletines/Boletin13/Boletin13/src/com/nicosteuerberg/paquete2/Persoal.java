package com.nicosteuerberg.paquete2;



public class Persoal {
    private double telefono;
    private String correo;
    
    // constructores
    public Persoal(){};
    
    public Persoal(double tlf, String email){
        telefono = tlf;
        correo = email;
    }
    
    // Accesos
    public void setTelefono(double tlf){
        telefono = tlf;
    } 
    
    public double getTelefono(){
        double tlf=telefono;
        return tlf;
    }
    
    public void setCorreo(String email){
        correo = email;
    }
    
    public String getCorreo(){
        String email = correo;
        return email;
    }

    // to string
    @Override
    public String toString() {
        return "Persoal{" + "telefono=" + telefono + ", correo=" + correo + '}';
    }
    
    
        
}
