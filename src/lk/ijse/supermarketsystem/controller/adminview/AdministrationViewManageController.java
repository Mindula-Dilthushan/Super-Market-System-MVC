package lk.ijse.supermarketsystem.controller.adminview;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;



public class AdministrationViewManageController {
    public  AnchorPane managePanel;
    public JFXButton registerNewItemBT;
    public JFXButton modifyItemBT;
    public JFXButton removeItemBT;

    public void registerNewItemBtOnAction(ActionEvent actionEvent) throws IOException {
        managePanel.getChildren().clear();
        AnchorPane registerItemForm = (AnchorPane) FXMLLoader.load(this.getClass().getResource("/lk/ijse/supermarketsystem/view/adminview/RegisterNewItem.fxml"));
        managePanel.getChildren().addAll(registerItemForm.getChildren());
    }

    public void removeItemBtOnAction(ActionEvent actionEvent) throws IOException {
        managePanel.getChildren().clear();
        AnchorPane registerItemForm = (AnchorPane) FXMLLoader.load(this.getClass().getResource("/lk/ijse/supermarketsystem/view/adminview/RemoveItem.fxml"));
        managePanel.getChildren().addAll(registerItemForm.getChildren());
    }

    public void modifyItemBtOnAction(ActionEvent actionEvent) throws IOException {
        managePanel.getChildren().clear();
        AnchorPane registerItemForm = (AnchorPane) FXMLLoader.load(this.getClass().getResource("/lk/ijse/supermarketsystem/view/adminview/ModifyItem.fxml"));
        managePanel.getChildren().addAll(registerItemForm.getChildren());
    }



}
