package Entrega2;

import Modelo.Edificios.Cuartel;
import Modelo.Edificios.PlazaCentral;
import Modelo.Exceptions.EdificioNoExisteException;
import Modelo.Exceptions.LimiteDePoblacionException;
import Modelo.Exceptions.PosicionesAledaniasOcupadasException;
import Modelo.Exceptions.TurnoDelOponenteException;
import Modelo.Jugador.Jugador;
import Modelo.Mapa;
import Modelo.Posicion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class JugadorCreaUnidadesTest {

    private Jugador jugador;
    private Mapa mapa;

    @Before
    public void setUp() throws Exception {
        mapa = new Mapa(20,30);
        jugador = new Jugador(mapa,5, 14);
        jugador.activar();
    }

    //Crear aldeanos. Solo durante el turno activo.

    @Test
    public void plazaCentralCreaUnAldeanoCorrectamenteDuranteSuTurno(){
        Posicion posicion1PlazaCentral = new Posicion(3,2);
        Posicion posicion2PlazaCentral = new Posicion(3,1);
        Posicion posicion3PlazaCentral = new Posicion(4,2);
        Posicion posicion4PlazaCentral = new Posicion(4,1);
        ArrayList<Posicion> posicionesPlazaCentral = new ArrayList<>();
        posicionesPlazaCentral.add(posicion1PlazaCentral);
        posicionesPlazaCentral.add(posicion2PlazaCentral);
        posicionesPlazaCentral.add(posicion3PlazaCentral);
        posicionesPlazaCentral.add(posicion4PlazaCentral);
        PlazaCentral plazaCentral = new PlazaCentral(posicionesPlazaCentral);
        plazaCentral.finalizarConstruccion();

        jugador.agregarEdificio(plazaCentral);
        mapa.ocuparCasilleros(posicionesPlazaCentral,plazaCentral);
        jugador.crearAldeano(mapa,plazaCentral);

        Assert.assertEquals(4, jugador.getAldeanos().size() );

    }//Cuando tengamos lo de las posiciones agregarlo al Test

    @Test (expected = TurnoDelOponenteException.class)
    public void plazaCentralCreaUnAldeanoDuranteTurnoDelOponente(){
        jugador.inactivar();
        Posicion posicion1PlazaCentral = new Posicion(3,2);
        Posicion posicion2PlazaCentral = new Posicion(3,1);
        Posicion posicion3PlazaCentral = new Posicion(4,2);
        Posicion posicion4PlazaCentral = new Posicion(4,1);
        ArrayList<Posicion> posicionesPlazaCentral = new ArrayList<>();
        posicionesPlazaCentral.add(posicion1PlazaCentral);
        posicionesPlazaCentral.add(posicion2PlazaCentral);
        posicionesPlazaCentral.add(posicion3PlazaCentral);
        posicionesPlazaCentral.add(posicion4PlazaCentral);
        PlazaCentral plazaCentral = new PlazaCentral(posicionesPlazaCentral);
        plazaCentral.finalizarConstruccion();

        jugador.agregarEdificio(plazaCentral);
        mapa.ocuparCasilleros(posicionesPlazaCentral,plazaCentral);
        jugador.crearAldeano(mapa,plazaCentral);

        Assert.assertEquals(3, jugador.getAldeanos().size() );

    }

    @Test (expected = EdificioNoExisteException.class)
    public void plazaCentralQueNoEsDeJugadorNoPuedecrearAldeanoDuranteSuTurno(){
        Posicion posicion1PlazaCentral = new Posicion(3,2);
        Posicion posicion2PlazaCentral = new Posicion(3,1);
        Posicion posicion3PlazaCentral = new Posicion(4,2);
        Posicion posicion4PlazaCentral = new Posicion(4,1);
        ArrayList<Posicion> posicionesPlazaCentral = new ArrayList<>();
        posicionesPlazaCentral.add(posicion1PlazaCentral);
        posicionesPlazaCentral.add(posicion2PlazaCentral);
        posicionesPlazaCentral.add(posicion3PlazaCentral);
        posicionesPlazaCentral.add(posicion4PlazaCentral);
        PlazaCentral plazaCentral = new PlazaCentral(posicionesPlazaCentral);
        plazaCentral.finalizarConstruccion();

        jugador.crearAldeano(mapa, plazaCentral);
    }
/*
    @Test (expected = TurnoDelOponenteException.class)
    public void plazaCentralQueNoEsDejJugadorNoPuedecrearAldeanoDuranteTurnoOponente(){
        Jugador jugador = new Jugador(5, 14);
        jugador.inactivar();

        Posicion posicion1PlazaCentral = new Posicion(3,2);
        Posicion posicion2PlazaCentral = new Posicion(3,1);
        Posicion posicion3PlazaCentral = new Posicion(4,2);
        Posicion posicion4PlazaCentral = new Posicion(4,1);
        ArrayList<Posicion> posicionesPlazaCentral = new ArrayList<>();
        posicionesPlazaCentral.add(posicion1PlazaCentral);
        posicionesPlazaCentral.add(posicion2PlazaCentral);
        posicionesPlazaCentral.add(posicion3PlazaCentral);
        posicionesPlazaCentral.add(posicion4PlazaCentral);
        PlazaCentral plazaCentral = new PlazaCentral(posicionesPlazaCentral);
        plazaCentral.finalizarConstruccion();

        jugador.crearAldeano(plazaCentral);
    }
*/ //Cuestion de verificaciones, ver.

    @Test
    public void plazaCentralCreaAldeanosHastaLlegarALimiteDePoblacionDuranteSuTurno(){
        Posicion posicion1PlazaCentral = new Posicion(3,2);
        Posicion posicion2PlazaCentral = new Posicion(3,1);
        Posicion posicion3PlazaCentral = new Posicion(4,2);
        Posicion posicion4PlazaCentral = new Posicion(4,1);
        ArrayList<Posicion> posicionesPlazaCentral = new ArrayList<>();
        posicionesPlazaCentral.add(posicion1PlazaCentral);
        posicionesPlazaCentral.add(posicion2PlazaCentral);
        posicionesPlazaCentral.add(posicion3PlazaCentral);
        posicionesPlazaCentral.add(posicion4PlazaCentral);
        PlazaCentral plazaCentral = new PlazaCentral(posicionesPlazaCentral);
        plazaCentral.finalizarConstruccion();

        jugador.agregarEdificio(plazaCentral);
        mapa.ocuparCasilleros(posicionesPlazaCentral,plazaCentral);
        for(int i = 0; i<12; i++){
            jugador.crearAldeano(mapa, plazaCentral);
        }

        Assert.assertEquals(15, jugador.getAldeanos().size() );

    }

    @Test (expected = TurnoDelOponenteException.class)
    public void plazaCentralCreaAldeanosHastaLlegarALimitePosicionesLibresDuranteTurnoDelOponente(){
        jugador.inactivar();

        Posicion posicion1PlazaCentral = new Posicion(3,2);
        Posicion posicion2PlazaCentral = new Posicion(3,1);
        Posicion posicion3PlazaCentral = new Posicion(4,2);
        Posicion posicion4PlazaCentral = new Posicion(4,1);
        ArrayList<Posicion> posicionesPlazaCentral = new ArrayList<>();
        posicionesPlazaCentral.add(posicion1PlazaCentral);
        posicionesPlazaCentral.add(posicion2PlazaCentral);
        posicionesPlazaCentral.add(posicion3PlazaCentral);
        posicionesPlazaCentral.add(posicion4PlazaCentral);
        PlazaCentral plazaCentral = new PlazaCentral(posicionesPlazaCentral);
        plazaCentral.finalizarConstruccion();

        jugador.agregarEdificio(plazaCentral);
        mapa.ocuparCasilleros(posicionesPlazaCentral,plazaCentral);
        for(int i = 0; i<47; i++)
            jugador.crearAldeano(mapa,plazaCentral);
        Assert.assertEquals(50, jugador.getAldeanos().size() );

    }

    @Test (expected = PosicionesAledaniasOcupadasException.class)
    public void plazaCentralNoPuedeCrearAldeanoSuperandoLimitePosicionesLibresDuranteSuTurno(){
        Posicion posicion1PlazaCentral = new Posicion(3,2);
        Posicion posicion2PlazaCentral = new Posicion(3,1);
        Posicion posicion3PlazaCentral = new Posicion(4,2);
        Posicion posicion4PlazaCentral = new Posicion(4,1);
        ArrayList<Posicion> posicionesPlazaCentral = new ArrayList<>();
        posicionesPlazaCentral.add(posicion1PlazaCentral);
        posicionesPlazaCentral.add(posicion2PlazaCentral);
        posicionesPlazaCentral.add(posicion3PlazaCentral);
        posicionesPlazaCentral.add(posicion4PlazaCentral);
        PlazaCentral plazaCentral = new PlazaCentral(posicionesPlazaCentral);
        plazaCentral.finalizarConstruccion();

        jugador.agregarEdificio(plazaCentral);
        mapa.ocuparCasilleros(posicionesPlazaCentral,plazaCentral);
        // Plaza Central tiene 12 posiciones aldeanias libres
        for(int i = 0; i<13; i++)
            jugador.crearAldeano(mapa,plazaCentral);

        Assert.assertEquals(50, jugador.getAldeanos().size() );
    }
/*
    @Test (expected = PosicionesLibresException.class)
    public void plazaCentralNoPuedeCrearAldeanoSuperandoLimiteDePoblacionDuranteTurnoDelOponente(){
        Jugador jugador = new Jugador(5, 14);
        jugador.inactivar();

        Posicion posicion1PlazaCentral = new Posicion(3,2);
        Posicion posicion2PlazaCentral = new Posicion(3,1);
        Posicion posicion3PlazaCentral = new Posicion(4,2);
        Posicion posicion4PlazaCentral = new Posicion(4,1);
        ArrayList<Posicion> posicionesPlazaCentral = new ArrayList<>();
        posicionesPlazaCentral.add(posicion1PlazaCentral);
        posicionesPlazaCentral.add(posicion2PlazaCentral);
        posicionesPlazaCentral.add(posicion3PlazaCentral);
        posicionesPlazaCentral.add(posicion4PlazaCentral);
        PlazaCentral plazaCentral = new PlazaCentral(posicionesPlazaCentral);
        plazaCentral.finalizarConstruccion();

        jugador.agregarEdificio(plazaCentral);
        for(int i = 0; i<48; i++){
            jugador.crearAldeano(plazaCentral);
        }

        Assert.assertEquals(50, jugador.getAldeanos().size() );

    }
*/ //Mismo problema de verificacion

    //crear espadachin y arquero

    @Test
    public void cuartelCreaUnArqueroCorrectamenteDuranteSuTurno(){
        Posicion posicion1Cuartel = new Posicion(3,2);
        Posicion posicion2Cuartel = new Posicion(3,1);
        Posicion posicion3Cuartel = new Posicion(4,2);
        Posicion posicion4Cuartel = new Posicion(4,1);
        ArrayList<Posicion> posicionesCuartel = new ArrayList<>();
        posicionesCuartel.add(posicion1Cuartel);
        posicionesCuartel.add(posicion2Cuartel);
        posicionesCuartel.add(posicion3Cuartel);
        posicionesCuartel.add(posicion4Cuartel);
        Cuartel cuartel = new Cuartel(posicionesCuartel);
        cuartel.finalizarConstruccion();

        jugador.agregarEdificio(cuartel);
        mapa.ocuparCasilleros(posicionesCuartel,cuartel);
        jugador.crearArquero(mapa,cuartel);

        Assert.assertEquals(1, jugador.getEjercito().size() );
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void cuartelCreaUnArqueroDuranteTurnodelOponente(){
        jugador.inactivar();

        Posicion posicion1Cuartel = new Posicion(3,2);
        Posicion posicion2Cuartel = new Posicion(3,1);
        Posicion posicion3Cuartel = new Posicion(4,2);
        Posicion posicion4Cuartel = new Posicion(4,1);
        ArrayList<Posicion> posicionesCuartel = new ArrayList<>();
        posicionesCuartel.add(posicion1Cuartel);
        posicionesCuartel.add(posicion2Cuartel);
        posicionesCuartel.add(posicion3Cuartel);
        posicionesCuartel.add(posicion4Cuartel);
        Cuartel cuartel = new Cuartel(posicionesCuartel);
        cuartel.finalizarConstruccion();

        jugador.agregarEdificio(cuartel);
        mapa.ocuparCasilleros(posicionesCuartel,cuartel);
        jugador.crearArquero(mapa,cuartel);

        Assert.assertEquals(1, jugador.getEjercito().size() );
    }

    @Test (expected = EdificioNoExisteException.class)
    public void cuartelQueNoEsDejJugadorNoPuedecrearArqueroDuranteSuTurno(){
        Posicion posicion1Cuartel = new Posicion(3,2);
        Posicion posicion2Cuartel = new Posicion(3,1);
        Posicion posicion3Cuartel = new Posicion(4,2);
        Posicion posicion4Cuartel = new Posicion(4,1);
        ArrayList<Posicion> posicionesCuartel = new ArrayList<>();
        posicionesCuartel.add(posicion1Cuartel);
        posicionesCuartel.add(posicion2Cuartel);
        posicionesCuartel.add(posicion3Cuartel);
        posicionesCuartel.add(posicion4Cuartel);
        Cuartel cuartel = new Cuartel(posicionesCuartel);
        cuartel.finalizarConstruccion();
        mapa.ocuparCasilleros(posicionesCuartel,cuartel);
        jugador.crearArquero(mapa,cuartel);
    }

    @Test
    public void cuartelCreaArquerosHastaLlegarALimitePosicionesLibresDuranteSuTurno(){
        Posicion posicion1Cuartel = new Posicion(3,2);
        Posicion posicion2Cuartel = new Posicion(3,1);
        Posicion posicion3Cuartel = new Posicion(4,2);
        Posicion posicion4Cuartel = new Posicion(4,1);
        ArrayList<Posicion> posicionesCuartel = new ArrayList<>();
        posicionesCuartel.add(posicion1Cuartel);
        posicionesCuartel.add(posicion2Cuartel);
        posicionesCuartel.add(posicion3Cuartel);
        posicionesCuartel.add(posicion4Cuartel);
        Cuartel cuartel = new Cuartel(posicionesCuartel);
        cuartel.finalizarConstruccion();
        mapa.ocuparCasilleros(posicionesCuartel,cuartel);
        jugador.agregarEdificio(cuartel);
        // Cuartel tiene 12 posiciones aldeanias libres
        for(int i = 0; i<12; i++){
            jugador.crearArquero(mapa,cuartel);
        }

        Assert.assertEquals(12, jugador.getEjercito().size() );

    }

    @Test (expected = PosicionesAledaniasOcupadasException.class)
    public void cuartelNoPuedeCrearArqueroSuperandoLimitePosicionesLibresDuranteSuTurno(){
        Posicion posicion1Cuartel = new Posicion(3,2);
        Posicion posicion2Cuartel = new Posicion(3,1);
        Posicion posicion3Cuartel = new Posicion(4,2);
        Posicion posicion4Cuartel = new Posicion(4,1);
        ArrayList<Posicion> posicionesCuartel = new ArrayList<>();
        posicionesCuartel.add(posicion1Cuartel);
        posicionesCuartel.add(posicion2Cuartel);
        posicionesCuartel.add(posicion3Cuartel);
        posicionesCuartel.add(posicion4Cuartel);
        Cuartel cuartel = new Cuartel(posicionesCuartel);
        cuartel.finalizarConstruccion();
        mapa.ocuparCasilleros(posicionesCuartel,cuartel);
        jugador.agregarEdificio(cuartel);
        // Cuartel tiene 12 posiciones aldeanias libres
        for(int i = 0; i<13; i++)
            jugador.crearArquero(mapa,cuartel);
    }

    @Test
    public void cuartelCreaUnEspadachinCorrectamenteDuranteSuTurno(){
        Posicion posicion1Cuartel = new Posicion(3,2);
        Posicion posicion2Cuartel = new Posicion(3,1);
        Posicion posicion3Cuartel = new Posicion(4,2);
        Posicion posicion4Cuartel = new Posicion(4,1);
        ArrayList<Posicion> posicionesCuartel = new ArrayList<>();
        posicionesCuartel.add(posicion1Cuartel);
        posicionesCuartel.add(posicion2Cuartel);
        posicionesCuartel.add(posicion3Cuartel);
        posicionesCuartel.add(posicion4Cuartel);
        Cuartel cuartel = new Cuartel(posicionesCuartel);
        cuartel.finalizarConstruccion();
        jugador.agregarEdificio(cuartel);
        mapa.ocuparCasilleros(posicionesCuartel,cuartel);
        jugador.crearEspadachin(mapa,cuartel);
        Assert.assertEquals(1, jugador.getEjercito().size() );
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void cuartelCreaUnEspadachinDuranteTurnoDelOponente(){
        jugador.inactivar();
        Posicion posicion1Cuartel = new Posicion(3,2);
        Posicion posicion2Cuartel = new Posicion(3,1);
        Posicion posicion3Cuartel = new Posicion(4,2);
        Posicion posicion4Cuartel = new Posicion(4,1);
        ArrayList<Posicion> posicionesCuartel = new ArrayList<>();
        posicionesCuartel.add(posicion1Cuartel);
        posicionesCuartel.add(posicion2Cuartel);
        posicionesCuartel.add(posicion3Cuartel);
        posicionesCuartel.add(posicion4Cuartel);
        Cuartel cuartel = new Cuartel(posicionesCuartel);
        cuartel.finalizarConstruccion();
        jugador.agregarEdificio(cuartel);
        mapa.ocuparCasilleros(posicionesCuartel,cuartel);
        jugador.crearEspadachin(mapa,cuartel);
        Assert.assertEquals(1, jugador.getEjercito().size() );
    }

    @Test (expected = EdificioNoExisteException.class)
    public void cuartelQueNoEsDejJugadorNoPuedecrearEspadachinDuranteSuTurno(){
        Posicion posicion1Cuartel = new Posicion(3,2);
        Posicion posicion2Cuartel = new Posicion(3,1);
        Posicion posicion3Cuartel = new Posicion(4,2);
        Posicion posicion4Cuartel = new Posicion(4,1);
        ArrayList<Posicion> posicionesCuartel = new ArrayList<>();
        posicionesCuartel.add(posicion1Cuartel);
        posicionesCuartel.add(posicion2Cuartel);
        posicionesCuartel.add(posicion3Cuartel);
        posicionesCuartel.add(posicion4Cuartel);
        Cuartel cuartel = new Cuartel(posicionesCuartel);
        cuartel.finalizarConstruccion();
        mapa.ocuparCasilleros(posicionesCuartel,cuartel);
        jugador.crearEspadachin(mapa, cuartel);
    }

    @Test
    public void cuartelCreaEspadachinesHastaLlegarALimitePosicionesLibresDuranteSuTurno(){
        Posicion posicion1Cuartel = new Posicion(3,2);
        Posicion posicion2Cuartel = new Posicion(3,1);
        Posicion posicion3Cuartel = new Posicion(4,2);
        Posicion posicion4Cuartel = new Posicion(4,1);
        ArrayList<Posicion> posicionesCuartel = new ArrayList<>();
        posicionesCuartel.add(posicion1Cuartel);
        posicionesCuartel.add(posicion2Cuartel);
        posicionesCuartel.add(posicion3Cuartel);
        posicionesCuartel.add(posicion4Cuartel);
        Cuartel cuartel = new Cuartel(posicionesCuartel);
        cuartel.finalizarConstruccion();
        jugador.agregarEdificio(cuartel);
        mapa.ocuparCasilleros(posicionesCuartel,cuartel);
        for(int i = 0; i<12; i++)
            jugador.crearEspadachin(mapa,cuartel);
        Assert.assertEquals(12, jugador.getEjercito().size() );

    }

    @Test (expected = PosicionesAledaniasOcupadasException.class)
    public void cuartelNoPuedeCrearEspadachinSuperandoLimitePosicionesLibresnDuranteSuTurno(){
        Posicion posicion1Cuartel = new Posicion(3,2);
        Posicion posicion2Cuartel = new Posicion(3,1);
        Posicion posicion3Cuartel = new Posicion(4,2);
        Posicion posicion4Cuartel = new Posicion(4,1);
        ArrayList<Posicion> posicionesCuartel = new ArrayList<>();
        posicionesCuartel.add(posicion1Cuartel);
        posicionesCuartel.add(posicion2Cuartel);
        posicionesCuartel.add(posicion3Cuartel);
        posicionesCuartel.add(posicion4Cuartel);
        Cuartel cuartel = new Cuartel(posicionesCuartel);
        cuartel.finalizarConstruccion();
        jugador.agregarEdificio(cuartel);
        mapa.ocuparCasilleros(posicionesCuartel,cuartel);
        // Cuartel tiene 12 posiciones aldeanias libres
        for(int i = 0; i<13; i++){
            jugador.crearEspadachin(mapa,cuartel);
        }

    }

    //Castillo crea ArmaDeAsedio

    @Test
    public void castilloCreaArmaDeAsedioCorrectamenteDuranteSuTurno(){
        jugador.crearArmaDeAsedio(mapa);
        Assert.assertEquals(1, jugador.getEjercito().size() );
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void castilloCreaArmaDeAsedioDuranteSuTurnoDelOponente(){
        jugador.inactivar();
        jugador.crearArmaDeAsedio(mapa);
        Assert.assertEquals(1, jugador.getEjercito().size() );
    }

    @Test
    public void castilloCreaArmasDeAsedioHastaLlegarALimitePosicionesLibresDuranteSuTurno(){
        for(int i=0; i<20; i++)
            jugador.crearArmaDeAsedio(mapa);
        Assert.assertEquals(20, jugador.getEjercito().size() );
    }

    @Test( expected = PosicionesAledaniasOcupadasException.class)
    public void castilloCreaArmasDeAsedioSuperandoLimitePosicionesLibresDuranteSuTurno(){
        // Castillo tiene 20 posiciones aledanias libres
        for(int i=0; i < 21; i++)
            jugador.crearArmaDeAsedio(mapa);
    }

}
