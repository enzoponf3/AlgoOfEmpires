package Modelo.Edificios;

import Modelo.Exceptions.EdificioDestruidoException;
import Modelo.Unidades.ArmaDeAsedio;

public class Castillo extends Edificio {

    private static final int VIDA = 1000;
    private static final int VELOCIDAD_REPARACION = 15;
    private static final int ANCHO = 4;
    private static final int ALTO = 4;
    private static final int DISTANCIA_MAXIMA_ATAQUE = 3;
    private static final int DANIO = 20;


    private int danio;
    private int distanciaMaximaAtaque;
    private IEstadoCastillo estado;

    public Castillo() {
        this.vidaMax = VIDA;
        this.vida = VIDA;
        this.velocidadReparacion = VELOCIDAD_REPARACION;
        this.ancho = ANCHO;
        this.alto = ALTO;
        this.distanciaMaximaAtaque = DISTANCIA_MAXIMA_ATAQUE;
        this.danio = DANIO;
        this.estado = new EstadoCastilloConstruido();
    }

    @Override
    public void reducirVida(int cant) {
        if (this.vida <= 0)
            throw new EdificioDestruidoException();
        this.vida -= cant;
        if (this.vida <= 0)
            this.estado = new EstadoCastilloDestruido();
    }

    public ArmaDeAsedio crearArmaDeAsedio() {
        return this.estado.crearArmaDeAsedio();
    }

    @Override
    public void reparar() {
        this.estado.reparar(this);
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

    void construido() {
        this.estado = new EstadoCastilloConstruido();
    }
//
//    LE PASO UN LISTADO DE OBJETIVOS
//
//    public void atacarA(ElementoMapa[] objetivos) {
//        for (ElementoMapa objetivo : objetivos)
//            objetivo.reducirVida(this.danio)
//    }
//
//    HAY QUE CREAR LA INTERFAZ ELEMENTOMAPA QUE IMPLEMENTARIAN UNIDAD Y EDIFICIO
//    ¿ COMPROBAMOS FUERA DEL CASTILLO LOS ELEMENTOS A MENOS DE DISTANCIA_MAXIMA ?
//
}
