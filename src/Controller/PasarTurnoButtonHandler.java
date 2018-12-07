package Controller;

import Modelo.Juego;
import Modelo.Jugador.Jugador;
import View.JugadorView;
import View.MapaView;
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
        MapaView.getInstancia().ControlarMusica().parar();
        this.juego.cambiarDeTurno();
        if(juego.getGanador() != null)
            actualizarUI.getJugadorViewActual().mostrarQueGane();
        this.actualizarUI.AlternarJugador();

        JugadorView jugadorView = this.actualizarUI.getJugadorViewInactivo();
        jugadorView.removerPiezasMuertas();

        MapaView.getInstancia().enviarMensaje("El castillo atacó.");
        MapaView.getInstancia().removerPiezasDestruidas();


    }
}
