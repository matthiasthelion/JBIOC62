package org.portaltasks.productmgmt;

import java.util.List;

public class Product {
    public Product(String SKUID, String productName, double price) {
        this.productName = productName;
        this.SKUID = SKUID;
        this.price = price;
    }

    private String SKUID;
    private String productName;
    private double price;

    public String getSKUID() {
        return SKUID;
    }

    public void setSKUID(String SKUID) {
        this.SKUID = SKUID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "SKUID='" + SKUID + '\'' +
                ", productName='" + productName + '\'' +
                ", price='£" + price + '\''+
                '}';
    }
}
