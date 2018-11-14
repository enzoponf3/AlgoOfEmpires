public abstract class Unidad implements UnidadMovil{

    protected int vida;
    protected int costo;
    protected Posicion posicion;

    public int getVida(){
        return vida;
    }

    public int getCosto(){
        return costo;
    }

    public boolean estaEnPosicion(Posicion posicionAComparar){
        return this.posicion.igualA(posicionAComparar);
    }

    public void setPosicion(Posicion posicion){
        this.posicion = posicion;
    }

    public Posicion getPosicion(){
        return this.posicion;
    }
}
