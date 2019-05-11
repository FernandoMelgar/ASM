package com.asm.view.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.Optional;

public class NewEmployeeController {
    private ScrollPane mainScrollPane;

    private void goToHomeView() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/employees.fxml"));
        try {
            Parent root = loader.load();
            EmployeesController employeesController = loader.getController();
            employeesController.init(mainScrollPane);
            this.mainScrollPane.setContent(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

        mainScrollPane.setFitToWidth(true);
    }

    public void init(ScrollPane mainScrollPane) {
        this.mainScrollPane = mainScrollPane;
    }

    public void cancelRegisterOnClick(MouseEvent mouseEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cancelar Registro de Empleado");
        alert.setHeaderText("¿Estás seguro que deseas cancelar el registro del empleado?");
        alert.setContentText("Todos los cambios se borraran");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            goToHomeView();
        }
    }
}
