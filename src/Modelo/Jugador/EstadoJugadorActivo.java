package Modelo.Jugador;

import Modelo.Edificios.*;
import Modelo.Exceptions.UnidadEstaOcupadoException;
import Modelo.Mapa;
import Modelo.Posicion;
import Modelo.Unidades.*;
import View.Constantes;
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
    public void mover(Unidad unidad, Posicion destino, Mapa mapa, Jugador jugador) {
        Posicion origen = unidad.getPosicion();
        unidad.mover(destino);
        mapa.mover(origen,destino);
    }

    //CREAR UNIDADES

    @Override
    public void crearAldeano(Mapa mapa, PlazaCentral plazaCentral, Jugador jugador){
        verificacionesCreacion(jugador, plazaCentral);
        jugador.verificarOroSuficiente(Constantes.COSTO_ALDEANO);
        Aldeano aldeano = plazaCentral.crearAldeano(mapa);
        jugador.agregarAldeano(aldeano, mapa);
        jugador.reducirOro(Constantes.COSTO_ALDEANO);
    }

    @Override
    public void crearArquero(Mapa mapa, Cuartel cuartel, Jugador jugador){
        verificacionesCreacion(jugador, cuartel);
        jugador.verificarOroSuficiente(Constantes.COSTO_ARQUERO);
        Arquero arquero = cuartel.crearArquero(mapa);
        jugador.agregarAEjercito(arquero,mapa);
        jugador.reducirOro(Constantes.COSTO_ARQUERO);
    }

    @Override
    public void crearEspadachin(Mapa mapa, Cuartel cuartel, Jugador jugador){
        verificacionesCreacion(jugador, cuartel);
        jugador.verificarOroSuficiente(Constantes.COSTO_ESPADACHIN);
        Espadachin espadachin = cuartel.crearEspadachin(mapa);
        jugador.agregarAEjercito(espadachin, mapa);
        jugador.reducirOro(Constantes.COSTO_ESPADACHIN);
    }

    @Override
    public ArmaDeAsedio crearArmaDeAsedio(Mapa mapa, Castillo castillo, Jugador jugador){
        verificacionesCreacion(jugador, castillo);
        jugador.verificarOroSuficiente(Constantes.COSTO_ARMA_ASEDIO);
        ArmaDeAsedio armaDeAsedio = castillo.crearArmaDeAsedio(mapa);
        jugador.agregarAEjercito(armaDeAsedio, mapa);
        jugador.reducirOro(Constantes.COSTO_ARMA_ASEDIO);
        return armaDeAsedio;
    }


    //MONTAR Y DESMONTAR ARMA_DE_ASEDIO

    @Override
    public void montarArmaDeAsedio(ArmaDeAsedio armaDeAsedio, Jugador jugador){
        jugador.verificarAtacantePropio(armaDeAsedio);
        armaDeAsedio.montar();
    }

    @Override
    public void desmontarArmaDeAsedio(ArmaDeAsedio armaDeAsedio, Jugador jugador){
        jugador.verificarAtacantePropio(armaDeAsedio);
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
    public Cuartel construirCuartel(Jugador jugador, Mapa mapa, Aldeano aldeano, ArrayList<Posicion> posicionesCuartel){
        jugador.verificarAldeanoPropio(aldeano);
        mapa.verificarPosicionesAledanias(aldeano.getPosicion(),posicionesCuartel);
        jugador.verificarOroSuficiente(Constantes.COSTO_CUARTEL);
        Cuartel cuartel = aldeano.construirCuartel(posicionesCuartel);
        jugador.agregarEdificio(cuartel, mapa);
        jugador.reducirOro(Constantes.COSTO_CUARTEL);
        return cuartel;
    }

    @Override
    public void continuarConstruccionCuartel(Jugador jugador, Aldeano aldeano, Cuartel cuartel){
        verificacionesConstruccion(jugador,aldeano,cuartel);
        aldeano.continuarConstruccionCuartel(cuartel);
    }

    @Override
    public PlazaCentral construirPlazaCentral(Jugador jugador, Mapa mapa, Aldeano aldeano, ArrayList<Posicion> posicionesPlazaCentral){
        jugador.verificarAldeanoPropio(aldeano);
        mapa.verificarPosicionesAledanias(aldeano.getPosicion(),posicionesPlazaCentral);
        jugador.verificarOroSuficiente(Constantes.COSTO_PLAZA);
        PlazaCentral plaza = aldeano.construirPlazaCentral(posicionesPlazaCentral);
        jugador.reducirOro(Constantes.COSTO_PLAZA);
        jugador.agregarEdificio(plaza, mapa);
        return plaza;
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

    @Override
    public void cambiarTurno(Jugador jugador) {
        jugador.inactivar();
    }

}
