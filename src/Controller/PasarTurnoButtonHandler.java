package Controller;

import Modelo.Juego;
import Modelo.Jugador.Jugador;
import View.JugadorView;
import View.MapaView;
import View.contenedores.ActualizarView;
import View.contenedores.PantallaJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;


import java.util.Observable;

public class PasarTurnoButtonHandler implements EventHandler<ActionEvent> {

    private Juego juego;
    private ActualizarView actualizarUI;
    private Stage stage;

    public PasarTurnoButtonHandler(Juego juego, ActualizarView actualizarUI, Stage stage){
        this.juego = juego;
        this.actualizarUI = actualizarUI;
        this.stage = stage;

    }

    public void handle(ActionEvent event){
        MapaView.getInstancia().ControlarMusica().parar();
        this.juego.cambiarDeTurno();
        if(juego.getGanador() != null){
            actualizarUI.getJugadorViewActual().mostrarQueGane();
            stage.close();
        }
        this.actualizarUI.AlternarJugador();

        JugadorView jugadorView = this.actualizarUI.getJugadorViewInactivo();
        jugadorView.removerPiezasMuertas();

        MapaView.getInstancia().enviarMensaje("El castillo atacó.");
        MapaView.getInstancia().removerPiezasDestruidas();


    }
}
