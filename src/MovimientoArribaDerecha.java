public class MovimientoArribaDerecha implements Movimiento{
    public Posicion desplazarPosicion(Posicion posicion) {
        posicion.incrementarCoordenadavertical();
        posicion.incrementarCoordenadaHorizontal();
        return posicion;
    }
}
