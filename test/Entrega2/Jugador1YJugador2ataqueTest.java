package Entrega2;

import Modelo.Jugador;
import Modelo.Posicion;
import Modelo.Unidades.*;
import org.junit.Assert;
import org.junit.Test;

public class Jugador1YJugador2ataqueTest {

    @Test
    public void crearDosJugadoresOponentesCorrectamente(){
        Jugador jugador1 = new Jugador(5, 14);
        Jugador jugador2 = new Jugador(41, 35);

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Assert.assertEquals(jugador2, jugador1.getOponente());
        Assert.assertEquals(jugador1, jugador2.getOponente());
    }

    //Atacar al oponente: jugador1 ataca a jugador2

    //PASAN PERO ESTAN MAL PORQUE HAY QUE CHEQUEAR QUE LO QUE ESTOY AtACANDO PERTENECE AL OTRO!!!!!

    /*
    @Test
    public void arqueroPropioAtacaAldeanoEnemigoEnTurnoPropio(){
        Jugador jugador1 = new Jugador(5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(1,1);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero);

        Posicion posicionAldeano = new Posicion(3, 3);
        Aldeano aldeanoEnemigo = new Aldeano(posicionAldeano);

        jugador1.atacar(arquero, aldeanoEnemigo);

        Assert.assertEquals(35, aldeanoEnemigo.getVida() );
    }

    @Test
    public void arqueroPropioAtacaArqueroEnemigoEnTurnoPropio(){
        Jugador jugador1 = new Jugador(5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(1,1);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero);

        Posicion posicionArqueroEnemigo = new Posicion(3, 3);
        Arquero arqueroEnemigo = new Arquero(posicionArqueroEnemigo);

        jugador1.atacar(arquero, arqueroEnemigo);

        Assert.assertEquals(60, arqueroEnemigo.getVida() );
    }

    @Test
    public void arqueroPropioAtacaEspadachinEnemigoEnTurnoPropio(){
        Jugador jugador1 = new Jugador(5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(1,1);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero);

        Posicion posicionEspadachinEnemigo = new Posicion(3, 3);
        Espadachin espadachinEnemigo = new Espadachin(posicionEspadachinEnemigo);

        jugador1.atacar(arquero, espadachinEnemigo);

        Assert.assertEquals(85, espadachinEnemigo.getVida() );
    }
    */

}
