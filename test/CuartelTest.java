import Modelo.Edificios.Cuartel;
import Modelo.Exceptions.*;
import Modelo.Posicion;
import Modelo.Unidades.Arquero;
import Modelo.Unidades.Espadachin;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CuartelTest {

    private Cuartel cuartelConstruido;

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
        cuartelConstruido = new Cuartel(posiciones);
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
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        Cuartel cuartel = new Cuartel(posiciones);
        cuartel.construir();
        cuartel.construir();
    }

    @Test(expected = EdificioYaConstruidoException.class)
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
        Cuartel cuartel = new Cuartel(posiciones);
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
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        Cuartel cuartel = new Cuartel(posiciones);
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        Assert.assertEquals(cuartel.getVida(), 0);
    }

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
        Cuartel cuartel = new Cuartel(posiciones);
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
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        Cuartel cuartel = new Cuartel(posiciones);
        cuartel.reparar();
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
        Cuartel cuartel = new Cuartel(posiciones);
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.reparar();
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
        Cuartel cuartel = new Cuartel(posiciones);
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.reparar();
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
        Cuartel cuartel = new Cuartel(posiciones);
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.reparar();
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
        Cuartel cuartel = new Cuartel(posiciones);
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

    //Tests agregados 18-11-18

    @Test (expected =  EdificioNoConstruidoException.class)
    public void cuartelNoConstruidoSigueNoConstruidoAlVolverAEstadoOriginal(){
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        Cuartel cuartel = new Cuartel(posiciones);
        cuartel.volverAEstadoOriginal();
        cuartel.reparar();
    }

    @Test (expected = EdificioYaConstruidoException.class)
    public void cuartelConstruidoSigueConstruidoAlVolverAEstadoOriginal(){
        cuartelConstruido.volverAEstadoOriginal();
        cuartelConstruido.construir();
    }

    @Test (expected = EdificioYaConstruidoException.class)
    public void cuartelEnReparacionFallaAlConstruir(){
        cuartelConstruido.reducirVida(30);
        cuartelConstruido.construir();
    }

    @Test
    public void atacarEdificioEnConstruccionEIntentarConstruirlo() {
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        Cuartel cuartel = new Cuartel(posiciones);
        cuartel.reducirVida(20);
        boolean errorLanzado = false;
        try {
            cuartel.construir();
        } catch (EdificioDestruidoException e) {
            errorLanzado = true;
        }
        Assert.assertTrue(errorLanzado);
    }

    @Test
    public void atacarEdificioEnConstruccionEIntentarRepararlo() {
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        Cuartel cuartel = new Cuartel(posiciones);
        cuartel.reducirVida(20);
        boolean errorLanzado = false;
        try {
            cuartel.reparar();
        } catch (EdificioDestruidoException e) {
            errorLanzado = true;
        }
        Assert.assertTrue(errorLanzado);
    }

}