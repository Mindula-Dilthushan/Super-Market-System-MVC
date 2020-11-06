package lk.ijse.supermarketsystem.dto;

public class CustomerDTO {
    private String custid;
    private String custtitle;
    private String custname;
    private String custaddress;
    private String city;
    private String province;
    private String postalcode;

    public CustomerDTO(String custid, String custtitle, String custname, String custaddress, String city, String province, String postalcode) {
        this.custid = custid;
        this.custtitle = custtitle;
        this.custname = custname;
        this.custaddress = custaddress;
        this.city = city;
        this.province = province;
        this.postalcode = postalcode;
    }

    public CustomerDTO() {
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    //-------------------------------------------------
    public String getCusttitle() {
        return custtitle;
    }

    public void setCusttitle(String custtitle) {
        this.custtitle = custtitle;
    }

    //-------------------------------------------------
    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    //-------------------------------------------------
    public String getCustaddress() {
        return custaddress;
    }

    public void setCustaddress(String custaddress) {
        this.custaddress = custaddress;
    }

    //-------------------------------------------------
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    //-------------------------------------------------
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    //-------------------------------------------------
    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    //-------------------------------------------------

}
