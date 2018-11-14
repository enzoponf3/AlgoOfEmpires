public class EstadoAldeanoLibre implements EstadoAldeano {

    @Override
    public int generaOro(){
        return 20;
    }

    @Override
    public Cuartel construirCuartel(Aldeano aldeano){
        aldeano.ocupar();
        return new Cuartel();
    }

    @Override
    public PlazaCentral construirPlazaCentral(Aldeano aldeano){
        aldeano.ocupar();
        return new PlazaCentral();
    }

    @Override
    public void repararEdificio(Edificio edificio, Aldeano aldeano){
        edificio.reparar();
        aldeano.ocupar();
    }

    @Override
    public void continuarConstruccion(Edificio edificio, Aldeano aldeano){
        edificio.construir();
        aldeano.ocupar();
    }


    @Override
    public void mover(Posicion destino, Aldeano aldeano){
        aldeano.cambiarPosicion(destino);
        aldeano.ocupar();
    }
}
