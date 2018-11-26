package Modelo.Unidades;
import Modelo.Edificios.Edificio;
import Modelo.Posicion;

import java.util.ArrayList;

public class Arquero extends Unidad implements IAtacante {

    private final int VIDA = 75;
    private final int COSTO= 75;
    private IEstadoArquero estado;
    private final  int RANGO = 3;
    private final int DANIO_UNIDAD = 15;
    private final int DANIO_EDIFICIO = 10;

    public Arquero(Posicion posicion) {
        this.vida = VIDA;
        this.costo = COSTO;
        this.danioUnidad = DANIO_UNIDAD;
        this.danioEdificio = DANIO_EDIFICIO;
        this.rango = RANGO;
        this.estado = new EstadoArqueroLibre(this);
        this.posicion = posicion;
    }

    @Override
    public void mover(Posicion destino){
        this.estado.mover(destino);
    }

    @Override
    public void cambiarPosicion(Posicion destino){
        this.posicion = destino;
    }

    public void ocupar(){
        this.estado = new EstadoArqueroOcupado(this);
    }

    public void desocupar(){
        this.estado = new EstadoArqueroLibre(this);
    }

    @Override
    public void atacar(Unidad unidad){ this.estado.atacar(unidad);}

    @Override
    public void atacar(Edificio edificio) {this.estado.atacar(edificio);}

    @Override
    public boolean enRangoDeAtaque(Posicion posAtacado){
        return this.posicion.estaEnRango(posAtacado,this.rango);
    }

    @Override
    public boolean enRangoDeAtaque(ArrayList<Posicion> posiciones){
        return this.posicion.estaEnRango(posiciones,this.rango);
    }
    @Override
    public int getDanioUnidad(){
        return this.danioUnidad;
    }

    @Override
    public int getDanioEdificio(){
        return this.danioEdificio;
    }
}
