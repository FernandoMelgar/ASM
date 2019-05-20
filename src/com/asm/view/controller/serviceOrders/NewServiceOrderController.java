package com.asm.view.controller.serviceOrders;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;


import java.io.IOException;

public class NewServiceOrderController {
    private ScrollPane mainScrollPane;
    @FXML private TextField orderTypeInput;
    @FXML private TextArea orderDescriptionInput;
    @FXML private ChoiceBox<?> selectClient;
    @FXML private ChoiceBox<?> selectEmployee;
    @FXML private ChoiceBox<?> clientsCars;
    @FXML private DatePicker finishDate;
    @FXML private TextField priceTag;

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
}
