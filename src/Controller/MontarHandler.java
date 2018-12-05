package Controller;

import Modelo.Exceptions.AtacanteNoExisteException;
import Modelo.Exceptions.UnidadEstaMontadaException;
import Modelo.Exceptions.UnidadEstaOcupadoException;
import Modelo.Mapa;
import Modelo.Unidades.ArmaDeAsedio;
import View.MapaView;
import View.contenedores.Alerta;
import View.JugadorView;
import View.contenedores.ActualizarView;
import View.entidades.ArmaDeAsedioView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class MontarHandler implements EventHandler<ActionEvent> {
    private  ArmaDeAsedioView arma;

    public MontarHandler(ArmaDeAsedioView arma) {
        this.arma = arma;
    }

    @Override
    public void handle(ActionEvent event) {
        ActualizarView actualizarView = ActualizarView.getInstancia();
        JugadorView jugadorViewActual = actualizarView.getJugadorViewActual();
        try{
            MapaView mapa = MapaView.getInstancia();
            jugadorViewActual.montarArma((ArmaDeAsedio) arma.getEntidad());
            arma.removerImagen();
            ImageView imagenArmaFrente = new ImageView(new Image("View/img/Trebuchetstand004.png"));
            ImageView imagenArmaEspalda = new ImageView(new Image("View/img/Trebuchetstand002.png"));
            arma.agregarImagen(imagenArmaFrente,imagenArmaEspalda);
            mapa.enviarMensaje("Arma de asedio montada.");
        }catch (UnidadEstaOcupadoException e){
            new Alerta().unidadOcupada();
        }catch (UnidadEstaMontadaException e1){
            new Alerta().armaMontada();
        }catch (AtacanteNoExisteException e2) {
            new Alerta().unidadEnemiga();
        }
    }
}
