package Controller;

import Modelo.Exceptions.UnidadDesarmadaException;
import Modelo.Exceptions.UnidadEstaOcupadoException;
import Modelo.Exceptions.UnidadMovibleNoExisteException;
import Modelo.Unidades.ArmaDeAsedio;
import View.contenedores.Alerta;
import View.JugadorView;
import View.contenedores.ActualizarView;
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
            new Alerta().unidadOcupada();
        }catch (UnidadDesarmadaException e1){
            new Alerta().armaDesmontada();
        }catch (UnidadMovibleNoExisteException e2) {
            new Alerta().unidadEnemiga();
        }
    }
}
