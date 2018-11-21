package Entrega2;

import Modelo.Exceptions.TurnoDelOponenteException;
import Modelo.Jugador;
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
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();
        Posicion origen = new Posicion(1,1);
        Posicion destino = new Posicion(2,1);

        Aldeano aldeano = jugador.devolverAldeanoEnPosicion(origen);
        jugador.mover(origen, destino);

        Assert.assertTrue( aldeano.enPosicion(destino) );
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void moverAldeanoInicialEnTurnoInactivo(){
        Jugador jugador = new Jugador(5, 14);
        jugador.inactivar();
        Posicion origen = new Posicion(1,1);
        Posicion destino = new Posicion(2,1);

        Aldeano aldeano = jugador.devolverAldeanoEnPosicion(origen);
        jugador.mover(origen, destino);

        Assert.assertTrue( aldeano.enPosicion(destino) );
    }

    @Test
    public void moverAldeanoAgregadoCorrectamenteEnTurnoActivo(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

        Aldeano aldeano = new Aldeano();
        Posicion origen = new Posicion(2,5);
        aldeano.setPosicion(origen);
        Posicion destino = new Posicion(2,6);

        jugador.agregarAldeano(aldeano);
        jugador.mover(origen, destino);

        Assert.assertTrue( aldeano.enPosicion(destino) );
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void moverAldeanoAgregadoEnTurnoDelOponente(){
        Jugador jugador = new Jugador(5, 14);
        jugador.inactivar();

        Aldeano aldeano = new Aldeano();
        Posicion origen = new Posicion(2,5);
        aldeano.setPosicion(origen);
        Posicion destino = new Posicion(2,6);

        jugador.agregarAldeano(aldeano);
        jugador.mover(origen, destino);

        Assert.assertTrue( aldeano.enPosicion(destino) );
    }

    @Test
    public void moverEspadachinAgregadoCorrectamente(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

        Espadachin espadachin = new Espadachin();
        Posicion origen = new Posicion(2,5);
        espadachin.setPosicion(origen);
        Posicion destino = new Posicion(2,6);

        jugador.agregarAEjercito(espadachin);
        jugador.mover(origen, destino);

        Assert.assertTrue( espadachin.enPosicion(destino) );
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void moverEspadachinAgregadoEnTurnoDelOponente(){
        Jugador jugador = new Jugador(5, 14);
        jugador.inactivar();

        Espadachin espadachin = new Espadachin();
        Posicion origen = new Posicion(2,5);
        espadachin.setPosicion(origen);
        Posicion destino = new Posicion(2,6);

        jugador.agregarAEjercito(espadachin);
        jugador.mover(origen, destino);

        Assert.assertTrue( espadachin.enPosicion(destino) );
    }

    @Test
    public void moverArqueroAgregadoCorrectamente(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

        Arquero arquero = new Arquero();
        Posicion origen = new Posicion(2,5);
        arquero.setPosicion(origen);
        Posicion destino = new Posicion(2,6);

        jugador.agregarAEjercito(arquero);
        jugador.mover(origen, destino);

        Assert.assertTrue( arquero.enPosicion(destino) );
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void moverArqueroAgregadoEnTurnoDelOponente(){
        Jugador jugador = new Jugador(5, 14);
        jugador.inactivar();

        Arquero arquero = new Arquero();
        Posicion origen = new Posicion(2,5);
        arquero.setPosicion(origen);
        Posicion destino = new Posicion(2,6);

        jugador.agregarAEjercito(arquero);
        jugador.mover(origen, destino);

        Assert.assertTrue( arquero.enPosicion(destino) );
    }

    @Test
    public void moverArmaDeAsedioAgregadoCorrectamente(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        Posicion origen = new Posicion(2,5);
        armaDeAsedio.setPosicion(origen);
        Posicion destino = new Posicion(2,6);

        jugador.agregarAEjercito(armaDeAsedio);
        jugador.mover(origen, destino);

        Assert.assertTrue( armaDeAsedio.enPosicion(destino) );
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void moverArmaDeAsedioAgregadoEnTurnoDelOponente(){
        Jugador jugador = new Jugador(5, 14);
        jugador.inactivar();

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        Posicion origen = new Posicion(2,5);
        armaDeAsedio.setPosicion(origen);
        Posicion destino = new Posicion(2,6);

        jugador.agregarAEjercito(armaDeAsedio);
        jugador.mover(origen, destino);

        Assert.assertTrue( armaDeAsedio.enPosicion(destino) );
    }

    //No hay que probar posiciones aldeanias dado que eso es verificado por el mapa
    // al darme la posicion de origen y destino.


}
