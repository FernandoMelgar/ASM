package com.asm.view.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class EmployeesController {
    private ScrollPane mainScrollPane;

    @FXML private TableColumn<?, ?> idColumn;
    @FXML private TableColumn<?, ?> nameColumn;
    @FXML private TableColumn<?, ?> surenamesColumn;
    @FXML private TableColumn<?, ?> phoneColumn;
    @FXML private TableColumn<?, ?> activityColumn;

    public void newEmployeeBtnOnClick(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/employee_views/new.fxml"));
        Parent root = loader.load();
        NewEmployeeController newEmployeeController = loader.getController();
        newEmployeeController.init(mainScrollPane);
        this.mainScrollPane.setContent(root);
        mainScrollPane.setFitToWidth(true);
    }

    public void init(ScrollPane mainScrollPane) {
        this.mainScrollPane = mainScrollPane;
    }
}
