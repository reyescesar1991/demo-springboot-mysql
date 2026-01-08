package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {

    @JsonProperty("customer_name")
    private String customerName;

    @JsonProperty("product_name")
    private String productName;

    @JsonProperty("quantity")
    private int quantity;

    @Override
    public String toString() {
        return "Order{" +
            "customerName='" + customerName + '\'' +
            ", productName='" + productName + '\'' +
            ", quantity=" + quantity +
            '}';
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}  