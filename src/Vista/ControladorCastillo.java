package Vista;


import Modelo.Edificios.Castillo;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;

public class ControladorCastillo implements EventHandler<MouseEvent> {

    private CastilloView castillo;

    public ControladorCastillo(CastilloView castillo){
        this.castillo = castillo;
    }


    @Override
    public void handle(MouseEvent event) {
        ContextMenu menu = castillo.devolverMenu();
        menu.show(castillo, event.getScreenX(), event.getScreenY());
    }


}
