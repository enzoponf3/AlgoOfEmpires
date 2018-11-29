package Entrega2;

import Modelo.Edificios.Castillo;
import Modelo.Edificios.Cuartel;
import Modelo.Edificios.PlazaCentral;
import Modelo.Exceptions.AldeanoNoExisteException;
import Modelo.Exceptions.TurnoDelOponenteException;
import Modelo.Exceptions.UnidadNoPuedeConstruirException;
import Modelo.Jugador.Jugador;
import Modelo.Mapa;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import Modelo.Unidades.Espadachin;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class JugadorControlaConstruccionYReparacionTest {


    //Mandar a un aldeano a construir un edificio

    @Test
    public void aldeanoConstruyeUnaPlazaCentralCorrectamenteEnTurnoPropio(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.activar();

        Posicion posicionAldeano = new Posicion(4,0);
        Aldeano aldeano = new Aldeano(posicionAldeano);

        Posicion posicion1PlazaCentral = new Posicion(3,2);
        Posicion posicion2PlazaCentral = new Posicion(3,1);
        Posicion posicion3PlazaCentral = new Posicion(4,2);
        Posicion posicion4PlazaCentral = new Posicion(4,1);
        ArrayList<Posicion> posicionesPlazaCentral = new ArrayList<>();
        posicionesPlazaCentral.add(posicion1PlazaCentral);
        posicionesPlazaCentral.add(posicion2PlazaCentral);
        posicionesPlazaCentral.add(posicion3PlazaCentral);
        posicionesPlazaCentral.add(posicion4PlazaCentral);

        jugador.agregarAldeano(aldeano, mapa);
        jugador.construirPlazaCentral(mapa, aldeano, posicionesPlazaCentral);

        Assert.assertEquals(2, jugador.getEdificios().size() );

    }

    @Test (expected = TurnoDelOponenteException.class)
    public void aldeanoConstruyeUnaPlazaCentralEnTurnoDelOponente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.inactivar();

        Posicion posicionAldeano = new Posicion(4,0);
        Aldeano aldeano = new Aldeano(posicionAldeano);

        Posicion posicion1PlazaCentral = new Posicion(3,2);
        Posicion posicion2PlazaCentral = new Posicion(3,1);
        Posicion posicion3PlazaCentral = new Posicion(4,2);
        Posicion posicion4PlazaCentral = new Posicion(4,1);
        ArrayList<Posicion> posicionesPlazaCentral = new ArrayList<>();
        posicionesPlazaCentral.add(posicion1PlazaCentral);
        posicionesPlazaCentral.add(posicion2PlazaCentral);
        posicionesPlazaCentral.add(posicion3PlazaCentral);
        posicionesPlazaCentral.add(posicion4PlazaCentral);

        jugador.agregarAldeano(aldeano, mapa);
        jugador.construirPlazaCentral(mapa, aldeano, posicionesPlazaCentral);
    }

    @Test
    public void aldeanoContinuaConstruccionDeUnaPlazaCentralCorrectamenteEnTurnoPropio(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.activar();

        Posicion posicionAldeano = new Posicion(2,2);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        jugador.agregarAldeano(aldeano, mapa);

        Posicion posicion1PlazaCentral = new Posicion(3,2);
        Posicion posicion2PlazaCentral = new Posicion(3,1);
        Posicion posicion3PlazaCentral = new Posicion(4,2);
        Posicion posicion4PlazaCentral = new Posicion(4,1);
        ArrayList<Posicion> posicionesPlazaCentral = new ArrayList<>();
        posicionesPlazaCentral.add(posicion1PlazaCentral);
        posicionesPlazaCentral.add(posicion2PlazaCentral);
        posicionesPlazaCentral.add(posicion3PlazaCentral);
        posicionesPlazaCentral.add(posicion4PlazaCentral);

        jugador.construirPlazaCentral(mapa, aldeano, posicionesPlazaCentral);
        aldeano.desocupar();
        PlazaCentral plazaCentral = (PlazaCentral) mapa.obtenerEntidad(posicion1PlazaCentral);
        jugador.continuarConstruccionPlazaCentral(aldeano, plazaCentral);

        Assert.assertEquals(2, jugador.getEdificios().size() );

    }

    @Test (expected = TurnoDelOponenteException.class)
    public void aldeanoContinuaConstruccionDeUnaPlazaCentralEnTurnoDelOponente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.inactivar();

        Posicion posicionAldeano = new Posicion(2,2);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        jugador.agregarAldeano(aldeano, mapa);

        Posicion posicion1PlazaCentral = new Posicion(3,2);
        Posicion posicion2PlazaCentral = new Posicion(3,1);
        Posicion posicion3PlazaCentral = new Posicion(4,2);
        Posicion posicion4PlazaCentral = new Posicion(4,1);
        ArrayList<Posicion> posicionesPlazaCentral = new ArrayList<>();
        posicionesPlazaCentral.add(posicion1PlazaCentral);
        posicionesPlazaCentral.add(posicion2PlazaCentral);
        posicionesPlazaCentral.add(posicion3PlazaCentral);
        posicionesPlazaCentral.add(posicion4PlazaCentral);

        jugador.construirPlazaCentral(mapa, aldeano, posicionesPlazaCentral);

        aldeano.desocupar();
        PlazaCentral plazaCentral = (PlazaCentral) mapa.obtenerEntidad(posicion1PlazaCentral);
        jugador.continuarConstruccionPlazaCentral(aldeano, plazaCentral);

        Assert.assertEquals(2, jugador.getEdificios().size() );

    }

    @Test
    public void aldeanoConstruyeUnCuartelCorrectamente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.activar();

        Posicion posicionAldeano = new Posicion(4,0);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        jugador.agregarAldeano(aldeano, mapa);

        Posicion posicion1Cuartel = new Posicion(3,2);
        Posicion posicion2Cuartel = new Posicion(3,1);
        Posicion posicion3Cuartel = new Posicion(4,2);
        Posicion posicion4Cuartel = new Posicion(4,1);
        ArrayList<Posicion> posicionesCuartel = new ArrayList<>();
        posicionesCuartel.add(posicion1Cuartel);
        posicionesCuartel.add(posicion2Cuartel);
        posicionesCuartel.add(posicion3Cuartel);
        posicionesCuartel.add(posicion4Cuartel);

        jugador.construirCuartel(mapa,aldeano, posicionesCuartel);

        Assert.assertEquals(2, jugador.getEdificios().size() );

    }


    @Test
    public void aldeanoContinuaConstruccionDeUnCuartelCorrectamente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.activar();

        Posicion posicionAldeano = new Posicion(4,0);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        jugador.agregarAldeano(aldeano, mapa);

        Posicion posicion1Cuartel = new Posicion(3,2);
        Posicion posicion2Cuartel = new Posicion(3,1);
        Posicion posicion3Cuartel = new Posicion(4,2);
        Posicion posicion4Cuartel = new Posicion(4,1);
        ArrayList<Posicion> posicionesCuartel = new ArrayList<>();
        posicionesCuartel.add(posicion1Cuartel);
        posicionesCuartel.add(posicion2Cuartel);
        posicionesCuartel.add(posicion3Cuartel);
        posicionesCuartel.add(posicion4Cuartel);

        jugador.construirCuartel(mapa,aldeano, posicionesCuartel);
        aldeano.desocupar();
        Cuartel cuartel = (Cuartel) mapa.obtenerEntidad(posicion1Cuartel);
        jugador.continuarConstruccionCuartel(aldeano, cuartel);

        Assert.assertEquals(2, jugador.getEdificios().size() );

    }



    @Test (expected = UnidadNoPuedeConstruirException.class)
    public void aldeanoNoPuedeConstruirSiNoFueDesocupado(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.activar();

        Posicion posicionAldeano = new Posicion(4,0);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        jugador.agregarAldeano(aldeano, mapa);

        Posicion posicion1PlazaCentral = new Posicion(3,2);
        Posicion posicion2PlazaCentral = new Posicion(3,1);
        Posicion posicion3PlazaCentral = new Posicion(4,2);
        Posicion posicion4PlazaCentral = new Posicion(4,1);
        ArrayList<Posicion> posicionesPlazaCentral = new ArrayList<>();
        posicionesPlazaCentral.add(posicion1PlazaCentral);
        posicionesPlazaCentral.add(posicion2PlazaCentral);
        posicionesPlazaCentral.add(posicion3PlazaCentral);
        posicionesPlazaCentral.add(posicion4PlazaCentral);

        jugador.construirPlazaCentral(mapa, aldeano, posicionesPlazaCentral);
        PlazaCentral plazaCentral = (PlazaCentral) mapa.obtenerEntidad(posicion1PlazaCentral);

        jugador.continuarConstruccionPlazaCentral(aldeano, plazaCentral);

        Assert.assertEquals(2, jugador.getEdificios().size() );

    }

    @Test
    public void aldeanoEnConstruccionNoGeneraOro(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.activar();

        Posicion posicionAldeano = new Posicion(4,0);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        jugador.agregarAldeano(aldeano, mapa);

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
        jugador.construirPlazaCentral(mapa,aldeano, posicionesPlazaCentral);
        aldeano.desocupar();

        PlazaCentral plazaCentral = (PlazaCentral) mapa.obtenerEntidad(posicion1PlazaCentral);
        jugador.continuarConstruccionPlazaCentral(aldeano, plazaCentral);
        jugador.recolectarOro();

        Assert.assertEquals(160, jugador.getCantidadOro() );
        Assert.assertEquals(2, jugador.getEdificios().size() );

    }

    @Test (expected = UnidadNoPuedeConstruirException.class )
    public void dosAldeanosIntentanConstruirAlMismoTiempoLanzaExcepcion(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.activar();

        Posicion posicionAldeano = new Posicion(4,0);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        jugador.agregarAldeano(aldeano, mapa);

        Posicion posicionOtroAldeano = new Posicion(2,1);
        Aldeano otroAldeano = new Aldeano(posicionOtroAldeano);
        jugador.agregarAldeano(otroAldeano, mapa);

        Posicion posicion1Cuartel = new Posicion(3,2);
        Posicion posicion2Cuartel = new Posicion(3,1);
        Posicion posicion3Cuartel = new Posicion(4,2);
        Posicion posicion4Cuartel = new Posicion(4,1);
        ArrayList<Posicion> posicionesCuartel = new ArrayList<>();
        posicionesCuartel.add(posicion1Cuartel);
        posicionesCuartel.add(posicion2Cuartel);
        posicionesCuartel.add(posicion3Cuartel);
        posicionesCuartel.add(posicion4Cuartel);

        jugador.construirCuartel(mapa,aldeano, posicionesCuartel);

        Cuartel cuartel = (Cuartel) mapa.obtenerEntidad(posicion1Cuartel);

        jugador.continuarConstruccionCuartel(otroAldeano, cuartel);
        jugador.continuarConstruccionCuartel(aldeano, cuartel);

    }

    //Control de reparacion

    @Test
    public void aldeanoReparaPlazaCentralCorrectamenteEnTurnoPropio(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.activar();

        Posicion posicionEspadachin = new Posicion(5,1);
        Espadachin espadachinEnemigo = new Espadachin(posicionEspadachin);

        Posicion posicionAldeano = new Posicion(4,0);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        jugador.agregarAldeano(aldeano, mapa);

        Posicion posicion1PlazaCentral = new Posicion(3,2);
        Posicion posicion2PlazaCentral = new Posicion(3,1);
        Posicion posicion3PlazaCentral = new Posicion(4,2);
        Posicion posicion4PlazaCentral = new Posicion(4,1);
        ArrayList<Posicion> posicionesPlazaCentral = new ArrayList<>();
        posicionesPlazaCentral.add(posicion1PlazaCentral);
        posicionesPlazaCentral.add(posicion2PlazaCentral);
        posicionesPlazaCentral.add(posicion3PlazaCentral);
        posicionesPlazaCentral.add(posicion4PlazaCentral);

        jugador.construirPlazaCentral(mapa,aldeano, posicionesPlazaCentral);
        PlazaCentral plazaCentral = (PlazaCentral) mapa.obtenerEntidad(posicion1PlazaCentral);

        aldeano.desocupar();
        jugador.continuarConstruccionPlazaCentral(aldeano, plazaCentral);

        plazaCentral.volverAEstadoOriginal();
        aldeano.desocupar();
        jugador.continuarConstruccionPlazaCentral(aldeano, plazaCentral);

        plazaCentral.volverAEstadoOriginal();
        aldeano.desocupar();
        jugador.continuarConstruccionPlazaCentral(aldeano, plazaCentral);
        plazaCentral.volverAEstadoOriginal();
        aldeano.desocupar();

        Assert.assertEquals(450, plazaCentral.getVida() );

        espadachinEnemigo.atacar(plazaCentral);
        Assert.assertEquals(435, plazaCentral.getVida() );

        jugador.reparar(aldeano, plazaCentral);
        Assert.assertEquals(450, plazaCentral.getVida() );

    } //Esta prueba queda inmensa porque hay que hacer control de turnos manual

    @Test (expected = TurnoDelOponenteException.class)
    public void aldeanoReparaPlazaCentralEnTurnoOponente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.inactivar();

        Posicion posicionEspadachin = new Posicion(5,1);
        Espadachin espadachinEnemigo = new Espadachin(posicionEspadachin);

        Posicion posicionAldeano = new Posicion(4,0);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        jugador.agregarAldeano(aldeano, mapa);

        Posicion posicion1PlazaCentral = new Posicion(3,2);
        Posicion posicion2PlazaCentral = new Posicion(3,1);
        Posicion posicion3PlazaCentral = new Posicion(4,2);
        Posicion posicion4PlazaCentral = new Posicion(4,1);
        ArrayList<Posicion> posicionesPlazaCentral = new ArrayList<>();
        posicionesPlazaCentral.add(posicion1PlazaCentral);
        posicionesPlazaCentral.add(posicion2PlazaCentral);
        posicionesPlazaCentral.add(posicion3PlazaCentral);
        posicionesPlazaCentral.add(posicion4PlazaCentral);

        jugador.construirPlazaCentral(mapa,aldeano, posicionesPlazaCentral);
        PlazaCentral plazaCentral = (PlazaCentral) mapa.obtenerEntidad(posicion1PlazaCentral);

        aldeano.desocupar();
        jugador.continuarConstruccionPlazaCentral(aldeano, plazaCentral);

        plazaCentral.volverAEstadoOriginal();
        aldeano.desocupar();
        jugador.continuarConstruccionPlazaCentral(aldeano, plazaCentral);

        plazaCentral.volverAEstadoOriginal();
        aldeano.desocupar();
        jugador.continuarConstruccionPlazaCentral(aldeano, plazaCentral);
        plazaCentral.volverAEstadoOriginal();
        aldeano.desocupar();

        Assert.assertEquals(450, plazaCentral.getVida() );

        espadachinEnemigo.atacar(plazaCentral);
        Assert.assertEquals(435, plazaCentral.getVida() );

        jugador.reparar(aldeano, plazaCentral);
    }

    @Test
    public void aldeanoReparaCuartelCorrectamente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.activar();

        Posicion posicionEspadachin = new Posicion(5,1);
        Espadachin espadachinEnemigo = new Espadachin(posicionEspadachin);

        Posicion posicionAldeano = new Posicion(4,0);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        jugador.agregarAldeano(aldeano, mapa);

        Posicion posicion1Cuartel = new Posicion(3,2);
        Posicion posicion2Cuartel = new Posicion(3,1);
        Posicion posicion3Cuartel = new Posicion(4,2);
        Posicion posicion4Cuartel = new Posicion(4,1);
        ArrayList<Posicion> posicionesCuartel = new ArrayList<>();
        posicionesCuartel.add(posicion1Cuartel);
        posicionesCuartel.add(posicion2Cuartel);
        posicionesCuartel.add(posicion3Cuartel);
        posicionesCuartel.add(posicion4Cuartel);

        jugador.construirCuartel(mapa,aldeano, posicionesCuartel);

        Cuartel cuartel = (Cuartel) mapa.obtenerEntidad(posicion1Cuartel);
        aldeano.desocupar();
        jugador.continuarConstruccionCuartel(aldeano, cuartel);

        cuartel.volverAEstadoOriginal();
        aldeano.desocupar();
        jugador.continuarConstruccionCuartel(aldeano, cuartel);

        cuartel.volverAEstadoOriginal();
        aldeano.desocupar();
        jugador.continuarConstruccionCuartel(aldeano, cuartel);
        cuartel.volverAEstadoOriginal();
        aldeano.desocupar();

        cuartel = (Cuartel) mapa.obtenerEntidad(posicion1Cuartel);
        Assert.assertEquals(250, cuartel.getVida() );

        espadachinEnemigo.atacar(cuartel);
        Assert.assertEquals(235, cuartel.getVida() );

        jugador.reparar(aldeano, cuartel);
        Assert.assertEquals(250, cuartel.getVida() );

    }

    @Test
    public void aldeanoReparaCastilloCorrectamente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.activar();

        Posicion posicionEspadachin = new Posicion(4,5);
        Espadachin espadachinEnemigo = new Espadachin(posicionEspadachin);

        Posicion posicionAldeano = new Posicion(5,4);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        jugador.agregarAldeano(aldeano, mapa);

        Castillo castillo = jugador.getCastillo();
        Assert.assertEquals(1000, castillo.getVida() );

        espadachinEnemigo.atacar(castillo);
        Assert.assertEquals(985, castillo.getVida() );

        jugador.reparar(aldeano, castillo);
        Assert.assertEquals(1000, castillo.getVida() );

    }//refactorizar

    @Test (expected = AldeanoNoExisteException.class)
    public void intentarConstruirPlazaCentralConAldeanoEnemigo() {
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.activar();

        Posicion posicionAldeano = new Posicion(4,0);
        Aldeano aldeano = new Aldeano(posicionAldeano);

        Posicion posicion1PlazaCentral = new Posicion(3,2);
        Posicion posicion2PlazaCentral = new Posicion(3,1);
        Posicion posicion3PlazaCentral = new Posicion(4,2);
        Posicion posicion4PlazaCentral = new Posicion(4,1);
        ArrayList<Posicion> posicionesPlazaCentral = new ArrayList<>();
        posicionesPlazaCentral.add(posicion1PlazaCentral);
        posicionesPlazaCentral.add(posicion2PlazaCentral);
        posicionesPlazaCentral.add(posicion3PlazaCentral);
        posicionesPlazaCentral.add(posicion4PlazaCentral);

        jugador.agregarAldeano(aldeano, mapa);

        Posicion posicionAldeanoEnemigo = new Posicion(8,0);
        Aldeano aldeanoEnemigo = new Aldeano(posicionAldeanoEnemigo);
        jugador.construirPlazaCentral(mapa,aldeanoEnemigo, posicionesPlazaCentral);

    }
    @Test (expected = AldeanoNoExisteException.class)
    public void intentarContinuarConstruccionPlazaCentralConAldeanoEnemigo() {
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.activar();

        Posicion posicionAldeano = new Posicion(4,0);
        Aldeano aldeano = new Aldeano(posicionAldeano);

        Posicion posicion1PlazaCentral = new Posicion(3,2);
        Posicion posicion2PlazaCentral = new Posicion(3,1);
        Posicion posicion3PlazaCentral = new Posicion(4,2);
        Posicion posicion4PlazaCentral = new Posicion(4,1);
        ArrayList<Posicion> posicionesPlazaCentral = new ArrayList<>();
        posicionesPlazaCentral.add(posicion1PlazaCentral);
        posicionesPlazaCentral.add(posicion2PlazaCentral);
        posicionesPlazaCentral.add(posicion3PlazaCentral);
        posicionesPlazaCentral.add(posicion4PlazaCentral);

        jugador.agregarAldeano(aldeano, mapa);

        jugador.construirPlazaCentral(mapa,aldeano, posicionesPlazaCentral);

        Posicion posicionAldeanoEnemigo = new Posicion(8,0);
        Aldeano aldeanoEnemigo = new Aldeano(posicionAldeanoEnemigo);
        PlazaCentral plazaCentral = (PlazaCentral) mapa.obtenerEntidad(posicion1PlazaCentral);
        jugador.continuarConstruccionPlazaCentral(aldeanoEnemigo, plazaCentral);

    }

    @Test (expected = AldeanoNoExisteException.class)
    public void intentarConstruirCuartelConAldeanoEnemigo() {
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa,5, 14);
        jugador.activar();

        Posicion posicionAldeano = new Posicion(4,0);
        Aldeano aldeano = new Aldeano(posicionAldeano);

        Posicion posicion1Cuartel = new Posicion(3,2);
        Posicion posicion2Cuartel = new Posicion(3,1);
        Posicion posicion3Cuartel = new Posicion(4,2);
        Posicion posicion4Cuartel = new Posicion(4,1);
        ArrayList<Posicion> posicionesCuartel = new ArrayList<>();
        posicionesCuartel.add(posicion1Cuartel);
        posicionesCuartel.add(posicion2Cuartel);
        posicionesCuartel.add(posicion3Cuartel);
        posicionesCuartel.add(posicion4Cuartel);

        jugador.agregarAldeano(aldeano, mapa);
        Posicion posicionAldeanoEnemigo = new Posicion(8,0);
        Aldeano aldeanoEnemigo = new Aldeano(posicionAldeanoEnemigo);
        jugador.construirCuartel(mapa,aldeanoEnemigo, posicionesCuartel);
    }

    @Test (expected = AldeanoNoExisteException.class)
    public void intentarContinuarConstruccionCuartelConAldeanoEnemigo() {
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.activar();

        Posicion posicionAldeano = new Posicion(4,0);
        Aldeano aldeano = new Aldeano(posicionAldeano);

        Posicion posicion1Cuartel = new Posicion(3,2);
        Posicion posicion2Cuartel = new Posicion(3,1);
        Posicion posicion3Cuartel = new Posicion(4,2);
        Posicion posicion4Cuartel = new Posicion(4,1);
        ArrayList<Posicion> posicionesCuartel = new ArrayList<>();
        posicionesCuartel.add(posicion1Cuartel);
        posicionesCuartel.add(posicion2Cuartel);
        posicionesCuartel.add(posicion3Cuartel);
        posicionesCuartel.add(posicion4Cuartel);

        jugador.agregarAldeano(aldeano, mapa);
        Posicion posicionAldeanoEnemigo = new Posicion(8,0);
        Aldeano aldeanoEnemigo = new Aldeano(posicionAldeanoEnemigo);
        jugador.construirCuartel(mapa,aldeano, posicionesCuartel);
        Cuartel cuartel = (Cuartel) mapa.obtenerEntidad(posicion1Cuartel);
        jugador.continuarConstruccionCuartel(aldeanoEnemigo, cuartel);

    }
}
