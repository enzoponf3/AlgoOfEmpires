package Modelo.Unidades;
import Modelo.Constantes;
import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Posicion;
import Modelo.Edificios.Edificio;

import java.util.ArrayList;

public class Espadachin extends Unidad implements IAtacante{

    private  IEstadoEspadachin estado;

    public Espadachin(Posicion posicion){
        this.vida = Constantes.VIDA_ESPADACHIN;
        this.costo = Constantes.COSTO_ESPADACHIN;
        this.estado = new EstadoEspadachinLibre(this);
        this.danioUnidad = Constantes.DANIO_UNIDAD_ESPADACHIN;
        this.danioEdificio = Constantes.DANIO_EDIFICIO_ESPADACHIN;
        this.rango = Constantes.RANGO_ESPADACHIN;
        this.posicion = posicion;
    }

    public void desocupar(){ this.estado = new EstadoEspadachinLibre(this);}
    public void ocupar(){ this.estado = new EstadoEspadachinOcupado(this);}

    @Override
    public void mover(Posicion destino){
        this.estado.mover(destino);
    }

    @Override
    public void cambiarPosicion(Posicion destino){
        this.posicion = destino;
    }

    @Override
    public void verificarPosicionAledania(Posicion destino){
        if ( !this.posicion.aledaniaA(destino) )
            throw new PosicionInvalidaException();
    }

    @Override
    public void atacar(Unidad unidad){ this.estado.atacar(unidad);}


    @Override
    public void atacar(Edificio edificio){this.estado.atacar(edificio);}

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
