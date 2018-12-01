package Controller;

import Modelo.Unidades.Aldeano;
import Modelo.Unidades.IUnidadMovible;
import View.MapaView;
import View.PiezaView;
import View.entidades.AldeanoView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;


public class MovimientoHandler implements EventHandler<DragEvent> {

    private IUnidadMovible unidadMovible;
    private PiezaView piezaView;
    private AldeanoView aldeanoView;

    public MovimientoHandler(AldeanoView aldeanoView, Aldeano aldeanoModelo){
        this.aldeanoView = aldeanoView;
        this.unidadMovible = aldeanoModelo;
    }


    @Override
    public void handle(DragEvent event) {
        MapaView mapaView = MapaView.getInstancia();

        this.aldeanoView.setPosicion(mapaView.getDestino());

        this.unidadMovible.mover(mapaView.getDestino());
    }
}
