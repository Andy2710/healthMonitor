package com.myproject.healthmonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private EditText userName;
    private EditText userAge;
    private Button saveBtn1;
    private Button presBtn;
    private Button liveIndBtn;
    private TextView nameAuthor;
    private TextView nameTx;
    private ImageView imageHealth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        userName.requestFocus();
        presBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "pressure button clicked");
                Intent intent = new Intent(MainActivity. this, Main2Activity.class);
                startActivity(intent);
            }
        });
        liveIndBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "liveIndicator button clicked");
               Intent intent = new Intent(MainActivity. this, Main3Activity.class);
               startActivity(intent);
            }
        });
        saveBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v){
                Log.d(TAG, "save button clicked");
                String userNameStr =  userName.getText().toString();
                String ageStr = userAge.getText().toString();

                try{
                    int Age = Integer.parseInt(ageStr);
                    String result = "Имя: "+userNameStr+", Возраст: "+Age;
                    Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
                }catch (NumberFormatException e ){
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, R.string.incorrect_value, Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    private void init() {
        userName = findViewById(R.id.userName);
        userAge = findViewById(R.id.userAge);
        saveBtn1 = findViewById(R.id.saveBtn1);
        presBtn = findViewById(R.id.presBtn);
        liveIndBtn = findViewById(R.id.liveIndBtn);
        nameAuthor = findViewById(R.id.nameAuthor);
        nameTx = findViewById(R.id.nameTx);
        imageHealth = findViewById(R.id.imageHealth);
        Log.d(TAG,"All views initialized");
    }
}
