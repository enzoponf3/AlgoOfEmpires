import Modelo.Edificios.*;
import Modelo.Exceptions.*;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class PlazaCentralTest {

    private PlazaCentral plazaConstruida;

    @Before
    public void setUp() throws Exception {
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        plazaConstruida = new PlazaCentral(posiciones);
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
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        PlazaCentral plaza = new PlazaCentral(posiciones);
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
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        PlazaCentral plaza = new PlazaCentral(posiciones);
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
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        PlazaCentral plaza = new PlazaCentral(posiciones);
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
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        PlazaCentral plaza = new PlazaCentral(posiciones);
        plaza.reparar();
    }

    @Test (expected = EdificioNoConstruidoException.class)
    public void noEsPosibleRepararTrasUnTurnoConstruccion() {
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        PlazaCentral plaza = new PlazaCentral(posiciones);
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.reparar();
    }

    @Test (expected = EdificioNoConstruidoException.class)
    public void noEsPosibleRepararTrasDosTurnosConstruccion() {
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        PlazaCentral plaza = new PlazaCentral(posiciones);
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.reparar();
    }

    @Test (expected = EdificioEnConstruccionException.class)
    public void noEsPosibleRepararTrasTresTurnosConstruccionSinFinalizar() {
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        PlazaCentral plaza = new PlazaCentral(posiciones);
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.reparar();
    }

    @Test
    public void repararTrasTresTurnosConstruccionYFinalizar() {
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        PlazaCentral plaza = new PlazaCentral(posiciones);
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
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        PlazaCentral plaza = new PlazaCentral(posiciones);
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