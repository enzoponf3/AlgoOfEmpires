package algoEmpires;

public class Castillo extends Edificio {

    private static final int VIDA = 1000;
    private static final int VELOCIDAD_REPARACION = 15;
    private static final int ANCHO = 4;
    private static final int ALTO = 4;
    private static final int DISTANCIA_MAXIMA_ATAQUE = 3;
    private static final int DAÑO = 20;


    private int daño;
    private int distanciaMaximaAtaque;
    private EstadoCastillo estado;

    public Castillo() {
        this.vidaMax = VIDA;
        this.vida = VIDA;
        this.velocidadReparacion = VELOCIDAD_REPARACION;
        this.ancho = ANCHO;
        this.alto = ALTO;
        this.distanciaMaximaAtaque = DISTANCIA_MAXIMA_ATAQUE;
        this.daño = DAÑO;
        this.estado = new EstadoCastilloConstruido();
    }

    @Override
    public void reparar() {
        this.estado.reparar(this);
    }

    public ArmaDeAsedio crearArmaDeAsedio() {
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        return armaDeAsedio;
    }

    public int getDistanciaMaximaAtaque() {
        return this.distanciaMaximaAtaque;
    }

    public void enReparacion() {
        this.estado = new EstadoCastilloEnReparacion();
    }

    public void volverAEstadoOriginal() {
        this.estado.volverAEstadoOriginal(this);
    }

    public void construido() {
        this.estado = new EstadoCastilloConstruido();
    }
//
//    LE PASO UN LISTADO DE OBJETIVOS
//
//    public void atacarA(ElementoMapa[] objetivos) {
//        for (ElementoMapa objetivo : objetivos)
//            objetivo.reducirVida(this.daño)
//    }
//
//    HAY QUE CREAR LA INTERFAZ ELEMENTOMAPA QUE IMPLEMENTARIAN UNIDAD Y EDIFICIO
//    ¿ COMPROBAMOS FUERA DEL CASTILLO LOS ELEMENTOS A MENOS DE DISTANCIA_MAXIMA ?
//
}
