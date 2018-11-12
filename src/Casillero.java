
public class Casillero {

    private boolean ocupado; // Default value false

    public boolean estaOcupado() {
        return this.ocupado;
    }

    public void ocupar() {
        if (this.ocupado) throw new CasilleroOcupadoException();
        this.ocupado = true;
    }

    public void desocupar() {
        if (!this.ocupado) throw new CasilleroNoOcupadoException();
        this.ocupado = false;
    }
}
