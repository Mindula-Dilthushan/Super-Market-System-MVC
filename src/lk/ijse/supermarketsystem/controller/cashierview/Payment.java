package lk.ijse.supermarketsystem.controller.cashierview;

public class Payment {
    private int orderID;
    private String date;
    private double total;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getDate() {
        return date;
    }

    public Payment(int orderID, String date, double total) {
        this.orderID = orderID;
        this.date = date;
        this.total = total;
    }

    public Payment() {
    }

    public void setDate(String date) {
        date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
