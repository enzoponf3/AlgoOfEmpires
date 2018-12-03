package Controller;

import Modelo.Exceptions.*;
import Modelo.Mapa;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import View.Alerta;
import View.JugadorView;
import View.MapaView;
import View.contenedores.ActualizarView;
import View.contenedores.Notificacion;
import View.entidades.AldeanoView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

import java.util.ArrayList;

public class ConstruirPlazaCentralHandler implements EventHandler<ActionEvent> {

    private AldeanoView aldeanoView;
    private Aldeano aldeanoModelo;

    public ConstruirPlazaCentralHandler(Aldeano aldeanoModelo, AldeanoView aldeanoView){
        this.aldeanoModelo = aldeanoModelo;
        this.aldeanoView = aldeanoView;
    }

    @Override
    public void handle(ActionEvent event) {
        MapaView mapaView = MapaView.getInstancia();
        Posicion posicion = mapaView.getDestino();
        Mapa mapaModelo = Mapa.getInstancia();
        try {
            ArrayList<Posicion> posiciones = mapaModelo.getBloque2x2(posicion);
            ActualizarView actualizarView = ActualizarView.getInstancia();
            JugadorView jugadorViewActual = actualizarView.getJugadorViewActual();
            jugadorViewActual.construirPlazaCentral(aldeanoModelo, posiciones);
        }catch (OroInsuficienteException e) {
            new Alerta().oroInsuficiente();
        } catch (PosicionInvalidaException e) {
            new Alerta().posicionNoAledania();
        } catch (PosicionFueraDelMapaException e) {
            new Alerta().posicionFueraDelMapa();
        } catch (AldeanoNoExisteException e) {
            new Alerta().unidadEnemiga();
        } catch (PosicionOcupadaException e) {
            new Alerta().posicionOcupada();
        }
    }
}
