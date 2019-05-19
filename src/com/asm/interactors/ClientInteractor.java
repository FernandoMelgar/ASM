package com.asm.interactors;


import com.asm.entities.client.Client;
import com.asm.persistance.node.client.ClientNodePersistence;
import com.asm.view.controller.properties.ClientProperty;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientInteractor {

    private ClientPersistence persistence;


    public ClientInteractor() {
        this.persistence = new ClientMockPersistence();
//        this.persistence = new ClientNodePersistence();
        try {
            List<Client> clients = persistence.readAll();
            System.out.println(clients.get(0));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void deleteClient(String id){
        try {
            persistence.delete(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveClient(Client c) {
        try {
            this.persistence.save(c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<ClientProperty> getAllClientsAsProperty() throws IOException {
        List<ClientProperty> clientProperties = new ArrayList<>();

        List<Client> clients = persistence.readAll();
        System.out.println(clients.get(0));

        for (Client c : clients) {
            clientProperties.add(new ClientProperty(
                    c.getId(),
                    c.getName(),
                    c.getSurnames(),
                    c.getEmail(),
                    c.getPhone()
            ));
        }

        return clientProperties;
    }
}

class ClientMockPersistence implements ClientPersistence {

    @Override
    public void save(Client client) throws IOException {

    }

    @Override
    public Client read(String id) throws IOException {
        return null;
    }

    @Override
    public List<Client> readAll() throws IOException {
        List<Client> clients = new ArrayList<>();
        clients.add(new Client("Hans", "Muster de la Paz", "hans@gmail.com"));
        clients.add(new Client("Ruth", "Mueller Rasjdnasjns", "goo@gmail.com"));
        clients.add(new Client("Heinz", "Kurz"));
        clients.add(new Client("Cornelia", "Meier"));
        clients.add(new Client("Werner", "Meyer"));
        clients.add(new Client("Lydia", "Kunz"));
        clients.add(new Client("Anna", "Best"));
        clients.add(new Client("Stefan", "Meier"));
        clients.add(new Client("Martin", "Mueller"));
        return clients;

    }

    @Override
    public void update(Client c) throws IOException {

    }

    @Override
    public void delete(String id) throws IOException {

    }
}
