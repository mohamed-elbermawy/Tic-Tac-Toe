package client;
import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Main extends Application {
    protected MediaPlayer videoForWinner;

    private static Parent root;
    public static Stage mystage;

    @Override
    public void start(Stage primaryStage) throws IOException {
//           StackPane secondaryLayout2 = new StackPane();
//         videoForWinner = new MediaPlayer( new Media(getClass().getResource("Music.mp3").toExternalForm()));
//                            MediaView mediaView2 = new MediaView(videoForWinner);
//                   
//                            videoForWinner.play();
        mystage = primaryStage;
        root = FXMLLoader.load(getClass().getResource("SinglePlayer.fxml"));
        mystage.setTitle("SinglePlayer");
        mystage.setScene(new Scene(root));
        mystage.show();

        
    }

    @Override
    public void stop() {
      
    }


    public static void main(String[] args) {
        launch(args);
       
    }
}
