package View.contenedores;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;



public class DisplayBarraDatos extends HBox {

    public DisplayBarraDatos(){
        Rectangle2D limitesPantalla = Screen.getPrimary().getVisualBounds();
        this.setPrefSize(limitesPantalla.getWidth(),limitesPantalla.getHeight()/24);
        //Image fondoBarra = new Image("View/img/BarraDatos.png", limitesPantalla.getWidth(), limitesPantalla.getHeight()/24, false, true);
        //ImageView im = new ImageView(fondoBarra);
        Label oro = new Label("1500");
        oro.setStyle("-fx-text-fill: white");
        Label poblacion = new Label("43");
        poblacion.setStyle("-fx-text-fill: white");
        Label vida = new Label("376");
        vida.setStyle("-fx-text-fill: white");
        Label nombre = new Label("LeNombre");


        nombre.setStyle("-fx-text-fill: white;\n -fx-font-size: 15");


        nombre.setPadding(new Insets(0,0,0,600));
        HBox hbox = new HBox(oro,poblacion,vida,nombre);
        hbox.setSpacing(120);

        hbox.setTranslateX(limitesPantalla.getWidth()/16);
        hbox.setAlignment(Pos.CENTER);

        this.setStyle("-fx-background-image: url(\"View/img/BarraDatos.png\");\n -fx-background-size: cover");
        this.getStylesheets().add(getClass().getResource("/View/estilos/buttonsStylesheet.css").toString());
        this.getChildren().addAll(hbox);
    }
}
