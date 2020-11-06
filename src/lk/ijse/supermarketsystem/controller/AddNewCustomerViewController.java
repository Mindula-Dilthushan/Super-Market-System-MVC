package lk.ijse.supermarketsystem.controller;

import lk.ijse.supermarketsystem.DBController.CustomerController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import lk.ijse.supermarketsystem.dto.CustomerDTO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddNewCustomerViewController {
    public JFXButton saveBt;
    public JFXButton backBt;
    public JFXButton cancelBt;
    public JFXTextField newCustIdTxt;
    public JFXTextField newCustTitleTxt;
    public JFXTextField newCustNameTxt;
    public JFXTextField newCustAddressTxt;
    public JFXTextField newCityTxt;
    public JFXTextField newProvinceTxt;
    public JFXTextField newPostalCodeTxt;
    public TableColumn customerIdColumn;
    public TableColumn customerTitleColumn;
    public TableColumn customerNameColumn;
    public TableColumn customerAddressColumn;
    public TableColumn cityColumn;
    public TableColumn provinceColumn;
    public TableColumn postalCodeColumn;
    public TableView cashierTableView;

    void clearAll() {
        newCustIdTxt.setText("");
        newCustTitleTxt.setText("");
        newCustNameTxt.setText("");
        newCustAddressTxt.setText("");
        newCityTxt.setText("");
        newProvinceTxt.setText("");
        newPostalCodeTxt.setText("");
    }
    public void addnewcust(){
        String custid=newCustIdTxt.getText();
        String custtitle=newCustTitleTxt.getText();
        String custname=newCustNameTxt.getText();
        String custaddress=newCustAddressTxt.getText();
        String city=newCityTxt.getText();
        String province=newProvinceTxt.getText();
        String postalcode=newPostalCodeTxt.getText();

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
    private void cashierTableViewLoad() {

        customerIdColumn.setCellValueFactory(new PropertyValueFactory<>("custid"));
        customerTitleColumn.setCellValueFactory(new PropertyValueFactory<>("custtitle"));
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("custname"));
        customerAddressColumn.setCellValueFactory(new PropertyValueFactory<>("custaddress"));
        cityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        provinceColumn.setCellValueFactory(new PropertyValueFactory<>("province"));
        postalCodeColumn.setCellValueFactory(new PropertyValueFactory<>("postalcode"));

        try {
            ArrayList<CustomerDTO> tableList = CustomerController.customerdata();
            cashierTableView.setItems(FXCollections.observableArrayList(tableList));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Driver not found !!!");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Class not found !!!");
        }
    }

    public void saveBtOnAction(ActionEvent actionEvent) {

        addnewcust();
        cashierTableViewLoad();
        clearAll();

    }

    public void backBtOnAction(ActionEvent actionEvent) throws  IOException {
        Stage closestage = (Stage) backBt.getScene().getWindow();
        closestage.close();

        URL resource = this.getClass().getResource("/lk/ijse/supermarketsystem/view/cashierview/CashierView.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

    public void cancelBtOnAction(ActionEvent actionEvent) throws IOException {
        Stage closestage = (Stage) cancelBt.getScene().getWindow();
        closestage.close();

        URL resource = this.getClass().getResource("/lk/ijse/supermarketsystem/view/LoginView.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();

    }

    /*public void exitWindow() throws IOException {
        int choice= JOptionPane.showConfirmDialog(null,"Do you want to Exit ??","Exit", JOptionPane.YES_NO_OPTION);
        if(choice==0){
            System.exit(0);


        }
    }*/

    public void newCustIdTxtOnAction(ActionEvent actionEvent) {
        newCustIdTxt.requestFocus();

    }
    public void newCustTitleTxtOnAction(ActionEvent actionEvent) {
        newCustTitleTxt.requestFocus();
    }

    public void newCustNameTxtOnAction(ActionEvent actionEvent) {
    }

    public void newCustAddressTxtOnAction(ActionEvent actionEvent) {
    }

    public void newCityTxtOnAction(ActionEvent actionEvent) {
    }

    public void newProvinceTxtOnAction(ActionEvent actionEvent) {
    }

    public void newPostalCodeTxtOnAction(ActionEvent actionEvent) {
        fetchData();
    }

    private void fetchData() {
    }

}
