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
        Espadachin espadachin = new Espadachin();
        Posicion posicion = new Posicion(5,7);
        espadachin.setPosicion(posicion);
        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
    }

    @Test
    public void crearEspadachinYVerificarVidaCorrespondiente(){
        Espadachin espadachin = new Espadachin();
        Assert.assertEquals(100,espadachin.getVida());
    }

    @Test
    public void crearEspadachinYVerificarCostoCorrespondiente(){
        Espadachin espadachin = new Espadachin();
        Assert.assertEquals(50,espadachin.getCosto());
    }

    //Pruebas Mov normales

    @Test
    public void moverEspadachinUnaUnidadArribaExitosamente(){
        Espadachin espadachin = new Espadachin();
        Posicion posicion = new Posicion(4,5);
        espadachin.setPosicion(posicion);
        Posicion destino = new Posicion(4,6);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));
    }

    @Test
    public void moverEspadachinUnaUnidadIzquierdaExitosamente(){
        Espadachin espadachin = new Espadachin();
        Posicion posicion = new Posicion(4,5);
        espadachin.setPosicion(posicion);
        Posicion destino = new Posicion(3,5);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));
    }



    @Test
    public void moverEspadachinUnaUnidadDerechaExitosamente(){
        Espadachin espadachin = new Espadachin();
        Posicion posicion = new Posicion(4,5);
        espadachin.setPosicion(posicion);
        Posicion destino = new Posicion(5,5);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));

    }

    @Test
    public void moverEspadachinUnaUnidadAbajoExitosamente(){
        Espadachin espadachin = new Espadachin();
        Posicion posicion = new Posicion(4,5);
        espadachin.setPosicion(posicion);
        Posicion destino = new Posicion(4,4);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));

    }

    @Test
    public void moverEspadachinUnaUnidadAbajoIzquierdaExitosamente(){
        Espadachin espadachin = new Espadachin();
        Posicion posicion = new Posicion(4,5);
        espadachin.setPosicion(posicion);
        Posicion destino = new Posicion(3,4);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));

    }

    @Test
    public void moverEspadachinUnaUnidadAbajoDerechaExitosamente(){
        Espadachin espadachin = new Espadachin();
        Posicion posicion = new Posicion(4,5);
        espadachin.setPosicion(posicion);
        Posicion destino = new Posicion(5,4);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));

    }

    @Test
    public void moverEspadachinUnaUnidadArribaIzquierdaExitosamente(){
        Espadachin espadachin = new Espadachin();
        Posicion posicion = new Posicion(4,5);
        espadachin.setPosicion(posicion);
        Posicion destino = new Posicion(3,6);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));

    }

    @Test
    public void moverEspadachinUnaUnidadaArribaDerechaExitosamente(){
        Espadachin espadachin = new Espadachin();
        Posicion posicion = new Posicion(4,5);
        espadachin.setPosicion(posicion);
        Posicion destino = new Posicion(5,6);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));
    }
    
    @Test
    public void moverEnDosTurnosDistintos(){
        Espadachin espadachin = new Espadachin();
        Posicion origen = new Posicion(1,1);
        espadachin.setPosicion(origen);
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
        Espadachin espadachin = new Espadachin();
        Posicion posicion = new Posicion(1,1);
        espadachin.setPosicion(posicion);
        Posicion destino1 = new Posicion(0,1);
        Posicion destino2 = new Posicion(1,1);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino1);
        espadachin.mover(destino2);
    }
    //pruebas atacar
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
        cuartel.construir();
        cuartel.construir();
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
        cuartel.construir();
        cuartel.construir();
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
        plaza.construir();
        plaza.construir();
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
        plaza.construir();
        plaza.construir();
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


}
