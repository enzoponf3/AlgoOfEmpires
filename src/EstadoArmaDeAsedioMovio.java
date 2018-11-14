public class EstadoArmaDeAsedioMovio implements EstadoArmaDeAsedio {
    public void mover(Posicion destino, ArmaDeAsedio armaDeAsedio){
        throw new UnidadEstaOcupadoException();
    }
    public void desocupar(ArmaDeAsedio armaDeAsedio){
        armaDeAsedio.desmontar();
    }
}
