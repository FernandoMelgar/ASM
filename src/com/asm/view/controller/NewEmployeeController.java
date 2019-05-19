package com.asm.view.controller;

import com.asm.entities.worker.Employee;
import com.asm.entities.worker.SalaryInfo;
import com.asm.entities.worker.salaries.SalaryIteration;
import com.asm.entities.worker.salaries.SalaryType;
import com.asm.persistance.node.client.EmployeeNodePersistence;
import com.asm.interactors.EmployeePersistence;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class NewEmployeeController implements Initializable {

    public ChoiceBox genreEmpl;
    public TextField surnamesEmpl;
    public TextField nameEmployee;
    public TextField rfcEmpl;
    public DatePicker birthDateEmpl;
    public TextField phoneEmpl;
    public TextField emailEmpl;
    public TextField streetEmpl;
    public TextField cityEmpl;
    public TextField ccpEmpl;
    public TextField stateEmpl;
    public TextField specialitiesEmpl;
    public TextField positionEmpl;
    public TextField nssEmpl;
    public TextField salaryEmpl;
    private ScrollPane mainScrollPane;
    private EmployeePersistence persistence;

    public NewEmployeeController() {
        this.persistence = new EmployeeNodePersistence();
    }

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

    public void saveEmployee(ActionEvent actionEvent) {

        Employee e = new Employee();
        e.setPaysheet(new SalaryInfo(this.salaryEmpl.getText(), SalaryType.NOTSET, SalaryIteration.NOTSET));
        e.setName(this.nameEmployee.getText());
        e.setSurnames(this.surnamesEmpl.getText());
        e.setRfc(this.rfcEmpl.getText());
        e.setEmail(this.emailEmpl.getText());
        e.setPosition(this.positionEmpl.getText());
        e.setSpecialities(this.specialitiesEmpl.getText());
        e.setNss(this.nssEmpl.getText());
//        e.setPhone(this.phoneEmpl.getText());

        try {
            this.persistence.save(e);
        } catch (IOException ex) {
//            ex.printStackTrace();
            System.out.println("Error here");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Error while creating Employee");
            alert.setHeaderText("There was an error while creating an Employee");
            alert.setContentText("Please check your internet connection");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                goToHomeView();
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        genreEmpl.getItems().addAll("Hombre", "Mujer", "Otro");
        
    }
}
