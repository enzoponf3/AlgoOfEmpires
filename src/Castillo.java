
public class Castillo extends Edificio {

    public static final int VIDA = 1000;
    public static final int VELOCIDAD_REPARACION = 15;

    public Castillo() {
        this.vidaMax = VIDA;
        this.vida = VIDA;
        this.velocidadReparacion = VELOCIDAD_REPARACION;
    }

    public void crearArmaDeAsedio() {

    }
}
