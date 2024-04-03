package edu.miu.productmgmtapp.domain;
import java.time.LocalDate;

public class Product {
    private long productId;
    private String name;
    private LocalDate dateSupplied;
    private float quantityInStock;
    private float unitPrice;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateSupplied() {
        return dateSupplied;
    }

    public void setDateSupplied(LocalDate dateSupplied) {
        this.dateSupplied = dateSupplied;
    }

    public float getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(float quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }



    //default constructor
    public Product() {
    }

    // constructor with all the attributes
    public Product(long productId, String name, LocalDate dateSupplied, float quantityInStock, float unitPrice) {
        this.productId = productId;
        this.name = name;
        this.dateSupplied = dateSupplied;
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
    }

    // constructor without productId
    public Product( String name, LocalDate dateSupplied, float quantityInStock, float unitPrice) {
        this.name = name;
        this.dateSupplied = dateSupplied;
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
    }

}
