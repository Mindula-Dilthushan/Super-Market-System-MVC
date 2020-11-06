package lk.ijse.supermarketsystem.controller.cashierview;

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

public class CashierviewController {
    public AnchorPane cashiermainpanel1;
    
    public JFXButton homeBT;
    public JFXButton orderBT;
    public JFXButton exitBT;
    public JFXButton backLoginBT;

    public void orderBtOnAction(ActionEvent actionEvent) throws IOException {
        cashiermainpanel1.getChildren().clear();
        AnchorPane registerItemForm = (AnchorPane) FXMLLoader.load(this.getClass().getResource("/lk/ijse/supermarketsystem/view/cashierview/PlaceOrder.fxml"));
        cashiermainpanel1.getChildren().addAll(registerItemForm.getChildren());
    }

    public void homeBtOnAction(ActionEvent actionEvent) throws IOException {
        cashiermainpanel1.getChildren().clear();
        AnchorPane registerItemForm = (AnchorPane) FXMLLoader.load(this.getClass().getResource("/lk/ijse/supermarketsystem/view/cashierview/CashierHomeBtPage.fxml"));
        cashiermainpanel1.getChildren().addAll(registerItemForm.getChildren());

    }

    public void exitBtOnAction(ActionEvent actionEvent) {
        Stage closestage = (Stage) exitBT.getScene().getWindow();
        closestage.close();

        try {
            Thread.sleep(5);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("| SUPER MARKET | ");
            alert.setHeaderText(null);
            alert.setContentText("Nice Today Work...! \nGood Bye...! ");
            alert.showAndWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void backLoginBtOnAction(ActionEvent actionEvent) throws IOException {
        Stage closestage = (Stage) backLoginBT.getScene().getWindow();
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
