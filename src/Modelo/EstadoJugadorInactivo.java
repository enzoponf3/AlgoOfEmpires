package Modelo;

import Modelo.Exceptions.TurnoDelOponenteException;
import Modelo.Unidades.*;
import Modelo.Unidades.IUnidadMovible;
import Modelo.Edificios.*;

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
    public void atacar(IAtacante atacante, Unidad unidadAAtacar){
        throw new TurnoDelOponenteException();
    }

    @Override
    public void atacar(IAtacante atacante, Edificio edificioAAtacar){
        throw new TurnoDelOponenteException();
    }


}
