package View.contenedores;


import Modelo.Jugador.Jugador;
import View.JugadorView;

import java.util.Observable;

public class ActualizarView extends Observable {

    private Jugador jugador;
    private JugadorView jugadorView;

    public void enviarJugador(/*Jugador jugador,*/ JugadorView jugadorView) {
        this.jugadorView = jugadorView;
        /*this.jugador = jugador;*/
        setChanged();
        notifyObservers();
    }

    public JugadorView getJugadorView(){
        return this.jugadorView;
    }


}
