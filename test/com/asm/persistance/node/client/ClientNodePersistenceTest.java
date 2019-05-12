package com.asm.persistance.node.client;

import com.asm.entities.Vehicle;
import com.asm.entities.client.Client;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        client.addVehicle(car);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(client);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testParseListOfClients() {

        ObjectMapper mapper = new ObjectMapper();

        Client client = new Client();
        client.setName("Fernando");
        client.setSurnames("Melgar");
        client.setPhone("6677888");
        client.setAddress("Los santos");
        Client client2 = new Client();
        client2.setName("Carlos");
        client2.setSurnames("Martines");
        client2.setPhone("555373895");
        client2.setAddress("Bell Air");


        Vehicle car = new Vehicle();
        car.setManufacture("Audi");
        car.setModel("R8");
        car.setYear(2017);
        car.setCurrentKilometers(0L);
        car.setSerialNumber("MTV-144");
        client.addVehicle(car);
        client.addVehicle(car);
        client.addVehicle(car);


        List<Client> clients = new ArrayList<>();
        clients.add(client);
        clients.add(client2);


        try {
            String json = mapper.writeValueAsString(clients);
            System.out.println(json);
            List<Client> myObjects = mapper.readValue(json, new TypeReference<List<Client>>(){});
            for (Client c : myObjects){
                System.out.println(c.getName());
                for (Vehicle v : c.getCars()){
                    System.out.println(v.getModel());
                }
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}