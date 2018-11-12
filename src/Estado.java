public interface Estado {

    PlazaCentral construirPlazaCentral(Aldeano aldeano);
    Cuartel construirCuartel(Aldeano aldeano);
    void repararEdificio(Edificio edificio,Aldeano aldeano);
    void continuarConstruccionPlazaCentral(PlazaCentral plaza, Aldeano aldeano);
    void continuarConstruccionCuartel(Cuartel cuartel, Aldeano aldeano);
    void atacar(Unidad unidad,Unidad atacante);
    boolean comprobarEstado();
    boolean estaOcupado();
}
