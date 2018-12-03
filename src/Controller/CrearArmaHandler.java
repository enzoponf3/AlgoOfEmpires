package Controller;

import Modelo.Edificios.Castillo;
import Modelo.Jugador.Jugador;
import Modelo.Mapa;
import Modelo.Unidades.ArmaDeAsedio;
import View.JugadorView;
import View.MapaView;
import View.contenedores.ActualizarView;
import View.entidades.CastilloView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CrearArmaHandler implements EventHandler <ActionEvent> {

    private CastilloView castillo;

    public CrearArmaHandler(CastilloView castillo) {
        this.castillo  = castillo;


    }

    @Override
    public void handle(ActionEvent event) {
        Castillo castilloMod = (Castillo) castillo.getEntidad();
        ActualizarView actualizarView = ActualizarView.getInstancia();
        JugadorView jugadorViewActual = actualizarView.getJugadorViewActual();
        jugadorViewActual.crearArmaDeAsedio(castilloMod);
    }
}
