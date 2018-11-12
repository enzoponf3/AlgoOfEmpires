

public interface EstadoCuartel {

    Espadachin crearEspadachin();

    Arquero crearArquero();

    void reparar(Cuartel cuartel);

    void construir(Cuartel cuartel);

    int getTurnosConstruccion();
}
