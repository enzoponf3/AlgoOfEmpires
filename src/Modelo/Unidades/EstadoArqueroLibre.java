package Modelo.Unidades;
import Modelo.Edificios.Edificio;
import Modelo.Exceptions.EntidadFueraDeRangoException;
import Modelo.Posicion;

import java.util.ArrayList;

public class EstadoArqueroLibre implements IEstadoArquero {

    Arquero arquero;
    public EstadoArqueroLibre(Arquero arquero){
        this.arquero = arquero;
    }

    @Override
    public void mover(Posicion destino){
        arquero.cambiarPosicion(destino);
        arquero.ocupar();
    }

    @Override
    public void atacar(Unidad unidad){
        if (!arquero.posicion.estaEnRango(unidad.getPosicion(), arquero.getRango())) {
            throw new EntidadFueraDeRangoException();
        }
        unidad.reducirVida(arquero.getDanioUnidad());
        arquero.ocupar();
    }

    @Override
    public void atacar(Edificio edificio){
        ArrayList<Posicion> posiciones = edificio.getPosiciones();
        for (Posicion pos : posiciones ){
            if (arquero.posicion.estaEnRango(pos, arquero.getRango())){
                edificio.reducirVida(arquero.getDanioEdificio());
                arquero.ocupar();
                return;
            }
        }
        throw new EntidadFueraDeRangoException();
    }
}
