package lk.ijse.supermarketsystem.controller.adminview.adminotherpage.tables;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.supermarketsystem.DBController.CustomerController;
import lk.ijse.supermarketsystem.dto.CustomerDTO;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerTableViewController {
    public TableView customerMainTB;
    public TableColumn custIdColumn;
    public TableColumn custTitleColumn;
    public TableColumn custNameColumn;
    public TableColumn custAddColumn;
    public TableColumn ciryColumn;
    public TableColumn provinceColumn;
    public TableColumn postalCodeColumn;
    public JFXButton refreshBt;

    private void TableViewLoad() {

        custIdColumn.setCellValueFactory(new PropertyValueFactory<>("custid"));
        custTitleColumn.setCellValueFactory(new PropertyValueFactory<>("custtitle"));
        custNameColumn.setCellValueFactory(new PropertyValueFactory<>("custname"));
        custAddColumn.setCellValueFactory(new PropertyValueFactory<>("custaddress"));
        ciryColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        provinceColumn.setCellValueFactory(new PropertyValueFactory<>("province"));
        postalCodeColumn.setCellValueFactory(new PropertyValueFactory<>("postalcode"));

        try {
            ArrayList<CustomerDTO> tableList = CustomerController.customerdata();
            customerMainTB.setItems(FXCollections.observableArrayList(tableList));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Driver not found !!!");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Class not found !!!");
        }
    }


    public void refreshBtOnAction(ActionEvent actionEvent) {
        TableViewLoad();
    }
}
