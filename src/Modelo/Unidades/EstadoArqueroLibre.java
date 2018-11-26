package Modelo.Unidades;
import Modelo.Edificios.Edificio;
import Modelo.Exceptions.EntidadFueraDeRangoException;
import Modelo.Posicion;

import java.util.ArrayList;

public class EstadoArqueroLibre extends EstadoAtacante implements IEstadoArquero {
    public EstadoArqueroLibre(Arquero arquero){
        super(arquero);
    }
}
