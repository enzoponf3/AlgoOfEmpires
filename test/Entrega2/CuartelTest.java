package Entrega2;

import Modelo.Edificios.Cuartel;
import Modelo.Exceptions.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CuartelTest {

    private Cuartel cuartelConstruido;

    @Before
    public void setUp() throws Exception {
        cuartelConstruido = new Cuartel();
        cuartelConstruido.finalizarConstruccion();
    }

    @Test
    public void crearCuartelConVidaCorrecta() {
        Assert.assertEquals(cuartelConstruido.getVida(), 250);
    }

    @Test
    public void crearCuartelConCostoCorrecto() {
        Assert.assertEquals(cuartelConstruido.getCosto(), 50);
    }

    @Test
    public void reducirVidaCuartel() {
        cuartelConstruido.reducirVida(10);
        Assert.assertEquals(cuartelConstruido.getVida(), 240);
    }

    @Test(expected = EdificioDestruidoException.class)
    public void intentarQuitarVidaCuandoYaEsCero() {
        cuartelConstruido.reducirVida(450);
        cuartelConstruido.reducirVida(10);
    }

    @Test
    public void reducirVidaYRepararEdificio() {
        cuartelConstruido.reducirVida(50);
        cuartelConstruido.reparar();
        Assert.assertEquals(cuartelConstruido.getVida(), 250);
    }

    @Test
    public void crearCuartelConVelocidadReparacionCorrecta() {
        Assert.assertEquals(cuartelConstruido.getVelocidadReparacion(), 50);
    }

    @Test(expected = EdificioEnReparacionException.class)
    public void soloSePuedeRepararUnaVezAntesDeCambiarDeEstado() {
        cuartelConstruido.reducirVida(100);
        cuartelConstruido.reparar();
        cuartelConstruido.reparar();
    }

    @Test
    public void sePuedeRepararNuevamenteDespuesDeCambiarDeEstado() {
        cuartelConstruido.reducirVida(100);
        cuartelConstruido.reparar();
        cuartelConstruido.volverAEstadoOriginal();
        cuartelConstruido.reparar();
        Assert.assertEquals(cuartelConstruido.getVida(), 250);
    }

    @Test(expected = EdificioConVidaAlMaximoException.class)
    public void noEsPosibleRepararCuandoVidaEsMaxima() {
        cuartelConstruido.reparar();
    }

    @Test
    public void repararNoSuperaVidaMaximaTrasHaberReducidoVida() {
        cuartelConstruido.reducirVida(10);
        cuartelConstruido.reparar();
        Assert.assertEquals(cuartelConstruido.getVida(), 250);
    }

    @Test(expected = EdificioEnConstruccionException.class)
    public void intentarConstruirMasDeUnaVezSinVolverAEstadoOriginalAntes() {
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        cuartel.construir();
    }

    @Test(expected = EdificioYaConstruidoException.class)
    public void intentarConstruirMasTurnosDeLoNecesario() {
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
    }

    @Test
    public void vidaAntesDeTerminarConstruccionEsCero() {
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        Assert.assertEquals(cuartel.getVida(), 0);
    }

    @Test
    public void vidaCorrectaTrasFinalizarConstruccion() {
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        Assert.assertEquals(cuartel.getVida(), 250);
    }

    @Test (expected = EdificioNoConstruidoException.class)
    public void noEsPosibleRepararSinInicializarConstruccion() {
        Cuartel cuartel = new Cuartel();
        cuartel.reparar();
    }

    @Test (expected = EdificioNoConstruidoException.class)
    public void noEsPosibleRepararTrasUnTurnoConstruccion() {
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.reparar();
    }

    @Test (expected = EdificioNoConstruidoException.class)
    public void noEsPosibleRepararTrasDosTurnosConstruccion() {
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.reparar();
    }

    @Test (expected = EdificioEnConstruccionException.class)
    public void noEsPosibleRepararTrasTresTurnosConstruccionSinFinalizar() {
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.reparar();
    }

    @Test
    public void repararTrasTresTurnosConstruccionYFinalizar() {
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.reducirVida(100);
        cuartel.reparar();
        Assert.assertEquals(cuartel.getVida(),200);
    }

    @Test (expected = EdificioDestruidoException.class)
    public void repararTrasDestruirCuartel() {
        cuartelConstruido.reducirVida(250);
        cuartelConstruido.reparar();
    }

    @Test (expected = EdificioDestruidoException.class)
    public void crearEspadachinTrasDestruirCuartel() {
        cuartelConstruido.reducirVida(250);
        cuartelConstruido.crearEspadachin();
    }

    @Test (expected = EdificioDestruidoException.class)
    public void crearArqueroTrasDestruirCuartel() {
        cuartelConstruido.reducirVida(250);
        cuartelConstruido.crearArquero();
    }

    @Test (expected = EdificioDestruidoException.class)
    public void construirTrasDestruirCuartel() {
        cuartelConstruido.reducirVida(250);
        cuartelConstruido.construir();
    }

    @Test (expected = EdificioDestruidoException.class)
    public void volverAEstadoOriginalTrasDestruirCuartel() {
        cuartelConstruido.reducirVida(250);
        cuartelConstruido.volverAEstadoOriginal();
    }
}