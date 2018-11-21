package Modelo;

import Modelo.*;

import java.util.ArrayList;
import java.util.Random;

public class Juego {

    private Jugador jugador1;
    private Jugador jugador2;

    public void inicializar() {

        jugador1 = new Jugador( 5,14);
        jugador2 = new Jugador( 41, 35);
        int turnoInicial = new Random().nextInt(2);
        if (turnoInicial == 0) {
//            jugador1.turnoActivo();
//            jugador2.turnoInactivo();
        }
        else {
//            jugador1.turnoInactivo();
//            jugador2.turnoActivo();
        }
    }

    //Inicializacion jugador1

    public ArrayList<Posicion> obtenerPosicionesInicialesCastilloJugador1(){
        ArrayList<Posicion> posiciones = new ArrayList<>();

        for(int i=5; i<9; i++ ){
            for(int j=5; j<9; j++){
                Posicion posicion = new Posicion(i,j);
                posiciones.add(posicion);
            }
        }

        return posiciones;
    }

    public ArrayList<Posicion> obtenerPosicionesInicialesPlazaCentralJugador1(){
        ArrayList<Posicion> posiciones = new ArrayList<>();

        for(int i=14; i<16; i++ ){
            for(int j=5; j<7; j++){
                Posicion posicion = new Posicion(i,j);
                posiciones.add(posicion);
            }
        }

        return posiciones;
    }

    //Inicializacion jugador 2

    public ArrayList<Posicion> obtenerPosicionesInicialesCastilloJugador2(){
        ArrayList<Posicion> posiciones = new ArrayList<>();

        for(int i=41; i<45; i++ ){
            for(int j=41; j<45; j++){
                Posicion posicion = new Posicion(i,j);
                posiciones.add(posicion);
            }
        }

        return posiciones;
    }

    public ArrayList<Posicion> obtenerPosicionesInicialesPlazaCentralJugador2(){
        ArrayList<Posicion> posiciones = new ArrayList<>();

        for(int i=35; i<37; i++ ){
            for(int j=43; j<45; j++){
                Posicion posicion = new Posicion(i,j);
                posiciones.add(posicion);
            }
        }

        return posiciones;
    }

    public void cambiarDeTurno() {
//        jugador1.cambiarTurno();
//        jugador2.cambiarTurno();
    }

}
