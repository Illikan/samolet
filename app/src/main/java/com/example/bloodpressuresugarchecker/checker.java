package com.example.bloodpressuresugarchecker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by Кируша on 29.04.2018.
 */

public class checker extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checker);

    }
    public void OnClick(View view) {


        Intent intent = new Intent(checker.this, outputer.class);
        EditText editText = findViewById(R.id.input);
        intent.putExtra("ticket",Integer.parseInt(editText.getText().toString()) );
        startActivity(intent);

    }
}

