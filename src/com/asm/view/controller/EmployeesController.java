package com.asm.view.controller;


import com.asm.entities.worker.Genre;
import com.asm.interactors.ClientInteractor;
import com.asm.interactors.EmployeeInteractor;
import com.asm.view.controller.properties.EmployeeProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
    @FXML private Label employeeNameDetail;
    @FXML private Label employeeEmailDetail;
    @FXML private Label employeePhoneDetail;
    private EmployeeProperty selectedEmployee;


    public EmployeesController() {
        this.interactor = new EmployeeInteractor();
        try {
            this.clientData = FXCollections.observableArrayList(interactor.readAllEmployees());
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
        columnEmail.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        columnAddress.setCellValueFactory(cellData-> cellData.getValue().addressProperty());
        columnPosition.setCellValueFactory(cellData-> cellData.getValue().positionProperty());
        columnSpeciality.setCellValueFactory(cellData-> cellData.getValue().specialityProperty());
        columnRFC.setCellValueFactory(cellData-> cellData.getValue().rfcProperty());
        showEmployeeDetails(null);

//        columnNSS.setCellValueFactory(cellData-> cellData.getValue().nssProperty());
        clientsTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showEmployeeDetails(newValue)
        );
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
        System.out.println("Here on earth");
        if (employeeProperty != null) {
            this.selectedEmployee = employeeProperty;
            showClientDetailsPane(true);
            carDetailsVBox.getChildren().clear();
            clientDetailSplitPane.setDividerPositions(new double[]{0.5});
            employeeNameDetail.setText(employeeProperty.getName()+ " " + employeeProperty.getSurnames());
            employeeEmailDetail.setText(employeeProperty.getEmail());
            employeePhoneDetail.setText(employeeProperty.getPhone());
        } else {
            showClientDetailsPane(false);
            clientDetailSplitPane.setDividerPositions(new double[]{1});
            employeeNameDetail.setText("");
            employeeEmailDetail.setText("");
            employeePhoneDetail.setText("");
            currentUserID = "";
        }
    }

    public static void saveClient() {
        String query_url = "http://localhost:8080/clients/new";

    }



    public void closeClientDetails(MouseEvent mouseEvent) {
        showClientDetailsPane(false);
        clientDetailSplitPane.setDividerPositions(new double[]{1});
        employeeNameDetail.setText("");
        employeeEmailDetail.setText("");
        employeePhoneDetail.setText("");
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
        this.interactor.deleteEmployee(selectedEmployee.getId());
        System.out.println(currentUserID);
    }

    public void goToEditEmployee(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/employee_views/edit.fxml"));
        Parent root = loader.load();
        EditEmployeeController editEmployeeController = loader.getController();
        editEmployeeController.init(mainScrollPane, this.selectedEmployee);
        this.mainScrollPane.setContent(root);
        mainScrollPane.setFitToWidth(true);

    }
}
