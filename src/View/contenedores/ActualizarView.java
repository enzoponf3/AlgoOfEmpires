package View.contenedores;

import View.JugadorView;
import View.MapaView;

import java.util.Observable;

public class ActualizarView extends Observable {

    private static ActualizarView INSTANCIA;

    private JugadorView jugadorViewInactivo;
    private JugadorView jugadorViewActual;

    public ActualizarView(JugadorView jugadorView1, JugadorView jugadorView2){
        this.jugadorViewActual = jugadorView1;      //Siempre inicia j1
        this.jugadorViewInactivo = jugadorView2;

        INSTANCIA = this;
    }

    public void AlternarJugador(){
        JugadorView aux = this.jugadorViewActual;
        this.jugadorViewActual = this.jugadorViewInactivo;
        this.jugadorViewInactivo = aux;
//      Deselecciono casillero del jugador actual
        MapaView mapaView = MapaView.getInstancia();
        mapaView.seleccionarCasillero(null);

        setChanged();
        notifyObservers();
    }

    public JugadorView getJugadorViewActual(){
        return this.jugadorViewActual;
    }

    public JugadorView getJugadorViewInactivo() {
        return jugadorViewInactivo;
    }

    public static ActualizarView getInstancia(){
        return INSTANCIA;
    }

}
