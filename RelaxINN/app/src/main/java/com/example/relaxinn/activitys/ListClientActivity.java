package com.example.relaxinn.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.example.relaxinn.R;
import com.example.relaxinn.adapters.ClientAdapter;
import com.example.relaxinn.managers.ClientManagerTest;

public class ListClientActivity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client_listview);
        ListView lv = findViewById(R.id.lv_client);
        ClientAdapter clientAdapter = new ClientAdapter(this,R.layout.client_list, ClientManagerTest.getAll());
        lv.setAdapter(clientAdapter);
    }
}
