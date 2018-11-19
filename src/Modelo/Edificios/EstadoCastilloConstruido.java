package Modelo.Edificios;
import Modelo.Exceptions.EdificioConVidaAlMaximoException;
import Modelo.Unidades.ArmaDeAsedio;

public class EstadoCastilloConstruido implements IEstadoCastillo {

    @Override
    public void reparar(Castillo castillo) {
        castillo.aumentarVida();
    }

    @Override
    public void volverAEstadoOriginal(Castillo castillo) {
        // Estado continua siendo construido
    }

    @Override
    public ArmaDeAsedio crearArmaDeAsedio() {
        return new ArmaDeAsedio();
    }
}
