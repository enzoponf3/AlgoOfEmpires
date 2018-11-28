package View;

import View.contenedores.pantallaInicio;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.stage.Stage;
import javafx.application.Application;


import java.io.FileInputStream;
import java.io.InputStream;

import static javafx.application.Application.launch;

public class Main extends Application {

    public static void main (String []args){
        launch(args);
    }

    public void start (Stage stageAplication) throws Exception{
        stageAplication.setTitle("Algo Of Empires");
        stageAplication.getIcons().add(new Image("View/img/icon.png"));

        Scene scene = new Scene(new pantallaInicio(stageAplication));

        stageAplication.setScene(scene);
        stageAplication.setResizable(false);
        stageAplication.show();
    }


}