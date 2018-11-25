package Modelo.Unidades;
import Modelo.Edificios.Edificio;
import Modelo.Posicion;

public class Arquero extends Unidad implements IAtacante {

    protected static int VIDA = 75;
    protected static int COSTO= 75;
    protected IEstadoArquero estado;
    protected  int RANGO = 3;
    protected static int DANIO_UNIDAD = 15;
    protected static int DANIO_EDIFICIO = 10;

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

}
