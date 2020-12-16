package com.example.relaxinn.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.relaxinn.R;
import com.example.relaxinn.activitys.RoomActivity;
import com.example.relaxinn.entity.Room;
import com.example.relaxinn.managers.ChambresManager;

import java.util.List;

public class ChambresAdapter extends ArrayAdapter {

    Context ctx;
    int layout;

    public ChambresAdapter(@NonNull Context context, int resource, @NonNull List<Room> objects) {
        super(context, resource, objects);
        ctx = context;
        layout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Room unChambre = (Room) getItem(position);
        if (convertView == null) {
            LayoutInflater li = LayoutInflater.from(ctx);
            convertView = li.inflate(R.layout.chambre_item_du_collection, null);
        }

        TextView tv_chamabre_description_item = convertView.findViewById(R.id.tv_description);
        Button btn_chambre_voir = convertView.findViewById(R.id.btn_voir);
        LinearLayout nb_lits = convertView.findViewById(R.id.nb_lits);
        tv_chamabre_description_item.setText(unChambre.getDescription());

        btn_chambre_voir = convertView.findViewById(R.id.btn_voir);

        btn_chambre_voir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("cesar", "conecte");
            }
        });

        TextView tv_qty_simple = convertView.findViewById(R.id.qty_lit_simple);
        TextView tv_qty_double = convertView.findViewById(R.id.qty_lit_double);


        //tv_qty_simple.setText(Integer.toString(unChambre.getSingle_bed_number()));
        if (unChambre.getDoubleBedNumber() == 0) {
            tv_qty_double.setTextColor(Color.RED);
            tv_qty_double.setText("X");
        } else {
            tv_qty_double.setTextColor(ctx.getResources().getColor(R.color.qty_nb));
            tv_qty_double.setText(Integer.toString(unChambre.getDoubleBedNumber()));
        }
        if (unChambre.getSingleBedNumber() == 0) {
            tv_qty_simple.setTextColor(Color.RED);
            tv_qty_simple.setText("X");
        } else {
            tv_qty_simple.setTextColor(ctx.getResources().getColor(R.color.qty_nb));
            tv_qty_simple.setText(Integer.toString(unChambre.getSingleBedNumber()));
        }

        Button btn_voir = convertView.findViewById(R.id.btn_voir);

        btn_voir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, RoomActivity.class);

                int id = unChambre.getId();
                String id_stg = String.valueOf(id);

                intent.putExtra("room", Room.serialize(ChambresManager.get_room(id_stg)));
                ctx.startActivity(intent);
            }
        });
        return convertView;
    }
}
