public class EstadoAldeanoLibre implements EstadoAldeano {

    public int generaOro(){
        return 20;
    }

    public Cuartel construirCuartel(Unidad unidad){
        unidad.ocuparse();
        return new Cuartel();
    }

    public PlazaCentral construirPlazaCentral(Unidad unidad){
        unidad.ocuparse();
        return new PlazaCentral();
    }

    public void repararEdificio(Edificio edificio,Unidad unidad){
        edificio.reparar();
        unidad.ocuparse();
    }

    public void continuarConstruccion(Edificio edificio,Unidad unidad){
        edificio.construir();
        unidad.ocuparse();
    }

    /*public void moverUnidad(Unidad unidad,Movimiento movimiento){             ver como hacer
        unidad.posicion = movimiento.desplazarPosicion(unidad.posicion);
        unidad.ocuparse();
    }*/
}
