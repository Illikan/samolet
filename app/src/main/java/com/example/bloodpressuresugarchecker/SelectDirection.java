package com.example.bloodpressuresugarchecker;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class SelectDirection extends AppCompatActivity {


    public String[] cities = new String[2];
    static String dest = "kek";


    //поток для соединения с БД
   private Zapros zapros;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_direction);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        String date1 = getIntent().getExtras().getString("date");
        final TextView textView = findViewById(R.id.textView6);
        final ListView list = (ListView) findViewById(R.id.cities);
        zapros = new Zapros();
        zapros.run(date1);
        try {
            zapros.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        ArrayList<String> cities = zapros.returner();


        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(SelectDirection.this,  android.R.layout.simple_list_item_1, cities);
        // Определяем разметку для использования при выборе элемента
        list.setAdapter(adapter);
        ArrayList<Integer> ids = zapros.retid();
if (cities.isEmpty() == true){
    textView.setText("НА ЭТУ ДАТУ НЕТ НИ ОДНОГО РЕЙСА");
}
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {
               dest =  ((TextView) itemClicked).getText().toString();
                System.out.println( ((TextView) itemClicked).getText().toString());

                Intent intent = new Intent(SelectDirection.this, Samolet.class);
                ArrayList<Integer> ids = zapros.retid();
                ArrayList<String> cities = zapros.returner();

                intent.putExtra("date",   getIntent().getExtras().getString("date"));
                intent.putExtra("destination", dest);
                intent.putExtra("id", ids.get(cities.indexOf(dest)));
                intent.putExtra("fio",getIntent().getExtras().getString("fio"));
                startActivity(intent);
            }
        });


        zapros.closer();


    }


}












