public class Posicion {

    private int horizontal;
    private int vertical;



    Posicion(int horizontal,int vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    public int getCoordenadaHorizontal(){
        return this.horizontal;
    }

    public int getCoordenadaVertical(){
        return this.vertical;
    }


    public boolean compararPosiciones(Posicion unaposicion){
        return ( (this.horizontal == unaposicion.horizontal) && (this.vertical == unaposicion.vertical) );
    } //Aca estoy rompiendo el encapsulamiento? CAMBIAR NOMBRE; ES BOOL

    public boolean estaDentroDelMapa(int limite1, int limite2) {
        return ( (this.horizontal >= 0 ) && (this.horizontal < limite1) && (this.vertical >= 0) && (this.vertical < limite2) );
    } // Decidir si parto de 0x0 o de 1x1. Y si hago el pasaje aca adentro.

    public void incrementarCoordenadaHorizontal() {
        //Le tiene que pedir lo slimites a la fahcada

        this.horizontal += 1;
    }

    public void decrementarCoordenadaHorizontal() {
        this.horizontal -= 1;
    }

    public void incrementarCoordenadavertical() {
        this.vertical += 1;
    }

    public void decrementarCoordenadaVertical() {
        this.vertical -= 1;
    }

    public String formatearAString(){
        String posicionString = this.horizontal + "," + this.vertical;
        return posicionString;
    }
}
