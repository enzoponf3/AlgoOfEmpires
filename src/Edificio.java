import java.util.ArrayList;

public abstract class Edificio implements Objeto{

    protected int vida;
    protected int costo;
    protected int velocidadReparacion;
    protected int vidaMax;
    protected int ancho;
    protected int alto;
    protected ArrayList<Posicion> posiciones;

    public int getVida() {
        return this.vida;
    }

    public int getVelocidadReparacion() {
        return velocidadReparacion;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public ArrayList<Posicion> getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(ArrayList<Posicion> posiciones) {
        this.posiciones = posiciones;
    }

    public void reducirVida(int cant) {
        if (this.vida <= 0)
            throw new EdificioSinVidaExcepcion();
        this.vida -= cant;
    }

    public void reparar() {
        if (this.vida == this.vidaMax)
            throw new EdificioConVidaAlMaximoException();
        if ((this.vida + this.velocidadReparacion) >= this.vidaMax)
            this.vida = this.vidaMax;
        else
            this.vida += this.velocidadReparacion;
    }

    public void construir(){}

}