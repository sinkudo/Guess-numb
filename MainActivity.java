package com.example.guess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        EditText begin = findViewById(R.id.begin);
        EditText end = findViewById(R.id.end);
        Intent i = new Intent(getApplicationContext(), GameActivity.class);
        int b = Integer.parseInt(begin.getText().toString());
        int e = Integer.parseInt(end.getText().toString());

        i.putExtra("begin", b);
        i.putExtra("end", e);
        startActivity(i);
    }
}