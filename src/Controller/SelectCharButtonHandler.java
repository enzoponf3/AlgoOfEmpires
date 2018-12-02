package Controller;

import View.Boton;
import View.BotonRadio;
import View.JugadorView;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;

import java.awt.*;

public class SelectCharButtonHandler implements EventHandler<ActionEvent> {

    ImageView figSelected;
    JugadorView jugador;
    ToggleGroup opcionesPersonaje;
    BotonRadio boton;

    public  SelectCharButtonHandler (ImageView fig, JugadorView jugador, ToggleGroup group, BotonRadio boton){
        this.figSelected = fig;
        this.jugador = jugador;
        this.opcionesPersonaje = group;
        this.boton = boton;

    }
    public void handle(ActionEvent event) {
        if (this.boton.getGraphic() != this.jugador.getFigura()) {
            this.boton.getStyleClass().clear();
            this.boton.getStyleClass().add("radio-button");
        }
        this.opcionesPersonaje.selectToggle(this.boton);
    }

}
