package com.asm.view.controller.properties;

import com.asm.entities.Automobile;
import com.asm.entities.client.Client;
import com.asm.entities.order.Piece;
import com.asm.entities.order.Service;
import com.asm.entities.order.Status;
import com.asm.entities.worker.Employee;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;
import java.util.List;

public class OrderProperty {


    private StringProperty id;
    private StringProperty client;
    private StringProperty automobile;
    private StringProperty service;
    private StringProperty mechanic;

    private StringProperty description;
    private StringProperty categories;
    private StringProperty extraPieces;
    private StringProperty hourlyRequiredTime;
    private StringProperty price;
    private StringProperty startDate;
    private StringProperty status;
    private StringProperty orderScore;

    public OrderProperty(String id, String client,
                         String automobile, String service,
                         String mechanic, String description,
                         String categories, String extraPieces,
                         String hourlyRequiredTime, String price,
                         String startDate, String status,
                         String orderScore) {
        this.id = new SimpleStringProperty(id);
        this.client = new SimpleStringProperty(client);
        this.automobile = new SimpleStringProperty(automobile);
        this.service = new SimpleStringProperty(service);
        this.mechanic = new SimpleStringProperty(mechanic);
        this.description = new SimpleStringProperty(description);
        this.categories = new SimpleStringProperty(categories);
        this.extraPieces = new SimpleStringProperty(extraPieces);
        this.hourlyRequiredTime = new SimpleStringProperty(hourlyRequiredTime);
        this.price = new SimpleStringProperty(price);
        this.startDate = new SimpleStringProperty(startDate);
        this.status = new SimpleStringProperty(status);
        this.orderScore = new SimpleStringProperty(orderScore);
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


    public String getDescription() {
        return description.get();
    }

    public String getClient() {
        return client.get();
    }

    public StringProperty clientProperty() {
        return client;
    }

    public void setClient(String client) {
        this.client.set(client);
    }

    public String getAutomobile() {
        return automobile.get();
    }

    public StringProperty automobileProperty() {
        return automobile;
    }

    public void setAutomobile(String automobile) {
        this.automobile.set(automobile);
    }

    public String getService() {
        return service.get();
    }

    public StringProperty serviceProperty() {
        return service;
    }

    public void setService(String service) {
        this.service.set(service);
    }

    public String getMechanic() {
        return mechanic.get();
    }

    public StringProperty mechanicProperty() {
        return mechanic;
    }

    public void setMechanic(String mechanic) {
        this.mechanic.set(mechanic);
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getCategories() {
        return categories.get();
    }

    public StringProperty categoriesProperty() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories.set(categories);
    }

    public String getExtraPieces() {
        return extraPieces.get();
    }

    public StringProperty extraPiecesProperty() {
        return extraPieces;
    }

    public void setExtraPieces(String extraPieces) {
        this.extraPieces.set(extraPieces);
    }

    public String getHourlyRequiredTime() {
        return hourlyRequiredTime.get();
    }

    public StringProperty hourlyRequiredTimeProperty() {
        return hourlyRequiredTime;
    }

    public void setHourlyRequiredTime(String hourlyRequiredTime) {
        this.hourlyRequiredTime.set(hourlyRequiredTime);
    }

    public String getPrice() {
        return price.get();
    }

    public StringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public String getStartDate() {
        return startDate.get();
    }

    public StringProperty startDateProperty() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate.set(startDate);
    }



    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public String getOrderScore() {
        return orderScore.get();
    }

    public StringProperty orderScoreProperty() {
        return orderScore;
    }

    public void setOrderScore(String orderScore) {
        this.orderScore.set(orderScore);
    }
}
