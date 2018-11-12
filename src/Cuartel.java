public class Cuartel extends Edificio {

    public static final int VIDA = 250;
    public static final int COSTO = 50;
    public static final int VELOCIDAD_REPARACION = 50;

    private EstadoCuartel estado;

    public Cuartel() {
        this.vidaMax = VIDA;
        this.vida = 0;
        this.costo = COSTO;
        this.velocidadReparacion = VELOCIDAD_REPARACION;
        this.estado = new EstadoCuartelEnConstruccion();
    }

    @Override
    public void reparar() {
        this.estado.reparar(this);
    }

    public int getCosto() {
        return this.costo;
    }

    public Espadachin crearEspadachin() {
        return this.estado.crearEspadachin();
    }

    public Arquero crearArquero() {
        return this.estado.crearArquero();
    }

    public void construir() {
        this.estado.construir(this);
    }

    protected void finalizarConstruccion() {
        this.vida = VIDA;
        this.estado = new EstadoCuartelConstruido();
    }

    public int getTurnosNecesariosConstruccion() {
        return this.estado.getTurnosConstruccion();
    }
}
