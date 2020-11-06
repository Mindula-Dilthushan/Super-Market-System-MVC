package lk.ijse.supermarketsystem.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;


public class AppInitializer extends Application {

    public void start(Stage primaryStage) throws Exception {

        URL resource = this.getClass().getResource("/lk/ijse/supermarketsystem/view/LoginView.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("* SUPER MARKET SYSTEM | PROGRAMMER -> ALPHA *");
        primaryStage.show();
    }
}