package lk.ijse.supermarketsystem.DBController;

import lk.ijse.supermarketsystem.dbconnection.DBConnection;
import lk.ijse.supermarketsystem.dto.OrderDTO;
import lk.ijse.supermarketsystem.dto.OrderDTO2;

import java.sql.*;
import java.util.ArrayList;

public class OrderController {
    public static String getLastOrderId() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT orderid FROM ordertable ORDER BY orderid DESC LIMIT 1");
        return rst.next() ? rst.getString("orderid") : null;
    }

    public static boolean addOrder(OrderDTO orderDTO) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement stm = connection.prepareStatement("INSERT INTO orderid values(?,?,?)");
            stm.setObject(1, orderDTO.getOrderid());
            stm.setObject(2, orderDTO.getOrderdate());
            stm.setObject(3, orderDTO.getCustid());
            boolean isAdded = stm.executeUpdate() > 0;
            if (isAdded) {
                boolean isAddedDetails = OrderDetailController.addOrderDetail(orderDTO.getOrderDetailDTOArrayList());
                if (isAddedDetails) {
                    boolean isUpdateStock = ItemController.updateStock(orderDTO.getOrderDetailDTOArrayList());
                    if (isUpdateStock) {
                        connection.commit();
                        return true;
                    }
                }
            }
            connection.rollback();
            return false;
        } finally {
            connection.setAutoCommit(true);
        }

    }
    public static ArrayList<OrderDTO2> orderdata() throws SQLException,ClassNotFoundException {
        ResultSet set = DBConnection.getInstance().getConnection().createStatement().executeQuery("Select * FROM ordertable");
        ArrayList<OrderDTO2> List = new ArrayList<>();

        while (set.next()){
            OrderDTO2 obg = new OrderDTO2(set.getString("orderid"),set.getString("orderdate"),set.getString("custid"));
            List.add(obg);
        }
        System.out.println("Data Refresh");
        return List;
    }
}
