public class EstadoAldeanoLibre implements EstadoAldeano {

    @Override
    public int generaOro(){
        return 20;
    }
/*
    @Override
    public Cuartel construirCuartel(Unidad unidad){
        unidad.ocuparse();
        return new Cuartel();
    }

    @Override
    public PlazaCentral construirPlazaCentral(Unidad unidad){
        unidad.ocuparse();
        return new PlazaCentral();
    }

    @Override
    public void repararEdificio(Edificio edificio,Unidad unidad){
        edificio.reparar();
        unidad.ocuparse();
    }

    @Override
    public void continuarConstruccion(Edificio edificio,Unidad unidad){
        edificio.construir();
        unidad.ocuparse();
    }
*/
    /*public void moverUnidad(Unidad unidad,Movimiento movimiento){             ver como hacer
        unidad.posicion = movimiento.desplazarPosicion(unidad.posicion);
        unidad.ocuparse();
    }*/

    @Override
    public void mover(Movimiento movimiento, Posicion posicion, Aldeano aldeano){
        movimiento.desplazarPosicion(posicion);
        aldeano.ocuparse();
    }
}
