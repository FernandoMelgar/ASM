package com.asm.entities;

public class Automobile {


    private String id;
    private String manufacture;
    private String model;
    private int year;
    private String licencePlate;
    private String serialNumber;
    private Long currentKilometers;

    public Automobile() {
        this.id = "";
        this.manufacture = "";
        this.model = "";
        this.year = 0;
        this.serialNumber = "";
        this.licencePlate = "";
        this.currentKilometers = 0L;
    }

    public Automobile(String manufacture, String model, int year) {
        this.manufacture = manufacture;
        this.model = model;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public Long getCurrentKilometers() {
        return currentKilometers;
    }

    public void setCurrentKilometers(Long currentKilometers) {
        this.currentKilometers = currentKilometers;
    }
}