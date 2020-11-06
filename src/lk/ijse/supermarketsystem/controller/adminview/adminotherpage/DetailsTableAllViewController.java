package lk.ijse.supermarketsystem.controller.adminview.adminotherpage;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DetailsTableAllViewController {
    public JFXButton custTableBt;
    public JFXButton ItemTableBT;
    public JFXButton ordetableBt;
    public JFXButton orderdetailsBT;
    public AnchorPane tablepanel;

    public void custTableBtOnAction(ActionEvent actionEvent) throws IOException {
        tablepanel.getChildren().clear();
        AnchorPane registerItemForm = (AnchorPane) FXMLLoader.load(this.getClass().getResource("/lk/ijse/supermarketsystem/view/adminview/adminotherpage/tables/CustomerTableView.fxml"));
        tablepanel.getChildren().addAll(registerItemForm.getChildren());

    }
    public void ItemTableBtOnAction(ActionEvent actionEvent) throws IOException {
        tablepanel.getChildren().clear();
        AnchorPane registerItemForm = (AnchorPane) FXMLLoader.load(this.getClass().getResource("/lk/ijse/supermarketsystem/view/adminview/adminotherpage/tables/ItemTableView.fxml"));
        tablepanel.getChildren().addAll(registerItemForm.getChildren());
    }
    public void orderdetailsBtOnAction(ActionEvent actionEvent) throws IOException {
        tablepanel.getChildren().clear();
        AnchorPane registerItemForm = (AnchorPane) FXMLLoader.load(this.getClass().getResource("/lk/ijse/supermarketsystem/view/adminview/adminotherpage/tables/OrderDetailsTableView.fxml"));
        tablepanel.getChildren().addAll(registerItemForm.getChildren());

    }

    public void ordetableBtOnAction(ActionEvent actionEvent) throws IOException {
        tablepanel.getChildren().clear();
        AnchorPane registerItemForm = (AnchorPane) FXMLLoader.load(this.getClass().getResource("/lk/ijse/supermarketsystem/view/adminview/adminotherpage/tables/OrderTableView.fxml"));
        tablepanel.getChildren().addAll(registerItemForm.getChildren());
    }




}
