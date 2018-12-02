package Controller;

import Modelo.Edificios.Edificio;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import View.JugadorView;
import View.MapaView;
import View.contenedores.ActualizarView;
import View.entidades.AldeanoView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class RepararHandler implements EventHandler<ActionEvent> {

    private Aldeano aldeanoModelo;
    private AldeanoView aldeanoView;

    public RepararHandler(Aldeano aldeanoModelo, AldeanoView aldeanoView) {
        this.aldeanoModelo = aldeanoModelo;
        this.aldeanoView = aldeanoView;
    }

    @Override
    public void handle(ActionEvent event) {
        MapaView mapaView = MapaView.getInstancia();
        System.out.println("Obtener entidad");

        Edificio edificio = (Edificio) mapaView.getEntidad();
        System.out.println("A reparar");

        ActualizarView actualizarView = ActualizarView.getInstancia();
        JugadorView jugadorViewActual = actualizarView.getJugadorViewActual();
        jugadorViewActual.reparar(aldeanoModelo,edificio);
        System.out.println("Reparo edificio");
    }
}
