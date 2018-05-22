package com.example.bloodpressuresugarchecker;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.GregorianCalendar;


public class Datepicker extends Activity {


    private DatePicker mDatePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datepicker);
        Button button = (Button) findViewById(R.id.button);
        mDatePicker = (DatePicker) findViewById(R.id.datePicker);

        button.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
              String month = "";
                if((mDatePicker.getMonth() + 1)<10){
                  month ="0" + Integer.toString( mDatePicker.getMonth() + 1);
              }else {
                   month = Integer.toString( mDatePicker.getMonth() + 1);
              }
              String day = "";
                if((mDatePicker.getDayOfMonth())<10){
                    day ="0" + Integer.toString( mDatePicker.getDayOfMonth());
                }else {
                    day = Integer.toString( mDatePicker.getDayOfMonth());
                }

                CharSequence date = (CharSequence)  new StringBuilder().append(mDatePicker.getYear()) .append("-").append(month).append("-").append(day) ;
                GregorianCalendar calendar = new GregorianCalendar();
                if(calendar.after(new GregorianCalendar((mDatePicker.getYear()),(mDatePicker.getMonth()),mDatePicker.getDayOfMonth()+1))){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "К сожалению, самолет уже улетел", Toast.LENGTH_SHORT);
                    toast.show();
                }else {
                    Intent intent = new Intent(Datepicker.this, SelectDirection.class);
                    intent.putExtra("fio",getIntent().getExtras().getString("fio"));
                    intent.putExtra("date", date);
                    startActivity(intent);
                }


             }
        });
    }
}