package View.contenedores;

import View.Boton;
import Controller.HelpButtonHandler;
import Controller.PlayButtonHandler;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class PantallaInicio extends Pane {

    Stage stage;

    public PantallaInicio(Stage stage) {

        this.stage = stage;
        this.setPrefSize(720,480);

        Popup pop = new Popup();
        Slider volumen = new Slider(0.0,1.0,0.5);
        pop.setAutoHide(true);
        pop.getContent().add(volumen);
        pop.setX(340);
        pop.setY(154);

        Image fuego = new Image("View/img/fondo.png", 730, 500, false, true);
        ImageView im1 = new ImageView();
        im1.setImage(fuego);
        Image age = new Image("View/img/logo.png", 390, 179, true, true);
        ImageView im2 = new ImageView();
        im2.setImage(age);
        im2.relocate(180, 82);

        Image espada = new Image("View/img/espadita.png", 30, 30, false, false);
        ImageView im3 = new ImageView(espada);

        Boton jugar = new Boton("JUGAR", new PlayButtonHandler(this.stage));
        jugar.setGraphic(im3);
        jugar.getStyleClass().add("menu-button");
        jugar.relocate(224, 356);

        Image help = new Image("View/img/preg.png", 30, 30, false, false);
        ImageView im4 = new ImageView(help);

        Boton ayuda = new Boton("AYUDA", new HelpButtonHandler(this.stage));
        ayuda.setGraphic(im4);
        ayuda.getStyleClass().add("menu-button");
        ayuda.relocate(397, 356);

        this.getStylesheets().add(getClass().getResource("/View/estilos/buttonsStylesheet.css").toString());

        this.getChildren().addAll(im1, im2, jugar, ayuda);

    }
}
