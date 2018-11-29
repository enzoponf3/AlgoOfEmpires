package Controller;

import View.CasilleroView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControladorCasillero implements EventHandler<MouseEvent>{

    private CasilleroView casillero;

    public ControladorCasillero(CasilleroView casillero) {
        this.casillero = casillero;
    }

    @Override
    public void handle(MouseEvent event) {
        System.out.print("hola");

    }


}


