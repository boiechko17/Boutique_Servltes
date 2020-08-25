package com.boiechko.entity;

import java.util.Objects;

public class Order_Product {

    private int idOrderProduct;
    private int idOrder;
    private int idProduct;
    private int quantity;

    public Order_Product(int idOrderProduct, int idOrder, int idProduct, int quantity) {
        this.idOrderProduct = idOrderProduct;
        this.idOrder = idOrder;
        this.idProduct = idProduct;
        this.quantity = quantity;
    }

    public Order_Product(int idOrder, int idProduct, int quantity) {
        this.idOrder = idOrder;
        this.idProduct = idProduct;
        this.quantity = quantity;
    }

    public int getIdOrderProduct() { return idOrderProduct; }

    public void setIdOrderProduct(int idOrderProduct) { this.idOrderProduct = idOrderProduct; }

    public int getIdOrder() { return idOrder; }

    public void setIdOrder(int idOrder) { this.idOrder = idOrder; }

    public int getIdProduct() { return idProduct; }

    public void setIdProduct(int idProduct) { this.idProduct = idProduct; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order_Product that = (Order_Product) o;
        return idOrderProduct == that.idOrderProduct &&
                idOrder == that.idOrder &&
                idProduct == that.idProduct &&
                quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrderProduct, idOrder, idProduct, quantity);
    }

    @Override
    public String toString() {
        return "Order_Product{" +
                "idOrderProduct=" + idOrderProduct +
                ", idOrder=" + idOrder +
                ", idProduct=" + idProduct +
                ", quantity=" + quantity +
                '}';
    }
}
