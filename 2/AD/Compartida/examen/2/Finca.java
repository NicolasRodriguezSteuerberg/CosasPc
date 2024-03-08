
package pfincas;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity

public class Finca {
    @Id 
    private String codf ;
    private String dni ; 

    public Finca() {
    }

    public Finca(String codf, String dni) {
        this.codf = codf;
        this.dni = dni;
    }

    public String getCodf() {
        return codf;
    }

    public void setCodf(String codf) {
        this.codf = codf;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Finca{" + "codf=" + codf + ", dni=" + dni + '}';
    }
    
    
}
