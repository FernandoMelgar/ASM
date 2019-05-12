package com.asm.view.controller;

import com.asm.entities.client.Client;
import com.asm.interactors.ClientPersistence;
import com.asm.persistance.node.client.ClientNodePersistence;
import com.asm.view.controller.properties.AutomobileProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


public class NewClientController {

    private int carCountState = 0;
    private List<AutomobileProperty> carsAdded;
    private ClientPersistence clientPersistence;

    @FXML private VBox newClientVBox;

    @FXML private TextField editNameInput;
    @FXML private TextField newNameInput;
    @FXML private TextField newSurnameInput;
    @FXML private TextField newEmailInput;
    @FXML private TextField newPhoneInput;
    @FXML private TextField newAddressInput;
    private ScrollPane mainScrollPane;

    public NewClientController() {
        this.clientPersistence = new ClientNodePersistence();
    }

    public void submitNewClientFormOnClick(MouseEvent mouseEvent) {
        saveClient();
        goToHomeView();
    }

    public void cancelNewClientFormOnClick(MouseEvent mouseEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cancelar Registro de Cliente");
        alert.setHeaderText("¿Estás seguro que deseas cancelar el registro del cliente?");
        alert.setContentText("Todos los cambios se borraran");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            goToHomeView();

        }

    }

    private void goToHomeView() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/clients.fxml"));
        try {
            Parent root = loader.load();
            ClientsController clientsController = loader.getController();
            clientsController.init(mainScrollPane);
            this.mainScrollPane.setContent(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

        mainScrollPane.setFitToWidth(true);
    }

    public void addNewCarToCurrentClient(MouseEvent mouseEvent) {
        carCountState++;
        System.out.print("Add a new Car");
        newClientVBox.getChildren().add(generateAutomobileGridPanel(carCountState));
    }

    public GridPane generateAutomobileGridPanel(int state) {
        String carGridId = "car-grid-"+ Integer.toString(state);
        GridPane carGridPane = new GridPane();
        carGridPane.setGridLinesVisible(false);
        carGridPane.setPadding(new Insets(20, 0,20,0));
        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();
        ColumnConstraints column3 = new ColumnConstraints();
        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        RowConstraints row3 = new RowConstraints();
        RowConstraints row4 = new RowConstraints();
        RowConstraints row5 = new RowConstraints();
        RowConstraints row6 = new RowConstraints();
        RowConstraints row7 = new RowConstraints();

        column1.setHgrow(Priority.ALWAYS);
        column2.setHgrow(Priority.ALWAYS);
        column2.setMaxWidth(100);
        column3.setHgrow(Priority.ALWAYS);
        column3.setHalignment(HPos.LEFT);

        carGridPane.getRowConstraints().addAll(row1, row2, row3, row4, row5, row6, row7);
        carGridPane.getColumnConstraints().addAll(column1, column2, column3);

        Label labelForTitle = new Label("Registro Automovil "+ carCountState +":");
        labelForTitle.setFont(new Font(24));
        labelForTitle.setPadding(new Insets(5, 5,5,2));

        Label labelForBrnad = new Label("Marca:");
        labelForBrnad.setPadding(new Insets(5, 5,5,2));

        Label labelForModel = new Label("Modelo:");
        labelForModel.setPadding(new Insets(5, 5,5,0));

        Label labelForLicencePlate = new Label("Placas:");
        labelForLicencePlate.setPadding(new Insets(5, 5,5,2));

        Label labelForKilometers = new Label("Kilometraje:");
        labelForKilometers.setPadding(new Insets(5, 5,5,0));

        Label labelForYears = new Label("Año:");
        labelForYears.setPadding(new Insets(5, 5,5,2));

        Label labelForSerialNumber = new Label("N. Serie:");
        labelForSerialNumber.setPadding(new Insets(5, 5,5,0));

        TextField brandInput = new TextField();
        TextField modelInput = new TextField();
        TextField licencePalteInput = new TextField();
        TextField kilometersInput = new TextField();
        TextField yearInput = new TextField();
        TextField serialNumberInput = new TextField();


        Button cancelButton = new Button("Remover Automóvil");
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Remove cars clicked!" + "");
            }
        });
        HBox carFormControls = new HBox();
        carFormControls.setPadding(new Insets(10, 0,10,0));
        carFormControls.getChildren().addAll(cancelButton);

        // Column 1
        carGridPane.add(labelForTitle, 0, 0);

        carGridPane.add(labelForBrnad, 0, 1);
        carGridPane.add(brandInput, 0, 2);

        carGridPane.add(labelForLicencePlate, 0, 3);
        carGridPane.add(licencePalteInput, 0, 4);

        carGridPane.add(labelForYears, 0, 5);
        carGridPane.add(yearInput, 0, 6);

        carGridPane.add(carFormControls, 0, 7);


        //Column 3
        carGridPane.add(labelForModel, 2, 1);
        carGridPane.add(modelInput, 2, 2);

        carGridPane.add(labelForSerialNumber, 2, 3);
        carGridPane.add(serialNumberInput, 2, 4);

        carGridPane.add(labelForKilometers, 2, 5);
        carGridPane.add(kilometersInput, 2, 6);

        return carGridPane;
    }

    public void saveClient() {
        Client client = new Client();
        client.setName(this.newNameInput.getText());
        client.setSurnames(this.newSurnameInput.getText());
        client.setPhone(this.newPhoneInput.getText());
        client.setEmail(this.newEmailInput.getText());
        client.setAddress(this.newAddressInput.getText());

        try {
            this.clientPersistence.save(client);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void init(ScrollPane mainScrollPane) {
        this.mainScrollPane = mainScrollPane;
        this.clientPersistence = new ClientNodePersistence();

    }

}
