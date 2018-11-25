package Modelo.Jugador;

import Modelo.Edificios.*;
import Modelo.Mapa;
import Modelo.Posicion;
import Modelo.Unidades.*;

import java.util.ArrayList;

public class EstadoJugadorActivo implements IEstadoJugador {

    private void verificacionesCreacion(Jugador jugador, Edificio edificio){
        jugador.verificarEdificioPropio(edificio);
        jugador.verificarLimitePoblacion();
    }

    private void verificacionesConstruccion(Jugador jugador, Aldeano aldeano, Edificio edificio) {
        jugador.verificarAldeanoPropio(aldeano);
        jugador.verificarEdificioPropio(edificio);
    }

    //MOVER

    @Override
    public void mover(IUnidadMovible unidad, Posicion origen, Posicion destino, Jugador jugador ){
        unidad.mover(destino);
    }//Tengo que inactivar desp? refactorizar


    //CREAR UNIDADES

    @Override
    public void crearAldeano(Mapa mapa, PlazaCentral plazaCentral, Jugador jugador){
        verificacionesCreacion(jugador, plazaCentral);
        Aldeano aldeano = plazaCentral.crearAldeano(mapa);
        jugador.agregarAldeano(aldeano);
    }

    @Override
    public void crearArquero(Mapa mapa, Cuartel cuartel, Jugador jugador){
        verificacionesCreacion(jugador, cuartel);
        Arquero arquero = cuartel.crearArquero(mapa);
        jugador.agregarAEjercito(arquero);
    }

    @Override
    public void crearEspadachin(Mapa mapa, Cuartel cuartel, Jugador jugador){
        verificacionesCreacion(jugador, cuartel);
        Espadachin espadachin = cuartel.crearEspadachin(mapa);
        jugador.agregarAEjercito(espadachin);
    }

    @Override
    public void crearArmaDeAsedio(Mapa mapa, Castillo castillo, Jugador jugador){
        jugador.verificarLimitePoblacion();
        ArmaDeAsedio armaDeAsedio = castillo.crearArmaDeAsedio(mapa);
        jugador.agregarAEjercito(armaDeAsedio);
    }


    //MONTAR Y DESMONTAR ARMA_DE_ASEDIO

    @Override
    public void montarArmaDeAsedio(ArmaDeAsedio armaDeAsedio){
        armaDeAsedio.montar();
    }

    @Override
    public void desmontarArmaDeAsedio(ArmaDeAsedio armaDeAsedio){
        armaDeAsedio.desmontar();
    }

    //ATACAR

    @Override
    public void atacar(Jugador jugador, IAtacante atacante, Unidad unidadAAtacar){
        jugador.verificarAtacantePropio(atacante);
        jugador.verificarUnidadEnemiga(unidadAAtacar);
        atacante.atacar(unidadAAtacar);
    }

    @Override
    public void atacar(Jugador jugador, IAtacante atacante, Edificio edificioAAtacar){
        jugador.verificarAtacantePropio(atacante);
        jugador.verificarEdificioEnemigo(edificioAAtacar);
        atacante.atacar(edificioAAtacar);
    }

    //CONSTRUIR
    @Override
    public Cuartel construirCuartel(Jugador jugador, Aldeano aldeano, ArrayList<Posicion> posicionesCuartel){
        jugador.verificarAldeanoPropio(aldeano);
        return aldeano.construirCuartel(posicionesCuartel);
    }

    @Override
    public void continuarConstruccionCuartel(Jugador jugador, Aldeano aldeano, Cuartel cuartel){
        verificacionesConstruccion(jugador,aldeano,cuartel);
        aldeano.continuarConstruccionCuartel(cuartel);
    }

    @Override
    public PlazaCentral construirPlazaCentral(Jugador jugador, Aldeano aldeano, ArrayList<Posicion> posicionesPlazaCentral){
        jugador.verificarAldeanoPropio(aldeano);
        return aldeano.construirPlazaCentral(posicionesPlazaCentral);
    }

    @Override
    public void continuarConstruccionPlazaCentral(Jugador jugador, Aldeano aldeano, PlazaCentral plazaCentral){
        verificacionesConstruccion(jugador,aldeano,plazaCentral);
        aldeano.continuarConstruccionPlazaCentral(plazaCentral);
    }

    @Override
    public void reparar(Jugador jugador, Aldeano aldeano, Edificio edificio){
        verificacionesConstruccion(jugador,aldeano,edificio);
        aldeano.repararEdificio(edificio);
    }

    @Override
    public int recolectarOro(Jugador jugador){
        int oroExtra = 0;
        for( Aldeano aldeano : jugador.getAldeanos()){
            oroExtra += aldeano.generaOro();
        }
        return oroExtra;
    }

}
