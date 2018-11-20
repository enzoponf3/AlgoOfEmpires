package Modelo.Unidades;
import Modelo.Edificios.*;
import Modelo.Edificios.Cuartel;
import Modelo.Edificios.PlazaCentral;
import Modelo.Exceptions.EntidadFueraDeRangoException;
import Modelo.Posicion;

import java.util.ArrayList;

public class EstadoAldeanoLibre implements IEstadoAldeano {

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
    public void repararEdificio(Edificio edificio, Aldeano aldeano){
        ArrayList<Posicion> posiciones = edificio.getPosiciones();
        for (Posicion pos : posiciones ){
            if (aldeano.posicion.estaEnRango(pos, aldeano.getRango())){
                edificio.reparar();
                aldeano.ocupar();
                return;
            }
        }
        throw new EntidadFueraDeRangoException();
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
