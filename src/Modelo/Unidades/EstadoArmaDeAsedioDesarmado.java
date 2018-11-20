package Modelo.Unidades;
import Modelo.Edificios.Edificio;
import Modelo.Posicion;
import Modelo.Exceptions.*;

public class EstadoArmaDeAsedioDesarmado implements IEstadoArmaDeAsedio {
    @Override
    public void mover(Posicion destino, ArmaDeAsedio armaDeAsedio){
        armaDeAsedio.cambiarPosicion(destino);
        armaDeAsedio.estado = new EstadoArmaDeAsedioDesarmadoOcupado();
    }

    public void desocupar(ArmaDeAsedio armaDeAsedio){
    }

    @Override
    public void montar(ArmaDeAsedio armaAsedio) {
        armaAsedio.estado = new EstadoArmaDeAsedioArmadoOcupado();
    }

    @Override
    public void desmontar(ArmaDeAsedio armaAsedio) {
        throw new UnidadDesarmadaException();
    }

    @Override
    public void atacar(ArmaDeAsedio armaDeAsedio, Edificio edificio){ throw new UnidadDesarmadaException();}
}
