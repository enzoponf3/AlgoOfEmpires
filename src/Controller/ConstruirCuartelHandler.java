package Controller;

import Modelo.Edificios.Cuartel;
import Modelo.Edificios.PlazaCentral;
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
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class ConstruirCuartelHandler implements EventHandler<ActionEvent> {

    private Aldeano aldeanoModelo;

    public ConstruirCuartelHandler(Aldeano aldeanoModelo){
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

    public void construir(MapaView mapaView){
        try {
            Posicion posicion = mapaView.getDestino();

            ActualizarView actualizarView = ActualizarView.getInstancia();
            JugadorView jugadorViewActual = actualizarView.getJugadorViewActual();

            try {
                Mapa mapaModelo = Mapa.getInstancia();
                ArrayList<Posicion> posiciones = mapaModelo.getBloque2x2(posicion);
                jugadorViewActual.construirCuartel(aldeanoModelo, posiciones);
                mapaView.reproducirEfecto().construirEdificio();
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
