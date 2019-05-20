package com.asm.persistance.node.client;

import com.asm.entities.worker.Employee;
import com.asm.interactors.EmployeePersistence;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class EmployeeNodePersistence implements EmployeePersistence {

    @Override
    public void save(Employee empl) throws IOException {

        System.out.println("You are here on employeeNode" + empl.getName());
        String query_url = "http://localhost:8080/employees/new";
        ObjectMapper mapper = new ObjectMapper();

            String json = mapper.writeValueAsString(empl);
            System.out.println("json = " + json);
            String response = NodePersistence.sendPostRequest(json, query_url);
    }

    @Override
    public List<Employee> readAll() throws IOException {
        {
            List<Employee> employeeList = new ArrayList<>();
            String response = NodePersistence.setRequest("http://localhost:8080/clients/", "GET");
            JsonNode rootNode = new ObjectMapper().readTree(new StringReader(response));
            JsonNode EmployeeNode = rootNode.get("employees");

            for (int i = 0; i < EmployeeNode.size(); i++) {
                JsonNode employeeJson = EmployeeNode.get(i);

                Employee employee = new Employee();
                employee.setId(employeeJson.get("_id").toString());
                employee.setName(employeeJson.get("name").toString());
                employee.setSurnames(employeeJson.get("surenames").toString());
                employee.setPhone(employeeJson.get("phone").toString());
                employee.setEmail(employeeJson.get("email").toString());
                employeeList.add(employee);
            }
            return employeeList;
        }
    }

    @Override
    public void delete(String id) throws IOException {

    }
}
