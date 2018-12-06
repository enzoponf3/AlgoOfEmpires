package Modelo.Edificios;

import Modelo.Exceptions.EdificioEnReparacionException;
import Modelo.Mapa;
import Modelo.Posicion;
import Modelo.Unidades.ArmaDeAsedio;

public class EstadoCastilloEnReparacion implements IEstadoCastillo {


    @Override
    public void reparar(Castillo castillo) {
        throw new EdificioEnReparacionException();
    }

    @Override
    public void volverAEstadoOriginal(Castillo castillo) {
        castillo.construido();
    }

    @Override
    public ArmaDeAsedio crearArmaDeAsedio(Mapa mapa, Castillo castillo) {
        Posicion posicionArmaAsedio = mapa.devolverPosicionAledaniaLibre(castillo);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicionArmaAsedio);
        return armaDeAsedio;
    }

    @Override
    public boolean estaDestruido() {
        return false;
    }
}
