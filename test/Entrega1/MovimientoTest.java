package Entrega1;

import Modelo.Exceptions.UnidadDesarmadaException;
import Modelo.Exceptions.UnidadEstaMontadaException;
import Modelo.Exceptions.UnidadEstaOcupadoException;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import Modelo.Unidades.ArmaDeAsedio;
import Modelo.Unidades.Arquero;
import Modelo.Unidades.Espadachin;
import org.junit.Assert;
import org.junit.Test;

public class MovimientoTest {
    //Pruebas aldeano


    @Test
    public void moverAldeanoUnaUnidadArribaExitosamente(){
        Posicion posicion = new Posicion(4,5);
        Aldeano aldeano = new Aldeano(posicion);
        Posicion destino = new Posicion(4,6);

        Assert.assertTrue(aldeano.estaEnPosicion(posicion));
        aldeano.mover(destino);
        Assert.assertTrue(aldeano.estaEnPosicion(destino));
    }

    @Test
    public void moverAldeanoUnaUnidadIzquierdaExitosamente(){
        Posicion posicion = new Posicion(4,5);
        Aldeano aldeano = new Aldeano(posicion);
        Posicion destino = new Posicion(3,5);

        Assert.assertTrue(aldeano.estaEnPosicion(posicion));
        aldeano.mover(destino);
        Assert.assertTrue(aldeano.estaEnPosicion(destino));
    }

    @Test
    public void moverAldeanoUnaUnidadDerechaExitosamente(){
        Posicion posicion = new Posicion(4,5);
        Aldeano aldeano = new Aldeano(posicion);
        Posicion destino = new Posicion(5,5);

        Assert.assertTrue(aldeano.estaEnPosicion(posicion));
        aldeano.mover(destino);
        Assert.assertTrue(aldeano.estaEnPosicion(destino));

    }

    @Test
    public void moverAldeanoUnaUnidadAbajoExitosamente(){
        Posicion posicion = new Posicion(4,5);
        Aldeano aldeano = new Aldeano(posicion);
        Posicion destino = new Posicion(4,4);

        Assert.assertTrue(aldeano.estaEnPosicion(posicion));
        aldeano.mover(destino);
        Assert.assertTrue(aldeano.estaEnPosicion(destino));

    }

    @Test
    public void moverAldeanoUnaUnidadAbajoIzquierdaExitosamente(){
        Posicion posicion = new Posicion(4,5);
        Aldeano aldeano = new Aldeano(posicion);
        Posicion destino = new Posicion(3,4);

        Assert.assertTrue(aldeano.estaEnPosicion(posicion));
        aldeano.mover(destino);
        Assert.assertTrue(aldeano.estaEnPosicion(destino));

    }

    @Test
    public void moverAldeanoUnaUnidadAbajoDerechaExitosamente(){
        Posicion posicion = new Posicion(4,5);
        Aldeano aldeano = new Aldeano(posicion);
        Posicion destino = new Posicion(5,4);

        Assert.assertTrue(aldeano.estaEnPosicion(posicion));
        aldeano.mover(destino);
        Assert.assertTrue(aldeano.estaEnPosicion(destino));

    }

    @Test
    public void moverAldeanoUnaUnidadArribaIzquierdaExitosamente(){
        Posicion posicion = new Posicion(4,5);
        Aldeano aldeano = new Aldeano(posicion);
        Posicion destino = new Posicion(3,6);

        Assert.assertTrue(aldeano.estaEnPosicion(posicion));
        aldeano.mover(destino);
        Assert.assertTrue(aldeano.estaEnPosicion(destino));

    }

    @Test
    public void moverAldeanoUnaUnidadaArribaDerechaExitosamente(){
        Posicion posicion = new Posicion(4,5);
        Aldeano aldeano = new Aldeano(posicion);
        Posicion destino = new Posicion(5,6);

        Assert.assertTrue(aldeano.estaEnPosicion(posicion));
        aldeano.mover(destino);
        Assert.assertTrue(aldeano.estaEnPosicion(destino));
    }
    @Test
    public void moverEnDosTurnosDistintos(){
        Posicion origen = new Posicion(1,1);
        Aldeano aldeano = new Aldeano(origen);
        Assert.assertTrue(aldeano.estaEnPosicion(origen));
        Posicion destino1 = new Posicion(1,2);
        aldeano.mover(destino1);
        Assert.assertTrue(aldeano.estaEnPosicion(destino1));
        Posicion destino2 = new Posicion(1,3);
        aldeano.desocupar();
        aldeano.mover(destino2);
        Assert.assertTrue(aldeano.estaEnPosicion(destino2));
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void moverAldeanoDosVecesConsecutivasLanzaUnidadEstaOcupadaException(){
        Posicion posicion = new Posicion(1,1);
        Aldeano aldeano = new Aldeano(posicion);
        Posicion destino1 = new Posicion(0,1);
        Posicion destino2 = new Posicion(1,1);

        Assert.assertTrue(aldeano.estaEnPosicion(posicion));
        aldeano.mover(destino1);
        aldeano.mover(destino2);
    }

    @Test
    public void moverAldeanoContinuaGenerandoOro(){
        Posicion posicion = new Posicion(1,1);
        Aldeano aldeano = new Aldeano(posicion);
        Assert.assertEquals(20, aldeano.generaOro());
        Posicion posicion2 = new Posicion(1,2);
        aldeano.mover(posicion2);
        Assert.assertEquals(20, aldeano.generaOro());
    }


    //Pruebas espadachin


    @Test
    public void moverEspadachinUnaUnidadArribaExitosamente(){
        Posicion posicion = new Posicion(4,5);
        Espadachin espadachin = new Espadachin(posicion);
        Posicion destino = new Posicion(4,6);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));
    }

    @Test
    public void moverEspadachinUnaUnidadIzquierdaExitosamente(){
        Posicion posicion = new Posicion(4,5);
        Espadachin espadachin = new Espadachin(posicion);
        Posicion destino = new Posicion(3,5);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));
    }



    @Test
    public void moverEspadachinUnaUnidadDerechaExitosamente(){
        Posicion posicion = new Posicion(4,5);
        Espadachin espadachin = new Espadachin(posicion);
        Posicion destino = new Posicion(5,5);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));

    }

    @Test
    public void moverEspadachinUnaUnidadAbajoExitosamente(){
        Posicion posicion = new Posicion(4,5);
        Espadachin espadachin = new Espadachin(posicion);
        Posicion destino = new Posicion(4,4);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));

    }

    @Test
    public void moverEspadachinUnaUnidadAbajoIzquierdaExitosamente(){
        Posicion posicion = new Posicion(4,5);
        Espadachin espadachin = new Espadachin(posicion);
        Posicion destino = new Posicion(3,4);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));

    }

    @Test
    public void moverEspadachinUnaUnidadAbajoDerechaExitosamente(){
        Posicion posicion = new Posicion(4,5);
        Espadachin espadachin = new Espadachin(posicion);
        Posicion destino = new Posicion(5,4);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));

    }

    @Test
    public void moverEspadachinUnaUnidadArribaIzquierdaExitosamente(){
        Posicion posicion = new Posicion(4,5);
        Espadachin espadachin = new Espadachin(posicion);
        Posicion destino = new Posicion(3,6);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));

    }

    @Test
    public void moverEspadachinUnaUnidadaArribaDerechaExitosamente(){
        Posicion posicion = new Posicion(4,5);
        Espadachin espadachin = new Espadachin(posicion);
        Posicion destino = new Posicion(5,6);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));
    }

    @Test
    public void moverEspadachinEnDosTurnosDistintos(){
        Posicion origen = new Posicion(1,1);
        Espadachin espadachin = new Espadachin(origen);
        Assert.assertTrue(espadachin.estaEnPosicion(origen));
        Posicion destino1 = new Posicion(1,2);
        espadachin.mover(destino1);
        Assert.assertTrue(espadachin.estaEnPosicion(destino1));
        Posicion destino2 = new Posicion(1,3);
        espadachin.desocupar();
        espadachin.mover(destino2);
        Assert.assertTrue(espadachin.estaEnPosicion(destino2));
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void moverEspadachinDosVecesConsecutivasFalla(){
        Posicion posicion = new Posicion(1,1);
        Espadachin espadachin = new Espadachin(posicion);
        Posicion destino1 = new Posicion(0,1);
        Posicion destino2 = new Posicion(1,1);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino1);
        espadachin.mover(destino2);
    }

    //Pruebas arquero


    @Test
    public void moverArqueroUnaUnidadArribaExitosamente(){
        Posicion posicion = new Posicion(4,5);
        Arquero arquero = new Arquero(posicion);
        Posicion destino = new Posicion(4,6);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));
    }

    @Test
    public void moverArqueroUnaUnidadIzquierdaExitosamente(){
        Posicion posicion = new Posicion(4,5);
        Arquero arquero = new Arquero(posicion);
        Posicion destino = new Posicion(3,5);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));
    }



    @Test
    public void moverArqueroUnaUnidadDerechaExitosamente(){
        Posicion posicion = new Posicion(4,5);
        Arquero arquero = new Arquero(posicion);
        Posicion destino = new Posicion(5,5);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));

    }

    @Test
    public void moverArqueroUnaUnidadAbajoExitosamente(){
        Posicion posicion = new Posicion(4,5);
        Arquero arquero = new Arquero(posicion);
        Posicion destino = new Posicion(4,4);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));

    }

    @Test
    public void moverArqueroUnaUnidadAbajoIzquierdaExitosamente(){
        Posicion posicion = new Posicion(4,5);
        Arquero arquero = new Arquero(posicion);
        Posicion destino = new Posicion(3,4);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));

    }

    @Test
    public void moverArqueroUnaUnidadAbajoDerechaExitosamente(){
        Posicion posicion = new Posicion(4,5);
        Arquero arquero = new Arquero(posicion);
        Posicion destino = new Posicion(5,4);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));

    }

    @Test
    public void moverArqueroUnaUnidadArribaIzquierdaExitosamente(){
        Posicion posicion = new Posicion(4,5);
        Arquero arquero = new Arquero(posicion);
        Posicion destino = new Posicion(3,6);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));

    }

    @Test
    public void moverArqueroUnaUnidadaArribaDerechaExitosamente(){
        Posicion posicion = new Posicion(4,5);
        Arquero arquero = new Arquero(posicion);
        Posicion destino = new Posicion(5,6);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));
    }

    @Test
    public void moverArqueroEnDosTurnosDistintos(){
        Posicion origen = new Posicion(1,1);
        Arquero arquero = new Arquero(origen);
        Assert.assertTrue(arquero.estaEnPosicion(origen));
        Posicion destino1 = new Posicion(1,2);
        arquero.mover(destino1);
        Assert.assertTrue(arquero.estaEnPosicion(destino1));
        Posicion destino2 = new Posicion(1,3);
        arquero.desocupar();
        arquero.mover(destino2);
        Assert.assertTrue(arquero.estaEnPosicion(destino2));
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void moverArqueroDosVecesConsecutivasLanzaUnidadEstaOcupadaException(){
        Posicion posicion = new Posicion(1,1);
        Arquero arquero = new Arquero(posicion);
        Posicion destino1 = new Posicion(0,1);
        Posicion destino2 = new Posicion(1,1);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino1);
        arquero.mover(destino2);
    }

    //Pruebas ArmaDeAsedio


    @Test
    public void moverArmaDeAsedioUnaUnidadArribaExitosamente() {
        Posicion posicion = new Posicion(4, 5);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(posicion);
        Posicion destino = new Posicion(4, 6);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));
    }

    @Test
    public void moverArmaDeAsedioUnaUnidadIzquierdaExitosamente() {
        Posicion posicion = new Posicion(4, 5);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(posicion);
        Posicion destino = new Posicion(3, 5);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));
    }

    @Test
    public void moverArmaDeAsedioUnaUnidadDerechaExitosamente() {
        Posicion posicion = new Posicion(4, 5);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(posicion);
        Posicion destino = new Posicion(5, 5);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));

    }

    @Test
    public void moverArmaDeAsedioUnaUnidadAbajoExitosamente() {
        Posicion posicion = new Posicion(4, 5);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(posicion);
        Posicion destino = new Posicion(4, 4);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));

    }

    @Test
    public void moverArmaDeAsedioUnaUnidadAbajoIzquierdaExitosamente() {
        Posicion posicion = new Posicion(4, 5);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(posicion);
        Posicion destino = new Posicion(3, 4);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));

    }

    @Test
    public void moverArmaDeAsedioUnaUnidadAbajoDerechaExitosamente() {
        Posicion posicion = new Posicion(4, 5);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(posicion);
        Posicion destino = new Posicion(5, 4);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));

    }

    @Test
    public void moverArmaDeAsedioUnaUnidadArribaIzquierdaExitosamente() {
        Posicion posicion = new Posicion(4, 5);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(posicion);
        Posicion destino = new Posicion(3, 6);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));

    }

    @Test
    public void moverArmaDeAsedioUnaUnidadaArribaDerechaExitosamente() {
        Posicion posicion = new Posicion(4, 5);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(posicion);
        Posicion destino = new Posicion(5, 6);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));
    }

    @Test
    public void moverArmaDeAsedioEnDosTurnosDistintos(){
        Posicion origen = new Posicion(1,1);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(origen);
        Assert.assertTrue(armaAsedio.estaEnPosicion(origen));
        Posicion destino1 = new Posicion(1,2);
        armaAsedio.mover(destino1);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino1));
        Posicion destino2 = new Posicion(1,3);
        armaAsedio.desocupar();
        armaAsedio.mover(destino2);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino2));
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void moverArmaDeAsedioDosVecesConsecutivasLanzaUnidadEstaOcupadaException() {
        Posicion posicion = new Posicion(1, 1);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(posicion);
        Posicion destino1 = new Posicion(0, 1);
        Posicion destino2 = new Posicion(1, 1);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino1);
        armaAsedio.mover(destino2);
    }

    @Test(expected = UnidadEstaMontadaException.class)
    public void moverArmaDeAsedioMontadaFalla() {
        Posicion origen = new Posicion(1, 1);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(origen);
        armaAsedio.montar();
        Posicion destino = new Posicion(1, 2);
        armaAsedio.desocupar();
        armaAsedio.mover(destino);
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void moverArmaDeAsedioMontadaEnMismoTurnoFalla() {
        Posicion origen = new Posicion(1, 1);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(origen);
        armaAsedio.montar();
        Posicion destino = new Posicion(1, 2);
        armaAsedio.mover(destino);
    }
    @Test(expected = UnidadEstaOcupadoException.class)
    public void montarArmaDeAsedioMontadaEnMismoTurnoFalla() {
        Posicion origen = new Posicion(1, 1);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(origen);
        armaAsedio.montar();
        armaAsedio.montar();
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void armaDeAsedioDesmontarYMoverEnUnMismoTurnoFalla() {
        Posicion origen = new Posicion(1, 1);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(origen);
        armaAsedio.montar();
        armaAsedio.desocupar();
        armaAsedio.desmontar();
        Posicion destino = new Posicion(1, 3);
        armaAsedio.mover(destino);
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void armaDeAsedioMontarYDesmontarEnMismoTurnoFalla() {
        Posicion origen = new Posicion(5, 5);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(origen);
        armaAsedio.montar();
        armaAsedio.desmontar();
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void armaDeAsedioDesmontarYMontarEnMismoTurnoFalla() {
        Posicion origen = new Posicion(5, 5);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(origen);
        armaAsedio.montar();
        armaAsedio.desocupar();
        armaAsedio.desmontar();
        armaAsedio.montar();
    }

    @Test(expected = UnidadEstaMontadaException.class)
    public void armaDeAsedioMontarYaMontadoFalla() {
        Posicion origen = new Posicion(5, 5);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(origen);
        armaAsedio.montar();
        armaAsedio.desocupar();
        armaAsedio.montar();
    }
    @Test(expected = UnidadDesarmadaException.class)
    public void armaDeAsedioDesmontarYaDesmontadoFalla() {
        Posicion origen = new Posicion(5, 5);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(origen);
        armaAsedio.desmontar();
        armaAsedio.desocupar();
        armaAsedio.desmontar();
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void armaAsedioDesmontarHabiendoMovidoFalla(){
        Posicion origen = new Posicion(5, 5);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(origen);
        Posicion destino = new Posicion(5,6);
        armaAsedio.mover(destino);
        armaAsedio.desmontar();
    }

}
