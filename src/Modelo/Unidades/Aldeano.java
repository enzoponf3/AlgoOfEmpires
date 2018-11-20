package Modelo.Unidades;
import Modelo.Edificios.Cuartel;
import Modelo.Edificios.PlazaCentral;
import Modelo.Unidades.*;
import Modelo.Edificios.*;
import Modelo.Posicion;

import java.util.ArrayList;

public class Aldeano extends Unidad {

    public static final int VIDA = 50;
    public static final int COSTO = 25;
    public static final int RANGO = 1;
    public IEstadoAldeano estado;

    public Aldeano() {
        this.vida = VIDA;
        this.costo = COSTO;
        this.rango = RANGO;
        this.estado = new EstadoAldeanoLibre();
    }

    public Cuartel construirCuartel(ArrayList<Posicion> posiciones){
        return this.estado.construirCuartel(this, posiciones);
    }

    public PlazaCentral construirPlazaCentral(ArrayList<Posicion> posiciones){
        return this.estado.construirPlazaCentral(this, posiciones);
    }

    public void repararEdificio(Edificio edificio){
        this.estado.repararEdificio(edificio,this);
    }

    public void continuarConstruccionPlazaCentral(PlazaCentral plaza){
        this.estado.continuarConstruccion(plaza, this);
    }

    public void continuarConstruccionCuartel(Cuartel cuartel){
        this.estado.continuarConstruccion(cuartel, this);
    }

    public void ocupar(){
        this.estado = new EstadoAldeanoOcupado();
    }

    public void desocupar() {
        this.estado = new EstadoAldeanoLibre();
    }

    public int generaOro(){
        return this.estado.generaOro();
    }

    public void movio(){this.estado = new EstadoAldeanoMovio();}
    @Override
    public void mover(Posicion destino){
        this.estado.mover(destino, this);
    }

    @Override
    public void cambiarPosicion(Posicion destino){
        this.posicion = destino;
    }

}
