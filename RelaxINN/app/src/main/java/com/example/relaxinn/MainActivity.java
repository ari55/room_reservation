package com.example.relaxinn;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.relaxinn.activitys.ChambresCollectionActivity;

import com.example.relaxinn.activitys.DisponibiliteActivity;

import com.example.relaxinn.activitys.InfoActivity;
import com.example.relaxinn.activitys.LoginActivity;

import com.example.relaxinn.activitys.DisponibiliteActivity;
import com.example.relaxinn.entity.Client;
import com.example.relaxinn.managers.ClientManager;
import com.example.relaxinn.services.HttpGetRequest;

import java.util.concurrent.ExecutionException;

public class MainActivity extends Activity {
    ImageButton imageButtonConfig;
    LinearLayout ll_chambres_menu, ll_diponibilite;
    LinearLayout imageButtonLogin;
    LinearLayout info_service;

    String myUrl = "http://70.53.207.187:9876/relax-inn-server/rooms";
    public static String result;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctx = this;

        ll_chambres_menu = findViewById(R.id.chambres_menu);


      /*  ll_chambres_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ctx, ChambresCollectionActivity.class);

                //intent.putExtra("name", et_nom.getText().toString());



                startActivity(intent);
            }
        });*/


        //intent.putExtra("name", et_nom.getText().toString());
        imageButtonLogin = findViewById(R.id.img_login);
        imageButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Client test = ClientManager.get_client("ateuboh@isi-mtl.com", "ateuboh");

                Log.v("test", "" + test.getFirstName());


                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);

            }
        });


        ll_diponibilite = findViewById(R.id.ll_recherche_date);


        ll_diponibilite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent_recherche = new Intent(getApplicationContext(), DisponibiliteActivity.class);
                startActivity(intent_recherche);
            }
        });

        //inifo services
        info_service = findViewById(R.id.ll_service);

        info_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_info = new Intent(getApplicationContext(), InfoActivity.class);
                startActivity(intent_info);
            }
        });
    }

    //get chambres
    public void getChambres(View v) {
        Intent intent = new Intent(ctx, ChambresCollectionActivity.class);

        //   intent.putExtra("name", result);
        startActivity(intent);

    }

    //info services
}
