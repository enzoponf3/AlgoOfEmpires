import org.junit.Assert;
import org.junit.Test;

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
    public void moverAldeanoUnaUnidadArribaExitosamente(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(4,5);
        arquero.setPosicion(posicion);
        Posicion destino = new Posicion(4,6);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));
    }

    @Test
    public void moverAldeanoUnaUnidadIzquierdaExitosamente(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(4,5);
        arquero.setPosicion(posicion);
        Posicion destino = new Posicion(3,5);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));
    }



    @Test
    public void moverAldeanoUnaUnidadDerechaExitosamente(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(4,5);
        arquero.setPosicion(posicion);
        Posicion destino = new Posicion(5,5);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));

    }

    @Test
    public void moverAldeanoUnaUnidadAbajoExitosamente(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(4,5);
        arquero.setPosicion(posicion);
        Posicion destino = new Posicion(4,4);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));

    }

    @Test
    public void moverAldeanoUnaUnidadAbajoIzquierdaExitosamente(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(4,5);
        arquero.setPosicion(posicion);
        Posicion destino = new Posicion(3,4);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));

    }

    @Test
    public void moverAldeanoUnaUnidadAbajoDerechaExitosamente(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(4,5);
        arquero.setPosicion(posicion);
        Posicion destino = new Posicion(5,4);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));

    }

    @Test
    public void moverAldeanoUnaUnidadArribaIzquierdaExitosamente(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(4,5);
        arquero.setPosicion(posicion);
        Posicion destino = new Posicion(3,6);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));

    }

    @Test
    public void moverAldeanoUnaUnidadaArribaDerechaExitosamente(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(4,5);
        arquero.setPosicion(posicion);
        Posicion destino = new Posicion(5,6);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));
    }

    //Mover mas de 1 vez falla en cada posicion

    @Test (expected = UnidadEstaOcupadoException.class)
    public void moverAldeanoDosVecesConsecutivasLanzaUnidadEstaOcupadaException(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(1,1);
        arquero.setPosicion(posicion);
        Posicion destino1 = new Posicion(0,1);
        Posicion destino2 = new Posicion(1,1);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino1);
        arquero.mover(destino2);
    }

}
