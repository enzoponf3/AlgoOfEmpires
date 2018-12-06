package Controller;

import Modelo.Edificios.Cuartel;
import Modelo.Edificios.PlazaCentral;
import Modelo.Exceptions.EdificioEnConstruccionException;
import Modelo.Exceptions.EdificioNoConstruidoException;
import Modelo.Exceptions.EdificioNoExisteException;
import Modelo.Exceptions.OroInsuficienteException;
import View.JugadorView;
import View.MapaView;
import View.contenedores.ActualizarView;
import View.contenedores.Alerta;
import View.entidades.CuartelView;
import View.entidades.PlazaCentralView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CrearAldeanoHandler implements EventHandler<ActionEvent> {
    PlazaCentralView plaza;

    public CrearAldeanoHandler(PlazaCentralView plazaCentralView) {
        this.plaza = plazaCentralView;
    }

    @Override
    public void handle(ActionEvent event) {
        MapaView mapa = MapaView.getInstancia();
        PlazaCentral plazaMod = (PlazaCentral) this.plaza.getEntidad();
        ActualizarView actualizarView = ActualizarView.getInstancia();
        JugadorView jugadorViewActual = actualizarView.getJugadorViewActual();
        try {
            jugadorViewActual.crearAldeano(plazaMod);
            mapa.enviarMensaje("Aldeano creado exitosamente.");
        }catch (EdificioNoExisteException e){
            new Alerta().unidadEnemiga();
        }catch (OroInsuficienteException e) {
            new Alerta().oroInsuficiente();
        }catch (EdificioNoConstruidoException e){
            new Alerta().edificioNoConstruido();
        }catch(EdificioEnConstruccionException e){
            new Alerta().edificioAunEnConst();
        }
    }
}
