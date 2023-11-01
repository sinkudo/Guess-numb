package com.example.guess;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    int begin, end, mid;
    TextView message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent i = getIntent();
        begin = i.getIntExtra("begin", 0);
        end = i.getIntExtra("end", 100);
        message = findViewById(R.id.message);
        mid = (begin + end) / 2;
        askQuestion();
    }
    public void onClick(View view){
        if(view.getId() == R.id.yes){
            begin = mid+1;
            if(end - begin <= 0) {
                message.setText(String.format("Ваше число %d", end));
                new CountDownTimer(2000, 1000) {
                    public void onFinish() {
                        finish();
                    }

                    public void onTick(long millisUntilFinished) {
                        // millisUntilFinished    The amount of time until finished.
                    }
                }.start();
            }
            else {
                mid = (begin + end) / 2;
                askQuestion();
            }
        }
        else{
            end = mid;
            if(end - begin <= 0) {
                message.setText(String.format("Ваше число %d", begin));
                new CountDownTimer(2000, 1000) {
                    public void onFinish() {
                        finish();
                    }

                    public void onTick(long millisUntilFinished) {
                        // millisUntilFinished    The amount of time until finished.
                    }
                }.start();
            }
            else {
                mid = (begin + end) / 2;
                askQuestion();
            }
        }
        System.out.println(begin + " " + end);
    }
    public void askQuestion(){
        message.setText(String.format("ваше число больше %d ?", mid));
    }
}