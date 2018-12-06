package Controller;

import Modelo.Edificios.Castillo;
import Modelo.Exceptions.EdificioNoExisteException;
import Modelo.Exceptions.OroInsuficienteException;
import Modelo.Jugador.Jugador;
import Modelo.Mapa;
import Modelo.Unidades.ArmaDeAsedio;
import View.JugadorView;
import View.MapaView;
import View.contenedores.ActualizarView;
import View.contenedores.Alerta;
import View.entidades.CastilloView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class CrearArmaHandler implements EventHandler <ActionEvent> {

    private CastilloView castillo;

    public CrearArmaHandler(CastilloView castillo) {
        this.castillo  = castillo;
    }

    @Override
    public void handle(ActionEvent event) {
        MapaView mapa = MapaView.getInstancia();
        Castillo castilloMod = (Castillo) castillo.getEntidad();
        ActualizarView actualizarView = ActualizarView.getInstancia();
        JugadorView jugadorViewActual = actualizarView.getJugadorViewActual();
        try {
            jugadorViewActual.crearArmaDeAsedio(castilloMod);
            mapa.reproducirEfecto().construirUnidad();
            mapa.enviarMensaje("Arma de asedio creada exitosamente.");
        }catch (EdificioNoExisteException e){
            new Alerta().unidadEnemiga();
        }catch (OroInsuficienteException e) {
            new Alerta().oroInsuficiente();
        }
    }
}
