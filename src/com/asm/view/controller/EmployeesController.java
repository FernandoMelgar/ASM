package com.asm.view.controller;


import com.asm.entities.worker.Genre;
import com.asm.interactors.EmployeeInteractor;
import com.asm.view.controller.properties.EmployeeProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class EmployeesController implements Initializable {

    private ObservableList<EmployeeProperty> clientData;
    private String currentUserID;
    private EmployeeInteractor interactor;
    private String baseURL = "http://localhost:8080";
    private ScrollPane mainScrollPane;

    // Anchor pane for forms
    @FXML private AnchorPane mainAnchorPane;

    // Clients table items
    @FXML private TableView<EmployeeProperty> clientsTable;
    @FXML private TableColumn<EmployeeProperty, String> columnID;
    @FXML private TableColumn<EmployeeProperty, String> columnName;
    @FXML private TableColumn<EmployeeProperty, String> columnSurnames;
    @FXML private TableColumn<EmployeeProperty, String> columnEmail;
    @FXML private TableColumn<EmployeeProperty, String> columnPhone;

    @FXML private TableColumn<EmployeeProperty, String> columnAddress;
    @FXML private TableColumn<EmployeeProperty, String> columnPosition;
    @FXML private TableColumn<EmployeeProperty, String> columnSpeciality;
    @FXML private TableColumn<EmployeeProperty, String> columnRFC;
    @FXML private TableColumn<EmployeeProperty, String> columnNSS;




    // Client Details labels
    @FXML private SplitPane clientDetailSplitPane;
    @FXML private AnchorPane clientDetailsPane;
    @FXML private VBox clientDetailsVBox;
    @FXML private VBox carDetailsVBox;
    @FXML private Label clientNameDetail;
    @FXML private Label clientEmailDetail;
    @FXML private Label clientPhoneDetail;



    public EmployeesController() {
        this.interactor = new MockEmployeeInteractor();
        try {
            this.clientData = FXCollections.observableArrayList(interactor.getAllEmployeesAsProperty());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<EmployeeProperty> getClientData() {
        return clientData;
    }

    private void setUpTable() {
        columnID.setText("ID");
        columnName.setText("Nombre");
        columnEmail.setText("Email");
        clientsTable.setItems(getClientData());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        columnID.setCellValueFactory(cellData-> cellData.getValue().idProperty());
        columnName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        columnSurnames.setCellValueFactory(cellData -> cellData.getValue().surnamesProperty());
        columnPhone.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());
        columnAddress.setCellValueFactory(cellData-> cellData.getValue().addressProperty());
        columnPosition.setCellValueFactory(cellData-> cellData.getValue().positionProperty());
        columnSpeciality.setCellValueFactory(cellData-> cellData.getValue().specialityProperty());
        columnRFC.setCellValueFactory(cellData-> cellData.getValue().rfcProperty());
        columnNSS.setCellValueFactory(cellData-> cellData.getValue().nssProperty());
        setUpTable();
    }



    public void newClientBtnOnClick(MouseEvent mouseEvent) throws IOException {
        System.out.println("New Client window!");
        newClientWindowVisible();
        //showNewClientForm(true);
    }

    private void showClientDetailsPane(boolean visible) {
        clientDetailsPane.setVisible(visible);
        clientDetailsPane.setManaged(visible);
    }

    public void showEmployeeDetails(EmployeeProperty employeeProperty) {
        if (employeeProperty != null) {
            showClientDetailsPane(true);
            clientDetailSplitPane.setDividerPositions(new double[]{0.5});
            currentUserID = employeeProperty.getId();
            System.out.println(currentUserID);
        } else {
            showClientDetailsPane(false);
            clientDetailSplitPane.setDividerPositions(new double[]{1});
            clientNameDetail.setText("");
            clientEmailDetail.setText("");
            clientPhoneDetail.setText("");
            currentUserID = "";
        }
    }

    public static void saveClient() {
        String query_url = "http://localhost:8080/clients/new";

    }



    public void closeClientDetails(MouseEvent mouseEvent) {
        showClientDetailsPane(false);
        clientDetailSplitPane.setDividerPositions(new double[]{1});
        clientNameDetail.setText("");
        clientEmailDetail.setText("");
        clientPhoneDetail.setText("");
        currentUserID = "";
    }

    public void openClientEditWindow() throws IOException {
        Node editPane = (Node)FXMLLoader.load(getClass().getResource("/fxml/client_views/edit.fxml"));
        mainAnchorPane.getChildren().clear();
        mainAnchorPane.getChildren().add(editPane);
    }

    public void newClientWindowVisible() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/employee_views/new.fxml"));
        Parent root = loader.load();
        NewEmployeeController newEmployeeController= loader.getController();
        newEmployeeController.init(mainScrollPane);
        this.mainScrollPane.setContent(root);
        mainScrollPane.setFitToWidth(true);
    }

    public void init(ScrollPane mainScrollPane) {
        this.mainScrollPane = mainScrollPane;
    }

    public void deleteClientOnClick(MouseEvent mouseEvent) {
        System.out.println(currentUserID);
    }
}

class MockEmployeeInteractor  extends EmployeeInteractor {


    @Override
    public List<EmployeeProperty> getAllEmployeesAsProperty() throws IOException {
        List<EmployeeProperty> employeeProperties = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            employeeProperties.add(new EmployeeProperty(
                    "EM",
                    "TestEmpl",
                    "Surname",
                    new Date(),
                    Genre.other,
                    "rfc",
                    "mail@gmail.com",
                    "55738398",
                    "Los angeles",
                    "Boss of u",
                    "Doing stuff",
                    "nss"
            ));
        }
        return employeeProperties;
    }
}