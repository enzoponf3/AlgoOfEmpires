package Modelo.Edificios;

import Modelo.Exceptions.EdificioDestruidoException;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;

import java.util.ArrayList;

public class PlazaCentral extends Edificio {

    private static final int VIDA = 450;
    private static final int COSTO = 100;
    private static final int VELOCIDAD_REPARACION = 25;
    private static final int ANCHO = 2;
    private static final int ALTO = 2;
    private static final int TURNOS = 3;


    private IEstadoPlazaCentral estado;

    public PlazaCentral(ArrayList<Posicion> posiciones) {
        this.vidaMax = VIDA;
        this.vida = 0;
        this.costo = COSTO;
        this.velocidadReparacion = VELOCIDAD_REPARACION;
        this.estado = new EstadoPlazaCentralNoConstruida(TURNOS);

        this.posiciones = posiciones;
    }

    public PlazaCentral() {
        this.vidaMax = VIDA;
        this.vida = 0;
        this.costo = COSTO;
        this.velocidadReparacion = VELOCIDAD_REPARACION;
        this.estado = new EstadoPlazaCentralNoConstruida(TURNOS);
    }


    public int getCosto() {
        return this.costo;
    }

    public Aldeano crearAldeano() {
        return this.estado.crearAldeano();
    }

    @Override
    public void reducirVida(int cant) {
        if (this.vida <= 0)
            throw new EdificioDestruidoException();
        this.vida -= cant;
        if (this.vida <= 0)
            this.estado = new EstadoPlazaCentralDestruida();
    }

    @Override
    public void reparar() {
        this.estado.reparar(this);
    }

    @Override
    public void construir() {
        this.estado.construir(this);
    }

    public void finalizarConstruccion() {
        this.vida = VIDA;
        this.estado = new EstadoPlazaCentralConstruida();
    }

    public void enReparacion() {
        this.estado = new EstadoPlazaCentralEnReparacion();
    }

    void construida() {
        this.estado = new EstadoPlazaCentralConstruida();
    }

    public void volverAEstadoOriginal() {
        this.estado.volverAEstadoOriginal(this);
    }

    void noConstruida(int turnosRestantes) {
        this.estado = new EstadoPlazaCentralNoConstruida(turnosRestantes);
    }

    void enConstruccion(int turnosRestantes) {
        this.estado = new EstadoPlazaCentralEnConstruccion(turnosRestantes);
    }
}
