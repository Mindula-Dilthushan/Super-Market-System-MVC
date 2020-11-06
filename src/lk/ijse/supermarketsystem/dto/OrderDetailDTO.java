package lk.ijse.supermarketsystem.dto;

import lk.ijse.supermarketsystem.DBController.OrderDetailController;

public class OrderDetailDTO extends OrderDetailController {
    private String orderId;
    private String itemCode;
    private int orderqty;
    private double discount;

    public OrderDetailDTO(String orderId, String itemCode, int orderqty, double discount) {
        this.orderId = orderId;
        this.itemCode = itemCode;
        this.orderqty = orderqty;
        this.discount = discount;
    }

    public OrderDetailDTO(){

    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getOrderqty() {
        return orderqty;
    }

    public void setOrderqty(int orderqty) {
        this.orderqty = orderqty;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
