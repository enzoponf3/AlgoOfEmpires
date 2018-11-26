package Modelo.Unidades;
import Modelo.Edificios.Edificio;
import Modelo.Exceptions.*;

public class EstadoArmaDeAsedioDesarmado extends EstadoAtacante implements IEstadoArmaDeAsedio {

    public EstadoArmaDeAsedioDesarmado(ArmaDeAsedio arma){
        super(arma);
    }


    public IEstadoArmaDeAsedio desocupar(ArmaDeAsedio arma) {
        return new EstadoArmaDeAsedioDesarmado(arma);
    }

    public IEstadoArmaDeAsedio montar(ArmaDeAsedio arma) {
        return new EstadoArmaDeAsedioArmadoOcupado(arma);
    }

    @Override
    public IEstadoArmaDeAsedio desmontar(ArmaDeAsedio arma) {
        throw new UnidadDesarmadaException();
    }

    @Override
    public void atacar(Edificio edificio){ throw new UnidadDesarmadaException();}

    @Override
    public void atacar(Unidad unidad){
        throw new ArmaDeAsedioNoAtacaUnidadException();
    }

    public IEstadoArmaDeAsedio ocupar(ArmaDeAsedio arma){
        return new EstadoArmaDeAsedioDesarmadoOcupado(arma);
    }

}
