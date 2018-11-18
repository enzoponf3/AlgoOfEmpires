public interface EstadoEspadachin {

    void mover(Posicion destino, Espadachin espadachin);
    void atacar(Espadachin espadachin,Edificio edificio);
    void atacar(Espadachin espadachin,Unidad unidad);
}
