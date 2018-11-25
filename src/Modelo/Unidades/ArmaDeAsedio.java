package Modelo.Unidades;
import Modelo.Edificios.Edificio;
import Modelo.Exceptions.ArmaDeAsedioNoAtacaUnidadException;
import Modelo.Posicion;

public class ArmaDeAsedio extends Unidad implements IAtacante {

    private int VIDA = 150;
    private int COSTO = 200;
    protected static int RANGO = 5;
    protected static int DANIO_EDIFICIO = 75;
    protected IEstadoArmaDeAsedio estado;

    public ArmaDeAsedio(Posicion posicion){
        this.vida = VIDA;
        this.costo = COSTO;
        this.rango = RANGO;
        this.danioEdificio = DANIO_EDIFICIO;
        this.estado = new EstadoArmaDeAsedioDesarmado(this);
        this.posicion = posicion;
    }

    public void montar(){ this.estado.montar();}

    public void desmontar(){ this.estado.desmontar();}

    public void desocupar(){this.estado.desocupar();}

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

}
