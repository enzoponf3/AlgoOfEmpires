package Controller;

import View.contenedores.Alerta;
import View.BotonRadio;
import View.JugadorView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;


public class ReadyButtonHandler implements EventHandler<ActionEvent> {
    private JugadorView jugador;
    private TextField nombre;
    private ToggleGroup grupoPersonajes;

    public ReadyButtonHandler(JugadorView jugador, TextField nombre, ToggleGroup group ) {
        this.jugador = jugador;
        this.nombre = nombre;
        grupoPersonajes = group;
    }

    public void handle(ActionEvent event) {
        if (this.nombre.getText().trim().isEmpty()) {
            new Alerta().faltaNombre();
        }
        else if(this.grupoPersonajes.getSelectedToggle() == null){
            new Alerta().faltaFigura();
        }else {
            BotonRadio opcionSeleccionada = (BotonRadio) this.grupoPersonajes.getSelectedToggle();
            this.jugador.setPersonaje((ImageView) opcionSeleccionada.getGraphic());
            this.jugador.setNombre(nombre.getText().trim());

            //jugador.mostrarQueGane(); Descomentar esto para ver pantalla win
        }
        grupoPersonajes.getToggles().stream().map((toggle) -> (BotonRadio)toggle).forEach((button) -> {
            button.getStyleClass().add("radio-button-confirmed");
        });

    }
}
