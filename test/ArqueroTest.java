import org.junit.Assert;
import org.junit.Test;

public class ArqueroTest {
    //Pruebas base
    @Test
    public void crearArqueroEnPosicionIndicada(){
        Arquero arquero = new Arquero();
        arquero.setPosicion(5,7);
        Assert.assertEquals(true,arquero.estaEnPos(5,7));
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
/*
    @Test
    public void moverArqueroUnaUnidadArribaExitosamente(){
        Arquero arquero = new Arquero();
        arquero.setPosicion(4,5);
        Assert.assertEquals(true,arquero.estaEnPos(4,5));
        arquero.moverHaciaArriba();
        Assert.assertEquals(true,arquero.estaEnPos(4,6));
    }

    @Test
    public void moverArqueroUnaUnidadIzquierdaExitosamente(){
        Arquero arquero = new Arquero(); //idem
        arquero.setPosicion(2,4);
        Assert.assertEquals(true,arquero.estaEnPos(2,4));
        arquero.moverHaciaIzquierda();
        Assert.assertEquals(true,arquero.estaEnPos(1,4));
    }

    @Test
    public void moverArqueroUnaUnidadDerechaExitosamente(){
        Arquero arquero = new Arquero(); //idem
        arquero.setPosicion(23,15);
        Assert.assertEquals(true,arquero.estaEnPos(23,15));
        arquero.moverHaciaDerecha();
        Assert.assertEquals(true,arquero.estaEnPos(24,15));
    }

    @Test
    public void moverArqueroUnaUnidadAbajoExitosamente(){
        Arquero arquero = new Arquero(); //idem
        arquero.setPosicion(10,10);
        Assert.assertEquals(true,arquero.estaEnPos(10,10));
        arquero.moverHaciaAbajo();
        Assert.assertEquals(true,arquero.estaEnPos(10,9));
    }

    @Test
    public void moverArqueroUnaUnidadAbajoIzquierdaExitosamente(){
        Arquero arquero = new Arquero(); //idem
        arquero.setPosicion(15,15);
        Assert.assertEquals(true,arquero.estaEnPos(15,15));
        arquero.moverHaciaAbajoIzquierda();
        Assert.assertEquals(true,arquero.estaEnPos(14,14));
    }

    @Test
    public void moverArqueroUnaUnidadAbajoDerechaExitosamente(){
        Arquero arquero = new Arquero(); //idem
        arquero.setPosicion(10,8);
        Assert.assertEquals(true,arquero.estaEnPos(10,8));
        arquero.moverHaciaAbajoDerecha();
        Assert.assertEquals(true,arquero.estaEnPos(11,7));
    }

    @Test
    public void moverArqueroUnaUnidadArribaIzquierdaExitosamente(){
        Arquero arquero = new Arquero(); //idem
        arquero.setPosicion(19,42);
        Assert.assertEquals(true,arquero.estaEnPos(19,42));
        arquero.moverHaciaArribaIzquierda();
        Assert.assertEquals(true,arquero.estaEnPos(18,43));
    }

    @Test
    public void moverArqueroUnaUnidadaArribaDerechaExitosamente(){
        Arquero arquero = new Arquero(); //idem
        arquero.setPosicion(33,33);
        Assert.assertEquals(true,arquero.estaEnPos(33,33));
        arquero.moverHaciaArribaDerecha();
        Assert.assertEquals(true,arquero.estaEnPos(34,34));
    }

    //Mover mas de 1 vez falla en cada posicion

    @Test (expected = UnidadEstaOcupadoException.class)
    public void moverArqueroADerechaLuegoDeHaberMovidoLanzaExcepcion(){
        Arquero arquero = new Arquero();
        arquero.setPosicion(1,1);
        Assert.assertEquals(true,arquero.estaEnPos(1,1));
        arquero.moverHaciaIzquierda();
        arquero.moverHaciaDerecha();
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void moverArqueroAIzquierdaLuegoDeHaberMovidoLanzaExcepcion(){
        Arquero arquero = new Arquero();
        arquero.setPosicion(3,3);
        Assert.assertEquals(true,arquero.estaEnPos(3,3));
        arquero.moverHaciaArriba();
        arquero.moverHaciaIzquierda();
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void moverArqueroArribaLuegoDeHaberMovidoLanzaExcepcion(){
        Arquero arquero = new Arquero();
        arquero.setPosicion(28,30);
        Assert.assertEquals(true,arquero.estaEnPos(28,30));
        arquero.moverHaciaDerecha();
        arquero.moverHaciaArriba();
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void moverArqueroArribaIzquierdaLuegoDeHaberMovidoLanzaExcepcion(){
        Arquero arquero = new Arquero();
        arquero.setPosicion(11,19);
        Assert.assertEquals(true,arquero.estaEnPos(11,19));
        arquero.moverHaciaArribaDerecha();
        arquero.moverHaciaArribaIzquierda();
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void moverArqueroArribaDerechaLuegoDeHaberMovidoLanzaExcepcion(){
        Arquero arquero = new Arquero();
        arquero.setPosicion(3,3);
        Assert.assertEquals(true,arquero.estaEnPos(3,3));
        arquero.moverHaciaAbajoIzquierda();
        arquero.moverHaciaArribaDerecha();
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void moverArqueroAbajoLuegoDeHaberMovidoExcepcion(){
        Arquero arquero = new Arquero();
        arquero.setPosicion(17,48);
        Assert.assertEquals(true,arquero.estaEnPos(17,48));
        arquero.moverHaciaArribaDerecha();
        arquero.moverHaciaAbajo();
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void moverArqueroAbajoIzquierdaLuegoDeHaberMovidoExcepcion(){
        Arquero arquero = new Arquero();
        arquero.setPosicion(34,41);
        Assert.assertEquals(true,arquero.estaEnPos(34,41));
        arquero.moverHaciaAbajo();
        arquero.moverHaciaAbajoIzquierda();
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void moverArqueroAbajoDerechaLuegoDeHaberMovidoException(){
        Arquero arquero = new Arquero();
        arquero.setPosicion(10,3);
        Assert.assertEquals(true,arquero.estaEnPos(10,3));
        arquero.moverHaciaIzquierda();
        arquero.moverHaciaAbajoDerecha();
    }
*/

}
