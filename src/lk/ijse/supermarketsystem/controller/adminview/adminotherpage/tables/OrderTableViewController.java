package lk.ijse.supermarketsystem.controller.adminview.adminotherpage.tables;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.supermarketsystem.DBController.OrderController;
import lk.ijse.supermarketsystem.dto.OrderDTO2;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderTableViewController {
    public TableView customerMainTB;
    public TableColumn orderCodeColumn;
    public TableColumn orderDateColumn;
    public TableColumn custIdColumn;
    public JFXButton refreshBt;

    public void OrderTableLoad(){
        orderCodeColumn.setCellValueFactory(new PropertyValueFactory<>("orderid"));
        orderDateColumn.setCellValueFactory(new PropertyValueFactory<>("orderdate"));
        custIdColumn.setCellValueFactory(new PropertyValueFactory<>("custid"));
        try{
            ArrayList<OrderDTO2> List = OrderController.orderdata();
            customerMainTB.setItems(FXCollections.observableArrayList(List));
        } catch (SQLException throwables) {
            JOptionPane.showMessageDialog(null, "Driver not found !!!");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Class not found !!!");
        }
    }

    public void refreshBtOnAction(ActionEvent actionEvent) {
        OrderTableLoad();
    }
}
