package com.asm.interactors;


import com.asm.entities.client.Client;
import com.asm.persistance.node.client.ClientNodePersistence;

public class ClientInteractor {

    private ClientPersistence clientDao;


    public ClientInteractor() {
        this.clientDao = new ClientNodePersistence();
    }


    public void saveClient(Client c) {
        this.clientDao.save(c);
    }
}
