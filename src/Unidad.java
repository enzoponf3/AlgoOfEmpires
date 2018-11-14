public abstract class Unidad implements UnidadMovil{

    protected int vida;
    protected int costo;
    protected Posicion posicion;
    protected int danio;
    protected Movimiento movimiento;

    public int getVida(){
        return vida;
    }

    public int getCosto(){
        return costo;
    }


    public boolean estaEnPos(int x, int y){
        Posicion posicionNueva= new Posicion(x,y);
        return this.posicion.igualA(posicionNueva);
    }

    public void reducirVida(int danio){
        this.vida -= danio;
    }

    public void setPosicion(int x,int y){
        posicion = new Posicion (x,y);
    }

    public Posicion getPosicion(){
        return this.posicion;
    }

    public int getDanio(){
        return this.danio;
    }

    public void ocuparse(){}

    public void desocuparse(){}

    //Luego de testear ataque y baja vida agregar codigo
}
