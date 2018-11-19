package Entrega2;

import Modelo.Edificios.Castillo;
import Modelo.Exceptions.EdificioDestruidoException;
import Modelo.Unidades.ArmaDeAsedio;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CastilloYUnidadesTest {

    private Castillo castillo;

    @Before
    public void setUp() throws Exception {
        castillo = new Castillo();
    }

    @Test
    public void creacionDeArmaDeAsedio() {
        ArmaDeAsedio armaDeAsedio = castillo.crearArmaDeAsedio();
        Assert.assertEquals(armaDeAsedio.getVida(), 150);
        Assert.assertEquals(armaDeAsedio.getCosto(),200);
    }

    @Test (expected = EdificioDestruidoException.class)
    public void crearArmaDeAsedioTrasDestruirCastillo() {
        castillo.reducirVida(1000);
        castillo.crearArmaDeAsedio();
    }

    @Test
    public void castilloCrearArmaAsedioExitosamente(){
        ArmaDeAsedio armaDeAsedio = castillo.crearArmaDeAsedio();
        Assert.assertNotNull(armaDeAsedio);
    }

    @Test
    public void castilloEnReparacionCreaArmaDeAsedio(){
        castillo.reducirVida(50);
        castillo.reparar();
        ArmaDeAsedio armaDeAsedio = castillo.crearArmaDeAsedio();
        Assert.assertNotNull(armaDeAsedio);
    }
}
