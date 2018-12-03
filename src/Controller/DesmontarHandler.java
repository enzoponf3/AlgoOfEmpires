package Controller;

import Modelo.Exceptions.UnidadDesarmadaException;
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

public class DesmontarHandler implements EventHandler<ActionEvent> {
    private ArmaDeAsedio arma;

    public DesmontarHandler(ArmaDeAsedio arma) {
        this.arma = arma;
    }

    @Override
    public void handle(ActionEvent event) {
        ActualizarView actualizarView = ActualizarView.getInstancia();
        JugadorView jugadorViewActual = actualizarView.getJugadorViewActual();
        try{
            jugadorViewActual.desmontarArma(arma);
        }catch (UnidadEstaOcupadoException e){
            new Notificacion("Este arma esta ocupada");
        }catch (UnidadDesarmadaException e1){
            new Notificacion("Este arma ya esta desmontada");
        }catch (UnidadMovibleNoExisteException e2) {
            new Notificacion("ESTE ARMA NO ES TUYA BOBO");
        }
    }
}
