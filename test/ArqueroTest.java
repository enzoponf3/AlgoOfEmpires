import Modelo.Edificios.Castillo;
import Modelo.Edificios.Cuartel;
import Modelo.Edificios.PlazaCentral;
import Modelo.Exceptions.EntidadFueraDeRangoException;
import Modelo.Exceptions.UnidadEstaOcupadoException;
import Modelo.Posicion;
import Modelo.Unidades.*;
import Modelo.Unidades.Arquero;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ArqueroTest {
    //Pruebas base
    @Test
    public void crearArqueroEnPosicionIndicada(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(5,7);
        arquero.setPosicion(posicion);
        Assert.assertTrue(arquero.estaEnPosicion(posicion));
    }

    @Test
    public void crearArqueroYVerificarVidaCorrespondiente(){
        Arquero arquero = new Arquero();
        Assert.assertEquals(75,arquero.getVida());
    }

    @Test
    public void crearArqueroYVerificarCostoCorrespondiente(){
        Arquero arquero = new Arquero();
        Assert.assertEquals(75,arquero.getCosto());
    }

    //Pruebas Mov normales

    @Test
    public void moverArqueroUnaUnidadArribaExitosamente(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(4,5);
        arquero.setPosicion(posicion);
        Posicion destino = new Posicion(4,6);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));
    }

    @Test
    public void moverArqueroUnaUnidadIzquierdaExitosamente(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(4,5);
        arquero.setPosicion(posicion);
        Posicion destino = new Posicion(3,5);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));
    }



    @Test
    public void moverArqueroUnaUnidadDerechaExitosamente(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(4,5);
        arquero.setPosicion(posicion);
        Posicion destino = new Posicion(5,5);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));

    }

    @Test
    public void moverArqueroUnaUnidadAbajoExitosamente(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(4,5);
        arquero.setPosicion(posicion);
        Posicion destino = new Posicion(4,4);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));

    }

    @Test
    public void moverArqueroUnaUnidadAbajoIzquierdaExitosamente(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(4,5);
        arquero.setPosicion(posicion);
        Posicion destino = new Posicion(3,4);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));

    }

    @Test
    public void moverArqueroUnaUnidadAbajoDerechaExitosamente(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(4,5);
        arquero.setPosicion(posicion);
        Posicion destino = new Posicion(5,4);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));

    }

    @Test
    public void moverArqueroUnaUnidadArribaIzquierdaExitosamente(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(4,5);
        arquero.setPosicion(posicion);
        Posicion destino = new Posicion(3,6);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));

    }

    @Test
    public void moverArqueroUnaUnidadaArribaDerechaExitosamente(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(4,5);
        arquero.setPosicion(posicion);
        Posicion destino = new Posicion(5,6);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));
    }

    @Test
    public void moverEnDosTurnosDistintos(){
        Arquero arquero = new Arquero();
        Posicion origen = new Posicion(1,1);
        arquero.setPosicion(origen);
        Assert.assertTrue(arquero.estaEnPosicion(origen));
        Posicion destino1 = new Posicion(1,2);
        arquero.mover(destino1);
        Assert.assertTrue(arquero.estaEnPosicion(destino1));
        Posicion destino2 = new Posicion(1,3);
        arquero.desocupar();
        arquero.mover(destino2);
        Assert.assertTrue(arquero.estaEnPosicion(destino2));
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void moverArqueroDosVecesConsecutivasLanzaUnidadEstaOcupadaException(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(1,1);
        arquero.setPosicion(posicion);
        Posicion destino1 = new Posicion(0,1);
        Posicion destino2 = new Posicion(1,1);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino1);
        arquero.mover(destino2);
    }
    
    //Pruebas atacar

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
}

