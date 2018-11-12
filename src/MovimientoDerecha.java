public class MovimientoDerecha {
    public Posicion desplazarPosicion(Posicion posicion) {
        posicion.aumentarHorizontal();
        return posicion;
    }
}
