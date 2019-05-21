package com.asm.interactors;

import com.asm.entities.MockData;
import com.asm.entities.client.Client;
import com.asm.entities.worker.Employee;
import com.asm.persistance.node.client.EmployeeNodePersistence;
import com.asm.view.controller.properties.AutomobileProperty;
import com.asm.view.controller.properties.ClientProperty;
import com.asm.view.controller.properties.EmployeeProperty;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EmployeeInteractor {

    private EmployeePersistence  persistence;

    public EmployeeInteractor() {

        //this.persistence = new EmployeeMockPersistence();
        this.persistence = new EmployeeNodePersistence();
    }

    public List<EmployeeProperty> readAllEmployees() throws IOException {
            List<Employee> employees = this.persistence.readAll();
            return getAsEmployeesPropery(employees);

    }


    public List<EmployeeProperty> getAsEmployeesPropery(List<Employee> employees) {

        for (Employee empl :
                employees) {
            System.out.println(empl.getName());
        }
        List<EmployeeProperty> employeeProperties = new ArrayList<>();

        for (Employee e : employees) {
            System.out.println(e.getName());
            employeeProperties.add(new EmployeeProperty(
                    e.getId(),
                    e.getName(),
                    e.getSurnames(),
                    e.getBirthDate(),
                    e.getGenre(),
                    e.getRfc(),
                    e.getEmail(),
                    e.getPhone(),
                    e.getAddress().getState() + " "
                            + e.getAddress().getCity() + " "
                            + e.getAddress().getStreet() +  " ,zip: "
                            + e.getAddress().getZip(),
                    e.getPosition(),
                    e.getSpecialities().get(0),
                    e.getActive()
            ));
        }
        return employeeProperties;
    }

    public void deleteEmployee(String id) {
        try {
            this.persistence.delete(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class EmployeeMockPersistence implements EmployeePersistence {

    @Override
    public void save(Employee e) throws IOException {

    }

    @Override
    public List<Employee> readAll() throws IOException {
        return MockData.createFakeEmployeeList();
    }

    @Override
    public void delete(String id) throws IOException {

    }
}