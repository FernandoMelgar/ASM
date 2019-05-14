package com.asm.entities.client;


import com.asm.entities.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private String id;
    private String name;
    private String surnames;
    private String phone;
    private String email;
    private String address;
    private List<String> cars;

    public Client() {
//        this.id = "";
        this.name = "";
        this.surnames = "";
        this.phone = "";
        this.address = "";
        this.email = "";
        this.cars = new ArrayList<>();
    }

    public Client(String name, String lastname, String email) {
//        this.id = "";
        this.name = name;
        this.email = email;
        this.surnames = "Defaul";
        this.phone = "4565";
        this.address = "";
        this.cars = new ArrayList<>();
    }

    public Client(String name, String lastname) {
//        this.id = "";
        this.name = name;
        this.email = "defaul@gmail.com";
        this.surnames = "Default";
        this.phone = "1234";
        this.address = "Defualt defualt fault";
        this.cars = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surnames='" + surnames + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", cars=" + cars +
                '}';
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

    public List<String> getCars() {
        return cars;
    }

    public void setCars(List<String> cars) {
        this.cars = cars;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


}