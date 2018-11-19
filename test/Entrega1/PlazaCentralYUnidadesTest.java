package Entrega1;


import Modelo.Edificios.*;
import Modelo.Exceptions.*;
import Modelo.Unidades.*;
import org.junit.Assert;
import org.junit.Test;

public class PlazaCentralYUnidadesTest {


    @Test(expected = EdificioNoConstruidoException.class)
    public void crearAldeanoTrasUnTurnoConstruccion() {
        PlazaCentral plaza = new PlazaCentral();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.crearAldeano();
    }

    @Test(expected = EdificioEnConstruccionException.class)
    public void crearAldeanoTrasUnTurnoConstruccionSinVolverAEstadoOriginal() {
        PlazaCentral plaza = new PlazaCentral();
        plaza.construir();
        plaza.crearAldeano();
    }

    @Test(expected = EdificioNoConstruidoException.class)
    public void crearAldeanoTrasDosTurnosConstruccion() {
        PlazaCentral plaza = new PlazaCentral();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.crearAldeano();
    }

    @Test(expected = EdificioEnConstruccionException.class)
    public void crearAldeanoTrasDosTurnosConstruccionSinVolverAEstadoOriginal() {
        PlazaCentral plaza = new PlazaCentral();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.crearAldeano();
    }

    @Test(expected = EdificioEnConstruccionException.class)
    public void crearAldeanoTrasTresTurnosConstruccion() {
        PlazaCentral plaza = new PlazaCentral();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.crearAldeano();
    }

    @Test
    public void crearAldeanoTrasTresTurnosConstruccionYFinalizarConstruccion() {
        PlazaCentral plaza = new PlazaCentral();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        Aldeano espadachin = plaza.crearAldeano();
        Assert.assertEquals(espadachin.getVida(), 50);
    }

    @Test
    public void plazaCentralEnReparacionCreaAldeano(){
        PlazaCentral plaza = new PlazaCentral();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.reducirVida(100);
        plaza.reparar();
        Aldeano aldeano = plaza.crearAldeano();
        Assert.assertNotNull(aldeano);
    }
}
