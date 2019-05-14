package com.asm.persistance.node.client;

import com.asm.entities.client.Client;
import com.asm.interactors.ClientPersistence;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
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
        String response = NodePersistence.sendGetRequest("http://localhost:8080/clients/" + id);
        return mapper.readValue(response, Client.class);
    }

    @Override
    public List<Client> readAll() throws IOException {
        List<Client> clientsList = new ArrayList<>();
        String response = NodePersistence.sendGetRequest("http://localhost:8080/clients/");
        System.out.println("response = " + response);

        JsonNode rootNode = new ObjectMapper().readTree(new StringReader(response));
        JsonNode clientsNode = rootNode.get("clients");

        for (int i = 0; i < clientsNode.size(); i++) {
            JsonNode clientJson = clientsNode.get(i);
            JsonNode clientCars = clientJson.get("cars");
            List<String> carsList = new ArrayList<>();

            if (clientCars.size() != 0) {
                for (final JsonNode carNode : clientCars) {
                    carsList.add(carNode.toString());
                }
            }

            Client client = new Client();
            client.setId(clientJson.get("_id").toString());
            client.setName(clientJson.get("name").toString());
            client.setSurnames(clientJson.get("surnames").toString());
            client.setPhone(clientJson.get("phone").toString());
            client.setEmail(clientJson.get("email").toString());
            client.setAddress(clientJson.get("address").toString());
            client.setCars(carsList);
            clientsList.add(client);
        }
        return clientsList;
    }

    @Override
    public void update(Client c) throws IOException {
        String json = mapper.writeValueAsString(c);
        String response = NodePersistence.sendPostRequest(json, "http://localhost:3000/client/update");
    }

    @Override
    public void delete(String id) throws IOException {
        String response = NodePersistence.sendGetRequest("http;//localhost:3000/client/delete/" + id);
    }
}
