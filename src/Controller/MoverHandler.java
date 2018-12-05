package Controller;

import Modelo.Constantes;
import Modelo.Exceptions.*;
import Modelo.IEntidad;
import Modelo.Posicion;
import Modelo.Unidades.Unidad;
import View.*;
import View.contenedores.ActualizarView;
import View.contenedores.Alerta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MoverHandler implements EventHandler<ActionEvent>{

    private Unidad unidadModelo;
    private PiezaView unidadView;

    public MoverHandler(IEntidad unidadModelo, PiezaView unidadView){
        this.unidadModelo = (Unidad) unidadModelo;
        this.unidadView = unidadView;
    }

    @Override
    public void handle(ActionEvent event){
        MapaView mapaView = MapaView.getInstancia();

        mapaView.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                mover(mapaView);
                mapaView.setOnMouseClicked(null);
            }
        });

    }

    public void mover(MapaView mapaView){
        Posicion destino = mapaView.getDestino();

        double destinoX = destino.getHorizontal();
        double destinoY = destino.getVertical();

        ActualizarView actualizarView = ActualizarView.getInstancia();
        JugadorView jugadorViewActual = actualizarView.getJugadorViewActual();

        try{
            jugadorViewActual.mover(unidadModelo, destino);
            unidadView.relocate(destinoX * Constantes.TAMANIO_CASILLERO, destinoY * Constantes.TAMANIO_CASILLERO);
            System.out.println(destinoX);
            System.out.println(destinoY);
            mapaView.enviarMensaje("Unidad movida exitosamente.");
        }catch (UnidadEstaOcupadoException e){
            new Alerta().unidadOcupada();
        }catch (UnidadMovibleNoExisteException e1){
            new Alerta().unidadEnemiga();
        }catch (PosicionInvalidaException e2){
            new Alerta().posicionNoAledania();
        }catch(UnidadEstaMontadaException e3){
            new Alerta().armaMontada();
        }

    }


}
