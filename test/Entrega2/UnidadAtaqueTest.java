package Entrega2;

import Modelo.Edificios.Castillo;
import Modelo.Edificios.Cuartel;
import Modelo.Edificios.PlazaCentral;
import Modelo.Exceptions.ArmaDeAsedioNoAtacaUnidadException;
import Modelo.Exceptions.EntidadFueraDeRangoException;
import Modelo.Exceptions.UnidadDesarmadaException;
import Modelo.Exceptions.UnidadEstaOcupadoException;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import Modelo.Unidades.ArmaDeAsedio;
import Modelo.Unidades.Arquero;
import Modelo.Unidades.Espadachin;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class UnidadAtaqueTest {
    //Pruebas espadachin
    @Test
    public void espadachinAtacarAldeanoEnRangoYBajaVida(){
        Aldeano aldeano = new Aldeano();
        Posicion posAldeano = new Posicion(1,1);
        aldeano.setPosicion(posAldeano);
        Espadachin espadachin = new Espadachin();
        Posicion posEspadachin = new Posicion(1,2);
        espadachin.setPosicion(posEspadachin);
        Assert.assertEquals(50,aldeano.getVida());
        espadachin.atacar(aldeano);
        Assert.assertEquals(25,aldeano.getVida());
    }
    @Test (expected = UnidadEstaOcupadoException.class)
    public void espadachinAtacarAldeanoEnRangoSeOcupa(){
        Aldeano aldeano = new Aldeano();
        Posicion posAldeano = new Posicion(1,1);
        aldeano.setPosicion(posAldeano);
        Espadachin espadachin = new Espadachin();
        Posicion posEspadachin = new Posicion(1,2);
        espadachin.setPosicion(posEspadachin);
        espadachin.atacar(aldeano);
        espadachin.atacar(aldeano);
    }

    @Test
    public void espadachinAtacarEspadachinEnRangoYBajaVida(){
        Espadachin espadachin = new Espadachin();
        Posicion posEspadachin = new Posicion(1,2);
        espadachin.setPosicion(posEspadachin);
        Espadachin espadachin2 = new Espadachin();
        Posicion posEspadachin2 = new Posicion(1,3);
        espadachin2.setPosicion(posEspadachin2);
        espadachin.atacar(espadachin2);
        Assert.assertEquals(75, espadachin2.getVida());
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void espadachinAtacarArqueroEnRangoSeOcupa(){
        Espadachin espadachin = new Espadachin();
        Posicion posEspadachin = new Posicion(1,2);
        espadachin.setPosicion(posEspadachin);
        Arquero arquero = new Arquero();
        Posicion pos = new Posicion(1,1);
        arquero.setPosicion(pos);
        espadachin.atacar(arquero);
        Posicion destino = new Posicion(1,3);
        espadachin.mover(destino);
    }

    @Test
    public void espadachinAtacarArqueroEnRangoBajaVida(){
        Espadachin espadachin = new Espadachin();
        Posicion posEspadachin = new Posicion(1,2);
        espadachin.setPosicion(posEspadachin);
        Arquero arquero = new Arquero();
        Posicion pos = new Posicion(1,1);
        arquero.setPosicion(pos);
        espadachin.atacar(arquero);
        Assert.assertEquals(50, arquero.getVida());
    }

    @Test
    public void espadachinAtacarArmaAsedioEnRangoBajaVida(){
        Espadachin espadachin = new Espadachin();
        Posicion posEspadachin = new Posicion(1,2);
        espadachin.setPosicion(posEspadachin);
        ArmaDeAsedio arma = new ArmaDeAsedio();
        Posicion pos = new Posicion(1,1);
        arma.setPosicion(pos);
        espadachin.atacar(arma);
        Assert.assertEquals(125, arma.getVida());
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void espadachinAtacarArmaAsedioEnRangoSeOcupa(){
        Espadachin espadachin = new Espadachin();
        Posicion posEspadachin = new Posicion(1,2);
        espadachin.setPosicion(posEspadachin);
        ArmaDeAsedio arma = new ArmaDeAsedio();
        Posicion pos = new Posicion(1,1);
        arma.setPosicion(pos);
        espadachin.atacar(arma);
        Posicion destino = new Posicion(1,3);
        espadachin.mover(destino);
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void espadachinAtacarCuartelEnRangoSeOcupa() {
        Cuartel cuartel = new Cuartel();
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
        Espadachin espadachin = new Espadachin();
        Posicion posicion5 = new Posicion(1, 3);
        espadachin.setPosicion(posicion5);
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        Assert.assertEquals(250, cuartel.getVida());
        espadachin.atacar(cuartel);
        Posicion destino = new Posicion(1,1);
        espadachin.mover(destino);
    }

    @Test
    public void espadachinAtacarCuartelEnRangoBajaVida(){
        Espadachin espadachin = new Espadachin();
        Posicion posEspadachin = new Posicion(1,3);
        espadachin.setPosicion(posEspadachin);
        Cuartel cuartel = new Cuartel();
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
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        Assert.assertEquals(250, cuartel.getVida());
        espadachin.atacar(cuartel);
        Assert.assertEquals(235, cuartel.getVida());
    }

    @Test
    public void espadachinAtacarPlazaCentralEnRangoBajaVida(){
        Espadachin espadachin = new Espadachin();
        Posicion posEspadachin = new Posicion(1,3);
        espadachin.setPosicion(posEspadachin);
        PlazaCentral plaza = new PlazaCentral();
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
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        Assert.assertEquals(450, plaza.getVida());
        espadachin.atacar(plaza);
        Assert.assertEquals(435, plaza.getVida());
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void espadachinAtacarPlazaCentralEnRangoSeOcupa(){
        PlazaCentral plaza = new PlazaCentral();
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
        Espadachin espadachin = new Espadachin();
        Posicion posicion5 = new Posicion(1, 3);
        espadachin.setPosicion(posicion5);
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        Assert.assertEquals(450, plaza.getVida());
        espadachin.atacar(plaza);
        Posicion destino = new Posicion(1,1);
        espadachin.mover(destino);
    }

    @Test (expected = EntidadFueraDeRangoException.class)
    public void espadachinAtacarUnidadFueraDeRango(){
        Aldeano aldeano = new Aldeano();
        Posicion posAldeano = new Posicion(1,1);
        aldeano.setPosicion(posAldeano);
        Espadachin espadachin = new Espadachin();
        Posicion posEspadachin = new Posicion(1,10);
        espadachin.setPosicion(posEspadachin);
        Assert.assertEquals(50,aldeano.getVida());
        espadachin.atacar(aldeano);
    }

    @Test
    public void espadachinAtacarCastilloEnRango(){
        Espadachin espadachin = new Espadachin();
        Posicion posEspadachin = new Posicion(5,5);
        espadachin.setPosicion(posEspadachin);
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
        espadachin.atacar(castillo);
        Assert.assertEquals(985, castillo.getVida());
    }
    @Test (expected = UnidadEstaOcupadoException.class)
    public void espadachinAtacarCastilloEnRangoSeOcupa(){
        Espadachin espadachin = new Espadachin();
        Posicion posEspadachin = new Posicion(5,5);
        espadachin.setPosicion(posEspadachin);
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
        espadachin.atacar(castillo);
        Posicion pos = new Posicion(5,6);
        espadachin.mover(pos);
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void espadachinAtacarEdificioEstandoOcupadoFalla(){
        Espadachin espadachin = new Espadachin();
        Posicion origen = new Posicion(5,4);
        Posicion destino = new Posicion(4,4);
        espadachin.setPosicion(origen);
        espadachin.mover(destino);
        PlazaCentral plaza = new PlazaCentral();
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
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        espadachin.atacar(plaza);
    }

    @Test ( expected = EntidadFueraDeRangoException.class)
    public void espadachinAtacarEdificioFueraDeRangoFalla(){
        PlazaCentral plaza = new PlazaCentral();
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
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        Espadachin espadachin = new Espadachin();
        Posicion origen = new Posicion(10,10);
        espadachin.setPosicion(origen);
        espadachin.atacar(plaza);
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void espadachinAtacarDosVecesMismoTurnofalla(){
        Espadachin espadachin = new Espadachin();
        Posicion origen = new Posicion(5,4);
        espadachin.setPosicion(origen);
        Aldeano aldeano = new Aldeano();
        Posicion posAldeano = new Posicion(5,5);
        aldeano.setPosicion(posAldeano);
        espadachin.atacar(aldeano);
        espadachin.atacar(aldeano);
    }

    //Pruebas arquero

    @Test
    public void arqueroAtacarAldeanoEnRangoYBajaVida(){
        Aldeano aldeano = new Aldeano();
        Posicion posAldeano = new Posicion(1,1);
        aldeano.setPosicion(posAldeano);
        Arquero arquero = new Arquero();
        Posicion posArquero = new Posicion(1,2);
        arquero.setPosicion(posArquero);
        Assert.assertEquals(50,aldeano.getVida());
        arquero.atacar(aldeano);
        Assert.assertEquals(35,aldeano.getVida());
    }
    @Test (expected = UnidadEstaOcupadoException.class)
    public void arqueroAtacarAldeanoEnRangoSeOcupa(){
        Aldeano aldeano = new Aldeano();
        Posicion posAldeano = new Posicion(1,1);
        aldeano.setPosicion(posAldeano);
        Arquero arquero = new Arquero();
        Posicion posArquero = new Posicion(1,2);
        arquero.setPosicion(posArquero);
        arquero.atacar(aldeano);
        arquero.atacar(aldeano);
    }

    @Test
    public void arqueroAtacarArqueroEnRangoYBajaVida(){
        Arquero arquero = new Arquero();
        Posicion posArquero = new Posicion(1,2);
        arquero.setPosicion(posArquero);
        Arquero arquero2 = new Arquero();
        Posicion posArquero2 = new Posicion(1,3);
        arquero2.setPosicion(posArquero2);
        arquero.atacar(arquero2);
        Assert.assertEquals(60, arquero2.getVida());
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void arqueroAtacarArqueroEnRangoSeOcupa(){
        Arquero arquero = new Arquero();
        Posicion posArquero = new Posicion(1,2);
        arquero.setPosicion(posArquero);
        Arquero arquero2 = new Arquero();
        Posicion pos2 = new Posicion(1,1);
        arquero2.setPosicion(pos2);
        arquero.atacar(arquero2);
        Posicion destino = new Posicion(1,3);
        arquero.mover(destino);
    }

    @Test
    public void arqueroAtacarEspadachinEnRangoBajaVida(){
        Arquero arquero = new Arquero();
        Posicion posArquero = new Posicion(1,2);
        arquero.setPosicion(posArquero);
        Espadachin espadachin = new Espadachin();
        Posicion posEspadachin = new Posicion(1,1);
        espadachin.setPosicion(posEspadachin);
        arquero.atacar(espadachin);
        Assert.assertEquals(85, espadachin.getVida());
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void arqueroAtacarEspadachinEnRangoSeOcupa(){
        Arquero arquero = new Arquero();
        Posicion posArquero = new Posicion(1,2);
        arquero.setPosicion(posArquero);
        Espadachin espadachin = new Espadachin();
        Posicion posEspadachin = new Posicion(1,1);
        espadachin.setPosicion(posEspadachin);
        arquero.atacar(espadachin);
        Posicion destino = new Posicion(2,2);
        arquero.mover(destino);
    }

    @Test
    public void arqueroAtacarArmaAsedioEnRangoBajaVida(){
        Arquero arquero = new Arquero();
        Posicion posArquero = new Posicion(1,2);
        arquero.setPosicion(posArquero);
        ArmaDeAsedio arma = new ArmaDeAsedio();
        Posicion pos = new Posicion(1,1);
        arma.setPosicion(pos);
        arquero.atacar(arma);
        Assert.assertEquals(135, arma.getVida());
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void arqueroAtacarArmaAsedioEnRangoSeOcupa(){
        Arquero arquero = new Arquero();
        Posicion posArquero = new Posicion(1,2);
        arquero.setPosicion(posArquero);
        ArmaDeAsedio arma = new ArmaDeAsedio();
        Posicion pos = new Posicion(1,1);
        arma.setPosicion(pos);
        arquero.atacar(arma);
        Posicion destino = new Posicion(1,3);
        arquero.mover(destino);
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void arqueroAtacarCuartelEnRangoSeOcupa() {
        Cuartel cuartel = new Cuartel();
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
        Arquero arquero = new Arquero();
        Posicion posicion5 = new Posicion(1, 3);
        arquero.setPosicion(posicion5);
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        Assert.assertEquals(250, cuartel.getVida());
        arquero.atacar(cuartel);
        Posicion destino = new Posicion(1,1);
        arquero.mover(destino);
    }

    @Test
    public void arqueroAtacarCuartelEnRangoBajaVida(){
        Arquero arquero = new Arquero();
        Posicion posArquero = new Posicion(1,3);
        arquero.setPosicion(posArquero);
        Cuartel cuartel = new Cuartel();
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
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        cuartel.construir();
        cuartel.volverAEstadoOriginal();
        Assert.assertEquals(250, cuartel.getVida());
        arquero.atacar(cuartel);
        Assert.assertEquals(240, cuartel.getVida());
    }

    @Test
    public void arqueroAtacarPlazaCentralEnRangoBajaVida(){
        Arquero arquero = new Arquero();
        Posicion posArquero = new Posicion(1,3);
        arquero.setPosicion(posArquero);
        PlazaCentral plaza = new PlazaCentral();
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
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        Assert.assertEquals(450, plaza.getVida());
        arquero.atacar(plaza);
        Assert.assertEquals(440, plaza.getVida());
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void arqueroAtacarPlazaCentralEnRangoSeOcupa(){
        PlazaCentral plaza = new PlazaCentral();
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
        Arquero arquero = new Arquero();
        Posicion posicion5 = new Posicion(1, 3);
        arquero.setPosicion(posicion5);
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        Assert.assertEquals(450, plaza.getVida());
        arquero.atacar(plaza);
        Posicion destino = new Posicion(1,1);
        arquero.mover(destino);
    }

    @Test (expected = EntidadFueraDeRangoException.class)
    public void arqueroAtacarUnidadFueraDeRango(){
        Aldeano aldeano = new Aldeano();
        Posicion posAldeano = new Posicion(1,1);
        aldeano.setPosicion(posAldeano);
        Arquero arquero = new Arquero();
        Posicion posArquero = new Posicion(1,10);
        arquero.setPosicion(posArquero);
        Assert.assertEquals(50,aldeano.getVida());
        arquero.atacar(aldeano);
    }

    @Test
    public void arqueroAtacarCastilloEnRango(){
        Arquero arquero = new Arquero();
        Posicion posArquero = new Posicion(5,5);
        arquero.setPosicion(posArquero);
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
        arquero.atacar(castillo);
        Assert.assertEquals(990, castillo.getVida());
    }
    @Test (expected = UnidadEstaOcupadoException.class)
    public void arqueroAtacarCastilloEnRangoSeOcupa(){
        Arquero arquero = new Arquero();
        Posicion posArquero = new Posicion(5,5);
        arquero.setPosicion(posArquero);
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
        arquero.atacar(castillo);
        Posicion pos = new Posicion(5,6);
        arquero.mover(pos);
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void arqueroAtacarEdificioEstandoOcupadoFalla(){
        Arquero arquero = new Arquero();
        Posicion origen = new Posicion(1,1);
        arquero.setPosicion(origen);
        PlazaCentral plaza = new PlazaCentral();
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
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        Posicion destino = new Posicion(1,2);
        arquero.mover(destino);
        arquero.atacar(plaza);
    }

    @Test (expected = EntidadFueraDeRangoException.class)
    public void arqueroAtacarEdificioFueraDeRangoFalla(){
        Arquero arquero = new Arquero();
        Posicion origen = new Posicion(10,10);
        arquero.setPosicion(origen);
        PlazaCentral plaza = new PlazaCentral();
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
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        arquero.atacar(plaza);
    }

    //Pruebas ArmaDeAsedio


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
        Cuartel cuartel = new Cuartel();
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
        Posicion destino = new Posicion(1,1);
        armaAsedio.mover(destino);
    }

    @Test
    public void armaAsedioAtacarCuartelEnRangoBajaVida(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posArmaDeAsedio = new Posicion(1,3);
        armaAsedio.setPosicion(posArmaDeAsedio);
        armaAsedio.montar();
        armaAsedio.desocupar();
        Cuartel cuartel = new Cuartel();
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
        Cuartel cuartel = new Cuartel();
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
        Cuartel cuartel = new Cuartel();
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
        Cuartel cuartel = new Cuartel();
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
        PlazaCentral plaza = new PlazaCentral();
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
        PlazaCentral plaza = new PlazaCentral();
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
        Posicion destino = new Posicion(1,1);
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
        PlazaCentral plaza = new PlazaCentral();
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
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        plaza.construir();
        plaza.volverAEstadoOriginal();
        armaAsedio.atacar(plaza);
    }
}
