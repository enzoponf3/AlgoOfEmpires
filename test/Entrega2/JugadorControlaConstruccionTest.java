package Entrega2;

import Modelo.Exceptions.UnidadNoPuedeConstruirException;
import Modelo.Jugador;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class JugadorControlaConstruccionTest {


    //Mandar a un aldeano a construir un edificio

    @Test
    public void aldeanoConstruyeUnaPlazaCentralCorrectamente(){
        Jugador jugador = new Jugador();
        Posicion posicionAldeano = new Posicion(2,2);
        Posicion posicion1PlazaCentral = new Posicion(3,2);
        Posicion posicion2PlazaCentral = new Posicion(3,1);
        Posicion posicion3PlazaCentral = new Posicion(4,2);
        Posicion posicion4PlazaCentral = new Posicion(4,1);
        ArrayList<Posicion> posicionesPlazaCentral = new ArrayList<>();
        posicionesPlazaCentral.add(posicion1PlazaCentral);
        posicionesPlazaCentral.add(posicion2PlazaCentral);
        posicionesPlazaCentral.add(posicion3PlazaCentral);
        posicionesPlazaCentral.add(posicion4PlazaCentral);

        jugador.construirPlazaCentral(posicionAldeano, posicionesPlazaCentral);

        Assert.assertEquals(2, jugador.getEdificios().size() );

    }

    @Test
    public void aldeanoContinuaConstruccionDeUnaPlazaCentralCorrectamente(){
        Jugador jugador = new Jugador();
        Posicion posicionAldeano = new Posicion(2,2);
        Posicion posicion1PlazaCentral = new Posicion(3,2);
        Posicion posicion2PlazaCentral = new Posicion(3,1);
        Posicion posicion3PlazaCentral = new Posicion(4,2);
        Posicion posicion4PlazaCentral = new Posicion(4,1);
        ArrayList<Posicion> posicionesPlazaCentral = new ArrayList<>();
        posicionesPlazaCentral.add(posicion1PlazaCentral);
        posicionesPlazaCentral.add(posicion2PlazaCentral);
        posicionesPlazaCentral.add(posicion3PlazaCentral);
        posicionesPlazaCentral.add(posicion4PlazaCentral);

        jugador.construirPlazaCentral(posicionAldeano, posicionesPlazaCentral);
        Aldeano aldeano2 = jugador.devolverAldeanoEnPosicion(posicionAldeano);
        aldeano2.desocupar();
        jugador.continuarConstruccionPlazaCentral(posicionAldeano, posicion1PlazaCentral);

        Assert.assertEquals(2, jugador.getEdificios().size() );

    }

    @Test
    public void aldeanoConstruyeUnCuartelCorrectamente(){
        Jugador jugador = new Jugador();
        Posicion posicionAldeano = new Posicion(2,2);
        Posicion posicion1Cuartel = new Posicion(3,2);
        Posicion posicion2Cuartel = new Posicion(3,1);
        Posicion posicion3Cuartel = new Posicion(4,2);
        Posicion posicion4Cuartel = new Posicion(4,1);
        ArrayList<Posicion> posicionesCuartel = new ArrayList<>();
        posicionesCuartel.add(posicion1Cuartel);
        posicionesCuartel.add(posicion2Cuartel);
        posicionesCuartel.add(posicion3Cuartel);
        posicionesCuartel.add(posicion4Cuartel);

        jugador.construirCuartel(posicionAldeano, posicionesCuartel);

        Assert.assertEquals(2, jugador.getEdificios().size() );

    }


    @Test
    public void aldeanoContinuaConstruccionDeUnCuartelCorrectamente(){
        Jugador jugador = new Jugador();
        Posicion posicionAldeano = new Posicion(2,2);
        Posicion posicion1Cuartel = new Posicion(3,2);
        Posicion posicion2Cuartel = new Posicion(3,1);
        Posicion posicion3Cuartel = new Posicion(4,2);
        Posicion posicion4Cuartel = new Posicion(4,1);
        ArrayList<Posicion> posicionesCuartel = new ArrayList<>();
        posicionesCuartel.add(posicion1Cuartel);
        posicionesCuartel.add(posicion2Cuartel);
        posicionesCuartel.add(posicion3Cuartel);
        posicionesCuartel.add(posicion4Cuartel);

        jugador.construirCuartel(posicionAldeano, posicionesCuartel);
        Aldeano aldeano2 = jugador.devolverAldeanoEnPosicion(posicionAldeano);
        aldeano2.desocupar();
        jugador.continuarConstruccionCuartel(posicionAldeano, posicion1Cuartel);

        Assert.assertEquals(2, jugador.getEdificios().size() );

    }



    @Test (expected = UnidadNoPuedeConstruirException.class)
    public void aldeanoNoPuedeConstruirSiNoFueDesocupado(){
        Jugador jugador = new Jugador();
        Posicion posicionAldeano = new Posicion(2,2);
        Posicion posicion1PlazaCentral = new Posicion(3,2);
        Posicion posicion2PlazaCentral = new Posicion(3,1);
        Posicion posicion3PlazaCentral = new Posicion(4,2);
        Posicion posicion4PlazaCentral = new Posicion(4,1);
        ArrayList<Posicion> posicionesPlazaCentral = new ArrayList<>();
        posicionesPlazaCentral.add(posicion1PlazaCentral);
        posicionesPlazaCentral.add(posicion2PlazaCentral);
        posicionesPlazaCentral.add(posicion3PlazaCentral);
        posicionesPlazaCentral.add(posicion4PlazaCentral);

        jugador.construirPlazaCentral(posicionAldeano, posicionesPlazaCentral);
        jugador.continuarConstruccionPlazaCentral(posicionAldeano, posicion1PlazaCentral);

        Assert.assertEquals(2, jugador.getEdificios().size() );

    }

    @Test
    public void aldeanoEnConstruccionNoGeneraOro(){
        Jugador jugador = new Jugador();
        Posicion posicionAldeano = new Posicion(2,2);
        Posicion posicion1PlazaCentral = new Posicion(3,2);
        Posicion posicion2PlazaCentral = new Posicion(3,1);
        Posicion posicion3PlazaCentral = new Posicion(4,2);
        Posicion posicion4PlazaCentral = new Posicion(4,1);
        ArrayList<Posicion> posicionesPlazaCentral = new ArrayList<>();
        posicionesPlazaCentral.add(posicion1PlazaCentral);
        posicionesPlazaCentral.add(posicion2PlazaCentral);
        posicionesPlazaCentral.add(posicion3PlazaCentral);
        posicionesPlazaCentral.add(posicion4PlazaCentral);

        Assert.assertEquals(100, jugador.getCantidadOro() );
        jugador.construirPlazaCentral(posicionAldeano, posicionesPlazaCentral);
        Aldeano aldeano2 = jugador.devolverAldeanoEnPosicion(posicionAldeano);
        aldeano2.desocupar();
        jugador.continuarConstruccionPlazaCentral(posicionAldeano, posicion1PlazaCentral);
        jugador.recolectarOro();

        Assert.assertEquals(140, jugador.getCantidadOro() );
        Assert.assertEquals(2, jugador.getEdificios().size() );

    }

    @Test (expected = UnidadNoPuedeConstruirException.class )
    public void dosAldeanosIntentanConstruirAlMismoTiempoLanzaExcepcion(){
        Jugador jugador = new Jugador();
        Posicion posicionAldeano = new Posicion(2,2);
        Posicion posicionOtroAldeano = new Posicion(2,1);
        Aldeano otroAldeano = new Aldeano();
        otroAldeano.setPosicion(posicionOtroAldeano);

        Posicion posicion1Cuartel = new Posicion(3,2);
        Posicion posicion2Cuartel = new Posicion(3,1);
        Posicion posicion3Cuartel = new Posicion(4,2);
        Posicion posicion4Cuartel = new Posicion(4,1);
        ArrayList<Posicion> posicionesCuartel = new ArrayList<>();
        posicionesCuartel.add(posicion1Cuartel);
        posicionesCuartel.add(posicion2Cuartel);
        posicionesCuartel.add(posicion3Cuartel);
        posicionesCuartel.add(posicion4Cuartel);

        jugador.agregarAldeano(otroAldeano);
        jugador.construirCuartel(posicionAldeano, posicionesCuartel);
        jugador.continuarConstruccionCuartel(posicionOtroAldeano, posicion1Cuartel);
        jugador.continuarConstruccionCuartel(posicionAldeano, posicion1Cuartel);

    }

}
