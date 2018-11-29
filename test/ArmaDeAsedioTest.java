import Modelo.Edificios.Castillo;
import Modelo.Edificios.Cuartel;
import Modelo.Edificios.PlazaCentral;
import Modelo.Exceptions.*;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import Modelo.Unidades.ArmaDeAsedio;
import Modelo.Unidades.Arquero;
import Modelo.Unidades.Espadachin;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ArmaDeAsedioTest {
    //Pruebas base
    @Test
    public void crearArmaDeAsedioEnPosicionIndicada() {
        Posicion posicion = new Posicion(5, 7);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(posicion);
        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
    }

    @Test
    public void crearArmaDeAsedioYVerificarVidaCorrespondiente() {
        Posicion posicion = new Posicion(5,7);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(posicion);
        Assert.assertEquals(150, armaAsedio.getVida());
    }

    @Test
    public void crearArmaDeAsedioYVerificarCostoCorrespondiente() {
        Posicion posicion = new Posicion(5,7);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(posicion);
        Assert.assertEquals(200, armaAsedio.getCosto());
    }

    //Pruebas Mov

    @Test
    public void moverArmaDeAsedioUnaUnidadArribaExitosamente() {
        Posicion posicion = new Posicion(4, 5);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(posicion);
        Posicion destino = new Posicion(4, 6);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));
    }

    @Test
    public void moverArmaDeAsedioUnaUnidadIzquierdaExitosamente() {
        Posicion posicion = new Posicion(4, 5);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(posicion);
        Posicion destino = new Posicion(3, 5);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));
    }

    @Test
    public void moverArmaDeAsedioUnaUnidadDerechaExitosamente() {
        Posicion posicion = new Posicion(4, 5);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(posicion);
        Posicion destino = new Posicion(5, 5);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));

    }

    @Test
    public void moverArmaDeAsedioUnaUnidadAbajoExitosamente() {
        Posicion posicion = new Posicion(4, 5);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(posicion);
        Posicion destino = new Posicion(4, 4);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));

    }

    @Test
    public void moverArmaDeAsedioUnaUnidadAbajoIzquierdaExitosamente() {
        Posicion posicion = new Posicion(4, 5);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(posicion);
        Posicion destino = new Posicion(3, 4);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));

    }

    @Test
    public void moverArmaDeAsedioUnaUnidadAbajoDerechaExitosamente() {
        Posicion posicion = new Posicion(4, 5);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(posicion);
        Posicion destino = new Posicion(5, 4);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));

    }

    @Test
    public void moverArmaDeAsedioUnaUnidadArribaIzquierdaExitosamente() {
        Posicion posicion = new Posicion(4, 5);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(posicion);
        Posicion destino = new Posicion(3, 6);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));

    }

    @Test
    public void moverArmaDeAsedioUnaUnidadaArribaDerechaExitosamente() {
        Posicion posicion = new Posicion(4, 5);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(posicion);
        Posicion destino = new Posicion(5, 6);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));
    }
    
    @Test
    public void moverEnDosTurnosDistintos(){
        Posicion origen = new Posicion(1,1);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(origen);
        Assert.assertTrue(armaAsedio.estaEnPosicion(origen));
        Posicion destino1 = new Posicion(1,2);
        armaAsedio.mover(destino1);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino1));
        Posicion destino2 = new Posicion(1,3);
        armaAsedio.desocupar();
        armaAsedio.mover(destino2);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino2));
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void moverArmaDeAsedioDosVecesConsecutivasLanzaUnidadEstaOcupadaException() {
        Posicion posicion = new Posicion(1, 1);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(posicion);
        Posicion destino1 = new Posicion(0, 1);
        Posicion destino2 = new Posicion(1, 1);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino1);
        armaAsedio.mover(destino2);
    }

    @Test(expected = UnidadEstaMontadaException.class)
    public void moverArmaDeAsedioMontadaFalla() {
        Posicion origen = new Posicion(1, 1);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(origen);
        armaAsedio.montar();
        Posicion destino = new Posicion(1, 2);
        armaAsedio.desocupar();
        armaAsedio.mover(destino);
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void moverArmaDeAsedioMontadaEnMismoTurnoFalla() {
        Posicion origen = new Posicion(1, 1);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(origen);
        armaAsedio.montar();
        Posicion destino = new Posicion(1, 2);
        armaAsedio.mover(destino);
    }
    @Test(expected = UnidadEstaOcupadoException.class)
    public void montarArmaDeAsedioMontadaEnMismoTurnoFalla() {
        Posicion origen = new Posicion(1, 1);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(origen);
        armaAsedio.montar();
        armaAsedio.montar();
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void armaDeAsedioDesmontarYMoverEnUnMismoTurnoFalla() {
        Posicion origen = new Posicion(1, 1);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(origen);
        armaAsedio.montar();
        armaAsedio.desocupar();
        armaAsedio.desmontar();
        Posicion destino = new Posicion(1, 3);
        armaAsedio.mover(destino);
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void armaDeAsedioMontarYDesmontarEnMismoTurnoFalla() {
        Posicion origen = new Posicion(5, 5);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(origen);
        armaAsedio.montar();
        armaAsedio.desmontar();
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void armaDeAsedioDesmontarYMontarEnMismoTurnoFalla() {
        Posicion origen = new Posicion(5, 5);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(origen);
        armaAsedio.montar();
        armaAsedio.desocupar();
        armaAsedio.desmontar();
        armaAsedio.montar();
    }

    @Test(expected = UnidadEstaMontadaException.class)
    public void armaDeAsedioMontarYaMontadoFalla() {
        Posicion origen = new Posicion(5, 5);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(origen);
        armaAsedio.montar();
        armaAsedio.desocupar();
        armaAsedio.montar();
    }
    @Test(expected = UnidadDesarmadaException.class)
    public void armaDeAsedioDesmontarYaDesmontadoFalla() {
        Posicion origen = new Posicion(5, 5);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(origen);
        armaAsedio.desmontar();
        armaAsedio.desocupar();
        armaAsedio.desmontar();
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void armaAsedioDesmontarHabiendoMovidoFalla(){
        Posicion origen = new Posicion(5, 5);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(origen);
        Posicion destino = new Posicion(5,6);
        armaAsedio.mover(destino);
        armaAsedio.desmontar();
    }

    //Pruebas atacar

    @Test (expected = ArmaDeAsedioNoAtacaUnidadException.class)
    public void armaDeAsedioAtacarUnidadFalla(){
        Posicion posicionArma = new Posicion(1, 3);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(posicionArma);
        armaAsedio.montar();
        armaAsedio.desocupar();
        Posicion posicion = new Posicion(1,4);
        Aldeano aldeano = new Aldeano(posicion);
        armaAsedio.atacar(aldeano);
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void armaAsedioAtacarCuartelEnRangoSeOcupa() {
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
        Posicion posicion5 = new Posicion(1, 3);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(posicion5);
        armaAsedio.montar();
        armaAsedio.desocupar();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        Assert.assertEquals(250, cuartel.getVida());
        armaAsedio.atacar(cuartel);
        Posicion destino = new Posicion(1,1);
        armaAsedio.mover(destino);
    }

    @Test
    public void armaAsedioAtacarCuartelEnRangoBajaVida(){
        Posicion posArmaDeAsedio = new Posicion(1,3);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(posArmaDeAsedio);
        armaAsedio.montar();
        armaAsedio.desocupar();
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
        Assert.assertEquals(250, cuartel.getVida());
        armaAsedio.atacar(cuartel);
        Assert.assertEquals(175, cuartel.getVida());
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void armaAsedioAtacarDosVecesMismoTurnoFalla(){
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
        Posicion posicion = new Posicion(1,1);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicion);
        armaDeAsedio.montar();
        armaDeAsedio.desocupar();
        armaDeAsedio.atacar(cuartel);
        armaDeAsedio.atacar(cuartel);
    }

    @Test (expected = UnidadDesarmadaException.class)
    public void armaAsedioAtacarDesarmadoFalla(){
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
        Posicion posicion = new Posicion(1,1);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicion);
        armaDeAsedio.atacar(cuartel);
    }

    @Test (expected = UnidadDesarmadaException.class)
    public void armaAsedioAtacarDesarmadoLuegoDeMoverFalla(){
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
        Posicion posicion = new Posicion(1,1);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicion);
        Posicion destino = new Posicion(1,2);
        armaDeAsedio.mover(destino);
        armaDeAsedio.atacar(cuartel);
    }

    @Test
    public void armaAsedioAtacarPlazaCentralEnRangoBajaVida(){
        Posicion posArmaDeAsedio = new Posicion(1,3);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(posArmaDeAsedio);
        armaAsedio.montar();
        armaAsedio.desocupar();
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
        Assert.assertEquals(450, plaza.getVida());
        armaAsedio.atacar(plaza);
        Assert.assertEquals(375, plaza.getVida());
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void armaAsedioAtacarPlazaCentralEnRangoSeOcupa(){
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
        Posicion posicion5 = new Posicion(1, 3);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(posicion5);
        armaAsedio.montar();
        armaAsedio.desocupar();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        Assert.assertEquals(450, plaza.getVida());
        armaAsedio.atacar(plaza);
        Posicion destino = new Posicion(1,1);
        armaAsedio.mover(destino);
    }

    @Test
    public void armaAsedioAtacarCastilloEnRango(){
        Posicion posArmaDeAsedio = new Posicion(5,5);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(posArmaDeAsedio);
        armaAsedio.montar();
        armaAsedio.desocupar();
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
        Castillo castillo = new Castillo(posiciones);
        Assert.assertEquals(1000, castillo.getVida());
        armaAsedio.atacar(castillo);
        Assert.assertEquals(925, castillo.getVida());
    }
    @Test (expected = UnidadEstaOcupadoException.class)
    public void armaAsedioAtacarCastilloEnRangoSeOcupa(){
        Posicion posArmaDeAsedio = new Posicion(5,5);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(posArmaDeAsedio);
        armaAsedio.montar();
        armaAsedio.desocupar();
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
        Castillo castillo = new Castillo(posiciones);
        Assert.assertEquals(1000, castillo.getVida());
        armaAsedio.atacar(castillo);
        Posicion pos = new Posicion(5,6);
        armaAsedio.mover(pos);
    }

    @Test (expected = EntidadFueraDeRangoException.class)
    public void armaAsedioAtacarEdificioFueraDeRangoFalla(){
        Posicion posArmaDeAsedio = new Posicion(10,10);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(posArmaDeAsedio);
        armaAsedio.montar();
        armaAsedio.desocupar();
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
        armaAsedio.atacar(plaza);
    }
}
