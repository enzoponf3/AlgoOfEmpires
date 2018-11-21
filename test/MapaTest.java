import Modelo.Exceptions.CasilleroDesocupadoException;
import Modelo.Exceptions.CasilleroOcupadoException;
import Modelo.Exceptions.MapaConDimensionesIncorrectasException;
import Modelo.Exceptions.PosicionFueraDelMapaException;
import Modelo.Casillero;
import Modelo.Mapa;
import Modelo.IEntidad;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

public class MapaTest {

    @Test
    public void crearMapaConMedidasCorrectas(){
        Mapa mapa = new Mapa(10, 20);

        Assert.assertEquals(20, mapa.getAlto());
        Assert.assertEquals(10, mapa.getAncho());
    }

    @Test
    public void crearMapaRectangularAnchoMayorALargo() {
        Mapa mapa = new Mapa(10,5);

        Assert.assertEquals(mapa.getAncho(), 10);
        Assert.assertEquals(mapa.getAlto(), 5);
    }

    @Test
    public void crearMapaRectangularAnchoMenorALargo() {
        Mapa mapa = new Mapa(5,10);

        Assert.assertEquals(mapa.getAncho(), 5);
        Assert.assertEquals(mapa.getAlto(), 10);
    }


    @Test (expected = MapaConDimensionesIncorrectasException.class)
    public void crearMapaConAnchoYLargoCero() {
        Mapa mapa = new Mapa(0,0);
    }

    @Test
    public void crearMapaYVerificarQueTodosSusCasillerosEstanDesocupados() {
        Mapa mapa = new Mapa(3,2);
        ArrayList<Casillero> casilleros;

        casilleros = mapa.devolverCasilleros();
        for (Casillero casillero : casilleros) {
            casillero.estaOcupado();
        }
    }

    @Test
    public void seleccionarUnCasillero(){
        Mapa mapa = new Mapa(10, 10);
        Posicion posicion = new Posicion(1,1);
        Casillero casillero;

        casillero = mapa.seleccionarCasillero(posicion);

        Assert.assertTrue( posicion.igualA(casillero.getPosicion()) );
    }


    @Test
    public void ocuparUnCasilleroVacio() {
        Mapa mapa = new Mapa(3,2);
        Posicion posicion = new Posicion(0,0);
        IEntidad IEntidad = new Aldeano();

        mapa.ocuparCasillero(posicion, IEntidad);
        Casillero casillero = mapa.seleccionarCasillero(posicion);

        Assert.assertTrue( casillero.estaOcupado() );
    }

    @Test (expected = CasilleroOcupadoException.class)
    public void ocuparUnCasilleroYaOcupado() {
        Mapa mapa = new Mapa(3,2);
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
        Mapa mapa = new Mapa(10,20);
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
        Mapa mapa = new Mapa(3,2);
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
    public void ocuparUnCasilleroDesocuparloYVerificarObtenerElMismoObjeto(){
        Mapa mapa = new Mapa(3,2);
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
        Mapa mapa = new Mapa(3,2);
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
        Mapa mapa = new Mapa(3,2);
        Posicion unaPosicion = new Posicion(0,0);

        mapa.desocuparCasillero(unaPosicion);
    }

    @Test
    public void ocuparVariosCasillerosYDesocuparUno() {
        Mapa mapa = new Mapa(10,20);
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
        Mapa mapa = new Mapa(5,2);

        Posicion posicion1 = new Posicion(10,0);
        IEntidad IEntidad1 = new Aldeano();

        mapa.ocuparCasillero(posicion1, IEntidad1);

    }

    @Test (expected = PosicionFueraDelMapaException.class)
    public void desocuparCasilleroFueraDelAnchoDelMapa() {
        Mapa mapa = new Mapa(5,2);
        Posicion posicion1 = new Posicion(10,0);
        IEntidad IEntidad1 = new Aldeano();

        mapa.ocuparCasillero(posicion1, IEntidad1);
    }

    @Test
    public void obtenerPosicionesAledaniasDePosicionMedioDevuelveCantidadCorrecta() {
        Mapa mapa = new Mapa(3,4);
        Posicion posicion = new Posicion(1,1);
        ArrayList<Posicion> posicionesAledanias;
        posicionesAledanias = mapa.getPosicionesAledanias(posicion);
        Assert.assertEquals(posicionesAledanias.size(),8);
    }

    @Test
    public void obtenerPosicionesAledaniasDePosicionEsquinaInferiorIzquierdaDevuelveCantidadCorrecta() {
        Mapa mapa = new Mapa(3,4);
        Posicion posicion = new Posicion(0,0);
        ArrayList<Posicion> posicionesAledanias;
        posicionesAledanias = mapa.getPosicionesAledanias(posicion);
        Assert.assertEquals(posicionesAledanias.size(),3);
    }

    @Test
    public void obtenerPosicionesAledaniasDePosicionEsquinaInferiorDerechaDevuelveCantidadCorrecta() {
        Mapa mapa = new Mapa(3,4);
        Posicion posicion = new Posicion(2,0);
        ArrayList<Posicion> posicionesAledanias;
        posicionesAledanias = mapa.getPosicionesAledanias(posicion);
        Assert.assertEquals(posicionesAledanias.size(),3);
    }

    @Test
    public void obtenerPosicionesAledaniasDePosicionEsquinaSuperiorIzquierdaDevuelveCantidadCorrecta() {
        Mapa mapa = new Mapa(3,4);
        Posicion posicion = new Posicion(0,3);
        ArrayList<Posicion> posicionesAledanias;
        posicionesAledanias = mapa.getPosicionesAledanias(posicion);
        Assert.assertEquals(posicionesAledanias.size(),3);
    }

    @Test
    public void obtenerPosicionesAledaniasDePosicionEsquinaSuperiorDerechaDevuelveCantidadCorrecta() {
        Mapa mapa = new Mapa(3,4);
        Posicion posicion = new Posicion(2,3);
        ArrayList<Posicion> posicionesAledanias;
        posicionesAledanias = mapa.getPosicionesAledanias(posicion);
        Assert.assertEquals(posicionesAledanias.size(),3);
    }

    @Test
    public void obtenerPosicionesAledaniasDePosicionBordeInferiorDevuelveCantidadCorrecta() {
        Mapa mapa = new Mapa(3,4);
        Posicion posicion = new Posicion(0,1);
        ArrayList<Posicion> posicionesAledanias;
        posicionesAledanias = mapa.getPosicionesAledanias(posicion);
        Assert.assertEquals(posicionesAledanias.size(),5);
    }

    @Test
    public void obtenerPosicionesAledaniasDePosicionBordeSuperiorDevuelveCantidadCorrecta() {
        Mapa mapa = new Mapa(3,4);
        Posicion posicion = new Posicion(1,3);
        ArrayList<Posicion> posicionesAledanias;
        posicionesAledanias = mapa.getPosicionesAledanias(posicion);
        Assert.assertEquals(posicionesAledanias.size(),5);
    }

    @Test
    public void obtenerPosicionesAledaniasDePosicionBordeDerechaDevuelveCantidadCorrecta() {
        Mapa mapa = new Mapa(3,4);
        Posicion posicion = new Posicion(2,1);
        ArrayList<Posicion> posicionesAledanias;
        posicionesAledanias = mapa.getPosicionesAledanias(posicion);
        Assert.assertEquals(posicionesAledanias.size(),5);
    }

    @Test
    public void obtenerPosicionesAledaniasDePosicionBordeIzquierdaDevuelveCantidadCorrecta() {
        Mapa mapa = new Mapa(3,4);
        Posicion posicion = new Posicion(0,1);
        ArrayList<Posicion> posicionesAledanias;
        posicionesAledanias = mapa.getPosicionesAledanias(posicion);
        Assert.assertEquals(posicionesAledanias.size(),5);
    }
}
