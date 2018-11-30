package View.contenedores;


import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
        this.setStyle("-fx-background-image: url(\"View/img/texturaLog.png\");\n -fx-background-size: cover");
        getChildren().addAll(new Label());
        this.getStylesheets().add(getClass().getResource("/View/estilos/buttonsStylesheet.css").toString());

    }

    @Override
    public void update(Observable o, Object arg) {
        if( o != log)
            return;
        Label label = new Label(log.getMensaje());
        label.setTextFill(Color.SIENNA);
        label.setStyle("-fx-font-size: 16");
        getChildren().set(0,label);
    }
}
