package Modelo;

import Modelo.Exceptions.EntidadFueraDeRangoException;

import java.lang.Math;
import java.util.ArrayList;

public class Posicion {

    private int horizontal;
    private int vertical;

    public Posicion(int horizontal,int vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    public int getHorizontal(){
        return this.horizontal;
    }//Para la vista

    public int getVertical(){
        return this.vertical;
    }//Para la vista

    public boolean igualA(Posicion unaposicion){
        return ( (this.horizontal == unaposicion.horizontal) && (this.vertical == unaposicion.vertical) );
    }

    public boolean estaDentroDelMapa(int limite1, int limite2) {
        return ( (this.horizontal >= 0 ) && (this.horizontal < limite1) && (this.vertical >= 0) && (this.vertical < limite2) );
    } // Decidir si parto de 0x0 o de 1x1. Y si hago el pasaje aca adentro.


    public boolean aledaniaA(Posicion destino){
        int abs_horizontal = Math.abs(this.horizontal - destino.horizontal);
        int abs_vertical = Math.abs(this.vertical - destino.vertical);
        return ( ( (abs_horizontal == 1) || (abs_horizontal == 0) ) && ( (abs_vertical == 1) || (abs_vertical == 0) ) );
    }
    public boolean estaEnRango (Posicion posicion, int rango){
        int abs_horizontal = Math.abs(this.horizontal - posicion.horizontal);
        int abs_vertical = Math.abs(this.vertical - posicion.vertical);
        if (abs_horizontal <= rango && abs_vertical <= rango){
            return true;
        }
        return false;
    }

    public boolean estaEnRango(ArrayList<Posicion> posiciones,int rango) {
        for (Posicion pos : posiciones) {
            if (this.estaEnRango(pos, rango))
                return true;
        }
        return false;
    }

}
