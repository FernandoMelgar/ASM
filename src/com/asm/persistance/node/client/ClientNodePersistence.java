package com.asm.persistance.node.client;

import com.asm.entities.Automobile;
import com.asm.entities.MockData;
import com.asm.entities.client.Client;
import com.asm.interactors.ClientPersistence;
import com.fasterxml.jackson.databind.*;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClientNodePersistence  implements ClientPersistence {

    ObjectMapper mapper;

    public ClientNodePersistence() {
        this.mapper = new ObjectMapper();
    }

    @Override
    public void save(Client c) throws IOException {
        String json = mapper.writeValueAsString(c);
        String response = NodePersistence.sendPostRequest(json, "http://localhost:8080/clients/new");
        System.out.println(json);
    }

    @Override
    public Client read(String id) throws IOException {
        String response = NodePersistence.setRequest("http://localhost:8080/clients/" + id,"GET");
        return mapper.readValue(response, Client.class);
    }

    @Override
    public List<Client> readAll() throws IOException {
        List<Client> clientsList = new ArrayList<>();
        String response = NodePersistence.setRequest("http://localhost:8080/clients/","GET");
        System.out.println("response = " + response);

        JsonNode rootNode = new ObjectMapper().readTree(new StringReader(response));
        JsonNode clientsNode = rootNode.get("clients");

        for (int i = 0; i < clientsNode.size(); i++) {
            JsonNode clientJson = clientsNode.get(i);
            JsonNode clientCars = clientJson.get("cars");
            List<Automobile> carsList = new ArrayList<>();

            if (clientCars.size() != 0) {
                for (final JsonNode carNode : clientCars) {
                    //carsList.add(mapper.readValue(carNode.toString(), Automobile.class));
                }
            }

            Client client = new Client();
            client.setId(clientJson.get("_id").textValue());
            client.setName(clientJson.get("name").textValue());
            client.setSurnames(clientJson.get("surnames").textValue());
            client.setPhone(clientJson.get("phone").textValue());
            client.setEmail(clientJson.get("email").textValue());
            client.setAddress(clientJson.get("address").textValue());
            client.setCars(MockData.createMockAutomobileList());
            clientsList.add(client);

        }
        return clientsList;
    }

    @Override
    public void update(Client c) throws IOException {
        String json = mapper.writeValueAsString(c);
        String response = NodePersistence.sendPostRequest(json, "http://localhost:8080/client/update");
    }

    @Override
    public void delete(String id) throws IOException {
        String response = NodePersistence.setRequest("http://localhost:8080/clients/" + id,"DELETE");

    }

}
