package Modelo.Unidades;
import Modelo.Posicion;
import Modelo.Exceptions.*;
import Modelo.Edificios.Edificio;
public class Espadachin extends Unidad {

   protected int VIDA = 100;
   protected int COSTO = 50;
   protected int DANIO_UNIDAD = 25;
   protected int DANIO_EDIFICIO = 15;
   protected EstadoEspadachin estado;
   protected int rango = 1;


    public Espadachin(){
        this.vida = VIDA;
        this.costo = COSTO;
        this.estado = new EstadoEspadachinLibre();
    }
    public int getVida() {
        return this.vida;
    }

    public int getCosto() {
        return this.costo;
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

    public void atacar(Unidad unidad){ this.estado.atacar(this,unidad);}

    public void atacar(Edificio edificio){this.estado.atacar(this,edificio);}

    public int getDanioUnidad(){
        return DANIO_UNIDAD;
    }

    public int getDanioEdificio(){
        return DANIO_EDIFICIO;
    }

    public void estaEnRango(Posicion posicion){         //De ultima pensar otra forma
        Posicion posicionDif = this.posicion.diferenciaEntrePos(posicion);
        if(posicionDif.getHorizontal() > this.rango || posicionDif.getVertical() > this.rango){
            throw new ObjetoFueraDeRangoException();
        }
    }
}