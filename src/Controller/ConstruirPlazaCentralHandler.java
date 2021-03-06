package Controller;

import Modelo.Exceptions.*;
import Modelo.Mapa;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import View.contenedores.Alerta;
import View.JugadorView;
import View.MapaView;
import View.contenedores.ActualizarView;
import View.entidades.AldeanoView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class ConstruirPlazaCentralHandler implements EventHandler<ActionEvent> {

    private Aldeano aldeanoModelo;

    public ConstruirPlazaCentralHandler(Aldeano aldeanoModelo){
        this.aldeanoModelo = aldeanoModelo;
    }

    @Override
    public void handle(ActionEvent event){
        MapaView mapaView = MapaView.getInstancia();
        mapaView.settearBorde();

        mapaView.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                construir(mapaView);
                mapaView.setOnMouseClicked(null);
            }
        });
    }

    public void construir(MapaView mapaView) {
        try {
            Posicion posicion = mapaView.getDestino();

            ActualizarView actualizarView = ActualizarView.getInstancia();
            JugadorView jugadorViewActual = actualizarView.getJugadorViewActual();

            try {
                Mapa mapaModelo = Mapa.getInstancia();
                ArrayList<Posicion> posiciones = mapaModelo.getBloque2x2(posicion);
                jugadorViewActual.construirPlazaCentral(aldeanoModelo, posiciones);
                mapaView.reproducirEfecto().construirEdificio();
                MapaView.getInstancia().enviarMensaje("Plaza central en construcción.");
            } catch (OroInsuficienteException e) {
                new Alerta().oroInsuficiente();
            } catch (PosicionInvalidaException e) {
                new Alerta().posicionNoAledania();
            } catch (PosicionFueraDelMapaException e) {
                new Alerta().posicionFueraDelMapa();
            } catch (AldeanoNoExisteException e) {
                new Alerta().unidadEnemiga();
            } catch (PosicionOcupadaException e) {
                new Alerta().posicionOcupada();
            } catch (UnidadNoPuedeConstruirException e) {
                new Alerta().unidadOcupada();
            }

        }catch(CasilleroNoSeleccionadoException e){
            new Alerta().objetivoIncorrecto();
        }
        mapaView.quitarBorde();
    }
}
