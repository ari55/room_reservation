package com.example.relaxinn.activitys;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.example.relaxinn.R;
import com.example.relaxinn.entity.Room;
import com.example.relaxinn.managers.ChambresManager;
import com.example.relaxinn.views.Accordeon;
import com.example.relaxinn.views.ImageGallery;
import com.example.relaxinn.views.InfoEstructure;
import com.example.relaxinn.views.ServicesStructure;

import java.util.ArrayList;

public class RoomActivity extends Activity {
    TextView tv_titre_view;

    //accordeons
    Accordeon view, les_servces;
    ArrayList<String> menu_string;
    LinearLayout ll_dinamic, ll_contianer_img, ll_services_container;
    Room un_room;
    String room_deserialize;
    Intent premierIntent;
    Button choisir, btn_fv;

    Context ctx;
    com.example.relaxinn.entity.View view_entite;
    InfoEstructure info_structure;
    String view_Result;
    int img_view;
    TextView tv_prix_par_nuit;
    static float prix;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);


        String parking = "Vue extérieure du parking pour prendre soin de votre voiture.";
        String rue = "Vue extérieure de la rue pour profiter de la ville.";
        String place = "Vue par la fenêtre vers une très belle place.";
        String mer = "Belle vue sur la plage depuis la fenêtre.";
        String montaigne = "Vue imprenable sur les montagnes, à apprécier en famille ou en couple.";
        String fleuve = "La nature abondante de votre fenêtre.";
//1/parking;2/rue;3/place;4/mer;5/montagne;6/fleuve


        ctx = this;
        premierIntent = getIntent();
        room_deserialize = premierIntent.getStringExtra("room");

        ll_contianer_img = findViewById(R.id.img_container);
        tv_prix_par_nuit = findViewById(R.id.prix_par_nuit);


        un_room = Room.deserializeItem(room_deserialize);
        ll_contianer_img.addView(new ImageGallery(ctx, un_room.getId()));

        ll_services_container = findViewById(R.id.sv_container_services);

        ll_services_container.addView(new ServicesStructure(this, un_room));
        view_entite = ChambresManager.get_view(un_room.getIdView());

        prix = un_room.getPrice();
        switch (view_entite.getId()) {

            case 1:

                view_Result = parking;
                img_view = R.drawable.view_parking;
                break;

            case 2:
                view_Result = rue;
                img_view = R.drawable.view_rue;

                break;
            case 3:
                view_Result = place;

                img_view = R.drawable.view_place;

                break;
            case 4:
                view_Result = mer;

                img_view = R.drawable.view_mer;

                break;
            case 5:
                view_Result = montaigne;
                img_view = R.drawable.view_montagne;

                break;
            case 6:
                view_Result = fleuve;
                img_view = R.drawable.view_fleuve;

                break;

        }

        info_structure = new InfoEstructure(this, view_Result, img_view);


        tv_prix_par_nuit.setText(String.valueOf("Prix par nuit : $ " + un_room.getPrice()));

        tv_titre_view = findViewById(R.id.titre_chambre);
        tv_titre_view.setText(un_room.getDescription());
        menu_string = new ArrayList<String>();

        view = new Accordeon(this, "View", info_structure);


        ll_dinamic = findViewById(R.id.sv_container_2);
        ll_dinamic.addView(view);

        ///les_servces

        //les_servces = new Accordeon(this, "Les services", null);
        //ll_dinamic.addView(les_servces);


        choisir = findViewById(R.id.choisir);


        choisir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                final LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View layoutFromMonXml = inflater.inflate(R.layout.dialog_pay, null);
                builder.setView(layoutFromMonXml);
                final AlertDialog dialog = builder.create();

                TextView iv_sub_total = layoutFromMonXml.findViewById(R.id.qty_nuits);
                TextView prix_nuit = layoutFromMonXml.findViewById(R.id.prix_dialog);

                Button btn_annuler = layoutFromMonXml.findViewById(R.id.btn_annuler);
                Button btn_reserve = layoutFromMonXml.findViewById(R.id.btn_reserve);


                Button btn_plus = layoutFromMonXml.findViewById(R.id.btn_increment);
                Button btn_moin = layoutFromMonXml.findViewById(R.id.btn_decrement);


                final TextView iv_qty = layoutFromMonXml.findViewById(R.id.qty_nuits);

                prix_nuit.setText("" + prix);
                btn_moin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer result = Integer.valueOf(iv_qty.getText().toString());
                        if (result == 0) {
                            result = 0;

                        } else {

                            result--;
                        }


                        iv_qty.setText(Integer.toString(result));
                    }
                });


                btn_plus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer result = Integer.valueOf(iv_qty.getText().toString());

                        result++;


                        iv_qty.setText(Integer.toString(result));
                    }
                });


                btn_annuler.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast toast1 = Toast.makeText(ctx, "Anule", Toast.LENGTH_SHORT);
                        toast1.show();
                        dialog.dismiss();

                    }
                });


                btn_reserve.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        Toast toast1 = Toast.makeText(ctx, "Rreserve", Toast.LENGTH_SHORT);
                        toast1.show();
                        dialog.dismiss();

                    }
                });


                dialog.show();
            }
        });

        btn_fv = findViewById(R.id.btn_add_favorites);

        btn_fv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast1 = Toast.makeText(ctx, "Ajoute a favorites", Toast.LENGTH_LONG);
                toast1.show();
            }
        });

    }

}
