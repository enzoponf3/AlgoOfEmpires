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
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(5, 7);
        armaAsedio.setPosicion(posicion);
        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
    }

    @Test
    public void crearArmaDeAsedioYVerificarVidaCorrespondiente() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Assert.assertEquals(150, armaAsedio.getVida());
    }

    @Test
    public void crearArmaDeAsedioYVerificarCostoCorrespondiente() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Assert.assertEquals(200, armaAsedio.getCosto());
    }

    //Pruebas Mov

    @Test
    public void moverArmaDeAsedioUnaUnidadArribaExitosamente() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(4, 5);
        armaAsedio.setPosicion(posicion);
        Posicion destino = new Posicion(4, 6);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));
    }

    @Test
    public void moverArmaDeAsedioUnaUnidadIzquierdaExitosamente() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(4, 5);
        armaAsedio.setPosicion(posicion);
        Posicion destino = new Posicion(3, 5);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));
    }

    @Test
    public void moverArmaDeAsedioUnaUnidadDerechaExitosamente() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(4, 5);
        armaAsedio.setPosicion(posicion);
        Posicion destino = new Posicion(5, 5);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));

    }

    @Test
    public void moverArmaDeAsedioUnaUnidadAbajoExitosamente() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(4, 5);
        armaAsedio.setPosicion(posicion);
        Posicion destino = new Posicion(4, 4);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));

    }

    @Test
    public void moverArmaDeAsedioUnaUnidadAbajoIzquierdaExitosamente() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(4, 5);
        armaAsedio.setPosicion(posicion);
        Posicion destino = new Posicion(3, 4);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));

    }

    @Test
    public void moverArmaDeAsedioUnaUnidadAbajoDerechaExitosamente() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(4, 5);
        armaAsedio.setPosicion(posicion);
        Posicion destino = new Posicion(5, 4);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));

    }

    @Test
    public void moverArmaDeAsedioUnaUnidadArribaIzquierdaExitosamente() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(4, 5);
        armaAsedio.setPosicion(posicion);
        Posicion destino = new Posicion(3, 6);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));

    }

    @Test
    public void moverArmaDeAsedioUnaUnidadaArribaDerechaExitosamente() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(4, 5);
        armaAsedio.setPosicion(posicion);
        Posicion destino = new Posicion(5, 6);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));
    }

    @Test
    public void moverEnDosTurnosDistintos(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion origen = new Posicion(1,1);
        armaAsedio.setPosicion(origen);
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
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(1, 1);
        armaAsedio.setPosicion(posicion);
        Posicion destino1 = new Posicion(0, 1);
        Posicion destino2 = new Posicion(1, 1);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino1);
        armaAsedio.mover(destino2);
    }

    @Test(expected = UnidadEstaMontadaException.class)
    public void moverArmaDeAsedioMontadaFalla() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion origen = new Posicion(1, 1);
        armaAsedio.setPosicion(origen);
        armaAsedio.montar();
        Posicion destino = new Posicion(1, 2);
        armaAsedio.desocupar();
        armaAsedio.mover(destino);
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void moverArmaDeAsedioMontadaEnMismoTurnoFalla() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion origen = new Posicion(1, 1);
        armaAsedio.setPosicion(origen);
        armaAsedio.montar();
        Posicion destino = new Posicion(1, 2);
        armaAsedio.mover(destino);
    }
    @Test(expected = UnidadEstaOcupadoException.class)
    public void montarArmaDeAsedioMontadaEnMismoTurnoFalla() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion origen = new Posicion(1, 1);
        armaAsedio.setPosicion(origen);
        armaAsedio.montar();
        armaAsedio.montar();
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void armaDeAsedioDesmontarYMoverEnUnMismoTurnoFalla() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion origen = new Posicion(1, 1);
        armaAsedio.setPosicion(origen);
        armaAsedio.montar();
        armaAsedio.desocupar();
        armaAsedio.desmontar();
        Posicion destino = new Posicion(1, 2);
        armaAsedio.mover(destino);
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void armaDeAsedioMontarYDesmontarEnMismoTurnoFalla() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion origen = new Posicion(5, 5);
        armaAsedio.setPosicion(origen);
        armaAsedio.montar();
        armaAsedio.desmontar();
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void armaDeAsedioDesmontarYMontarEnMismoTurnoFalla() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion origen = new Posicion(5, 5);
        armaAsedio.setPosicion(origen);
        armaAsedio.montar();
        armaAsedio.desocupar();
        armaAsedio.desmontar();
        armaAsedio.montar();
    }

    @Test(expected = UnidadEstaMontadaException.class)
    public void armaDeAsedioMontarYaMontadoFalla() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion origen = new Posicion(5, 5);
        armaAsedio.setPosicion(origen);
        armaAsedio.montar();
        armaAsedio.desocupar();
        armaAsedio.montar();
    }
    @Test(expected = UnidadDesarmadaException.class)
    public void armaDeAsedioDesmontarYaDesmontadoFalla() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion origen = new Posicion(5, 5);
        armaAsedio.setPosicion(origen);
        armaAsedio.desmontar();
        armaAsedio.desocupar();
        armaAsedio.desmontar();
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void armaAsedioDesmontarHabiendoMovidoFalla(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion origen = new Posicion(5, 5);
        armaAsedio.setPosicion(origen);
        Posicion destino = new Posicion(5,6);
        armaAsedio.mover(destino);
        armaAsedio.desmontar();
    }

    @Test (expected = DestinoNoEsAledanioException.class)
    public void moverArmaDeAsedioPosicionNoAdyacenteFalla(){
        ArmaDeAsedio arma = new ArmaDeAsedio();
        Posicion posicion = new Posicion(1,1);
        arma.setPosicion(posicion);
        Posicion posicion2 = new Posicion(1,4);
        arma.mover(posicion2);
    }

    //Pruebas atacar

    @Test (expected = ArmaDeAsedioNoAtacaUnidadException.class)
    public void armaDeAsedioAtacarUnidadFalla(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posicion5 = new Posicion(1, 3);
        armaAsedio.setPosicion(posicion5);
        armaAsedio.montar();
        armaAsedio.desocupar();
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(1,4);
        aldeano.setPosicion(posicion);
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
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posicion5 = new Posicion(1, 3);
        armaAsedio.setPosicion(posicion5);
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
        Posicion destino = new Posicion(1,2);
        armaAsedio.mover(destino);
    }

    @Test
    public void armaAsedioAtacarCuartelEnRangoBajaVida(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posArmaDeAsedio = new Posicion(1,3);
        armaAsedio.setPosicion(posArmaDeAsedio);
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
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(1,1);
        armaDeAsedio.setPosicion(posicion);
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
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(1,1);
        armaDeAsedio.setPosicion(posicion);
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
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(1,1);
        armaDeAsedio.setPosicion(posicion);
        Posicion destino = new Posicion(1,2);
        armaDeAsedio.mover(destino);
        armaDeAsedio.atacar(cuartel);
    }

    @Test
    public void armaAsedioAtacarPlazaCentralEnRangoBajaVida(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posArmaDeAsedio = new Posicion(1,3);
        armaAsedio.setPosicion(posArmaDeAsedio);
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
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posicion5 = new Posicion(1, 3);
        armaAsedio.setPosicion(posicion5);
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
        Posicion destino = new Posicion(1,2);
        armaAsedio.mover(destino);
    }

    @Test
    public void armaAsedioAtacarCastilloEnRango(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posArmaDeAsedio = new Posicion(5,5);
        armaAsedio.setPosicion(posArmaDeAsedio);
        armaAsedio.montar();
        armaAsedio.desocupar();
        Castillo castillo = new Castillo();
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
        Assert.assertEquals(1000, castillo.getVida());
        armaAsedio.atacar(castillo);
        Assert.assertEquals(925, castillo.getVida());
    }
    @Test (expected = UnidadEstaOcupadoException.class)
    public void armaAsedioAtacarCastilloEnRangoSeOcupa(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posArmaDeAsedio = new Posicion(5,5);
        armaAsedio.setPosicion(posArmaDeAsedio);
        armaAsedio.montar();
        armaAsedio.desocupar();
        Castillo castillo = new Castillo();
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
        Assert.assertEquals(1000, castillo.getVida());
        armaAsedio.atacar(castillo);
        Posicion pos = new Posicion(5,6);
        armaAsedio.mover(pos);
    }

    @Test (expected = EntidadFueraDeRangoException.class)
    public void armaAsedioAtacarEdificioFueraDeRangoFalla(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posArmaDeAsedio = new Posicion(10,10);
        armaAsedio.setPosicion(posArmaDeAsedio);
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
