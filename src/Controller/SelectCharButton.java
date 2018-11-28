package Controller;

import View.JugadorView;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;

import java.awt.*;

public class SelectCharButton implements EventHandler<ActionEvent> {
    ImageView figSelected;
    JugadorView jugador;
    public  SelectCharButton (ImageView fig, JugadorView jugador){
        this.figSelected = fig;
        this.jugador = jugador;

    }
    public void handle(ActionEvent event){
        this.jugador.setPersonaje(this.figSelected);
    }


}
