
public class EstadoLibre implements Estado{
    private boolean LIBRE = true;

    public void moverHaciaArriba(Unidad unidad){
        MovimientoArriba movimiento = new MovimientoArriba();
        unidad.posicion = movimiento.desplazarPosicion(unidad.posicion);
        unidad.ocuparse();
    }
    public void moverHaciaAbajo(Unidad unidad){
        MovimientoAbajo movimiento = new MovimientoAbajo();
        unidad.posicion = movimiento.desplazarPosicion(unidad.posicion);
        unidad.ocuparse();
    }
    public void moverHaciaIzquierda(Unidad unidad){
        MovimientoIzquierda movimiento = new MovimientoIzquierda();
        unidad.posicion = movimiento.desplazarPosicion(unidad.posicion);
        unidad.ocuparse();
    }
    public void moverHaciaDerecha(Unidad unidad){
        MovimientoDerecha movimiento = new MovimientoDerecha();
        unidad.posicion = movimiento.desplazarPosicion(unidad.posicion);
        unidad.ocuparse();
    }
    public void moverHaciaArribaIzquierda(Unidad unidad){
        MovimientoArribaIzquierda movimiento = new MovimientoArribaIzquierda();
        unidad.posicion = movimiento.desplazarPosicion(unidad.posicion);
        unidad.ocuparse();
    }
    public void moverHaciaArribaDerecha(Unidad unidad){
        MovimientoArribaDerecha movimiento = new MovimientoArribaDerecha();
        unidad.posicion = movimiento.desplazarPosicion(unidad.posicion);
        unidad.ocuparse();
    }
    public void moverHaciaAbajoIzquierda(Unidad unidad){
        MovimientoAbajoIzquierda movimiento = new MovimientoAbajoIzquierda();
        unidad.posicion = movimiento.desplazarPosicion(unidad.posicion);
        unidad.ocuparse();
    }
    public void moverHaciaAbajoDerecha(Unidad unidad){
        MovimientoAbajoDerecha movimiento = new MovimientoAbajoDerecha();
        unidad.posicion = movimiento.desplazarPosicion(unidad.posicion);
        unidad.ocuparse();
    }

    public int generaOro(){
        return 0;
    }

    public void atacar(Unidad unidad,Unidad atacante){
        unidad.reducirVida(atacante.getDanio());
    }

    public PlazaCentral construirPlazaCentral(Unidad unidad){
        throw new UnidadNoPuedeConstruirException();
    }

    public Cuartel construirCuartel(Unidad unidad){
        throw new UnidadNoPuedeConstruirException();
    }

    public void repararEdificio(Edificio edificio,Unidad unidad) {
        throw new UndidadNoPuedeRepararException();
    }

    public void continuarConstruccion(Edificio edificio,Unidad unidad){
        throw new UnidadNoPuedeConstruirException();
    }

}

