package Controller;

import Modelo.Edificios.Cuartel;
import Modelo.Exceptions.EdificioNoConstruidoException;
import Modelo.Exceptions.EdificioNoExisteException;
import Modelo.Exceptions.OroInsuficienteException;
import View.JugadorView;
import View.MapaView;
import View.contenedores.ActualizarView;
import View.contenedores.Alerta;
import View.entidades.CuartelView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CrearArqueroHandler implements EventHandler<ActionEvent> {
    CuartelView cuartel;

    public CrearArqueroHandler(CuartelView cuartelView) {
        this.cuartel = cuartelView;

    }

    @Override
    public void handle(ActionEvent event) {
        MapaView mapa = MapaView.getInstancia();
        Cuartel cuartelMod = (Cuartel) this.cuartel.getEntidad();
        ActualizarView actualizarView = ActualizarView.getInstancia();
        JugadorView jugadorViewActual = actualizarView.getJugadorViewActual();
        try {
            jugadorViewActual.crearArquero(cuartelMod);
            mapa.enviarMensaje("Arquero creado exitosamente.");
        }catch (EdificioNoExisteException e){
            new Alerta().unidadEnemiga();
        }catch (OroInsuficienteException e) {
            new Alerta().oroInsuficiente();
        }catch (EdificioNoConstruidoException e){
            new Alerta().edificioNoConstruido();
        }
    }
}
