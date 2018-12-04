package View;

import Controller.PiezaHandler;
import Modelo.IEntidad;
import Modelo.Posicion;
import Modelo.Constantes;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;

public class PiezaView extends StackPane {

    private ImageView imagenPieza;
    private IEntidad entidadModelo;
    private double alto;
    private double ancho;

    private int x;
    private int y;

    public PiezaView(IEntidad entidadModelo){

        this.entidadModelo = entidadModelo;

        setOnMousePressed(new PiezaHandler(this));

    }

    public void setPosicion(Posicion unaPosicion){
        this.x = unaPosicion.getHorizontal();
        this.y = unaPosicion.getVertical();

        relocate(x*Constantes.TAMANIO_CASILLERO,y*Constantes.TAMANIO_CASILLERO);
    }

    public void ajustarTamanio(double alto, double ancho){
        this.alto = alto;
        setWidth(this.ancho*Constantes.TAMANIO_CASILLERO);

        this.ancho = ancho;
        setHeight(this.alto*Constantes.TAMANIO_CASILLERO);
    }

    public void agregarImagen(ImageView imagenPiezaADerecha, ImageView imagenPiezaAIzquierda){

        if( this.x < Screen.getPrimary().getVisualBounds().getWidth() /2 ){
            imagenPieza = imagenPiezaADerecha;
            imagenPieza.setFitHeight(this.alto*Constantes.TAMANIO_CASILLERO);
            imagenPieza.setFitWidth(this.ancho*Constantes.TAMANIO_CASILLERO);
        }else{
            imagenPieza = imagenPiezaAIzquierda;
            imagenPieza.setFitHeight(this.alto*Constantes.TAMANIO_CASILLERO);
            imagenPieza.setFitWidth(this.ancho*Constantes.TAMANIO_CASILLERO);
        }

        getChildren().add(imagenPieza);
    }

    public double getPosX(){
        return this.x*Constantes.TAMANIO_CASILLERO;
    }

    public double getPosY(){
        return this.y*Constantes.TAMANIO_CASILLERO;
    }

    // Seba
    public IEntidad getEntidad() {
        return this.entidadModelo;
    }
}
