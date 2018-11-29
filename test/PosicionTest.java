import junit.framework.AssertionFailedError;
import org.junit.Test;
import org.junit.Assert;

import Modelo.Posicion;


import java.util.ArrayList;

public class PosicionTest {

    @Test
    public void compararDosPosicionesIgualesDevuelveTrue(){
        Posicion unaPosicion = new Posicion(2,3);
        Posicion otraPosicion = new Posicion(2, 3);

        Assert.assertTrue( unaPosicion.igualA(otraPosicion) );
    }

    @Test
    public void compararDosPosicionesConAmbasCoordenadasDistintasDevuelveFalse(){
        Posicion unaPosicion = new Posicion(2,3);
        Posicion otraPosicion = new Posicion(5, 6);

        Assert.assertFalse( unaPosicion.igualA(otraPosicion) );
    }

    @Test
    public void compararDosPosicionesConLaCoordenadaHorizontalDistintaYOtraIgualDevuelveFalse(){
        Posicion unaPosicion = new Posicion(2,3);
        Posicion otraPosicion = new Posicion(2, 6);

        Assert.assertFalse( unaPosicion.igualA(otraPosicion) );
    }

    @Test
    public void compararDosPosicionesConLaCoordenadaHorizontalIgualYLaVerticalDiferenteDevuelveFalse(){
        Posicion unaPosicion = new Posicion(2,3);
        Posicion otraPosicion = new Posicion(5, 3);

        Assert.assertFalse( unaPosicion.igualA(otraPosicion) );
    }

    @Test
    public void preguntarSiEstaDentroDeLosLimitesCuandoLoEstaDevuelveTrue(){
        Posicion posicion = new Posicion(2,3);
        int limite1 = 10;
        int limite2 = 20;

        Assert.assertTrue( posicion.estaDentroDelMapa(limite1, limite2) );
    }

    @Test
    public void preguntarSiEstaDentroDeLosLimitesCuandoEstaEnUnBordeDevuelveTrue(){
        Posicion posicion = new Posicion(9,3);
        int limite1 = 10;
        int limite2 = 20;

        Assert.assertTrue( posicion.estaDentroDelMapa(limite1, limite2) );
    }

    @Test
    public void preguntarSiEstaDentroDeLosLimitesCuandoEstaEnUnaEsquinaDevuelveTrue(){
        Posicion posicion = new Posicion(9,19);
        int limite1 = 10;
        int limite2 = 20;

        Assert.assertTrue( posicion.estaDentroDelMapa(limite1, limite2) );
    }

    @Test
    public void preguntarSiEstaDentroDeLosLimitesCuandoNoLoEstaDevuelveFalse(){
        Posicion posicion = new Posicion(10,3);
        int limite1 = 10;
        int limite2 = 20;

        Assert.assertFalse( posicion.estaDentroDelMapa(limite1, limite2) );
    }

    @Test
    public void verificaSiDosPosicionesSonAledaniasPorLaVerticalHaciaArribaCorrectamente(){
        Posicion posicion = new Posicion(2,3);
        Posicion otraPosicion = new Posicion(2,4);

        Assert.assertTrue( posicion.aledaniaA(otraPosicion) );
    }

    @Test
    public void verificaSiDosPosicionesSonAledaniasPorLaVerticalHaciaAbajoCorrectamente(){
        Posicion posicion = new Posicion(2,3);
        Posicion otraPosicion = new Posicion(2,2);

        Assert.assertTrue( posicion.aledaniaA(otraPosicion) );
    }

    @Test
    public void verificaSiDosPosicionesSonAledaniasPorLaHorizontalHaciaIzquierdaCorrectamente(){
        Posicion posicion = new Posicion(2,3);
        Posicion otraPosicion = new Posicion(1,3);

        Assert.assertTrue( posicion.aledaniaA(otraPosicion) );
    }

    @Test
    public void verificaSiDosPosicionesSonAledaniasPorLaHorizontalHaciaDerechaCorrectamente(){
        Posicion posicion = new Posicion(2,3);
        Posicion otraPosicion = new Posicion(3,3);

        Assert.assertTrue( posicion.aledaniaA(otraPosicion) );
    }

    @Test
    public void verificaSiDosPosicionesSonAledaniasPorLaDiagonalSuperiorIzquierdaCorrectamente(){
        Posicion posicion = new Posicion(2,3);
        Posicion otraPosicion = new Posicion(1,2);

        Assert.assertTrue( posicion.aledaniaA(otraPosicion) );
    }

    @Test
    public void verificaSiDosPosicionesSonAledaniasPorLaDiagonalSuperiorDerechaCorrectamente(){
        Posicion posicion = new Posicion(2,3);
        Posicion otraPosicion = new Posicion(1,4);

        Assert.assertTrue( posicion.aledaniaA(otraPosicion) );
    }

    @Test
    public void verificaSiDosPosicionesSonAledaniasPorLaDiagonalInferiorIzquierdaCorrectamente(){
        Posicion posicion = new Posicion(2,3);
        Posicion otraPosicion = new Posicion(3,2);

        Assert.assertTrue( posicion.aledaniaA(otraPosicion) );
    }

    @Test
    public void verificaSiDosPosicionesSonAledaniasPorLaDiagonalInferiorDerechaCorrectamente(){
        Posicion posicion = new Posicion(2,3);
        Posicion otraPosicion = new Posicion(3,4);

        Assert.assertTrue( posicion.aledaniaA(otraPosicion) );
    }

    @Test
    public void verificarHorizontalYVerticalCorrecta() {
        Posicion posicion = new Posicion(5,10);
        Assert.assertEquals(posicion.getHorizontal(),5);
        Assert.assertEquals(posicion.getVertical(),10);
    }
}
