
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

    @Test(expected = EdificioSinVidaExcepcion.class)
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

    /*@Test
    public void creacionDeArmaDeAsedio() {
        ArmaDeAsedio armaDeAsedio = castillo.crearArmaDeAsedio();
        Assert.assertEquals(armaDeAsedio.getVida(), 150);
        Assert.assertEquals(armaDeAsedio.getCosto(),200);
    }*/

//    @Test
//    public void atacarUnaUnidad() {
//
//    }
//
//    @Test
//    public void atacarUnEdificio() {
//
//    }
//
//    @Test
//    public void atacarUnidadesYEdificios() {
//
//    }
}
