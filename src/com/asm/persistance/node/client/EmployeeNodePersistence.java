package com.asm.persistance.node.client;

import com.asm.entities.worker.Employee;
import com.asm.view.controller.persistence.EmployeePersistence;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

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
}
