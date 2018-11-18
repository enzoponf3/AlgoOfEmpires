package Modelo;

import Modelo.Edificios.IEstadoCasillero;
import Modelo.Edificios.EstadoDesocupado;
import Modelo.Edificios.EstadoOcupado;
import Modelo.Exceptions.CasilleroDesocupadoException;
import Modelo.Exceptions.CasilleroOcupadoException;

public class Casillero<T>{

    private Posicion posicion;
    private T entidad;
    private IEstadoCasillero estado;

    public Casillero(Posicion posicion){
        this.posicion = posicion;
        this.entidad = null;
        this.estado = new EstadoDesocupado();
    }

    public Posicion getPosicion(){
        return this.posicion;
    }

    public void setEntidad(T entidad){
        this.entidad = entidad;
    }


    public void colocarObjeto(IEntidad iEntidad) {

        try{
            this.estado.colocarObjeto(iEntidad, this);
        } catch (CasilleroOcupadoException e) {
            throw e;
        }
    }

    public T removerObjeto(){
        try {
            T objeto = this.entidad;
            this.estado.removerObjeto(this);
            return objeto;
        } catch (CasilleroDesocupadoException e){
            throw e;
        }
    }

    public boolean estaOcupado(){
        return entidad != null;
    }

    public void ocupar(){
        this.estado = new EstadoOcupado();
    }

    public void desocupar(){
        this.estado = new EstadoDesocupado();
    }

    public boolean tienePosicion(Posicion posicion){
        return this.posicion.igualA(posicion);
    }

}
