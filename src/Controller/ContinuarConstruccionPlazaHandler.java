package Controller;

import Modelo.Edificios.PlazaCentral;
import Modelo.Exceptions.*;
import Modelo.IEntidad;
import Modelo.Unidades.Aldeano;
import View.JugadorView;
import View.MapaView;
import View.contenedores.ActualizarView;
import View.contenedores.Alerta;
import View.entidades.CuartelView;
import View.entidades.PlazaCentralView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ContinuarConstruccionPlazaHandler implements EventHandler<ActionEvent> {

    private final Aldeano aldeano;

    public ContinuarConstruccionPlazaHandler(Aldeano entidadModelo) {
        this.aldeano = entidadModelo;
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

    private void continuarConstruccion(MapaView mapaView) {
        try {
            PlazaCentralView edificioView = (PlazaCentralView) mapaView.getPiezaSeleccionada();


            try {
                PlazaCentral edificioModelo = (PlazaCentral) edificioView.getEntidad();
                ActualizarView actualizarView = ActualizarView.getInstancia();
                JugadorView jugadorViewActual = actualizarView.getJugadorViewActual();

                try {
                    jugadorViewActual.continuarConstruccionPlazaCentral(aldeano, edificioModelo);
                    edificioView.construir();
                    mapaView.reproducirEfecto().continuarEdificio();
                    MapaView.getInstancia().enviarMensaje("Se continuo la construcción de la plaza central.");
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
                } catch (EdificioYaConstruidoException e) {
                    new Alerta().edificioYaConstruido();
                } catch(EdificioEnConstruccionException e){
                    new Alerta().edificioAunEnConst();
                } catch (EdificioNoExisteException e) {
                    new Alerta().edificioAjeno();
                }


            } catch (java.lang.NullPointerException e) {
                new Alerta().edifcioEnConstNoSeleccionado();
            }

        }catch(ClassCastException e){
            new Alerta().objetivoIncorrecto();
        }
        mapaView.quitarBorde();
    }
}
