package com.example.lab2.products;

public class Product {
    private String productName;
    private Boolean isChecked;

    public Product(String productName, Boolean isChecked) {
        this.productName = productName;
        this.isChecked = isChecked;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Boolean getChecked() {
        return isChecked;
    }

    public void setChecked(Boolean checked) {
        isChecked = checked;
    }
}
