public class MovimientoAbajoIzquierda implements Movimiento{
    public Posicion desplazarPosicion(Posicion posicion) {
        posicion.decrementarCoordenadaVertical();
        posicion.decrementarCoordenadaHorizontal();
        return posicion;
    }
}
