public interface EstadoArmaDeAsedio {

    void mover(Posicion destino, ArmaDeAsedio armaDeAsedio);
    void desocupar(ArmaDeAsedio armaDeAsedio);
}
