package View;

import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;


public class JugadorView {
    private ImageView personaje;
    private String nombre = "";

    public void setPersonaje(ImageView figura){
        this.personaje = figura;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public ImageView getFigura(){
        return this.personaje;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void mostrarQueGane(){

    }
}
