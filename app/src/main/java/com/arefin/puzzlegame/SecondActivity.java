package com.arefin.puzzlegame;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class SecondActivity extends AppCompatActivity {

        String op=" ";
        ArrayList<Integer> answers = new ArrayList<Integer>();
        int locationOfCorrectAnswer;
        int score=0;
        int numberOfQuestions=0;
        TextView rsltTextView;
        TextView scoreTextView;
        TextView sumTextView;
        TextView timerTextView;
        Button button0;
        Button button1;
        Button button2;
        Button button3;


        public void chooseAnswer(View view){
            if(Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString())){
                rsltTextView.setText("Correct!");
                score++;
            }else{
                rsltTextView.setText("Wrong :(");
            }
            numberOfQuestions++;
            scoreTextView.setText(Integer.toString(score) + "/" +Integer.toString(numberOfQuestions));
            newQuestion();
        }

        public void newQuestion(){

           Random rand = new Random();

            int a=rand.nextInt(21);
            int b=rand.nextInt(21);
            int operation = (int) (Math.random() * 3) + 1;

            if(operation==1)
                op="+";
            else if(operation==2)
                op="-";
            else if(operation==3)
                op="*";

            if(op=="+") {
                sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));
            }
            else if(op=="-") {
                sumTextView.setText(Integer.toString(a) + " - " + Integer.toString(b));
            }
            else if(op=="*") {
                sumTextView.setText(Integer.toString(a) + " * " + Integer.toString(b));
            }

            locationOfCorrectAnswer = rand.nextInt(4);

            answers.clear();

            for(int i=0;i<4;i++){

                if(i==locationOfCorrectAnswer && op=="+"){
                    answers.add(a+b);
                }else if(i== locationOfCorrectAnswer && op=="-"){
                    answers.add(a-b);
                }else if(i== locationOfCorrectAnswer && op=="*") {
                    answers.add(a * b);
                } else{
                    int wrongAnswer = rand.nextInt(41);
                    while(wrongAnswer == a+b || wrongAnswer== a-b || wrongAnswer == a*b){
                        wrongAnswer = rand.nextInt(41);
                    }
                    answers.add(wrongAnswer);
                }
            }
            button0.setText(Integer.toString(answers.get(0)));
            button1.setText(Integer.toString(answers.get(1)));
            button2.setText(Integer.toString(answers.get(2)));
            button3.setText(Integer.toString(answers.get(3)));
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        sumTextView = findViewById(R.id.sumTextView);
        button0 = findViewById(R.id.Button0);
        button1 = findViewById(R.id.Button1);
        button2 = findViewById(R.id.Button2);
        button3 = findViewById(R.id.Button3);
        rsltTextView = findViewById(R.id.rsltTextView);
        scoreTextView=findViewById(R.id.scoreTextView);
        timerTextView = findViewById(R.id.timerTextView);

        newQuestion();

        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long l) {
                    timerTextView.setText(String.valueOf(l/1000)+"s");
            }

            @Override
            public void onFinish() {
                rsltTextView.setText("Done!");
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                intent.putExtra(ThirdActivity.EXTRA_MESSAGE, Integer.toString(score));
                intent.putExtra(ThirdActivity.EXTRA_MESSAGE1, Integer.toString(numberOfQuestions));
                startActivity(intent);
            }
        }.start();

    }
}
