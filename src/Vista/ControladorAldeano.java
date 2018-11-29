package Vista;

import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.input.MouseEvent;

public class ControladorAldeano implements EventHandler<MouseEvent> {

    private AldeanoView aldeanoView;

    public ControladorAldeano(AldeanoView aldeanoView){
        this.aldeanoView = aldeanoView;
    }


    @Override
    public void handle(MouseEvent event) {
        ContextMenu menu = this.aldeanoView.devolverMenu();
        menu.show(aldeanoView, event.getScreenX(), event.getScreenY());
    }

}
