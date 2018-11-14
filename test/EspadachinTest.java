import org.junit.Assert;
import org.junit.Test;

public class EspadachinTest {
    //Pruebas base
    @Test
    public void crearEspadachinEnPosicionIndicada(){
        Espadachin espadachin = new Espadachin();
        espadachin.setPosicion(5,7);
        Assert.assertEquals(true,espadachin.estaEnPos(5,7));
    }

    @Test
    public void crearEspadachinYVerificarVidaCorrespondiente(){
        Espadachin espadachin = new Espadachin();
        Assert.assertEquals(50,espadachin.getVida());
    }

    @Test
    public void crearEspadachinYVerificarCostoCorrespondiente(){
        Espadachin espadachin = new Espadachin();
        Assert.assertEquals(25,espadachin.getCosto());
    }

    //Pruebas Mov normales
/*
    @Test
    public void moverEspadachinUnaUnidadArribaExitosamente(){
        Espadachin espadachin = new Espadachin();
        espadachin.setPosicion(4,5);
        Assert.assertEquals(true,espadachin.estaEnPos(4,5));
        espadachin.moverHaciaArriba();
        Assert.assertEquals(true,espadachin.estaEnPos(4,6));
    }

    @Test
    public void moverEspadachinUnaUnidadIzquierdaExitosamente(){
        Espadachin espadachin = new Espadachin(); //idem
        espadachin.setPosicion(2,4);
        Assert.assertEquals(true,espadachin.estaEnPos(2,4));
        espadachin.moverHaciaIzquierda();
        Assert.assertEquals(true,espadachin.estaEnPos(1,4));
    }

    @Test
    public void moverEspadachinUnaUnidadDerechaExitosamente(){
        Espadachin espadachin = new Espadachin(); //idem
        espadachin.setPosicion(23,15);
        Assert.assertEquals(true,espadachin.estaEnPos(23,15));
        espadachin.moverHaciaDerecha();
        Assert.assertEquals(true,espadachin.estaEnPos(24,15));
    }

    @Test
    public void moverEspadachinUnaUnidadAbajoExitosamente(){
        Espadachin espadachin = new Espadachin(); //idem
        espadachin.setPosicion(10,10);
        Assert.assertEquals(true,espadachin.estaEnPos(10,10));
        espadachin.moverHaciaAbajo();
        Assert.assertEquals(true,espadachin.estaEnPos(10,9));
    }

    @Test
    public void moverEspadachinUnaUnidadAbajoIzquierdaExitosamente(){
        Espadachin espadachin = new Espadachin(); //idem
        espadachin.setPosicion(15,15);
        Assert.assertEquals(true,espadachin.estaEnPos(15,15));
        espadachin.moverHaciaAbajoIzquierda();
        Assert.assertEquals(true,espadachin.estaEnPos(14,14));
    }

    @Test
    public void moverEspadachinUnaUnidadAbajoDerechaExitosamente(){
        Espadachin espadachin = new Espadachin(); //idem
        espadachin.setPosicion(10,8);
        Assert.assertEquals(true,espadachin.estaEnPos(10,8));
        espadachin.moverHaciaAbajoDerecha();
        Assert.assertEquals(true,espadachin.estaEnPos(11,7));
    }

    @Test
    public void moverEspadachinUnaUnidadArribaIzquierdaExitosamente(){
        Espadachin espadachin = new Espadachin(); //idem
        espadachin.setPosicion(19,42);
        Assert.assertEquals(true,espadachin.estaEnPos(19,42));
        espadachin.moverHaciaArribaIzquierda();
        Assert.assertEquals(true,espadachin.estaEnPos(18,43));
    }

    @Test
    public void moverEspadachinUnaUnidadaArribaDerechaExitosamente(){
        Espadachin espadachin = new Espadachin(); //idem
        espadachin.setPosicion(33,33);
        Assert.assertEquals(true,espadachin.estaEnPos(33,33));
        espadachin.moverHaciaArribaDerecha();
        Assert.assertEquals(true,espadachin.estaEnPos(34,34));
    }

    //Mover mas de 1 vez falla en cada posicion

    @Test (expected = UnidadEstaOcupadoException.class)
    public void moverEspadachinADerechaLuegoDeHaberMovidoLanzaExcepcion(){
        Espadachin espadachin = new Espadachin();
        espadachin.setPosicion(1,1);
        Assert.assertEquals(true,espadachin.estaEnPos(1,1));
        espadachin.moverHaciaIzquierda();
        espadachin.moverHaciaDerecha();
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void moverEspadachinAIzquierdaLuegoDeHaberMovidoLanzaExcepcion(){
        Espadachin espadachin = new Espadachin();
        espadachin.setPosicion(3,3);
        Assert.assertEquals(true,espadachin.estaEnPos(3,3));
        espadachin.moverHaciaArriba();
        espadachin.moverHaciaIzquierda();
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void moverEspadachinArribaLuegoDeHaberMovidoLanzaExcepcion(){
        Espadachin espadachin = new Espadachin();
        espadachin.setPosicion(28,30);
        Assert.assertEquals(true,espadachin.estaEnPos(28,30));
        espadachin.moverHaciaDerecha();
        espadachin.moverHaciaArriba();
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void moverEspadachinArribaIzquierdaLuegoDeHaberMovidoLanzaExcepcion(){
        Espadachin espadachin = new Espadachin();
        espadachin.setPosicion(11,19);
        Assert.assertEquals(true,espadachin.estaEnPos(11,19));
        espadachin.moverHaciaArribaDerecha();
        espadachin.moverHaciaArribaIzquierda();
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void moverEspadachinArribaDerechaLuegoDeHaberMovidoLanzaExcepcion(){
        Espadachin espadachin = new Espadachin();
        espadachin.setPosicion(3,3);
        Assert.assertEquals(true,espadachin.estaEnPos(3,3));
        espadachin.moverHaciaAbajoIzquierda();
        espadachin.moverHaciaArribaDerecha();
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void moverEspadachinAbajoLuegoDeHaberMovidoExcepcion(){
        Espadachin espadachin = new Espadachin();
        espadachin.setPosicion(17,48);
        Assert.assertEquals(true,espadachin.estaEnPos(17,48));
        espadachin.moverHaciaArribaDerecha();
        espadachin.moverHaciaAbajo();
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void moverEspadachinAbajoIzquierdaLuegoDeHaberMovidoExcepcion(){
        Espadachin espadachin = new Espadachin();
        espadachin.setPosicion(34,41);
        Assert.assertEquals(true,espadachin.estaEnPos(34,41));
        espadachin.moverHaciaAbajo();
        espadachin.moverHaciaAbajoIzquierda();
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void moverEspadachinAbajoDerechaLuegoDeHaberMovidoException(){
        Espadachin espadachin = new Espadachin();
        espadachin.setPosicion(10,3);
        Assert.assertEquals(true,espadachin.estaEnPos(10,3));
        espadachin.moverHaciaIzquierda();
        espadachin.moverHaciaAbajoDerecha();
    }

 */
}
