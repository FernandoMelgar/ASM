package com.asm.view.controller.properties;

import com.asm.entities.worker.Genre;
import com.asm.entities.worker.SalaryInfo;
import com.asm.entities.worker.workhistory.WorkHistory;
import com.sun.xml.internal.bind.v2.model.core.ID;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;
import java.util.List;

public class EmployeeProperty {


    private StringProperty id;
    private StringProperty name;
    private StringProperty surnames;
    private StringProperty genre;
    private StringProperty birthDate;
    private StringProperty rfc;
    private StringProperty email;
    private StringProperty phone;
    private StringProperty address;
    private StringProperty position;
    private StringProperty speciality;
    private SalaryInfo paysheet;
    private int qualification;
    private StringProperty active;

    public EmployeeProperty(String id, String name,
                            String surnames, String birthDate,
                            Genre genre, String rfc,
                            String email, String phone,
                            String address, String position,
                            String speciality, String active) {

        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.surnames = new SimpleStringProperty(surnames);
        this.birthDate = new SimpleStringProperty(birthDate);
        this.genre = new SimpleStringProperty(genre.toString());
        this.rfc = new SimpleStringProperty(rfc);
        this.email = new SimpleStringProperty(email);
        this.phone = new SimpleStringProperty(phone);
        this.address = new SimpleStringProperty(address);
        this.position = new SimpleStringProperty(position);
        this.speciality = new SimpleStringProperty(speciality);
        this.active = new SimpleStringProperty(active);

    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
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

    public String getBirthDate() {
        return birthDate.get();
    }

    public StringProperty birthDateProperty() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate.set(birthDate);
    }

    public String getGenre() {
        return genre.get();
    }

    public StringProperty genreProperty() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre.set(genre);
    }

    public String getRfc() {
        return rfc.get();
    }

    public StringProperty rfcProperty() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc.set(rfc);
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

    public String getPhone() {
        return phone.get();
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
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

    public String getPosition() {
        return position.get();
    }

    public StringProperty positionProperty() {
        return position;
    }

    public void setPosition(String position) {
        this.position.set(position);
    }

    public String getSpeciality() {
        return speciality.get();
    }

    public StringProperty specialityProperty() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality.set(speciality);
    }

    public SalaryInfo getPaysheet() {
        return paysheet;
    }

    public void setPaysheet(SalaryInfo paysheet) {
        this.paysheet = paysheet;
    }

    public int getQualification() {
        return qualification;
    }

    public void setQualification(int qualification) {
        this.qualification = qualification;
    }

    public String getActive() {
        return active.get();
    }

    public StringProperty activeProperty() {
        return active;
    }

    public void setActive(String active) {
        this.active.set(active);
    }
}