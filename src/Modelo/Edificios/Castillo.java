package Modelo.Edificios;

import Modelo.Exceptions.EdificioDestruidoException;
import Modelo.Posicion;
import Modelo.Unidades.ArmaDeAsedio;
import Modelo.Unidades.Unidad;

import java.util.ArrayList;

public class Castillo extends Edificio {

    private static final int VIDA = 1000;
    private static final int VELOCIDAD_REPARACION = 15;
    private static final int DISTANCIA_MAXIMA_ATAQUE = 3;
    private static final int DANIO = 20;


    private int danio;
    private IEstadoCastillo estado;

    public Castillo() {
        this.vidaMax = VIDA;
        this.vida = VIDA;
        this.velocidadReparacion = VELOCIDAD_REPARACION;
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

    public void enReparacion() {
        this.estado = new EstadoCastilloEnReparacion();
    }

    public void volverAEstadoOriginal() {
        this.estado.volverAEstadoOriginal(this);
    }

    void construido() {
        this.estado = new EstadoCastilloConstruido();
    }

    private boolean estaEnRango(Edificio edificio) {
        ArrayList<Posicion> posicionesOtroEdificio = edificio.getPosiciones();
        for (Posicion posicion : this.posiciones) {
            for (Posicion posicionOtroEdificio : posicionesOtroEdificio) {
                if (posicion.estaEnRango(posicionOtroEdificio, DISTANCIA_MAXIMA_ATAQUE))
                    return true;
            }
        }
        return false;
    }

    private boolean estaEnRango(Unidad unidad) {
        Posicion posicionUnidad = unidad.getPosicion();
        for (Posicion posicion : this.posiciones) {
            if (posicion.estaEnRango(posicionUnidad, DISTANCIA_MAXIMA_ATAQUE))
                    return true;
        }
        return false;
    }

    public void atacarEdificios(ArrayList<Edificio> edificios) {
        for (Edificio edificio : edificios) {
            if (this.estaEnRango(edificio))
               edificio.reducirVida(this.danio);
        }
    }

    public void atacarUnidades(ArrayList<Unidad> unidades) {
        for (Unidad unidad : unidades) {
            if (this.estaEnRango(unidad))
                unidad.reducirVida(this.danio);
        }
    }


}
