package Controller;

import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import View.entidades.AldeanoView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class ControladorAldeano implements EventHandler<MouseEvent>{

    private AldeanoView aldeanoView;
    private Aldeano aldeanoModelo;

    public ControladorAldeano(AldeanoView aldeanoView, Aldeano aldeanoModelo){
        this.aldeanoView = aldeanoView;
        this.aldeanoModelo = aldeanoModelo;

        ArrayList<Posicion> posiciones = new ArrayList<>();
        for(int i=4; i<6; i++){
            for(int j=0; j<6; j++) {
                Posicion posicion = new Posicion(i, j);
                posiciones.add(posicion);
            }
        }

        ContextMenu menu = new ContextMenu();
        MenuItem construirPlazaCentral = new MenuItem("Construir PlazaCentral");
        //construirPlazaCentral.setOnAction();

        MenuItem reparar = new MenuItem("Reparar");
        MenuItem mover = new MenuItem("Mover");
        menu.getItems().addAll(construirPlazaCentral, reparar, mover);

       // aldeanoView.agregarMenu(menu);
    }


    @Override
    public void handle(MouseEvent event) {
       // ContextMenu menu = this.aldeanoView.devolverMenu();
        //menu.show(aldeanoView, event.getScreenX(), event.getScreenY());
    }




}
