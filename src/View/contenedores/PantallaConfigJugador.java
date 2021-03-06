package View.contenedores;

import Controller.*;
import View.Boton;
import View.BotonRadio;
import View.JugadorView;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class PantallaConfigJugador extends Pane {

    Stage stage;

    public PantallaConfigJugador(Stage stage, JugadorView jugador1, JugadorView jugador2, ControladorMusicaFx musica){
        this.stage = stage;
        this.setPrefSize(1080,680);
        this.setStyle("-fx-background-color: black");

        Label label1 = new Label("JUGADOR 1");
        Label label2 = new Label("JUGADOR 2");
        label1.getStyleClass().add("label");
        label2.getStyleClass().add("label");

        Pane panel1 = setPersonaje(jugador1,"JUGADOR 1");
        Pane panel2 = setPersonaje(jugador2, "JUGADOR 2");

        Boton empezar = new Boton ("EMPEZAR!", new BeginButtonHandler(stage, jugador1,jugador2, musica));
        empezar.getStyleClass().add("menu-button");

        panel1.relocate(0,0);
        panel2.relocate(542, 0);
        empezar.relocate(980,570);
        this.getStylesheets().add(getClass().getResource("/View/estilos/buttonsStylesheet.css").toExternalForm());
        this.getChildren().addAll(panel1,panel2,empezar);

    }

    public Pane setPersonaje(JugadorView jugador, String personaje){
        Pane panel = new Pane();
        panel.resize(300,480);
        ImageView fondo = new ImageView(new Image("View/img/fondo2.png",538,680,false,false));
        Label figura = new Label(personaje);
        figura.setFont(Font.font("Castellar", FontWeight.NORMAL, FontPosture.REGULAR,20));
        ImageView fig1 = new ImageView(new Image("View/img/charMujer.png",500,355,true,false));
        ImageView fig2 = new ImageView(new Image("View/img/charHombre.png",500,355,true,false));

        final ToggleGroup group = new ToggleGroup();
        BotonRadio im1 = new BotonRadio("");
        im1.setOnAction(new SelectCharButtonHandler(fig1,jugador,group,im1));
        im1.setGraphic(fig1);
        im1.getStyleClass().add("radio-button");
        im1.setToggleGroup(group);

        BotonRadio im2 = new BotonRadio("");
        im2.setOnAction(new SelectCharButtonHandler(fig2,jugador,group,im2));
        im2.setGraphic(fig2);
        im2.getStyleClass().add("radio-button");
        im2.setToggleGroup(group);

        TextField nombre = new TextField();
        nombre.setPromptText("Ingresar Nombre");
        nombre.setPrefSize(200,40);

        Boton listo = new Boton("Listo", new ReadyButtonHandler(jugador, nombre, group));
        listo.getStyleClass().add("ready-button");
        figura.relocate(210,60);
        im1.relocate(50,150);
        im2.relocate(300,150);
        nombre.relocate(175, 550);
        listo.relocate(175,595);
        panel.getStylesheets().add(getClass().getResource("/View/estilos/buttonsStylesheet.css").toExternalForm());
        panel.getChildren().addAll(fondo,figura,im1,im2,nombre,listo);

        return panel;
    }

}
