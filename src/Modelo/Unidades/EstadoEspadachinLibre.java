package Modelo.Unidades;
import Modelo.Exceptions.EntidadFueraDeRangoException;
import Modelo.Posicion;
import Modelo.Edificios.Edificio;

import java.util.ArrayList;

public class EstadoEspadachinLibre implements EstadoEspadachin {
    @Override
    public void mover(Posicion destino, Espadachin espadachin){
        espadachin.cambiarPosicion(destino);
        espadachin.ocupar();
    }

    @Override
    public void atacar(Espadachin espadachin, Unidad unidad){
        if (!espadachin.posicion.estaEnRango(unidad.getPosicion(), espadachin.rango)) {
           throw new EntidadFueraDeRangoException();
        }
        unidad.reducirVida(espadachin.getDanioUnidad());
        espadachin.ocupar();
    }
    @Override
    public void atacar(Espadachin espadachin, Edificio edificio){
        ArrayList<Posicion> posiciones = edificio.getPosiciones();
        for (Posicion pos : posiciones ){
            if (espadachin.posicion.estaEnRango(pos, espadachin.rango)){
                edificio.reducirVida(espadachin.getDanioEdificio());
                espadachin.ocupar();
                return;
            }
        }
        throw new EntidadFueraDeRangoException();
    }
}
