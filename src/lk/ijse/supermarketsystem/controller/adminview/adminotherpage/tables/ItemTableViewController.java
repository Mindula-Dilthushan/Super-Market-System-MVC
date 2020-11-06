package lk.ijse.supermarketsystem.controller.adminview.adminotherpage.tables;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.supermarketsystem.DBController.ItemController;
import lk.ijse.supermarketsystem.dto.ItemDTO;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemTableViewController {
    public TableView customerMainTB;
    public TableColumn itemCodeColumn;
    public TableColumn itemDescrColumn;
    public TableColumn packSizeColumn;
    public TableColumn unitPriceColumn;
    public TableColumn qtyOnHandColumn;
    public JFXButton refreshBt;

    public void ItemTableLoad(){
        itemCodeColumn.setCellValueFactory(new PropertyValueFactory<>("itemcode"));
        itemDescrColumn.setCellValueFactory(new PropertyValueFactory<>("itemdescription"));
        packSizeColumn.setCellValueFactory(new PropertyValueFactory<>("packsize"));
        unitPriceColumn.setCellValueFactory(new PropertyValueFactory<>("unitprice"));
        qtyOnHandColumn.setCellValueFactory(new PropertyValueFactory<>("qtyonhand"));
        try{
            ArrayList<ItemDTO> List = ItemController.itemdata();
            customerMainTB.setItems(FXCollections.observableArrayList(List));
        } catch (SQLException throwables) {
            JOptionPane.showMessageDialog(null, "Driver not found !!!");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Class not found !!!");
        }
    }

    public void refreshBtOnAction(ActionEvent actionEvent) {
        ItemTableLoad();
    }
}
