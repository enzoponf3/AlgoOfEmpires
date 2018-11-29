import Modelo.Edificios.*;
import Modelo.*;
import Modelo.Exceptions.*;
import Modelo.Unidades.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapaYIEntidadTest {

    //Modelo.Unidades

    @Test
    public void colocarUnObjetoAldeanoEnUnaPosicionDeterminadaDentroDelMapa(){
        Mapa mapa = new Mapa(10, 20);

        Posicion posicion = new Posicion(2,5);
        IEntidad IEntidad = new Aldeano(posicion);

        mapa.ocuparCasillero(posicion, IEntidad);
        Casillero casillero = mapa.seleccionarCasillero(posicion);
        Assert.assertTrue( casillero.estaOcupado() );

        IEntidad IEntidad2 = mapa.desocuparCasillero(posicion);
        Assert.assertEquals(IEntidad, IEntidad2);
    }

    @Test (expected = PosicionFueraDelMapaException.class)
    public void colocarUnObjetoAldeanoEnUnaPosicionFueraDelMapa(){
        Mapa mapa = new Mapa(10, 20);
        Posicion posicion = new Posicion(15,5);
        IEntidad IEntidad = new Aldeano(posicion);

        mapa.ocuparCasillero(posicion, IEntidad);
    }

    @Test
    public void colocarUnObjetoArqueroEnUnaPosicionDeterminadaDentroDelMapa(){
        Mapa mapa = new Mapa(10, 20);
        Posicion posicion = new Posicion(2,5);
        IEntidad IEntidad = new Arquero(posicion);

        mapa.ocuparCasillero(posicion, IEntidad);
        Casillero casillero = mapa.seleccionarCasillero(posicion);
        Assert.assertTrue( casillero.estaOcupado() );

        IEntidad IEntidad2 = mapa.desocuparCasillero(posicion);
        Assert.assertEquals(IEntidad, IEntidad2);
    }

    @Test (expected = PosicionFueraDelMapaException.class)
    public void colocarUnObjetoArqueroEnUnaPosicionFueraDelMapa(){
        Mapa mapa = new Mapa(10, 20);
        Posicion posicion = new Posicion(15,5);
        IEntidad IEntidad = new Arquero(posicion);

        mapa.ocuparCasillero(posicion, IEntidad);
    }

    @Test
    public void colocarUnObjetoEspadachinEnUnaPosicionDeterminadaDentroDelMapa(){
        Mapa mapa = new Mapa(10, 20);
        Posicion posicion = new Posicion(2,5);
        IEntidad IEntidad = new Espadachin(posicion);

        mapa.ocuparCasillero(posicion, IEntidad);
        Casillero casillero = mapa.seleccionarCasillero(posicion);
        Assert.assertTrue( casillero.estaOcupado() );

        IEntidad IEntidad2 = mapa.desocuparCasillero(posicion);
        Assert.assertEquals(IEntidad, IEntidad2);
    }

    @Test (expected = PosicionFueraDelMapaException.class)
    public void colocarUnObjetoEspadachinEnUnaPosicionFueraDelMapa(){
        Mapa mapa = new Mapa(10, 20);
        Posicion posicion = new Posicion(15,5);
        IEntidad IEntidad = new Espadachin(posicion);

        mapa.ocuparCasillero(posicion, IEntidad);
    }

    @Test
    public void colocarUnObjetoArmaDeAsedioEnUnaPosicionDeterminadaDentroDelMapa(){
        Mapa mapa = new Mapa(10, 20);
        Posicion posicion = new Posicion(2,5);
        IEntidad IEntidad = new ArmaDeAsedio(posicion);

        mapa.ocuparCasillero(posicion, IEntidad);
        Casillero casillero = mapa.seleccionarCasillero(posicion);
        Assert.assertTrue( casillero.estaOcupado() );

        IEntidad IEntidad2 = mapa.desocuparCasillero(posicion);
        Assert.assertEquals(IEntidad, IEntidad2);
    }

    @Test (expected = PosicionFueraDelMapaException.class)
    public void colocarUnObjetoArmaDeAsedioEnUnaPosicionFueraDelMapa(){
        Mapa mapa = new Mapa(10, 20);
        Posicion posicion = new Posicion(15,5);
        IEntidad IEntidad = new ArmaDeAsedio(posicion);

        mapa.ocuparCasillero(posicion, IEntidad);
    }

    //Modelo.Edificios

    @Test
    public void colocarUnObjetoCuartelEnUnaPosicionDeterminadaDentroDelMapa(){
        Mapa mapa = new Mapa(10, 20);
        Posicion posicion1 = new Posicion(2,5);
        Posicion posicion2 = new Posicion(2,4);
        Posicion posicion3 = new Posicion(3,5);
        Posicion posicion4 = new Posicion(3,4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        Cuartel cuartel = new Cuartel(posiciones);

        for (Posicion posicion : posiciones) {
            mapa.ocuparCasillero(posicion, cuartel);
            Casillero casillero = mapa.seleccionarCasillero(posicion);
            Assert.assertTrue(casillero.estaOcupado());
        }

    }

    @Test (expected = PosicionFueraDelMapaException.class)
    public void colocarUnObjetoCuartelEnUnaPosicionFueraDelMapa(){
        Mapa mapa = new Mapa(10, 20);
        Posicion posicion1 = new Posicion(-1,0);
        Posicion posicion2 = new Posicion(0,0);
        Posicion posicion3 = new Posicion(-1,1);
        Posicion posicion4 = new Posicion(0,1);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        Cuartel cuartel = new Cuartel(posiciones);

        for (Posicion posicion : posiciones) {
            mapa.ocuparCasillero(posicion, cuartel);
            Casillero casillero = mapa.seleccionarCasillero(posicion);
            Assert.assertTrue(casillero.estaOcupado());
        }
    }


    @Test
    public void colocarUnObjetoPlazaCentralEnUnaPosicionDeterminadaDentroDelMapa(){
        Mapa mapa = new Mapa(10, 20);
        Posicion posicion1 = new Posicion(2,5);
        Posicion posicion2 = new Posicion(2,4);
        Posicion posicion3 = new Posicion(3,5);
        Posicion posicion4 = new Posicion(3,4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        PlazaCentral plazaCentral = new PlazaCentral(posiciones);

        for (Posicion posicion : posiciones) {
            mapa.ocuparCasillero(posicion, plazaCentral);
            Casillero casillero = mapa.seleccionarCasillero(posicion);
            Assert.assertTrue(casillero.estaOcupado());
        }

    }

    @Test (expected = PosicionFueraDelMapaException.class)
    public void colocarUnObjetoPlazaCentralEnUnaPosicionFueraDelMapa(){
        Mapa mapa = new Mapa(10, 20);
        Posicion posicion1 = new Posicion(-1,0);
        Posicion posicion2 = new Posicion(0,0);
        Posicion posicion3 = new Posicion(-1,1);
        Posicion posicion4 = new Posicion(0,1);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        PlazaCentral plazaCentral = new PlazaCentral(posiciones);

        for (Posicion posicion : posiciones) {
            mapa.ocuparCasillero(posicion, plazaCentral);
            Casillero casillero = mapa.seleccionarCasillero(posicion);
            Assert.assertTrue(casillero.estaOcupado());
        }
    }


    @Test
    public void colocarUnObjetoCastilloEnUnaPosicionDeterminadaDentroDelMapa(){
        Mapa mapa = new Mapa(10, 20);
        Posicion posicion1 = new Posicion(1, 1);
        Posicion posicion2 = new Posicion(1, 2);
        Posicion posicion3 = new Posicion(1, 3);
        Posicion posicion4 = new Posicion(1, 4);
        Posicion posicion5 = new Posicion(2, 1);
        Posicion posicion6 = new Posicion(2, 2);
        Posicion posicion7 = new Posicion(2, 3);
        Posicion posicion8 = new Posicion(2, 4);
        Posicion posicion9 = new Posicion(3, 1);
        Posicion posicion10 = new Posicion(3, 2);
        Posicion posicion11 = new Posicion(3, 3);
        Posicion posicion12 = new Posicion(3, 4);
        Posicion posicion13 = new Posicion(4, 1);
        Posicion posicion14 = new Posicion(4, 2);
        Posicion posicion15 = new Posicion(4, 3);
        Posicion posicion16 = new Posicion(4, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        posiciones.add(posicion5);
        posiciones.add(posicion6);
        posiciones.add(posicion7);
        posiciones.add(posicion8);
        posiciones.add(posicion9);
        posiciones.add(posicion10);
        posiciones.add(posicion11);
        posiciones.add(posicion12);
        posiciones.add(posicion13);
        posiciones.add(posicion14);
        posiciones.add(posicion15);
        posiciones.add(posicion16);
        Castillo castillo = new Castillo(posiciones);

        for (Posicion posicion : posiciones) {
            mapa.ocuparCasillero(posicion, castillo);
            Casillero casillero = mapa.seleccionarCasillero(posicion);
            Assert.assertTrue(casillero.estaOcupado());
        }

    }

    @Test (expected = PosicionFueraDelMapaException.class)
    public void colocarUnObjetoCastilloEnUnaPosicionFueraDelMapa(){
        Mapa mapa = new Mapa(10, 20);
        Posicion posicion1 = new Posicion(-1, 1);
        Posicion posicion2 = new Posicion(1, 2);
        Posicion posicion3 = new Posicion(1, 3);
        Posicion posicion4 = new Posicion(1, 4);
        Posicion posicion5 = new Posicion(2, 1);
        Posicion posicion6 = new Posicion(2, 2);
        Posicion posicion7 = new Posicion(2, 3);
        Posicion posicion8 = new Posicion(2, 4);
        Posicion posicion9 = new Posicion(3, 1);
        Posicion posicion10 = new Posicion(3, 2);
        Posicion posicion11 = new Posicion(3, 3);
        Posicion posicion12 = new Posicion(3, 4);
        Posicion posicion13 = new Posicion(4, 1);
        Posicion posicion14 = new Posicion(4, 2);
        Posicion posicion15 = new Posicion(4, 3);
        Posicion posicion16 = new Posicion(4, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        posiciones.add(posicion5);
        posiciones.add(posicion6);
        posiciones.add(posicion7);
        posiciones.add(posicion8);
        posiciones.add(posicion9);
        posiciones.add(posicion10);
        posiciones.add(posicion11);
        posiciones.add(posicion12);
        posiciones.add(posicion13);
        posiciones.add(posicion14);
        posiciones.add(posicion15);
        posiciones.add(posicion16);
        Castillo castillo = new Castillo(posiciones);

        for (Posicion posicion : posiciones) {
            mapa.ocuparCasillero(posicion, castillo);
            Casillero casillero = mapa.seleccionarCasillero(posicion);
            Assert.assertTrue(casillero.estaOcupado());
        }
    }

    @Test
    public void obtenerPosicionAledaniaLibreConTodasLibresAlrededor() {
        Mapa mapa = new Mapa(3, 4);
        Posicion posicion1 = new Posicion(0,0);
        Posicion posicion2 = new Posicion(1,0);
        Posicion posicion3 = new Posicion(0,1);
        Posicion posicion4 = new Posicion(1,1);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        Cuartel cuartel = new Cuartel(posiciones);
        for (Posicion posicion : posiciones) mapa.ocuparCasillero(posicion, cuartel);
        Posicion posicionLibre = mapa.devolverPosicionAledaniaLibre(cuartel);
        Posicion posicionPosible1 = new Posicion(0,2);
        Posicion posicionPosible2 = new Posicion(1,2);
        Posicion posicionPosible3 = new Posicion(2,0);
        Posicion posicionPosible4 = new Posicion(2,1);
        Posicion posicionPosible5 = new Posicion(2,2);
        boolean posicionValida = posicionLibre.igualA(posicionPosible1) ||
                posicionLibre.igualA(posicionPosible2) ||
                posicionLibre.igualA(posicionPosible3) ||
                posicionLibre.igualA(posicionPosible4) ||
                posicionLibre.igualA(posicionPosible5);
        Assert.assertTrue(posicionValida);
    }

    @Test (expected = PosicionesAledaniasOcupadasException.class)
    public void obtenerPosicionAledaniaLibreConTodasOcupadasAlrededor() {
        Mapa mapa = new Mapa(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();

        for( int i=0; i<2; i++){
            for( int j=0; j<2; j++){
                Posicion posicion = new Posicion(i,j);
                posiciones.add(posicion);
            }
        }

        Cuartel cuartel = new Cuartel(posiciones);

        Posicion posicionAldeano1 = new Posicion(2,0);
        Posicion posicionAldeano2 = new Posicion(2,1);
        Posicion posicionAldeano3 = new Posicion(2,2);
        Posicion posicionAldeano4 = new Posicion(1,2);
        Posicion posicionAldeano5 = new Posicion(0,2);
        Aldeano aldeano1 = new Aldeano(posicionAldeano1);
        Aldeano aldeano2 = new Aldeano(posicionAldeano2);
        Aldeano aldeano3 = new Aldeano(posicionAldeano3);
        Aldeano aldeano4 = new Aldeano(posicionAldeano4);
        Aldeano aldeano5 = new Aldeano(posicionAldeano5);

        for (Posicion posicion : posiciones) mapa.ocuparCasillero(posicion, cuartel);

        mapa.ocuparCasillero(posicionAldeano1,aldeano1);
        mapa.ocuparCasillero(posicionAldeano2,aldeano2);
        mapa.ocuparCasillero(posicionAldeano3,aldeano3);
        mapa.ocuparCasillero(posicionAldeano4,aldeano4);
        mapa.ocuparCasillero(posicionAldeano5,aldeano5);

        mapa.devolverPosicionAledaniaLibre(cuartel);
    }

    @Test
    public void obtenerPosicionAledaniaLibreConUnaSolaLibreAlrededor() {
        Mapa mapa = new Mapa(3, 4);

        ArrayList<Posicion> posiciones = new ArrayList<>();

        for( int i=0; i<2; i++){
            for( int j=0; j<2; j++){
                Posicion posicion = new Posicion(i,j);
                posiciones.add(posicion);
            }
        }

        Cuartel cuartel = new Cuartel(posiciones);

        Posicion posicionAldeano1 = new Posicion(2,0);
        Posicion posicionAldeano2 = new Posicion(2,1);
        Posicion posicionAldeano3 = new Posicion(2,2);
        Posicion posicionAldeano4 = new Posicion(1,2);

        Aldeano aldeano1 = new Aldeano(posicionAldeano1);
        Aldeano aldeano2 = new Aldeano(posicionAldeano2);
        Aldeano aldeano3 = new Aldeano(posicionAldeano3);
        Aldeano aldeano4 = new Aldeano(posicionAldeano4);

        for (Posicion posicion : posiciones) mapa.ocuparCasillero(posicion, cuartel);

        mapa.ocuparCasillero(posicionAldeano1,aldeano1);
        mapa.ocuparCasillero(posicionAldeano2,aldeano2);
        mapa.ocuparCasillero(posicionAldeano3,aldeano3);
        mapa.ocuparCasillero(posicionAldeano4,aldeano4);

        Posicion posicionAledaniaLibre = new Posicion(0,2);
        Posicion posicionLibre = mapa.devolverPosicionAledaniaLibre(cuartel);
        Assert.assertTrue(posicionLibre.igualA(posicionAledaniaLibre));
    }
}