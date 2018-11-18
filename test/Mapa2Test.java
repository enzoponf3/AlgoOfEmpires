import Modelo.Exceptions.CasilleroDesocupadoException;
import Modelo.Exceptions.CasilleroOcupadoException;
import Modelo.Exceptions.MapaConDimensionesIncorrectasException;
import Modelo.Exceptions.PosicionFueraDelMapaException;
import Modelo.Casillero;
import Modelo.Mapa2;
import Modelo.Objeto;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import java.util.Iterator;

public class Mapa2Test {

    @Test
    public void crearMapaConMedidasCorrectas(){
        Mapa2 mapa = new Mapa2(10, 20);
        int alto = mapa.getAlto();
        int ancho = mapa.getAncho();

        Assert.assertEquals(20, mapa.getAlto());
        Assert.assertEquals(10, mapa.getAncho());
    }

    @Test
    public void crearMapaRectangularAnchoMayorALargo() {
        Mapa2 mapa = new Mapa2(10,5);
        Assert.assertEquals(mapa.getAncho(), 10);
        Assert.assertEquals(mapa.getAlto(), 5);
    }

    @Test
    public void crearMapaRectangularAnchoMenorALargo() {
        Mapa2 mapa = new Mapa2(5,10);
        Assert.assertEquals(mapa.getAncho(), 5);
        Assert.assertEquals(mapa.getAlto(), 10);
    }


    @Test (expected = MapaConDimensionesIncorrectasException.class)
    public void crearMapaConAnchoYLargoCero() {
        Mapa2 mapa = new Mapa2(0,0);
    }

    @Test
    public void crearMapaYVerificarQueTodosSusCasillerosEstanDesocupados() {
        Mapa2 mapa = new Mapa2(3,2);
        ArrayList<Casillero> casilleros;

        casilleros = mapa.devolverCasilleros();
        for (Iterator<Casillero> iterator = casilleros.iterator(); iterator.hasNext();) {
            iterator.next().estaOcupado();
        }
    } //Creo que esta prueba esta mal porque es dependiente de la implementacion, pero no se me ocurre otra forma.


    @Test
    public void seleccionarUnCasillero(){
        Mapa2 mapa = new Mapa2(10, 10);
        Posicion posicion = new Posicion(1,1);
        Casillero casillero;

        casillero = mapa.seleccionarCasillero(posicion);

        Assert.assertTrue( posicion.igualA(casillero.getPosicion()) );
    }// Revisar, actualmente tengo que crear un casillero para poder hacer la comparacion sin romper el encapslamiento.


    @Test
    public void ocuparUnCasilleroVacio() {
        Mapa2 mapa = new Mapa2(3,2);
        Posicion posicion = new Posicion(0,0);
        Objeto objeto = new Aldeano();

        mapa.ocuparCasillero(posicion, objeto);
        Casillero casillero = mapa.seleccionarCasillero(posicion);

        Assert.assertTrue( casillero.estaOcupado() );
    }

    @Test (expected = CasilleroOcupadoException.class)
    public void ocuparUnCasilleroYaOcupado() {
        Mapa2 mapa = new Mapa2(3,2);
        Posicion posicion = new Posicion(0,0);
        Objeto unObjeto = new Aldeano();
        Objeto otroObjeto = new Aldeano();

        mapa.ocuparCasillero(posicion, unObjeto);
        Casillero casillero = mapa.seleccionarCasillero(posicion);
        Assert.assertTrue( casillero.estaOcupado() );

        mapa.ocuparCasillero(posicion, otroObjeto);
    }

    @Test
    public void ocuparCasillerosDistintosConObjetosDistintos() {
        Mapa2 mapa = new Mapa2(10,20);
        Posicion unaPosicion = new Posicion(0,0);
        Posicion otraPosicion = new Posicion(4,5);
        Objeto unObjeto = new Aldeano();
        Objeto otroObjeto = new Aldeano();

        mapa.ocuparCasillero(unaPosicion, unObjeto);
        Casillero casillero = mapa.seleccionarCasillero(unaPosicion);
        Assert.assertTrue( casillero.estaOcupado() );

        mapa.ocuparCasillero(otraPosicion, otroObjeto);
        casillero = mapa.seleccionarCasillero(otraPosicion);
        Assert.assertTrue( casillero.estaOcupado() );
    }

    @Test
    public void ocuparUnCasillerosYDespuesDesocuparlo() {
        Mapa2 mapa = new Mapa2(3,2);
        Posicion unaPosicion = new Posicion(0,0);
        Posicion otraPosicion = new Posicion(4,5);
        Objeto unObjeto = new Aldeano();

        mapa.ocuparCasillero(unaPosicion, unObjeto);
        Casillero casillero = mapa.seleccionarCasillero(unaPosicion);
        Assert.assertTrue( casillero.estaOcupado() );

        mapa.desocuparCasillero(unaPosicion);
        casillero = mapa.seleccionarCasillero(unaPosicion);
        Assert.assertFalse( casillero.estaOcupado() );

    }


    @Test
    public void OcuparUnCasilleroDesocuparloYVerificarObtenerElMismoObjeto(){
        Mapa2 mapa = new Mapa2(3,2);
        Posicion unaPosicion = new Posicion(0,0);
        Posicion otraPosicion = new Posicion(4,5);
        Objeto unObjeto = new Aldeano();

        mapa.ocuparCasillero(unaPosicion, unObjeto);
        Casillero casillero = mapa.seleccionarCasillero(unaPosicion);
        Assert.assertTrue( casillero.estaOcupado() );

        Objeto otroObjeto = mapa.desocuparCasillero(unaPosicion);
        casillero = mapa.seleccionarCasillero(unaPosicion);
        Assert.assertEquals(unObjeto, otroObjeto);
    }

    @Test (expected = CasilleroOcupadoException.class)
    public void ocuparUnCasilleroOcupadoLanzaCasilleroOcupadoException() {
        Mapa2 mapa = new Mapa2(3,2);
        Posicion unaPosicion = new Posicion(0,0);
        Objeto unObjeto = new Aldeano();
        Objeto otroObjeto = new Aldeano();

        mapa.ocuparCasillero(unaPosicion, unObjeto);
        Casillero casillero = mapa.seleccionarCasillero(unaPosicion);
        Assert.assertTrue( casillero.estaOcupado() );

        mapa.ocuparCasillero(unaPosicion, otroObjeto);
    }

    @Test (expected = CasilleroDesocupadoException.class)
    public void desocuparCasilleroNoOcupado() {
        Mapa2 mapa = new Mapa2(3,2);
        Posicion unaPosicion = new Posicion(0,0);

        mapa.desocuparCasillero(unaPosicion);
    }

    @Test
    public void ocuparVariosCasillerosYDesocuparUno() {
        Mapa2 mapa = new Mapa2(10,20);
        Posicion posicion1 = new Posicion(0,0);
        Posicion posicion2 = new Posicion(4,5);
        Posicion posicion3 = new Posicion(4,6);
        Objeto objeto1 = new Aldeano();
        Objeto objeto2 = new Aldeano();
        Objeto objeto3 = new Aldeano();

        mapa.ocuparCasillero(posicion1, objeto1);
        Casillero casillero1 = mapa.seleccionarCasillero(posicion1);
        Assert.assertTrue( casillero1.estaOcupado() );

        mapa.ocuparCasillero(posicion2, objeto2);
        Casillero casillero2 = mapa.seleccionarCasillero(posicion2);
        Assert.assertTrue( casillero2.estaOcupado() );

        mapa.ocuparCasillero(posicion3, objeto3);
        Casillero casillero3 = mapa.seleccionarCasillero(posicion3);
        Assert.assertTrue( casillero3.estaOcupado() );

        mapa.desocuparCasillero(posicion1);
        Casillero casilleroUno = mapa.seleccionarCasillero(posicion1);
        Assert.assertFalse( casilleroUno.estaOcupado() );
    }

    @Test (expected = PosicionFueraDelMapaException.class)
    public void ocuparCasilleroFueraDelAnchoDelMapa() {
        Mapa2 mapa = new Mapa2(5,2);

        Posicion posicion1 = new Posicion(10,0);
        Objeto objeto1 = new Aldeano();

        mapa.ocuparCasillero(posicion1, objeto1);

    }

    @Test (expected = PosicionFueraDelMapaException.class)
    public void desocuparCasilleroFueraDelAnchoDelMapa() {
        Mapa2 mapa = new Mapa2(5,2);
        Posicion posicion1 = new Posicion(10,0);
        Objeto objeto1 = new Aldeano();

        mapa.ocuparCasillero(posicion1, objeto1);
    }

}
