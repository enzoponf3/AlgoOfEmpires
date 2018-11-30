package Controller;

import Modelo.Edificios.Cuartel;
import Modelo.Edificios.PlazaCentral;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import View.JugadorView;
import View.entidades.AldeanoView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class ControladorConstruir implements EventHandler<ActionEvent> {

    AldeanoView aldeanoView;
    Aldeano aldeanoModelo;
    ArrayList<Posicion> posiciones;
    JugadorView jugadorView;

    public ControladorConstruir(Aldeano aldeanoModelo){
        this.aldeanoModelo = aldeanoModelo;
    }

    public void setJugadorActual(){

    }

    @Override
    public void handle(ActionEvent event) {
        this.aldeanoModelo.construirPlazaCentral(this.posiciones);
    }

}
