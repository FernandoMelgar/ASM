package com.asm.view.controller.properties;

import javafx.beans.property.*;

import java.util.ArrayList;
import java.util.List;


public class ClientProperty {
    private StringProperty ID;
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty email;
    private StringProperty phoneNumber;
    private StringProperty address;
    private List<AutomobileProperty> car;


    public ClientProperty(String ID, String firstName, String lastName, String email, String phoneNumber) {
        this.ID = new SimpleStringProperty(ID);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.email = new SimpleStringProperty(email);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.car = new ArrayList<>();
        AutomobileProperty c = new  AutomobileProperty("Audi", "Q5");
        this.car.add(c);
    }

    public ClientProperty(){

        this.car = new ArrayList<>();
        AutomobileProperty c = new  AutomobileProperty("Audi", "Q5");
        this.car.add(c);
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

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
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
        for(int i=0; i < car.size(); i++) {
            elements += car.get(i).getBrand() + " - " + car.get(i).getModel();
            if (i != car.size() - 1) {
                elements += "\n";
            }
        }
        return elements;
    }

    public List<AutomobileProperty> getCar() {
        return car;
    }

    public void setCar(List<AutomobileProperty> car) {
        this.car = car;
    }
}
