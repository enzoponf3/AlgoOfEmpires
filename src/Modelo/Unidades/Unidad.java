package Modelo.Unidades;

import Modelo.*;

public abstract class Unidad implements IUnidadMovible, IEntidad {

    protected int vida;
    protected int costo;
    protected Posicion posicion;
    protected int DANIO_UNIDAD = 0;
    protected int DANIO_EDIFICIO = 0;

    public int getVida(){
        return vida;
    }

    public int getCosto(){
        return costo;
    }

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

    public int getDanioUnidad(){
        return DANIO_UNIDAD;
    }
    public int getDanioEdificio(){
        return DANIO_EDIFICIO;
    }
}
