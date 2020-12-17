package sample;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static HostServices hostServices;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("ZS Shop Admin");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        hostServices = getHostServices();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
