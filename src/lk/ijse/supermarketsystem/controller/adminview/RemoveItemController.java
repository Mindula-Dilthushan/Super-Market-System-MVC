package lk.ijse.supermarketsystem.controller.adminview;

import lk.ijse.supermarketsystem.DBController.ItemController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import lk.ijse.supermarketsystem.dto.ItemDTO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RemoveItemController implements Initializable {

    public JFXTextField itemcodeTxt;
    public JFXTextField itemDescTxt;
    public JFXTextField unitPriceTxt;
    public JFXTextField qtyOnHandTxt;
    public JFXTextField packSizeTxt;
    public JFXButton deleteBT;
    public JFXButton refreshBt;
    public TableView tableViewMain;
    public TableColumn itemCodeColumn;
    public TableColumn itemDescColumn;
    public TableColumn packColumn;
    public TableColumn unitpriceColumn;
    public TableColumn qtyonhandColumn;
    public JFXButton searchBT;

    void clearAll() {
        itemcodeTxt.setText("");
        itemDescTxt.setText("");
        packSizeTxt.setText("");
        unitPriceTxt.setText("");
        qtyOnHandTxt.setText("");
    }
    public  void ItemTableLoad(){
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

    public void itemdelete(){
        String itemcode=itemcodeTxt.getText();
        String itemdescription=itemDescTxt.getText();
        String packsize=packSizeTxt.getText();
        String unitprice=qtyOnHandTxt.getText();
        String qtyonhand=unitPriceTxt.getText();

        ItemDTO info = new ItemDTO(itemcode,itemdescription,packsize,unitprice,qtyonhand);
        try{
            boolean isAdded = ItemController.itemdelete(itemcode);
            if(isAdded){
                JOptionPane.showMessageDialog(null, "Deleted");
            }else{
                JOptionPane.showMessageDialog(null, "Delete Fail");
            }
        } catch (
                SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver not found");
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void refreshBtOnAction(ActionEvent actionEvent) {

        ItemTableLoad();
    }

    public void deleteBtOnAction(ActionEvent actionEvent) {
        ItemTableLoad();
        itemdelete();
        clearAll();
    }

    public void searchBtOnAction(ActionEvent actionEvent) {
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
}
