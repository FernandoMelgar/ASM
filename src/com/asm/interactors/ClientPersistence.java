package com.asm.interactors;

import com.asm.entities.client.Client;

import java.io.IOException;
import java.util.List;

public interface ClientPersistence {

    void save(Client client) throws IOException;
    Client read(String id) throws IOException;
    List<Client> readAll() throws IOException;
    void update(Client c) throws IOException;
    void delete(String id) throws IOException;
}
