package Entrega2;

import Modelo.Edificios.Castillo;
import Modelo.Exceptions.EdificioConVidaAlMaximoException;
import Modelo.Exceptions.EdificioDestruidoException;
import Modelo.Exceptions.EdificioEnReparacionException;
import Modelo.Unidades.ArmaDeAsedio;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CastilloTest {

    private Castillo castillo;

    @Before
    public void setUp() throws Exception {
        castillo = new Castillo();
    }

    @Test
    public void crearCastilloConVidaCorrecta() {
        Assert.assertEquals(castillo.getVida(), 1000);
    }

    @Test
    public void crearCastilloConVelocidadReparacionCorrecta() {
        Assert.assertEquals(castillo.getVelocidadReparacion(), 15);
    }

    @Test
    public void reducirVidaCastillo() {
        castillo.reducirVida(100);
        Assert.assertEquals(castillo.getVida(), 900);
    }

    @Test(expected = EdificioDestruidoException.class)
    public void intentarQuitarVidaCuandoYaEsCero() {
        castillo.reducirVida(1000);
        castillo.reducirVida(10);
    }

    @Test
    public void reducirVidaYRepararEdificio() {
        castillo.reducirVida(100);
        castillo.reparar();
        Assert.assertEquals(castillo.getVida(), 915);
    }

    @Test (expected = EdificioConVidaAlMaximoException.class)
    public void noEsPosibleRepararCuandoVidaEsMaxima() {
        castillo.reparar();
    }

    @Test
    public void repararNoSuperaVidaMaximaTrasHaberReducidoVida() {
        castillo.reducirVida(10);
        castillo.reparar();
        Assert.assertEquals(castillo.getVida(),1000);
     }

    @Test (expected = EdificioEnReparacionException.class)
    public void soloSePuedeRepararUnaVezAntesDeCambiarDeEstado() {
        castillo.reducirVida(100);
        castillo.reparar();
        castillo.reparar();
    }

    @Test
    public void sePuedeRepararNuevamenteDespuesDeCambiarDeEstado() {
        castillo.reducirVida(100);
        castillo.reparar();
        castillo.volverAEstadoOriginal();
        castillo.reparar();
        Assert.assertEquals(castillo.getVida(),930);
    }

    @Test (expected = EdificioDestruidoException.class)
    public void repararTrasDestruirCastillo() {
        castillo.reducirVida(1000);
        castillo.reparar();
    }

    @Test (expected = EdificioDestruidoException.class)
    public void volverAEstadoOriginalTrasDestruirCastillo() {
        castillo.reducirVida(1000);
        castillo.volverAEstadoOriginal();
    }
    
}
