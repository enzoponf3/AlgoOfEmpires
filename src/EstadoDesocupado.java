public class EstadoDesocupado implements EstadoCasillero {

    @Override
    public boolean estaOcupado(){
        return false;
    }

    @Override
    public void colocarObjeto(Objeto objeto, Casillero casillero){
        casillero.objeto = objeto;
        casillero.ocupar();
    }

    @Override
    public void removerObjeto(Casillero casillero){
        throw new CasilleroDesocupadoException();
    }

}
