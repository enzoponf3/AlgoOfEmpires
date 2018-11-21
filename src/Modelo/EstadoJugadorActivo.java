package Modelo;

import Modelo.Edificios.*;
import Modelo.Unidades.*;

public class EstadoJugadorActivo implements IEstadoJugador {

    //MOVER

    @Override
    public void mover( IUnidadMovible unidad, Posicion origen, Posicion destino, Jugador jugador ){
        unidad.mover(destino);
    }//Tengo que inactivar desp? refactorizar


    //CREAR UNIDADES

    @Override
    public void crearAldeano(PlazaCentral plazaCentral, Jugador jugador){
        Aldeano aldeano = plazaCentral.crearAldeano();
        jugador.agregarAldeano(aldeano);
    }

    @Override
    public void crearArquero(Cuartel cuartel, Jugador jugador){
        Arquero arquero = cuartel.crearArquero();
        jugador.agregarAEjercito(arquero);
    } //Lo hace desde aca o se lo devuelve y el jug lo agrega? Que es mejor?

    @Override
    public void crearEspadachin(Cuartel cuartel, Jugador jugador){
        Espadachin espadachin = cuartel.crearEspadachin();
        jugador.agregarAEjercito(espadachin);
    }

    @Override
    public void crearArmaDeAsedio(Castillo castillo, Jugador jugador){
        ArmaDeAsedio armaDeAsedio = castillo.crearArmaDeAsedio();
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
    public void atacar(IAtacante atacante, Unidad unidadAAtacar){
        atacante.atacar(unidadAAtacar);
    }

    @Override
    public void atacar(IAtacante atacante, Edificio edificioAAtacar){
        atacante.atacar(edificioAAtacar);
    }

}
