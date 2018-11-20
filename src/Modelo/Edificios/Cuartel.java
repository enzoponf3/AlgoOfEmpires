package Modelo.Edificios;

import Modelo.Exceptions.EdificioDestruidoException;
import Modelo.Posicion;
import Modelo.Unidades.Arquero;
import Modelo.Unidades.Espadachin;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Cuartel extends Edificio {

    private static final int VIDA = 250;
    private static final int COSTO = 50;
    private static final int VELOCIDAD_REPARACION = 50;
    private static final int ANCHO = 2;
    private static final int ALTO = 2;
    private static final int TURNOS_CONSTRUCCION = 3;

    private IEstadoCuartel estado;

    public Cuartel(ArrayList<Posicion> posiciones) {
        this.vidaMax = VIDA;
        this.vida = 0;
        this.costo = COSTO;
        this.velocidadReparacion = VELOCIDAD_REPARACION;
        this.estado = new EstadoCuartelNoConstruido(TURNOS_CONSTRUCCION);

        this.posiciones = posiciones;
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

    @Override
    public void reducirVida(int cant) {
        if (this.vida < 0)
            throw new EdificioDestruidoException();
        this.vida -= cant;
        if (this.vida <= 0) {
            this.vida -= cant; // Aseguro vida sea negativa
            this.estado = new EstadoCuartelDestruido();
        }
    }

    @Override
    public void reparar() {
        this.estado.reparar(this);
    }

    @Override
    public void construir() {
        this.estado.construir(this);
    }

    void enConstruccion(int turnosRestantes) {
        this.estado = new EstadoCuartelEnConstruccion(turnosRestantes);
    }

    void noConstruido(int turnosRestantes) {
        this.estado = new EstadoCuartelNoConstruido(turnosRestantes);
    }

    public void finalizarConstruccion() {
        this.vida = VIDA;
        this.estado = new EstadoCuartelConstruido();
    }

    void construido() {
        this.estado = new EstadoCuartelConstruido();
    }

    public void enReparacion() {
        this.estado = new EstadoCuartelEnReparacion();
    }

    public void volverAEstadoOriginal() {
        this.estado.volverAEstadoOriginal(this);
    }

}
