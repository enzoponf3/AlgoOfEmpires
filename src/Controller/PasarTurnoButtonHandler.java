package Controller;

import Modelo.Juego;
import View.contenedores.ActualizarView;
import View.contenedores.PantallaJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


import java.util.Observable;

public class PasarTurnoButtonHandler implements EventHandler<ActionEvent> {

    private Juego juego;
    private PantallaJuego pantalla;
    private ActualizarView actualizarIcono;

    public PasarTurnoButtonHandler(Juego juego, ActualizarView actualizarIcono){
        this.juego = juego;
        this.actualizarIcono = actualizarIcono;

    }

    public void handle(ActionEvent event){

    }
}
