package com.example.relaxinn.managers;

import android.util.Log;

import com.example.relaxinn.entity.Client;
import com.example.relaxinn.entity.Room;
import com.example.relaxinn.services.HttpGetRequest;

import java.util.concurrent.ExecutionException;

public class ClientManager {


    private String get_client;
    private String ariana;
    private String aranatest;

    public static Client get_client(String email, String pwd) {
       // String ariana = "http://70.53.207.187:9876/relax-inn-server/clients?email=ateuboh@isi-mtl.com&pwd=ateuboh";
        String aranatest = "http://70.53.207.187:9876/relax-inn-server/clients?email=" + email + "&pwd=" + pwd;
        String get_client = "http://70.53.207.187:9876/relax-inn-server/clients";

        Client un_client_test = new Client(0, "null", "null", "null");//je peux rempacer firsname par null

        String x = "";

        try {
            x = new HttpGetRequest().execute(aranatest).get();

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Log.v("xa", x);
        if (x != null && !x.equals("null")) {
            un_client_test = Client.deserializeItem(x);
        }
        return un_client_test;


    }


}

