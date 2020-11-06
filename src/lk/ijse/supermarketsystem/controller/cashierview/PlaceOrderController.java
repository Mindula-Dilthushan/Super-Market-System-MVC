package lk.ijse.supermarketsystem.controller.cashierview;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.supermarketsystem.DBController.CustomerController;
import lk.ijse.supermarketsystem.DBController.ItemController;
import lk.ijse.supermarketsystem.DBController.OrderController;
import lk.ijse.supermarketsystem.dto.CashierDTO;
import lk.ijse.supermarketsystem.dto.CustomerDTO;
import lk.ijse.supermarketsystem.dto.ItemDTO;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlaceOrderController implements Initializable {

    //------------------AnchorPane------------------
    public AnchorPane placeorderpanel;

    //------------------Label-----------------------
    public Label custNameLbl;
    public Label orderIdLbl;
    public Label unitPriceLbl;
    public Label lblUPrice;
    public Label lblStock;

    //------------------Button----------------------
    public JFXButton addItemBT;
    public JFXButton removeBT;
    public JFXButton newCustBT;
    public JFXButton placeOrderBT;
    public JFXButton refreshbt;

    //------------------TxtField--------------------
    public JFXTextField orderdateTxt;
    public JFXTextField qtyTxt;
    public JFXTextField descripTxt;
    public JFXTextField collectionRsTxt;
    public JFXTextField discountTxt;

    //------------------combo box-------------------
    public JFXComboBox custIdComboBox;
    public JFXComboBox itemCodeComboBox;

    //----------------table details-----------------

    @FXML
    private TableView<CashierDTO> tableMainPlaceOrder;

    @FXML
    private TableColumn<CashierDTO, String> itemCodeColumn;

    @FXML
    private TableColumn<CashierDTO, String> decripColumn;

    @FXML
    private TableColumn<CashierDTO, Integer> qtyColumn;

    @FXML
    private TableColumn<CashierDTO,Integer> unitPriceColumn;

    @FXML
    private TableColumn<CashierDTO, Double> discountColumn;

    @FXML
    private TableColumn<CashierDTO, Double> totalColumn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        autogenarateOrderDate();
        loadAllCustomers();
        loadAllItem();
        try {
            genarateOrderId();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void autogenarateOrderDate() {
        LocalDate date = LocalDate.now(); //Since JDK1.8
        orderdateTxt.setText(date.toString());
        //Date date = new Date();
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //String orderDate = sdf.format(date);
        //orderdateTxt.setText(orderDate);
    }
    private void genarateOrderId() throws SQLException, ClassNotFoundException {
        String idCount = OrderController.getLastOrderId();
        orderIdLbl.setText(idCount + 1);
    }
    private void loadAllCustomers() {
        try {
            ArrayList<CustomerDTO> customerdto = CustomerController.customerdata();
            for (CustomerDTO c : customerdto) {
                custIdComboBox.getItems().addAll(c.getCustid());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PlaceOrderController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PlaceOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void loadAllItem(){
        ArrayList<ItemDTO> items = null;
        try {
            items = ItemController.itemdata();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (ItemDTO i : items) {
            itemCodeComboBox.getItems().addAll(i.getItemcode());
        }
        qtyTxt.requestFocus();
    }
    public void custIdComboBoxOnAction (ActionEvent actionEvent) {

        try {
            String customerId = (String) custIdComboBox.getValue();
            CustomerDTO customerDTO = CustomerController.searchCustomer(customerId);
            custNameLbl.setText(customerDTO.getCustname());
        } catch (ClassNotFoundException ex) {

        } catch (SQLException ex) {

        }
    }


    public void newCustBtOnAction(ActionEvent actionEvent) throws IOException {
        Stage closestage = (Stage) newCustBT.getScene().getWindow();
        closestage.close();

        URL resource = this.getClass().getResource("/lk/ijse/supermarketsystem/view/cashierview/NewCustomer.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

    public void itemCodeComboBoxOnAction(ActionEvent actionEvent) {
        try {
            String itmId = (String) itemCodeComboBox.getValue();
            ItemDTO item = ItemController.searchItem(itmId);
            descripTxt.setText(item.getItemdescription());
            lblStock.setText(String.valueOf(item.getQtyonhand()));
            lblUPrice.setText(String.valueOf(item.getUnitprice()));
            qtyTxt.requestFocus();

        } catch (ClassNotFoundException ex) {

        } catch (SQLException ex) {

        }
    }

    public void cashierTableViewLoad() {

        itemCodeColumn.setCellValueFactory(new PropertyValueFactory<>("itemcode"));
        decripColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        qtyColumn.setCellValueFactory(new PropertyValueFactory<>("qtyonhand"));
        unitPriceColumn.setCellValueFactory(new PropertyValueFactory<>("unitprice"));
        discountColumn.setCellValueFactory(new PropertyValueFactory<>("discount"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));

    }

    public void removeBtOnAction (ActionEvent actionEvent){

    }
    public void addItemBtOnAction(ActionEvent actionEvent) {

    }
    public void orderdateLblOnAction(ActionEvent actionEvent) {
    }


    public void qtyTxtOnAction(ActionEvent actionEvent) {

    }


    public void descripTxtOnAction(ActionEvent actionEvent) {
    }

    public void collectionRsTxtOnAction(ActionEvent actionEvent) {
    }


    public void refreshbtOnAction(ActionEvent actionEvent) {

    }
}
