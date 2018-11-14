import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class MapaYObjetoTest {

    //Unidades

    @Test
    public void colocarUnObjetoAldeanoEnUnaPosicionDeterminadaDentroDelMapa(){
        Mapa2 mapa = new Mapa2(10, 20);
        Objeto objeto = new Aldeano();
        Posicion posicion = new Posicion(2,5);

        mapa.ocuparCasillero(posicion, objeto);
        Casillero casillero = mapa.seleccionarCasillero(posicion);
        Assert.assertTrue( casillero.estaOcupado() );

        Objeto objeto2 = mapa.desocuparCasillero(posicion);
        Assert.assertEquals( objeto, objeto2 );
    }

    @Test (expected = PosicionFueraDelMapaException.class)
    public void colocarUnObjetoAldeanoEnUnaPosicionFueraDelMapa(){
        Mapa2 mapa = new Mapa2(10, 20);
        Objeto objeto = new Aldeano();
        Posicion posicion = new Posicion(15,5);

        mapa.ocuparCasillero(posicion, objeto);
    }

    @Test
    public void colocarUnObjetoArqueroEnUnaPosicionDeterminadaDentroDelMapa(){
        Mapa2 mapa = new Mapa2(10, 20);
        Objeto objeto = new Arquero();
        Posicion posicion = new Posicion(2,5);

        mapa.ocuparCasillero(posicion, objeto);
        Casillero casillero = mapa.seleccionarCasillero(posicion);
        Assert.assertTrue( casillero.estaOcupado() );

        Objeto objeto2 = mapa.desocuparCasillero(posicion);
        Assert.assertEquals( objeto, objeto2 );
    }

    @Test (expected = PosicionFueraDelMapaException.class)
    public void colocarUnObjetoArqueroEnUnaPosicionFueraDelMapa(){
        Mapa2 mapa = new Mapa2(10, 20);
        Objeto objeto = new Arquero();
        Posicion posicion = new Posicion(15,5);

        mapa.ocuparCasillero(posicion, objeto);
    }

    @Test
    public void colocarUnObjetoEspadachinEnUnaPosicionDeterminadaDentroDelMapa(){
        Mapa2 mapa = new Mapa2(10, 20);
        Objeto objeto = new Espadachin();
        Posicion posicion = new Posicion(2,5);

        mapa.ocuparCasillero(posicion, objeto);
        Casillero casillero = mapa.seleccionarCasillero(posicion);
        Assert.assertTrue( casillero.estaOcupado() );

        Objeto objeto2 = mapa.desocuparCasillero(posicion);
        Assert.assertEquals( objeto, objeto2 );
    }

    @Test (expected = PosicionFueraDelMapaException.class)
    public void colocarUnObjetoEspadachinEnUnaPosicionFueraDelMapa(){
        Mapa2 mapa = new Mapa2(10, 20);
        Objeto objeto = new Espadachin();
        Posicion posicion = new Posicion(15,5);

        mapa.ocuparCasillero(posicion, objeto);
    }

    @Test
    public void colocarUnObjetoArmaDeAsedioEnUnaPosicionDeterminadaDentroDelMapa(){
        Mapa2 mapa = new Mapa2(10, 20);
        Objeto objeto = new ArmaDeAsedio();
        Posicion posicion = new Posicion(2,5);

        mapa.ocuparCasillero(posicion, objeto);
        Casillero casillero = mapa.seleccionarCasillero(posicion);
        Assert.assertTrue( casillero.estaOcupado() );

        Objeto objeto2 = mapa.desocuparCasillero(posicion);
        Assert.assertEquals( objeto, objeto2 );
    }

    @Test (expected = PosicionFueraDelMapaException.class)
    public void colocarUnObjetoArmaDeAsedioEnUnaPosicionFueraDelMapa(){
        Mapa2 mapa = new Mapa2(10, 20);
        Objeto objeto = new ArmaDeAsedio();
        Posicion posicion = new Posicion(15,5);

        mapa.ocuparCasillero(posicion, objeto);
    }

    //Edificios

    @Test
    public void colocarUnObjetoCuartelEnUnaPosicionDeterminadaDentroDelMapa(){
        Mapa2 mapa = new Mapa2(10, 20);
        Cuartel cuartel = new Cuartel();
        Posicion posicion1 = new Posicion(2,5);
        Posicion posicion2 = new Posicion(2,4);
        Posicion posicion3 = new Posicion(3,5);
        Posicion posicion4 = new Posicion(3,4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        cuartel.setPosiciones(posiciones);

        for(int i=0; i<posiciones.size(); i++){
            mapa.ocuparCasillero(posiciones.get(i), cuartel);
            Casillero casillero = mapa.seleccionarCasillero(posiciones.get(i));
            Assert.assertTrue( casillero.estaOcupado() );
        }

    }

    @Test (expected = PosicionFueraDelMapaException.class)
    public void colocarUnObjetoCuartelEnUnaPosicionFueraDelMapa(){
        Mapa2 mapa = new Mapa2(10, 20);
        Cuartel cuartel = new Cuartel();
        Posicion posicion1 = new Posicion(-1,0);
        Posicion posicion2 = new Posicion(0,0);
        Posicion posicion3 = new Posicion(-1,1);
        Posicion posicion4 = new Posicion(0,1);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        cuartel.setPosiciones(posiciones);

        for(int i=0; i<posiciones.size(); i++){
            mapa.ocuparCasillero(posiciones.get(i), cuartel);
            Casillero casillero = mapa.seleccionarCasillero(posiciones.get(i));
            Assert.assertTrue( casillero.estaOcupado() );
        }
    }


    @Test
    public void colocarUnObjetoPlazaCentralEnUnaPosicionDeterminadaDentroDelMapa(){
        Mapa2 mapa = new Mapa2(10, 20);
        PlazaCentral plazaCentral = new PlazaCentral();
        Posicion posicion1 = new Posicion(2,5);
        Posicion posicion2 = new Posicion(2,4);
        Posicion posicion3 = new Posicion(3,5);
        Posicion posicion4 = new Posicion(3,4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        plazaCentral.setPosiciones(posiciones);

        for(int i=0; i<posiciones.size(); i++){
            mapa.ocuparCasillero(posiciones.get(i), plazaCentral);
            Casillero casillero = mapa.seleccionarCasillero(posiciones.get(i));
            Assert.assertTrue( casillero.estaOcupado() );
        }

    }

    @Test (expected = PosicionFueraDelMapaException.class)
    public void colocarUnObjetoPlazaCentralEnUnaPosicionFueraDelMapa(){
        Mapa2 mapa = new Mapa2(10, 20);
        PlazaCentral plazaCentral = new PlazaCentral();
        Posicion posicion1 = new Posicion(-1,0);
        Posicion posicion2 = new Posicion(0,0);
        Posicion posicion3 = new Posicion(-1,1);
        Posicion posicion4 = new Posicion(0,1);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        plazaCentral.setPosiciones(posiciones);

        for(int i=0; i<posiciones.size(); i++){
            mapa.ocuparCasillero(posiciones.get(i), plazaCentral);
            Casillero casillero = mapa.seleccionarCasillero(posiciones.get(i));
            Assert.assertTrue( casillero.estaOcupado() );
        }
    }


    @Test
    public void colocarUnObjetoCastilloEnUnaPosicionDeterminadaDentroDelMapa(){
        Mapa2 mapa = new Mapa2(10, 20);
        Castillo castillo = new Castillo();
        Posicion posicion1 = new Posicion(2,5);
        Posicion posicion2 = new Posicion(2,4);
        Posicion posicion3 = new Posicion(3,5);
        Posicion posicion4 = new Posicion(3,4);
        Posicion posicion5 = new Posicion(4,5);
        Posicion posicion6 = new Posicion(4,4);
        Posicion posicion7 = new Posicion(5,5);
        Posicion posicion8 = new Posicion(5,4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        posiciones.add(posicion5);
        posiciones.add(posicion6);
        posiciones.add(posicion7);
        posiciones.add(posicion8);
        castillo.setPosiciones(posiciones);

        for(int i=0; i<posiciones.size(); i++){
            mapa.ocuparCasillero(posiciones.get(i), castillo);
            Casillero casillero = mapa.seleccionarCasillero(posiciones.get(i));
            Assert.assertTrue( casillero.estaOcupado() );
        }

    }

    @Test (expected = PosicionFueraDelMapaException.class)
    public void colocarUnObjetoCastilloEnUnaPosicionFueraDelMapa(){
        Mapa2 mapa = new Mapa2(10, 20);
        Castillo castillo = new Castillo();
        Posicion posicion1 = new Posicion(-1,0);
        Posicion posicion2 = new Posicion(0,0);
        Posicion posicion3 = new Posicion(-1,1);
        Posicion posicion4 = new Posicion(0,1);
        Posicion posicion5 = new Posicion(1,0);
        Posicion posicion6 = new Posicion(1,1);
        Posicion posicion7 = new Posicion(2,0);
        Posicion posicion8 = new Posicion(2,1);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        posiciones.add(posicion5);
        posiciones.add(posicion6);
        posiciones.add(posicion7);
        posiciones.add(posicion8);
        castillo.setPosiciones(posiciones);

        for(int i=0; i<posiciones.size(); i++){
            mapa.ocuparCasillero(posiciones.get(i), castillo);
            Casillero casillero = mapa.seleccionarCasillero(posiciones.get(i));
            Assert.assertTrue( casillero.estaOcupado() );
        }
    }


}