public class EstadoArmaDeAsedioDesarmadoOcupado implements EstadoArmaDeAsedio {

    @Override
    public void mover(Posicion destino, ArmaDeAsedio armaDeAsedio){
        throw new UnidadEstaOcupadoException();
    }
    public void montar(ArmaDeAsedio armaAsedio){throw new UnidadEstaOcupadoException();}
    public void desocupar(ArmaDeAsedio armaDeAsedio){armaDeAsedio.estado = new EstadoArmaDeAsedioDesarmado();}
    public void desmontar (ArmaDeAsedio armaAsedio){ throw new UnidadEstaOcupadoException();}
}