public class MovimientoArriba {
    public Posicion desplazarPosicion(Posicion posicion) {
        posicion.aumentarVertical();
        return posicion;
    }
}
