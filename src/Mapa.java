public class Mapa {

    private int ancho;
    private int alto;
    private Casillero[][] casilleros;

    public Mapa(int ancho, int alto) {
        if (alto == 0 || ancho == 0)
            throw new MapaConDimensionesIncorrectasException();
        this.ancho = ancho;
        this.alto = alto;
        this.inicializarCasilleros(ancho,alto);
    }

    private void inicializarCasilleros(int ancho, int alto) {
        this.casilleros = new Casillero[ancho][alto];
        for (int i = 0; i < ancho; i++)
            for (int j = 0; j < alto; j++)
                this.casilleros[i][j] = new Casillero();
    }

    public int getAncho() {
        return this.ancho;
    }

    public int getAlto() {
        return this.alto;
    }

    protected int getCantidadCasillerosOcupados() {
        int cont = 0;
        for (Casillero[] filaCasilleros : this.casilleros)
            for (int i = 0; i < this.alto; i++)
                if (filaCasilleros[i].estaOcupado()) cont += 1;
        return cont;
    }

    private void comprobarPosicion(int posHorizontal, int posVertical) {
        if (posHorizontal >= this.ancho || posVertical >= this.alto)
            throw new PosicionFueraDelMapaException();
    }

    public void ocuparCasillero(int posHorizontal, int posVertical) {
        try {
            this.comprobarPosicion(posHorizontal,posVertical);
        } catch (PosicionFueraDelMapaException e) {
            throw e;
        }
        this.casilleros[posHorizontal][posVertical].ocupar();
    }

    public void desocuparCasillero(int posHorizontal, int posVertical) {
        try {
            this.comprobarPosicion(posHorizontal,posVertical);
        } catch (PosicionFueraDelMapaException e) {
            throw e;
        }
        this.casilleros[posHorizontal][posVertical].desocupar();
    }


}
