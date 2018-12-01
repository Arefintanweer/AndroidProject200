package com.arefin.puzzlegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    private static long back_pressed;
    public static final String EXTRA_MESSAGE = "Score ";
    public static final String EXTRA_MESSAGE1 = "Attempt ";

    Button playAgainButton;
    TextView timerTextView;
    TextView rsltTextView;
    TextView scoreTextView;
    TextView FinalTextView;
    TextView attemptTextView;

    public void playAgain(View view) {
        Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        playAgainButton = findViewById(R.id.playAgainButton);
        timerTextView = findViewById(R.id.timerTextView);
        rsltTextView = findViewById(R.id.rsltTextView);
        scoreTextView = findViewById(R.id.scoreTextView);
        FinalTextView = findViewById(R.id.finalTextView);
        attemptTextView = findViewById(R.id.attemptTextView);

        Intent intent = getIntent();
        String var = intent.getStringExtra(EXTRA_MESSAGE);
        String var1 = intent.getStringExtra(EXTRA_MESSAGE1);
        FinalTextView.setText("Your Score : " + var);
        attemptTextView.setText("You Tried : " + var1 + " times!");

    }

}



