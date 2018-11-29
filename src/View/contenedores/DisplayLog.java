package View.contenedores;

import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;

import java.util.Observable;
import java.util.Observer;

public class DisplayLog extends HBox implements Observer {

    private Log log;

    public DisplayLog(Log log){
        Rectangle2D limitesPantalla =  Screen.getPrimary().getVisualBounds();

        this.log = log;
        log.addObserver(this);
        this.setPrefSize((2*limitesPantalla.getWidth())/3,limitesPantalla.getHeight()/5);
        setStyle("-fx-background-color: lightblue");
        getChildren().add(new Label());
    }

    @Override
    public void update(Observable o, Object arg) {
        if( o != log)
            return;
        getChildren().set(0,new Label(log.getMensaje()));
    }
}
