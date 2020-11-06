package lk.ijse.supermarketsystem.controller.adminview;

import lk.ijse.supermarketsystem.DBController.ItemController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import lk.ijse.supermarketsystem.dto.ItemDTO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModifyItemController {
    public JFXTextField itemcodeTxt;
    public JFXTextField itemDescTxt;
    public JFXTextField packSizeTxt;
    public JFXTextField unitPriceTxt;
    public JFXTextField qtyOnHandTxt;
    public TableView tableViewMain;
    public TableColumn itemCodeColumn;
    public TableColumn itemDescColumn;
    public TableColumn packColumn;
    public TableColumn unitpriceColumn;
    public TableColumn qtyonhandColumn;
    public JFXButton refreshBt;
    public JFXButton searchBT;
    public JFXButton modifyBT;
    public AnchorPane managePanel;

    void clearAll() {
        itemcodeTxt.setText("");
        itemDescTxt.setText("");
        packSizeTxt.setText("");
        unitPriceTxt.setText("");
        qtyOnHandTxt.setText("");
    }

    public void searchBtOnAction(ActionEvent actionEvent)  {
        try {
            ItemDTO itemDTO= ItemController.searchItem(itemcodeTxt.getText());
            if(itemDTO!=null){
                itemDescTxt.setText(itemDTO.getItemdescription());
                packSizeTxt.setText(itemDTO.getPacksize());
                unitPriceTxt.setText(itemDTO.getUnitprice()+"");
                qtyOnHandTxt.setText(itemDTO.getQtyonhand()+"");
            }else{
                JOptionPane.showMessageDialog(null, "Customer not found...");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver not found...");
        }

    }


    public void refreshBtOnAction(ActionEvent actionEvent) {

        ItemTableLoad();
    }
    public void ItemTableLoad(){
        itemCodeColumn.setCellValueFactory(new PropertyValueFactory<>("itemcode"));
        itemDescColumn.setCellValueFactory(new PropertyValueFactory<>("itemdescription"));
        packColumn.setCellValueFactory(new PropertyValueFactory<>("packsize"));
        unitpriceColumn.setCellValueFactory(new PropertyValueFactory<>("unitprice"));
        qtyonhandColumn.setCellValueFactory(new PropertyValueFactory<>("qtyonhand"));
        try{
            ArrayList<ItemDTO> List = ItemController.itemdata();
            tableViewMain.setItems(FXCollections.observableArrayList(List));
        } catch (SQLException throwables) {
            JOptionPane.showMessageDialog(null, "Driver not found !!!");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Class not found !!!");
        }
    }
    public void modifyBtOnAction(ActionEvent actionEvent) throws IOException {
        try {
            ItemDTO itemDTO=new ItemDTO(itemcodeTxt.getText() , itemDescTxt.getText(), packSizeTxt.getText(),unitPriceTxt.getText(),qtyOnHandTxt.getText());
            boolean isUpdated=ItemController.updateItem(itemDTO);
            if (isUpdated) {
                JOptionPane.showMessageDialog(null, "Update Success");
            } else {
                JOptionPane.showMessageDialog(null, "Update Fail");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver not found...");
        }
        clearAll();
        ItemTableLoad();
    }
}
