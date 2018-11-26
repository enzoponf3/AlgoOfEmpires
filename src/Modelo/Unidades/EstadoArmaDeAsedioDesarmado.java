package Modelo.Unidades;
import Modelo.Edificios.Edificio;
import Modelo.Posicion;
import Modelo.Exceptions.*;

public class EstadoArmaDeAsedioDesarmado implements IEstadoArmaDeAsedio {

    ArmaDeAsedio armaDeAsedio;
    public EstadoArmaDeAsedioDesarmado(ArmaDeAsedio arma){
        this.armaDeAsedio = arma;
    }

    @Override
    public void mover(Posicion destino){
        armaDeAsedio.cambiarPosicion(destino);
        armaDeAsedio.estado = new EstadoArmaDeAsedioDesarmadoOcupado(armaDeAsedio);
    }

    public void desocupar(){
    }

    @Override
    public void montar() {
        armaDeAsedio.estado = new EstadoArmaDeAsedioArmadoOcupado(armaDeAsedio);
    }

    @Override
    public void desmontar() {
        throw new UnidadDesarmadaException();
    }

    @Override
    public void atacar(Edificio edificio){ throw new UnidadDesarmadaException();}
}
