package Controller;

import Modelo.Exceptions.UnidadDesarmadaException;
import Modelo.Exceptions.UnidadEstaOcupadoException;
import Modelo.Exceptions.UnidadMovibleNoExisteException;
import Modelo.IEntidad;
import Modelo.Unidades.ArmaDeAsedio;
import View.MapaView;
import View.PiezaView;
import View.contenedores.Alerta;
import View.JugadorView;
import View.contenedores.ActualizarView;
import View.entidades.ArmaDeAsedioView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DesmontarHandler implements EventHandler<ActionEvent> {
    private ArmaDeAsedioView arma;

    public DesmontarHandler(IEntidad atacante, ArmaDeAsedioView pieza) {
        this.arma = pieza;
    }

    @Override
    public void handle(ActionEvent event) {
        ActualizarView actualizarView = ActualizarView.getInstancia();
        JugadorView jugadorViewActual = actualizarView.getJugadorViewActual();
        try{
            MapaView mapa = MapaView.getInstancia();
            jugadorViewActual.desmontarArma((ArmaDeAsedio) arma.getEntidad());
            arma.removerImagen();
            ImageView imagenArmaFrente = new ImageView(new Image("View/img/Trebuchetmove039.png"));
            ImageView imagenArmaEspalda = new ImageView(new Image("View/img/Trebuchetmove012.png"));
            arma.agregarImagen(imagenArmaFrente,imagenArmaEspalda);
            mapa.enviarMensaje("Arma de asedio desmontada.");
        }catch (UnidadEstaOcupadoException e){
            new Alerta().unidadOcupada();
        }catch (UnidadDesarmadaException e1){
            new Alerta().armaDesmontada();
        }catch (UnidadMovibleNoExisteException e2) {
            new Alerta().unidadEnemiga();
        }
    }
}
