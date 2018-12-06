package Modelo.Jugador;

import Modelo.Exceptions.TurnoDelOponenteException;
import Modelo.Mapa;
import Modelo.Posicion;
import Modelo.Unidades.*;
import Modelo.Edificios.*;

import java.util.ArrayList;

public class EstadoJugadorInactivo implements IEstadoJugador {


    @Override
    public void mover(Unidad unidad, Posicion destino, Mapa mapa, Jugador jugador){
        throw new TurnoDelOponenteException();
    }

    @Override
    public Aldeano crearAldeano(Mapa mapa, PlazaCentral plazaCentral, Jugador jugador){
        throw new TurnoDelOponenteException();
    }

    @Override
    public Arquero crearArquero(Mapa mapa, Cuartel cuartel, Jugador jugador){
        throw new TurnoDelOponenteException();
    }

    @Override
    public Espadachin crearEspadachin(Mapa mapa, Cuartel cuartel, Jugador jugador){
        throw new TurnoDelOponenteException();
    }

    @Override
    public ArmaDeAsedio crearArmaDeAsedio(Mapa mapa, Castillo castillo, Jugador jugador){
        throw new TurnoDelOponenteException();
    }

    @Override
    public void montarArmaDeAsedio(ArmaDeAsedio armaDeAsedio, Jugador jugador){
        throw new TurnoDelOponenteException();
    }

    @Override
    public void desmontarArmaDeAsedio(ArmaDeAsedio armaDeAsedio, Jugador jugador){
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
    public Cuartel construirCuartel(Jugador jugador, Mapa mapa, Aldeano aldeano, ArrayList<Posicion> posicionesCuartel){
        throw new TurnoDelOponenteException();
    }

    @Override
    public void continuarConstruccionCuartel(Jugador jugador, Mapa mapa, Aldeano aldeano, Cuartel cuartel){
        throw new TurnoDelOponenteException();
    }

    @Override
    public PlazaCentral construirPlazaCentral(Jugador jugador, Mapa mapa, Aldeano aldeano, ArrayList<Posicion> posicionesPlazaCentral){
        throw new TurnoDelOponenteException();
    }

    @Override
    public void continuarConstruccionPlazaCentral(Jugador jugador, Mapa mapa, Aldeano aldeano, PlazaCentral plazaCentral){
        throw new TurnoDelOponenteException();
    }

    @Override
    public void reparar(Jugador jugador, Aldeano aldeano, Edificio edificio){
        throw new TurnoDelOponenteException();
    }

    @Override
    public int recolectarOro(Jugador jugador){
        int oroExtra = 0;
        for( Aldeano aldeano : jugador.getAldeanos()){
            oroExtra += aldeano.generaOro();
        }
        return oroExtra;
    }

    @Override
    public void cambiarTurno(Jugador jugador) {
        Mapa mapa = Mapa.getInstancia();
        jugador.activar();
        jugador.limpiarEntidadesMuertas(mapa);
        jugador.desocuparUnidades();
        jugador.desocuparEdificios();
    }
}
