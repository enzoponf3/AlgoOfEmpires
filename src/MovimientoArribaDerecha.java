public class MovimientoArribaDerecha {
    public Posicion desplazarPosicion(Posicion posicion) {
        posicion.aumentarVertical();
        posicion.aumentarHorizontal();
        return posicion;
    }
}
