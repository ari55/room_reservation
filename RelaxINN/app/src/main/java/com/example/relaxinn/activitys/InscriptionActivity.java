package com.example.relaxinn.activitys;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.example.relaxinn.R;

import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import static com.example.relaxinn.MainActivity.result;

public class InscriptionActivity  extends AppCompatActivity {
    EditText edt_email, edt_password;
    Button btn_login, btn_inscrivez_vous;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription);
        edt_email = findViewById(R.id.edt_email_login);
        edt_password = findViewById(R.id.edt_pwd_login);
        btn_login = findViewById(R.id.btn_login);
        btn_inscrivez_vous = findViewById(R.id.btn_inscrivez_vous);
    }


   private class AsyncTaskInscription extends AsyncTask<String,String,String> {
       int statusCode;

       @Override
       protected String doInBackground(String... strings) {
           InputStream inputStream;
           try {
               URL url = new URL("http://70.53.207.187:9876/relax-inn-server/clients");
               HttpURLConnection   httpURLConnection = (HttpURLConnection) url.openConnection();
               httpURLConnection.setDoInput(true);
               httpURLConnection.setDoOutput(true);
               httpURLConnection.setRequestMethod("POST");
               httpURLConnection.setRequestProperty("Accept","*/*");

               ContentValues values = new ContentValues();
               values.put("email", "abc@tjk.com");
               values.put("password", "hjh");
               values.put("name","hui");

               httpURLConnection.connect();

           OutputStream outputStream = httpURLConnection.getOutputStream();

             BufferedWriter  bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
               bufferedWriter.write(getQuery(values));
               bufferedWriter.flush();

               statusCode = httpURLConnection.getResponseCode();

             inputStream = httpURLConnection.getInputStream();

               if (statusCode == 200) {
                   InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                   int data = inputStreamReader.read();
                   while (data != -1) {
                       char current = (char) data;
                       result += current;
                       data = inputStreamReader.read();
                   }

                   JSONObject jsonObject = new JSONObject(result);

                   Log.i("Result",String.valueOf(jsonObject));

               } else {
                   Log.i("Result","false");
                   //return false;
               }

           } catch (Exception e) {

               e.printStackTrace();
           }/* finally {
               try {
                   if (inputStream != null) {
                       inputStream.close();
                   }
                   if (outputStream != null) {
                       outputStream.close();
                   }
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }*/
           return null;
       }
   }
    private String getQuery(ContentValues values) throws UnsupportedEncodingException
    {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (Map.Entry<String, Object> entry : values.valueSet())
        {
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(String.valueOf(entry.getValue()), "UTF-8"));
        }

        Log.i("Result",result.toString());

        return result.toString();
    }

}
