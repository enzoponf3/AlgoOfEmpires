import Modelo.Edificios.PlazaCentral;
import Modelo.Exceptions.CastilloSinObjetivosEnRangoException;
import Modelo.Exceptions.TurnoDelOponenteException;
import Modelo.Juego;
import Modelo.Jugador.Jugador;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import Modelo.Unidades.ArmaDeAsedio;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JuegoTest {

    private Juego juego;

    @Before
    public void setUp() {
        juego = new Juego();
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void crearJuegoConJugadorDosInactivo() {
        Jugador jugador = juego.getJugador2();
        Posicion posicion = new Posicion(0,0);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(posicion);
        jugador.montarArmaDeAsedio(armaAsedio);
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void cambiarCorrectamenteDeTurno() {
        try {
            juego.cambiarDeTurno();
        } catch (CastilloSinObjetivosEnRangoException ignroed){}
        Jugador jugador = juego.getJugador1();
        Posicion posicion = new Posicion(0,0);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(posicion);
        jugador.montarArmaDeAsedio(armaAsedio);
    }

    @Test (expected = CastilloSinObjetivosEnRangoException.class)
    public void castilloNoRealizaAtaqueAlFinalizarTurno() {
        juego.cambiarDeTurno();
    }

    @Test
    public void verificarJugadorGanador() {
        juego.getJugador2().getCastillo().reducirVida(2000);
        if (juego.esGanador(juego.getJugador1()))
            juego.finalizarJuego(juego.getJugador1());
        Assert.assertEquals(juego.getJugador1(),juego.getGanador());
    }
}
