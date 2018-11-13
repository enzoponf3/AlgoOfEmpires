public class MovimientoDerecha implements Movimiento{
    public Posicion desplazarPosicion(Posicion posicion) {
        posicion.aumentarHorizontal();
        return posicion;
    }
}
