import org.junit.Test;
import org.junit.Assert;

public class AldeanoTest {
    //Pruebas base
    @Test
    public void crearAldeanoEnPosicionIndicada(){
        Aldeano aldeano = new Aldeano(5,7);
        Assert.assertEquals(true,aldeano.estaEnPos(5,7));
    }

    @Test
    public void crearAldeanoYVerificarVidaCorrespondiente(){
        Aldeano aldeano = new Aldeano(13,21);
        Assert.assertEquals(50,aldeano.getVida());
    }

    @Test
    public void crearAldeanoYVerificarCostoCorrespondiente(){
        Aldeano aldeano = new Aldeano(13,21);
        Assert.assertEquals(50,aldeano.getCosto());
    }

    //Pruebas Mov normales

    @Test
    public void moverAldeanoUnaUnidadArribaExitosamente(){
        Aldeano aldeano = new Aldeano(4,5);
        Assert.assertEquals(true,aldeano.estaEnPos(4,5));
        aldeano.moverHaciaArriba();
        Assert.assertEquals(true,aldeano.estaEnPos(4,6));
    }

    @Test
    public void moverAldeanoUnaUnidadIzquierdaExitosamente(){
        Aldeano aldeano = new Aldeano(2,4); //idem
        Assert.assertEquals(true,aldeano.estaEnPos(2,4));
        aldeano.moverHaciaIzquierda();
        Assert.assertEquals(true,aldeano.estaEnPos(1,4));
    }

    @Test
    public void moverAldeanoUnaUnidadDerechaExitosamente(){
        Aldeano aldeano = new Aldeano(23,15); //idem
        Assert.assertEquals(true,aldeano.estaEnPos(23,15));
        aldeano.moverHaciaDerecha();
        Assert.assertEquals(true,aldeano.estaEnPos(24,15));
    }

    @Test
    public void moverAldeanoUnaUnidadAbajoExitosamente(){
        Aldeano aldeano = new Aldeano(10,10); //idem
        Assert.assertEquals(true,aldeano.estaEnPos(10,10));
        aldeano.moverHaciaAbajo();
        Assert.assertEquals(true,aldeano.estaEnPos(10,9));
    }

    @Test
    public void moverAldeanoUnaUnidadAbajoIzquierdaExitosamente(){
        Aldeano aldeano = new Aldeano(15,15); //idem
        Assert.assertEquals(true,aldeano.estaEnPos(15,15));
        aldeano.moverHaciaAbajoIzquierda();
        Assert.assertEquals(true,aldeano.estaEnPos(14,14));
    }

    @Test
    public void moverAldeanoUnaUnidadAbajoDerechaExitosamente(){
        Aldeano aldeano = new Aldeano(10,8); //idem
        Assert.assertEquals(true,aldeano.estaEnPos(10,8));
        aldeano.moverHaciaAbajoDerecha();
        Assert.assertEquals(true,aldeano.estaEnPos(11,7));
    }

    @Test
    public void moverAldeanoUnaUnidadArribaIzquierdaExitosamente(){
        Aldeano aldeano = new Aldeano(19,42); //idem
        Assert.assertEquals(true,aldeano.estaEnPos(19,42));
        aldeano.moverHaciaArribaIzquierda();
        Assert.assertEquals(true,aldeano.estaEnPos(18,43));
    }

    @Test
    public void moverAldeanoUnaUnidadaArribaDerechaExitosamente(){
        Aldeano aldeano = new Aldeano(33,33); //idem
        Assert.assertEquals(true,aldeano.estaEnPos(33,33));
        aldeano.moverHaciaArribaDerecha();
        Assert.assertEquals(true,aldeano.estaEnPos(34,34));
    }

    //Pruebas mov unidad inexistente , hacer las comentadas cuando se sepa tamanio map

    @Test
    public void moverAldeanoUnaUnidadArribaInexistente(){
        Aldeano aldeano = new Aldeano(1,1);
        Assert.assertEquals(true,aldeano.estaEnPos(1,1));
        try{
            aldeano.moverHaciaArriba();
        }catch(Exception posicionInexistente){}
    }

    @Test
    public void moverAldeanoUnaUnidadAbajoInexistente(){
        Aldeano aldeano = new Aldeano(2,50);
        Assert.assertEquals(true,aldeano.estaEnPos(2,50));
        try{
            aldeano.moverHaciaArribaDerecha();
        }catch(Exception unidadInexistente){}
    }

    @Test
    public void moverAldeanoUnaUnidadDerechaInexistente(){
        Aldeano aldeano = new Aldeano(50,1);
        Assert.assertEquals(true,aldeano.estaEnPos(50,1));
        try{
            aldeano.moverHaciaArribaDerecha();
        }catch(Exception unidadInexistente){}

    }

    @Test
    public void moverAldeanoUnaUnidadAbajoDerechaInexistente(){
        Aldeano aldeano = new Aldeano(50,50);
            Assert.assertEquals(true,aldeano.estaEnPos(50,50));
            try{
                aldeano.moverHaciaArribaDerecha();
            }catch(Exception unidadInexistente){}
    }

    @Test
    public void moverAldeanoUnaUnidadAbajoIzquierdaInexistente(){
        Aldeano aldeano = new Aldeano(1,50);
        Assert.assertEquals(true,aldeano.estaEnPos(1,50));
        try{
            aldeano.moverHaciaArribaDerecha();
        }catch(Exception unidadInexistente){}
    }

    @Test
    public void moverAldeanoUnaUnidadIzquierdaInexistente(){
        Aldeano aldeano = new Aldeano(5,1);
        Assert.assertEquals(true,aldeano.estaEnPos(5,1));
        try{
            aldeano.moverHaciaIzquierda();
        }catch(Exception unidadInexistente){}
    }

    @Test
    public void moverAldeanoUnaUnidadArribaIzquierdaInexistente(){
        Aldeano aldeano = new Aldeano(1,2);
        Assert.assertEquals(true,aldeano.estaEnPos(1,2));
        try{
            aldeano.moverHaciaArribaIzquierda();
        }catch(Exception unidadInexistente){}
    }

    @Test
    public void moverAldeanoUnaUnidadArribaDerechaInexistente(){
        Aldeano aldeano = new Aldeano(24,1);
        Assert.assertEquals(true,aldeano.estaEnPos(24,1));
        try{
            aldeano.moverHaciaArribaDerecha();
        }catch(Exception unidadInexistente){}

    }

    //Mover mas de 1 vez falla en cada posicion

    @Test (expected = UnidadYaMovioException.class)
    public void moverAldeanoADerechaLuegoDeHaberMovidoLanzaExcepcion(){
        Aldeano aldeano = new Aldeano(1,1);
        Assert.assertEquals(true,aldeano.estaEnPos(1,1));
        aldeano.moverHaciaIzquierda();
        aldeano.moverHaciaDerecha();
    }

    @Test
    public void moverAldeanoAIzquierdaLuegoDeHaberMovidoLanzaExcepcion(){
        Aldeano aldeano = new Aldeano(3,3);
        Assert.assertEquals(true,aldeano.estaEnPos(3,3));
        aldeano.moverHaciaArriba();
        try{
            aldeano.moverHaciaIzquierda();
        }catch(Exception unidadYaMovio){}
    }

    @Test
    public void moverAldeanoArribaLuegoDeHaberMovidoLanzaExcepcion(){
        Aldeano aldeano = new Aldeano(28,30);
        Assert.assertEquals(true,aldeano.estaEnPos(28,30));
        aldeano.moverHaciaDerecha();
        try{
            aldeano.moverHaciaArriba();
        }catch(Exception unidadYaMovio){}
    }

    @Test
    public void moverAldeanoArribaIzquierdaLuegoDeHaberMovidoLanzaExcepcion(){
        Aldeano aldeano = new Aldeano(11,19);
        Assert.assertEquals(true,aldeano.estaEnPos(11,19));
        aldeano.moverHaciaArribaDerecha();
        try{
            aldeano.moverHaciaArribaIzquierda();
        }catch(Exception unidadYaMovio){}
    }

    @Test
    public void moverAldeanoArribaDerechaLuegoDeHaberMovidoLanzaExcepcion(){
        Aldeano aldeano = new Aldeano(3,3);
        Assert.assertEquals(true,aldeano.estaEnPos(3,3));
        aldeano.moverHaciaAbajoIzquierda();
        try{
            aldeano.moverHaciaArribaDerecha();
        }catch(Exception unidadYaMovio){}
    }

    @Test
    public void moverAldeanoAbajoLuegoDeHaberMovidoExcepcion(){
        Aldeano aldeano = new Aldeano(17,48);
        Assert.assertEquals(true,aldeano.estaEnPos(17,48));
        aldeano.moverHaciaArribaDerecha();
        try{
            aldeano.moverHaciaAbajo();
        }catch(Exception unidadYaMovio){}
    }

    @Test
    public void moverAldeanoAbajoIzquierdaLuegoDeHaberMovidoExcepcion(){
        Aldeano aldeano = new Aldeano(34,41);
        Assert.assertEquals(true,aldeano.estaEnPos(34,41));
        aldeano.moverHaciaAbajo();
        try{
            aldeano.moverHaciaAbajoIzquierda();
        }catch(Exception unidadYaMovio){}
    }

    @Test (expected = UnidadYaMovioException.class)
    public void moverAldeanoAbajoDerechaLuegoDeHaberMovidoException(){
        Aldeano aldeano = new Aldeano(10,3);
        Assert.assertEquals(true,aldeano.estaEnPos(10,3));
        aldeano.moverHaciaIzquierda();
        aldeano.moverHaciaAbajoDerecha();
    }

    /*Pruebas construccion

   @Test
    public void AldeanoConstruyeCuartelYSeVerificaQueExiste(){
        Aldeano aldeano = new Aldeano(2,3);
        Cuartel cuartel = aldeano.construirCuartel();
        Assert.assertNotNull(cuartel);
    }

    @Test
    public void AldeanoConstruyeCuartelYSeVerificaQueTieneVidaCorrespondiente(){
        Aldeano aldeano = new Aldeano(2,3);
        Cuartel cuartel = aldeano.construirCuartel();
        Assert.assertEquals(250, cuartel.getVida());
    }

    @Test
    public void AldeanoConstruyePlazaCentralYSeVerificaQueExiste(){
        Aldeano aldeano = new Aldeano(10,9);
        Cuartel cuartel = aldeano.construirCuartel();
        Assert.assertNotNull(cuartel);
    }

    @Test
    public void AldeanoConstruyePlazaCentralYSeVerificaQueTieneVidaCorrespondiente(){
        Aldeano aldeano = new Aldeano(2,3);
        PlazaCentral plaza = aldeano.construirPlazaCentral();
        Assert.assertEquals(450, plaza.getVida());
    }

    @Test
    public void AldeanoConstruyeCuartelYSeVerificaQueEsDuranteTurnoJugador(){      // Estos test serian de la clase Jugador porque oro es stat
        Aldeano aldeano = new Aldeano(6,20);

    }

    @Test
    public void AldeanoConstruyePlazaCentralYSeVerificaQueEsDuranteTurnoJugador(){
        Aldeano aldeano = new Aldeano(24,4);

    }

    @Test
    public void AldeanoConstruyeCuartelYSeVerificaQueoNoGeneraOro(){
        Aldeano aldeano = new Aldeano(35,30);

    }

    @Test
    public void AldeanoConstruyePlazaCentralYSeVerificaQueNoGeneraOro(){
        Aldeano aldeano = new Aldeano(45,11);

    }

    Pruebas de reparacion

    @Test
    public void AldeanoReparaCuartelConVidaCompletaException(){
        Aldeano aldeano = new Aldeano;
        Cuartel cuartel = new Cuartel;
        try{
            aldeano.repararCuartel(cuartel);
        }catch(Exception CuartelVidaCompleta){}
    }

    @Test
    public void AldeanoReparaPlazaCentralConVidaCompletaException(){
        Aldeano aldeano = new Aldeano;
        PlazaCentral plaza = new PlazaCentral;
        try{
            aldeano.repararPlazaCentral(plaza);
        }catch(Exception PlazaCentralVidaCompleta){}
    }

    @Test
    public void AldeanoReparaCuartelYSeVerificaSuEstado(){
        Aldeano aldeano = new Aldeano;
        aldeano.construirCuartel();
        cuartel.reducirVida(50);
        aldeano.repararCuartel(cuartel);
        Assert.assertEquals(Aldeano.estado(),'Ocupado');
    }

    @Test
    public void AldeanoReparaCuartelYSeVerificaAumentoVida(){
        Aldeano aldeano = new Aldeano;
        Cuartel cuartel = new Cuartel();
        Assert.assertEquals(250,cuartel.getVida());
        cuartel.reducirVida(50);
        Assert.assertEquals(200,cuartel.getVida());
        aldeano.repararCuartel(cuartel);
        Assert.assertEquals(250,cuartel.getVida());
    }

    @Test
    public void AldeanoFinalizaReparacionCuartelYGeneraOro(){ // Estos test serian de la clase Jugador porque oro es stat
        Aldeano aldeano = new Aldeano;

    }
        @Test
    public void AldeanoFinalizaReparacionPlazaCentralYGeneraOro(){
        Aldeano aldeano = new Aldeano;

    }


    @Test
    public void AldeanoReparaPlazaCentralYSeVerificaSuEstado(){
        Aldeano aldeano = new Aldeano;
        aldeano.construirPlazaCentral();
        Assert.assertEquals(Aldeano.estado(),'Ocupado');
    }

    @Test
    public void AldeanoReparaPlazaCentralYSeVerificaAumentoVida(){
        Aldeano aldeano = new Aldeano;
        PlazaCentral plaza = new PlazaCentral();
        Assert.assertEquals(250,plaza.getVida());
        plaza.reducirVida(50);
        Assert.assertEquals(200,plaza.getVida());
        aldeano.repararPlazaCentral(plaza);
        Assert.assertEquals(250,plaza.getVida());
    }
    */
}
