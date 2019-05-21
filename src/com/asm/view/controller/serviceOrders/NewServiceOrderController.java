package com.asm.view.controller.serviceOrders;

import com.asm.interactors.ClientInteractor;
import com.asm.interactors.EmployeeInteractor;
import com.asm.view.controller.properties.AutomobileProperty;
import com.asm.view.controller.properties.ClientProperty;
import com.asm.view.controller.properties.EmployeeProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class NewServiceOrderController implements Initializable {
    private ClientInteractor clientInteractor;
    private EmployeeInteractor employeeInteractor;
    private ObservableList<ClientProperty> clientData;
    private ObservableList<EmployeeProperty> emplooyeeData;
    private ScrollPane mainScrollPane;
    @FXML private TextField orderTypeInput;
    @FXML private TextArea orderDescriptionInput;
    @FXML private ComboBox<SelectClientObj> selectClient;
    @FXML private ComboBox<String> selectEmployee;
    @FXML private ComboBox<String> clientsCars;
    @FXML private DatePicker finishDate;
    @FXML private TextField priceTag;

    private class SelectClientObj {
        private String id;
        private String name;
        private List<AutomobileProperty> cars;

        public SelectClientObj(String id, String name, List<AutomobileProperty> cars) {
            this.id = id;
            this.name = name;
            this.cars = cars;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public ObservableList<ClientProperty> getClientData() {
        return clientData;
    }

    public void cancelNewOrder(MouseEvent mouseEvent) {
        goToServiceHomeView();
    }

    public void newOrderOnClick(MouseEvent mouseEvent) {
        goToServiceHomeView();
    }

    public void init(ScrollPane mainScrollPane) {
        this.mainScrollPane = mainScrollPane;
    }

    private void goToServiceHomeView() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/services.fxml"));
        try {
            Parent root = loader.load();
            ServiceOrdersController serviceOrdersController = loader.getController();
            serviceOrdersController.init(mainScrollPane);
            this.mainScrollPane.setContent(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

        mainScrollPane.setFitToWidth(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        this.clientInteractor = new ClientInteractor();
        this.employeeInteractor = new EmployeeInteractor();
        try {
            this.clientData = FXCollections.observableArrayList(clientInteractor.readClientsAsProperty());
            this.emplooyeeData = FXCollections.observableArrayList(employeeInteractor.readAllEmployees());
            for (int i = 0; i < clientData.size(); i++) {
                System.out.println();
                selectClient.getItems().add(new SelectClientObj(clientData.get(i).getID(), clientData.get(i).getFirstName() + " " + clientData.get(i).getSurnames(), clientData.get(i).getCars()));
            }
            for (int k = 0; k < emplooyeeData.size(); k++) {
                selectEmployee.getItems().add(emplooyeeData.get(k).getName() + " " + emplooyeeData.get(k).getSurnames());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void comboAction(ActionEvent event) {
        List<AutomobileProperty> cars = selectClient.getValue().cars;
        for (int i = 0; i < cars.size(); i++) {
            clientsCars.getItems().add(cars.get(i).getModel() + " - " + cars.get(i).getBrand());
        }
    }
}
