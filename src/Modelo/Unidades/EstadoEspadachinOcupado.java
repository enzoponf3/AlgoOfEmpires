package Modelo.Unidades;
import Modelo.Posicion;
import Modelo.Edificios.Edificio;
import Modelo.Exceptions.*;
public class EstadoEspadachinOcupado implements IEstadoEspadachin {
    @Override
    public void mover(Posicion destino, Espadachin espadachin){
        throw new UnidadEstaOcupadoException();
    }

    @Override
    public void atacar(Espadachin espadachin, Unidad unidad){ throw new UnidadEstaOcupadoException();}
    @Override
    public void atacar(Espadachin espadachin, Edificio edificio){ throw new UnidadEstaOcupadoException();}
}
