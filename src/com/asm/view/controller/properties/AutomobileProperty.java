package com.asm.view.controller.properties;

import javafx.beans.property.*;

public class AutomobileProperty {
    private StringProperty ID;
    private StringProperty brand;
    private StringProperty model;
    private StringProperty year;
    private StringProperty licencePlate;
    private StringProperty serialNumber;
    private StringProperty currentKm;


    public AutomobileProperty(String ID, String brand, String model,
                              String year, String licencePlate,
                              String serialNumber, String currentKm) {
        this.ID = new SimpleStringProperty(ID);
        this.brand = new SimpleStringProperty(brand);
        this.model = new SimpleStringProperty(model);
        this.year = new SimpleStringProperty(year);
        this.licencePlate = new SimpleStringProperty(licencePlate);
        this.serialNumber = new SimpleStringProperty(serialNumber);
        this.currentKm = new SimpleStringProperty(currentKm);
    }

    public String getID() {
        return ID.get();
    }

    public StringProperty IDProperty() {
        return ID;
    }

    public void setID(String ID) {
        this.ID.set(ID);
    }

    public void setYear(String year) {
        this.year.set(year);
    }

    public void setCurrentKm(String currentKm) {
        this.currentKm.set(currentKm);
    }

    public String getBrand() {
        return brand.get();
    }

    public StringProperty brandProperty() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand.set(brand);
    }

    public String getModel() {
        return model.get();
    }

    public StringProperty modelProperty() {
        return model;
    }

    public void setModel(String model) {
        this.model.set(model);
    }


    public String getLicencePlate() {
        return licencePlate.get();
    }

    public StringProperty licencePlateProperty() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate.set(licencePlate);
    }

    public String getSerialNumber() {
        return serialNumber.get();
    }

    public StringProperty serialNumberProperty() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber.set(serialNumber);
    }

    public String getYear() {
        return year.get();
    }

    public StringProperty yearProperty() {
        return year;
    }

    public String getCurrentKm() {
        return currentKm.get();
    }

    public StringProperty currentKmProperty() {
        return currentKm;
    }
}
