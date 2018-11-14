import com.sun.org.glassfish.external.probe.provider.annotations.Probe;

public class EstadoArmaDeAsedioArmado implements EstadoArmaDeAsedio {
    //Aca van los exceptions a los movimientos

    private int turnos_para_desmontar;

    public EstadoArmaDeAsedioArmado() {
        turnos_para_desmontar = 1;
    }


    /*@Override
    public void mover(Posicion destino, ArmaDeAsedio armaDeAsedio){
        turnos_para_desmontar -= 1;
        if (turnos_para_desmontar > -1)
            throw new ArmaDeAsedioArmadaNoPuedeMoverse();
        armaDeAsedio.desarmar();
    }*/ // Aca tenemos que pensarlo bien.

    @Override
    public void mover(Posicion destino, ArmaDeAsedio armaDeAsedio){

    }

}
