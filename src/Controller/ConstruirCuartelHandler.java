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

    private AldeanoView aldeanoView;
    private Aldeano aldeanoModelo;

    public ConstruirCuartelHandler(Aldeano aldeanoModelo, AldeanoView aldeanoView){

        this.aldeanoModelo = aldeanoModelo;
        this.aldeanoView = aldeanoView;
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

        mapaView.quitarBorde();
    }

    public void construir(MapaView mapaView){
        Posicion posicion = mapaView.getDestino();

        ArrayList<Posicion> posiciones = new ArrayList<>();
        Posicion posicion1 = new Posicion(posicion.getHorizontal(), posicion.getVertical()+1);
        Posicion posicion2 = new Posicion(posicion.getHorizontal()+1, posicion.getVertical());
        Posicion posicion3 = new Posicion(posicion.getHorizontal()+1, posicion.getVertical()+1);
        posiciones.add(posicion);
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);

        ActualizarView actualizarView = ActualizarView.getInstancia();
        JugadorView jugadorViewActual = actualizarView.getJugadorViewActual();

        try {
            jugadorViewActual.construirCuartel(aldeanoModelo, posiciones);
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
        } catch (UnidadNoPuedeConstruirException e) {
            new Alerta().unidadOcupada();
        }

    }

    /*
    @Override
    public void handle(ActionEvent event) {

        MapaView mapaView = MapaView.getInstancia();
        Posicion posicion = mapaView.getDestino();
        Mapa mapaModelo = Mapa.getInstancia();

        try {

            ArrayList<Posicion> posiciones = mapaModelo.getBloque2x2(posicion);
            ActualizarView actualizarView = ActualizarView.getInstancia();
            JugadorView jugadorViewActual = actualizarView.getJugadorViewActual();

            jugadorViewActual.construirCuartel(aldeanoModelo, posiciones);

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
        } catch (UnidadNoPuedeConstruirException e) {
            new Alerta().unidadOcupada();
        }
    }
    */

}
