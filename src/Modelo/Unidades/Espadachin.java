package Modelo.Unidades;
import Modelo.Posicion;
import Modelo.Exceptions.*;
import Modelo.Edificios.Edificio;
public class Espadachin extends Unidad implements IAtacante{

   protected int VIDA = 100;
   protected int COSTO = 50;
   protected int DANIO_UNIDAD = 25;
   protected int DANIO_EDIFICIO = 15;
   protected EstadoEspadachin estado;
   protected int RANGO = 1;


    public Espadachin(){
        this.vida = VIDA;
        this.costo = COSTO;
        this.estado = new EstadoEspadachinLibre();
        this.danioUnidad = DANIO_UNIDAD;
        this.danioEdificio = DANIO_EDIFICIO;
        this.rango = RANGO;
    }
    public void desocupar(){ this.estado = new EstadoEspadachinLibre();}
    public void ocupar(){ this.estado = new EstadoEspadachinOcupado();}

    @Override
    public void mover(Posicion destino){
        this.estado.mover(destino, this);
    }

    @Override
    public void cambiarPosicion(Posicion destino){
        this.posicion = destino;
        this.ocupar();
    }

    @Override
    public void atacar(Unidad unidad){ this.estado.atacar(this,unidad);}


    @Override
    public void atacar(Edificio edificio){this.estado.atacar(this,edificio);}
}