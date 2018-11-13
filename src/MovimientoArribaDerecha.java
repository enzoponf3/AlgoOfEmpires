public class MovimientoArribaDerecha implements Movimiento{
    public Posicion desplazarPosicion(Posicion posicion) {
        posicion.aumentarVertical();
        posicion.aumentarHorizontal();
        return posicion;
    }
}
