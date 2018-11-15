package algoEmpires;

public interface EstadoPlazaCentral {

    Aldeano crearAldeano();

    void reparar(PlazaCentral plaza);

    void construir(PlazaCentral plaza);

    int getTurnosConstruccion();

    void volverAEstadoOriginal(PlazaCentral plazaCentral);
}
