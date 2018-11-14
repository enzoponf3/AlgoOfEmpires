public class MovimientoAbajoIzquierda implements Movimiento{
    public Posicion desplazarPosicion(Posicion posicion) {
        posicion.disminuirVertical();
        posicion.disminuirHorizontal();
        return posicion;
    }
}
