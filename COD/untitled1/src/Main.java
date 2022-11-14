import javax.swing.JOptionPane;
public class Main {

    public static void main(String[] args) {

        String num=JOptionPane.showInputDialog("Teclee o número");
        float n=Float.parseFloat(num);
        if(n>=0){
            JOptionPane.showMessageDialog(null, "É positivo");
        }


    }

}