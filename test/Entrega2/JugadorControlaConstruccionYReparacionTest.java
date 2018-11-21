package Entrega2;

import Modelo.Edificios.Castillo;
import Modelo.Edificios.Cuartel;
import Modelo.Edificios.PlazaCentral;
import Modelo.Exceptions.UnidadNoPuedeConstruirException;
import Modelo.Jugador;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import Modelo.Unidades.Espadachin;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class JugadorControlaConstruccionYReparacionTest {


    //Mandar a un aldeano a construir un edificio

    @Test
    public void aldeanoConstruyeUnaPlazaCentralCorrectamente(){
        Jugador jugador = new Jugador(5, 14);
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
        Jugador jugador = new Jugador(5, 14);
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
        Jugador jugador = new Jugador(5, 14);
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
        Jugador jugador = new Jugador(5, 14);
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
        Jugador jugador = new Jugador(5, 14);
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
        Jugador jugador = new Jugador(5, 14);
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
        Jugador jugador = new Jugador(5, 14);
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

    //Control de reparacion

    @Test
    public void aldeanoReparaPlazaCentralCorrectamente(){
        Jugador jugador = new Jugador(5, 14);
        Espadachin espadachinEnemigo = new Espadachin();
        Posicion posicionEspadachin = new Posicion(5,1);
        espadachinEnemigo.setPosicion(posicionEspadachin);

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

        PlazaCentral plaza = (PlazaCentral) jugador.devolverEdificioEnPosicion(posicion1PlazaCentral);
        plaza.volverAEstadoOriginal();
        aldeano2.desocupar();
        jugador.continuarConstruccionPlazaCentral(posicionAldeano, posicion1PlazaCentral);

        plaza.volverAEstadoOriginal();
        aldeano2.desocupar();
        jugador.continuarConstruccionPlazaCentral(posicionAldeano, posicion1PlazaCentral);
        plaza.volverAEstadoOriginal();
        aldeano2.desocupar();

        Assert.assertEquals(450, plaza.getVida() );

        espadachinEnemigo.atacar(plaza);
        Assert.assertEquals(435, plaza.getVida() );

        jugador.reparar(posicionAldeano, posicion1PlazaCentral);
        Assert.assertEquals(450, plaza.getVida() );

    } //Esta prueba queda inmensa porque hay que hacer control de turnos manual

    @Test
    public void aldeanoReparaCuartelCorrectamente(){
        Jugador jugador = new Jugador(5, 14);
        Espadachin espadachinEnemigo = new Espadachin();
        Posicion posicionEspadachin = new Posicion(5,1);
        espadachinEnemigo.setPosicion(posicionEspadachin);

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

        Cuartel cuartel = (Cuartel) jugador.devolverEdificioEnPosicion(posicion1Cuartel);
        cuartel.volverAEstadoOriginal();
        aldeano2.desocupar();
        jugador.continuarConstruccionCuartel(posicionAldeano, posicion1Cuartel);

        cuartel.volverAEstadoOriginal();
        aldeano2.desocupar();
        jugador.continuarConstruccionCuartel(posicionAldeano, posicion1Cuartel);
        cuartel.volverAEstadoOriginal();
        aldeano2.desocupar();

        cuartel = (Cuartel) jugador.devolverEdificioEnPosicion(posicion1Cuartel);
        Assert.assertEquals(250, cuartel.getVida() );

        espadachinEnemigo.atacar(cuartel);
        Assert.assertEquals(235, cuartel.getVida() );

        jugador.reparar(posicionAldeano, posicion1Cuartel);
        Assert.assertEquals(250, cuartel.getVida() );

    }

    @Test
    public void aldeanoReparaCastilloCorrectamente(){
        Jugador jugador = new Jugador(5, 14);
        Espadachin espadachinEnemigo = new Espadachin();
        Posicion posicionEspadachin = new Posicion(4,5);
        Posicion posicion = new Posicion(5,4);
        espadachinEnemigo.setPosicion(posicionEspadachin);

        Posicion posicionAldeano = new Posicion(2,2);
        Aldeano aldeano = (Aldeano) jugador.devolverUnidadMovible(posicionAldeano);
        aldeano.mover(posicion);
        aldeano.desocupar();

        Castillo castillo = jugador.getCastillo();
        Assert.assertEquals(1000, castillo.getVida() );

        espadachinEnemigo.atacar(castillo);
        Assert.assertEquals(985, castillo.getVida() );

        jugador.reparar(posicion);
        Assert.assertEquals(1000, castillo.getVida() );

    }//refactorizar
    


}
