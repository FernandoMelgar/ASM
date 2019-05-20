package com.asm.persistance.node.client;

import com.asm.entities.MockData;
import com.asm.entities.worker.Employee;
import com.asm.entities.worker.Genre;
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
            String response = NodePersistence.setRequest("http://localhost:8080/employees/", "GET");
            System.out.println("response = " + response);
            JsonNode rootNode = new ObjectMapper().readTree(new StringReader(response));
            JsonNode EmployeeNode = rootNode.get("employees");
            for (int i = 0; i < EmployeeNode.size(); i++) {
                JsonNode employeeJson = EmployeeNode.get(i);
                System.out.println(employeeJson.toString());
                Employee employee = new Employee();
                employee.setId(employeeJson.get("_id").textValue());
                employee.setName(employeeJson.get("name").toString());
                employee.setSurnames(employeeJson.get("surnames").toString());
                employee.setPhone(employeeJson.get("phone").toString());
                employee.setEmail(employeeJson.get("email").textValue());
                employee.setGenre(Genre.Hombre);
                employee.setBirthDate(employeeJson.get("birthDate").toString());
                employee.setRfc(employeeJson.get("rfc").toString());
                employee.setAddress(MockData.createFakeAddress());
                ArrayList<String> specialties = new ArrayList<>();
                specialties.add(employeeJson.get("specialties").toString());
                employee.setSpecialities(specialties);
                employee.setPaysheet(MockData.createFakePaysheet());
                employeeList.add(employee);
            }
            return employeeList;
        }
    }

    @Override
    public void delete(String id) throws IOException {
        System.out.println("id = " + id);
        String response = NodePersistence.setRequest("http://localhost:8080/employees/" + id,"DELETE");
    }
}
