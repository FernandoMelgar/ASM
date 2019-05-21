package com.asm.view.controller;

import com.asm.entities.worker.Employee;
import com.asm.interactors.ClientInteractor;
import com.asm.interactors.EmployeeInteractor;
import com.asm.view.controller.properties.ClientProperty;
import com.asm.view.controller.serviceOrders.ServiceOrdersController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DashboardController {
    private ScrollPane mainScrollPane;
    private ClientInteractor clientInteractor;
    private EmployeeInteractor employeeInteractor;

    @FXML private Label activeClientsLabel;
    @FXML private Label activeEmployeesLabel;
    @FXML private Label currentOrdersLabel;
    @FXML private Label totalIncomeLabel;

    private void setValues() {

        int currentClients;
        int currentEmployees;
        ServiceOrdersController s = new ServiceOrdersController();
        int currentOrders = s.initToGetCount();
        double totalIncome = s.getTotalIncome();

        this.clientInteractor = new ClientInteractor();
        this.employeeInteractor = new EmployeeInteractor();

        try {
            currentClients = FXCollections.observableArrayList(clientInteractor.readClientsAsProperty()).size();
            activeClientsLabel.setText(Integer.toString(currentClients));
            currentEmployees = FXCollections.observableArrayList(employeeInteractor.readAllEmployees()).size();
            activeEmployeesLabel.setText(Integer.toString(currentEmployees));
            currentOrdersLabel.setText(Integer.toString(currentOrders));
            totalIncomeLabel.setText("$"+Double.toString(totalIncome));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void activeClientsBoxOnClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/clients.fxml"));
            Parent root = loader.load();
            ClientsController clientsController = loader.getController();
            clientsController.init(mainScrollPane);
            mainScrollPane.setContent(root);
            mainScrollPane.setFitToWidth(true);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void activeEmployeesBoxOnClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/employees.fxml"));
            Parent root = loader.load();
            EmployeesController employeesController = loader.getController();
            employeesController.init(mainScrollPane);
            mainScrollPane.setContent(root);
            mainScrollPane.setFitToWidth(true);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void currentOrdersOnClick(MouseEvent event) {
        goToServiceOrders();
    }

    public void incomeBoxOnClick(MouseEvent event) {
        goToServiceOrders();
    }

    public void goToServiceOrders() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/services.fxml"));
            Parent root = loader.load();
            ServiceOrdersController serviceOrdersController = loader.getController();
            serviceOrdersController.init(mainScrollPane);
            mainScrollPane.setContent(root);
            mainScrollPane.setFitToWidth(true);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void init(ScrollPane mainScrollPane) {
        setValues();
        this.mainScrollPane = mainScrollPane;
    }
}
