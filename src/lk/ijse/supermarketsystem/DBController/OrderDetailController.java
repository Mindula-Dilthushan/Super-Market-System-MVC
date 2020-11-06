package lk.ijse.supermarketsystem.DBController;

import lk.ijse.supermarketsystem.dbconnection.DBConnection;
import lk.ijse.supermarketsystem.dto.OrderDetailDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailController {
    public static boolean addOrderDetail(ArrayList<OrderDetailDTO> orderDetailArrayList) throws ClassNotFoundException, SQLException{
        for (OrderDetailDTO orderDetailDTO : orderDetailArrayList) {
            boolean isAdded=addOrderDetail(orderDetailDTO);
            if(!isAdded){
                return false;
            }
        }
        return true;
    }
    public static boolean addOrderDetail(OrderDetailDTO orderDetailDTO)throws ClassNotFoundException, SQLException{
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("INSERT INTO orderdetailstable VALUES (?,?,?,?)");
        stm.setObject(1,orderDetailDTO.getOrderId());
        stm.setObject(2,orderDetailDTO.getItemCode());
        stm.setObject(3,orderDetailDTO.getDiscount());
        stm.setObject(4,orderDetailDTO.getOrderqty());
        return stm.executeUpdate()>0;
    }
    public static ArrayList<OrderDetailDTO> orderDetailsdata() throws SQLException,ClassNotFoundException {
        ResultSet set = DBConnection.getInstance().getConnection().createStatement().executeQuery("Select * FROM orderdetailstable");
        ArrayList<OrderDetailDTO> List = new ArrayList<>();

        while (set.next()){
            OrderDetailDTO obg = new OrderDetailDTO(set.getString("orderid"),set.getString("itemcode"),set.getInt("orderqty"),set.getDouble("discount"));
            List.add(obg);
        }
        System.out.println("Data Refresh");
        return List;
    }
}
