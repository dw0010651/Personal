package com.example.jaykang.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Timer;

public class TimerActivity extends Activity {

    private Button start;
    private Button reset;
    private TextView time;
    private TextView text1;
    private CountDownTimer countDownTimer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        start = (Button) findViewById(R.id.start);
        reset = (Button) findViewById(R.id.reset);
        time = (TextView) findViewById(R.id.timer);
        text1 = (TextView) findViewById(R.id.editText);


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.start:
                        start();
                        break;
                    case R.id.reset:
                        reset();
                        break;

                }
                text1.setText(String.valueOf(time));
            }
        };
        start.setOnClickListener(onClickListener);
        reset.setOnClickListener(onClickListener);

    }

    private void start(){

        countDownTimer = new CountDownTimer(Long.parseLong("string"), 1000){
            @Override
            public void onTick(long millisUntilFinished) {
                text1.setText("value ="+millisUntilFinished / 1000);
            }
            @Override
            public void onFinish() {
                text1.setText("Timesadasd's up!!!!!");
            }



       };
       countDownTimer.start();
    }

    private void reset(){
        if(countDownTimer != null){
            countDownTimer.cancel();
            countDownTimer = null;

        }
    }
}
