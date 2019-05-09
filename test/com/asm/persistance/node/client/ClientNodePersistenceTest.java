package com.asm.persistance.node.client;

import com.asm.entities.Vehicle;
import com.asm.entities.client.Client;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

public class ClientNodePersistenceTest {

    @Test
    public void save() {
        Client client = new Client();
        client.setName("Fernando");
        client.setSurnames("Melgar");
        client.setPhone("6677888");
        client.setAddress("Los santos");

        Vehicle car = new Vehicle();
        car.setManufacture("Audi");
        car.setModel("R8");
        car.setYear(2017);
        car.setCurrentKilometers(0L);
        car.setSerialNumber("MTV-144");
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(client);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}