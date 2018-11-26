package Vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;



public class PiezaView extends StackPane {

    private ImageView imagenPieza;

    public PiezaView(int x, int y){
        setWidth(MainView.TAMANIO_CASILLERO);
        setHeight(MainView.TAMANIO_CASILLERO);

        relocate(x*MainView.TAMANIO_CASILLERO,y*MainView.TAMANIO_CASILLERO);

        Image newPic = new Image("castle.png");
        imagenPieza = new ImageView(newPic);
        imagenPieza.setFitHeight(MainView.TAMANIO_CASILLERO);
        imagenPieza.setFitWidth(MainView.TAMANIO_CASILLERO);

        getChildren().addAll(imagenPieza);
    }

}
