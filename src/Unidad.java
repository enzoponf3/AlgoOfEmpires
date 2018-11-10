public abstract class Unidad {
    protected int vida;
    protected int costo;
    protected Posicion posicion;
    protected String estado;

    public Unidad(int x, int y){
        posicion = new Posicion(x,y);
    }

    public int getVida(){
        return vida;
    }

    public int getCosto(){
        return costo;
    }

    public void moverHaciaArriba(){

        posicion.moverHaciaArriba();
    }
    public void moverHaciaAbajo(){
        posicion.moverHaciaAbajo();
    }
    public void moverHaciaIzquierda(){
        posicion.moverHaciaIzquierda();
        estado = "Ocupado";
    }
    public void moverHaciaDerecha(){
        if(estado.equals("Ocupado"))
            throw new UnidadYaMovioException();
        posicion.moverHaciaDerecha();
    }
    public void moverHaciaAbajoIzquierda(){
        posicion.moverHaciaAbajoIzquierda();
    }
    public void moverHaciaAbajoDerecha(){
        posicion.moverHaciaAbajoDerecha();
    }
    public void moverHaciaArribaIzquierda(){
        posicion.moverHaciaArribaIzquierda();
    }
    public void moverHaciaArribaDerecha(){
        posicion.moverHaciaArribaDerecha();
    }

    public boolean estaEnPos(int x, int y){
        return posicion.estaEnPos(x,y);
    }

    //Luego de testear ataque y baja vida agregar codigo
}
