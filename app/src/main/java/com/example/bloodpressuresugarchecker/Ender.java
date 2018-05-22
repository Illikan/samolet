package com.example.bloodpressuresugarchecker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Ender extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ender);
        TextView textView = findViewById(R.id.textView5);
        int number = getIntent().getExtras().getInt("Number");
        textView.setText(" Ваш номер билета:" + number);

    }
    public void OnClick(View view){
        Intent intent = new Intent(Ender.this, MainActivity.class);
        startActivity(intent);
    }
}
