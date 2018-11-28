package Controller;

import View.JugadorView;
import View.contenedores.PantallaGanador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class ReadyButtonHandler implements EventHandler<ActionEvent> {
    private JugadorView jugador;
    private TextField nombre;

    public ReadyButtonHandler(JugadorView jugador, TextField nombre) {
        this.jugador = jugador;
        this.nombre = nombre;
    }

    public void handle(ActionEvent event) {
        if (this.nombre.getText().trim().isEmpty()) {
            Alert faltaNombre = new Alert(Alert.AlertType.ERROR);
            faltaNombre.setHeaderText(null);
            faltaNombre.setContentText("NO ESCRIBISTE UN NOMBRE!");
            faltaNombre.show();
        }
        else if(this.jugador.getFigura() == null){
            Alert faltaImagen = new Alert(Alert.AlertType.ERROR);
            faltaImagen.setHeaderText(null);
            faltaImagen.setContentText("NO SELECCIONASTE UNA FIGURA!");
            faltaImagen.show();
        }else {
            this.jugador.setNombre(nombre.getText().trim());

            //jugador.mostrarQueGane(); Descomentar esto para ver pantalla win
        }
    }
}
