package Entrega2;

import Modelo.Edificios.Castillo;
import Modelo.Edificios.Cuartel;
import Modelo.Edificios.Edificio;
import Modelo.Edificios.PlazaCentral;
import Modelo.Exceptions.EdificioDestruidoException;
import Modelo.Posicion;
import Modelo.Unidades.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CastilloUnidadesYAtaqueTest {

    private Castillo castillo;

    @Before
    public void setUp() throws Exception {
        castillo = new Castillo();
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
        castillo.setPosiciones(posiciones);
    }

    @Test
    public void creacionDeArmaDeAsedio() {
        ArmaDeAsedio armaDeAsedio = castillo.crearArmaDeAsedio();
        Assert.assertEquals(armaDeAsedio.getVida(), 150);
        Assert.assertEquals(armaDeAsedio.getCosto(),200);
    }

    @Test (expected = EdificioDestruidoException.class)
    public void crearArmaDeAsedioTrasDestruirCastillo() {
        castillo.reducirVida(1000);
        castillo.crearArmaDeAsedio();
    }

    @Test
    public void castilloCrearArmaAsedioExitosamente(){
        ArmaDeAsedio armaDeAsedio = castillo.crearArmaDeAsedio();
        Assert.assertNotNull(armaDeAsedio);
    }

    @Test
    public void castilloEnReparacionCreaArmaDeAsedio(){
        castillo.reducirVida(50);
        castillo.reparar();
        ArmaDeAsedio armaDeAsedio = castillo.crearArmaDeAsedio();
        Assert.assertNotNull(armaDeAsedio);
    }

    @Test
    public void atacarAldeanoEnRango() {
        ArrayList<Aldeano> aldeanos = new ArrayList<>();
        ArrayList<IAtacante> atacantes = new ArrayList<>();
        Posicion posicion = new Posicion(5,5);
        Aldeano aldeano = new Aldeano(posicion);
        aldeanos.add(aldeano);
        castillo.atacarUnidades(aldeanos,atacantes);
        Assert.assertEquals(aldeano.getVida(),30);
    }

    @Test
    public void atacarAldeanoFueraDeRango() {
        ArrayList<Aldeano> aldeanos = new ArrayList<>();
        ArrayList<IAtacante> atacantes = new ArrayList<>();
        Posicion posicion = new Posicion(8,8);
        Aldeano aldeano = new Aldeano(posicion);
        aldeanos.add(aldeano);
        castillo.atacarUnidades(aldeanos,atacantes);
        Assert.assertEquals(aldeano.getVida(),50);
    }

    @Test
    public void reducirVidaCastilloNoEvitaAtacarAldeanoEnRango() {
        ArrayList<Aldeano> aldeanos = new ArrayList<>();
        ArrayList<IAtacante> atacantes = new ArrayList<>();
        Posicion posicion = new Posicion(7,7);
        Aldeano aldeano = new Aldeano(posicion);
        aldeanos.add(aldeano);
        castillo.reducirVida(150);
        castillo.atacarUnidades(aldeanos,atacantes);
        Assert.assertEquals(aldeano.getVida(),30);
    }

    @Test
    public void atacarTodoTipoUnidadesEnRango() {
        ArrayList<Aldeano> aldeanos = new ArrayList<>();
        ArrayList<IAtacante> atacantes = new ArrayList<>();
        Posicion posicionAldeano = new Posicion(5,5);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        Posicion posicionArquero = new Posicion(7,7);
        Arquero arquero = new Arquero(posicionArquero);
        Posicion posicionEspadachin = new Posicion(5,3);
        Espadachin espadachin = new Espadachin(posicionEspadachin);
        Posicion posicionArmaAsedio = new Posicion(4,6);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicionArmaAsedio);
        aldeanos.add(aldeano);
        atacantes.add(arquero);
        atacantes.add(espadachin);
        atacantes.add(armaDeAsedio);
        castillo.atacarUnidades(aldeanos,atacantes);
        Assert.assertEquals(aldeano.getVida(),30);
        Assert.assertEquals(arquero.getVida(),55);
        Assert.assertEquals(espadachin.getVida(),80);
        Assert.assertEquals(armaDeAsedio.getVida(),130);
    }

    @Test
    public void atacarUnidadesDentroYFueraDeRango() {
        ArrayList<Aldeano> aldeanos = new ArrayList<>();
        ArrayList<IAtacante> atacantes = new ArrayList<>();
        Posicion posicionAldeano = new Posicion(5,5);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        Posicion posicionArquero = new Posicion(10,10);
        Arquero arquero = new Arquero(posicionArquero);
        Posicion posicionEspadachin = new Posicion(5,3);
        Espadachin espadachin = new Espadachin(posicionEspadachin);
        Posicion posicionArmaAsedio = new Posicion(9,9);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicionArmaAsedio);
        aldeanos.add(aldeano);
        atacantes.add(arquero);
        atacantes.add(espadachin);
        atacantes.add(armaDeAsedio);
        castillo.atacarUnidades(aldeanos,atacantes);
        Assert.assertEquals(aldeano.getVida(),30);
        Assert.assertEquals(arquero.getVida(),75);
        Assert.assertEquals(espadachin.getVida(),80);
        Assert.assertEquals(armaDeAsedio.getVida(),150);
    }

    @Test
    public void atacarEdificioEnRango() {
        ArrayList<Edificio> edificios = new ArrayList<>();
        Posicion posicionCuartel1 = new Posicion(5,5);
        Posicion posicionCuartel2 = new Posicion(5,6);
        Posicion posicionCuartel3 = new Posicion(6,5);
        Posicion posicionCuartel4 = new Posicion(6,6);
        ArrayList<Posicion> posicionesCuartel = new ArrayList<>();
        posicionesCuartel.add(posicionCuartel1);
        posicionesCuartel.add(posicionCuartel2);
        posicionesCuartel.add(posicionCuartel3);
        posicionesCuartel.add(posicionCuartel4);
        Cuartel cuartel = new Cuartel(posicionesCuartel);
        // Finalizo construccion automaticamente para prolijidad en las pruebas
        cuartel.finalizarConstruccion();
        edificios.add(cuartel);
        castillo.atacarEdificios(edificios);
        Assert.assertEquals(cuartel.getVida(),230);
    }

    @Test
    public void atacarEdificioFueraDeRango() {
        ArrayList<Edificio> edificios = new ArrayList<>();
        Posicion posicionCuartel1 = new Posicion(10,10);
        Posicion posicionCuartel2 = new Posicion(10,11);
        Posicion posicionCuartel3 = new Posicion(11,10);
        Posicion posicionCuartel4 = new Posicion(11,11);
        ArrayList<Posicion> posicionesCuartel = new ArrayList<>();
        posicionesCuartel.add(posicionCuartel1);
        posicionesCuartel.add(posicionCuartel2);
        posicionesCuartel.add(posicionCuartel3);
        posicionesCuartel.add(posicionCuartel4);
        Cuartel cuartel = new Cuartel(posicionesCuartel);
        // Finalizo construccion automaticamente para prolijidad en las pruebas
        cuartel.finalizarConstruccion();
        cuartel.setPosiciones(posicionesCuartel);
        edificios.add(cuartel);
        castillo.atacarEdificios(edificios);
        Assert.assertEquals(cuartel.getVida(),250);
    }

    @Test
    public void reducirVidaCastilloNoEvitaAtacarEdificioEnRango() {
        ArrayList<Edificio> edificios = new ArrayList<>();
        Posicion posicionCuartel1 = new Posicion(5,5);
        Posicion posicionCuartel2 = new Posicion(5,6);
        Posicion posicionCuartel3 = new Posicion(6,5);
        Posicion posicionCuartel4 = new Posicion(6,6);
        ArrayList<Posicion> posicionesCuartel = new ArrayList<>();
        posicionesCuartel.add(posicionCuartel1);
        posicionesCuartel.add(posicionCuartel2);
        posicionesCuartel.add(posicionCuartel3);
        posicionesCuartel.add(posicionCuartel4);
        Cuartel cuartel = new Cuartel(posicionesCuartel);
        // Finalizo construccion automaticamente para prolijidad en las pruebas
        cuartel.finalizarConstruccion();
        edificios.add(cuartel);
        castillo.reducirVida(150);
        castillo.atacarEdificios(edificios);
        Assert.assertEquals(cuartel.getVida(),230);
    }

    @Test
    public void atacarEdificiosDentroYFueraDeRango() {
        ArrayList<Edificio> edificios = new ArrayList<>();
        Posicion posicionCuartel1 = new Posicion(5,5);
        Posicion posicionCuartel2 = new Posicion(5,6);
        Posicion posicionCuartel3 = new Posicion(6,5);
        Posicion posicionCuartel4 = new Posicion(6,6);
        ArrayList<Posicion> posicionesCuartel = new ArrayList<>();
        posicionesCuartel.add(posicionCuartel1);
        posicionesCuartel.add(posicionCuartel2);
        posicionesCuartel.add(posicionCuartel3);
        posicionesCuartel.add(posicionCuartel4);
        Cuartel cuartel = new Cuartel(posicionesCuartel);
        // Finalizo construccion automaticamente para prolijidad en las pruebas
        cuartel.finalizarConstruccion();
        edificios.add(cuartel);

        Posicion posicionPlaza1 = new Posicion(1,6);
        Posicion posicionPlaza2 = new Posicion(2,6);
        Posicion posicionPlaza3 = new Posicion(1,7);
        Posicion posicionPlaza4 = new Posicion(2,7);
        ArrayList<Posicion> posicionesPlaza = new ArrayList<>();
        posicionesPlaza.add(posicionPlaza1);
        posicionesPlaza.add(posicionPlaza2);
        posicionesPlaza.add(posicionPlaza3);
        posicionesPlaza.add(posicionPlaza4);
        PlazaCentral plaza = new PlazaCentral(posicionesPlaza);
        // Finalizo construccion automaticamente para prolijidad en las pruebas
        plaza.finalizarConstruccion();
        plaza.setPosiciones(posicionesPlaza);
        edificios.add(plaza);

        Castillo castilloAtaque = new Castillo();
        Posicion posicionCastillo1 = new Posicion(10,1);
        Posicion posicionCastillo2 = new Posicion(10,2);
        Posicion posicionCastillo3 = new Posicion(10,3);
        Posicion posicionCastillo4 = new Posicion(10,4);
        Posicion posicionCastillo5 = new Posicion(11,1);
        Posicion posicionCastillo6 = new Posicion(11,2);
        Posicion posicionCastillo7 = new Posicion(11,3);
        Posicion posicionCastillo8 = new Posicion(11,4);
        Posicion posicionCastillo9 = new Posicion(12,1);
        Posicion posicionCastillo10 = new Posicion(12,2);
        Posicion posicionCastillo11 = new Posicion(12,3);
        Posicion posicionCastillo12 = new Posicion(12,4);
        Posicion posicionCastillo13 = new Posicion(13,1);
        Posicion posicionCastillo14 = new Posicion(13,2);
        Posicion posicionCastillo15 = new Posicion(13,3);
        Posicion posicionCastillo16 = new Posicion(13,4);
        ArrayList<Posicion> posicionesCastillo = new ArrayList<>();
        posicionesCastillo.add(posicionCastillo1);
        posicionesCastillo.add(posicionCastillo2);
        posicionesCastillo.add(posicionCastillo3);
        posicionesCastillo.add(posicionCastillo4);
        posicionesCastillo.add(posicionCastillo5);
        posicionesCastillo.add(posicionCastillo6);
        posicionesCastillo.add(posicionCastillo7);
        posicionesCastillo.add(posicionCastillo8);
        posicionesCastillo.add(posicionCastillo9);
        posicionesCastillo.add(posicionCastillo10);
        posicionesCastillo.add(posicionCastillo11);
        posicionesCastillo.add(posicionCastillo12);
        posicionesCastillo.add(posicionCastillo13);
        posicionesCastillo.add(posicionCastillo14);
        posicionesCastillo.add(posicionCastillo15);
        posicionesCastillo.add(posicionCastillo16);
        castilloAtaque.setPosiciones(posicionesCastillo);
        edificios.add(castilloAtaque);

        castillo.atacarEdificios(edificios);
        Assert.assertEquals(cuartel.getVida(),230);
        Assert.assertEquals(plaza.getVida(),430);
        Assert.assertEquals(castilloAtaque.getVida(),1000);

    }
}
