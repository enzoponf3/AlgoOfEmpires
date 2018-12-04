package Modelo.Unidades;
import Modelo.Constantes;
import Modelo.Edificios.Edificio;
import Modelo.Posicion;
import java.util.ArrayList;

public class Arquero extends Unidad implements IAtacante {

    private IEstadoArquero estado;

    public Arquero(Posicion posicion) {
        this.vida = Constantes.VIDA_ARQUERO;
        this.costo = Constantes.COSTO_ARQUERO;
        this.danioUnidad = Constantes.DANIO_UNIDAD_ARQUERO;
        this.danioEdificio = Constantes.DANIO_EDIFICIO_ARQUERO;
        this.rango = Constantes.RANGO_ARQUERO;
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
