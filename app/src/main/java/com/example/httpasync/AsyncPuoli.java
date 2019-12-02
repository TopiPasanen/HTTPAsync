package com.example.httpasync;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncPuoli extends AsyncTask <String, Void, String> {

    @Override
    protected String doInBackground(String... strings) {
        String strinki = strings[0];
        String tyhjanPantti = "";

        try {
            URL url;
            url = new URL(strinki);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            tyhjanPantti = fromStream(urlConnection.getInputStream());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tyhjanPantti;
    }

    @Override
    protected void onPostExecute(String tyhjanPantti) {
        super.onPostExecute(tyhjanPantti);
    }

    public static String fromStream(InputStream in) throws IOException{
        BufferedReader reader = new BufferedReader((new InputStreamReader(in)));
        StringBuilder out = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        String line;
        while((line = reader.readLine())!= null){
            out.append(line);
            out.append(newLine);
        }
        return out.toString();
    }

}