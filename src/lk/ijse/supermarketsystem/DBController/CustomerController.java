package lk.ijse.supermarketsystem.DBController;

import lk.ijse.supermarketsystem.dbconnection.DBConnection;
import lk.ijse.supermarketsystem.dto.CustomerDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerController {


    //----------------------------------------------------------------------------------------------------------------------------------------------

    public static boolean customerInfo(CustomerDTO data) throws ClassNotFoundException,SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO customertable(custid,custtitle,custname,custaddress,city,province,postalcode) VALUES (?,?,?,?,?,?,?)");
        stm.setObject(1,data.getCustid());
        stm.setObject(2,data.getCusttitle());
        stm.setObject(3,data.getCustname());
        stm.setObject(4,data.getCustaddress());
        stm.setObject(5,data.getCity());
        stm.setObject(6,data.getProvince());
        stm.setObject(7,data.getPostalcode());
        int res = stm.executeUpdate();
        return res>0;
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------

    public static CustomerDTO searchCustomer(String custid) throws ClassNotFoundException, SQLException{
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM customertable WHERE custid=?");
        stm.setObject(1, custid);
        ResultSet rst = stm.executeQuery();
        if(rst.next()){
            CustomerDTO data=new CustomerDTO(rst.getString("custid"), rst.getString("custtitle"), rst.getString("custname"), rst.getString("custaddress"), rst.getString("city"), rst.getString("province"), rst.getString("postalcode"));
            return data;
        }
        return null;
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------

    public static boolean updateCustomer(CustomerDTO data) throws ClassNotFoundException, SQLException{
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("UPDATE customertable SET custtitle=?, custname=?, custaddress=?, city=?, province=?, postalcode=? where custid=?");
        stm.setObject(1, data.getCusttitle());
        stm.setObject(2, data.getCustname());
        stm.setObject(3, data.getCustaddress());
        stm.setObject(4, data.getCity());
        stm.setObject(5, data.getProvince());
        stm.setObject(6, data.getPostalcode());
        return stm.executeUpdate()>0;
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------

    public static boolean deleteCustomer(String custid) throws ClassNotFoundException, SQLException{
        return DBConnection.getInstance().getConnection().createStatement().executeUpdate("DELETE FROM customertable WHERE custid='"+custid+"'")>0;
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------

    public static ArrayList<CustomerDTO> customerdata() throws SQLException,ClassNotFoundException {
        ResultSet set = DBConnection.getInstance().getConnection().createStatement().executeQuery("SELECT * FROM customertable");
        ArrayList<CustomerDTO> List = new ArrayList<>();

        while (set.next()){
            CustomerDTO obg = new CustomerDTO(set.getString("custid"),set.getString("custtitle"),set.getString("custname"),set.getString("custaddress"),set.getString("city"),set.getString("province"),set.getString("postalcode"));
            List.add(obg);
        }
        System.out.println("Data Refresh");
        return List;
    }


}
