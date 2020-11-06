package lk.ijse.supermarketsystem.dto;

public class CashierDTO {
    private String itemcode;
    private String itemdescription;
    private int unitprice;
    private int qtyonhand;
    private double discount;


    public CashierDTO(String itemcode, String itemdescription, int unitprice, int qtyonhand, double discount) {
        this.itemcode = itemcode;
        this.itemdescription = itemdescription;
        this.unitprice = unitprice;
        this.qtyonhand = qtyonhand;
        this.discount = discount;
    }

    public CashierDTO(){}

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public String getItemdescription() {
        return itemdescription;
    }

    public void setItemdescription(String itemdescription) {
        this.itemdescription = itemdescription;
    }


    public int getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(int unitprice) {
        this.unitprice = unitprice;
    }

    public int getQtyonhand() {
        return qtyonhand;
    }

    public void setQtyonhand(int qtyonhand) {
        this.qtyonhand = qtyonhand;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
