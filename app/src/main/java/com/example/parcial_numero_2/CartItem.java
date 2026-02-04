package com.example.parcial_numero_2;

public class CartItem {
    private int id;
    private String modelo;
    private double unitPrice;
    private int quantity;
    private double totalPrice;

    public CartItem(int id, String modelo, double unitPrice, int quantity) {
        this.id = id;
        this.modelo = modelo;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.totalPrice = unitPrice * quantity;
    }

    // getters
    public int getId() { return id; }
    public String getModelo() { return modelo; }
    public double getUnitPrice() { return unitPrice; }
    public int getQuantity() { return quantity; }
    public double getTotalPrice() { return totalPrice; }
}
