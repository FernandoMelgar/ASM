package com.asm.entities.worker;


import com.asm.entities.worker.salaries.SalaryIteration;
import com.asm.entities.worker.salaries.SalaryType;
import com.asm.entities.worker.workhistory.WorkHistory;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private String id;

    private String name;
    private String surnames;
    private Genre genre;
    private String birthDate;
    private String rfc;
    private String email;
    private String phone;
    private Address address;
    private String position;
    private List<String> specialties;
    private List<WorkHistory> workHistory;
    private SalaryInfo paysheet;
    private int qualification;
    private String active;

    public Employee() {
        this.id = "";
        this.name = "";
        this.surnames = "";
        this.genre = Genre.Otro;
        this.rfc = "";
        this.email = "";
        this.phone = "";
        this.address = new Address();
        this.position = "";
        this.workHistory = new ArrayList<>();
        this.paysheet = new SalaryInfo(0, SalaryType.NOTSET, SalaryIteration.Sin_Establecer, 5553);
        this.qualification = 0;
        this.active = "true";
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


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getSpecialities() {
        return specialties;
    }

    public void setSpecialities(List<String> specialities) {
        this.specialties = specialities;
    }

    public int getQualification() {
        return qualification;
    }

    public void setQualification(int qualification) {
        this.qualification = qualification;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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
