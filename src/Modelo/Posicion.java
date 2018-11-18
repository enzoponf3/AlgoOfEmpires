package Modelo;

import Modelo.Exceptions.EntidadFueraDeRangoException;

import java.lang.Math;

public class Posicion {

    private int horizontal;
    private int vertical;

    public Posicion(int horizontal,int vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    public boolean igualA(Posicion unaposicion){
        return ( (this.horizontal == unaposicion.horizontal) && (this.vertical == unaposicion.vertical) );
    }

    public boolean estaDentroDelMapa(int limite1, int limite2) {
        return ( (this.horizontal >= 0 ) && (this.horizontal < limite1) && (this.vertical >= 0) && (this.vertical < limite2) );
    } // Decidir si parto de 0x0 o de 1x1. Y si hago el pasaje aca adentro.

    public boolean compararPosiciones(Posicion unaposicion){
        return ( (this.horizontal == unaposicion.horizontal) && (this.vertical == unaposicion.vertical) );
    } //Aca estoy rompiendo el encapsulamiento?

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


}
