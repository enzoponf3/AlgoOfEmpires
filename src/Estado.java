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
}
