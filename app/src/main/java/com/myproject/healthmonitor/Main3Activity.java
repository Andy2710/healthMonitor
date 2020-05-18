package com.myproject.healthmonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    private static final String TAG = Main3Activity.class.getSimpleName();
    private EditText weightEdTx;
    private EditText trekEdTx;
    private Button saveBtn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();
        weightEdTx.requestFocus();
        saveBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, getString(R.string.saveMain3));
                String weightEdTxStr = weightEdTx.getText().toString();
                String trekEdTxStr = trekEdTx.getText().toString();

                try {
                    int weight = Integer.parseInt(weightEdTxStr);
                    int trek = Integer.parseInt(trekEdTxStr);

                    String result = "Вес " + weight + ", кол.-во шагов " + trek;
                    Toast.makeText(Main3Activity.this, result, Toast.LENGTH_SHORT).show();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    Toast.makeText(Main3Activity.this, R.string.incorrect_value3, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void init() {
        weightEdTx = findViewById(R.id.weightEdTx);
        trekEdTx = findViewById(R.id.trekEdTx);
        saveBtn3 = findViewById(R.id.saveBtn3);
        Log.d(TAG,"All views initialized");
    }
}