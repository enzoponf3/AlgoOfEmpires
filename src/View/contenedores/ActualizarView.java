package View.contenedores;


import Modelo.Jugador.Jugador;
import View.JugadorView;

import java.util.Observable;

public class ActualizarView extends Observable {

    private JugadorView jugadorViewActual;
    private JugadorView jugadorView1;
    private JugadorView jugadorView2;

    public ActualizarView(JugadorView jugadorView1, JugadorView jugadorView2){
        this.jugadorViewActual = jugadorView1;      //Siempre inicia j1
        this.jugadorView1 = jugadorView1;
        this.jugadorView2 = jugadorView2;
    }

    public void AlternarJugador(){
        if(this.jugadorViewActual == this.jugadorView1)
            this.jugadorViewActual = this.jugadorView2;
        else
            this.jugadorViewActual = this.jugadorView1;

        setChanged();
        notifyObservers();
    }

    public JugadorView getJugadorView(){
        return this.jugadorViewActual;
    }


}
