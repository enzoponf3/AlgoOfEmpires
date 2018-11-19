package Entrega1;

import Modelo.Edificios.Castillo;
import Modelo.Edificios.Cuartel;
import Modelo.Edificios.PlazaCentral;
import Modelo.Exceptions.*;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class RepararTest {
    @Test (expected = EdificioConVidaAlMaximoException.class)
    public void AldeanoReparaCuartelConVidaCompletaException(){
        Aldeano aldeano = new Aldeano();
        Posicion origen = new Posicion(2,3);
        aldeano.setPosicion(origen);
        Cuartel cuartel = aldeano.construirCuartel();
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        cuartel.setPosiciones(posiciones);
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        aldeano.repararEdificio(cuartel);
    }

    @Test (expected = EdificioConVidaAlMaximoException.class)
    public void AldeanoReparaPlazaCentralConVidaCompletaException(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(1,6);
        aldeano.setPosicion(posicion);
        PlazaCentral plaza = aldeano.construirPlazaCentral();
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        plaza.setPosiciones(posiciones);
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        aldeano.repararEdificio(plaza);
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void AldeanoReparaCuartelYSeVerificaSuEstado(){
        Aldeano aldeano = new Aldeano();
        Posicion origen = new Posicion(2,6);
        aldeano.setPosicion(origen);
        Cuartel cuartel = aldeano.construirCuartel();
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        cuartel.setPosiciones(posiciones);
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        cuartel.reducirVida(60);
        aldeano.repararEdificio(cuartel);
        Posicion destino = new Posicion(2,3);
        aldeano.mover(destino);
    }

    @Test
    public void AldeanoReparaCuartelYSeVerificaAumentoVida(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(2,6);
        aldeano.setPosicion(posicion);
        Cuartel cuartel = aldeano.construirCuartel();
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        cuartel.setPosiciones(posiciones);
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        Assert.assertEquals(250,cuartel.getVida());
        cuartel.reducirVida(50);
        Assert.assertEquals(200,cuartel.getVida());
        aldeano.repararEdificio(cuartel);
        Assert.assertEquals(250,cuartel.getVida());
    }

    @Test
    public void AldeanoReparaCuartelNoGeneraOro(){
        Aldeano aldeano = new Aldeano();
        Posicion origen = new Posicion(3,6);
        aldeano.setPosicion(origen);
        Cuartel cuartel = aldeano.construirCuartel();
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        cuartel.setPosiciones(posiciones);
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        cuartel.reducirVida(50);
        Assert.assertEquals(200,cuartel.getVida());
        aldeano.repararEdificio(cuartel);
        Assert.assertEquals(0,aldeano.generaOro());
    }

    @Test
    public void AldeanoReparaPlazaCentralNoGeneraOro(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(3,6);
        aldeano.setPosicion(posicion);
        PlazaCentral plaza = aldeano.construirPlazaCentral();
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        plaza.setPosiciones(posiciones);
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        plaza.reducirVida(50);
        Assert.assertEquals(400,plaza.getVida());
        aldeano.repararEdificio(plaza);
        Assert.assertEquals(0,aldeano.generaOro());
    }

    @Test
    public void AldeanoFinalizaReparacionCuartelYGeneraOro(){
        Aldeano aldeano = new Aldeano();
        Posicion origen = new Posicion(1,6);
        aldeano.setPosicion(origen);
        Cuartel cuartel = aldeano.construirCuartel();
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        cuartel.setPosiciones(posiciones);
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        Assert.assertEquals(250,cuartel.getVida());
        cuartel.reducirVida(50);
        Assert.assertEquals(200,cuartel.getVida());
        aldeano.repararEdificio(cuartel);
        aldeano.desocupar();
        Assert.assertEquals(20, aldeano.generaOro());
    }

    @Test
    public void AldeanoFinalizaReparacionPlazaCentralYGeneraOro(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(4,5);
        aldeano.setPosicion(posicion);
        PlazaCentral plaza = aldeano.construirPlazaCentral();
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        plaza.setPosiciones(posiciones);
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        plaza.reducirVida(50);
        Assert.assertEquals(400,plaza.getVida());
        aldeano.repararEdificio(plaza);
        Assert.assertEquals(0,aldeano.generaOro());
        aldeano.desocupar();
        Assert.assertEquals(20,aldeano.generaOro());
    }


    @Test (expected = UnidadEstaOcupadoException.class)
    public void AldeanoReparaPlazaCentralYSeVerificaSuEstado(){
        Aldeano aldeano = new Aldeano();
        Posicion inicial = new Posicion(3,3);
        aldeano.setPosicion(inicial);
        PlazaCentral plaza = aldeano.construirPlazaCentral();
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        plaza.setPosiciones(posiciones);
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        plaza.reducirVida(50);
        Assert.assertEquals(400,plaza.getVida());
        aldeano.repararEdificio(plaza);
        Posicion destino = new Posicion(4,3);
        aldeano.mover(destino);
    }

    @Test
    public void AldeanoReparaPlazaCentralYSeVerificaAumentoVida(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(1,6);
        aldeano.setPosicion(posicion);
        PlazaCentral plaza = aldeano.construirPlazaCentral();
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        plaza.setPosiciones(posiciones);
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        Assert.assertEquals(450,plaza.getVida());
        plaza.reducirVida(50);
        Assert.assertEquals(400,plaza.getVida());
        aldeano.repararEdificio(plaza);
        Assert.assertEquals(plaza.getVida(),425);
    }

    @Test (expected = UnidadNoPuedeRepararException.class)
    public void aldeanoRepararPlazaCentralDosVecesEnMismoTurnoFalla(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(2,3);
        aldeano.setPosicion(posicion);
        PlazaCentral plaza = aldeano.construirPlazaCentral();
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        plaza.setPosiciones(posiciones);
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        plaza.reducirVida(100);
        aldeano.repararEdificio(plaza);
        aldeano.repararEdificio(plaza);
    }

    @Test (expected = UnidadNoPuedeRepararException.class)
    public void aldeanoRepararCuartellDosVecesEnMismoTurnoFalla(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(1,6);
        aldeano.setPosicion(posicion);
        Cuartel cuartel = aldeano.construirCuartel();
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        cuartel.setPosiciones(posiciones);
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        cuartel.reducirVida(100);
        aldeano.repararEdificio(cuartel);
        aldeano.repararEdificio(cuartel);
    }

    @Test (expected = EntidadFueraDeRangoException.class)
    public void aldeanoRepararCuartelFueraDeRango(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(1,99);
        aldeano.setPosicion(posicion);
        Cuartel cuartel = aldeano.construirCuartel();
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        cuartel.setPosiciones(posiciones);
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        cuartel.reducirVida(100);
        aldeano.repararEdificio(cuartel);
    }

    @Test (expected = EntidadFueraDeRangoException.class)
    public void aldeanoRepararPlazaCentralFueraDeRango(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(1,99);
        aldeano.setPosicion(posicion);
        PlazaCentral plaza = aldeano.construirPlazaCentral();
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        plaza.setPosiciones(posiciones);
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        plaza.reducirVida(100);
        aldeano.repararEdificio(plaza);
    }

    @Test
    public void aldeanoRepararCastilloExitosamente(){
        Aldeano aldeano = new Aldeano();
        Posicion origen = new Posicion(4,5);
        aldeano.setPosicion(origen);
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
        castillo.reducirVida(50);
        aldeano.repararEdificio(castillo);
        Assert.assertEquals(965,castillo.getVida());
    }

    @Test (expected = UnidadNoPuedeRepararException.class)
    public void aldeanoOcupadoRepararCastilloFalla(){
        Aldeano aldeano = new Aldeano();
        Posicion origen = new Posicion(4,6);
        aldeano.setPosicion(origen);
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
        castillo.reducirVida(50);
        Posicion destino = new Posicion(4,5);
        aldeano.mover(destino);
        aldeano.repararEdificio(castillo);
    }


}
