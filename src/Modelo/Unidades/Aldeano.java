package Modelo.Unidades;
import Modelo.Constantes;
import Modelo.Edificios.Cuartel;
import Modelo.Edificios.PlazaCentral;
import Modelo.Edificios.*;
import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Posicion;

import java.util.ArrayList;

public class Aldeano extends Unidad {

    private IEstadoAldeano estado;


    public Aldeano(Posicion posicion) {
        this.vida = Constantes.VIDA_ALDEANO;
        this.costo = Constantes.COSTO_ALDEANO;
        this.rango = Constantes.RANGO_ALDEANO;
        this.estado = new EstadoAldeanoLibre(this);
        this.posicion = posicion;
    }

    public Cuartel construirCuartel(ArrayList<Posicion> posiciones){
        return this.estado.construirCuartel(posiciones);
    }

    public PlazaCentral construirPlazaCentral(ArrayList<Posicion> posiciones){
        return this.estado.construirPlazaCentral(posiciones);
    }

    public void repararEdificio(Edificio edificio){
        this.estado.repararEdificio(edificio);
    }

    public void continuarConstruccionPlazaCentral(PlazaCentral plaza){
        this.estado.continuarConstruccion(plaza);
    }

    public void continuarConstruccionCuartel(Cuartel cuartel){
        this.estado.continuarConstruccion(cuartel);
    }

    public void ocupar(){
        this.estado = new EstadoAldeanoOcupado(this);
    }

    public void desocupar() {
        this.estado = new EstadoAldeanoLibre(this);
    }

    public int generaOro(){
        return this.estado.generaOro();
    }

    void movio(){this.estado = new EstadoAldeanoMovio(this);}

    @Override
    public void verificarPosicionAledania(Posicion destino){
        if ( !this.posicion.aledaniaA(destino) )
            throw new PosicionInvalidaException();
    }

    @Override
    public void mover(Posicion destino){
        verificarPosicionAledania(destino);
        this.estado.mover(destino);
    }

    @Override
    public void cambiarPosicion(Posicion destino){
        this.posicion = destino;
    }

}
