package Modelo.Unidades;
import Modelo.Posicion;
import Modelo.Exceptions.*;

public class EstadoArmaDeAsedioDesarmado implements EstadoArmaDeAsedio {
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
}
