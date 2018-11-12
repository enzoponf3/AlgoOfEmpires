public class Posicion {

    protected int horizontal;
    protected int vertical;


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
    }

    public boolean estaDentroDelMapa(int limite1, int limite2) {
        return ( (this.horizontal > 0 ) && (this.horizontal < limite1) && (this.vertical > 0) && (this.vertical < limite2) );
    }

    public void aumentarHorizontal(){
        this.horizontal +=1;
    }
    public void aumentarVertical(){
        this.vertical +=1;
    }
    public void disminuirHorizontal(){
        this.horizontal-=1;
    }
    public void disminuirVertical(){
        this.vertical-=1;
    }
}
