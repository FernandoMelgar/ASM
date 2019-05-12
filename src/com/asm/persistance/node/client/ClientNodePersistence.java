package com.asm.persistance.node.client;

import com.asm.entities.client.Client;
import com.asm.interactors.ClientPersistence;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import java.io.*;
import java.util.List;

public class ClientNodePersistence  implements ClientPersistence {

    ObjectMapper mapper;

    public ClientNodePersistence() {
        this.mapper = new ObjectMapper();
    }

    @Override
    public void save(Client c) throws IOException {
        String json = mapper.writeValueAsString(c);
        String response = NodePersistence.sendPostRequest(json, "http://localhost:3000/client/save");
    }

    @Override
    public Client read(String id) throws IOException {
        String response = NodePersistence.sendGetRequest("http;//localhost:3000/client/" + id);
        return mapper.readValue(response, Client.class);
    }

    @Override
    public List<Client> readAll() throws IOException {
        String response = NodePersistence.sendGetRequest("http;//localhost:3000/client/all");
        return mapper.readValue(response, new TypeReference<List<Client>>(){});
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
