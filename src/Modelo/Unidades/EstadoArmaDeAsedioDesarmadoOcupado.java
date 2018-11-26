package Modelo.Unidades;
import Modelo.Edificios.Edificio;
import Modelo.Posicion;
import Modelo.Exceptions.*;

public class EstadoArmaDeAsedioDesarmadoOcupado extends EstadoAtacante implements IEstadoArmaDeAsedio {
    
    public EstadoArmaDeAsedioDesarmadoOcupado(ArmaDeAsedio arma){
        super(arma);
    }
    
    @Override
    public void mover(Posicion destino){
        throw new UnidadEstaOcupadoException();
    }
    public IEstadoArmaDeAsedio montar(ArmaDeAsedio arma){throw new UnidadEstaOcupadoException();}
    public IEstadoArmaDeAsedio desocupar(ArmaDeAsedio arma){return new EstadoArmaDeAsedioDesarmado(arma);}
    public IEstadoArmaDeAsedio desmontar (ArmaDeAsedio arma){ throw new UnidadEstaOcupadoException();}

    @Override
    public void atacar (Edificio edificio){ throw new UnidadDesarmadaException();}


    public IEstadoArmaDeAsedio ocupar(ArmaDeAsedio arma) {
        throw new UnidadEstaOcupadoException();
    }
}
