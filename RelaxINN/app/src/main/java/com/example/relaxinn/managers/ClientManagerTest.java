package com.example.relaxinn.managers;

import com.example.relaxinn.entities.ChambreItemList;
import com.example.relaxinn.entity.Client;
import com.example.relaxinn.entity.Room;

import java.util.ArrayList;
import java.util.List;

public class ClientManagerTest {

    private static List<Client> clientList;
    private static void init() {
        clientList = new ArrayList<>();
        clientList.add(new Client(0,"ariane","teuboh","arihanna.teuboh55@gmail.com"));
    }
    public static List<Client> getAll() {
        if (clientList == null)
            init();
        return clientList;
    }
}