package Modelo.Unidades;

import Modelo.*;

public abstract class Unidad implements IUnidadMovible, IEntidad {

    protected int vida;
    protected int costo;
    protected Posicion posicion;
    protected int danioUnidad = 0;
    protected int danioEdificio = 0;
    protected int rango = 0;


    public int getVida(){
        return vida;
    }
    public int getCosto(){
        return costo;
    }
    public int getDanioUnidad(){
        return danioUnidad;
    }
    public int getDanioEdificio(){
        return danioEdificio;
    }
    public int getRango(){ return rango;}

    public boolean estaEnPosicion(Posicion posicionAComparar){
        return this.posicion.igualA(posicionAComparar);
    }

    public void setPosicion(Posicion posicion){
        this.posicion = posicion;
    }

    public Posicion getPosicion(){
        return this.posicion;
    }

    public void reducirVida(int danio){
        this.vida -= danio;
    }




}