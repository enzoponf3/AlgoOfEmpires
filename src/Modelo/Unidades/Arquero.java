package Modelo.Unidades;
import Modelo.Edificios.Edificio;
import Modelo.Posicion;

public class Arquero extends Unidad implements IAtacante {

    protected static int VIDA = 75;
    protected static int COSTO= 75;
    protected EstadoArquero estado;

    public int getVida() {
        return this.vida;
    }
    public int getCosto() {
        return this.costo;
    }

    public Arquero() {
        this.vida = VIDA;
        this.costo = COSTO;
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

    @Override
    public void atacar(Unidad unidad){}

    @Override
    public void atacar(Edificio edificio){}
}
