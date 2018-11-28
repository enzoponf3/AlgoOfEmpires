package View;


import View.contenedores.PantallaGanador;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


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
        Scene ayuda = new Scene(new PantallaGanador(this));        //Display de pantalla ganador
        Stage stage = new Stage();
        stage.setScene(ayuda);
        stage.setResizable(false);
        stage.show();

    }

    public void inicializar(Jugador jugador){


    }

}
