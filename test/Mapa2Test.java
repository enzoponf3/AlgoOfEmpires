import Modelo.Exceptions.CasilleroDesocupadoException;
import Modelo.Exceptions.CasilleroOcupadoException;
import Modelo.Exceptions.MapaConDimensionesIncorrectasException;
import Modelo.Exceptions.PosicionFueraDelMapaException;
import Modelo.Casillero;
import Modelo.Mapa2;
import Modelo.IEntidad;
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
        for (Casillero casillero : casilleros) {
            casillero.estaOcupado();
        }
    }

    @Test
    public void seleccionarUnCasillero(){
        Mapa2 mapa = new Mapa2(10, 10);
        Posicion posicion = new Posicion(1,1);
        Casillero casillero;

        casillero = mapa.seleccionarCasillero(posicion);

        Assert.assertTrue( posicion.igualA(casillero.getPosicion()) );
    }


    @Test
    public void ocuparUnCasilleroVacio() {
        Mapa2 mapa = new Mapa2(3,2);
        Posicion posicion = new Posicion(0,0);
        IEntidad IEntidad = new Aldeano();

        mapa.ocuparCasillero(posicion, IEntidad);
        Casillero casillero = mapa.seleccionarCasillero(posicion);

        Assert.assertTrue( casillero.estaOcupado() );
    }

    @Test (expected = CasilleroOcupadoException.class)
    public void ocuparUnCasilleroYaOcupado() {
        Mapa2 mapa = new Mapa2(3,2);
        Posicion posicion = new Posicion(0,0);
        IEntidad unIEntidad = new Aldeano();
        IEntidad otroIEntidad = new Aldeano();

        mapa.ocuparCasillero(posicion, unIEntidad);
        Casillero casillero = mapa.seleccionarCasillero(posicion);
        Assert.assertTrue( casillero.estaOcupado() );

        mapa.ocuparCasillero(posicion, otroIEntidad);
    }

    @Test
    public void ocuparCasillerosDistintosConObjetosDistintos() {
        Mapa2 mapa = new Mapa2(10,20);
        Posicion unaPosicion = new Posicion(0,0);
        Posicion otraPosicion = new Posicion(4,5);
        IEntidad unIEntidad = new Aldeano();
        IEntidad otroIEntidad = new Aldeano();

        mapa.ocuparCasillero(unaPosicion, unIEntidad);
        Casillero casillero = mapa.seleccionarCasillero(unaPosicion);
        Assert.assertTrue( casillero.estaOcupado() );

        mapa.ocuparCasillero(otraPosicion, otroIEntidad);
        casillero = mapa.seleccionarCasillero(otraPosicion);
        Assert.assertTrue( casillero.estaOcupado() );
    }

    @Test
    public void ocuparUnCasillerosYDespuesDesocuparlo() {
        Mapa2 mapa = new Mapa2(3,2);
        Posicion unaPosicion = new Posicion(0,0);
        Posicion otraPosicion = new Posicion(4,5);
        IEntidad unIEntidad = new Aldeano();

        mapa.ocuparCasillero(unaPosicion, unIEntidad);
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
        IEntidad unIEntidad = new Aldeano();

        mapa.ocuparCasillero(unaPosicion, unIEntidad);
        Casillero casillero = mapa.seleccionarCasillero(unaPosicion);
        Assert.assertTrue( casillero.estaOcupado() );

        IEntidad otroIEntidad = mapa.desocuparCasillero(unaPosicion);
        casillero = mapa.seleccionarCasillero(unaPosicion);
        Assert.assertEquals(unIEntidad, otroIEntidad);
    }

    @Test (expected = CasilleroOcupadoException.class)
    public void ocuparUnCasilleroOcupadoLanzaCasilleroOcupadoException() {
        Mapa2 mapa = new Mapa2(3,2);
        Posicion unaPosicion = new Posicion(0,0);
        IEntidad unIEntidad = new Aldeano();
        IEntidad otroIEntidad = new Aldeano();

        mapa.ocuparCasillero(unaPosicion, unIEntidad);
        Casillero casillero = mapa.seleccionarCasillero(unaPosicion);
        Assert.assertTrue( casillero.estaOcupado() );

        mapa.ocuparCasillero(unaPosicion, otroIEntidad);
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
        IEntidad IEntidad1 = new Aldeano();
        IEntidad IEntidad2 = new Aldeano();
        IEntidad IEntidad3 = new Aldeano();

        mapa.ocuparCasillero(posicion1, IEntidad1);
        Casillero casillero1 = mapa.seleccionarCasillero(posicion1);
        Assert.assertTrue( casillero1.estaOcupado() );

        mapa.ocuparCasillero(posicion2, IEntidad2);
        Casillero casillero2 = mapa.seleccionarCasillero(posicion2);
        Assert.assertTrue( casillero2.estaOcupado() );

        mapa.ocuparCasillero(posicion3, IEntidad3);
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
        IEntidad IEntidad1 = new Aldeano();

        mapa.ocuparCasillero(posicion1, IEntidad1);

    }

    @Test (expected = PosicionFueraDelMapaException.class)
    public void desocuparCasilleroFueraDelAnchoDelMapa() {
        Mapa2 mapa = new Mapa2(5,2);
        Posicion posicion1 = new Posicion(10,0);
        IEntidad IEntidad1 = new Aldeano();

        mapa.ocuparCasillero(posicion1, IEntidad1);
    }

}
