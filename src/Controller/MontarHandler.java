package Controller;

import Modelo.Exceptions.AtacanteNoExisteException;
import Modelo.Exceptions.UnidadEstaMontadaException;
import Modelo.Exceptions.UnidadEstaOcupadoException;
import Modelo.Exceptions.UnidadMovibleNoExisteException;
import Modelo.Unidades.ArmaDeAsedio;
import View.JugadorView;
import View.contenedores.ActualizarView;
import View.contenedores.Notificacion;
import View.entidades.ArmaDeAsedioView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class MontarHandler implements EventHandler<ActionEvent> {
    private  ArmaDeAsedio arma;

    public MontarHandler(ArmaDeAsedio arma) {
        this.arma = arma;
    }

    @Override
    public void handle(ActionEvent event) {
        ActualizarView actualizarView = ActualizarView.getInstancia();
        JugadorView jugadorViewActual = actualizarView.getJugadorViewActual();
        try{
            jugadorViewActual.montarArma(arma);
        }catch (UnidadEstaOcupadoException e){
            new Notificacion("Esta arma esta ocupada");
        }catch (UnidadEstaMontadaException e1){
            new Notificacion("Esta arma ya esta montada");
        }catch (AtacanteNoExisteException e2) {
            new Notificacion("ESTA ARMA NO ES TUYA BOBO");
        }
    }
}
