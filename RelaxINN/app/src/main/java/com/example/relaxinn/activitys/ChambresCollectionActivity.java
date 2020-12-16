package com.example.relaxinn.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.relaxinn.R;
import com.example.relaxinn.adapters.ChambresAdapter;
import com.example.relaxinn.managers.ChambresManager;
import com.example.relaxinn.services.ConnectionHTTP;

public class ChambresCollectionActivity extends Activity {

    ListView lv_chambres;
    TextView tv_response;
    Intent premierIntent;
    String msg_return;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chambres_collection_activity);
        lv_chambres = findViewById(R.id.lv_chambres_collection);
        String getAllRoms = "http://70.53.207.187:9876/relax-inn-server/rooms";

        premierIntent = getIntent();
        msg_return = premierIntent.getStringExtra("name");

        tv_response = new TextView(this);
        ChambresAdapter cbrsAdapter = new ChambresAdapter(this, R.layout.chambre_item_du_collection, ChambresManager.getAll_rooms());
        // ChambresAdapter cbrsAdapter = new ChambresAdapter(this, R.layout.chambre_item_du_collection,         new ConnectionHTTP().envoiResponse(getAllRoms + ((EditText) findViewById(R.id.et)).getText().toString());

        lv_chambres.setAdapter(cbrsAdapter);

    }
}
