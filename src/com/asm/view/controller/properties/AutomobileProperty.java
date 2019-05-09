package com.asm.view.controller.properties;

import javafx.beans.property.*;

public class AutomobileProperty {
    private static int folio = 0;
    private IntegerProperty ID;
    private StringProperty brand;
    private StringProperty model;
    private IntegerProperty year;
    private StringProperty licencePlate;
    private StringProperty serailNumber;
    private LongProperty currentKm;

    public AutomobileProperty(String brand, String model) {
        folio ++;
        this.ID = new SimpleIntegerProperty(folio);
        this.brand = new SimpleStringProperty(brand);
        this.model = new SimpleStringProperty(model);
        this.licencePlate = new SimpleStringProperty("");
        this.serailNumber = new SimpleStringProperty("");
        this.year = new SimpleIntegerProperty();
        this.currentKm = new SimpleLongProperty();
    }

    public AutomobileProperty(String brand, String model, String licencePlate) {
        folio ++;
        this.ID = new SimpleIntegerProperty(folio);
        this.brand = new SimpleStringProperty(brand);
        this.model = new SimpleStringProperty(model);
        this.licencePlate = new SimpleStringProperty(licencePlate);
        this.serailNumber = new SimpleStringProperty("");
        this.year = new SimpleIntegerProperty();
        this.currentKm = new SimpleLongProperty();
    }

    public AutomobileProperty(String brand, String model, String licencePlate, String serialNumber) {
        folio ++;
        this.ID = new SimpleIntegerProperty(folio);
        this.brand = new SimpleStringProperty(brand);
        this.model = new SimpleStringProperty(model);
        this.licencePlate = new SimpleStringProperty(licencePlate);
        this.serailNumber = new SimpleStringProperty(serialNumber);
        this.year = new SimpleIntegerProperty();
        this.currentKm = new SimpleLongProperty();
    }

    public AutomobileProperty(String brand, String model, int year, String licencePlate, String serialNumber, long currentKm) {
        folio ++;
        this.ID = new SimpleIntegerProperty(folio);
        this.brand = new SimpleStringProperty(brand);
        this.model = new SimpleStringProperty(model);
        this.year = new SimpleIntegerProperty(year);
        this.licencePlate = new SimpleStringProperty(licencePlate);
        this.serailNumber = new SimpleStringProperty(serialNumber);
        this.currentKm = new SimpleLongProperty(currentKm);
    }

    public int getID() {
        return ID.get();
    }

    public IntegerProperty IDProperty() {
        return ID;
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

    public int getYear() {
        return year.get();
    }

    public IntegerProperty yearProperty() {
        return year;
    }

    public void setYear(int year) {
        this.year.set(year);
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

    public String getSerailNumber() {
        return serailNumber.get();
    }

    public StringProperty serailNumberProperty() {
        return serailNumber;
    }

    public void setSerailNumber(String serailNumber) {
        this.serailNumber.set(serailNumber);
    }

    public long getCurrentKm() {
        return currentKm.get();
    }

    public LongProperty currentKmProperty() {
        return currentKm;
    }

    public void setCurrentKm(long currentKm) {
        this.currentKm.set(currentKm);
    }
}
