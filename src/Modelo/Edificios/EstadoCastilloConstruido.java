package Modelo.Edificios;
import Modelo.Exceptions.EdificioConVidaAlMaximoException;
import Modelo.Mapa;
import Modelo.Posicion;
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
    public ArmaDeAsedio crearArmaDeAsedio(Mapa mapa, Castillo castillo) {
        Posicion posicionArmaAsedio = mapa.devolverPosicionAledaniaLibre(castillo);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicionArmaAsedio);
        mapa.ocuparCasillero(posicionArmaAsedio,armaDeAsedio);
        return armaDeAsedio;
    }
}
