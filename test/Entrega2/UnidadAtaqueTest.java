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
        Posicion posAldeano = new Posicion(1,1);
        Aldeano aldeano = new Aldeano(posAldeano);

        Posicion posEspadachin = new Posicion(1,2);
        Espadachin espadachin = new Espadachin(posEspadachin);
        Assert.assertEquals(50,aldeano.getVida());
        espadachin.atacar(aldeano);
        Assert.assertEquals(25,aldeano.getVida());
    }
    @Test (expected = UnidadEstaOcupadoException.class)
    public void espadachinAtacarAldeanoEnRangoSeOcupa(){
        Posicion posAldeano = new Posicion(1,1);
        Aldeano aldeano = new Aldeano(posAldeano);

        Posicion posEspadachin = new Posicion(1,2);
        Espadachin espadachin = new Espadachin(posEspadachin);

        espadachin.atacar(aldeano);
        espadachin.atacar(aldeano);
    }

    @Test
    public void espadachinAtacarEspadachinEnRangoYBajaVida(){
        Posicion posEspadachin = new Posicion(1,2);
        Espadachin espadachin = new Espadachin(posEspadachin);

        Posicion posEspadachin2 = new Posicion(1,3);
        Espadachin espadachin2 = new Espadachin(posEspadachin2);

        espadachin.atacar(espadachin2);
        Assert.assertEquals(75, espadachin2.getVida());
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void espadachinAtacarArqueroEnRangoSeOcupa(){
        Posicion posEspadachin = new Posicion(1,2);
        Espadachin espadachin = new Espadachin(posEspadachin);
        Posicion pos = new Posicion(1,1);
        Arquero arquero = new Arquero(pos);
        espadachin.atacar(arquero);
        Posicion destino = new Posicion(1,3);
        espadachin.mover(destino);
    }

    @Test
    public void espadachinAtacarArqueroEnRangoBajaVida(){
        Posicion posEspadachin = new Posicion(1,2);
        Espadachin espadachin = new Espadachin(posEspadachin);
        Posicion pos = new Posicion(1,1);
        Arquero arquero = new Arquero(pos);
        espadachin.atacar(arquero);
        Assert.assertEquals(50, arquero.getVida());
    }

    @Test
    public void espadachinAtacarArmaAsedioEnRangoBajaVida(){
        Posicion posEspadachin = new Posicion(1,2);
        Espadachin espadachin = new Espadachin(posEspadachin);
        Posicion pos = new Posicion(1,1);
        ArmaDeAsedio arma = new ArmaDeAsedio(pos);
        espadachin.atacar(arma);
        Assert.assertEquals(125, arma.getVida());
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void espadachinAtacarArmaAsedioEnRangoSeOcupa(){
        Posicion posEspadachin = new Posicion(1,2);
        Espadachin espadachin = new Espadachin(posEspadachin);
        Posicion pos = new Posicion(1,1);
        ArmaDeAsedio arma = new ArmaDeAsedio(pos);
        espadachin.atacar(arma);
        Posicion destino = new Posicion(1,3);
        espadachin.mover(destino);
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void espadachinAtacarCuartelEnRangoSeOcupa() {
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
        Espadachin espadachin = new Espadachin(posicion5);
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
        Posicion posEspadachin = new Posicion(1,3);
        Espadachin espadachin = new Espadachin(posEspadachin);
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
        espadachin.atacar(cuartel);
        Assert.assertEquals(235, cuartel.getVida());
    }

    @Test
    public void espadachinAtacarPlazaCentralEnRangoBajaVida(){
        Posicion posEspadachin = new Posicion(1,3);
        Espadachin espadachin = new Espadachin(posEspadachin);
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
        espadachin.atacar(plaza);
        Assert.assertEquals(435, plaza.getVida());
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void espadachinAtacarPlazaCentralEnRangoSeOcupa(){
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
        Espadachin espadachin = new Espadachin(posicion5);
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
        Posicion posAldeano = new Posicion(1,1);
        Aldeano aldeano = new Aldeano(posAldeano);

        Posicion posEspadachin = new Posicion(1,10);
        Espadachin espadachin = new Espadachin(posEspadachin);
        Assert.assertEquals(50,aldeano.getVida());
        espadachin.atacar(aldeano);
    }

    @Test
    public void espadachinAtacarCastilloEnRango(){
        Posicion posEspadachin = new Posicion(5,5);

        Espadachin espadachin = new Espadachin(posEspadachin);

        ArrayList<Posicion> posiciones = new ArrayList<>();
        for( int i=0; i<5; i++){
            for( int j=0; j<5; j++){
                Posicion posicion = new Posicion(i, j);
                posiciones.add(posicion);
            }
        }
        Castillo castillo = new Castillo(posiciones);

        Assert.assertEquals(1000, castillo.getVida());
        espadachin.atacar(castillo);
        Assert.assertEquals(985, castillo.getVida());
    }
    @Test (expected = UnidadEstaOcupadoException.class)
    public void espadachinAtacarCastilloEnRangoSeOcupa(){
        Posicion posEspadachin = new Posicion(5,5);
        Espadachin espadachin = new Espadachin(posEspadachin);

        ArrayList<Posicion> posiciones = new ArrayList<>();
        for( int i=0; i<5; i++){
            for( int j=0; j<5; j++){
                Posicion posicion = new Posicion(i, j);
                posiciones.add(posicion);
            }
        }

        Castillo castillo = new Castillo(posiciones);

        Assert.assertEquals(1000, castillo.getVida());
        espadachin.atacar(castillo);
        Posicion pos = new Posicion(5,6);
        espadachin.mover(pos);
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void espadachinAtacarEdificioEstandoOcupadoFalla(){
        Posicion origen = new Posicion(5,4);
        Espadachin espadachin = new Espadachin(origen);
        Posicion destino = new Posicion(4,4);
        espadachin.mover(destino);
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
        espadachin.atacar(plaza);
    }

    @Test ( expected = EntidadFueraDeRangoException.class)
    public void espadachinAtacarEdificioFueraDeRangoFalla(){
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
        Posicion origen = new Posicion(10,10);
        Espadachin espadachin = new Espadachin(origen);
        espadachin.atacar(plaza);
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void espadachinAtacarDosVecesMismoTurnofalla(){
        Posicion origen = new Posicion(5,4);
        Espadachin espadachin = new Espadachin(origen);

        Posicion posAldeano = new Posicion(5,5);
        Aldeano aldeano = new Aldeano(posAldeano);


        espadachin.atacar(aldeano);
        espadachin.atacar(aldeano);
    }
    //Pruebas arquero
    @Test
    public void arqueroAtacarAldeanoEnRangoYBajaVida(){
        Posicion posAldeano = new Posicion(1,1);
        Aldeano aldeano = new Aldeano(posAldeano);

        Posicion posArquero = new Posicion(1,2);
        Arquero arquero = new Arquero(posArquero);

        Assert.assertEquals(50,aldeano.getVida());
        arquero.atacar(aldeano);
        Assert.assertEquals(35,aldeano.getVida());
    }
    @Test (expected = UnidadEstaOcupadoException.class)
    public void arqueroAtacarAldeanoEnRangoSeOcupa(){
        Posicion posAldeano = new Posicion(1,1);
        Aldeano aldeano = new Aldeano(posAldeano);

        Posicion posArquero = new Posicion(1,2);
        Arquero arquero = new Arquero(posArquero);

        arquero.atacar(aldeano);
        arquero.atacar(aldeano);
    }

    @Test
    public void arqueroAtacarArqueroEnRangoYBajaVida(){
        Posicion posArquero = new Posicion(1,2);
        Arquero arquero = new Arquero(posArquero);
        Posicion posArquero2 = new Posicion(1,3);
        Arquero arquero2 = new Arquero(posArquero2);
        arquero.atacar(arquero2);
        Assert.assertEquals(60, arquero2.getVida());
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void arqueroAtacarArqueroEnRangoSeOcupa(){
        Posicion posArquero = new Posicion(1,2);
        Arquero arquero = new Arquero(posArquero);
        Posicion pos2 = new Posicion(1,1);
        Arquero arquero2 = new Arquero(pos2);
        arquero.atacar(arquero2);
        Posicion destino = new Posicion(1,3);
        arquero.mover(destino);
    }

    @Test
    public void arqueroAtacarEspadachinEnRangoBajaVida(){
        Posicion posArquero = new Posicion(1,2);
        Arquero arquero = new Arquero(posArquero);
        Posicion posEspadachin = new Posicion(1,1);
        Espadachin espadachin = new Espadachin(posEspadachin);
        arquero.atacar(espadachin);
        Assert.assertEquals(85, espadachin.getVida());
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void arqueroAtacarEspadachinEnRangoSeOcupa(){
        Posicion posArquero = new Posicion(1,2);
        Arquero arquero = new Arquero(posArquero);
        Posicion posEspadachin = new Posicion(1,1);
        Espadachin espadachin = new Espadachin(posEspadachin);
        arquero.atacar(espadachin);
        Posicion destino = new Posicion(2,2);
        arquero.mover(destino);
    }

    @Test
    public void arqueroAtacarArmaAsedioEnRangoBajaVida(){
        Posicion posArquero = new Posicion(1,2);
        Arquero arquero = new Arquero(posArquero);
        Posicion pos = new Posicion(1,1);
        ArmaDeAsedio arma = new ArmaDeAsedio(pos);
        arquero.atacar(arma);
        Assert.assertEquals(135, arma.getVida());
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void arqueroAtacarArmaAsedioEnRangoSeOcupa(){
        Posicion posArquero = new Posicion(1,2);
        Arquero arquero = new Arquero(posArquero);
        Posicion pos = new Posicion(1,1);
        ArmaDeAsedio arma = new ArmaDeAsedio(pos);
        arquero.atacar(arma);
        Posicion destino = new Posicion(1,3);
        arquero.mover(destino);
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void arqueroAtacarCuartelEnRangoSeOcupa() {
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
        Arquero arquero = new Arquero(posicion5);
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
        Posicion posArquero = new Posicion(1,3);
        Arquero arquero = new Arquero(posArquero);
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
        arquero.atacar(cuartel);
        Assert.assertEquals(240, cuartel.getVida());
    }

    @Test
    public void arqueroAtacarPlazaCentralEnRangoBajaVida(){
        Posicion posArquero = new Posicion(1,3);
        Arquero arquero = new Arquero(posArquero);
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
        arquero.atacar(plaza);
        Assert.assertEquals(440, plaza.getVida());
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void arqueroAtacarPlazaCentralEnRangoSeOcupa(){
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
        Arquero arquero = new Arquero(posicion5);
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
        Posicion posAldeano = new Posicion(1,1);
        Aldeano aldeano = new Aldeano(posAldeano);

        Posicion posArquero = new Posicion(1,10);
        Arquero arquero = new Arquero(posArquero);

        Assert.assertEquals(50,aldeano.getVida());
        arquero.atacar(aldeano);
    }

    @Test
    public void arqueroAtacarCastilloEnRango(){
        Posicion posArquero = new Posicion(5,5);
        Arquero arquero = new Arquero(posArquero);
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
        arquero.atacar(castillo);
        Assert.assertEquals(990, castillo.getVida());
    }
    @Test (expected = UnidadEstaOcupadoException.class)
    public void arqueroAtacarCastilloEnRangoSeOcupa(){
        Posicion posArquero = new Posicion(5,5);
        Arquero arquero = new Arquero(posArquero);
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
        arquero.atacar(castillo);
        Posicion pos = new Posicion(5,6);
        arquero.mover(pos);
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void arqueroAtacarEdificioEstandoOcupadoFalla(){
        Posicion origen = new Posicion(1,1);
        Arquero arquero = new Arquero(origen);
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
        Posicion destino = new Posicion(1,2);
        arquero.mover(destino);
        arquero.atacar(plaza);
    }

    @Test (expected = EntidadFueraDeRangoException.class)
    public void arqueroAtacarEdificioFueraDeRangoFalla(){
        Posicion origen = new Posicion(10,10);
        Arquero arquero = new Arquero(origen);

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
        arquero.atacar(plaza);
    }

    //Pruebas ArmaDeAsedio


    @Test (expected = ArmaDeAsedioNoAtacaUnidadException.class)
    public void armaDeAsedioAtacarUnidadFalla(){
        Posicion posicion = new Posicion(1, 3);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(posicion);
        armaAsedio.montar();
        armaAsedio.desocupar();

        Posicion posicion2 = new Posicion(1,4);
        Aldeano aldeano = new Aldeano(posicion2);

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
