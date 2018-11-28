package Vista;

import Modelo.Edificios.Castillo;
import Modelo.Mapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControladorArmaDeAsedio implements EventHandler<ActionEvent> {

    private Castillo castillo;

    public ControladorArmaDeAsedio(Castillo castillo){
        this.castillo = castillo;
    }


    @Override
    public void handle(ActionEvent event) {
        System.out.print("ArmaDeAsedio");

    }
}
