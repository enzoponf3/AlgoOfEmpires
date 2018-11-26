package Modelo.Unidades;
import Modelo.Exceptions.EntidadFueraDeRangoException;
import Modelo.Posicion;
import Modelo.Edificios.Edificio;

import java.util.ArrayList;

public class EstadoEspadachinLibre extends EstadoAtacante implements IEstadoEspadachin {

    public EstadoEspadachinLibre(Espadachin espadachin){
        super(espadachin);
    }

}
