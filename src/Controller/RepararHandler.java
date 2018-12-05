package Controller;

import Modelo.Edificios.Edificio;
import Modelo.Exceptions.*;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import View.JugadorView;
import View.MapaView;
import View.PiezaView;
import View.contenedores.ActualizarView;
import View.contenedores.Alerta;
import View.entidades.AldeanoView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class RepararHandler implements EventHandler<ActionEvent> {

    private Aldeano aldeanoModelo;
    private AldeanoView aldeanoView;

    public RepararHandler(Aldeano aldeanoModelo, AldeanoView aldeanoView) {
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
                reparar(mapaView);
                mapaView.setOnMouseClicked(null);
            }
        });
    }


    public void reparar(MapaView mapaView) {
        try{
            System.out.println("Obtener entidad");
            PiezaView edificioView = mapaView.getPiezaSeleccionada();
            try{
                Edificio edificio = (Edificio) edificioView.getEntidad();

                System.out.println("A reparar");
                ActualizarView actualizarView = ActualizarView.getInstancia();
                JugadorView jugadorViewActual = actualizarView.getJugadorViewActual();
                try{
                    jugadorViewActual.reparar(aldeanoModelo,edificio);
                    System.out.println("Reparo edificio");
                    System.out.println(edificio.getVida());
                } catch (PosicionInvalidaException e) {
                    new Alerta().posicionNoAledania();
                } catch (PosicionFueraDelMapaException e) {
                    new Alerta().posicionFueraDelMapa();
                } catch (AldeanoNoExisteException e) {
                    new Alerta().unidadEnemiga();
                } catch (ClassCastException e) {
                    new Alerta().edifcioEnConstNoSeleccionado();
                }

            } catch (java.lang.NullPointerException e) {
                new Alerta().edifcioEnConstNoSeleccionado();
            }
        }catch(java.lang.ClassCastException e) {
            new Alerta().objetivoIncorrecto();
        }

        mapaView.quitarBorde();
    }
}
