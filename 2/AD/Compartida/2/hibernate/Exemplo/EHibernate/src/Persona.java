import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Entity;

@Entity
@Table(name="Persona")
public class Persona implements Serializable{
    @Id
    @Column(name="id")     
    private int id;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="apellido")
    private String apellido;
    
    @Column(name="salario")
    private BigDecimal salario;
    
    public Persona(){}

    public Persona(int id, String nombre, String apellido, BigDecimal salario) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return " id=" + id + ", salario=" + salario + ", nombre=" + nombre + ", apellido=" + apellido;
    }
    
    
}
