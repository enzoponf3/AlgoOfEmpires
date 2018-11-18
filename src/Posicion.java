public class Posicion {

    private int horizontal;
    private int vertical;

    Posicion(int horizontal,int vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    public boolean igualA(Posicion unaposicion){
        return ( (this.horizontal == unaposicion.horizontal) && (this.vertical == unaposicion.vertical) );
    }

    public boolean estaDentroDelMapa(int limite1, int limite2) {
        return ( (this.horizontal >= 0 ) && (this.horizontal < limite1) && (this.vertical >= 0) && (this.vertical < limite2) );
    } // Decidir si parto de 0x0 o de 1x1. Y si hago el pasaje aca adentro.

    public int getHorizontal(){
        return this.horizontal;
    }

    public int getVertical(){
        return this.vertical;
    }

    public Posicion diferenciaEntrePos(Posicion posicion){
        int horizontalNueva = this.horizontal - posicion.horizontal;
        int verticalNueva = this.vertical - posicion.vertical;
        return new Posicion(horizontalNueva,verticalNueva);
    }
}
