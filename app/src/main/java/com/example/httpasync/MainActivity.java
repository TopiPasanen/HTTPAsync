package com.example.httpasync;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

     EditText osoiteLoota;
     TextView dataLoota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.Gogogo).setOnClickListener(this);
        osoiteLoota = (EditText) findViewById(R.id.osoiteLoota);
        dataLoota = (TextView) findViewById(R.id.dataLoota);
    }

    @Override
    public void onClick(View v) {
        AsyncPuoli asyncPuoli = new AsyncPuoli();
        EditText editText = findViewById(R.id.osoiteLoota);
        try{
            String tulos = asyncPuoli.execute(editText.getText().toString()).get();
            dataLoota.setText(tulos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
