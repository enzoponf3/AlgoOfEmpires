package Controller;

import Modelo.Exceptions.CasilleroDesocupadoException;
import Modelo.Exceptions.UnidadEstaOcupadoException;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import View.Constantes;
import View.JugadorView;
import View.MapaView;
import View.contenedores.ActualizarView;
import View.entidades.AldeanoView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

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
        double destinoY = destino.getVertical();

        ActualizarView actualizarView = ActualizarView.getInstancia();
        JugadorView jugadorViewActual = actualizarView.getJugadorViewActual();

        if(!jugadorViewActual.contienePieza(aldeanoView)){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setContentText("No es tuyo bobo");
            alerta.show();
        }else{
            if(jugadorViewActual.mover(aldeanoModelo, destino)) {
                aldeanoView.relocate(destinoX * Constantes.TAMANIO_CASILLERO, destinoY * Constantes.TAMANIO_CASILLERO);
                System.out.println(destinoX);
                System.out.println(destinoY);
            }else{
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText(null);
                alerta.setContentText("Ya se movio bobo");
                alerta.show();
            }
        }

    }

}
