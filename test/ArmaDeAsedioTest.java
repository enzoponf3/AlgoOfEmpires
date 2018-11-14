import org.junit.Assert;
import org.junit.Test;

public class ArmaDeAsedioTest {
    //Pruebas base
    @Test
    public void crearArmaDeAsedioEnPosicionIndicada(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(5,7);
        armaAsedio.setPosicion(posicion);
        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
    }

    @Test
    public void crearArmaDeAsedioYVerificarVidaCorrespondiente(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Assert.assertEquals(150,armaAsedio.getVida());
    }

    @Test
    public void crearArmaDeAsedioYVerificarCostoCorrespondiente(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Assert.assertEquals(200,armaAsedio.getCosto());
    }

    //Pruebas Mov

    @Test
    public void moverArmaDeAsedioUnaUnidadArribaExitosamente(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(4,5);
        armaAsedio.setPosicion(posicion);
        Posicion destino = new Posicion(4,6);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));
    }

    @Test
    public void moverArmaDeAsedioUnaUnidadIzquierdaExitosamente(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(4,5);
        armaAsedio.setPosicion(posicion);
        Posicion destino = new Posicion(3,5);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));
    }

    @Test
    public void moverArmaDeAsedioUnaUnidadDerechaExitosamente(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(4,5);
        armaAsedio.setPosicion(posicion);
        Posicion destino = new Posicion(5,5);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));

    }

    @Test
    public void moverArmaDeAsedioUnaUnidadAbajoExitosamente(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(4,5);
        armaAsedio.setPosicion(posicion);
        Posicion destino = new Posicion(4,4);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));

    }

    @Test
    public void moverArmaDeAsedioUnaUnidadAbajoIzquierdaExitosamente(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(4,5);
        armaAsedio.setPosicion(posicion);
        Posicion destino = new Posicion(3,4);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));

    }

    @Test
    public void moverArmaDeAsedioUnaUnidadAbajoDerechaExitosamente(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(4,5);
        armaAsedio.setPosicion(posicion);
        Posicion destino = new Posicion(5,4);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));

    }

    @Test
    public void moverArmaDeAsedioUnaUnidadArribaIzquierdaExitosamente(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(4,5);
        armaAsedio.setPosicion(posicion);
        Posicion destino = new Posicion(3,6);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));

    }

    @Test
    public void moverArmaDeAsedioUnaUnidadaArribaDerechaExitosamente(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(4,5);
        armaAsedio.setPosicion(posicion);
        Posicion destino = new Posicion(5,6);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));
    }

    //Mover mas de 1 vez falla

    @Test (expected = UnidadEstaOcupadoException.class)
    public void moverArmaDeAsedioDosVecesConsecutivasLanzaUnidadEstaOcupadaException(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(1,1);
        armaAsedio.setPosicion(posicion);
        Posicion destino1 = new Posicion(0,1);
        Posicion destino2 = new Posicion(1,1);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino1);
        armaAsedio.mover(destino2);
    }


}
