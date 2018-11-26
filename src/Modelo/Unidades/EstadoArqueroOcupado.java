package Modelo.Unidades;
import Modelo.Edificios.Edificio;
import Modelo.Posicion;
import Modelo.Exceptions.UnidadEstaOcupadoException;

public class EstadoArqueroOcupado extends EstadoAtacante implements IEstadoArquero {

    public EstadoArqueroOcupado(Arquero arquero){
        super(arquero);
    }

    @Override
    public void mover(Posicion destino){
        throw new UnidadEstaOcupadoException();
    }

    public void atacar(Edificio edificio) { throw new UnidadEstaOcupadoException();}

    public void atacar(Unidad unidad){ throw new UnidadEstaOcupadoException();}
}
