package com.asm.persistance.node.client;

import com.asm.entities.client.Client;
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
    public void save(Employee empl) {

        System.out.println("You are here on employeeNode" + empl.getName());
        String query_url = "http://localhost:3000/employee/save";
        ObjectMapper mapper = new ObjectMapper();

        try {
            String json = mapper.writeValueAsString(empl);
            String response = NodePersistence.sendPostRequest(json, query_url);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        return response;
    }

    @Override
    public List<Employee> readAll() throws IOException {
        {
            List<Employee> employeeList = new ArrayList<>();
            String response = NodePersistence.sendGetRequest("http://localhost:8080/clients/");
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
}
