package lk.ijse.supermarketsystem.dto;

public class ItemDTO {
    private String itemcode;
    private String itemdescription;
    private String packsize;
    private String unitprice;
    private String qtyonhand;

    public ItemDTO(String itemcode, String itemdescription, String packsize, String unitprice, String qtyonhand) {
        this.itemcode = itemcode;
        this.itemdescription = itemdescription;
        this.packsize = packsize;
        this.unitprice = unitprice;
        this.qtyonhand = qtyonhand;
    }

    public ItemDTO(){
    }

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

    public String getPacksize() {
        return packsize;
    }

    public void setPacksize(String packsize) {
        this.packsize = packsize;
    }

    public String getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(String unitprice) {
        this.unitprice = unitprice;
    }

    public String getQtyonhand() {
        return qtyonhand;
    }

        public void setQtyonhand(String qtyonhand) {
        this.qtyonhand = qtyonhand;
    }
}
