package com.asm.entities.worker;


import com.asm.entities.worker.salaries.SalaryIteration;
import com.asm.entities.worker.salaries.SalaryType;
import com.asm.entities.worker.workhistory.WorkHistory;
import javafx.scene.control.DatePicker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Employee {

    private String id;

    private String name;
    private String surnames;
    private String birthDate;
    private Genre genre;
    private String rfc;
    private String email;
    private String phone;
    private String address;
    private String position;
    private String specialities;
    private List<WorkHistory> workHistory;
    private SalaryInfo paysheet;
    private String nss;

    public Employee() {
        this.id = "";
        this.name = "";
        this.surnames = "";
        this.genre = Genre.Otro;
        this.rfc = "";
        this.email = "";
        this.phone = "";
        this.address = "";
        this.position = "";
        this.workHistory = new ArrayList<>();
        this.paysheet = new SalaryInfo("0", SalaryType.NOTSET, SalaryIteration.Sin_Establecer);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }


    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSpecialities() {
        return specialities;
    }

    public void setSpecialities(String specialities) {
        this.specialities = specialities;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public List<WorkHistory> getWorkHistory() {
        return workHistory;
    }

    public void setWorkHistory(List<WorkHistory> workHistory) {
        this.workHistory = workHistory;
    }

    public SalaryInfo getPaysheet() {
        return paysheet;
    }

    public void setPaysheet(SalaryInfo paysheet) {
        this.paysheet = paysheet;
    }
}
