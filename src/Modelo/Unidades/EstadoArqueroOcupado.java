package Modelo.Unidades;
import Modelo.Edificios.Edificio;
import Modelo.Posicion;
import Modelo.Exceptions.UnidadEstaOcupadoException;

public class EstadoArqueroOcupado implements IEstadoArquero {
    Arquero arquero;
    public EstadoArqueroOcupado(Arquero arquero){
        this.arquero = arquero;
    }

    @Override
    public void mover(Posicion destino){
        throw new UnidadEstaOcupadoException();
    }

    public void atacar(Edificio edificio) { throw new UnidadEstaOcupadoException();}

    public void atacar(Unidad unidad){ throw new UnidadEstaOcupadoException();}
}
