package Entrega2;

import Modelo.Edificios.Castillo;
import Modelo.Edificios.Cuartel;
import Modelo.Edificios.Edificio;
import Modelo.Edificios.PlazaCentral;
import Modelo.Exceptions.*;
import Modelo.Jugador.Jugador;
import Modelo.Mapa;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class JugadorCreaUnidadesTest {

    private Jugador jugador;
    private Mapa mapa;
    private Castillo castillo;

    @Before
    public void setUp() throws Exception {
        mapa = new Mapa(20,30);
        jugador = new Jugador(mapa,5, 14);
        jugador.activar();
        castillo = jugador.getCastillo();
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

        jugador.agregarEdificio(plazaCentral,mapa);
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

        jugador.agregarEdificio(plazaCentral,mapa);
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

    @Test (expected = TurnoDelOponenteException.class)
    public void plazaCentralQueNoEsDejJugadorNoPuedecrearAldeanoDuranteTurnoOponente(){
        Jugador jugador2 = new Jugador(mapa,10, 16);
        jugador2.inactivar();

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
        jugador2.agregarEdificio(plazaCentral,mapa);

        jugador2.crearAldeano(mapa,plazaCentral);
    }


/*    @Test
    public void plazaCentralCreaAldeanosHastaLlegarALimiteDePoblacionDuranteSuTurno(){          //Ver test, no hay suficientes aledanios
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

        jugador.agregarEdificio(plazaCentral,mapa);
        for(int i = 0; i<12; i++){
            jugador.crearAldeano(mapa, plazaCentral);
        }

        Assert.assertEquals(15, jugador.getAldeanos().size() );

    }*/

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

        jugador.agregarEdificio(plazaCentral,mapa);
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

        jugador.agregarEdificio(plazaCentral,mapa);
        // Plaza Central tiene 12 posiciones aldeanias libres
        for(int i = 0; i<13; i++) {
            jugador.recolectarOro(); //Aumento oro para que siempre sea suficiente
            jugador.crearAldeano(mapa, plazaCentral);
        }
        Assert.assertEquals(50, jugador.getAldeanos().size() );
    }

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

        jugador.agregarEdificio(cuartel,mapa);
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

        jugador.agregarEdificio(cuartel,mapa);
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
        Posicion posicion1Cuartel = new Posicion(1,2);
        Posicion posicion2Cuartel = new Posicion(1,1);
        Posicion posicion3Cuartel = new Posicion(2,1);
        Posicion posicion4Cuartel = new Posicion(2,2);
        ArrayList<Posicion> posicionesCuartel = new ArrayList<>();
        posicionesCuartel.add(posicion1Cuartel);
        posicionesCuartel.add(posicion2Cuartel);
        posicionesCuartel.add(posicion3Cuartel);
        posicionesCuartel.add(posicion4Cuartel);
        Cuartel cuartel = new Cuartel(posicionesCuartel);
        cuartel.finalizarConstruccion();
        jugador.agregarEdificio(cuartel,mapa);
        // Cuartel tiene 12 posiciones aldeanias libres
        for(int i = 0; i<12; i++){
            jugador.recolectarOro();
            jugador.recolectarOro();
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
        jugador.agregarEdificio(cuartel,mapa);
        // Cuartel tiene 12 posiciones aldeanias libres
        for(int i = 0; i<13; i++) {
            jugador.recolectarOro();
            jugador.recolectarOro();
            jugador.crearArquero(mapa, cuartel);
        }
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
        jugador.agregarEdificio(cuartel,mapa);
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
        jugador.agregarEdificio(cuartel,mapa);
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
        Posicion posicion1Cuartel = new Posicion(1,1);
        Posicion posicion2Cuartel = new Posicion(1,2);
        Posicion posicion3Cuartel = new Posicion(2,2);
        Posicion posicion4Cuartel = new Posicion(2,1);
        ArrayList<Posicion> posicionesCuartel = new ArrayList<>();
        posicionesCuartel.add(posicion1Cuartel);
        posicionesCuartel.add(posicion2Cuartel);
        posicionesCuartel.add(posicion3Cuartel);
        posicionesCuartel.add(posicion4Cuartel);
        Cuartel cuartel = new Cuartel(posicionesCuartel);
        cuartel.finalizarConstruccion();
        jugador.agregarEdificio(cuartel,mapa);
        for(int i = 0; i<12; i++) {
            jugador.recolectarOro();
            jugador.crearEspadachin(mapa, cuartel);
        }
        Assert.assertEquals(12, jugador.getEjercito().size() );

    }

    @Test (expected = PosicionesAledaniasOcupadasException.class)
    public void cuartelNoPuedeCrearEspadachinSuperandoLimitePosicionesLibresnDuranteSuTurno(){
        Posicion posicion1Cuartel = new Posicion(1,1);
        Posicion posicion2Cuartel = new Posicion(1,2);
        Posicion posicion3Cuartel = new Posicion(2,2);
        Posicion posicion4Cuartel = new Posicion(2,1);
        ArrayList<Posicion> posicionesCuartel = new ArrayList<>();
        posicionesCuartel.add(posicion1Cuartel);
        posicionesCuartel.add(posicion2Cuartel);
        posicionesCuartel.add(posicion3Cuartel);
        posicionesCuartel.add(posicion4Cuartel);
        Cuartel cuartel = new Cuartel(posicionesCuartel);
        cuartel.finalizarConstruccion();
        jugador.agregarEdificio(cuartel,mapa);
        // Cuartel tiene 12 posiciones aldeanias libres
        for(int i = 0; i<13; i++){
            jugador.recolectarOro();
            jugador.crearEspadachin(mapa,cuartel);
        }

    }

    //Castillo crea ArmaDeAsedio

    @Test
    public void castilloCreaArmaDeAsedioCorrectamenteDuranteSuTurnoConCastilloPropio(){
        jugador.recolectarOro();
        jugador.recolectarOro();
        jugador.crearArmaDeAsedio(mapa,castillo);
        Assert.assertEquals(1, jugador.getEjercito().size() );
    }

    @Test (expected = EdificioNoExisteException.class)
    public void castilloCreaArmaDeAsedioCorrectamenteDuranteSuTurnoConCastilloAjeno(){
        Posicion posicion1 = new Posicion(6, 1);
        Posicion posicion2 = new Posicion(6, 2);
        Posicion posicion3 = new Posicion(6, 3);
        Posicion posicion4 = new Posicion(6, 4);
        Posicion posicion5 = new Posicion(7, 1);
        Posicion posicion6 = new Posicion(7, 2);
        Posicion posicion7 = new Posicion(7, 3);
        Posicion posicion8 = new Posicion(7, 4);
        Posicion posicion9 = new Posicion(8, 1);
        Posicion posicion10 = new Posicion(8, 2);
        Posicion posicion11 = new Posicion(8, 3);
        Posicion posicion12 = new Posicion(8, 4);
        Posicion posicion13 = new Posicion(9, 1);
        Posicion posicion14 = new Posicion(9, 2);
        Posicion posicion15 = new Posicion(9, 3);
        Posicion posicion16 = new Posicion(9, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        posiciones.add(posicion5);
        posiciones.add(posicion6);
        posiciones.add(posicion7);
        posiciones.add(posicion8);
        posiciones.add(posicion9);
        posiciones.add(posicion10);
        posiciones.add(posicion11);
        posiciones.add(posicion12);
        posiciones.add(posicion13);
        posiciones.add(posicion14);
        posiciones.add(posicion15);
        posiciones.add(posicion16);
        Castillo castilloAjeno = new Castillo(posiciones);
        jugador.crearArmaDeAsedio(mapa,castilloAjeno);
    }


    @Test (expected = TurnoDelOponenteException.class)
    public void castilloCreaArmaDeAsedioDuranteTurnoDelOponente(){
        jugador.inactivar();
        jugador.crearArmaDeAsedio(mapa,castillo);
        Assert.assertEquals(1, jugador.getEjercito().size() );
    }

    @Test
    public void castilloCreaArmasDeAsedioHastaLlegarALimitePosicionesLibresDuranteSuTurno(){
        for(int i=0; i<20; i++) {
            jugador.recolectarOro();
            jugador.recolectarOro();
            jugador.recolectarOro();
            jugador.recolectarOro();
            jugador.crearArmaDeAsedio(mapa, castillo);
        }
        Assert.assertEquals(20, jugador.getEjercito().size() );
    }

    @Test( expected = PosicionesAledaniasOcupadasException.class)
    public void castilloCreaArmasDeAsedioSuperandoLimitePosicionesLibresDuranteSuTurno(){
        // Castillo tiene 20 posiciones aledanias libres
        for(int i=0; i < 21; i++) {
            jugador.recolectarOro();
            jugador.recolectarOro();
            jugador.recolectarOro();
            jugador.recolectarOro();
            jugador.crearArmaDeAsedio(mapa, castillo);
        }
    }

    @Test
    public void crearUnidadConOroSuficiente() {
//        Inicialmente solo esta la plaza
        PlazaCentral plaza = (PlazaCentral) jugador.getEdificios().get(0);
        jugador.crearAldeano(mapa,plaza);
        Assert.assertEquals(jugador.getCantidadOro(),75);
    }


    @Test (expected = OroInsuficienteException.class)
    public void crearUnidadConOroInsuficiente() {
//        Inicialmente solo esta la plaza
        PlazaCentral plaza = (PlazaCentral) jugador.getEdificios().get(0);
        jugador.reducirOro(100);
        jugador.crearAldeano(mapa,plaza);
    }


}
