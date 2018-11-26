package Vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class CastilloView extends StackPane {

    private ImageView imagenCastillo;
    private static final int ALTURA_CASTILLO = 4;
    private static final int ANCHO_CASTILLO = 4;

    public CastilloView(int x, int y){

        setWidth(ANCHO_CASTILLO*MainView.TAMANIO_CASILLERO);
        setHeight(ALTURA_CASTILLO*MainView.TAMANIO_CASILLERO);

        relocate(x*MainView.TAMANIO_CASILLERO,y*MainView.TAMANIO_CASILLERO);

        Image newPic = new Image("castle.png");
        imagenCastillo = new ImageView(newPic);
        imagenCastillo.setFitHeight(ALTURA_CASTILLO*MainView.TAMANIO_CASILLERO);
        imagenCastillo.setFitWidth(ANCHO_CASTILLO*MainView.TAMANIO_CASILLERO);

        getChildren().addAll(imagenCastillo);

    }


}
