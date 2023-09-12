package com.nicosteuerberg.paquete2;



public class Persoal {
    private String telefono;
    private String correo;
    
    // constructores
    public Persoal(){}
    
    public Persoal(String tlf, String email){
        telefono = tlf;
        correo = email;
    }
    
    // Accesos
    public void setTelefono(String tlf){
        telefono = tlf;
    } 
    
    public String getTelefono(){
        String tlf=telefono;
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
        return "telefono=" + telefono + ", correo=" + correo;
    }
    
    
        
}
