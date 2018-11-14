public class MovimientoIzquierda implements Movimiento{
    @Override
    public Posicion desplazarPosicion(Posicion posicion) {
        posicion.decrementarCoordenadaHorizontal();
        return posicion;
    }
}
