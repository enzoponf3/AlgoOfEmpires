package Entrega2;

import Modelo.Edificios.Castillo;
import Modelo.Edificios.Cuartel;
import Modelo.Edificios.PlazaCentral;
import Modelo.Exceptions.AldeanoNoExisteException;
import Modelo.Exceptions.TurnoDelOponenteException;
import Modelo.Exceptions.UnidadNoPuedeConstruirException;
import Modelo.Jugador.Jugador;
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
        Jugador jugador = new Jugador(5, 14);
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

        jugador.agregarAldeano(aldeano);
        jugador.construirPlazaCentral(aldeano, posicionesPlazaCentral);

        Assert.assertEquals(2, jugador.getEdificios().size() );

    }

    @Test (expected = TurnoDelOponenteException.class)
    public void aldeanoConstruyeUnaPlazaCentralEnTurnoDelOponente(){
        Jugador jugador = new Jugador(5, 14);
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

        jugador.agregarAldeano(aldeano);
        jugador.construirPlazaCentral(aldeano, posicionesPlazaCentral);
    }

    @Test
    public void aldeanoContinuaConstruccionDeUnaPlazaCentralCorrectamenteEnTurnoPropio(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

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
        Aldeano aldeano2 = jugador.devolverAldeanoEnPosicion(posicionAldeano);

        jugador.construirPlazaCentral(aldeano2, posicionesPlazaCentral);
        aldeano2.desocupar();
        PlazaCentral plazaCentral = (PlazaCentral) jugador.devolverEdificioEnPosicion(posicion1PlazaCentral);
        jugador.continuarConstruccionPlazaCentral(aldeano2, plazaCentral);

        Assert.assertEquals(2, jugador.getEdificios().size() );

    }

    @Test (expected = TurnoDelOponenteException.class)
    public void aldeanoContinuaConstruccionDeUnaPlazaCentralEnTurnoDelOponente(){
        Jugador jugador = new Jugador(5, 14);
        jugador.inactivar();

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

        Aldeano aldeano2 = jugador.devolverAldeanoEnPosicion(posicionAldeano);
        jugador.construirPlazaCentral(aldeano2, posicionesPlazaCentral);

        aldeano2.desocupar();
        PlazaCentral plazaCentral = (PlazaCentral) jugador.devolverEdificioEnPosicion(posicion1PlazaCentral);
        jugador.continuarConstruccionPlazaCentral(aldeano2, plazaCentral);

        Assert.assertEquals(2, jugador.getEdificios().size() );

    }

    @Test
    public void aldeanoConstruyeUnCuartelCorrectamente(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

        Posicion posicionAldeano = new Posicion(4,0);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        jugador.agregarAldeano(aldeano);

        Posicion posicion1Cuartel = new Posicion(3,2);
        Posicion posicion2Cuartel = new Posicion(3,1);
        Posicion posicion3Cuartel = new Posicion(4,2);
        Posicion posicion4Cuartel = new Posicion(4,1);
        ArrayList<Posicion> posicionesCuartel = new ArrayList<>();
        posicionesCuartel.add(posicion1Cuartel);
        posicionesCuartel.add(posicion2Cuartel);
        posicionesCuartel.add(posicion3Cuartel);
        posicionesCuartel.add(posicion4Cuartel);

        jugador.construirCuartel(aldeano, posicionesCuartel);

        Assert.assertEquals(2, jugador.getEdificios().size() );

    }


    @Test
    public void aldeanoContinuaConstruccionDeUnCuartelCorrectamente(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

        Posicion posicionAldeano = new Posicion(4,0);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        jugador.agregarAldeano(aldeano);

        Posicion posicion1Cuartel = new Posicion(3,2);
        Posicion posicion2Cuartel = new Posicion(3,1);
        Posicion posicion3Cuartel = new Posicion(4,2);
        Posicion posicion4Cuartel = new Posicion(4,1);
        ArrayList<Posicion> posicionesCuartel = new ArrayList<>();
        posicionesCuartel.add(posicion1Cuartel);
        posicionesCuartel.add(posicion2Cuartel);
        posicionesCuartel.add(posicion3Cuartel);
        posicionesCuartel.add(posicion4Cuartel);

        jugador.construirCuartel(aldeano, posicionesCuartel);
        aldeano.desocupar();
        Cuartel cuartel = (Cuartel) jugador.devolverEdificioEnPosicion(posicion1Cuartel);
        jugador.continuarConstruccionCuartel(aldeano, cuartel);

        Assert.assertEquals(2, jugador.getEdificios().size() );

    }



    @Test (expected = UnidadNoPuedeConstruirException.class)
    public void aldeanoNoPuedeConstruirSiNoFueDesocupado(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

        Posicion posicionAldeano = new Posicion(4,0);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        jugador.agregarAldeano(aldeano);

        Posicion posicion1PlazaCentral = new Posicion(3,2);
        Posicion posicion2PlazaCentral = new Posicion(3,1);
        Posicion posicion3PlazaCentral = new Posicion(4,2);
        Posicion posicion4PlazaCentral = new Posicion(4,1);
        ArrayList<Posicion> posicionesPlazaCentral = new ArrayList<>();
        posicionesPlazaCentral.add(posicion1PlazaCentral);
        posicionesPlazaCentral.add(posicion2PlazaCentral);
        posicionesPlazaCentral.add(posicion3PlazaCentral);
        posicionesPlazaCentral.add(posicion4PlazaCentral);

        jugador.construirPlazaCentral(aldeano, posicionesPlazaCentral);
        PlazaCentral plazaCentral = (PlazaCentral) jugador.devolverEdificioEnPosicion(posicion1PlazaCentral);

        jugador.continuarConstruccionPlazaCentral(aldeano, plazaCentral);

        Assert.assertEquals(2, jugador.getEdificios().size() );

    }

    @Test
    public void aldeanoEnConstruccionNoGeneraOro(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

        Posicion posicionAldeano = new Posicion(4,0);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        jugador.agregarAldeano(aldeano);

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
        jugador.construirPlazaCentral(aldeano, posicionesPlazaCentral);
        aldeano.desocupar();

        PlazaCentral plazaCentral = (PlazaCentral) jugador.devolverEdificioEnPosicion(posicion1PlazaCentral);
        jugador.continuarConstruccionPlazaCentral(aldeano, plazaCentral);
        jugador.recolectarOro();

        Assert.assertEquals(160, jugador.getCantidadOro() );
        Assert.assertEquals(2, jugador.getEdificios().size() );

    }

    @Test (expected = UnidadNoPuedeConstruirException.class )
    public void dosAldeanosIntentanConstruirAlMismoTiempoLanzaExcepcion(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

        Posicion posicionAldeano = new Posicion(4,0);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        jugador.agregarAldeano(aldeano);

        Posicion posicionOtroAldeano = new Posicion(2,1);
        Aldeano otroAldeano = new Aldeano(posicionOtroAldeano);
        jugador.agregarAldeano(otroAldeano);

        Posicion posicion1Cuartel = new Posicion(3,2);
        Posicion posicion2Cuartel = new Posicion(3,1);
        Posicion posicion3Cuartel = new Posicion(4,2);
        Posicion posicion4Cuartel = new Posicion(4,1);
        ArrayList<Posicion> posicionesCuartel = new ArrayList<>();
        posicionesCuartel.add(posicion1Cuartel);
        posicionesCuartel.add(posicion2Cuartel);
        posicionesCuartel.add(posicion3Cuartel);
        posicionesCuartel.add(posicion4Cuartel);

        jugador.construirCuartel(aldeano, posicionesCuartel);

        Cuartel cuartel = (Cuartel) jugador.devolverEdificioEnPosicion(posicion1Cuartel);

        jugador.continuarConstruccionCuartel(otroAldeano, cuartel);
        jugador.continuarConstruccionCuartel(aldeano, cuartel);

    }

    //Control de reparacion

    @Test
    public void aldeanoReparaPlazaCentralCorrectamenteEnTurnoPropio(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

        Espadachin espadachinEnemigo = new Espadachin();
        Posicion posicionEspadachin = new Posicion(5,1);
        espadachinEnemigo.setPosicion(posicionEspadachin);

        Posicion posicionAldeano = new Posicion(4,0);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        jugador.agregarAldeano(aldeano);

        Posicion posicion1PlazaCentral = new Posicion(3,2);
        Posicion posicion2PlazaCentral = new Posicion(3,1);
        Posicion posicion3PlazaCentral = new Posicion(4,2);
        Posicion posicion4PlazaCentral = new Posicion(4,1);
        ArrayList<Posicion> posicionesPlazaCentral = new ArrayList<>();
        posicionesPlazaCentral.add(posicion1PlazaCentral);
        posicionesPlazaCentral.add(posicion2PlazaCentral);
        posicionesPlazaCentral.add(posicion3PlazaCentral);
        posicionesPlazaCentral.add(posicion4PlazaCentral);

        jugador.construirPlazaCentral(aldeano, posicionesPlazaCentral);
        PlazaCentral plazaCentral = (PlazaCentral) jugador.devolverEdificioEnPosicion(posicion1PlazaCentral);

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
        Jugador jugador = new Jugador(5, 14);
        jugador.inactivar();

        Espadachin espadachinEnemigo = new Espadachin();
        Posicion posicionEspadachin = new Posicion(5,1);
        espadachinEnemigo.setPosicion(posicionEspadachin);

        Posicion posicionAldeano = new Posicion(4,0);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        jugador.agregarAldeano(aldeano);

        Posicion posicion1PlazaCentral = new Posicion(3,2);
        Posicion posicion2PlazaCentral = new Posicion(3,1);
        Posicion posicion3PlazaCentral = new Posicion(4,2);
        Posicion posicion4PlazaCentral = new Posicion(4,1);
        ArrayList<Posicion> posicionesPlazaCentral = new ArrayList<>();
        posicionesPlazaCentral.add(posicion1PlazaCentral);
        posicionesPlazaCentral.add(posicion2PlazaCentral);
        posicionesPlazaCentral.add(posicion3PlazaCentral);
        posicionesPlazaCentral.add(posicion4PlazaCentral);

        jugador.construirPlazaCentral(aldeano, posicionesPlazaCentral);
        PlazaCentral plazaCentral = (PlazaCentral) jugador.devolverEdificioEnPosicion(posicion1PlazaCentral);

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
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

        Espadachin espadachinEnemigo = new Espadachin();
        Posicion posicionEspadachin = new Posicion(5,1);
        espadachinEnemigo.setPosicion(posicionEspadachin);

        Posicion posicionAldeano = new Posicion(4,0);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        jugador.agregarAldeano(aldeano);

        Posicion posicion1Cuartel = new Posicion(3,2);
        Posicion posicion2Cuartel = new Posicion(3,1);
        Posicion posicion3Cuartel = new Posicion(4,2);
        Posicion posicion4Cuartel = new Posicion(4,1);
        ArrayList<Posicion> posicionesCuartel = new ArrayList<>();
        posicionesCuartel.add(posicion1Cuartel);
        posicionesCuartel.add(posicion2Cuartel);
        posicionesCuartel.add(posicion3Cuartel);
        posicionesCuartel.add(posicion4Cuartel);

        jugador.construirCuartel(aldeano, posicionesCuartel);

        Cuartel cuartel = (Cuartel) jugador.devolverEdificioEnPosicion(posicion1Cuartel);
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

        cuartel = (Cuartel) jugador.devolverEdificioEnPosicion(posicion1Cuartel);
        Assert.assertEquals(250, cuartel.getVida() );

        espadachinEnemigo.atacar(cuartel);
        Assert.assertEquals(235, cuartel.getVida() );

        jugador.reparar(aldeano, cuartel);
        Assert.assertEquals(250, cuartel.getVida() );

    }

    @Test
    public void aldeanoReparaCastilloCorrectamente(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

        Posicion posicionEspadachin = new Posicion(4,5);
        Espadachin espadachinEnemigo = new Espadachin(posicionEspadachin);

        Posicion posicionAldeano = new Posicion(5,4);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        jugador.agregarAldeano(aldeano);

        Castillo castillo = jugador.getCastillo();
        Assert.assertEquals(1000, castillo.getVida() );

        espadachinEnemigo.atacar(castillo);
        Assert.assertEquals(985, castillo.getVida() );

        jugador.reparar(aldeano, castillo);
        Assert.assertEquals(1000, castillo.getVida() );

    }//refactorizar

    @Test (expected = AldeanoNoExisteException.class)
    public void intentarConstruirPlazaCentralConAldeanoEnemigo() {
        Jugador jugador = new Jugador(5, 14);
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

        jugador.agregarAldeano(aldeano);

        Posicion posicionAldeanoEnemigo = new Posicion(8,0);
        Aldeano aldeanoEnemigo = new Aldeano(posicionAldeanoEnemigo);
        jugador.construirPlazaCentral(aldeanoEnemigo, posicionesPlazaCentral);

    }
    @Test (expected = AldeanoNoExisteException.class)
    public void intentarContinuarConstruccionPlazaCentralConAldeanoEnemigo() {
        Jugador jugador = new Jugador(5, 14);
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

        jugador.agregarAldeano(aldeano);

        jugador.construirPlazaCentral(aldeano, posicionesPlazaCentral);

        Posicion posicionAldeanoEnemigo = new Posicion(8,0);
        Aldeano aldeanoEnemigo = new Aldeano(posicionAldeanoEnemigo);
        PlazaCentral plazaCentral = (PlazaCentral) jugador.devolverEdificioEnPosicion(posicion1PlazaCentral);
        jugador.continuarConstruccionPlazaCentral(aldeanoEnemigo, plazaCentral);

    }

    @Test (expected = AldeanoNoExisteException.class)
    public void intentarConstruirCuartelConAldeanoEnemigo() {
        Jugador jugador = new Jugador(5, 14);
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

        jugador.agregarAldeano(aldeano);
        Posicion posicionAldeanoEnemigo = new Posicion(8,0);
        Aldeano aldeanoEnemigo = new Aldeano(posicionAldeanoEnemigo);
        jugador.construirCuartel(aldeanoEnemigo, posicionesCuartel);
    }

    @Test (expected = AldeanoNoExisteException.class)
    public void intentarContinuarConstruccionCuartelConAldeanoEnemigo() {
        Jugador jugador = new Jugador(5, 14);
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

        jugador.agregarAldeano(aldeano);
        Posicion posicionAldeanoEnemigo = new Posicion(8,0);
        Aldeano aldeanoEnemigo = new Aldeano(posicionAldeanoEnemigo);
        jugador.construirCuartel(aldeano, posicionesCuartel);
        Cuartel cuartel = (Cuartel) jugador.devolverEdificioEnPosicion(posicion1Cuartel);
        jugador.continuarConstruccionCuartel(aldeanoEnemigo, cuartel);

    }
}
