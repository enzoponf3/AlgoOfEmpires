package Modelo.Jugador;

import Modelo.Exceptions.TurnoDelOponenteException;
import Modelo.Posicion;
import Modelo.Unidades.*;
import Modelo.Unidades.IUnidadMovible;
import Modelo.Edificios.*;

import java.util.ArrayList;

public class EstadoJugadorInactivo implements IEstadoJugador {


    @Override
    public void mover(IUnidadMovible unidad, Posicion origen, Posicion destino, Jugador jugador){
        throw new TurnoDelOponenteException();
    }

    @Override
    public void crearAldeano(PlazaCentral plazaCentral, Jugador jugador){
        throw new TurnoDelOponenteException();
    }

    @Override
    public void crearArquero(Cuartel cuartel, Jugador jugador){
        throw new TurnoDelOponenteException();
    }

    @Override
    public void crearEspadachin(Cuartel cuartel, Jugador jugador){
        throw new TurnoDelOponenteException();
    }

    @Override
    public void crearArmaDeAsedio(Castillo castillo, Jugador jugador){
        throw new TurnoDelOponenteException();
    }

    @Override
    public void montarArmaDeAsedio(ArmaDeAsedio armaDeAsedio){
        throw new TurnoDelOponenteException();
    }

    @Override
    public void desmontarArmaDeAsedio(ArmaDeAsedio armaDeAsedio){
        throw new TurnoDelOponenteException();
    }

    @Override
    public void atacar(Jugador jugador, IAtacante atacante, Unidad unidadAAtacar){
        throw new TurnoDelOponenteException();
    }

    @Override
    public void atacar(Jugador jugador, IAtacante atacante, Edificio edificioAAtacar){
        throw new TurnoDelOponenteException();
    }

    @Override
    public Cuartel construirCuartel(Aldeano aldeano, ArrayList<Posicion> posicionesCuartel){
        throw new TurnoDelOponenteException();
    }

    @Override
    public void continuarConstruccionCuartel(Aldeano aldeano, Cuartel cuartel){
        throw new TurnoDelOponenteException();
    }

    @Override
    public PlazaCentral construirPlazaCentral(Aldeano aldeano, ArrayList<Posicion> posicionesPlazaCentral){
        throw new TurnoDelOponenteException();
    }

    @Override
    public void continuarConstruccionPlazaCentral(Aldeano aldeano, PlazaCentral plazaCentral){
        throw new TurnoDelOponenteException();
    }

    @Override
    public void reparar(Aldeano aldeano, Edificio edificio){
        throw new TurnoDelOponenteException();
    }

    @Override
    public int recolectarOro(Jugador jugador){return 0;} //return 0 o exception?
}