package Controller;

import Modelo.Juego;
import Modelo.Jugador.Jugador;
import View.contenedores.ActualizarView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class RendirseButtonHandler implements EventHandler<ActionEvent> {

    private Juego juego;
    private ActualizarView actualizarUI;
    Stage stage;

    public RendirseButtonHandler(ActualizarView actualizarUI, Stage stage, Juego juego) {
        this.stage = stage;
        this.actualizarUI = actualizarUI;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent event) {
        this.actualizarUI.getJugadorViewActual().rendirse();
        this.actualizarUI.getJugadorViewInactivo().finalizar(juego);
        this.actualizarUI.getJugadorViewInactivo().mostrarQueGane();
        stage.close();
    }
}
