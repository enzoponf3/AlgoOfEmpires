
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

    @Test(expected = EdificioSinVidaExcepcion.class)
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


//  EN EL SIGUIENTE TEST NO SE COMPRUEBA SI SE CREA EL ARQUERO
//

    @Test
    public void crearCuartelDemoraTresTurnosParaPoderCrearArquero() {
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        try {
            cuartel.crearArquero();
        } catch (EdificioEnConstruccionException e1) {
            try {
                cuartel.construir();
                cuartel.crearArquero();
            } catch (EdificioEnConstruccionException e2) {
                try {
                    cuartel.crearArquero();
                } catch (EdificioEnConstruccionException ignored) { }
            }
        }
        cuartel.construir();
        cuartel.crearArquero();
    }

//  EN EL SIGUIENTE TEST NO SE COMPRUEBA SI SE CREA EL ESPADACHIN
//


    @Test
    public void crearCuartelDemoraTresTurnosParaPoderCrearEspadachin() {
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        try {
            cuartel.crearEspadachin();
        } catch (EdificioEnConstruccionException e1) {
            try {
                cuartel.construir();
                cuartel.crearEspadachin();
            } catch (EdificioEnConstruccionException e2) {
                try {
                    cuartel.crearEspadachin();
                } catch (EdificioEnConstruccionException ignored) { }
            }
        }
        cuartel.construir();
        cuartel.crearEspadachin();
    }

    @Test
    public void crearCuartelDemoraTresTurnosParaPoderReducirVidaYReparar() {
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        try {
            cuartel.reparar();
        } catch (EdificioEnConstruccionException e1) {
            try {
                cuartel.construir();
                cuartel.reparar();
            } catch (EdificioEnConstruccionException e2) {
                try {
                    cuartel.reparar();
                } catch (EdificioEnConstruccionException ignored) { }
            }
        }
        cuartel.construir();
        cuartel.reducirVida(50);
        cuartel.reparar();
        Assert.assertEquals(cuartel.getVida(),250);
    }

    @Test (expected = EdificioYaConstruidoException.class)
    public void intentarConstruirMasTurnosDeLoNecesario() {
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        cuartel.construir();
        cuartel.construir();
        cuartel.construir();
    }

    @Test
    public void turnosRestantesTrasUnTurnoDeConstruccion() {
        Cuartel cuartel  = new Cuartel();
        cuartel.construir();
        Assert.assertEquals(cuartel.getTurnosNecesariosConstruccion(),2);
    }

    @Test
    public void turnosRestantesTrasDosTurnosDeConstruccion() {
        Cuartel cuartel  = new Cuartel();
        cuartel.construir();
        cuartel.construir();
        Assert.assertEquals(cuartel.getTurnosNecesariosConstruccion(),1);
    }

    @Test (expected = EdificioYaConstruidoException.class)
    public void consultarTurnosRestantesTrasFinalizarConstruccion() {
        Cuartel cuartel  = new Cuartel();
        cuartel.construir();
        cuartel.construir();
        cuartel.construir();
        cuartel.getTurnosNecesariosConstruccion();
    }

    @Test (expected = EdificioConVidaAlMaximoException.class)
    public void noEsPosibleRepararCuandoVidaEsMaxima() {
        cuartelConstruido.reparar();
    }

    @Test
    public void repararNoSuperaVidaMaximaTrasHaberReducidoVida() {
        cuartelConstruido.reducirVida(10);
        cuartelConstruido.reparar();
        Assert.assertEquals(cuartelConstruido.getVida(),250);
    }

    @Test
    public void vidaAntesDeTerminarConstruccionEsCero() {
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        cuartel.construir();
        Assert.assertEquals(cuartel.getVida(),0);
    }

    @Test
    public void creacionDeEspadachin() {
        Espadachin espadachin = cuartelConstruido.crearEspadachin();
        Assert.assertEquals(espadachin.getVida(), 100);
        Assert.assertEquals(espadachin.getCosto(),50);
    }

   @Test
    public void creacionDeArquero() {
        Arquero arquero = cuartelConstruido.crearArquero();
        Assert.assertEquals(arquero.getVida(), 75);
        Assert.assertEquals(arquero.getCosto(),75);
    }
}
