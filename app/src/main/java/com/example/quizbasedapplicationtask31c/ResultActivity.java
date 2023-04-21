package com.example.quizbasedapplicationtask31c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView resultTitleTextView;
    TextView yourScoreTextView;
    TextView scoreTextView;
    Button takeNewQuizButton;
    Button finishButton;

    String username;
    Integer correctAnswer;
    Integer totalQuestions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        correctAnswer = intent.getIntExtra("correctAnswer", 0);
        totalQuestions = intent.getIntExtra("totalQuestions", 5);


        resultTitleTextView = findViewById(R.id.resultTitleTextView);
        yourScoreTextView = findViewById(R.id.yourScoreTextView);
        scoreTextView = findViewById(R.id.scoreTextView);
        takeNewQuizButton = findViewById(R.id.takeNewQuizButton);
        finishButton = findViewById(R.id.finishButton);

        resultTitleTextView.setText("Congratulations "+username+"!");
        scoreTextView.setText(correctAnswer+"/"+totalQuestions);
    }
    public void onFinishButtonPressed(View view) {
        finish();
        System.exit(0);
    }
    public void onTakeNewQuizButtonPressed(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("username", username);
        startActivity(intent);
    }
}