package com.asm.view.controller.serviceOrders;

import com.asm.entities.Automobile;
import com.asm.entities.client.Client;
import com.asm.entities.order.Order;
import com.asm.entities.order.Status;
import com.asm.entities.worker.Employee;
import com.asm.interactors.ClientInteractor;
import com.asm.interactors.EmployeeInteractor;
import com.asm.interactors.OrderPersistence;
import com.asm.view.controller.properties.AutomobileProperty;
import com.asm.view.controller.properties.ClientProperty;
import com.asm.view.controller.properties.EmployeeProperty;
import com.asm.view.controller.properties.OrderProperty;
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
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class NewServiceOrderController implements Initializable {
    private Order newServiceOrder;
    private ClientInteractor clientInteractor;
    private EmployeeInteractor employeeInteractor;
    private ObservableList<ClientProperty> clientData;
    private ObservableList<EmployeeProperty> emplooyeeData;
    private ScrollPane mainScrollPane;
    @FXML private TextField orderTypeInput;
    @FXML private TextArea orderDescriptionInput;
    @FXML private ComboBox<ClientProperty> selectClient;
    @FXML private ComboBox<Employee> selectEmployee;
    @FXML private ComboBox<Automobile> clientsCars;
    @FXML private DatePicker finishDate;
    @FXML private TextField priceTag;

    public ObservableList<ClientProperty> getClientData() {
        return clientData;
    }

    public void cancelNewOrder(MouseEvent mouseEvent) {
        goToServiceHomeView();
    }

    private OrderProperty createOrder() {
        OrderProperty newOrder;
        LocalDate localDate = finishDate.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Client client = new Client(selectClient.getValue().getID(), selectClient.getValue().getFirstName(), selectClient.getValue().getSurnames());
        Automobile automobile = new Automobile(clientsCars.getValue().getId(), clientsCars.getValue().getManufacture(), clientsCars.getValue().getModel());
        Employee employee = selectEmployee.getValue();
        String description = orderDescriptionInput.getText();
        Double price = Double.parseDouble(priceTag.getText());
        Order order = new Order(client, automobile, employee, description, price, new Date(), Date.from(instant), Status.UNFINISHED);
        newOrder = new OrderProperty(
                String.valueOf(order.getId()),
                order.getClient().getName() + " " + order.getClient().getSurnames(),
                order.getAutomobile().getManufacture() + " "
                        + order.getAutomobile().getModel(),
                orderTypeInput.getText(),
                order.getMechanic().getName()+ " " + order.getMechanic().getSurnames(),
                order.getDescription(),
                "Servicio Básico",
                "Sin piezas extras",
                String.valueOf(order.getHourlyRequiredTime()),
                String.valueOf(order.getPrice()),
                order.getStartDate().toString(),
                order.getStatus().toString(),
                String.valueOf(order.getOrderScore())
        );

        return newOrder;
    }

    public void newOrderOnClick(MouseEvent mouseEvent) {
        OrderProperty newOrder = createOrder();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/services.fxml"));
        try {
            Parent root = loader.load();
            ServiceOrdersController serviceOrdersController = loader.getController();
            serviceOrdersController.initWithNewOrder(mainScrollPane, newOrder);
            this.mainScrollPane.setContent(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainScrollPane.setFitToWidth(true);
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
                selectClient.getItems().add(new ClientProperty(clientData.get(i).getID(), clientData.get(i).getFirstName(), clientData.get(i).getSurnames(), clientData.get(i).getCars()));
            }
            for (int k = 0; k < emplooyeeData.size(); k++) {
                selectEmployee.getItems().add(new Employee(emplooyeeData.get(k).getId(), emplooyeeData.get(k).getName(), emplooyeeData.get(k).getSurnames()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void comboAction(ActionEvent event) {
        List<AutomobileProperty> cars = selectClient.getValue().getCars();
        for (int i = 0; i < cars.size(); i++) {
            clientsCars.getItems().add(new Automobile(cars.get(i).getID(), cars.get(i).getBrand(), cars.get(i).getModel()));
        }
    }
}
