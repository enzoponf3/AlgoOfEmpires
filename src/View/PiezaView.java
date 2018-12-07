package View;

import Controller.PiezaHandler;
import Modelo.IEntidad;
import Modelo.Posicion;
import Modelo.Constantes;
import Modelo.Unidades.Unidad;
import javafx.scene.control.ContextMenu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;

public abstract class PiezaView extends StackPane {

    private ImageView imagenPieza;
    protected IEntidad entidadModelo;
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

    public void agregarImagen(ImageView imagenPieza){
        this.imagenPieza = imagenPieza;
        this.imagenPieza.setFitHeight(this.alto*Constantes.TAMANIO_CASILLERO);
        this.imagenPieza.setFitWidth(this.ancho*Constantes.TAMANIO_CASILLERO);

        getChildren().add(imagenPieza);
    }

    public void setImagenPlazaConstruida(){
        removerImagen();
        this.imagenPieza = new ImageView((new Image("View/img/University2.png")));
        this.imagenPieza.setFitHeight(this.alto*Constantes.TAMANIO_CASILLERO);
        this.imagenPieza.setFitWidth(this.ancho*Constantes.TAMANIO_CASILLERO);
        getChildren().add(imagenPieza);
    }

    public void setImagenCuartelConstruido(){
        removerImagen();
        this.imagenPieza = new ImageView(new Image("View/img/Cuartel.png"));
        this.imagenPieza.setFitHeight(this.alto*Constantes.TAMANIO_CASILLERO);
        this.imagenPieza.setFitWidth(this.ancho*Constantes.TAMANIO_CASILLERO);
        getChildren().add(imagenPieza);
    }

    public double getPosX(){
        return this.x*Constantes.TAMANIO_CASILLERO;
    }

    public double getPosY(){
        return this.y*Constantes.TAMANIO_CASILLERO;
    }

    public abstract ContextMenu crearMenu();

    public ImageView getImagen(){
        return this.imagenPieza;
    }

    // Seba
    public IEntidad getEntidad() {
        return this.entidadModelo;
    }

    public  void removerImagen(){
        getChildren().remove(imagenPieza);
    }

    public abstract void colocarImgRestos();

    public boolean estaMuerta(){
        return entidadModelo.estaMuerto();
    }

    public void imagenMuerto(){
        if( estaMuerta() ){
            colocarImgRestos();
        }
    }

}
