package lk.ijse.supermarketsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;


public class LoginViewController {
    public JFXTextField usernameTxt;
    public JFXPasswordField passwordTxt;
    public JFXButton loginBt;
    public JFXButton exitBt;
    public Label lblDateTime;

    void clearAll() {
        usernameTxt.setText("");
        passwordTxt.setText("");
    }

    public void loginBtOnAction(ActionEvent actionEvent) throws IOException {
        String LoginId = usernameTxt.getText();
        String LoginPassword = passwordTxt.getText();

        if (LoginId.equals("Admin") && LoginPassword.equals("Admin")) {
            System.out.println(LoginId);

            Stage closestage = (Stage) loginBt.getScene().getWindow();
            closestage.close();

            URL resource = this.getClass().getResource("/lk/ijse/supermarketsystem/view/adminview/AdminView.fxml");
            Parent load = FXMLLoader.load(resource);
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();

        } else if (LoginId.equals("Cashier") && LoginPassword.equals("Cashier")) {

            Stage closestage = (Stage) loginBt.getScene().getWindow();
            closestage.close();

            URL resource = this.getClass().getResource("/lk/ijse/supermarketsystem/view/cashierview/CashierView.fxml");
            Parent load = FXMLLoader.load(resource);
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Invalid ID Or Password ! ").show();
            clearAll();
        }
       
    }

    public void exitBtOnAction(ActionEvent actionEvent){
        Stage closestage = (Stage) exitBt.getScene().getWindow();
        closestage.close();

        try {
            Thread.sleep(5);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("| SUPER MARKET | ");
            alert.setHeaderText(null);
            alert.setContentText("Good Bye..! Welcome Back...!");
            alert.showAndWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void initialize(URL location, ResourceBundle resources) {
        initClock();
    }
    private void initClock() {

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            lblDateTime.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public void usrnameTxtOnAction(ActionEvent actionEvent){
    }

    public void passwordTxtOnAction(ActionEvent actionEvent){
    }


}
