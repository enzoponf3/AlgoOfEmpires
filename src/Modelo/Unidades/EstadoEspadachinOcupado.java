package Modelo.Unidades;
import Modelo.Posicion;
import Modelo.Edificios.Edificio;
import Modelo.Exceptions.*;
public class EstadoEspadachinOcupado extends EstadoAtacante implements IEstadoEspadachin {


    public EstadoEspadachinOcupado(Espadachin espadachin){
        super(espadachin);
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
