package com.example.bloodpressuresugarchecker;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class outputer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outputer);
        int number = getIntent().getExtras().getInt("ticket");
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();//Samolet otmenyaet pravila
        StrictMode.setThreadPolicy(policy);
        String[] mass ={"A1","B1","C1","D1","A2","B2","C2","D2","A3","B3","C3","D3","A4","B4","C4","D4","A5","B5","C5","D5","A6","B6","C6","D6","A7","B7","C7","D7","A8","B8","C8","D8","A9","B9","C9","D9","A10","B10","C10","D10"};
        TextView fiot = findViewById(R.id.fio);
        TextView datet = findViewById(R.id.date);
        TextView racenamet = findViewById(R.id.racename);
        TextView placet = findViewById(R.id.place);
        String fio = "";
        String date = "";
        String racename = "";
        int place = 0;
        zaprosdannixpobiletu zap= new zaprosdannixpobiletu();
        zap.run(number);
        fio = zap.getFio();
        place = zap.getPlace();
        date = zap.getDate();
        racename = zap.getRacename();

        if(place!= 0 ){
           fiot.setText( "Пассажир:" + fio);
           datet.setText("Дата вылета:" + date);
           racenamet.setText("Название рейса:" + racename);
           placet.setText("Место номер:" + mass[place-1]);
       }else{
           placet.setText("БИЛЕТ С ТАКИМ НОМЕРОМ НЕ ЗАРЕГИСТРИРОВАН");
       }

        zap.closer();
    }
    public void OnClick(View view){
        Intent intent = new Intent(outputer.this, MainActivity.class);
        startActivity(intent);
    }
}
