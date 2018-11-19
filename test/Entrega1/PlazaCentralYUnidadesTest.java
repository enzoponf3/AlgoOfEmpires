package Entrega1;


import Modelo.Edificios.*;
import Modelo.Exceptions.*;
import Modelo.Posicion;
import Modelo.Unidades.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class PlazaCentralYUnidadesTest {


    @Test(expected = EdificioNoConstruidoException.class)
    public void crearAldeanoTrasUnTurnoConstruccion() {
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
        plaza.crearAldeano();
    }

    @Test(expected = EdificioEnConstruccionException.class)
    public void crearAldeanoTrasUnTurnoConstruccionSinVolverAEstadoOriginal() {
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
        plaza.crearAldeano();
    }

    @Test(expected = EdificioNoConstruidoException.class)
    public void crearAldeanoTrasDosTurnosConstruccion() {
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
        plaza.crearAldeano();
    }

    @Test(expected = EdificioEnConstruccionException.class)
    public void crearAldeanoTrasDosTurnosConstruccionSinVolverAEstadoOriginal() {
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
        plaza.crearAldeano();
    }

    @Test(expected = EdificioEnConstruccionException.class)
    public void crearAldeanoTrasTresTurnosConstruccion() {
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
        plaza.crearAldeano();
    }

    @Test
    public void crearAldeanoTrasTresTurnosConstruccionYFinalizarConstruccion() {
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
        Aldeano espadachin = plaza.crearAldeano();
        Assert.assertEquals(espadachin.getVida(), 50);
    }

    @Test
    public void plazaCentralEnReparacionCreaAldeano(){
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
        Aldeano aldeano = plaza.crearAldeano();
        Assert.assertNotNull(aldeano);
    }
}
