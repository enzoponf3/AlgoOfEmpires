public class MovimientoDerecha implements Movimiento{
    public Posicion desplazarPosicion(Posicion posicion) {
        posicion.incrementarCoordenadaHorizontal();
        return posicion;
    }
}
