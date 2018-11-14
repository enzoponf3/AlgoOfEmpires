public abstract class Unidad implements UnidadMovil{

    protected int vida;
    protected int costo;
    protected Posicion posicion;
    protected int danio;

    public int getVida(){
        return vida;
    }

    public int getCosto(){
        return costo;
    }


    /*public boolean estaEnPos(int x, int y){
        Posicion posicionNueva= new Posicion(x,y);
        return this.posicion.igualA(posicionNueva);
    }*/

    public boolean estaEnPosicion(Posicion posicionAComparar){
        return this.posicion.igualA(posicionAComparar);
    }

    public void reducirVida(int danio){
        this.vida -= danio;
    }

    /*public void setPosicion(int x,int y){
        posicion = new Posicion (x,y);
    }*/

    public void setPosicion(Posicion posicion){
        this.posicion = posicion;
    } //Asi evitas romper el encapsulamiento al dar detalles de como es la posicion.

    public Posicion getPosicion(){
        return this.posicion;
    }

    public int getDanio(){
        return this.danio;
    }


    //Luego de testear ataque y baja vida agregar codigo
}
