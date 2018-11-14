public class MovimientoArribaIzquierda implements Movimiento{
    public Posicion desplazarPosicion(Posicion posicion) {
        posicion.decrementarCoordenadaHorizontal();
        posicion.incrementarCoordenadavertical();
        return posicion;
    }
}
