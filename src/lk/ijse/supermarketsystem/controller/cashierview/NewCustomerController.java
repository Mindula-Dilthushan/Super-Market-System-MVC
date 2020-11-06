package lk.ijse.supermarketsystem.controller.cashierview;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.supermarketsystem.DBController.CustomerController;
import lk.ijse.supermarketsystem.dto.CustomerDTO;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

public class NewCustomerController {
    public JFXButton saveBt;
    public JFXButton backBt;
    public Label custidLbl;
    public JFXTextField custTitleTxt;
    public JFXTextField custNameTxt;
    public JFXTextField custAddressTxt;
    public JFXTextField cityTxt;
    public JFXTextField provinceTxt;
    public JFXTextField postalCodeTxt;
    public JFXTextField custidTxt;

    public void addnewcust(){
        String custid =custidTxt.getText();
        String custtitle=custTitleTxt.getText();
        String custname=custNameTxt.getText();
        String custaddress=custAddressTxt.getText();
        String city=cityTxt.getText();
        String province=provinceTxt.getText();
        String postalcode=postalCodeTxt.getText();

        CustomerDTO info = new CustomerDTO(custid,custtitle,custname,custaddress,city,province,postalcode);
        try{
            boolean isAdded = CustomerController.customerInfo(info);
            if(isAdded){
                JOptionPane.showMessageDialog(null, "Added Success");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver not found");
        }
    }


    public void backBtOnAction(ActionEvent actionEvent) throws IOException {
        Stage closestage = (Stage) backBt.getScene().getWindow();
        closestage.close();

        URL resource = this.getClass().getResource("/lk/ijse/supermarketsystem/view/cashierview/Cashierview.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

    public void saveBtOnAction(ActionEvent actionEvent) throws IOException {
        addnewcust();
        Stage closestage = (Stage) backBt.getScene().getWindow();
        closestage.close();

        URL resource = this.getClass().getResource("/lk/ijse/supermarketsystem/view/cashierview/Cashierview.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

    public void postalCodeTxtOnAction(ActionEvent actionEvent) {
    }

    public void provinceTxtOnAction(ActionEvent actionEvent) {
    }

    public void cityTxtOnAction(ActionEvent actionEvent) {
    }

    public void custAddressTxtOnAction(ActionEvent actionEvent) {
    }

    public void custTitleTxtOnAction(ActionEvent actionEvent) {
    }

    public void custNameTxtOnAction(ActionEvent actionEvent) {
    }
}
