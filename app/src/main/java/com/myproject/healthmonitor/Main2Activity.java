package com.myproject.healthmonitor;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;


public class Main2Activity extends AppCompatActivity {
    private static final String TAG = Main2Activity.class.getSimpleName();
    private EditText upperEdTx;
    private EditText lowerEdTx;
    private EditText pulseEdTx;
    private EditText dateEdTx;
    private Button saveBtn2;
    private Switch tahSw;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        upperEdTx.requestFocus();
        saveBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, getString(R.string.saveMain2));
                String upperStr = upperEdTx.getText().toString();
                String lowerStr = lowerEdTx.getText().toString();
                String pulseStr = pulseEdTx.getText().toString();
                boolean haveTah = tahSw.isChecked();

                try {
                    int upper = Integer.parseInt(upperStr);
                    int lower = Integer.parseInt(lowerStr);
                    int pulse = Integer.parseInt(pulseStr);

                    String result = "Верхнее давление " + upper + ", нижнее давление " + lower + ", пульс " + pulse;
                    Toast.makeText(Main2Activity.this, result, Toast.LENGTH_SHORT).show();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    Toast.makeText(Main2Activity.this, R.string.incorrect_value2, Toast.LENGTH_SHORT).show();


                }
            }
        });


    }

    private void init() {
        upperEdTx = findViewById(R.id.upperEdTx);
        lowerEdTx = findViewById(R.id.lowerEdTx);
        pulseEdTx = findViewById(R.id.pulseEdTx);
        dateEdTx = findViewById(R.id.dateEdTx);
        saveBtn2 = findViewById(R.id.saveBtn2);
        tahSw = findViewById(R.id.tahSw);
        Log.d(TAG,"All views initialized");
    }


}
