package com.asm.view.controller.properties;

import javafx.beans.property.*;

import java.util.ArrayList;
import java.util.List;


public class ClientProperty {
    private StringProperty ID;
    private StringProperty firstName;
    private StringProperty surnames;
    private StringProperty email;
    private StringProperty phoneNumber;
    private StringProperty address;
    private List<AutomobileProperty> cars;


    public ClientProperty(String ID, String firstName, String surnames, String email, String phoneNumber, String address, List<AutomobileProperty> cars) {
        this.ID = new SimpleStringProperty(ID);
        this.firstName = new SimpleStringProperty(firstName);
        this.surnames = new SimpleStringProperty(surnames);
        this.email = new SimpleStringProperty(email);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.address = new SimpleStringProperty(address);
        this.cars = cars;
    }

    public ClientProperty(String ID, String firstName, String surnames, List<AutomobileProperty> cars) {
        this.ID = new SimpleStringProperty(ID);
        this.firstName = new SimpleStringProperty(firstName);
        this.surnames = new SimpleStringProperty(surnames);
        this.cars = cars;
    }

    public ClientProperty(){

        this.cars = new ArrayList<>();
        AutomobileProperty c1 = new  AutomobileProperty("ID","Brand","Model","Year","Plate","Serial","Kilometes");
        AutomobileProperty c2 = new  AutomobileProperty("ID","Brand","Model","Year","Plate","Serial","Kilometes");
        this.cars.add(c1);
        this.cars.add(c2);
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

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getSurnames() {
        return surnames.get();
    }

    public void setSurnames(String surnames) {
        this.surnames.set(surnames);
    }

    public StringProperty surnamesProperty() {
        return surnames;
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public String getCarElementsToString() {
        String elements = new String();
        for(int i = 0; i < cars.size(); i++) {
            elements += cars.get(i).getBrand() + " - " + cars.get(i).getModel();
            if (i != cars.size() - 1) {
                elements += "\n";
            }
        }
        return elements;
    }

    public List<AutomobileProperty> getCars() {
        return cars;
    }

    public void setCars(List<AutomobileProperty> cars) {
        this.cars = cars;
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    @Override
    public String toString() {
        return firstName.getValue() + " " + surnames.getValue();
    }
}
