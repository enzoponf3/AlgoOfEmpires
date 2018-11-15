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


}
