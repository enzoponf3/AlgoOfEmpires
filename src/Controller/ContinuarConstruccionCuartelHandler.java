package Controller;

import Modelo.Edificios.Cuartel;
import Modelo.Exceptions.*;
import Modelo.Unidades.Aldeano;
import View.JugadorView;
import View.MapaView;
import View.contenedores.ActualizarView;
import View.contenedores.Alerta;
import View.entidades.CuartelView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ContinuarConstruccionCuartelHandler implements EventHandler<ActionEvent> {

    private Aldeano aldeanoModelo;

    public ContinuarConstruccionCuartelHandler(Aldeano aldeanoModelo){
        this.aldeanoModelo = aldeanoModelo;
    }

    @Override
    public void handle(ActionEvent event) {
        MapaView mapaView = MapaView.getInstancia();

        mapaView.settearBorde();

        mapaView.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                continuarConstruccion(mapaView);
                mapaView.setOnMouseClicked(null);
            }
        });
    }

    public void continuarConstruccion(MapaView mapaView){
        try {
            CuartelView edificioView = (CuartelView) mapaView.getPiezaSeleccionada();

            try {
                Cuartel edificioModelo = (Cuartel) edificioView.getEntidad();
                ActualizarView actualizarView = ActualizarView.getInstancia();
                JugadorView jugadorViewActual = actualizarView.getJugadorViewActual();

                try {
                    jugadorViewActual.continuarConstruccionCuartel(aldeanoModelo, edificioModelo);
                    edificioView.construir();
                    mapaView.reproducirEfecto().continuarEdificio();
                    if (jugadorViewActual.construccionFinalizada(edificioModelo)) {
                        MapaView.getInstancia().enviarMensaje("Construcción del cuartel finalizada.");
                    } else {
                        MapaView.getInstancia().enviarMensaje("Construcción del cuartel continuada.");
                    }
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
                } catch (ClassCastException e) {
                    new Alerta().edifcioEnConstNoSeleccionado();
                } catch (EdificioNoExisteException e) {
                    new Alerta().edificioAjeno();
                } catch (EdificioYaConstruidoException e) {
                    new Alerta().edificioYaConstruido();
                } catch (EdificioEnConstruccionException e) {
                    new Alerta().edificioAunEnConst();
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
