/*package com.example.relaxinn.managers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.relaxinn.entity.Room;
import com.example.relaxinn.services.HttpGetRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class PaysManager {

    public static List<String> allPays(Context ctx) {
        List<String> liste_pays ;
        String queryGetAllPays ="http://70.53.207.187:9876/relax-inn-server/countries";
        HttpGetRequest getRequest = new HttpGetRequest();


        public static List<String> getAll_pays(){
        String x = "";
        try {
            x = new HttpGetRequest().execute(queryGetAllPays).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.v("rx", x);
        all_pays = new ArrayList<String>();

        String result = "";

        Log.v("test1 ", result);

        Room[] rooms = Room.deserializeArray(x);

        for (Room un_room : rooms) {

            lis.add(un_room);
        }

        return list_rooms;
    }
}
*/