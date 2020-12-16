package com.example.relaxinn.activitys;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.relaxinn.MainActivity;
import com.example.relaxinn.R;
import com.example.relaxinn.views.Accordeon;

public class ProfilActivity extends Activity {
    LinearLayout ll, ll_profil, ll_reservation, ll_derniere_recherche, ll_liste, ll_commentaire;
    Accordeon accordeon;
    Button btn_logout;
    Button btn_login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil);

        btn_logout = findViewById(R.id.btn_login);
        btn_login = findViewById(R.id.btn_login);

        ll = findViewById(R.id.profil_reservation);
        ll_derniere_recherche = findViewById(R.id.derniere_recherche);
        ll_liste = findViewById(R.id.liste_prefere);
        ll_commentaire = findViewById(R.id.commentaire);

        LayoutInflater inflaterFrom = LayoutInflater.from(this);
        ll_profil = (LinearLayout) inflaterFrom.inflate(R.layout.profil, null);
        accordeon = new Accordeon(this, "", ll_profil);
        ll.addView(accordeon);

        LayoutInflater inflate = LayoutInflater.from(this);
        ll_profil = (LinearLayout) inflate.inflate(R.layout.profil, null);
        accordeon = new Accordeon(this, "", ll_profil);
        ll_derniere_recherche.addView(accordeon);
        LayoutInflater inflate2 = LayoutInflater.from(this);
        ll_profil = (LinearLayout) inflate2.inflate(R.layout.profil, null);
        accordeon = new Accordeon(this, "", ll_profil);
        ll_liste.addView(accordeon);
        LayoutInflater inflater3 = LayoutInflater.from(this);
        ll_profil = (LinearLayout) inflater3.inflate(R.layout.profil, null);
        accordeon = new Accordeon(this, "", ll_profil);
        ll_commentaire.addView(accordeon);
        LayoutInflater inflate4 = LayoutInflater.from(this);
        ll_profil = (LinearLayout) inflate4.inflate(R.layout.profil, null);
        accordeon = new Accordeon(this, "", ll_profil);
        ll_derniere_recherche.addView(accordeon);


    }
}
