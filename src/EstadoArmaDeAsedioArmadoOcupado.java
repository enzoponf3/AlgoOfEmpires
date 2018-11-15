public class EstadoArmaDeAsedioArmadoOcupado implements EstadoArmaDeAsedio{

    @Override
    public void mover(Posicion destino, ArmaDeAsedio armaDeAsedio){
        throw new UnidadEstaOcupadoException();
    }

    public void desocupar(ArmaDeAsedio armaDeAsedio){ armaDeAsedio.estado = new EstadoArmaDeAsedioArmado(); }

    public void montar(ArmaDeAsedio armaAsedio){throw new UnidadEstaOcupadoException();}
    public void desmontar (ArmaDeAsedio armaAsedio){ throw new UnidadEstaOcupadoException();}
}
