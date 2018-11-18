package Modelo.Unidades;
import Modelo.Edificios.Edificio;
import Modelo.Posicion;

public class Arquero extends Unidad {

    protected static int VIDA = 75;
    protected static int COSTO= 75;
    protected EstadoArquero estado;
    protected  int RANGO = 3;
    protected static int DANIO_UNIDAD = 15;
    protected static int DANIO_EDIFICIO = 10;

    public Arquero() {
        this.vida = VIDA;
        this.costo = COSTO;
        this.danioUnidad = DANIO_UNIDAD;
        this.danioEdificio = DANIO_EDIFICIO;
        this.rango = RANGO;
        this.estado = new EstadoArqueroLibre();
    }

    @Override
    public void mover(Posicion destino){
        this.estado.mover(destino, this);
    }

    @Override
    public void cambiarPosicion(Posicion destino){
        this.posicion = destino;
    }

    public void ocupar(){
        this.estado = new EstadoArqueroOcupado();
    }

    public void desocupar(){
        this.estado = new EstadoArqueroLibre();
    }

    public void atacar(Unidad unidad){ this.estado.atacar(this,unidad);}

    public void atacar(Edificio edificio) {this.estado.atacar(this,edificio);}
}
