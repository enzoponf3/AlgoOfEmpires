public class MovimientoAbajoDerecha implements Movimiento {
    public Posicion desplazarPosicion(Posicion posicion) {
        posicion.disminuirVertical();
        posicion.aumentarHorizontal();
        return posicion;
    }
}
