import Modelo.Edificios.*;
import Modelo.Exceptions.*;
import Modelo.Unidades.Aldeano;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlazaCentralTest {

    private PlazaCentral plazaConstruida;

    @Before
    public void setUp() throws Exception {
        plazaConstruida = new PlazaCentral();
        plazaConstruida.finalizarConstruccion();
    }

    @Test
    public void crearPlazaCentralConVidaCorrecta() {
        Assert.assertEquals(plazaConstruida.getVida(), 450);
    }

    @Test
    public void crearPlazaCentralConCostoCorrecto() {
        Assert.assertEquals(plazaConstruida.getCosto(), 100);
    }

    @Test
    public void reducirVidaPlazaCentral() {
        plazaConstruida.reducirVida(10);
        Assert.assertEquals(plazaConstruida.getVida(), 440);
    }

    @Test(expected = EdificioDestruidoException.class)
    public void intentarQuitarVidaCuandoYaEsCero() {
        plazaConstruida.reducirVida(450);
        plazaConstruida.reducirVida(10);
    }

    @Test
    public void reducirVidaYRepararEdificio() {
        plazaConstruida.reducirVida(50);
        plazaConstruida.reparar();
        Assert.assertEquals(plazaConstruida.getVida(), 425);
    }

    @Test
    public void crearPlazaCentralConVelocidadReparacionCorrecta() {
        Assert.assertEquals(plazaConstruida.getVelocidadReparacion(), 25);
    }

    @Test (expected = EdificioEnReparacionException.class)
    public void soloSePuedeRepararUnaVezAntesDeCambiarDeEstado() {
        plazaConstruida.reducirVida(100);
        plazaConstruida.reparar();
        plazaConstruida.reparar();
    }

    @Test
    public void sePuedeRepararNuevamenteDespuesDeCambiarDeEstado() {
        plazaConstruida.reducirVida(100);
        plazaConstruida.reparar();
        plazaConstruida.volverAEstadoOriginal();
        plazaConstruida.reparar();
        Assert.assertEquals(plazaConstruida.getVida(),400);
    }
    @Test (expected = EdificioConVidaAlMaximoException.class)
    public void noEsPosibleRepararCuandoVidaEsMaxima() {
        plazaConstruida.reparar();
    }

    @Test
    public void repararNoSuperaVidaMaximaTrasHaberReducidoVida() {
        plazaConstruida.reducirVida(10);
        plazaConstruida.reparar();
        Assert.assertEquals(plazaConstruida.getVida(),450);
    }

    @Test(expected = EdificioEnConstruccionException.class)
    public void intentarConstruirMasDeUnaVezSinVolverAEstadoOriginalAntes() {
        PlazaCentral plaza = new PlazaCentral();
        plaza.construir();
        plaza.construir();
    }
    
    @Test (expected = EdificioYaConstruidoException.class)
    public void intentarConstruirMasTurnosDeLoNecesario() {
        PlazaCentral plaza = new PlazaCentral();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();;
    }

    @Test
    public void vidaAntesDeTerminarConstruccionEsCero() {
        PlazaCentral plaza = new PlazaCentral();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        Assert.assertEquals(plaza.getVida(), 0);
    }
    // VAMOS BIEN

    @Test
    public void vidaCorrectaTrasFinalizarConstruccion() {
        PlazaCentral plaza = new PlazaCentral();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        Assert.assertEquals(plaza.getVida(), 450);
    }

    @Test (expected = EdificioNoConstruidoException.class)
    public void noEsPosibleRepararSinInicializarConstruccion() {
        PlazaCentral plaza = new PlazaCentral();
        plaza.reparar();
    }

    @Test (expected = EdificioNoConstruidoException.class)
    public void noEsPosibleRepararTrasUnTurnoConstruccion() {
        PlazaCentral plaza = new PlazaCentral();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.reparar();
    }

    @Test (expected = EdificioNoConstruidoException.class)
    public void noEsPosibleRepararTrasDosTurnosConstruccion() {
        PlazaCentral plaza = new PlazaCentral();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.reparar();
    }

    @Test (expected = EdificioEnConstruccionException.class)
    public void noEsPosibleRepararTrasTresTurnosConstruccionSinFinalizar() {
        PlazaCentral plaza = new PlazaCentral();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.reparar();
    }

    @Test
    public void repararTrasTresTurnosConstruccionYFinalizar() {
        PlazaCentral plaza = new PlazaCentral();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.reducirVida(100);
        plaza.reparar();
        Assert.assertEquals(plaza.getVida(),375);
    }

    @Test (expected = EdificioDestruidoException.class)
    public void repararTrasDestruirPlazaCentral() {
        plazaConstruida.reducirVida(450);
        plazaConstruida.reparar();
    }

    @Test (expected = EdificioDestruidoException.class)
    public void crearAldeanoTrasDestruirPlazaCentral() {
        plazaConstruida.reducirVida(450);
        plazaConstruida.crearAldeano();
    }

    @Test (expected = EdificioDestruidoException.class)
    public void construirTrasDestruirPlazaCentral() {
        plazaConstruida.reducirVida(450);
        plazaConstruida.construir();
    }

    @Test (expected = EdificioDestruidoException.class)
    public void volverAEstadoOriginalTrasDestruirPlazaCentral() {
        plazaConstruida.reducirVida(450);
        plazaConstruida.volverAEstadoOriginal();
    }

    //Pruebas agregadas 18-11-18



    @Test (expected = EdificioYaConstruidoException.class)
    public void plazaCentralEnReparacionSigueEstandoConstruida(){
        plazaConstruida.reducirVida(100);
        plazaConstruida.reparar();
        plazaConstruida.construir();
    }

    @Test (expected = EdificioYaConstruidoException.class)
    public void plazaCentralConstruidaSigueConstruidaAlVolverAlEstadoOriginal(){
        plazaConstruida.volverAEstadoOriginal();
        plazaConstruida.construir();
    }

    @Test (expected = EdificioNoConstruidoException.class)
    public void plazaCentralNoConstruidaSigueNoConstruidaAlVolverAlEstadoOriginal(){
        PlazaCentral plaza = new PlazaCentral();
        plaza.volverAEstadoOriginal();
        plaza.reparar();
    }

    @Test (expected = EdificioYaConstruidoException.class)
    public void plazaCentralConstruirEnReparacionFalla(){
        plazaConstruida.reducirVida(50);
        plazaConstruida.reparar();
        plazaConstruida.construir();
    }
}