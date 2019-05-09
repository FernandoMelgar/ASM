package com.asm.entities.order;

import java.util.ArrayList;
import java.util.List;

public class Service {

    public String name;
    public String description;
    public double price;
    public List<Piece> needPieces;
    public double hourlyTimeNeed;

    public Service(String name, double price, double hourlyTimeNeed) {
        this.name = name;
        this.description = "";
        this.price = price;
        this.hourlyTimeNeed = hourlyTimeNeed;
        this.needPieces = new ArrayList<>();
    }
}
