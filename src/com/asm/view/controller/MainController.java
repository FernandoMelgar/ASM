package com.asm.view.controller;


import com.asm.entities.client.Client;
import com.asm.interactors.ClientInteractor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {

    @FXML public Label lblHello;
    @FXML public Button btnGoodBye;
    private ClientInteractor clientInteractor;

    public MainController(){
        this.clientInteractor = new ClientInteractor();
    }

    public void sayHelloWorld(ActionEvent actionEvent) {
        lblHello.setText("Good Bye:");
        Client c = new Client();
        c.setName("Fernando");
        clientInteractor.saveClient(c);
    }
}