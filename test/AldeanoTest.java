import org.junit.Assert;
import org.junit.Test;

public class AldeanoTest {

    //Pruebas base
    @Test
    public void crearAldeanoEnPosicionIndicada() {
        Aldeano aldeano = new Aldeano();
        aldeano.setPosicion(5, 7);
        Assert.assertEquals(true, aldeano.estaEnPos(5, 7));
    }

    @Test
    public void crearAldeanoYVerificarQueGeneraOro() {
        Aldeano aldeano = new Aldeano();
        Assert.assertEquals(20, aldeano.generaOro());
    }

    @Test
    public void crearAldeanoYVerificarVidaCorrespondiente() {
        Aldeano aldeano = new Aldeano();
        Assert.assertEquals(50, aldeano.getVida());
    }

    @Test
    public void crearAldeanoYVerificarCostoCorrespondiente() {
        Aldeano aldeano = new Aldeano();
        Assert.assertEquals(25, aldeano.getCosto());
    }

    //Pruebas Mov normales

    @Test
    public void moverAldeanoUnaUnidadArribaExitosamente(){
        Aldeano aldeano = new Aldeano();
        aldeano.setPosicion(4,5);
        Posicion destino = new Posicion(4,6);

        Assert.assertEquals(true,aldeano.estaEnPos(4,5));
        aldeano.mover(destino);
        Assert.assertEquals(true,aldeano.estaEnPos(4,6));
    }

/*
    @Test
    public void moverAldeanoUnaUnidadArribaExitosamente(){
        Aldeano aldeano = new Aldeano();
        aldeano.setPosicion(4,5);
        Movimiento movimientoArriba = new MovimientoArriba();

        Assert.assertEquals(true,aldeano.estaEnPos(4,5));
        aldeano.mover(movimientoArriba, aldeano.getPosicion());
        Assert.assertEquals(true,aldeano.estaEnPos(4,6));
    }

    @Test
    public void moverAldeanoUnaUnidadIzquierdaExitosamente(){
        Aldeano aldeano = new Aldeano();
        aldeano.setPosicion(4,5);
        Movimiento movimientoIzquierda = new MovimientoIzquierda();

        Assert.assertEquals(true,aldeano.estaEnPos(4,5));
        aldeano.mover(movimientoIzquierda, aldeano.getPosicion());
        Assert.assertEquals(true,aldeano.estaEnPos(3,5));

    }

    @Test
    public void moverAldeanoUnaUnidadDerechaExitosamente(){
        Aldeano aldeano = new Aldeano();
        aldeano.setPosicion(23,15);
        Movimiento movimientoDerecha = new MovimientoDerecha();

        Assert.assertEquals(true,aldeano.estaEnPos(23,15));
        aldeano.mover(movimientoDerecha, aldeano.getPosicion());
        Assert.assertEquals(true,aldeano.estaEnPos(24,15));

    }

    @Test
    public void moverAldeanoUnaUnidadAbajoExitosamente(){
        Aldeano aldeano = new Aldeano();
        aldeano.setPosicion(4,5);
        Movimiento movimientoAbajo = new MovimientoAbajo();

        Assert.assertEquals(true,aldeano.estaEnPos(4,5));
        aldeano.mover(movimientoAbajo, aldeano.getPosicion());
        Assert.assertEquals(true,aldeano.estaEnPos(4,4));

    }

    @Test
    public void moverAldeanoUnaUnidadAbajoIzquierdaExitosamente(){
        Aldeano aldeano = new Aldeano();
        aldeano.setPosicion(4,5);
        Movimiento movimientoAbajoIzquierda = new MovimientoAbajoIzquierda();

        Assert.assertEquals(true,aldeano.estaEnPos(4,5));
        aldeano.mover(movimientoAbajoIzquierda, aldeano.getPosicion());
        Assert.assertEquals(true,aldeano.estaEnPos(3,4));

    }

    @Test
    public void moverAldeanoUnaUnidadAbajoDerechaExitosamente(){
        Aldeano aldeano = new Aldeano();
        aldeano.setPosicion(4,5);
        Movimiento movimientoAbajoDerecha = new MovimientoAbajoDerecha();

        Assert.assertEquals(true,aldeano.estaEnPos(4,5));
        aldeano.mover(movimientoAbajoDerecha, aldeano.getPosicion());
        Assert.assertEquals(true,aldeano.estaEnPos(5,4));

    }

    @Test
    public void moverAldeanoUnaUnidadArribaIzquierdaExitosamente(){
        Aldeano aldeano = new Aldeano();
        aldeano.setPosicion(4,5);
        Movimiento movimientoArribaIzquierda = new MovimientoArribaIzquierda();

        Assert.assertEquals(true,aldeano.estaEnPos(4,5));
        aldeano.mover(movimientoArribaIzquierda, aldeano.getPosicion());
        Assert.assertEquals(true,aldeano.estaEnPos(3,6));

    }

    @Test
    public void moverAldeanoUnaUnidadaArribaDerechaExitosamente(){
        Aldeano aldeano = new Aldeano();
        aldeano.setPosicion(4,4);
        Movimiento movimientoArribaDerecha = new MovimientoArribaDerecha();

        Assert.assertEquals(true,aldeano.estaEnPos(4,4));
        aldeano.mover(movimientoArribaDerecha, aldeano.getPosicion());
        Assert.assertEquals(true,aldeano.estaEnPos(5,5));

    }

    //Mover mas de 1 vez falla en cada posicion

    @Test (expected = UnidadEstaOcupadoException.class)
    public void moverAldeanoADerechaLuegoDeHaberMovidoLanzaExcepcion(){
        Aldeano aldeano = new Aldeano();
        aldeano.setPosicion(1,1);
        Movimiento movimientoIzquierda = new MovimientoIzquierda();
        Movimiento movimientoDerecha = new MovimientoDerecha();

        Assert.assertEquals(true,aldeano.estaEnPos(1,1));
        aldeano.mover(movimientoIzquierda, aldeano.getPosicion());
        aldeano.mover(movimientoDerecha, aldeano.getPosicion());
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void moverAldeanoAIzquierdaLuegoDeHaberMovidoLanzaExcepcion(){
        Aldeano aldeano = new Aldeano();
        aldeano.setPosicion(3,3);
        Movimiento movimientoArriba = new MovimientoArriba();
        Movimiento movimientoIzquierda = new MovimientoIzquierda();

        Assert.assertEquals(true,aldeano.estaEnPos(3,3));
        aldeano.mover(movimientoArriba, aldeano.getPosicion());
        aldeano.mover(movimientoIzquierda, aldeano.getPosicion());
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void moverAldeanoArribaLuegoDeHaberMovidoLanzaExcepcion(){
        Aldeano aldeano = new Aldeano();
        aldeano.setPosicion(28,30);
        Movimiento movimientoDerecha = new MovimientoDerecha();
        Movimiento movimientoArriba = new MovimientoArriba();

        Assert.assertEquals(true,aldeano.estaEnPos(28,30));
        aldeano.mover(movimientoDerecha, aldeano.getPosicion());
        aldeano.mover(movimientoArriba, aldeano.getPosicion());
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void moverAldeanoArribaIzquierdaLuegoDeHaberMovidoLanzaExcepcion(){
        Aldeano aldeano = new Aldeano();
        aldeano.setPosicion(11,19);
        Movimiento movimientoArribaDerecha = new MovimientoArribaDerecha();
        Movimiento movimientoArribaIzquierda = new MovimientoArribaIzquierda();

        Assert.assertEquals(true,aldeano.estaEnPos(11,19));
        aldeano.mover(movimientoArribaDerecha, aldeano.getPosicion());
        aldeano.mover(movimientoArribaIzquierda, aldeano.getPosicion());
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void moverAldeanoArribaDerechaLuegoDeHaberMovidoLanzaExcepcion(){
        Aldeano aldeano = new Aldeano();
        aldeano.setPosicion(3,3);
        Movimiento movimientoAbajoIzquierda = new MovimientoAbajoIzquierda();
        Movimiento movimientoArribaDerecha = new MovimientoArribaDerecha();

        Assert.assertEquals(true,aldeano.estaEnPos(3,3));
        aldeano.mover(movimientoAbajoIzquierda, aldeano.getPosicion());
        aldeano.mover(movimientoArribaDerecha, aldeano.getPosicion());

    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void moverAldeanoAbajoLuegoDeHaberMovidoExcepcion(){
        Aldeano aldeano = new Aldeano();
        aldeano.setPosicion(17,48);
        Movimiento movimientoArribaDerecha = new MovimientoArribaDerecha();
        Movimiento movimientoAbajo = new MovimientoAbajo();

        Assert.assertEquals(true,aldeano.estaEnPos(17,48));
        aldeano.mover(movimientoArribaDerecha, aldeano.getPosicion());
        aldeano.mover(movimientoAbajo, aldeano.getPosicion());
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void moverAldeanoAbajoIzquierdaLuegoDeHaberMovidoExcepcion(){
        Aldeano aldeano = new Aldeano();
        aldeano.setPosicion(34,41);
        Movimiento movimientoAbajo = new MovimientoAbajo();
        Movimiento movimientoArribaIzquierda = new MovimientoArribaIzquierda();

        Assert.assertEquals(true,aldeano.estaEnPos(34,41));
        aldeano.mover(movimientoAbajo, aldeano.getPosicion());
        aldeano.mover(movimientoArribaIzquierda, aldeano.getPosicion());

    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void moverAldeanoAbajoDerechaLuegoDeHaberMovidoException(){
        Aldeano aldeano = new Aldeano();
        aldeano.setPosicion(10,3);
        Movimiento movimientoIzquierda = new MovimientoIzquierda();
        Movimiento movimientoAbajoDerecha = new MovimientoAbajoDerecha();

        Assert.assertEquals(true,aldeano.estaEnPos(10,3));
        aldeano.mover(movimientoIzquierda, aldeano.getPosicion());
        aldeano.mover(movimientoAbajoDerecha, aldeano.getPosicion());
    }
*/

}
