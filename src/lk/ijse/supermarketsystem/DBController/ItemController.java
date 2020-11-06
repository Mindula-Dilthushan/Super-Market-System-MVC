package lk.ijse.supermarketsystem.DBController;

import lk.ijse.supermarketsystem.dbconnection.DBConnection;
import lk.ijse.supermarketsystem.dto.ItemDTO;
import lk.ijse.supermarketsystem.dto.OrderDetailDTO;

import java.sql.*;
import java.util.ArrayList;

public class ItemController {

    //----------------------------------------------------------------------------------------------------------------------------------------------

    public static boolean itemInfo(ItemDTO data) throws ClassNotFoundException,SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO itemtable(itemcode,itemdescription,packsize,unitprice,qtyonhand) VALUES (?,?,?,?,?)");
        stm.setObject(1,data.getItemcode());
        stm.setObject(2,data.getItemdescription());
        stm.setObject(3,data.getPacksize());
        stm.setObject(4,data.getUnitprice());
        stm.setObject(5,data.getQtyonhand());
        int res = stm.executeUpdate();
        return res>0;
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------

    public static boolean updateStock(ArrayList<OrderDetailDTO> orderDetailArrayList) throws ClassNotFoundException,SQLException{
        for (OrderDetailDTO orderDetailDTO :orderDetailArrayList ) {
            boolean isUpdate=updateStock(orderDetailDTO);
            if(!isUpdate){
                return false;
            }
        }
        return true;
    }
    public static boolean updateStock(OrderDetailDTO orderDetailDTO) throws ClassNotFoundException, SQLException{
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("update itemtable set qtyonhand=qtyonhand-? where itemcode=?");
        stm.setObject(1, orderDetailDTO.getOrderqty());
        stm.setObject(2, orderDetailDTO.getItemCode());
        return stm.executeUpdate()>0;
    }
    public static ArrayList<ItemDTO> loadAllItems() throws ClassNotFoundException, SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Item");

        ArrayList<ItemDTO> alItems = new ArrayList<>();

        while (rst.next()) {

            ItemDTO item = new ItemDTO();
            item.setItemcode(rst.getString(1));
            item.setItemdescription(rst.getString(2));
            item.setPacksize(rst.getString(3));
            item.setUnitprice(rst.getString(4));
            item.setQtyonhand(rst.getString(5));

            alItems.add(item);
        }

        return alItems;

    }



    //----------------------------------------------------------------------------------------------------------------------------------------------

    public static ItemDTO searchItem(String itemcode) throws ClassNotFoundException, SQLException{
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("Select * From itemtable where itemcode=?");
        stm.setObject(1, itemcode);
        ResultSet rst = stm.executeQuery();
        if(rst.next()){
            ItemDTO data=new ItemDTO(rst.getString("itemcode"), rst.getString("itemdescription"), rst.getString("packsize"), rst.getString("unitprice"), rst.getString("qtyonhand"));
            return data;
        }
        return null;
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------

    public static boolean updateItem(ItemDTO data) throws ClassNotFoundException, SQLException{
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("Update itemtable set itemdescription=?, packsize=?, unitprice=?,qtyonhand=? where itemcode=?");

        stm.setObject(1, data.getItemdescription());
        stm.setObject(2, data.getPacksize());
        stm.setObject(3, data.getUnitprice());
        stm.setObject(4, data.getQtyonhand());
        stm.setObject(5, data.getItemcode());
        return stm.executeUpdate()>0;
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------

    public static boolean itemdelete(String itemcode) throws ClassNotFoundException, SQLException{
        return DBConnection.getInstance().getConnection().createStatement().executeUpdate("Delete From itemtable where itemcode='"+itemcode+"'")>0;
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------

    public static ArrayList<ItemDTO> itemdata() throws SQLException,ClassNotFoundException {
        ResultSet set = DBConnection.getInstance().getConnection().createStatement().executeQuery("Select * FROM itemtable");
        ArrayList<ItemDTO> List = new ArrayList<>();

        while (set.next()){
            ItemDTO obg = new ItemDTO(set.getString("itemcode"),set.getString("itemdescription"),set.getString("packsize"),set.getString("unitprice"),set.getString("qtyonhand"));
            List.add(obg);
        }
        System.out.println("Data Refresh");
        return List;
    }

}