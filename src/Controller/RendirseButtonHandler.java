package Controller;

import Modelo.Jugador.Jugador;
import View.contenedores.ActualizarView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class RendirseButtonHandler implements EventHandler<ActionEvent> {

    private Jugador jugador;
    Stage stage;

    public RendirseButtonHandler(/*Stage stage, Jugador jugador*/) {
        this.jugador = jugador;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {
        jugador.rendirse();
    }
}
