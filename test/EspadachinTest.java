import Modelo.Edificios.*;
import Modelo.Exceptions.*;
import Modelo.Unidades.*;
import Modelo.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class EspadachinTest {
    //Pruebas base
    @Test
    public void crearEspadachinEnPosicionIndicada(){
        Posicion posicion = new Posicion(5,7);
        Espadachin espadachin = new Espadachin(posicion);
        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
    }

    @Test
    public void crearEspadachinYVerificarVidaCorrespondiente(){
        Posicion posicion = new Posicion(5,7);
        Espadachin espadachin = new Espadachin(posicion);
        Assert.assertEquals(100,espadachin.getVida());
    }

    @Test
    public void crearEspadachinYVerificarCostoCorrespondiente(){
        Posicion posicion = new Posicion(5,7);
        Espadachin espadachin = new Espadachin(posicion);
        Assert.assertEquals(50,espadachin.getCosto());
    }

    //Pruebas Mov normales

    @Test
    public void moverEspadachinUnaUnidadArribaExitosamente(){
        Posicion posicion = new Posicion(4,5);
        Espadachin espadachin = new Espadachin(posicion);
        Posicion destino = new Posicion(4,6);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));
    }

    @Test
    public void moverEspadachinUnaUnidadIzquierdaExitosamente(){
        Posicion posicion = new Posicion(4,5);
        Espadachin espadachin = new Espadachin(posicion);
        Posicion destino = new Posicion(3,5);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));
    }



    @Test
    public void moverEspadachinUnaUnidadDerechaExitosamente(){
        Posicion posicion = new Posicion(4,5);
        Espadachin espadachin = new Espadachin(posicion);
        Posicion destino = new Posicion(5,5);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));

    }

    @Test
    public void moverEspadachinUnaUnidadAbajoExitosamente(){
        Posicion posicion = new Posicion(4,5);
        Espadachin espadachin = new Espadachin(posicion);
        Posicion destino = new Posicion(4,4);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));

    }

    @Test
    public void moverEspadachinUnaUnidadAbajoIzquierdaExitosamente(){
        Posicion posicion = new Posicion(4,5);
        Espadachin espadachin = new Espadachin(posicion);
        Posicion destino = new Posicion(3,4);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));

    }

    @Test
    public void moverEspadachinUnaUnidadAbajoDerechaExitosamente(){
        Posicion posicion = new Posicion(4,5);
        Espadachin espadachin = new Espadachin(posicion);
        Posicion destino = new Posicion(5,4);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));

    }

    @Test
    public void moverEspadachinUnaUnidadArribaIzquierdaExitosamente(){
        Posicion posicion = new Posicion(4,5);
        Espadachin espadachin = new Espadachin(posicion);
        Posicion destino = new Posicion(3,6);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));

    }

    @Test
    public void moverEspadachinUnaUnidadaArribaDerechaExitosamente(){
        Posicion posicion = new Posicion(4,5);
        Espadachin espadachin = new Espadachin(posicion);
        Posicion destino = new Posicion(5,6);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));
    }
    
    @Test
    public void moverEnDosTurnosDistintos(){
        Posicion origen = new Posicion(1,1);
        Espadachin espadachin = new Espadachin(origen);
        Assert.assertTrue(espadachin.estaEnPosicion(origen));
        Posicion destino1 = new Posicion(1,2);
        espadachin.mover(destino1);
        Assert.assertTrue(espadachin.estaEnPosicion(destino1));
        Posicion destino2 = new Posicion(1,3);
        espadachin.desocupar();
        espadachin.mover(destino2);
        Assert.assertTrue(espadachin.estaEnPosicion(destino2));
    }
    
    @Test (expected = UnidadEstaOcupadoException.class)
    public void moverEspadachinDosVecesConsecutivasFalla(){
        Posicion posicion = new Posicion(1,1);
        Espadachin espadachin = new Espadachin(posicion);
        Posicion destino1 = new Posicion(0,1);
        Posicion destino2 = new Posicion(1,1);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino1);
        espadachin.mover(destino2);
    }
    //pruebas atacar
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
        espadachin.atacar(castillo);
        Assert.assertEquals(985, castillo.getVida());
    }
    @Test (expected = UnidadEstaOcupadoException.class)
    public void espadachinAtacarCastilloEnRangoSeOcupa(){
        Posicion posEspadachin = new Posicion(5,5);
        Espadachin espadachin = new Espadachin(posEspadachin);
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
}
