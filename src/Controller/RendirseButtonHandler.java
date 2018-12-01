package Controller;

import Modelo.Jugador.Jugador;
import View.contenedores.ActualizarView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class RendirseButtonHandler implements EventHandler<ActionEvent> {

    private ActualizarView actualizarUI;
    private Jugador jugador;
    Stage stage;

    public RendirseButtonHandler(ActualizarView actualizarUI,Stage stage) {
        this.stage = stage;
        this.actualizarUI = actualizarUI;
    }

    @Override
    public void handle(ActionEvent event) {
        this.actualizarUI.getJugadorViewInactivo().mostrarQueGane();
        stage.close();
    }
}
