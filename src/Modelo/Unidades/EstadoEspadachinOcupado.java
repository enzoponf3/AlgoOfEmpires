package Modelo.Unidades;
import Modelo.Posicion;
import Modelo.Edificios.Edificio;
import Modelo.Exceptions.*;
public class EstadoEspadachinOcupado implements IEstadoEspadachin {

    Espadachin espadachin;
    public EstadoEspadachinOcupado(Espadachin espadachin){
        this.espadachin = espadachin;
    }
    @Override
    public void mover(Posicion destino){
        throw new UnidadEstaOcupadoException();
    }

    @Override
    public void atacar(Unidad unidad){ throw new UnidadEstaOcupadoException();}
    @Override
    public void atacar(Edificio edificio){ throw new UnidadEstaOcupadoException();}
}
