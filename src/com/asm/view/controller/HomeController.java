package com.asm.view.controller;

import com.asm.view.controller.serviceOrders.ServiceOrdersController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HomeController implements Initializable {

    private String currentUI = "";
    @FXML private BorderPane mainPane;
    @FXML private ScrollPane mainScrollPane;
    @FXML private Button clientsButton;



    private void loadUI(String ui) {
        this.currentUI = ui;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/"+ ui + ".fxml"));
            Parent root = loader.load();
            if (ui.equals("clients")){
                System.out.println("You selected clients");
                ClientsController clientsController = loader.getController();
                clientsController.init(mainScrollPane);
            }
            if (ui.equals("dashboard")){
                System.out.println("You selected dashboard");
                DashboardController dashboardController = loader.getController();
                dashboardController.init(mainScrollPane);
            }
            if (ui.equals("services")){
                System.out.println("You selected services");
                ServiceOrdersController serviceOrdersController = loader.getController();
                serviceOrdersController.init(mainScrollPane);
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

    protected void displayViewIfNotAlready(String fileName) {
        if (!this.currentUI.equals(fileName)) loadUI(fileName);
    }

    public void onBtnClientsClicked(MouseEvent mouseEvent) {
        displayViewIfNotAlready("clients");
    }

    public void btnEmployeesOnClick(MouseEvent mouseEvent) { displayViewIfNotAlready("employees"); }

    public void btnConfigOnClick(MouseEvent mouseEvent) {
        displayViewIfNotAlready("settings");
    }

    public void btnServicesOnClick(MouseEvent mouseEvent) {
        displayViewIfNotAlready("services");
    }

    public void btnDashboardOnClick(MouseEvent mouseEvent) {
        displayViewIfNotAlready("dashboard");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dashboard.fxml"));
            Parent root = loader.load();
            DashboardController dashboardController = loader.getController();
            dashboardController.init(mainScrollPane);
            mainScrollPane.setContent(root);
            mainScrollPane.setFitToWidth(true);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
