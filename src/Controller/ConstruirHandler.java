package Controller;

import Modelo.Edificios.Cuartel;
import Modelo.Edificios.PlazaCentral;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import View.JugadorView;
import View.MapaView;
import View.entidades.AldeanoView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class ConstruirHandler implements EventHandler<ActionEvent> {

    AldeanoView aldeanoView;
    Aldeano aldeanoModelo;

    JugadorView jugadorView;

    public ConstruirHandler(Aldeano aldeanoModelo){
        this.aldeanoModelo = aldeanoModelo;
    }

    public void setJugadorActual(){

    }

    @Override
    public void handle(ActionEvent event) {
        MapaView mapaView = MapaView.getInstancia();
        Posicion posicion = mapaView.getDestino();
        ArrayList<Posicion> posiciones = new ArrayList<>();


        this.aldeanoModelo.construirPlazaCentral(posiciones);
    }

}
