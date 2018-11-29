import Modelo.Exceptions.CasilleroDesocupadoException;
import Modelo.Exceptions.CasilleroOcupadoException;
import Modelo.Casillero;
import Modelo.IEntidad;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import org.junit.Assert;
import org.junit.Test;

public class CasilleroTest {

    @Test
    public void compararCasillerosIgualesCorrectamente(){
        Posicion posicion = new Posicion(5, 2);
        Casillero casillero  = new Casillero(posicion);

    }

    @Test
    public void colocarUnObjetoEnUnCasilleroVacio(){
        Posicion posicion = new Posicion(5, 2);
        Casillero casillero  = new Casillero(posicion);
        IEntidad IEntidad = new Aldeano(posicion);

        casillero.colocarObjeto(IEntidad);

        Assert.assertTrue( casillero.estaOcupado() );
    }

    @Test (expected = CasilleroOcupadoException.class)
    public void colocarUnObjetoEnUnCasilleroOcupadoLanzaCasilleroOcupadoException(){
        Posicion posicion = new Posicion(5, 2);
        Casillero casillero = new Casillero(posicion);
        IEntidad unIEntidad = new Aldeano(posicion);
        IEntidad otroIEntidad = new Aldeano(posicion);

        casillero.colocarObjeto(unIEntidad);
        Assert.assertTrue( casillero.estaOcupado() );
        casillero.colocarObjeto(otroIEntidad);
    }

    @Test
    public void colocarUnObjetoEnUnCasilleroYLuegoDesocuparloDevuelveElMismoObjeto(){
        Posicion posicion = new Posicion(5, 2);
        Casillero casillero = new Casillero(posicion);
        IEntidad unIEntidad = new Aldeano(posicion);
        IEntidad otroIEntidad;

        casillero.colocarObjeto(unIEntidad);
        Assert.assertTrue( casillero.estaOcupado() );
        otroIEntidad = (IEntidad) casillero.removerObjeto();
        Assert.assertFalse( casillero.estaOcupado() );
    }

    @Test
    public void colocarUnObjetoEnUnCasilleroDesocuparloYColocarOtro(){
        Posicion posicion = new Posicion(5, 2);
        Casillero casillero = new Casillero(posicion);
        IEntidad unIEntidad = new Aldeano(posicion);
        IEntidad otroIEntidad = new Aldeano(posicion);

        casillero.colocarObjeto(unIEntidad);
        Assert.assertTrue( casillero.estaOcupado() );
        casillero.removerObjeto();
        Assert.assertFalse( casillero.estaOcupado() );

        casillero.colocarObjeto(otroIEntidad);
        Assert.assertTrue( casillero.estaOcupado() );
    }

    @Test (expected = CasilleroDesocupadoException.class)
    public void removerObjetoDeCasilleroVacioLanzaCasilleroDesocupadoException(){
        Posicion posicion = new Posicion(5, 2);
        Casillero casillero = new Casillero(posicion);

        casillero.removerObjeto();
    }

    @Test
    public void colocarUnObjetoEnUnCasilleroVacioYRecuperarElObjeto(){
        Posicion posicion = new Posicion(5, 2);
        Casillero casillero  = new Casillero(posicion);
        IEntidad IEntidad = new Aldeano(posicion);

        casillero.colocarObjeto(IEntidad);
        IEntidad entidad = (IEntidad) casillero.obtenerObjeto();
        Assert.assertEquals(entidad,IEntidad);
    }

    @Test (expected = CasilleroDesocupadoException.class)
    public void obtenerObjetoCasilleroVacio(){
        Posicion posicion = new Posicion(5, 2);
        Casillero casillero  = new Casillero(posicion);
        IEntidad entidad = (IEntidad) casillero.obtenerObjeto();
    }

}
