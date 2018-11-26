package Modelo.Unidades;
import Modelo.Edificios.Cuartel;
import Modelo.Edificios.PlazaCentral;
import Modelo.Exceptions.*;
import Modelo.Edificios.*;
import Modelo.Posicion;

import java.util.ArrayList;

public class EstadoAldeanoOcupado implements IEstadoAldeano{

    Aldeano aldeano;

    public EstadoAldeanoOcupado(Aldeano aldeano){
        this.aldeano = aldeano;
    }

    @Override
    public PlazaCentral construirPlazaCentral(ArrayList<Posicion> posiciones){
        throw new UnidadNoPuedeConstruirException();
    }

    @Override
    public Cuartel construirCuartel(ArrayList<Posicion> posiciones){
        throw new UnidadNoPuedeConstruirException();
    }


    @Override
    public void repararEdificio(Edificio edificio) {
        throw new UnidadNoPuedeRepararException();
    }

    @Override
    public void continuarConstruccion(Edificio edificio){
        throw new UnidadNoPuedeConstruirException();
    }

    @Override
    public int generaOro(){
        return 0;
    }

    @Override
    public void mover(Posicion destino){
        throw new UnidadEstaOcupadoException();
    }
}

