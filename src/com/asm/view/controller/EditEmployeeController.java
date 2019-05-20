package com.asm.view.controller;

import com.asm.entities.worker.Address;
import com.asm.entities.worker.Employee;
import com.asm.entities.worker.Genre;
import com.asm.entities.worker.SalaryInfo;
import com.asm.entities.worker.salaries.SalaryIteration;
import com.asm.entities.worker.salaries.SalaryType;
import com.asm.interactors.EmployeePersistence;
import com.asm.persistance.node.client.EmployeeNodePersistence;
import com.asm.view.controller.properties.EmployeeProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;


public class EditEmployeeController implements Initializable {
    public ChoiceBox genreEmpl;
    public ChoiceBox paymentEmployee;
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
    private EmployeeProperty employeeProperty;

    public EditEmployeeController() {

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
        alert.setTitle("Cancelar La actualizacion de empleado");
        alert.setHeaderText("¿Estás seguro que deseas cancelar la actualizacion de la informacion del empleado?");
        alert.setContentText("Todos los cambios se borraran");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            goToHomeView();
        }
    }

    public void updateEmployee(ActionEvent actionEvent) {
        System.out.println(this.birthDateEmpl.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

//        getAsSalaryEnum(this.)
        Employee e = new Employee();
        e.setPaysheet(new SalaryInfo(Integer.parseInt(this.salaryEmpl.getText()),
                SalaryType.NOTSET,
                SalaryIteration.valueOf(this.paymentEmployee.getValue().toString()),
                5553));

        e.setName(this.nameEmployee.getText());
        e.setBirthDate(this.birthDateEmpl.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        e.setSurnames(this.surnamesEmpl.getText());
        e.setRfc(this.rfcEmpl.getText());
        e.setEmail(this.emailEmpl.getText());
        e.setPosition(this.positionEmpl.getText());
        List<String> l = new ArrayList<>();
        l.add(this.specialitiesEmpl.getText());
        e.setSpecialities(l);
        e.setGenre((Genre) this.genreEmpl.getValue());
        e.setPhone(this.phoneEmpl.getText());
        e.setAddress(new Address(this.streetEmpl.getText(), this.cityEmpl.getText(), this.stateEmpl.getText(), (this.nssEmpl.getText())));

        try {
            this.persistence.save(e);
            goToHomeView();
        } catch (IOException ex) {
//            ex.printStackTrace();
            System.out.println("Error here");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Error while Updating Employee");
            alert.setHeaderText("There was an error while creating an Employee");
            alert.setContentText("Please check your internet connection");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                goToHomeView();
            }
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void init(ScrollPane mainScrollPane, EmployeeProperty selectedEmployee) {
        this.mainScrollPane = mainScrollPane;
        this.employeeProperty = employeeProperty;
        this.surnamesEmpl.setText(selectedEmployee.getSurnames());
        this.nameEmployee.setText(selectedEmployee.getName());
        this.rfcEmpl.setText(selectedEmployee.getRfc());
        this.phoneEmpl.setText(selectedEmployee.getPhone());
        this.emailEmpl.setText(selectedEmployee.getEmail());
        this.specialitiesEmpl.setText(selectedEmployee.getSpeciality());
        this.positionEmpl.setText(selectedEmployee.getPosition());
    }
}
