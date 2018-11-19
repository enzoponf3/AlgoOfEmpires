package Entrega1;

import Modelo.Unidades.Arquero;
import Modelo.Unidades.Espadachin;
import Modelo.Edificios.Cuartel;
import Modelo.Exceptions.*;
import org.junit.Assert;
import org.junit.Test;

public class CuartelYUnidadesTest {

    @Test(expected = EdificioNoConstruidoException.class)
    public void crearEspadachinTrasUnTurnoConstruccion() {
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.crearEspadachin();
    }

    @Test(expected = EdificioEnConstruccionException.class)
    public void crearEspadachinTrasUnTurnoConstruccionSinVolverAEstadoOriginal() {
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        cuartel.crearEspadachin();
    }

    @Test(expected = EdificioNoConstruidoException.class)
    public void crearEspadachinTrasDosTurnosConstruccion() {
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.crearEspadachin();
    }

    @Test(expected = EdificioEnConstruccionException.class)
    public void crearEspadachinTrasDosTurnosConstruccionSinVolverAEstadoOriginal() {
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.crearEspadachin();
    }

    @Test(expected = EdificioEnConstruccionException.class)
    public void crearEspadachinTrasTresTurnosConstruccion() {
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.crearEspadachin();
    }

    @Test
    public void crearEspadachinTrasTresTurnosConstruccionYFinalizarConstruccion() {
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        Espadachin espadachin = cuartel.crearEspadachin();
        Assert.assertEquals(espadachin.getVida(), 100);
    }

    @Test(expected = EdificioNoConstruidoException.class)
    public void crearArqueroTrasUnTurnoConstruccion() {
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.crearArquero();
    }

    @Test(expected = EdificioEnConstruccionException.class)
    public void crearArqueroTrasUnTurnoConstruccionSinVolverAEstadoOriginal() {
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        cuartel.crearArquero();
    }

    @Test(expected = EdificioNoConstruidoException.class)
    public void crearArqueroTrasDosTurnosConstruccion() {
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.crearArquero();
    }

    @Test(expected = EdificioEnConstruccionException.class)
    public void crearArqueroTrasDosTurnosConstruccionSinVolverAEstadoOriginal() {
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.crearArquero();
    }

    @Test(expected = EdificioEnConstruccionException.class)
    public void crearArqueroTrasTresTurnosConstruccion() {
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.crearArquero();
    }

    @Test
    public void crearArqueroTrasTresTurnosConstruccionYFinalizarConstruccion() {
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        Arquero arquero = cuartel.crearArquero();
        Assert.assertEquals(arquero.getVida(), 75);
    }

    @Test
    public void cuartelEnReparacionCreaEspadachin(){
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.reducirVida(30);
        cuartel.reparar();
        Espadachin espadachin = cuartel.crearEspadachin();
        Assert.assertNotNull(espadachin);
    }

    @Test
    public void cuartelEnReparacionCreaArquero(){
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.reducirVida(30);
        cuartel.reparar();
        Arquero arquero = cuartel.crearArquero();
        Assert.assertNotNull(arquero);
    }
}
