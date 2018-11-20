package Modelo.Unidades;
import Modelo.Edificios.Edificio;
import Modelo.Posicion;
import Modelo.Exceptions.*;

import java.util.ArrayList;

public class EstadoArmaDeAsedioArmado implements IEstadoArmaDeAsedio {

    @Override
    public void mover(Posicion destino, ArmaDeAsedio armaDeAsedio){
        throw new UnidadEstaMontadaException();
    }
    public void desocupar(ArmaDeAsedio armaDeAsedio){ }
    public void montar (ArmaDeAsedio armaAsedio){ throw new UnidadEstaMontadaException();}
    public void desmontar (ArmaDeAsedio armaAsedio){ armaAsedio.estado = new EstadoArmaDeAsedioDesarmadoOcupado();}

    @Override
    public void atacar(ArmaDeAsedio armaDeAsedio,  Edificio edificio){
        ArrayList<Posicion> posiciones = edificio.getPosiciones();
        for (Posicion pos : posiciones ){
            if (armaDeAsedio.posicion.estaEnRango(pos, armaDeAsedio.getRango())){
                edificio.reducirVida(armaDeAsedio.getDanioEdificio());
                armaDeAsedio.estado = new EstadoArmaDeAsedioArmadoOcupado();
                return;
            }
        }
        throw new EntidadFueraDeRangoException();
    }
}
