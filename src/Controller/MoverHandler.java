package Controller;

import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Exceptions.UnidadEstaOcupadoException;
import Modelo.Exceptions.UnidadMovibleNoExisteException;
import Modelo.Posicion;
import Modelo.Unidades.Unidad;
import View.*;
import View.contenedores.ActualizarView;
import View.contenedores.Alerta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MoverHandler implements EventHandler<ActionEvent> {

    private Unidad unidadModelo;
    private PiezaView unidadView;

    public MoverHandler(Unidad unidadModelo, PiezaView unidadView){
        this.unidadModelo = unidadModelo;
        this.unidadView = unidadView;
    }

    @Override
    public void handle(ActionEvent event) {
        MapaView mapaView = MapaView.getInstancia();
        Posicion destino = null;
        try{
            destino = mapaView.getDestino();

        }catch (NullPointerException e){
            new Alerta().seleccionarCasilleroDestino();
            return;
        }
        double destinoX = destino.getHorizontal();
        double destinoY = destino.getVertical();

        ActualizarView actualizarView = ActualizarView.getInstancia();
        JugadorView jugadorViewActual = actualizarView.getJugadorViewActual();

        try{
            jugadorViewActual.mover(unidadModelo, destino);
            unidadView.relocate(destinoX * Constantes.TAMANIO_CASILLERO, destinoY * Constantes.TAMANIO_CASILLERO);
            System.out.println(destinoX);
            System.out.println(destinoY);
        }catch (UnidadEstaOcupadoException e){
            new Alerta().unidadOcupada();
        }catch (UnidadMovibleNoExisteException e1){
            new Alerta().unidadEnemiga();
        }catch (PosicionInvalidaException e2){
            new Alerta().posicionNoAledania();
        }
    }

}
