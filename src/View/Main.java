package View;

import Controller.ControladorMusicaFx;
import View.contenedores.PantallaInicio;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.application.Application;


public class Main extends Application {

    public static void main (String []args){
        launch(args);
    }

    public void start (Stage stageAplication){
        stageAplication.setTitle("Algo Of Empires");
        stageAplication.getIcons().add(new Image("View/img/icon.png"));
        ControladorMusicaFx musica = new ControladorMusicaFx();
        Scene scene = new Scene(new PantallaInicio(stageAplication));

        stageAplication.setScene(scene);
        stageAplication.setResizable(false);
        stageAplication.show();
    }

}