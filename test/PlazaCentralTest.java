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
    public void reducirLaVida() {
        plazaConstruida.reducirVida(10);
        Assert.assertEquals(plazaConstruida.getVida(), 440);
    }

    @Test(expected = EdificioSinVidaExcepcion.class)
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

//
//  EN EL SIGUIENTE TEST NO SE COMPRUEBA SI SE CREA EL ALDEANO
//

    @Test
    public void crearPlazaDemoraTresTurnosParaPoderCrearAldeano() {
        PlazaCentral plaza = new PlazaCentral();
        plaza.construir();
        try {
            plaza.crearAldeano();
        } catch (EdificioEnConstruccionException e1) {
            try {
                plaza.construir();
                plaza.crearAldeano();
            } catch (EdificioEnConstruccionException e2) {
                try {
                    plaza.crearAldeano();
                } catch (EdificioEnConstruccionException ignored) { }
            }
        }
        plaza.construir();
        plaza.crearAldeano();
    }

    @Test
    public void crearPlazaDemoraTresTurnosParaPoderReducirVidaYReparar() {
        PlazaCentral plaza = new PlazaCentral();
        plaza.construir();
        try {
            plaza.reparar();
        } catch (EdificioEnConstruccionException e1) {
            try {
                plaza.construir();
                plaza.reparar();
            } catch (EdificioEnConstruccionException e2) {
                try {
                    plaza.reparar();
                } catch (EdificioEnConstruccionException ignored) { }
            }
        }
        plaza.construir();
        plaza.reducirVida(50);
        plaza.reparar();
        Assert.assertEquals(plaza.getVida(),425);
    }

    @Test
    public void construirPlazaReducirVidaYReparar() {
        PlazaCentral plaza = new PlazaCentral();
        plaza.construir();
        plaza.construir();
        plaza.construir();
        plaza.reducirVida(100);
        plaza.reparar();
        Assert.assertEquals(plaza.getVida(),375);
    }

    @Test (expected = EdificioYaConstruidoException.class)
    public void intentarConstruirMasTurnosDeLoNecesario() {
        PlazaCentral plaza = new PlazaCentral();
        plaza.construir();
        plaza.construir();
        plaza.construir();
        plaza.construir();
    }

    @Test
    public void turnosRestantesTrasUnTurnoDeConstruccion() {
        PlazaCentral plaza  = new PlazaCentral();
        plaza.construir();
        Assert.assertEquals(plaza.getTurnosNecesariosConstruccion(),2);
    }

    @Test
    public void turnosRestantesTrasDosTurnosDeConstruccion() {
        PlazaCentral plaza  = new PlazaCentral();
        plaza.construir();
        plaza.construir();
        Assert.assertEquals(plaza.getTurnosNecesariosConstruccion(),1);
    }

    @Test (expected = EdificioYaConstruidoException.class)
    public void consultarTurnosRestantesTrasFinalizarConstruccion() {
        PlazaCentral plaza = new PlazaCentral();
        plaza.construir();
        plaza.construir();
        plaza.construir();
        plaza.getTurnosNecesariosConstruccion();
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

    @Test
    public void vidaAntesDeTerminarConstruccionEsCero() {
        PlazaCentral plaza = new PlazaCentral();
        plaza.construir();
        plaza.construir();
        Assert.assertEquals(plaza.getVida(),0);
    }

    @Test
    public void creacionDeAldeano() {
        Aldeano aldeano = plazaConstruida.crearAldeano();
        Assert.assertEquals(aldeano.getVida(), 50);
        Assert.assertEquals(aldeano.getCosto(),25);
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
}