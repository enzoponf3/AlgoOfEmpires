public class MovimientoArribaIzquierda {
    public Posicion desplazarPosicion(Posicion posicion) {
        posicion.disminuirHorizontal();
        posicion.aumentarVertical();
        return posicion;
    }
}
