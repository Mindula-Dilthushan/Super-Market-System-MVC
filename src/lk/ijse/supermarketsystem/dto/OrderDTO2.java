package lk.ijse.supermarketsystem.dto;

public class OrderDTO2 {
    private String orderid;
    private String orderdate;
    private String custid;

    public OrderDTO2(String orderid, String orderdate, String custid) {
        this.orderid = orderid;
        this.orderdate = orderdate;
        this.custid = custid;
    }
    public OrderDTO2(){

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
}
