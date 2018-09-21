import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    static Stage primaryStage;
    static AnchorPane startScreen;

    @Override
    public void start(Stage stage) throws Exception {
        try {
            this.primaryStage = stage;
            startScreen = FXMLLoader.load(getClass().getResource("startScreen.fxml"));
            primaryStage.setScene(new Scene (startScreen, 600, 400));
            primaryStage.setTitle("Main Menu");
            primaryStage.show();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }


    public static void main(String[] args)
    {
        launch(args);
    }
}
