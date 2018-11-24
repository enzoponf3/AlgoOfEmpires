package Modelo.Edificios;

import Modelo.Exceptions.EdificioConVidaAlMaximoException;
import Modelo.IEntidad;
import Modelo.Posicion;

import java.util.ArrayList;

public abstract class Edificio implements IEntidad {

    int vida;
    int costo;
    int velocidadReparacion;
    int vidaMax;
    protected ArrayList<Posicion> posiciones;

    public int getVida() {
        return this.vida;
    }

    public int getVelocidadReparacion() {
        return velocidadReparacion;
    }

    public ArrayList<Posicion> getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(ArrayList<Posicion> posiciones) {
        this.posiciones = posiciones;
    }

    public abstract void reducirVida(int cant);

    public abstract void reparar();

    public abstract void enReparacion();

    void aumentarVida() {
        if (this.vida == this.vidaMax)
            throw new EdificioConVidaAlMaximoException();
        this.enReparacion();
        if ((this.vida + this.velocidadReparacion) >= this.vidaMax)
            this.vida = this.vidaMax;
        else
            this.vida += this.velocidadReparacion;
    }

    public void construir(){}

    public boolean contienePosicion(Posicion posicionBuscada){
        for( Posicion posicion : this.posiciones){
            if( posicion.igualA(posicionBuscada) )
                return true;
        }
        return false;
    }

    public boolean estaDestruido() {
        return this.vida <= 0;
    }
}
