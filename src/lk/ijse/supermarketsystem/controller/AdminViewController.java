package lk.ijse.supermarketsystem.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;

public class AdminViewController {
    public AnchorPane homepanel;

    public JFXButton homeBT;
    public JFXButton reportBT;
    public JFXButton manageBT;
    public JFXButton exitBT;
    public JFXButton detailsBT;
    public JFXButton backLoginBT;

    public void homeBtOnAction(ActionEvent actionEvent) throws IOException {
        homepanel.getChildren().clear();
        AnchorPane registerItemForm = (AnchorPane) FXMLLoader.load(this.getClass().getResource("../view/adminview/adminotherpage/AdminHomeBtPage.fxml"));
        homepanel.getChildren().addAll(registerItemForm.getChildren());
    }

    public void reportBtOnAction(ActionEvent actionEvent) {
    }

    public void manageBtOnAction(ActionEvent actionEvent) throws IOException {
        homepanel.getChildren().clear();
        AnchorPane registerItemForm = (AnchorPane) FXMLLoader.load(this.getClass().getResource("../view/adminview/AdminstrationViewManage.fxml"));
        homepanel.getChildren().addAll(registerItemForm.getChildren());
    }

    public void exitBtOnAction(ActionEvent actionEvent) throws IOException {
        Stage closestage = (Stage) exitBT.getScene().getWindow();
        closestage.close();

        try {
            Thread.sleep(5);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("| SUPER MARKET | ");
            alert.setHeaderText(null);
            alert.setContentText("Good Bye Sir...!");
            alert.showAndWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void detailsBtOnAction(ActionEvent actionEvent) throws IOException {
        homepanel.getChildren().clear();
        AnchorPane registerItemForm = (AnchorPane) FXMLLoader.load(this.getClass().getResource("../view/adminview/adminotherpage/DetailsTableAllView.fxml"));
        homepanel.getChildren().addAll(registerItemForm.getChildren());
    }

    public void backLoginBtOnAction(ActionEvent actionEvent) throws IOException {
        Stage closestage = (Stage) exitBT.getScene().getWindow();
        closestage.close();

        URL resource = this.getClass().getResource("/lk/ijse/supermarketsystem/view/LoginView.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }
}
