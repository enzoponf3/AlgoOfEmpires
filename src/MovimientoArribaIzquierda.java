public class MovimientoArribaIzquierda implements Movimiento{
    public Posicion desplazarPosicion(Posicion posicion) {
        posicion.disminuirHorizontal();
        posicion.aumentarVertical();
        return posicion;
    }
}
