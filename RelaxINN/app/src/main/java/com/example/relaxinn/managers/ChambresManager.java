package com.example.relaxinn.managers;


import android.util.Log;
import android.view.ViewDebug;
import android.widget.EditText;

import com.example.relaxinn.entities.ChambreItemList;
import com.example.relaxinn.entity.Picture;
import com.example.relaxinn.entity.Room;
import com.example.relaxinn.entity.View;
import com.example.relaxinn.services.HttpGetRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ChambresManager {

    private static List<ChambreItemList> listChambres;
    private static List<Room> list_rooms;
    private static List<Picture> list_pictures;

    /* private static String rooms_all = "1/chambre 2 lits simples au calme, fumeur/1/1/2/0/49.99/true;2/chambre 1 lit double au calme/1/1/0/1/49.99/false;3/chambre familiale/1/1/2/1/74.99/false;4/chambre amoureux/2/2/0/1/63.49/true;5/chambre swingers/2/2/0/2/100.0/true;6/chambre deux lits simples/2/2/2/0/49.99/true;7/chambre deux lits simples, un lit double/3/3/2/1/74.99/false;8/chambre lit double/3/2/0/1/49.99/true;9/chambre avec belle vue sur la montagne/5/5/2/0/80.5/false";
     */

    private static String picture_all = "1/1/http://localhost:8080/relax-inn-server/room-pictures/hotelTemplate1/1doubleBedSample.jpg\n" +
            "2/2/http://localhost:8080/relax-inn-server/room-pictures/hotelTemplate1/2singleBedSample2.jpg\n" +
            "3/3/http://localhost:8080/relax-inn-server/room-pictures/hotelTemplate1/2doubleBedSample.jpg\n" +
            "4/4/http://localhost:8080/relax-inn-server/room-pictures/hotelTemplate1/2singleBedSample.jpg\n" +
            "5/4/http://localhost:8080/relax-inn-server/room-pictures/hotelTemplate2/bathroomSample.jpg\n" +
            "6/7/http://localhost:8080/relax-inn-server/room-pictures/hotelTemplate2/bathroomSample.jpg\n" +
            "7/8/http://localhost:8080/relax-inn-server/room-pictures/hotelTemplate1/2doubleBedSample2.jpg\n" +
            "8/9/http://localhost:8080/relax-inn-server/room-pictures/hotelTemplate2/2singleBedSample2.jpg\n" +
            "9/9/http://localhost:8080/relax-inn-server/room-pictures/hotelTemplate2/bathroomSample4.jpg";


    HttpGetRequest getRequest = new HttpGetRequest();


    public static List<Room> getAll_rooms() {

        String getAllRoms = "http://70.53.207.187:9876/relax-inn-server/rooms";

        String x = "";
        try {
            x = new HttpGetRequest().execute(getAllRoms).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.v("rx", x);
        list_rooms = new ArrayList<Room>();

        String result = "";

        Log.v("test1 ", result);

        Room[] rooms = Room.deserializeArray(x);

        for (Room un_room : rooms) {

            list_rooms.add(un_room);
        }

        return list_rooms;
    }

    public static Room get_room(String id) {

        String get_room = "http://70.53.207.187:9876/relax-inn-server/rooms?id=" + id;
        String x = "";

        try {
            x = new HttpGetRequest().execute(get_room).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Room un_room = Room.deserializeItem(x);

        return un_room;
    }


    public static View get_view(Integer id) {

        String id_strng = String.valueOf(id);
        String get_view = "http://70.53.207.187:9876/relax-inn-server/views?id=" + id_strng;

        String x = "";

        try {
            x = new HttpGetRequest().execute(get_view).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        View un_view = View.deserializeItem(x);

        return un_view;

    }




    public static List<Picture> getAll_pictures() {
        list_pictures = new ArrayList<Picture>();

        Picture[] pictures = Picture.deserializeArray(picture_all);

        for (Picture un_picture : pictures) {

            list_pictures.add(un_picture);
        }

        return list_pictures;
    }

}
