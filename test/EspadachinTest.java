import org.junit.Assert;
import org.junit.Test;

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
    public void moverAldeanoUnaUnidadDerechaExitosamente(){
        Espadachin espadachin = new Espadachin();
        Posicion posicion = new Posicion(4,5);
        espadachin.setPosicion(posicion);
        Posicion destino = new Posicion(5,5);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));

    }

    @Test
    public void moverAldeanoUnaUnidadAbajoExitosamente(){
        Espadachin espadachin = new Espadachin();
        Posicion posicion = new Posicion(4,5);
        espadachin.setPosicion(posicion);
        Posicion destino = new Posicion(4,4);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));

    }

    @Test
    public void moverAldeanoUnaUnidadAbajoIzquierdaExitosamente(){
        Espadachin espadachin = new Espadachin();
        Posicion posicion = new Posicion(4,5);
        espadachin.setPosicion(posicion);
        Posicion destino = new Posicion(3,4);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));

    }

    @Test
    public void moverAldeanoUnaUnidadAbajoDerechaExitosamente(){
        Espadachin espadachin = new Espadachin();
        Posicion posicion = new Posicion(4,5);
        espadachin.setPosicion(posicion);
        Posicion destino = new Posicion(5,4);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));

    }

    @Test
    public void moverAldeanoUnaUnidadArribaIzquierdaExitosamente(){
        Espadachin espadachin = new Espadachin();
        Posicion posicion = new Posicion(4,5);
        espadachin.setPosicion(posicion);
        Posicion destino = new Posicion(3,6);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));

    }

    @Test
    public void moverAldeanoUnaUnidadaArribaDerechaExitosamente(){
        Espadachin espadachin = new Espadachin();
        Posicion posicion = new Posicion(4,5);
        espadachin.setPosicion(posicion);
        Posicion destino = new Posicion(5,6);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void moverAldeanoDosVecesConsecutivasLanzaUnidadEstaOcupadaException(){
        Espadachin espadachin = new Espadachin();
        Posicion posicion = new Posicion(1,1);
        espadachin.setPosicion(posicion);
        Posicion destino1 = new Posicion(0,1);
        Posicion destino2 = new Posicion(1,1);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino1);
        espadachin.mover(destino2);
    }


}
