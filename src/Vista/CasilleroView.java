package Vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


public class CasilleroView extends StackPane {

    private PiezaView pieza;
    private ImageView laImagen;

    public PiezaView getPieza(){
        return this.pieza;
    }

    public void setPieza(PiezaView pieza){
        this.pieza = pieza;
    }

    public CasilleroView(int x, int y){
        setWidth(Main2View.TAMANIO_CASILLERO);
        setHeight(Main2View.TAMANIO_CASILLERO);

        relocate(x* Main2View.TAMANIO_CASILLERO,y* Main2View.TAMANIO_CASILLERO);

        Image newPic = new Image("aoeGrass.jpeg");
        laImagen = new ImageView(newPic);
        laImagen.setFitHeight(Main2View.TAMANIO_CASILLERO);
        laImagen.setFitWidth(Main2View.TAMANIO_CASILLERO);


        this.setOnMouseClicked(new ControladorCasillero(this));

        getChildren().addAll(laImagen);
    }


}
