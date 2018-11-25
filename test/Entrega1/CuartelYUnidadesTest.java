package Entrega1;

import Modelo.Mapa;
import Modelo.Posicion;
import Modelo.Unidades.Arquero;
import Modelo.Unidades.Espadachin;
import Modelo.Edificios.Cuartel;
import Modelo.Exceptions.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class CuartelYUnidadesTest {

    @Test(expected = EdificioNoConstruidoException.class)
    public void crearEspadachinTrasUnTurnoConstruccion() {
        Mapa mapa = new Mapa(10, 20);

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
        cuartel.crearEspadachin(mapa);
    }

    @Test(expected = EdificioEnConstruccionException.class)
    public void crearEspadachinTrasUnTurnoConstruccionSinVolverAEstadoOriginal() {
        Mapa mapa = new Mapa(10, 20);

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
        cuartel.crearEspadachin(mapa);
    }

    @Test(expected = EdificioNoConstruidoException.class)
    public void crearEspadachinTrasDosTurnosConstruccion() {
        Mapa mapa = new Mapa(10, 20);

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
        cuartel.crearEspadachin(mapa);
    }

    @Test(expected = EdificioEnConstruccionException.class)
    public void crearEspadachinTrasDosTurnosConstruccionSinVolverAEstadoOriginal() {
        Mapa mapa = new Mapa(10, 20);

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
        cuartel.crearEspadachin(mapa);
    }

    @Test(expected = EdificioEnConstruccionException.class)
    public void crearEspadachinTrasTresTurnosConstruccion() {
        Mapa mapa = new Mapa(10, 20);

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
        cuartel.crearEspadachin(mapa);
    }

    @Test
    public void crearEspadachinTrasTresTurnosConstruccionYFinalizarConstruccion() {
        Mapa mapa = new Mapa(10, 20);

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
        Espadachin espadachin = cuartel.crearEspadachin(mapa);
        Assert.assertEquals(espadachin.getVida(), 100);
    }

    @Test(expected = EdificioNoConstruidoException.class)
    public void crearArqueroTrasUnTurnoConstruccion() {
        Mapa mapa = new Mapa(10, 20);

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
        cuartel.crearArquero(mapa);
    }

    @Test(expected = EdificioEnConstruccionException.class)
    public void crearArqueroTrasUnTurnoConstruccionSinVolverAEstadoOriginal() {
        Mapa mapa = new Mapa(10, 20);

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
        cuartel.crearArquero(mapa);
    }

    @Test(expected = EdificioNoConstruidoException.class)
    public void crearArqueroTrasDosTurnosConstruccion() {
        Mapa mapa = new Mapa(10, 20);

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
        cuartel.crearArquero(mapa);
    }

    @Test(expected = EdificioEnConstruccionException.class)
    public void crearArqueroTrasDosTurnosConstruccionSinVolverAEstadoOriginal() {
        Mapa mapa = new Mapa(10, 20);

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
        cuartel.crearArquero(mapa);
    }

    @Test(expected = EdificioEnConstruccionException.class)
    public void crearArqueroTrasTresTurnosConstruccion() {
        Mapa mapa = new Mapa(10, 20);

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
        cuartel.crearArquero(mapa);
    }

    @Test
    public void crearArqueroTrasTresTurnosConstruccionYFinalizarConstruccion() {
        Mapa mapa = new Mapa(10, 20);

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
        Arquero arquero = cuartel.crearArquero(mapa);
        Assert.assertEquals(arquero.getVida(), 75);
    }

    @Test
    public void cuartelEnReparacionCreaEspadachin(){
        Mapa mapa = new Mapa(10, 20);

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
        cuartel.reducirVida(30);
        cuartel.reparar();
        Espadachin espadachin = cuartel.crearEspadachin(mapa);
        Assert.assertNotNull(espadachin);
    }

    @Test
    public void cuartelEnReparacionCreaArquero(){
        Mapa mapa = new Mapa(10, 20);

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
        cuartel.reducirVida(30);
        cuartel.reparar();
        Arquero arquero = cuartel.crearArquero(mapa);
        Assert.assertNotNull(arquero);
    }
}
