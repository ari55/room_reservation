package com.example.relaxinn.services;

import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectionHTTP {

    final static String ip_hotel = "http://70.53.207.187:9876/relax-inn-server/";

    public static void envoiResponse() {

        URL url;
        HttpURLConnection urlConnection = null;
        try {
            url = new URL(ip_hotel);


            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = urlConnection.getInputStream();

            InputStreamReader isw = new InputStreamReader(in);

            int data = isw.read();
            while (data != -1) {
                char current = (char) data;
                data = isw.read();
                Log.v("Response", "" + data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }
}
