package com.asm.view.controller.serviceOrders;

import com.asm.interactors.ClientInteractor;
import com.asm.view.controller.properties.ClientProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewServiceOrderController implements Initializable {
    private ClientInteractor interactor;
    private ObservableList<ClientProperty> clientData;
    private ScrollPane mainScrollPane;
    @FXML private TextField orderTypeInput;
    @FXML private TextArea orderDescriptionInput;
    @FXML private ChoiceBox<String> selectClient;
    @FXML private ChoiceBox<?> selectEmployee;
    @FXML private ChoiceBox<?> clientsCars;
    @FXML private DatePicker finishDate;
    @FXML private TextField priceTag;
    
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
        this.interactor = new ClientInteractor();
        try {
            this.clientData = FXCollections.observableArrayList(interactor.readClientsAsProperty());
            for (int i = 0; i < clientData.size(); i++) {
                selectClient.getItems().add(clientData.get(i).getFirstName() + " " + clientData.get(i).getSurnames());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
