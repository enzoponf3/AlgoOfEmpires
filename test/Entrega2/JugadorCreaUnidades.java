package Entrega2;

import Modelo.Edificios.Cuartel;
import Modelo.Edificios.PlazaCentral;
import Modelo.Exceptions.EdificioNoExisteException;
import Modelo.Exceptions.LimiteDePoblacionException;
import Modelo.Jugador;
import Modelo.Posicion;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class JugadorCreaUnidades {


    //Crear aldeanos

    @Test
    public void plazaCentralCreaUnAldeanoCorrectamente(){
        Jugador jugador = new Jugador(5, 14);
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

    @Test (expected = EdificioNoExisteException.class)
    public void plazaCentralQueNoEsDejJugadorNoPuedecrearAldeano(){
        Jugador jugador = new Jugador(5, 14);
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

    @Test
    public void plazaCentralCreaAldeanosHastaLlegarALimiteDePoblacion(){
        Jugador jugador = new Jugador(5, 14);
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
    public void plazaCentralNoPuedeCrearAldeanoSuperandoLimiteDePoblacion(){
        Jugador jugador = new Jugador(5, 14);
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

    //crear espadachin y arquero

    @Test
    public void cuartelCreaUnArqueroCorrectamente(){
        Jugador jugador = new Jugador(5, 14);

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
    public void cuartelQueNoEsDejJugadorNoPuedecrearArquero(){
        Jugador jugador = new Jugador(5, 14);

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
    public void cuartelCreaArquerosHastaLlegarALimiteDePoblacion(){
        Jugador jugador = new Jugador(5, 14);
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
    public void cuartelNoPuedeCrearArqueroSuperandoLimiteDePoblacion(){
        Jugador jugador = new Jugador(5, 14);
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
    public void cuartelCreaUnEspadachinCorrectamente(){
        Jugador jugador = new Jugador(5, 14);

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
    public void cuartelQueNoEsDejJugadorNoPuedecrearEspadachin(){
        Jugador jugador = new Jugador(5, 14);

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
    public void cuartelCreaEspadachinesHastaLlegarALimiteDePoblacion(){
        Jugador jugador = new Jugador(5, 14);
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
    public void cuartelNoPuedeCrearEspadachinSuperandoLimiteDePoblacion(){
        Jugador jugador = new Jugador(5, 14);
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
    public void castilloCreaArmaDeAsedioCorrectamente(){
        Jugador jugador = new Jugador(5, 14);

        jugador.crearArmaDeAsedio();

        Assert.assertEquals(1, jugador.getEjercito().size() );
    }

    @Test
    public void castilloCreaArmasDeAsedioHastaLlegarALimiteDePoblacion(){
        Jugador jugador = new Jugador(5, 14);

        for(int i=0; i<47; i++) {
            jugador.crearArmaDeAsedio();
        }

        Assert.assertEquals(47, jugador.getEjercito().size() );
    }

    @Test( expected = LimiteDePoblacionException.class)
    public void castilloCreaArmasDeAsedioSuperandoLimiteDePoblacion(){
        Jugador jugador = new Jugador(5, 14);

        for(int i=0; i<48; i++) {
            jugador.crearArmaDeAsedio();
        }
    }

}
