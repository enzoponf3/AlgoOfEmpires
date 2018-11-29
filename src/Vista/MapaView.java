package Vista;

import Modelo.Mapa;
import View.CasilleroView;
import javafx.scene.Group;
import javafx.scene.layout.Pane;

public class MapaView extends Pane {

    private Mapa mapaModelo;
    private Group casilleros;

    public MapaView(Mapa mapa){
        casilleros = new Group();
        this.mapaModelo = mapa;

        this.setPrefSize(Main2View.ANCHO* Main2View.TAMANIO_CASILLERO, Main2View.ALTO* Main2View.TAMANIO_CASILLERO);

        //creo los casilleros para poner en el Pane
        for(int y = 0; y< Main2View.ALTO ; y++){
            for(int x = 0; x< Main2View.ANCHO; x++){
                CasilleroView unCasillero = new CasilleroView(x,y);
                casilleros.getChildren().add(unCasillero);
            }
        }

        getChildren().addAll(casilleros);

    }


}
