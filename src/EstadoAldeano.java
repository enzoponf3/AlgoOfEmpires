public interface EstadoAldeano {
    int generaOro();
    Cuartel construirCuartel(Unidad unidad);
    PlazaCentral construirPlazaCentral(Unidad unidad);
    void repararEdificio(Edificio edificio,Unidad unidad);
    void continuarConstruccion(Edificio edificio,Unidad unidad);
}
