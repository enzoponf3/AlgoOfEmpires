package Modelo.Unidades;
import Modelo.Posicion;
import Modelo.Exceptions.*;
import Modelo.Edificios.Edificio;
public class Espadachin extends Unidad implements IAtacante{

   private final int VIDA = 100;
   private final int COSTO = 50;
   private final int DANIO_UNIDAD = 25;
   private final int DANIO_EDIFICIO = 15;
   protected  IEstadoEspadachin estado;
   private final int RANGO = 1;

    public Espadachin(Posicion posicion){
        this.vida = VIDA;
        this.costo = COSTO;
        this.estado = new EstadoEspadachinLibre(this);
        this.danioUnidad = DANIO_UNIDAD;
        this.danioEdificio = DANIO_EDIFICIO;
        this.rango = RANGO;
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
    public void atacar(Unidad unidad){ this.estado.atacar(unidad);}


    @Override
    public void atacar(Edificio edificio){this.estado.atacar(edificio);}

    @Override
    public boolean enRangoDeAtaque(Posicion posAtacado){
        return this.posicion.estaEnRango(posAtacado,this.rango);
    }
}
