package Entrega2;

import Modelo.Edificios.Cuartel;
import Modelo.Edificios.PlazaCentral;
import Modelo.Exceptions.EdificioNoExisteException;
import Modelo.Exceptions.LimiteDePoblacionException;
import Modelo.Exceptions.TurnoDelOponenteException;
import Modelo.Jugador.Jugador;
import Modelo.Posicion;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class JugadorCreaUnidadesTest {


    //Crear aldeanos. Solo durante el turno activo.

    @Test
    public void plazaCentralCreaUnAldeanoCorrectamenteDuranteSuTurno(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

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
        jugador.crearAldeano(plazaCentral);

        Assert.assertEquals(4, jugador.getAldeanos().size() );

    }//Cuando tengamos lo de las posiciones agregarlo al Test

    @Test (expected = TurnoDelOponenteException.class)
    public void plazaCentralCreaUnAldeanoDuranteTurnoDelOponente(){
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
        jugador.crearAldeano(plazaCentral);

        Assert.assertEquals(3, jugador.getAldeanos().size() );

    }

    @Test (expected = EdificioNoExisteException.class)
    public void plazaCentralQueNoEsDeJugadorNoPuedecrearAldeanoDuranteSuTurno(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

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
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

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
        for(int i = 0; i<47; i++){
            jugador.crearAldeano(plazaCentral);
        }

        Assert.assertEquals(50, jugador.getAldeanos().size() );

    }

    @Test (expected = TurnoDelOponenteException.class)
    public void plazaCentralCreaAldeanosHastaLlegarALimiteDePoblacionDuranteTurnoDelOponente(){
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
        for(int i = 0; i<47; i++){
            jugador.crearAldeano(plazaCentral);
        }

        Assert.assertEquals(50, jugador.getAldeanos().size() );

    }

    @Test (expected = LimiteDePoblacionException.class)
    public void plazaCentralNoPuedeCrearAldeanoSuperandoLimiteDePoblacionDuranteSuTurno(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

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
/*
    @Test (expected = LimiteDePoblacionException.class)
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
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

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
        jugador.crearArquero(cuartel);

        Assert.assertEquals(1, jugador.getEjercito().size() );

    }

    @Test (expected = TurnoDelOponenteException.class)
    public void cuartelCreaUnArqueroDuranteTurnodelOponente(){
        Jugador jugador = new Jugador(5, 14);
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
        jugador.crearArquero(cuartel);

        Assert.assertEquals(1, jugador.getEjercito().size() );

    }

    @Test (expected = EdificioNoExisteException.class)
    public void cuartelQueNoEsDejJugadorNoPuedecrearArqueroDuranteSuTurno(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

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

        jugador.crearArquero(cuartel);
    }

    @Test
    public void cuartelCreaArquerosHastaLlegarALimiteDePoblacionDuranteSuTurno(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

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
        for(int i = 0; i<47; i++){
            jugador.crearArquero(cuartel);
        }

        Assert.assertEquals(47, jugador.getEjercito().size() );

    }

    @Test (expected = LimiteDePoblacionException.class)
    public void cuartelNoPuedeCrearArqueroSuperandoLimiteDePoblacionDuranteSuTurno(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

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
        for(int i = 0; i<48; i++){
            jugador.crearArquero(cuartel);
        }

    }

    @Test
    public void cuartelCreaUnEspadachinCorrectamenteDuranteSuTurno(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

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
        jugador.crearEspadachin(cuartel);

        Assert.assertEquals(1, jugador.getEjercito().size() );

    }

    @Test (expected = TurnoDelOponenteException.class)
    public void cuartelCreaUnEspadachinDuranteTurnoDelOponente(){
        Jugador jugador = new Jugador(5, 14);
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
        jugador.crearEspadachin(cuartel);

        Assert.assertEquals(1, jugador.getEjercito().size() );

    }

    @Test (expected = EdificioNoExisteException.class)
    public void cuartelQueNoEsDejJugadorNoPuedecrearEspadachinDuranteSuTurno(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

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

        jugador.crearEspadachin(cuartel);
    }

    @Test
    public void cuartelCreaEspadachinesHastaLlegarALimiteDePoblacionDuranteSuTurno(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

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
        for(int i = 0; i<47; i++){
            jugador.crearEspadachin(cuartel);
        }

        Assert.assertEquals(47, jugador.getEjercito().size() );

    }

    @Test (expected = LimiteDePoblacionException.class)
    public void cuartelNoPuedeCrearEspadachinSuperandoLimiteDePoblacionDuranteSuTurno(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

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
        for(int i = 0; i<48; i++){
            jugador.crearEspadachin(cuartel);
        }

    }

    //Castillo crea ArmaDeAsedio

    @Test
    public void castilloCreaArmaDeAsedioCorrectamenteDuranteSuTurno(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

        jugador.crearArmaDeAsedio();

        Assert.assertEquals(1, jugador.getEjercito().size() );
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void castilloCreaArmaDeAsedioDuranteSuTurnoDelOponente(){
        Jugador jugador = new Jugador(5, 14);
        jugador.inactivar();

        jugador.crearArmaDeAsedio();

        Assert.assertEquals(1, jugador.getEjercito().size() );
    }

    @Test
    public void castilloCreaArmasDeAsedioHastaLlegarALimiteDePoblacionDuranteSuTurno(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

        for(int i=0; i<47; i++) {
            jugador.crearArmaDeAsedio();
        }

        Assert.assertEquals(47, jugador.getEjercito().size() );
    }

    @Test( expected = LimiteDePoblacionException.class)
    public void castilloCreaArmasDeAsedioSuperandoLimiteDePoblacionDuranteSuTurno(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

        for(int i=0; i<48; i++) {
            jugador.crearArmaDeAsedio();
        }
    }

}
