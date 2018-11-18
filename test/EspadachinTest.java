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
    public void EspadachinAtacarAldeanoEnRangoYBajaVida(){
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
    public void EspadachinAtacarAldeanoEnRangoSeOcupa(){
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
    public void EspadachinAtacarEspadachinEnRangoYBajaVida(){}

    @Test
    public void EspadachinAtacarArqueroEnRangoSeOcupa(){}

    @Test
    public void EspadachinAtacarArqueroEnRangoBajaVida(){}

    @Test
    public void EspadachinAtacarArmaAsedioEnRangoBajaVida(){}

    @Test
    public void EspadachinAtacarArmaAsedioEnRangoSeOcupa(){}

    @Test
    public void EspadachinAtacarCuartelEnRangoSeOcupa(){
        Cuartel cuartel = new Cuartel();
        Posicion posicion1 = new Posicion(2,5);
        Posicion posicion2 = new Posicion(2,4);
        Posicion posicion3 = new Posicion(3,5);
        Posicion posicion4 = new Posicion(3,4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        cuartel.setPosiciones(posiciones);
        Espadachin espadachin = new Espadachin();
        Posicion posicion5 = new Posicion(1,3);
        espadachin.setPosicion(posicion5);
        cuartel.construir();
        cuartel.construir();
        cuartel.construir();
        Assert.assertEquals(250,cuartel.getVida());
        espadachin.atacar(cuartel);
        Assert.assertEquals(235,cuartel.getVida());
    }

    @Test
    public void EspadachinAtacarCuartelEnRangoBajaVida(){}

    @Test
    public void EspadachinAtacarPlazaCentralEnRangoBajaVida(){}

    @Test
    public void EspadachinAtacarPlazaCentralEnRangoSeOcupa(){}

    @Test (expected = ObjetoFueraDeRangoException.class)
    public void EspadachinAtacarUnidadFueraDeRango(){
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
    public void EspadachinAtacarCastilloEnRango(){}



}
