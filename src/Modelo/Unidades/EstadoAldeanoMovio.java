package Modelo.Unidades;

public class EstadoAldeanoMovio extends EstadoAldeanoOcupado {

    public EstadoAldeanoMovio(Aldeano aldeano) {
        super(aldeano);
    }

    public int generaOro(){return 20;}
}
