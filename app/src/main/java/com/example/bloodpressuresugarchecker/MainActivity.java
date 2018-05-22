package com.example.bloodpressuresugarchecker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.bron);
        final CheckBox checkBox = findViewById(R.id.checkBox);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                EditText fio =  findViewById(R.id.fio);

                if (fio.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
 Toast toast = Toast.makeText(getApplicationContext(),
                          "Пожалуйста введите свои ФИО", Toast.LENGTH_SHORT);
                  toast.show();
                }
                else
                {
                 if(checkBox.isChecked() == false){
                     Toast toast = Toast.makeText(getApplicationContext(),
                             "К сожалению эту программу нельзя использовать не согласившись с условиями", Toast.LENGTH_SHORT);
                     toast.show();
                 }else {
                     Intent intent1 = new Intent(MainActivity.this, Datepicker.class);

                     intent1.putExtra("fio", fio.getText().toString());
                     startActivity(intent1);
                 }

                }

            }
        });
    }

    public void OnClick(View v) {
        //переход на экран с выбором даты
        Intent intent2 = new Intent(MainActivity.this, checker.class);//переход на экран с вводом номера билета
        startActivity(intent2);





    }
}
