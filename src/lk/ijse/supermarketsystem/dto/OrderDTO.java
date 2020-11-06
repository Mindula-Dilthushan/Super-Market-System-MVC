package lk.ijse.supermarketsystem.dto;

import java.util.ArrayList;

public class OrderDTO {
    private String orderid;
    private String orderdate;
    private String custid;
    private ArrayList<OrderDetailDTO>orderDetailDTOArrayList;

    public OrderDTO(String orderid, String orderdate, String custid,ArrayList<OrderDetailDTO> orderDetailDTOArrayList) {
        this.orderid = orderid;
        this.orderdate = orderdate;
        this.custid = custid;
        this.orderDetailDTOArrayList = orderDetailDTOArrayList;

    }



    public OrderDTO(){

    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
      this.custid = custid;
   }
   public ArrayList<OrderDetailDTO> getOrderDetailDTOArrayList() { return orderDetailDTOArrayList; }
   public void setOrderDetailDTOArrayList(ArrayList<OrderDetailDTO> orderDetailDTOArrayList) {
        this.orderDetailDTOArrayList = orderDetailDTOArrayList;
    }
}
