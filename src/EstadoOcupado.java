public class EstadoOcupado implements EstadoCasillero{

    @Override
    public boolean estaOcupado(){
        return true;
    }

    @Override
    public void colocarObjeto(Objeto objeto, Casillero casillero){
        throw new CasilleroOcupadoException();
    }

    @Override
    public void removerObjeto(Casillero casillero){
        //¿como borro la instancia?
        casillero.objeto = null;
        casillero.desocupar();
    }

}
