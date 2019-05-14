package com.asm.persistance.node.client;

import com.asm.entities.Vehicle;
import com.asm.entities.client.Client;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.ObservableList;
import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class ClientNodePersistenceTest {


    private String response2 = "{[{\"cars\":[],\"id\":\"5cd1c3577b010306d824e5a8\",\"name\":\"Andrea\",\"surenames\":\"Mtz Rdz\",\"email\":\"andy6@gmail.com\",\"phone\":\"5540029494\",\"adress\":\"Salt Lake City, Utah\"},{\"cars\":[],\"id\":\"5cd2da333c9505030a8c1d39\",\"name\":\"Andrea\",\"surenames\":\"Mtz Rdz\",\"email\":\"andy@gmail.com\",\"phone\":\"5540029494\",\"adress\":\"Salt Lake City, Utah\",},{\"cars\":[\"5cd3813a2d16450b48fb3979\",\"5cd381792d16450b48fb397b\",\"5cd389f398e16f0bd6058c31\"],\"id\":\"5cd2e9f6b7576003b9daf18e\",\"name\":\"Andrea\",\"surenames\":\"Mtz Rdz\",\"email\":\"andy95@gmail.com\",\"phone\":\"5540029494\",\"adress\":\"Salt Lake City, Utah},{\"cars\":[\"5cd38e34b778ec0c24a09adf\",\"5cd38e6bd9dfde0c32d278ae\"],\"_id\":\"5cd38acf98e16f0bd6058c32\",\"name\":\"Carlos\",\"surenames\":\"Martínez Rodríguez\",\"email\":\"cmtz@gmail.com\",\"phone\":\"5540029494\",\"adress\":\"México City\"}]}";
    private String clientJson = "{\"cars\":[],\"id\":\"5cd1c3577b010306d824e5a8\",\"name\":\"Andrea\",\"surenames\":\"Mtz Rdz\",\"email\":\"andy6@gmail.com\",\"phone\":\"5540029494\",\"adress\":\"Salt Lake City, Utah\"}";




    @Test
    public void save() throws IOException {
        List<Client> clientsList = new ArrayList<>();
        String response = "{\"message\":\"Fetch post successfully\",\"clients\":[{\"cars\":[],\"_id\":\"5cd1c3577b010306d824e5a8\",\"name\":\"Andrea\",\"surenames\":\"Mtz Rdz\",\"email\":\"andy6@gmail.com\",\"phone\":\"5540029494\",\"adress\":\"Salt Lake City, Utah\",\"createdAt\":\"2019-05-07T17:41:43.731Z\",\"updatedAt\":\"2019-05-07T17:41:43.731Z\",\"__v\":0},{\"cars\":[],\"_id\":\"5cd2da333c9505030a8c1d39\",\"name\":\"Andrea\",\"surenames\":\"Mtz Rdz\",\"email\":\"andy@gmail.com\",\"phone\":\"5540029494\",\"adress\":\"Salt Lake City, Utah\",\"createdAt\":\"2019-05-08T13:31:31.853Z\",\"updatedAt\":\"2019-05-08T13:31:31.853Z\",\"__v\":0},{\"cars\":[\"5cd3813a2d16450b48fb3979\",\"5cd381792d16450b48fb397b\",\"5cd389f398e16f0bd6058c31\"],\"_id\":\"5cd2e9f6b7576003b9daf18e\",\"name\":\"Andrea\",\"surenames\":\"Mtz Rdz\",\"email\":\"andy95@gmail.com\",\"phone\":\"5540029494\",\"adress\":\"Salt Lake City, Utah\",\"createdAt\":\"2019-05-08T14:38:46.348Z\",\"updatedAt\":\"2019-05-09T02:01:23.126Z\",\"__v\":5},{\"cars\":[\"5cd38e34b778ec0c24a09adf\",\"5cd38e6bd9dfde0c32d278ae\"],\"_id\":\"5cd38acf98e16f0bd6058c32\",\"name\":\"Carlos\",\"surenames\":\"Martínez Rodríguez\",\"email\":\"cmtz@gmail.com\",\"phone\":\"5540029494\",\"adress\":\"México City\",\"createdAt\":\"2019-05-09T02:05:03.029Z\",\"updatedAt\":\"2019-05-09T02:20:27.226Z\",\"__v\":2}]}";

        JsonNode rootNode = new ObjectMapper().readTree(new StringReader(response));
        JsonNode clientsNode = rootNode.get("clients");

        for (int i = 0; i < clientsNode.size(); i++) {
            JsonNode clientJson = clientsNode.get(i);
            JsonNode clientCars = clientJson.get("cars");
            List<String> carsList = new ArrayList<>();

            if (clientCars.size() != 0) {
                for (final JsonNode carNode : clientCars) {
                    System.out.println(carNode);
                    carsList.add(carNode.toString());
                }
            }

            Client client = new Client();
            client.setId(clientJson.get("_id").toString());
            client.setName(clientJson.get("name").toString());
            client.setSurnames(clientJson.get("surenames").toString());
            client.setPhone(clientJson.get("phone").toString());
            client.setEmail(clientJson.get("email").toString());
            client.setAddress(clientJson.get("adress").toString());
            client.setCars(carsList);
            System.out.println(client.toString());
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



        List<Client> clients = new ArrayList<>();
        clients.add(client);
        clients.add(client2);


        try {
            String json = mapper.writeValueAsString(clients);
            System.out.println(json);
            List<Client> myObjects = mapper.readValue(json, new TypeReference<List<Client>>(){});
            for (Client c : myObjects){
                System.out.println(c.getName());
                //for (Vehicle v : c.getCars()){
                  //  System.out.println(v.getModel());
                //}
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    @Test
    public void testReadResponse() {

        ObjectMapper mapper = new ObjectMapper();

        try {
            String json = response2;
            System.out.println(json);
            List<Client> myObjects = mapper.readValue(json, new TypeReference<List<Client>>() {
            });
            for (Client c : myObjects) {
                System.out.println(c.getName());
                //for (Vehicle v : c.getCars()) {
                  //  System.out.println(v.getModel());
                //}
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        @Test
        public void testReadClient(){

            ObjectMapper mapper = new ObjectMapper();

            try {
                String json = clientJson;
                System.out.println(json);
                Client myObjects = mapper.readValue(json, Client.class);
                System.out.println(myObjects.getName());

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

        }