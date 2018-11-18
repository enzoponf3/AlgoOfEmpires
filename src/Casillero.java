public class Casillero{

    private Posicion posicion;
    protected Objeto objeto;
    private EstadoCasillero estado;

    Casillero(Posicion posicion){
        this.posicion = posicion;
        this.estado = new EstadoDesocupado();
    }

    public Posicion getPosicion(){
        return this.posicion;
    }


    public void colocarObjeto(Objeto objeto) {

        try{
            this.estado.colocarObjeto(objeto, this);
        } catch (CasilleroOcupadoException e) {
            throw e;
        }
    }

    public Objeto removerObjeto(){
        try {
            Objeto objeto = this.objeto;
            this.estado.removerObjeto(this);
            return objeto;
        } catch (CasilleroDesocupadoException e){
            throw e;
        }
    }


    public boolean estaOcupado(){
        return this.estado.estaOcupado();
    }//Solo para la prueba, no se usa

    public void ocupar(){
        this.estado = new EstadoOcupado();
    }

    public void desocupar(){
        this.estado = new EstadoDesocupado();
    }

    public boolean esIgualA(Casillero casillero){
        return this.posicion.igualA(casillero.posicion);
    }

    public boolean tienePosicion(Posicion posicion){
        return this.posicion.igualA(posicion);
    }

}
