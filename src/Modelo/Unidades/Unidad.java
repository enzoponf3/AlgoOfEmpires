package Modelo.Unidades;

import Modelo.*;

public abstract class Unidad implements IUnidadMovible, IEntidad {

    protected int vida;
    int costo;
    protected Posicion posicion;
    int danioUnidad = 0;
    int danioEdificio = 0;
    int rango = 0;


    public int getVida(){
        return vida;
    }
    public int getCosto(){
        return costo;
    }
    int getDanioUnidad(){
        return danioUnidad;
    }
    int getDanioEdificio(){
        return danioEdificio;
    }
    int getRango(){ return rango;}

    public boolean estaEnPosicion(Posicion posicionAComparar){
        return this.posicion.igualA(posicionAComparar);
    }

    public Posicion getPosicion(){
        return this.posicion;
    }

    public void reducirVida(int danio){
        this.vida -= danio;
    }

    public boolean enPosicion(Posicion posicion){
        return this.posicion.igualA(posicion);
    }


    public boolean estaMuerto() {
        return this.vida <= 0;
    }
}
