package com.example.bloodpressuresugarchecker;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Samolet extends AppCompatActivity{
    //Samolet
    //Samolet
    //Uvezi menya v polet
    //Samoleoot
    ZaprosOtSamoleta zaprosOtSamoleta ;
    int[] mass = new int[40];
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.samolet);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();//Samolet otmenyaet pravila
        StrictMode.setThreadPolicy(policy);
        final String date = getIntent().getExtras().getString("date");// получам дату полета
        final   String destination = getIntent().getExtras().getString("destination");// получаем маршрут полета
        final  String query ="select * from Race where RaceName =\""+destination+"\""+"and Date = \""+ date + "\"" ;// запрос на получение статуса мест
        zaprosOtSamoleta = new ZaprosOtSamoleta();
        zaprosOtSamoleta.run(date,destination,mass,query);//samolet poletel!!!
        try {
            zaprosOtSamoleta.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

            repaint(mass);

        zaprosOtSamoleta.closer();





    }

    public void OnClick(View view) {
        final String date = getIntent().getExtras().getString("date");// получам дату полета
        final   String destination = getIntent().getExtras().getString("destination");// получаем маршрут полета
        final  String query ="select FIO from Ticket where ID =\""+mass[Integer.parseInt((String) view.getTag())]+"\"";//запрашиваем фамилию пассажира на данном месте
      String fio = "kek";// если что-то сломается, то это писал не я

      if(mass[Integer.parseInt((String) view.getTag())]< 1){// тыкнули не на красную - записываем в массив номер тыкнутого места
           for (int i = 0; i < 40; i++) {
               if(mass[i] == -1){
                   mass[i] = 0;               }
           }
           mass[Integer.parseInt((String) view.getTag())] = -1;
           repaint(mass);//перекрашиваем кнопки

       }else{
           //alert вывод фамилии сидящего
          ZaprosFamilii zaprosFamilii = new ZaprosFamilii();

          zaprosFamilii.run(query,1);
          fio = zaprosFamilii.getFio();// получили ФИО сидящего
          System.out.println(mass[Integer.parseInt((String) view.getTag())]);
           Toast toast = Toast.makeText(getApplicationContext(),
                   fio, Toast.LENGTH_SHORT);
           toast.show();// вывели в виде тоста
          zaprosFamilii.closer();
       }



        }
    public void OnOplata(View view) {
        String fio = getIntent().getExtras().getString("fio");
        int id = getIntent().getExtras().getInt("id");
        int place = -2;
       for (int i = 0; i < mass.length; i++) {
            if(mass[i] == -1 ){
                 place = i+1;

            }
        }
        int number = generator();
        String query = "insert into Ticket (Number, FIO, RaceID,Place) values(\""+ number + "\"," +"\"" + fio + "\"," + "\"" + id + "\","+ "\"" + place + "\")";
        String idid = "SELECT LAST_INSERT_ID() as ID";
       OtpravkaDataTicket data = new OtpravkaDataTicket();
        data.run(query,idid,fio,id,place);


        int ilul =  data.getIds();
        data.closer();

        System.out.println(number);


        System.out.println(ilul);
        String qery = "update Race  set M"+ place + "= \"" + ilul + "\"" +"where ID =\"" + id + "\"";
        data.run(qery,idid,fio,id,place);
        data.closer();
        Intent intent = new Intent(Samolet.this, Ender.class);
        intent.putExtra("Number",number);
        startActivity(intent);


    }
    public int generator(){
        int ticket_number = (int) (10000000+Math.random()*99999999);

        return ticket_number;
    }



















        public void repaint(int[] mass){//перекрашиваем кнопки
        for (int i = 0; i <mass.length ; i++) {
           int id=0;
            switch (i){// для каждой кнопки
                case 0: id = R.id.M1;break;
                case 1:id = R.id.M2;break;
                case 2:id = R.id.M3;break;
                case 3:id = R.id.M4;break;
                case 4:id = R.id.M5;break;
                case 5:id = R.id.M6;break;
                case 6:id = R.id.M7;break;
                case 7:id = R.id.M8;break;
                case 8:id = R.id.M9;break;
                case 9:id = R.id.M10;break;
                case 10:id = R.id.M11;break;
                case 11:id = R.id.M12;break;
                case 12:id = R.id.M13;break;
                case 13:id = R.id.M14;break;
                case 14:id = R.id.M15;break;
                case 15:id = R.id.M16;break;
                case 16:id = R.id.M17;break;
                case 17:id = R.id.M18;break;
                case 18:id = R.id.M19;break;
                case 19:id = R.id.M20;break;
                case 20:id = R.id.M21;break;
                case 21:id = R.id.M22;break;
                case 22:id = R.id.M23;break;
                case 23:id = R.id.M24;break;
                case 24:id = R.id.M25;break;
                case 25:id = R.id.M26;break;
                case 26:id = R.id.M27;break;
                case 27:id = R.id.M28;break;
                case 28:id = R.id.M29;break;
                case 29:id = R.id.M30;break;
                case 30: id = R.id.M31;break;
                    case 31:id = R.id.M32;break;
                case 32:id = R.id.M33;break;
                case 33:id = R.id.M34;break;
                case 34:id = R.id.M35;break;
                case 35:id = R.id.M36;break;
                case 36:id = R.id.M37;break;
                case 37: id = R.id.M38;break;
                    case 38: id = R.id.M39;break;
                        case 39: id = R.id.M40;break;
            }
            switch (mass[i]){
                case 0:findViewById(id).setBackgroundColor(Color.parseColor("#c0c0c0"));break;// еслив массиве 0 - не тыкнули и не занятая - серая
                case -1:findViewById(id).setBackgroundColor(Color.parseColor("#228b22"));break;//если -1 - значит мы выбрали это место - зелененькая

            }
        if (mass[i] >0){
            findViewById(id).setBackgroundColor(Color.parseColor("#ff0000")); // если там записан ID сидящего - значит оно занято - красное
        }
        }
    }
}
