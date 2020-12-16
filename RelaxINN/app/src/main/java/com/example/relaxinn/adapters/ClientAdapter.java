package com.example.relaxinn.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.relaxinn.R;
import com.example.relaxinn.entity.Client;

import java.util.List;

public class ClientAdapter extends ArrayAdapter<Client> {
    int layout;
    Context ctx;

    public ClientAdapter(@NonNull Context context, int resource, @NonNull List<Client> objects) {
        super(context, resource, objects);
        layout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // return super.getView(position, convertView, parent);
        Client client = getItem(position);
        if (convertView == null) {
            LayoutInflater li = LayoutInflater.from(ctx);
            convertView = li.inflate(R.layout.client_listview, null);
        }
        TextView nom = convertView.findViewById(R.id.first_name_list);
        TextView prenom = convertView.findViewById(R.id.last_name_list);
        TextView email = convertView.findViewById(R.id.email_list);
        TextView pwd = convertView.findViewById(R.id.pwd_list);
        //nom.setText(client.getFirstName());
        //prenom.setText(client.getLastName());
        //email.setText(client.getEmail());
        return convertView;
    }
}
