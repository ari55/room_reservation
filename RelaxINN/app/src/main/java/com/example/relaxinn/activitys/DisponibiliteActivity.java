package com.example.relaxinn.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.relaxinn.R;
import com.example.relaxinn.views.Accordeon;


public class DisponibiliteActivity extends Activity {
    //attributs from
    LinearLayout calendar_layout_from,calendar_layout_to,list_pays,list_etat,list_ville,fummeurReponse,dejeunerrReponse,dinnerReponse,souperReponse;
    LinearLayout layout_pour_accordeon_from,layout_pour_accordeon_to,layout_pour_accordeon_pays,layout_pour_accordeon_etat,layout_pour_accordeon_ville,layout_pour_accordeon_fummeur,layout_pour_accordeon_dejeuner,layout_pour_accordeon_dinner,layout_pour_accordeon_souper;
    Accordeon accordeon_from,accordeon_to,accordeon_pays,accordeon_etat,accordeon_ville,accordeon_fummeur,accordeon_dejeuner,accordeon_dinner,accordeon_souper;
//attributs to

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disponibilite_layout);
        //Accordeon "from" seulement
        layout_pour_accordeon_from = findViewById(R.id.injection_from_dispo);
        LayoutInflater inflaterFrom = LayoutInflater.from(this);
        calendar_layout_from = (LinearLayout) inflaterFrom.inflate(R.layout.calendar_from_layout, null);
        accordeon_from = new Accordeon(this, "From", calendar_layout_from);
        layout_pour_accordeon_from.addView(accordeon_from);
//------------------------------------
        //Accordeon "to" seulement
      layout_pour_accordeon_to = findViewById(R.id.injection_to_dispo);
        LayoutInflater inflaterTo = LayoutInflater.from(this);
        calendar_layout_to = (LinearLayout) inflaterTo.inflate(R.layout.calendar_from_layout, null);
        accordeon_to= new Accordeon(this, "To", calendar_layout_to);
        layout_pour_accordeon_to.addView((accordeon_to));
        //Accordeon Pays
       layout_pour_accordeon_pays = findViewById(R.id.injection_pays);
        LayoutInflater inflaterPays = LayoutInflater.from(this);
        list_pays = (LinearLayout) inflaterTo.inflate(R.layout.pays_etat_ville_layout, null);
       accordeon_pays= new Accordeon(this, "Pays", list_pays);
        layout_pour_accordeon_pays.addView((accordeon_pays));
        //Accordeon Etat
        layout_pour_accordeon_etat = findViewById(R.id.injection_etat);
        LayoutInflater inflaterEtat = LayoutInflater.from(this);
        list_etat = (LinearLayout) inflaterTo.inflate(R.layout.pays_etat_ville_layout, null);
        accordeon_etat= new Accordeon(this, "Etat", list_etat);
        layout_pour_accordeon_etat.addView((accordeon_etat));
        //Accordeon Ville
        layout_pour_accordeon_ville = findViewById(R.id.injection_ville);
        LayoutInflater inflaterVille = LayoutInflater.from(this);
        list_ville = (LinearLayout) inflaterTo.inflate(R.layout.pays_etat_ville_layout, null);
        accordeon_ville= new Accordeon(this, "Ville", list_ville);
        layout_pour_accordeon_ville.addView((accordeon_ville));
        //Accordeon Fummeur
        layout_pour_accordeon_fummeur = findViewById(R.id.ll_fumeur);
        LayoutInflater inflaterFummeur = LayoutInflater.from(this);
        fummeurReponse= (LinearLayout) inflaterTo.inflate(R.layout.pays_etat_ville_layout, null);
        accordeon_fummeur= new Accordeon(this, "Oui", fummeurReponse);
        layout_pour_accordeon_fummeur.addView((accordeon_fummeur));
        //Accordeon Dejeuner
        layout_pour_accordeon_dejeuner = findViewById(R.id.injection_dejeuner);
        LayoutInflater inflaterDejeuner = LayoutInflater.from(this);
        dejeunerrReponse= (LinearLayout) inflaterTo.inflate(R.layout.pays_etat_ville_layout, null);
        accordeon_dejeuner= new Accordeon(this, "Oui", dejeunerrReponse);
        layout_pour_accordeon_dejeuner.addView((accordeon_dejeuner));
        //Accordeon Dinner
        layout_pour_accordeon_dinner = findViewById(R.id.injection_dinner);
        LayoutInflater inflaterDinner = LayoutInflater.from(this);
        dinnerReponse= (LinearLayout) inflaterTo.inflate(R.layout.pays_etat_ville_layout, null);
        accordeon_dinner= new Accordeon(this, "Oui", dinnerReponse);
        layout_pour_accordeon_dinner.addView((accordeon_dinner));
        //Accordeon Souper
        layout_pour_accordeon_souper = findViewById(R.id.injection_Souper);
        LayoutInflater inflaterSouper = LayoutInflater.from(this);
        souperReponse= (LinearLayout) inflaterTo.inflate(R.layout.pays_etat_ville_layout, null);
        accordeon_souper= new Accordeon(this, "Oui", souperReponse);
        layout_pour_accordeon_souper.addView((accordeon_souper));
        }

        }