public class Movimiento {

    public int moverHaciaArriba(int vertical) {
        return vertical + 1;
    }

    public int moverHaciaAbajo(int vertical) {
        vertical = vertical - 1;
        return vertical;
    }

    public int moverHaciaIzquierda(int horizontal) {
        horizontal = horizontal - 1;
        return horizontal;
    }

    public int moverHaciaDerecha(int horizontal) {
        horizontal = horizontal + 1;
        return horizontal;
    }
}

