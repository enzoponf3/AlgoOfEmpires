package Controller;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class ControladorMusicaFx {

     private static ControladorMusicaFx INSTANCIA;
     private MediaPlayer sonido;

    public ControladorMusicaFx(){
        INSTANCIA = this;
    }

    public static ControladorMusicaFx getINSTANCIA (){return INSTANCIA;}

    private void play(MediaPlayer reproductor, Double volumen, boolean auto){

        reproductor.play();
        reproductor.setVolume(volumen);
        if(auto){
            reproductor.setOnEndOfMedia(() -> reproductor.seek(Duration.ZERO));
        }

    }



    public MediaPlayer inicio(){
        MediaPlayer inicio =new MediaPlayer(new Media(getClass().getResource("/View/sounds/TitleScreen.mp3").toExternalForm()));
        this.play(inicio,1.0,false);
        this.sonido = inicio;
        return inicio;
    }

    public void ataque(){
        MediaPlayer ataque =new MediaPlayer(new Media(getClass().getResource("/View/sounds/fight4.wav").toExternalForm()));
        this.play(ataque,1.0,false);
        this.sonido = ataque;
    }

    public void montarADA(){
        MediaPlayer montarADA =new MediaPlayer(new Media(getClass().getResource("/View/sounds/trebuchetcreak2.wav").toExternalForm()));
        this.play(montarADA,1.0,false);
        this.sonido = montarADA;
    }

    public void desmontarADA(){
        MediaPlayer desmontarADA =new MediaPlayer(new Media(getClass().getResource("/View/sounds/trebuchet1.wav").toExternalForm()));
        this.play(desmontarADA,1.0,false);
        this.sonido = desmontarADA;
    }

    public void construirUnidad(){
        MediaPlayer unidadCreada =new MediaPlayer(new Media(getClass().getResource("/View/sounds/blacksmith.wav").toExternalForm()));
        this.play(unidadCreada,1.0,false);
        this.sonido = unidadCreada;
    }

    public void construirEdificio(){
        MediaPlayer construir =new MediaPlayer(new Media(getClass().getResource("/View/sounds/batteringramhit3.wav").toExternalForm()));
        this.play(construir,1.0,false);
        this.sonido = construir;

    }

    public void terminarEdificio(){
        MediaPlayer terminarEdificio =new MediaPlayer(new Media(getClass().getResource("/View/sounds/batteringramhit1.wav").toExternalForm()));
        this.play(terminarEdificio,1.0,false);
        this.sonido = terminarEdificio;

    }

    public void continuarEdificio(){
        MediaPlayer continuarEdificio =new MediaPlayer(new Media(getClass().getResource("/View/sounds/mine3.wav").toExternalForm()));
        this.play(continuarEdificio,1.0,false);
        this.sonido = continuarEdificio;
    }

    public void destruirEdifio(){
        MediaPlayer destruirEdificio =new MediaPlayer(new Media(getClass().getResource("/View/sounds/demolitionshipexplode2.wav").toExternalForm()));
        this.play(destruirEdificio,1.0,false);
        this.sonido = destruirEdificio;

    }

    public void error(){
        MediaPlayer error =new MediaPlayer(new Media(getClass().getResource("/View/sounds/error.wav").toExternalForm()));
        this.play(error,1.0,false);
        this.sonido = error;

    }

    public void inGame() {
        MediaPlayer inGame =new MediaPlayer(new Media(getClass().getResource("/View/sounds/InGame.mp3").toExternalForm()));
        this.play(inGame,0.2,true);
        this.sonido = inGame;
    }

    public void pasarTurno(){
        MediaPlayer inGame =new MediaPlayer(new Media(getClass().getResource("/View/sounds/attackwarning2.wav").toExternalForm()));
        this.play(inGame,1.0,false);
        this.sonido = inGame;
    }

    public void victoria() {
        MediaPlayer victoria =new MediaPlayer(new Media(getClass().getResource("/View/sounds/victory.wav").toExternalForm()));
        this.play(victoria,0.2,false);
        this.sonido = victoria;
    }

    public void parar() {
        this.sonido.stop();
    }
}
