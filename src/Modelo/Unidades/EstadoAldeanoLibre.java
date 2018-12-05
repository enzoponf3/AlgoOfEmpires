package Modelo.Unidades;
import Modelo.Edificios.*;
import Modelo.Edificios.Cuartel;
import Modelo.Edificios.PlazaCentral;
import Modelo.Exceptions.EntidadFueraDeRangoException;
import Modelo.Posicion;

import java.util.ArrayList;

public class EstadoAldeanoLibre implements IEstadoAldeano {
    Aldeano aldeano;
    public EstadoAldeanoLibre(Aldeano aldeano){
        this.aldeano = aldeano;
    }

    @Override
    public int generaOro(){
        return 20;
    }

    @Override
    public Cuartel construirCuartel(ArrayList<Posicion> posiciones){
        aldeano.ocupar();
        return new Cuartel(posiciones);
    }

    @Override
    public PlazaCentral construirPlazaCentral(ArrayList<Posicion> posiciones){
        aldeano.ocupar();
        return new PlazaCentral(posiciones);
    }

    @Override
    public void repararEdificio(Edificio edificio){
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
    public void continuarConstruccion(Edificio edificio){
        edificio.construir();
        aldeano.ocupar();
    }


    @Override
    public void mover(Posicion destino){
            aldeano.cambiarPosicion(destino);
            aldeano.movio();
    }
}
