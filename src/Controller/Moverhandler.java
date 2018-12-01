package Controller;

import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import View.Constantes;
import View.JugadorView;
import View.MapaView;
import View.contenedores.ActualizarView;
import View.entidades.AldeanoView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Moverhandler implements EventHandler<ActionEvent> {

    private Aldeano aldeanoModelo;
    private AldeanoView aldeanoView;

    public Moverhandler(Aldeano aldeanoModelo, AldeanoView aldeanoView){
        this.aldeanoModelo = aldeanoModelo;
        this.aldeanoView = aldeanoView;
    }

    @Override
    public void handle(ActionEvent event) {
        MapaView mapaView = MapaView.getInstancia();
        Posicion destino = mapaView.getDestino();

        double destinoX = destino.getHorizontal();
        System.out.println(destinoX);
        double destinoY = destino.getVertical();
        System.out.println(destinoY);

        ActualizarView actualizarView = ActualizarView.getInstancia();
        JugadorView jugadorViewActual = actualizarView.getJugadorViewActual();
        jugadorViewActual.mover(aldeanoModelo, destino);

        aldeanoView.relocate(destinoX* Constantes.TAMANIO_CASILLERO, destinoY*Constantes.TAMANIO_CASILLERO);
    }

}
