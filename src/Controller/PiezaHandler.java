package Controller;

import View.JugadorView;
import View.MapaView;
import View.PiezaView;
import View.contenedores.ActualizarView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class PiezaHandler implements EventHandler<MouseEvent> {

    private PiezaView piezaView;

    public PiezaHandler(PiezaView piezaView){
        this.piezaView = piezaView;
    }

    @Override
    public void handle(MouseEvent event) {
        MapaView mapaView = MapaView.getInstancia();
        if(event.getButton() == MouseButton.PRIMARY ) {
            System.out.println("seleccionado pieza");
            if( esSuTurno() )
                mapaView.seleccionarPieza(this.piezaView);
        }
        if(event.getButton() == MouseButton.SECONDARY ) {

        }
    }

    public boolean esSuTurno(){
        ActualizarView actualizarView = ActualizarView.getInstancia();
        JugadorView jugadorViewActual = actualizarView.getJugadorViewActual();

        return jugadorViewActual.contienePieza(this.piezaView);
    }


}
