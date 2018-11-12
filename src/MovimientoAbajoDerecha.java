public class MovimientoAbajoDerecha {
    public Posicion desplazarPosicion(Posicion posicion) {
        posicion.disminuirVertical();
        posicion.aumentarHorizontal();
        return posicion;
    }
}
