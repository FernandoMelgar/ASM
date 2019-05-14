package com.asm.view.controller;


import com.asm.entities.client.Client;
import com.asm.interactors.ClientInteractor;
import com.asm.view.controller.properties.AutomobileProperty;
import com.asm.view.controller.properties.ClientProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class ClientsController implements Initializable {

    private ObservableList<ClientProperty> clientData;
    private ClientInteractor interactor;
    private String baseURL = "http://localhost:8080";
    private ScrollPane mainScrollPane;

    // Anchor pane for forms
    @FXML private AnchorPane mainAnchorPane;

    // Clients table items
    @FXML private TableView<ClientProperty> clientsTable;
    @FXML private TableColumn<ClientProperty, String> columnID;
    @FXML private TableColumn<ClientProperty, String> columnName;
    @FXML private TableColumn<ClientProperty, String> columnLastName;
    @FXML private TableColumn<ClientProperty, String> columnEmail;
    @FXML private TableColumn<ClientProperty, String> columnPhone;
    @FXML private TableColumn<ClientProperty, String> columnCars;

    // Client Details labels
    @FXML private SplitPane clientDetailSplitPane;
    @FXML private AnchorPane clientDetailsPane;
    @FXML private VBox clientDetailsVBox;
    @FXML private VBox carDetailsVBox;
    @FXML private Label clientNameDetail;
    @FXML private Label clientEmailDetail;
    @FXML private Label clientPhoneDetail;



    public ClientsController() {
        this.interactor = new ClientInteractor();
        try {
            this.clientData = FXCollections.observableArrayList(interactor.getAllClientsAsProperty());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<ClientProperty> getClientData() {
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
        columnID.setCellValueFactory(cellData-> cellData.getValue().IDProperty());
        columnName.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        columnLastName.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        columnEmail.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        columnPhone.setCellValueFactory(cellData -> cellData.getValue().phoneNumberProperty());
        columnCars.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getCarElementsToString()));
        showUserDetails(null);
        clientsTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) ->
                        showUserDetails(newValue)
        );
        setUpTable();
    }

    public GridPane generateAutomobileGridPanel(AutomobileProperty auto) {
        GridPane carGridPane = new GridPane();
        carGridPane.setGridLinesVisible(false);

        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();
        ColumnConstraints column3 = new ColumnConstraints();
        ColumnConstraints column4 = new ColumnConstraints();
        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        RowConstraints row3 = new RowConstraints();

        column1.setHgrow(Priority.NEVER);
        column2.setHgrow(Priority.ALWAYS);
        column2.setHalignment(HPos.LEFT);
        column3.setHgrow(Priority.NEVER);
        column4.setHgrow(Priority.ALWAYS);
        column4.setHalignment(HPos.LEFT);

        carGridPane.getRowConstraints().addAll(row1, row2, row3);
        carGridPane.getColumnConstraints().addAll(column1, column2, column3, column4);

        Label labelForBrnadAndModel = new Label(auto.getBrand() + " - " + auto.getModel());
        labelForBrnadAndModel.setPadding(new Insets(5, 5,5,2));
        Label labelForLicencePlate = new Label("Placas:");
        labelForLicencePlate.setPadding(new Insets(5, 5,5,2));
        Label labelLicencePlate = new Label(auto.getLicencePlate());
        labelLicencePlate.setPadding(new Insets(0, 0,0,5));
        Label labelForKilometers = new Label("Km:");
        labelForKilometers.setPadding(new Insets(5, 5,5,2));
        Label labelKilometers = new Label(Long.toString(auto.getCurrentKm()));
        labelKilometers.setPadding(new Insets(0, 0,0,5));
        Label labelForYears = new Label("Año:");
        labelForYears.setPadding(new Insets(5, 5,5,2));
        Label labelYear = new Label(Integer.toString(auto.getYear()));
        labelYear.setPadding(new Insets(0, 0,0,5));
        Label labelForSerialNumber = new Label("N. Serie:");
        labelForSerialNumber.setPadding(new Insets(5, 5,5,2));
        Label labelSerialNumber = new Label(auto.getSerailNumber());
        labelSerialNumber.setPadding(new Insets(0, 0,0,5));

        carGridPane.add(labelForBrnadAndModel, 0, 0, 4, 1);
        carGridPane.add(labelForLicencePlate, 0, 1);
        carGridPane.add(labelLicencePlate, 1, 1);
        carGridPane.add(labelForKilometers, 0, 2);
        carGridPane.add(labelKilometers, 1, 2);
        carGridPane.add(labelForYears, 2, 1);
        carGridPane.add(labelYear, 3, 1);
        carGridPane.add(labelForSerialNumber, 2, 2);
        carGridPane.add(labelSerialNumber, 3, 2);

        return carGridPane;
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

    public void showUserDetails(ClientProperty client) {
        if (client != null) {
            showClientDetailsPane(true);
            carDetailsVBox.getChildren().clear();
            for (AutomobileProperty element : client.getCar()) {
                carDetailsVBox.getChildren().add(generateAutomobileGridPanel(element));
            }
            clientDetailSplitPane.setDividerPositions(new double[]{0.5});
            clientNameDetail.setText(client.getFirstName() + " " + client.getLastName());
            clientEmailDetail.setText(client.getEmail());
            clientPhoneDetail.setText(client.getPhoneNumber());
        } else {
            showClientDetailsPane(false);
            clientDetailSplitPane.setDividerPositions(new double[]{1});
            clientNameDetail.setText("");
            clientEmailDetail.setText("");
            clientPhoneDetail.setText("");
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
    }

    public void openClientEditWindow() throws IOException {
        Node editPane = (Node)FXMLLoader.load(getClass().getResource("/fxml/client_views/edit.fxml"));
        mainAnchorPane.getChildren().clear();
        mainAnchorPane.getChildren().add(editPane);
    }

    public void newClientWindowVisible() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/client_views/new.fxml"));
        Parent root = loader.load();
        NewClientController newClientController= loader.getController();
        newClientController.init(mainScrollPane);
        this.mainScrollPane.setContent(root);
        mainScrollPane.setFitToWidth(true);
    }

    public void init(ScrollPane mainScrollPane) {
        this.mainScrollPane = mainScrollPane;
    }

}
