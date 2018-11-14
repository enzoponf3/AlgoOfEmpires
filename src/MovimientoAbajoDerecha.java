public class MovimientoAbajoDerecha implements Movimiento {
    public Posicion desplazarPosicion(Posicion posicion) {
        posicion.decrementarCoordenadaVertical();
        posicion.incrementarCoordenadaHorizontal();
        return posicion;
    }
}
