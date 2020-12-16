package com.example.relaxinn.activitys;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.relaxinn.R;
import com.example.relaxinn.entity.Client;
import com.example.relaxinn.managers.ClientManager;
import com.example.relaxinn.services.ConnectionHTTP;

public class LoginActivity extends AppCompatActivity {
    EditText edt_email, edt_password;
    Button btn_login, btn_inscrivez_vous;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        initViews();
        initListener();



    }

    private void initViews() {
        edt_email = findViewById(R.id.edt_email_login);
        edt_password = findViewById(R.id.edt_pwd_login);
        btn_login = findViewById(R.id.btn_login);
        btn_inscrivez_vous = findViewById(R.id.btn_inscrivez_vous);
    }

    private void initListener() {
       final Client clientTest = ClientManager.get_client(edt_email.getText().toString(), edt_password.getText().toString());

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("test click", edt_email.getText().toString());
                Log.v("test click", edt_password.getText().toString());
                if (edt_email.getText().toString() != null && edt_password.getText().toString() != null) {


                    Log.v("first", clientTest.getFirstName());
                    Log.v("last", clientTest.getLastName());
                    if (clientTest.getFirstName() != "null") {

                        Intent intent = new Intent(getApplicationContext(), ProfilActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),
                                "email ou mot de passe incorrect,veuillez ressayer ou vous inscrire0.", Toast.LENGTH_SHORT).show();

                    }
                }

               /* if ((!edt_email.getText().toString().equals("")) && (!edt_password.getText().toString().equals("")) && clientTest != null) {
//                   Client test = ClientManager.get_client("ateuboh@isi-mtl.com", "ateuboh");
                    // Log.v("test", "" + test.getFirstName());
                    Intent intent = new Intent(getApplicationContext(), ProfilActivity.class);
                    startActivity(intent);

                }
                else if((edt_email.getText().toString().equals(""))&&(edt_password.getText().toString().equals(""))){
                    Client test = ClientManager.get_client("ateuboh@isi-mtl.com", "ateuboh");

                    // Log.v("test", "" + test.getFirstName());
                    Intent intent = new Intent(getApplicationContext(), ProfilActivity.class);
                    startActivity(intent);

                }

                else if ((!edt_email.getText().toString().equals(""))) {
                    Toast.makeText(getApplicationContext(),
                            "le mot de passe est vide ", Toast.LENGTH_SHORT).show();
                } else if ((!edt_password.getText().toString().equals(""))) {
                    Toast.makeText(getApplicationContext(),
                            "Email est vide", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "l'email et le mot de passe sont vides", Toast.LENGTH_SHORT).show();
                }*/
            }
        });

        btn_inscrivez_vous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_recherche = new Intent(getApplicationContext(), InscriptionActivity.class);
                startActivity(intent_recherche);
            }
        });
    }
    //verifier la connection internet
   /*
                Client test = ClientManager.get_client("ateuboh@isi-mtl.com", "ateuboh");

                Log.v("test", "" + test.getFirstName());
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);*/
}


