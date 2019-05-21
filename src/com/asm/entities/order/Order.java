package com.asm.entities.order;

import com.asm.entities.Automobile;
import com.asm.entities.client.Client;
import com.asm.entities.worker.Employee;
import javafx.scene.control.ComboBox;

import java.time.chrono.Chronology;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private long id;
    private Client client;
    private Automobile automobile;
    private Service service;
    private Employee mechanic;

    private String description;
    private List<String> categories;
    private List<Piece> extraPieces;
    private double hourlyRequiredTime;
    private double price;
    private Date startDate;
    private Date endDate;
    private Status status;
    private double orderScore;

    public Order(Client client, Automobile automobile, Employee mechanic, String description, double price, Date startDate, Date endDate, Status status) {
        this.client = client;
        this.automobile = automobile;
        this.mechanic = mechanic;
        this.description = description;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Order(Service service, Client client, Automobile automobile) {
        this.service = service;
        this.client = client;
        this.automobile = automobile;
        this.status = Status.UNFINISHED;
        this.categories = new ArrayList<>();
        this.extraPieces = new ArrayList<>();
        this.hourlyRequiredTime = service.hourlyTimeNeed;
        this.price = calculateBasePrice();
        this.description = "";
        this.orderScore = 3.0;

    }

    private double calculateBasePrice() {
        return 0.0;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<Piece> getExtraPieces() {
        return extraPieces;
    }

    public void setExtraPieces(List<Piece> extraPieces) {
        this.extraPieces = extraPieces;
    }

    public double getHourlyRequiredTime() {
        return hourlyRequiredTime;
    }

    public void setHourlyRequiredTime(double hourlyRequiredTime) {
        this.hourlyRequiredTime = hourlyRequiredTime;
    }

    public void addHourlyTime(int i) {
        this.hourlyRequiredTime += i;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Employee getMechanic() {
        return mechanic;
    }

    public void setMechanic(Employee mechanic) {
        this.mechanic = mechanic;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public int getBasePrice() {
        int basePrice = sumServicePiecesPrice();
        basePrice += sumExtraPieces();
        return  basePrice;
    }

    private int sumExtraPieces() {
        int sum = 0;
        for (Piece p: this.extraPieces){
            sum += p.neededItems * p.price;
        }

        return sum;

    }

    private int sumServicePiecesPrice() {
        int sum = 0;

        for (Piece p: this.service.needPieces){
            sum += p.neededItems * p.price;
        }

        return sum;
    }

    public void subtractHourlyTime(int i) {
        this.hourlyRequiredTime -= i;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getOrderScore() {
        return orderScore;
    }

    public void setOrderScore(double orderScore) {
        this.orderScore = orderScore;
    }

    public Automobile getAutomobile() {
        return automobile;
    }

    public void setAutomobile(Automobile automobile) {
        this.automobile = automobile;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client=" + client.getName() + " " + client.getSurnames() +
                ", automobile=" + automobile +
                ", service=" + service +
                ", mechanic=" + mechanic +
                ", description='" + description + '\'' +
                ", categories=" + categories +
                ", extraPieces=" + extraPieces +
                ", hourlyRequiredTime=" + hourlyRequiredTime +
                ", price=" + price +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                ", orderScore=" + orderScore +
                '}';
    }
}