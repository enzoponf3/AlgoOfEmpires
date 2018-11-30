package View;

import View.Constantes;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;



public class PiezaView extends StackPane {

    private ImageView imagenPieza;

    public PiezaView(int x, int y){
        setWidth(Constantes.TAMANIO_CASILLERO);
        setHeight(Constantes.TAMANIO_CASILLERO);

        relocate(x* Constantes.TAMANIO_CASILLERO,y* Constantes.TAMANIO_CASILLERO);

        Image newPic = new Image("castle.png");
        imagenPieza = new ImageView(newPic);
        imagenPieza.setFitHeight(Constantes.TAMANIO_CASILLERO);
        imagenPieza.setFitWidth(Constantes.TAMANIO_CASILLERO);

        getChildren().addAll(imagenPieza);
    }



}
