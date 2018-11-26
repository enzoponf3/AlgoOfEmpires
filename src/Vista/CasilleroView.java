package Vista;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static javafx.scene.layout.BackgroundRepeat.NO_REPEAT;


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
        setWidth(MainView.TAMANIO_CASILLERO);
        setHeight(MainView.TAMANIO_CASILLERO);

        relocate(x*MainView.TAMANIO_CASILLERO,y*MainView.TAMANIO_CASILLERO);

        Image newPic = new Image("aoeGrass.jpeg");
        laImagen = new ImageView(newPic);
        laImagen.setFitHeight(MainView.TAMANIO_CASILLERO);
        laImagen.setFitWidth(MainView.TAMANIO_CASILLERO);


        this.setOnMouseClicked(new ControladorCasillero(this));

        getChildren().addAll(laImagen);
    }


}
