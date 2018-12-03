package Controller;

import Modelo.Edificios.Cuartel;
import Modelo.Edificios.PlazaCentral;
import Modelo.Mapa;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import View.JugadorView;
import View.MapaView;
import View.contenedores.ActualizarView;
import View.entidades.AldeanoView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class ConstruirCuartelHandler implements EventHandler<ActionEvent> {

    private AldeanoView aldeanoView;
    private Aldeano aldeanoModelo;

    public ConstruirCuartelHandler(Aldeano aldeanoModelo, AldeanoView aldeanoView){
        this.aldeanoModelo = aldeanoModelo;
        this.aldeanoView = aldeanoView;
    }

    @Override
    public void handle(ActionEvent event) {
        MapaView mapaView = MapaView.getInstancia();
        Posicion posicion = mapaView.getDestino();
        ArrayList<Posicion> posiciones = completarPosicionesAledanias(posicion);

        ActualizarView actualizarView = ActualizarView.getInstancia();
        JugadorView jugadorViewActual = actualizarView.getJugadorViewActual();
        System.out.println("A construir cuartel");
        jugadorViewActual.construirCuartel(aldeanoModelo, posiciones);
        System.out.println("Se construyo");
    }

    private ArrayList<Posicion> completarPosicionesAledanias(Posicion posicion){
        Mapa mapaModelo = Mapa.getInstancia();
        System.out.println("Tengo posiciones");
        ArrayList<Posicion> posiciones = new ArrayList<>();
        Posicion pos2 = new Posicion(posicion.getHorizontal(), posicion.getVertical()+1);
        Posicion pos3 = new Posicion(posicion.getHorizontal()+1, posicion.getVertical()+1);
        Posicion pos4 = new Posicion(posicion.getHorizontal()+1, posicion.getVertical());
        posiciones.add(posicion);
        posiciones.add(pos2);
        posiciones.add(pos3);
        posiciones.add(pos4);
        return posiciones;
        //return mapaModelo.getPosicionesAledanias(posicion);
    }

}
