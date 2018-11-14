import org.junit.Assert;
import org.junit.Test;

public class CasilleroTest {


    @Test
    public void ColocarUnObjetoEnUnCasilleroVacio(){
        Posicion posicion = new Posicion(5, 2);
        Casillero casillero  = new Casillero(posicion);
        Objeto objeto = new Aldeano();

        casillero.colocarObjeto(objeto);

        Assert.assertTrue( casillero.estaOcupado() );
    }

    @Test (expected = CasilleroOcupadoException.class)
    public void ColocarUnObjetoEnUnCasilleroOcupadoLanzaCasilleroOcupadoException(){
        Posicion posicion = new Posicion(5, 2);
        Casillero casillero = new Casillero(posicion);
        Objeto unObjeto = new Aldeano();
        Objeto otroObjeto = new Aldeano();

        casillero.colocarObjeto(unObjeto);
        Assert.assertTrue( casillero.estaOcupado() );
        casillero.colocarObjeto(otroObjeto);
    }

    @Test
    public void ColocarUnObjetoEnUnCasilleroYLuegoDesocuparloDevuelveElMismoObjeto(){
        Posicion posicion = new Posicion(5, 2);
        Casillero casillero = new Casillero(posicion);
        Objeto unObjeto = new Aldeano();
        Objeto otroObjeto;

        casillero.colocarObjeto(unObjeto);
        Assert.assertTrue( casillero.estaOcupado() );
        otroObjeto = casillero.removerObjeto();
        Assert.assertFalse( casillero.estaOcupado() );
    }

    @Test
    public void ColocarUnObjetoEnUnCasilleroDesocuparloYColocarOtro(){
        Posicion posicion = new Posicion(5, 2);
        Casillero casillero = new Casillero(posicion);
        Objeto unObjeto = new Aldeano();
        Objeto otroObjeto = new Aldeano();

        casillero.colocarObjeto(unObjeto);
        Assert.assertTrue( casillero.estaOcupado() );
        casillero.removerObjeto();
        Assert.assertFalse( casillero.estaOcupado() );

        casillero.colocarObjeto(otroObjeto);
        Assert.assertTrue( casillero.estaOcupado() );
    }

    @Test (expected = CasilleroDesocupadoException.class)
    public void RemoverObjetoDeCasilleroVacioLanzaCasilleroDesocupadoException(){
        Posicion posicion = new Posicion(5, 2);
        Casillero casillero = new Casillero(posicion);

        casillero.removerObjeto();
    }

}
