public class MovimientoAbajo implements Movimiento {

    public Posicion desplazarPosicion(Posicion posicion){
        posicion.decrementarCoordenadaVertical();
        return posicion;
    }

}
