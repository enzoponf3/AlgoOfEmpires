package Controller;

import Modelo.Mapa;
import View.CasilleroView;
import View.MapaView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class CasilleroHandler implements EventHandler<MouseEvent> {

    private CasilleroView casilleroView;

    public CasilleroHandler(CasilleroView casilleroView){
        this.casilleroView = casilleroView;
    }

    @Override
    public void handle(MouseEvent event) {
        MapaView mapaView = MapaView.getInstancia();
        mapaView.seleccionarCasillero(this.casilleroView);
    }

}
