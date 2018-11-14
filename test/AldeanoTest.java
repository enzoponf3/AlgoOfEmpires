import org.junit.Assert;
import org.junit.Test;

public class AldeanoTest {

    //Pruebas base
    @Test
    public void crearAldeanoEnPosicionIndicada() {
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(5,7);
        aldeano.setPosicion(posicion);

        Assert.assertEquals(true, aldeano.estaEnPosicion(posicion));
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
        Posicion posicion = new Posicion(4,5);
        aldeano.setPosicion(posicion);
        Posicion destino = new Posicion(4,6);

        Assert.assertEquals(true,aldeano.estaEnPosicion(posicion));
        aldeano.mover(destino);
        Assert.assertEquals(true,aldeano.estaEnPosicion(destino));
    }

    @Test
    public void moverAldeanoUnaUnidadIzquierdaExitosamente(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(4,5);
        aldeano.setPosicion(posicion);
        Posicion destino = new Posicion(3,5);

        Assert.assertEquals(true,aldeano.estaEnPosicion(posicion));
        aldeano.mover(destino);
        Assert.assertEquals(true,aldeano.estaEnPosicion(destino));
    }



    @Test
    public void moverAldeanoUnaUnidadDerechaExitosamente(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(4,5);
        aldeano.setPosicion(posicion);
        Posicion destino = new Posicion(5,5);

        Assert.assertEquals(true,aldeano.estaEnPosicion(posicion));
        aldeano.mover(destino);
        Assert.assertEquals(true,aldeano.estaEnPosicion(destino));

    }

    @Test
    public void moverAldeanoUnaUnidadAbajoExitosamente(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(4,5);
        aldeano.setPosicion(posicion);
        Posicion destino = new Posicion(4,4);

        Assert.assertEquals(true,aldeano.estaEnPosicion(posicion));
        aldeano.mover(destino);
        Assert.assertEquals(true,aldeano.estaEnPosicion(destino));

    }

    @Test
    public void moverAldeanoUnaUnidadAbajoIzquierdaExitosamente(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(4,5);
        aldeano.setPosicion(posicion);
        Posicion destino = new Posicion(3,4);

        Assert.assertEquals(true,aldeano.estaEnPosicion(posicion));
        aldeano.mover(destino);
        Assert.assertEquals(true,aldeano.estaEnPosicion(destino));

    }

    @Test
    public void moverAldeanoUnaUnidadAbajoDerechaExitosamente(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(4,5);
        aldeano.setPosicion(posicion);
        Posicion destino = new Posicion(5,4);

        Assert.assertEquals(true,aldeano.estaEnPosicion(posicion));
        aldeano.mover(destino);
        Assert.assertEquals(true,aldeano.estaEnPosicion(destino));

    }

    @Test
    public void moverAldeanoUnaUnidadArribaIzquierdaExitosamente(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(4,5);
        aldeano.setPosicion(posicion);
        Posicion destino = new Posicion(3,6);

        Assert.assertEquals(true,aldeano.estaEnPosicion(posicion));
        aldeano.mover(destino);
        Assert.assertEquals(true,aldeano.estaEnPosicion(destino));

    }

    @Test
    public void moverAldeanoUnaUnidadaArribaDerechaExitosamente(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(4,5);
        aldeano.setPosicion(posicion);
        Posicion destino = new Posicion(5,5);

        Assert.assertEquals(true,aldeano.estaEnPosicion(posicion));
        aldeano.mover(destino);
        Assert.assertEquals(true,aldeano.estaEnPosicion(destino));
    }

    //Mover mas de 1 vez falla en cada posicion

    @Test (expected = UnidadEstaOcupadoException.class)
    public void moverAldeanoDosVecesConsecutivasLanzaUnidadEstaOcupadaException(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(1,1);
        aldeano.setPosicion(posicion);
        Posicion destino1 = new Posicion(0,1);
        Posicion destino2 = new Posicion(1,1);

        Assert.assertEquals(true,aldeano.estaEnPosicion(posicion));
        aldeano.mover(destino1);
        aldeano.mover(destino2);
    }

    //Me parece que ya no es necesario probar todos los movimientos.
    //Y tambien creo que deberiamos definir el arriba jaja, porque yo lo tomaba como los ejes cartesianod.
    //Pero cuando veamos el mapa con los cuadraditos supongo que el de arriba a la izq va a ser el (0,0).
}
