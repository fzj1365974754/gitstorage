package com.domain;

public class Products {
    private int productid;
    private String productname;
    private String englishname;
    private float unitprice;
    private String supplierid;

    @Override
    public String toString() {
        return "products{" +
                "productid=" + productid +
                ", productname='" + productname + '\'' +
                ", englishname='" + englishname + '\'' +
                ", unitprice=" + unitprice +
                ", supplierid='" + supplierid + '\'' +
                '}';
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getEnglishname() {
        return englishname;
    }

    public void setEnglishname(String englishname) {
        this.englishname = englishname;
    }

    public float getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(float unitprice) {
        this.unitprice = unitprice;
    }

    public String getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(String supplierid) {
        this.supplierid = supplierid;
    }
}
