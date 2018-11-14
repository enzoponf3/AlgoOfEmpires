import org.junit.Assert;
import org.junit.Test;

public class ArmaDeAsedioTest {
    //Pruebas base
    @Test
    public void crearArmaDeAsedioEnPosicionIndicada(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        armaAsedio.setPosicion(5,7);
        Assert.assertEquals(true,armaAsedio.estaEnPos(5,7));
    }

    @Test
    public void crearArmaDeAsedioYVerificarVidaCorrespondiente(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Assert.assertEquals(50,armaAsedio.getVida());
    }

    @Test
    public void crearArmaDeAsedioYVerificarCostoCorrespondiente(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Assert.assertEquals(25,armaAsedio.getCosto());
    }

    //Pruebas Mov normales

    @Test
    public void moverArmaDeAsedioUnaUnidadArribaExitosamente(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        armaAsedio.setPosicion(4,5);
        Assert.assertEquals(true,armaAsedio.estaEnPos(4,5));
        armaAsedio.moverHaciaArriba();
        Assert.assertEquals(true,armaAsedio.estaEnPos(4,6));
    }

    @Test
    public void moverArmaDeAsedioUnaUnidadIzquierdaExitosamente(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(); //idem
        armaAsedio.setPosicion(2,4);
        Assert.assertEquals(true,armaAsedio.estaEnPos(2,4));
        armaAsedio.moverHaciaIzquierda();
        Assert.assertEquals(true,armaAsedio.estaEnPos(1,4));
    }

    @Test
    public void moverArmaDeAsedioUnaUnidadDerechaExitosamente(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(); //idem
        armaAsedio.setPosicion(23,15);
        Assert.assertEquals(true,armaAsedio.estaEnPos(23,15));
        armaAsedio.moverHaciaDerecha();
        Assert.assertEquals(true,armaAsedio.estaEnPos(24,15));
    }

    @Test
    public void moverArmaDeAsedioUnaUnidadAbajoExitosamente(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(); //idem
        armaAsedio.setPosicion(10,10);
        Assert.assertEquals(true,armaAsedio.estaEnPos(10,10));
        armaAsedio.moverHaciaAbajo();
        Assert.assertEquals(true,armaAsedio.estaEnPos(10,9));
    }

    @Test
    public void moverArmaDeAsedioUnaUnidadAbajoIzquierdaExitosamente(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(); //idem
        armaAsedio.setPosicion(15,15);
        Assert.assertEquals(true,armaAsedio.estaEnPos(15,15));
        armaAsedio.moverHaciaAbajoIzquierda();
        Assert.assertEquals(true,armaAsedio.estaEnPos(14,14));
    }

    @Test
    public void moverArmaDeAsedioUnaUnidadAbajoDerechaExitosamente(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(); //idem
        armaAsedio.setPosicion(10,8);
        Assert.assertEquals(true,armaAsedio.estaEnPos(10,8));
        armaAsedio.moverHaciaAbajoDerecha();
        Assert.assertEquals(true,armaAsedio.estaEnPos(11,7));
    }

    @Test
    public void moverArmaDeAsedioUnaUnidadArribaIzquierdaExitosamente(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(); //idem
        armaAsedio.setPosicion(19,42);
        Assert.assertEquals(true,armaAsedio.estaEnPos(19,42));
        armaAsedio.moverHaciaArribaIzquierda();
        Assert.assertEquals(true,armaAsedio.estaEnPos(18,43));
    }

    @Test
    public void moverArmaDeAsedioUnaUnidadaArribaDerechaExitosamente(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(); //idem
        armaAsedio.setPosicion(33,33);
        Assert.assertEquals(true,armaAsedio.estaEnPos(33,33));
        armaAsedio.moverHaciaArribaDerecha();
        Assert.assertEquals(true,armaAsedio.estaEnPos(34,34));
    }

    //Mover mas de 1 vez falla en cada posicion

    @Test (expected = UnidadEstaOcupadoException.class)
    public void moverArmaDeAsedioADerechaLuegoDeHaberMovidoLanzaExcepcion(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        armaAsedio.setPosicion(1,1);
        Assert.assertEquals(true,armaAsedio.estaEnPos(1,1));
        armaAsedio.moverHaciaIzquierda();
        armaAsedio.moverHaciaDerecha();
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void moverArmaDeAsedioAIzquierdaLuegoDeHaberMovidoLanzaExcepcion(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        armaAsedio.setPosicion(3,3);
        Assert.assertEquals(true,armaAsedio.estaEnPos(3,3));
        armaAsedio.moverHaciaArriba();
        armaAsedio.moverHaciaIzquierda();
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void moverArmaDeAsedioArribaLuegoDeHaberMovidoLanzaExcepcion(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        armaAsedio.setPosicion(28,30);
        Assert.assertEquals(true,armaAsedio.estaEnPos(28,30));
        armaAsedio.moverHaciaDerecha();
        armaAsedio.moverHaciaArriba();
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void moverArmaDeAsedioArribaIzquierdaLuegoDeHaberMovidoLanzaExcepcion(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        armaAsedio.setPosicion(11,19);
        Assert.assertEquals(true,armaAsedio.estaEnPos(11,19));
        armaAsedio.moverHaciaArribaDerecha();
        armaAsedio.moverHaciaArribaIzquierda();
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void moverArmaDeAsedioArribaDerechaLuegoDeHaberMovidoLanzaExcepcion(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        armaAsedio.setPosicion(3,3);
        Assert.assertEquals(true,armaAsedio.estaEnPos(3,3));
        armaAsedio.moverHaciaAbajoIzquierda();
        armaAsedio.moverHaciaArribaDerecha();
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void moverArmaDeAsedioAbajoLuegoDeHaberMovidoExcepcion(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        armaAsedio.setPosicion(17,48);
        Assert.assertEquals(true,armaAsedio.estaEnPos(17,48));
        armaAsedio.moverHaciaArribaDerecha();
        armaAsedio.moverHaciaAbajo();
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void moverArmaDeAsedioAbajoIzquierdaLuegoDeHaberMovidoExcepcion(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        armaAsedio.setPosicion(34,41);
        Assert.assertEquals(true,armaAsedio.estaEnPos(34,41));
        armaAsedio.moverHaciaAbajo();
        armaAsedio.moverHaciaAbajoIzquierda();
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void moverArmaDeAsedioAbajoDerechaLuegoDeHaberMovidoException(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        armaAsedio.setPosicion(10,3);
        Assert.assertEquals(true,armaAsedio.estaEnPos(10,3));
        armaAsedio.moverHaciaIzquierda();
        armaAsedio.moverHaciaAbajoDerecha();
    }
}
