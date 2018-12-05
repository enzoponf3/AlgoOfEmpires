package Controller;

import Modelo.Juego;
import View.contenedores.ActualizarView;
import View.contenedores.PantallaJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


import java.util.Observable;

public class PasarTurnoButtonHandler implements EventHandler<ActionEvent> {

    private Juego juego;
    private ActualizarView actualizarUI;

    public PasarTurnoButtonHandler(Juego juego, ActualizarView actualizarUI){
        this.juego = juego;
        this.actualizarUI = actualizarUI;

    }

    public void handle(ActionEvent event){
        this.actualizarUI.AlternarJugador();
        this.juego.cambiarDeTurno();
    }
}
