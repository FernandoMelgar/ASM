package com.asm.entities.order;

public class Piece {
    public String name;
    public String model;
    public String brand;
    public String description;
    public double price;
    public int neededItems;

    public Piece() {
        this.model = "";
        this.brand = "";
        this.description = "";
        this.price = 0.0;
        this.neededItems = 1;
    }

}
