public class PlazaCentral extends Edificio {

    private static final int VIDA = 450;
    private static final int COSTO = 100;
    private static final int VELOCIDAD_REPARACION = 25;
    private static final int ANCHO = 2;
    private static final int ALTO = 2;

    private EstadoPlazaCentral estado;

    public PlazaCentral() {
        this.vidaMax = VIDA;
        this.vida = 0;
        this.costo = COSTO;
        this.velocidadReparacion = VELOCIDAD_REPARACION;
        this.ancho = ANCHO;
        this.alto = ALTO;
        this.estado = new EstadoPlazaCentralEnConstruccion();
    }

    @Override
    public void reparar() {
        this.estado.reparar(this);
    }

    public int getCosto() {
        return this.costo;
    }

    public Aldeano crearAldeano() {
        return this.estado.crearAldeano();
    }

    @Override
    public void construir() {
        this.estado.construir(this);
    }

    protected void finalizarConstruccion() {
        this.vida = VIDA;
        this.estado = new EstadoPlazaCentralConstruida();
    }

    public int getTurnosNecesariosConstruccion() {
        return this.estado.getTurnosConstruccion();
    }

    public void enReparacion() {
        this.estado = new EstadoPlazaCentralEnReparacion();
    }

    public void construida() {
        this.estado = new EstadoPlazaCentralConstruida();
    }

    public void volverAEstadoOriginal() {
        this.estado.volverAEstadoOriginal(this);
    }

}
