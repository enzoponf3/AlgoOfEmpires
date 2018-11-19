package Modelo.Unidades;
import Modelo.Edificios.*;
import Modelo.Edificios.Cuartel;
import Modelo.Edificios.PlazaCentral;
import Modelo.Posicion;

import java.util.ArrayList;

public class EstadoAldeanoLibre implements EstadoAldeano {

    @Override
    public int generaOro(){
        return 20;
    }

    @Override
    public Cuartel construirCuartel(Aldeano aldeano, ArrayList<Posicion> posiciones){
        aldeano.ocupar();
        return new Cuartel(posiciones);
    }

    @Override
    public PlazaCentral construirPlazaCentral(Aldeano aldeano, ArrayList<Posicion> posiciones){
        aldeano.ocupar();
        return new PlazaCentral(posiciones);
    }

    @Override
    public Cuartel construirCuartel(Aldeano aldeano){
        aldeano.ocupar();
        return new Cuartel();
    }

    @Override
    public PlazaCentral construirPlazaCentral(Aldeano aldeano){
        aldeano.ocupar();
        return new PlazaCentral();
    }

    @Override
    public void repararEdificio(Edificio edificio, Aldeano aldeano){
        edificio.reparar();
        aldeano.ocupar();
    }

    @Override
    public void continuarConstruccion(Edificio edificio, Aldeano aldeano){
        edificio.construir();
        aldeano.ocupar();
    }


    @Override
    public void mover(Posicion destino, Aldeano aldeano){
        aldeano.cambiarPosicion(destino);
        aldeano.ocupar();
    }
}
