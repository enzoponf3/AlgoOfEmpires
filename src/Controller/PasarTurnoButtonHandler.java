package Controller;

import Modelo.Juego;
import View.contenedores.ActualizarView;
import View.contenedores.PantallaJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


import java.util.Observable;

public class PasarTurnoButtonHandler implements EventHandler<ActionEvent> {             //Ver donde meter la verificacion de vida castillo == 0 -> termina juego

    private Juego juego;
    private ActualizarView actualizarUI;

    public PasarTurnoButtonHandler(Juego juego, ActualizarView actualizarUI){
        this.juego = juego;
        this.actualizarUI = actualizarUI;

    }

    public void handle(ActionEvent event){
        this.actualizarUI.AlternarJugador();     //Esto cambia el JugadorView actual, no hace nada en el modelo, solo UI
        this.juego.cambiarDeTurno();             //Esto activa y desactiva a cada jugador, se supone que no deberia poderse tocar las entidades enemigas o tirar exception
    }
}
