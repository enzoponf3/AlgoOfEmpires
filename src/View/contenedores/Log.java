package View.contenedores;
import java.util.Observable;

public class Log extends Observable {

    private String logText = "";

    public void enviarMensaje(String mensaje){
        logText = "\n" + mensaje + logText ;
        setChanged();
        notifyObservers();
    }

    public String getMensaje(){
        return this.logText;
    }

}
