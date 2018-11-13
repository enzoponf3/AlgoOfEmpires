public interface Estado {
    void atacar(Unidad unidad,Unidad atacante);
    void moverHaciaArriba(Unidad unidad);
    void moverHaciaAbajo(Unidad unidad);
    void moverHaciaIzquierda(Unidad unidad);
    void moverHaciaDerecha(Unidad unidad);
    void moverHaciaArribaIzquierda(Unidad unidad);
    void moverHaciaArribaDerecha(Unidad unidad);
    void moverHaciaAbajoIzquierda(Unidad unidad);
    void moverHaciaAbajoDerecha(Unidad unidad);
    Cuartel construirCuartel(Unidad unidad);
    PlazaCentral construirPlazaCentral(Unidad unidad);
    void continuarConstruccion(Edificio edificio,Unidad unidad);
    void repararEdificio(Edificio edificio,Unidad unidad);
    int generaOro();
}
