package Modelo.Unidades;
import Modelo.Constantes;
import Modelo.Edificios.Edificio;
import Modelo.Exceptions.ArmaDeAsedioNoAtacaUnidadException;
import Modelo.Posicion;

import java.util.ArrayList;

public class ArmaDeAsedio extends Unidad implements IAtacante {

    protected IEstadoArmaDeAsedio estado;

    public ArmaDeAsedio(Posicion posicion){
        this.vida = Constantes.VIDA_ARMA_ASEDIO;
        this.costo = Constantes.COSTO_ARMA_ASEDIO;
        this.rango = Constantes.RANGO_ARMA_ASEDIO;
        this.danioEdificio = Constantes.DANIO_EDIFICIO_ARMA_ASEDIO;
        this.estado = new EstadoArmaDeAsedioDesarmado(this);
        this.posicion = posicion;
    }

    public void montar(){ this.estado = this.estado.montar(this);}

    public void desmontar(){ this.estado = this.estado.desmontar(this);}

    public void desocupar(){this.estado = this.estado.desocupar(this);}

    @Override
    public void mover(Posicion destino){
        this.estado.mover(destino);
    }

    @Override
    public void cambiarPosicion(Posicion destino){
        this.posicion = destino;
    }

    public void atacar(Unidad unidad){ throw new ArmaDeAsedioNoAtacaUnidadException();}

    public void atacar(Edificio edificio) {this.estado.atacar(edificio);}

    @Override
    public boolean enRangoDeAtaque(Posicion posAtacado){
        throw new ArmaDeAsedioNoAtacaUnidadException();
    }

    @Override
    public boolean enRangoDeAtaque(ArrayList<Posicion> posiciones){
        return this.posicion.estaEnRango(posiciones,this.rango);
    }

    @Override
    public void ocupar(){
        this.estado = this.estado.ocupar(this);
    }

    @Override
    public int getDanioUnidad(){
        throw new ArmaDeAsedioNoAtacaUnidadException();
    }

    @Override
    public int getDanioEdificio(){
        return this.danioEdificio;
    }
}
