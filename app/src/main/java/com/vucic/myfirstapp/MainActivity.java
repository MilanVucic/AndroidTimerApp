package com.vucic.myfirstapp;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final int TIME_TO_PLAY = 10000;
    public static final int COUNT_DOWN_INTERVAL = 1000;
    int clicks = 0;
    private TextView clickCountTextView;
    private Button resetButton;
    private Button clickingButton;
    private TextView timerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer_layout);
        clickCountTextView = findViewById(R.id.clickCountTextView);
        resetButton = findViewById(R.id.resetButton);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });
        timerTextView = findViewById(R.id.timerTextView);
        clickingButton = findViewById(R.id.clickingButton);
        startTimer();

        clickCountTextView.setText("0");
        clickingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClicked();
            }
        });
    }

    private void startTimer() {
        CountDownTimer countDownTimer = new CountDownTimer(TIME_TO_PLAY, COUNT_DOWN_INTERVAL) {
            @Override
            public void onTick(long millisUntilFinish) {
                timerTextView.setText("" + millisUntilFinish / 1000);
            }

            @Override
            public void onFinish() {
                clickingButton.setEnabled(false);
            }
        };
        countDownTimer.start();
    }

    private void resetGame() {
        clicks = 0;
        clickCountTextView.setText(Integer.toString(clicks));
        clickingButton.setEnabled(true);
        startTimer();
    }

    private void buttonClicked() {
        clicks++;
        clickCountTextView.setText(Integer.toString(clicks));
    }

}