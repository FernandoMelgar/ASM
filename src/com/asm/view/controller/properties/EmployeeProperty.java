package com.asm.view.controller.properties;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.List;

public class EmployeeProperty {

    private StringProperty ID;
    private StringProperty name;
    private StringProperty surnames;
    private StringProperty phone;
    private StringProperty activity;

    public EmployeeProperty(String ID, String name, String surnames, String phone, String activity) {
        this.ID = new SimpleStringProperty(ID);
        this.name = new SimpleStringProperty(name);
        this.surnames = new SimpleStringProperty(surnames);
        this.phone = new SimpleStringProperty(phone);
        this.activity = new SimpleStringProperty(activity);
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

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSurnames() {
        return surnames.get();
    }

    public StringProperty surnamesProperty() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames.set(surnames);
    }

    public String getPhone() {
        return phone.get();
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public String getActivity() {
        return activity.get();
    }

    public StringProperty activityProperty() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity.set(activity);
    }
}


