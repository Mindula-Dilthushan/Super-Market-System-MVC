package lk.ijse.supermarketsystem.controller.adminview.adminotherpage.tables;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.supermarketsystem.DBController.OrderDetailController;
import lk.ijse.supermarketsystem.dto.OrderDetailDTO;
import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsTableViewController {
    public TableView customerMainTB;
    public TableColumn orderIdColumn;
    public TableColumn itemCodeColumn;
    public TableColumn orderQtyColumn;
    public TableColumn dicountColumn;
    public JFXButton refreshBt;

    public void OrderDetailsTableLoad(){
        orderIdColumn.setCellValueFactory(new PropertyValueFactory<>("orderid"));
        itemCodeColumn.setCellValueFactory(new PropertyValueFactory<>("itemcode"));
        orderQtyColumn.setCellValueFactory(new PropertyValueFactory<>("orderqty"));
        dicountColumn.setCellValueFactory(new PropertyValueFactory<>("discount"));
        try{
            ArrayList<OrderDetailDTO> List = OrderDetailController.orderDetailsdata();
            customerMainTB.setItems(FXCollections.observableArrayList(List));
        } catch (SQLException throwables) {
            JOptionPane.showMessageDialog(null, "Driver not found !!!");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Class not found !!!");
        }
    }

    public void refreshBtOnAction(ActionEvent actionEvent) {
        OrderDetailsTableLoad();
    }
}
