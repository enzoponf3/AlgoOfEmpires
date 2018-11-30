package View.contenedores;

import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
        System.out.println("LogWidth:" + this.getPrefWidth() + "\nLogHeight:" + this.getPrefHeight());
        /*Image fondoLog = new Image("View/img/texturaLog.png",(2*limitesPantalla.getWidth())/3, limitesPantalla.getHeight()/5, false, true);
        ImageView im = new ImageView(fondoLog);*/
        this.setStyle("-fx-background-image: url(\"View/img/texturaLog.png\");");           //Ver si se deforma en la de enzo
        getChildren().addAll(new Label());
    }

    @Override
    public void update(Observable o, Object arg) {
        if( o != log)
            return;
        getChildren().set(0,new Label(log.getMensaje()));
    }
}
