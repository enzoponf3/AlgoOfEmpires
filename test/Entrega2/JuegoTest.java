package Entrega2;

import Modelo.Posicion;
import Modelo.Juego;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class JuegoTest {

    @Test
    public void obtenerPosicionesInicialesCastilloJugador1Correctamente(){
        Juego juego = new Juego();

        ArrayList<Posicion> posiciones = new ArrayList<>();
        Posicion posicion1 = new Posicion(5,5);
        Posicion posicion2 = new Posicion(5,6);
        Posicion posicion3 = new Posicion(5,7);
        Posicion posicion4 = new Posicion(5,8);
        Posicion posicion5 = new Posicion(6,5);
        Posicion posicion6 = new Posicion(6,6);
        Posicion posicion7 = new Posicion(6,7);
        Posicion posicion8 = new Posicion(6,8);
        Posicion posicion9 = new Posicion(7,5);
        Posicion posicion10 = new Posicion(7,6);
        Posicion posicion11 = new Posicion(7,7);
        Posicion posicion12 = new Posicion(7,8);
        Posicion posicion13 = new Posicion(8,5);
        Posicion posicion14 = new Posicion(8,6);
        Posicion posicion15 = new Posicion(8,7);
        Posicion posicion16 = new Posicion(8,8);

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

        ArrayList<Posicion> posicionesaAComparar = juego.obtenerPosicionesInicialesCastilloJugador1();

        int i=0;
        for( Posicion posicion : posicionesaAComparar){
            Assert.assertTrue( posicion.igualA( posiciones.get(i) ) );
            i++;
        }
    }

    @Test
    public void obtenerPosicionesInicialesPlazaCentralJugador1Correctamente(){
        Juego juego = new Juego();

        ArrayList<Posicion> posiciones = new ArrayList<>();
        Posicion posicion1 = new Posicion(14,5);
        Posicion posicion2 = new Posicion(14,6);
        Posicion posicion3 = new Posicion(15,5);
        Posicion posicion4 = new Posicion(15,6);

        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);

        ArrayList<Posicion> posicionesaAComparar = juego.obtenerPosicionesInicialesPlazaCentralJugador1();

        int i=0;
        for( Posicion posicion : posicionesaAComparar){
            Assert.assertTrue( posicion.igualA( posiciones.get(i) ) );
            i++;
        }
    }

    @Test
    public void obtenerPosicionesInicialesCastilloJugador2Correctamente(){
        Juego juego = new Juego();

        ArrayList<Posicion> posiciones = new ArrayList<>();
        Posicion posicion1 = new Posicion(41,41);
        Posicion posicion2 = new Posicion(41,42);
        Posicion posicion3 = new Posicion(41,43);
        Posicion posicion4 = new Posicion(41,44);
        Posicion posicion5 = new Posicion(42,41);
        Posicion posicion6 = new Posicion(42,42);
        Posicion posicion7 = new Posicion(42,43);
        Posicion posicion8 = new Posicion(42,44);
        Posicion posicion9 = new Posicion(43,41);
        Posicion posicion10 = new Posicion(43,42);
        Posicion posicion11 = new Posicion(43,43);
        Posicion posicion12 = new Posicion(43,44);
        Posicion posicion13 = new Posicion(44,41);
        Posicion posicion14 = new Posicion(44,42);
        Posicion posicion15 = new Posicion(44,43);
        Posicion posicion16 = new Posicion(44,44);

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

        ArrayList<Posicion> posicionesaAComparar = juego.obtenerPosicionesInicialesCastilloJugador2();

        int i=0;
        for( Posicion posicion : posicionesaAComparar){
            Assert.assertTrue( posicion.igualA( posiciones.get(i) ) );
            i++;
        }
    }

    @Test
    public void obtenerPosicionesInicialesPlazaCentralJugador2Correctamente(){
        Juego juego = new Juego();

        ArrayList<Posicion> posiciones = new ArrayList<>();
        Posicion posicion1 = new Posicion(35,43);
        Posicion posicion2 = new Posicion(35,44);
        Posicion posicion3 = new Posicion(36,43);
        Posicion posicion4 = new Posicion(36,44);

        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);

        ArrayList<Posicion> posicionesaAComparar = juego.obtenerPosicionesInicialesPlazaCentralJugador2();

        int i=0;
        for( Posicion posicion : posicionesaAComparar){
            Assert.assertTrue( posicion.igualA( posiciones.get(i) ) );
            i++;
        }
    }

}
