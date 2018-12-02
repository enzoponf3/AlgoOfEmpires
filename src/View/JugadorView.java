package View;


import Modelo.Edificios.PlazaCentral;
import Modelo.Jugador.Jugador;
import Modelo.Mapa;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import View.contenedores.PantallaGanador;
import View.entidades.AldeanoView;
import View.entidades.CastilloView;
import View.entidades.PlazaCentralView;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class JugadorView {

    private ImageView personaje;
    private String nombre = "";

    private Jugador jugadorModelo;
    private Group aldeanosView;
    private Group ejercitoView;
    private Group edificiosView;
    private CastilloView castilloView;

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

    public void setJugadorModelo(Jugador jugadorModelo){
        this.jugadorModelo = jugadorModelo;
        inicializarPiezas();
    }

    public Group getPiezas(){
        Group piezas = new Group();
        piezas.getChildren().addAll(castilloView, aldeanosView, ejercitoView, edificiosView);

        return piezas;
    }

    public void inicializarPiezas(){
        this.castilloView = new CastilloView(this.jugadorModelo.getCastillo());

        PlazaCentralView plazaCentralView = new PlazaCentralView((PlazaCentral) this.jugadorModelo.getEdificios().get(0));
        this.edificiosView = new Group();
        this.edificiosView.getChildren().add(plazaCentralView);

        this.aldeanosView = new Group();
        for(Aldeano aldeanoModelo : jugadorModelo.getAldeanos()){
            AldeanoView aldeanoView = new AldeanoView(aldeanoModelo);
            this.aldeanosView.getChildren().add(aldeanoView);
        }

        this.ejercitoView = new Group();
    }

    public String getOro() {
        return Integer.toString(jugadorModelo.getCantidadOro());
    }

    public String getPoblacion() {
        return Integer.toString(jugadorModelo.getCantidadPoblacion());
    }

    public String getVida() {
        return Integer.toString(jugadorModelo.getVida()); //Este pregunta por vida castillo, le puse vida y no vidaCastillo para no revelar implementacion o la flasheo fuerte?
    }

    public boolean contienePieza(PiezaView piezaView){
        if( this.aldeanosView.getChildren().contains(piezaView) )
            return true;
        else if( this.ejercitoView.getChildren().contains(piezaView) )
            return true;
        else if( this.edificiosView.getChildren().contains(piezaView) )
            return true;
        else if( this.edificiosView.getChildren().contains(piezaView) )
            return true;
        else
            return false;

    }

    public boolean mover(Aldeano aldeanoModelo, Posicion destino){
        Mapa mapaModelo = Mapa.getInstancia();
        return jugadorModelo.mover(aldeanoModelo, destino, mapaModelo);
    }
}
