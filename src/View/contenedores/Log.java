package View.contenedores;
import java.util.Observable;

public class Log extends Observable {

    private String logText = "\n\n\n";

    public void enviarMensaje(String mensaje){
        logText = "\t"  + mensaje + "\n" + logText ;
        setChanged();
        notifyObservers();
    }

    public String getMensaje(){
        return this.logText;
    }

}
