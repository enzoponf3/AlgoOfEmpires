package Entrega1;

import Modelo.Edificios.Cuartel;
import Modelo.Edificios.PlazaCentral;
import Modelo.Exceptions.UnidadNoPuedeConstruirException;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ConstruirTest {

    @Test
    public void AldeanoConstruyeCuartelYSeVerificaQueExiste(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(2,2);
        Posicion posicion4 = new Posicion(2,3);
        Posicion posicionAlde = new Posicion(1,1);
        ArrayList<Posicion> posicions =new ArrayList<>();
        posicions.add(posicion1);
        posicions.add(posicion2);
        posicions.add(posicion3);
        posicions.add(posicion4);
        aldeano.setPosicion(posicionAlde);
        Cuartel cuartel = aldeano.construirCuartel(posicions);
        Assert.assertNotNull(cuartel);
    }

    @Test
    public void AldeanoConstruyeCuartelYSeVerificaQueTieneVidaCorrespondiente(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(2,2);
        Posicion posicion4 = new Posicion(2,3);
        Posicion posicionAlde = new Posicion(1,1);
        ArrayList<Posicion> posicions =new ArrayList<>();
        posicions.add(posicion1);
        posicions.add(posicion2);
        posicions.add(posicion3);
        posicions.add(posicion4);
        aldeano.setPosicion(posicionAlde);
        Cuartel cuartel = aldeano.construirCuartel(posicions);
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        aldeano.continuarConstruccionCuartel(cuartel);
        cuartel.volverAEstadoOriginal();
        Assert.assertEquals(250, cuartel.getVida());
    }

    @Test
    public void AldeanoConstruyePlazaCentralYSeVerificaQueExiste(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(2,2);
        Posicion posicion4 = new Posicion(2,3);
        Posicion posicionAlde = new Posicion(1,1);
        ArrayList<Posicion> posicions =new ArrayList<>();
        posicions.add(posicion1);
        posicions.add(posicion2);
        posicions.add(posicion3);
        posicions.add(posicion4);
        aldeano.setPosicion(posicionAlde);
        PlazaCentral plaza = aldeano.construirPlazaCentral(posicions);
        Assert.assertNotNull(plaza);
    }

    @Test
    public void AldeanoConstruyePlazaCentralYSeVerificaQueTieneVidaCorrespondiente(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(2,2);
        Posicion posicion4 = new Posicion(2,3);
        Posicion posicionAlde = new Posicion(1,1);
        ArrayList<Posicion> posicions =new ArrayList<>();
        posicions.add(posicion1);
        posicions.add(posicion2);
        posicions.add(posicion3);
        posicions.add(posicion4);
        aldeano.setPosicion(posicionAlde);
        PlazaCentral plaza = aldeano.construirPlazaCentral(posicions);
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        plaza.volverAEstadoOriginal();
        Assert.assertEquals(450, plaza.getVida());
    }

    @Test(expected = UnidadNoPuedeConstruirException.class)
    public void AldeanoConstruyeCuartelYSeVerificaQueAldeanoEstaOcupado(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(2,2);
        Posicion posicion4 = new Posicion(2,3);
        Posicion posicionAlde = new Posicion(1,1);
        ArrayList<Posicion> posicions =new ArrayList<>();
        posicions.add(posicion1);
        posicions.add(posicion2);
        posicions.add(posicion3);
        posicions.add(posicion4);
        aldeano.setPosicion(posicionAlde);
        aldeano.construirCuartel(posicions);
        aldeano.construirPlazaCentral(posicions);
    }


    @Test
    public void AldeanoConstruyeCuartelYSeVerificaQueoNoGeneraOro(){
        Aldeano aldeano = new Aldeano();
        Assert.assertEquals(20,aldeano.generaOro());
        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(2,2);
        Posicion posicion4 = new Posicion(2,3);
        Posicion posicionAlde = new Posicion(1,1);
        ArrayList<Posicion> posicions =new ArrayList<>();
        posicions.add(posicion1);
        posicions.add(posicion2);
        posicions.add(posicion3);
        posicions.add(posicion4);
        aldeano.setPosicion(posicionAlde);
        aldeano.construirCuartel(posicions);
        Assert.assertEquals(0,aldeano.generaOro());
    }

    @Test
    public void AldeanoConstruyePlazaCentralYSeVerificaQueNoGeneraOro(){
        Aldeano aldeano = new Aldeano();
        Assert.assertEquals(20,aldeano.generaOro());
        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(2,2);
        Posicion posicion4 = new Posicion(2,3);
        Posicion posicionAlde = new Posicion(1,1);
        ArrayList<Posicion> posicions =new ArrayList<>();
        posicions.add(posicion1);
        posicions.add(posicion2);
        posicions.add(posicion3);
        posicions.add(posicion4);
        aldeano.setPosicion(posicionAlde);
        aldeano.construirPlazaCentral(posicions);
        Assert.assertEquals(0,aldeano.generaOro());
    }


    @Test (expected = UnidadNoPuedeConstruirException.class)
    public void aldeanoConstruirPlazaCentralDosVecesEnMismoTurnoFalla(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(2,2);
        Posicion posicion4 = new Posicion(2,3);
        Posicion posicionAlde = new Posicion(1,1);
        ArrayList<Posicion> posicions =new ArrayList<>();
        posicions.add(posicion1);
        posicions.add(posicion2);
        posicions.add(posicion3);
        posicions.add(posicion4);
        aldeano.setPosicion(posicionAlde);
        aldeano.construirPlazaCentral(posicions);
        aldeano.construirPlazaCentral(posicions);
    }

    @Test (expected = UnidadNoPuedeConstruirException.class)
    public void aldeanoConstruirCuartellDosVecesEnMismoTurnoFalla(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(2,2);
        Posicion posicion4 = new Posicion(2,3);
        Posicion posicionAlde = new Posicion(1,1);
        ArrayList<Posicion> posicions =new ArrayList<>();
        posicions.add(posicion1);
        posicions.add(posicion2);
        posicions.add(posicion3);
        posicions.add(posicion4);
        aldeano.setPosicion(posicionAlde);
        aldeano.construirCuartel(posicions);
        aldeano.construirCuartel(posicions);
    }

    @Test (expected = UnidadNoPuedeConstruirException.class)
    public void aldeanoContinuarConstruccionPlazaCentralEnMismoTurnoFalla(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(2,2);
        Posicion posicion4 = new Posicion(2,3);
        Posicion posicionAlde = new Posicion(1,1);
        ArrayList<Posicion> posicions =new ArrayList<>();
        posicions.add(posicion1);
        posicions.add(posicion2);
        posicions.add(posicion3);
        posicions.add(posicion4);
        aldeano.setPosicion(posicionAlde);
        PlazaCentral plaza = aldeano.construirPlazaCentral(posicions);
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.continuarConstruccionPlazaCentral(plaza);
    }

    @Test (expected = UnidadNoPuedeConstruirException.class)
    public void aldeanoContinuarConstruccionCuartelEnMismoTurnoFalla(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(2,2);
        Posicion posicion4 = new Posicion(2,3);
        Posicion posicionAlde = new Posicion(1,1);
        ArrayList<Posicion> posicions =new ArrayList<>();
        posicions.add(posicion1);
        posicions.add(posicion2);
        posicions.add(posicion3);
        posicions.add(posicion4);
        aldeano.setPosicion(posicionAlde);
        Cuartel cuartel = aldeano.construirCuartel(posicions);
        aldeano.continuarConstruccionCuartel(cuartel);
    }

}
