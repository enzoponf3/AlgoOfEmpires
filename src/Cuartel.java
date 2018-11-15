public class Cuartel extends Edificio {

    private static final int VIDA = 250;
    private static final int COSTO = 50;
    private static final int VELOCIDAD_REPARACION = 50;
    private static final int ANCHO = 2;
    private static final int ALTO = 2;


    private EstadoCuartel estado;

    public Cuartel() {
        this.vidaMax = VIDA;
        this.vida = 0;
        this.costo = COSTO;
        this.velocidadReparacion = VELOCIDAD_REPARACION;
        this.ancho = ANCHO;
        this.alto = ALTO;
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

    public void enReparacion() {
        this.estado = new EstadoCuartelEnReparacion();
    }

    public void construido() {
        this.estado = new EstadoCuartelConstruido();
    }

    public void volverAEstadoOriginal() {
        this.estado.volverAEstadoOriginal(this);
    }
}
