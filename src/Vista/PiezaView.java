package Vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;



public class PiezaView extends StackPane {

    private ImageView imagenPieza;

    public PiezaView(int x, int y){
        setWidth(Main2View.TAMANIO_CASILLERO);
        setHeight(Main2View.TAMANIO_CASILLERO);

        relocate(x* Main2View.TAMANIO_CASILLERO,y* Main2View.TAMANIO_CASILLERO);

        Image newPic = new Image("castle.png");
        imagenPieza = new ImageView(newPic);
        imagenPieza.setFitHeight(Main2View.TAMANIO_CASILLERO);
        imagenPieza.setFitWidth(Main2View.TAMANIO_CASILLERO);

        getChildren().addAll(imagenPieza);
    }



}
