package Controller;

import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Exceptions.UnidadEstaOcupadoException;
import Modelo.Exceptions.UnidadMovibleNoExisteException;
import Modelo.Posicion;
import Modelo.Unidades.Unidad;
import View.Constantes;
import View.JugadorView;
import View.MapaView;
import View.PiezaView;
import View.contenedores.ActualizarView;
import View.contenedores.Notificacion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

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
            new Notificacion("Primero debes seleccionar el casillero de destino");
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
            new Notificacion("Ya movio bobo");

        }catch (UnidadMovibleNoExisteException e1){
            new Notificacion("No es tuyo bobo");
        }catch (PosicionInvalidaException e2){
            new Notificacion("El destino seleccionado es muy lejos y a la unidad le da PAJA");
        }
    }

}
