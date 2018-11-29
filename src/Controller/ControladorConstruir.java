package Controller;

import Modelo.Edificios.Cuartel;
import Modelo.Edificios.PlazaCentral;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import View.entidades.AldeanoView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class ControladorConstruir implements EventHandler<ActionEvent> {

    AldeanoView aldeanoView;
    Aldeano aldeanoModelo;
    ArrayList<Posicion> posiciones;

    public ControladorConstruir(AldeanoView aldeanoView, Aldeano aldeanoModelo, ArrayList<Posicion> posiciones){
        this.aldeanoView = aldeanoView;
        this.aldeanoModelo = aldeanoModelo;
        this.posiciones = posiciones;
    }

    @Override
    public void handle(ActionEvent event) {
        this.aldeanoModelo.construirPlazaCentral(this.posiciones);
    }

}
