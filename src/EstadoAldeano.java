public interface EstadoAldeano{

    int generaOro();

    Cuartel construirCuartel(Aldeano aldeano);

    PlazaCentral construirPlazaCentral(Aldeano aldeano);

    void repararEdificio(Edificio edificio, Aldeano aldeano);

    void continuarConstruccion(Edificio edificio, Aldeano aldeano);

    void mover(Posicion destino, Aldeano aldeano);

}
