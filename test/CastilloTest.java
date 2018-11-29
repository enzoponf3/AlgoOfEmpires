import Modelo.Edificios.Castillo;
import Modelo.Exceptions.EdificioConVidaAlMaximoException;
import Modelo.Exceptions.EdificioDestruidoException;
import Modelo.Exceptions.EdificioEnReparacionException;
import Modelo.Posicion;
import Modelo.Unidades.ArmaDeAsedio;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CastilloTest {

    private Castillo castillo;

    @Before
    public void setUp() throws Exception {
        Posicion posicion1 = new Posicion(1, 1);
        Posicion posicion2 = new Posicion(1, 2);
        Posicion posicion3 = new Posicion(1, 3);
        Posicion posicion4 = new Posicion(1, 4);
        Posicion posicion5 = new Posicion(2, 1);
        Posicion posicion6 = new Posicion(2, 2);
        Posicion posicion7 = new Posicion(2, 3);
        Posicion posicion8 = new Posicion(2, 4);
        Posicion posicion9 = new Posicion(3, 1);
        Posicion posicion10 = new Posicion(3, 2);
        Posicion posicion11 = new Posicion(3, 3);
        Posicion posicion12 = new Posicion(3, 4);
        Posicion posicion13 = new Posicion(4, 1);
        Posicion posicion14 = new Posicion(4, 2);
        Posicion posicion15 = new Posicion(4, 3);
        Posicion posicion16 = new Posicion(4, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        posiciones.add(posicion5);
        posiciones.add(posicion6);
        posiciones.add(posicion7);
        posiciones.add(posicion8);
        posiciones.add(posicion9);
        posiciones.add(posicion10);
        posiciones.add(posicion11);
        posiciones.add(posicion12);
        posiciones.add(posicion13);
        posiciones.add(posicion14);
        posiciones.add(posicion15);
        posiciones.add(posicion16);
        castillo = new Castillo(posiciones);
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
