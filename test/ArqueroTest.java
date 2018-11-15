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
    public void moverArqueroUnaUnidadArribaExitosamente(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(4,5);
        arquero.setPosicion(posicion);
        Posicion destino = new Posicion(4,6);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));
    }

    @Test
    public void moverArqueroUnaUnidadIzquierdaExitosamente(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(4,5);
        arquero.setPosicion(posicion);
        Posicion destino = new Posicion(3,5);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));
    }



    @Test
    public void moverArqueroUnaUnidadDerechaExitosamente(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(4,5);
        arquero.setPosicion(posicion);
        Posicion destino = new Posicion(5,5);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));

    }

    @Test
    public void moverArqueroUnaUnidadAbajoExitosamente(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(4,5);
        arquero.setPosicion(posicion);
        Posicion destino = new Posicion(4,4);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));

    }

    @Test
    public void moverArqueroUnaUnidadAbajoIzquierdaExitosamente(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(4,5);
        arquero.setPosicion(posicion);
        Posicion destino = new Posicion(3,4);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));

    }

    @Test
    public void moverArqueroUnaUnidadAbajoDerechaExitosamente(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(4,5);
        arquero.setPosicion(posicion);
        Posicion destino = new Posicion(5,4);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));

    }

    @Test
    public void moverArqueroUnaUnidadArribaIzquierdaExitosamente(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(4,5);
        arquero.setPosicion(posicion);
        Posicion destino = new Posicion(3,6);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));

    }

    @Test
    public void moverArqueroUnaUnidadaArribaDerechaExitosamente(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(4,5);
        arquero.setPosicion(posicion);
        Posicion destino = new Posicion(5,6);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));
    }

    @Test
    public void moverEnDosTurnosDistintos(){
        Arquero arquero = new Arquero();
        Posicion origen = new Posicion(1,1);
        arquero.setPosicion(origen);
        Assert.assertTrue(arquero.estaEnPosicion(origen));
        Posicion destino1 = new Posicion(1,2);
        arquero.mover(destino1);
        Assert.assertTrue(arquero.estaEnPosicion(destino1));
        Posicion destino2 = new Posicion(1,3);
        arquero.desocupar();
        arquero.mover(destino2);
        Assert.assertTrue(arquero.estaEnPosicion(destino2));
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void moverArqueroDosVecesConsecutivasLanzaUnidadEstaOcupadaException(){
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
