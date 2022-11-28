package game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;

public class GameApp extends Application {
    @Override
    public void start(Stage primaryStage)  {
        try {
            BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("GameGUI.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            root.requestFocus();
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    public static void main(String[] args) {
        launch(args);
    }

}
