package View.contenedores;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.Observable;
import java.util.Observer;

public class DisplayLog extends HBox implements Observer {

    private Log log;

    public DisplayLog(Log log){
        this.log = log;
        log.addObserver(this);
        getChildren().add(new Label());
    }

    @Override
    public void update(Observable o, Object arg) {
        if( o != log)
            return;

        getChildren().set(0,new Label(log.getMensaje()));
    }
}
