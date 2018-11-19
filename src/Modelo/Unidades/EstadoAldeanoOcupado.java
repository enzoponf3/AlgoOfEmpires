package Modelo.Unidades;
import Modelo.Edificios.Cuartel;
import Modelo.Edificios.PlazaCentral;
import Modelo.Exceptions.*;
import Modelo.Edificios.*;
import Modelo.Posicion;

import java.util.ArrayList;

public class EstadoAldeanoOcupado implements EstadoAldeano{

    @Override
    public PlazaCentral construirPlazaCentral(Aldeano aldeano, ArrayList<Posicion> posiciones){
        throw new UnidadNoPuedeConstruirException();
    }

    @Override
    public Cuartel construirCuartel(Aldeano aldeano, ArrayList<Posicion> posiciones){
        throw new UnidadNoPuedeConstruirException();
    }


    @Override
    public void repararEdificio(Edificio edificio, Aldeano aldeano) {
        throw new UnidadNoPuedeRepararException();
    }

    @Override
    public void continuarConstruccion(Edificio edificio, Aldeano aldeano){
        throw new UnidadNoPuedeConstruirException();
    }

    @Override
    public int generaOro(){
        return 0;
    }

    @Override
    public void mover(Posicion destino, Aldeano aldeano){
        throw new UnidadEstaOcupadoException();
    }
}

