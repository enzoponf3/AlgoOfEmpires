public class MovimientoArriba implements Movimiento{
    public Posicion desplazarPosicion(Posicion posicion) {
        posicion.incrementarCoordenadavertical();
        return posicion;
    }
}