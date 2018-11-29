package Entrega2;

import Modelo.Exceptions.TurnoDelOponenteException;
import Modelo.Jugador.Jugador;
import Modelo.Mapa;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import Modelo.Unidades.ArmaDeAsedio;
import Modelo.Unidades.Arquero;
import Modelo.Unidades.Espadachin;
import org.junit.Assert;
import org.junit.Test;

public class JugadorMueveUnidadesTest {

    // Pruebas movimiento. Solo puede mover unidades durante su turno, es decir en el EstadoTurnoActivo.

    @Test
    public void moverAldeanoInicialCorrectamenteEnTurnoActivo(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.activar();
        Posicion origen = new Posicion(1,1);
        Posicion destino = new Posicion(2,1);
        Aldeano aldeano = new Aldeano(origen);
        jugador.agregarAldeano(aldeano, mapa);
        jugador.mover(aldeano,destino,mapa);

        Assert.assertTrue( aldeano.enPosicion(destino) );
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void moverAldeanoInicialEnTurnoInactivo(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa,5, 14);
        jugador.inactivar();

        Posicion origen = new Posicion(1,1);
        Aldeano aldeano = new Aldeano(origen);
        jugador.agregarAldeano(aldeano, mapa);
        Posicion destino = new Posicion(2,1);

        jugador.mover(aldeano, destino, mapa);

        Assert.assertTrue( aldeano.enPosicion(destino) );
    }

    @Test
    public void moverAldeanoAgregadoCorrectamenteEnTurnoActivo(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa,5, 14);
        jugador.activar();

        Posicion origen = new Posicion(2,5);
        Aldeano aldeano = new Aldeano(origen);

        Posicion destino = new Posicion(2,6);

        jugador.agregarAldeano(aldeano, mapa);
        jugador.mover(aldeano, destino, mapa);

        Assert.assertTrue( aldeano.enPosicion(destino) );
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void moverAldeanoAgregadoEnTurnoDelOponente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.inactivar();

        Posicion origen = new Posicion(2,5);
        Aldeano aldeano = new Aldeano(origen);

        Posicion destino = new Posicion(2,6);

        jugador.agregarAldeano(aldeano, mapa);
        jugador.mover(aldeano, destino, mapa);

        Assert.assertTrue( aldeano.enPosicion(destino) );
    }

    @Test
    public void moverEspadachinAgregadoCorrectamente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.activar();

        Posicion origen = new Posicion(2,5);
        Espadachin espadachin = new Espadachin(origen);
        Posicion destino = new Posicion(2,6);

        jugador.agregarAEjercito(espadachin, mapa);
        jugador.mover(espadachin, destino, mapa);

        Assert.assertTrue( espadachin.enPosicion(destino) );
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void moverEspadachinAgregadoEnTurnoDelOponente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.inactivar();

        Posicion origen = new Posicion(2,5);
        Espadachin espadachin = new Espadachin(origen);
        Posicion destino = new Posicion(2,6);

        jugador.agregarAEjercito(espadachin, mapa);
        jugador.mover(espadachin, destino, mapa);

        Assert.assertTrue( espadachin.enPosicion(destino) );
    }

    @Test
    public void moverArqueroAgregadoCorrectamente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa,5, 14);
        jugador.activar();

        Posicion origen = new Posicion(2,5);
        Arquero arquero = new Arquero(origen);
        Posicion destino = new Posicion(2,6);

        jugador.agregarAEjercito(arquero, mapa);
        jugador.mover(arquero, destino, mapa);

        Assert.assertTrue( arquero.enPosicion(destino) );
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void moverArqueroAgregadoEnTurnoDelOponente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.inactivar();

        Posicion origen = new Posicion(2,5);
        Arquero arquero = new Arquero(origen);
        Posicion destino = new Posicion(2,6);

        jugador.agregarAEjercito(arquero, mapa);
        jugador.mover(arquero, destino, mapa);

        Assert.assertTrue( arquero.enPosicion(destino) );
    }

    @Test
    public void moverArmaDeAsedioAgregadoCorrectamente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.activar();

        Posicion origen = new Posicion(2,5);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(origen);
        Posicion destino = new Posicion(2,6);

        jugador.agregarAEjercito(armaDeAsedio, mapa);
        jugador.mover(armaDeAsedio, destino, mapa);

        Assert.assertTrue( armaDeAsedio.enPosicion(destino) );
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void moverArmaDeAsedioAgregadoEnTurnoDelOponente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.inactivar();

        Posicion origen = new Posicion(2,5);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(origen);
        Posicion destino = new Posicion(2,6);

        jugador.agregarAEjercito(armaDeAsedio, mapa);
        jugador.mover(armaDeAsedio, destino, mapa);

        Assert.assertTrue( armaDeAsedio.enPosicion(destino) );
    }

    //No hay que probar posiciones aldeanias dado que eso es verificado por el mapa
    // al darme la posicion de origen y destino.


}
