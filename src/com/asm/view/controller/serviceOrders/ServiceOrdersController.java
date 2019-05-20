package com.asm.view.controller.serviceOrders;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class ServiceOrdersController {

    private ScrollPane mainScrollPane;

    public void newOrderClicked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/services_views/newServiceOrder.fxml"));
        Parent root = loader.load();
        NewServiceOrderController newServiceOrderController= loader.getController();
        newServiceOrderController.init(mainScrollPane);
        this.mainScrollPane.setContent(root);
        mainScrollPane.setFitToWidth(true);
        System.out.println("New Order");
    }

    public void init(ScrollPane mainScrollPane) {
        this.mainScrollPane = mainScrollPane;
    }
}
