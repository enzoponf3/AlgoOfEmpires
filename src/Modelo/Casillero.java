package Modelo;

import Modelo.Exceptions.CasilleroDesocupadoException;
import Modelo.Exceptions.CasilleroOcupadoException;

public class Casillero<T>{

    private Posicion posicion;
    private T entidad;
    private IEstadoCasillero estado;

    public Casillero(Posicion posicion){
        this.posicion = posicion;
        this.entidad = null;
        this.estado = new EstadoCasilleroDesocupado();
    }

    public Posicion getPosicion(){
        return this.posicion;
    }

    public void setEntidad(T entidad){
        this.entidad = entidad;
    }


    public void colocarObjeto(IEntidad iEntidad) {
        this.estado.colocarObjeto(iEntidad, this);
    }

    public T removerObjeto(){
        T objeto = this.entidad;
        this.estado.removerObjeto(this);
        return objeto;
    }

    public boolean estaOcupado(){
        return entidad != null;
    }

    public void ocupar(){
        this.estado = new EstadoCasilleroOcupado();
    }

    public void desocupar(){
        this.estado = new EstadoCasilleroDesocupado();
    }

    public boolean tienePosicion(Posicion posicion){
        return this.posicion.igualA(posicion);
    }

    public T obtenerObjeto() {
        T objeto = this.entidad;
        this.estado.obtenerObjeto();
        return objeto;
    }
}
