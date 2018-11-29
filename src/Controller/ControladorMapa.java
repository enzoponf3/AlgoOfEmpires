package Controller;

import Modelo.Mapa;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.input.MouseEvent;

public class ControladorMapa implements EventHandler<MouseEvent> {

    private Mapa mapa;

    public ControladorMapa(Mapa mapa){
        this.mapa = mapa;
    }

    public Mapa getMapa(){
        return this.mapa;
    }

    @Override
    public void handle(MouseEvent evento) {

    }
}
