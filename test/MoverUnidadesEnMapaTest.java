import Modelo.Exceptions.PosicionFueraDelMapaException;
import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Exceptions.PosicionOcupadaException;
import Modelo.Mapa;
import Modelo.Unidades.Aldeano;
import org.junit.Assert;
import org.junit.Test;

import Modelo.Casillero;
import Modelo.IEntidad;
import Modelo.Posicion;
import Modelo.Unidades.*;


public class MoverUnidadesEnMapaTest {

    //Movimiento a posicion desocupada

    @Test
    public void moverAldeanoAUnCasilleroAledanioDesocupadoDentroDelMapa(){
        Mapa mapa = new Mapa(10, 20);
        Aldeano aldeano = new Aldeano();
        Posicion origen = new Posicion(2,5);
        Posicion destino = new Posicion(2,6);

        mapa.ocuparCasillero(origen, aldeano);
        mapa.moverUnidadMovil(origen, destino);

        Casillero casilleroOrigen = mapa.seleccionarCasillero(origen);;
        Casillero casilleroDestino = mapa.seleccionarCasillero(destino);

        Assert.assertFalse( casilleroOrigen.estaOcupado() );
        Assert.assertTrue( casilleroDestino.estaOcupado() );
        IEntidad aldeano2 = mapa.desocuparCasillero(destino);
        Assert.assertEquals( aldeano, aldeano2 );
    }

    @Test
    public void moverArqueroAUnCasilleroAledanioDesocupadoDentroDelMapa(){
        Mapa mapa = new Mapa(10, 20);
        Arquero arquero = new Arquero();
        Posicion origen = new Posicion(2,5);
        Posicion destino = new Posicion(2,6);

        mapa.ocuparCasillero(origen, arquero);
        mapa.moverUnidadMovil(origen, destino);

        Casillero casilleroOrigen = mapa.seleccionarCasillero(origen);;
        Casillero casilleroDestino = mapa.seleccionarCasillero(destino);

        Assert.assertFalse( casilleroOrigen.estaOcupado() );
        Assert.assertTrue( casilleroDestino.estaOcupado() );
        IEntidad arquero2 = mapa.desocuparCasillero(destino);
        Assert.assertEquals( arquero, arquero2 );
    }

    @Test
    public void moverEspadachinAUnCasilleroAledanioDesocupadoDentroDelMapa(){
        Mapa mapa = new Mapa(10, 20);
        Espadachin espadachin = new Espadachin();
        Posicion origen = new Posicion(2,5);
        Posicion destino = new Posicion(2,6);

        mapa.ocuparCasillero(origen, espadachin);
        mapa.moverUnidadMovil(origen, destino);

        Casillero casilleroOrigen = mapa.seleccionarCasillero(origen);;
        Casillero casilleroDestino = mapa.seleccionarCasillero(destino);

        Assert.assertFalse( casilleroOrigen.estaOcupado() );
        Assert.assertTrue( casilleroDestino.estaOcupado() );
        IEntidad espadachin2 = mapa.desocuparCasillero(destino);
        Assert.assertEquals( espadachin, espadachin2 );
    }

    @Test
    public void moverArmaDeAsedioAUnCasilleroAledanioDesocupadoDentroDelMapa(){
        Mapa mapa = new Mapa(10, 20);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        Posicion origen = new Posicion(2,5);
        Posicion destino = new Posicion(2,6);

        mapa.ocuparCasillero(origen, armaDeAsedio);
        mapa.moverUnidadMovil(origen, destino);

        Casillero casilleroOrigen = mapa.seleccionarCasillero(origen);;
        Casillero casilleroDestino = mapa.seleccionarCasillero(destino);

        Assert.assertFalse( casilleroOrigen.estaOcupado() );
        Assert.assertTrue( casilleroDestino.estaOcupado() );
        IEntidad armaDeAsedio2 = mapa.desocuparCasillero(destino);
        Assert.assertEquals( armaDeAsedio, armaDeAsedio2 );
    }

    //Movimiento a posicion ocupada lanza exception

    @Test (expected = PosicionOcupadaException.class)
    public void moverAldeanoAUnCasilleroAledanioOcupadoDentroDelMapa(){
        Mapa mapa = new Mapa(10, 20);
        Aldeano aldeano = new Aldeano();
        Aldeano aldeano2 = new Aldeano();
        Posicion origen = new Posicion(2,5);
        Posicion destino = new Posicion(2,6);

        mapa.ocuparCasillero(origen, aldeano);
        mapa.ocuparCasillero(destino, aldeano2);
        mapa.moverUnidadMovil(origen, destino);

    }

    @Test (expected = PosicionOcupadaException.class)
    public void moverArqueroUnCasilleroAledanioOcupadoDentroDelMapa(){
        Mapa mapa = new Mapa(10, 20);
        Arquero arquero = new Arquero();
        Arquero arquero2 = new Arquero();
        Posicion origen = new Posicion(2,5);
        Posicion destino = new Posicion(2,6);

        mapa.ocuparCasillero(origen, arquero);
        mapa.ocuparCasillero(destino, arquero2);
        mapa.moverUnidadMovil(origen, destino);

    }

    @Test (expected = PosicionOcupadaException.class)
    public void moverEspadachinUnCasilleroAledanioOcupadoDentroDelMapa(){
        Mapa mapa = new Mapa(10, 20);
        Espadachin espadachin = new Espadachin();
        Espadachin espadachin2 = new Espadachin();
        Posicion origen = new Posicion(2,5);
        Posicion destino = new Posicion(2,6);

        mapa.ocuparCasillero(origen, espadachin);
        mapa.ocuparCasillero(destino, espadachin2);
        mapa.moverUnidadMovil(origen, destino);

    }

    @Test (expected = PosicionOcupadaException.class)
    public void moverArmaDeAsedioUnCasilleroAledanioOcupadoDentroDelMapa(){
        Mapa mapa = new Mapa(10, 20);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        ArmaDeAsedio armaDeAsedio2 = new ArmaDeAsedio();
        Posicion origen = new Posicion(2,5);
        Posicion destino = new Posicion(2,6);

        mapa.ocuparCasillero(origen, armaDeAsedio);
        mapa.ocuparCasillero(destino, armaDeAsedio2);
        mapa.moverUnidadMovil(origen, destino);

    }


    //Movimiento a posicion fuera del mapa lanza exception

    @Test (expected = PosicionFueraDelMapaException.class)
    public void moverAldeanoAUnCasilleroAledanioFueraDelMapa(){
        Mapa mapa = new Mapa(10, 20);
        Aldeano aldeano = new Aldeano();
        Posicion origen = new Posicion(10,20);
        Posicion destino = new Posicion(10,21);

        mapa.ocuparCasillero(origen, aldeano);
        mapa.moverUnidadMovil(origen, destino);

    }

    @Test (expected = PosicionFueraDelMapaException.class)
    public void moverArqueroAUnCasilleroAledanioFueraDelMapa(){
        Mapa mapa = new Mapa(10, 20);
        Arquero arquero = new Arquero();
        Posicion origen = new Posicion(10,20);
        Posicion destino = new Posicion(10,21);

        mapa.ocuparCasillero(origen, arquero);
        mapa.moverUnidadMovil(origen, destino);

    }

    @Test (expected = PosicionFueraDelMapaException.class)
    public void moverEspadachinAUnCasilleroAledanioFueraDelMapa() {
        Mapa mapa = new Mapa(10, 20);
        Espadachin espadachin = new Espadachin();
        Posicion origen = new Posicion(10, 20);
        Posicion destino = new Posicion(10, 21);

        mapa.ocuparCasillero(origen, espadachin);
        mapa.moverUnidadMovil(origen, destino);

    }

    @Test (expected = PosicionFueraDelMapaException.class)
    public void moverArmaDeAsedioAUnCasilleroAledanioFueraDelMapa() {
        Mapa mapa = new Mapa(10, 20);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        Posicion origen = new Posicion(10, 20);
        Posicion destino = new Posicion(10, 21);

        mapa.ocuparCasillero(origen, armaDeAsedio);
        mapa.moverUnidadMovil(origen, destino);

    }

    //Mover mas de un casillero a la vez no se puede

    @Test (expected = PosicionInvalidaException.class)
    public void moverAldeanoAUnCasilleroNoAledanioDentroDelMapa(){
        Mapa mapa = new Mapa(10, 20);
        Aldeano aldeano = new Aldeano();
        Posicion origen = new Posicion(2,5);
        Posicion destino = new Posicion(4,8);

        mapa.ocuparCasillero(origen, aldeano);
        mapa.moverUnidadMovil(origen, destino);

    }

    @Test (expected = PosicionInvalidaException.class)
    public void moverArqueroAUnCasilleroNoAledanioDentroDelMapa(){
        Mapa mapa = new Mapa(10, 20);
        Arquero arquero = new Arquero();
        Posicion origen = new Posicion(2,5);
        Posicion destino = new Posicion(4,8);

        mapa.ocuparCasillero(origen, arquero);
        mapa.moverUnidadMovil(origen, destino);

    }

    @Test (expected = PosicionInvalidaException.class)
    public void moverEspadachinAUnCasilleroNoAledanioDentroDelMapa(){
        Mapa mapa = new Mapa(10, 20);
        Espadachin espadachin = new Espadachin();
        Posicion origen = new Posicion(2,5);
        Posicion destino = new Posicion(4,8);

        mapa.ocuparCasillero(origen, espadachin);
        mapa.moverUnidadMovil(origen, destino);

    }

    @Test (expected = PosicionInvalidaException.class)
    public void moverArmaDeAsedioAUnCasilleroNoAledanioDentroDelMapa(){
        Mapa mapa = new Mapa(10, 20);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        Posicion origen = new Posicion(2,5);
        Posicion destino = new Posicion(4,8);

        mapa.ocuparCasillero(origen, armaDeAsedio);
        mapa.moverUnidadMovil(origen, destino);

    }

}
