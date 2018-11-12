
public class EstadoCuartelEnConstruccion implements EstadoCuartel{

    public static final int TURNOS = 3;

    private int turnos;

    public EstadoCuartelEnConstruccion() {
        this.turnos = TURNOS;
    }

    @Override
    public Espadachin crearEspadachin() {
        if (this.turnos > 0)
            throw new EdificioEnConstruccionException();
        return null;
    }

    @Override
    public Arquero crearArquero() {
        if (this.turnos > 0)
            throw new EdificioEnConstruccionException();
        return null;
    }

    @Override
    public void reparar(Cuartel cuartel) {
        if (this.turnos > 0)
            throw new EdificioEnConstruccionException();
    }

    @Override
    public void construir(Cuartel cuartel) {
        this.turnos -=1;
        if (this.turnos == 0)
            cuartel.finalizarConstruccion();
    }

    @Override
    public int getTurnosConstruccion() {
        return this.turnos;
    }
}
