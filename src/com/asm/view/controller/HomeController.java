package com.asm.view.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HomeController {

    private String currentUI = "";
    @FXML private BorderPane mainPane;
    @FXML private ScrollPane mainScrollPane;
    @FXML private Button clientsButton;

    private void loadUI(String ui) {
        // TODO:cmr Búscar una alternativa para llamar a las distintas vistas
        this.currentUI = ui;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/"+ ui + ".fxml"));
            Parent root = loader.load();
            if (ui.equals("clients")){
                System.out.println("You selected clients");
                ClientsController clientsController = loader.getController();
                clientsController.init(mainScrollPane);
            }
            if (ui.equals("employees")) {
                System.out.println("You selected employess");
                EmployeesController employeesController = loader.getController();
                employeesController.init(mainScrollPane);
            }
            mainScrollPane.setContent(root);
            mainScrollPane.setFitToWidth(true);

        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

    public void onBtnClientsClicked(MouseEvent mouseEvent) {
        displayViewIfNotAlready("clients");
    }

    protected void displayViewIfNotAlready(String fileName) {
        if (!this.currentUI.equals(fileName)) loadUI(fileName);
    }


    public void btnEmployeesOnClick(MouseEvent mouseEvent) {
        displayViewIfNotAlready("employees");
    }

    public void btnConfigOnClick(MouseEvent mouseEvent) {
        displayViewIfNotAlready("settings");
    }

    public void btnServicesOnClick(MouseEvent mouseEvent) {
    }

    public void btnDashboardOnClick(MouseEvent mouseEvent) {
        displayViewIfNotAlready("/client_views/edit");
    }
}
