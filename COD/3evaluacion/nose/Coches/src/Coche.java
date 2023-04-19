public class Coche {
    private String modelo,matricula;
    private Integer velocidad = 0;

    /**
     * @param modelo
     * @param matricula
     */
    public Coche(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
    }

    public void acelerar(Integer aumentoV){
        velocidad+=aumentoV;
    }

    public void frenar(Integer reduzcoV){
        velocidad-=reduzcoV;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Integer getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
    }
}
