public class MovimientoIzquierda implements Movimiento{
    @Override
    public Posicion desplazarPosicion(Posicion posicion) {
        posicion.disminuirHorizontal();
        return posicion;
    }
}
