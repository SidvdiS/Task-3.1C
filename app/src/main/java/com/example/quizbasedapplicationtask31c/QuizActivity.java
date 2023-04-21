package com.example.quizbasedapplicationtask31c;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class QuizActivity extends AppCompatActivity {

    TextView welcomeTitle;
    TextView currentQuestionNumber;
    ProgressBar quizProgressBar;
    TextView quizQuestion;
    TextView quizQuestionDetails;

    Button option1Button;
    Button option2Button;
    Button option3Button;
    Button option4Button;
    Button submitButton;

    String username;

    Integer currentQuestion = 0;
    Integer correctAnswer = 0;
    Integer totalQuestions = 5;
    Boolean selectedOption = false;
    private ArrayList<Quiz> quizzes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        populateQuiz();
        Intent intent = getIntent();
        username = intent.getStringExtra("username");

        welcomeTitle = findViewById(R.id.welcomeTitle);
        currentQuestionNumber = findViewById(R.id.currentQuestionNumber);
        quizProgressBar = findViewById(R.id.QuizProgressBar);
        quizQuestion = findViewById(R.id.quizQuestion);
        quizQuestionDetails = findViewById(R.id.quizQuestionDetails);
        option1Button = findViewById(R.id.option1Button);
        option2Button = findViewById(R.id.option2Button);
        option3Button = findViewById(R.id.option3Button);
        option4Button = findViewById(R.id.option4Button);
        submitButton = findViewById(R.id.submitButton);

        welcomeTitle.setText("Welcome "+username+"!");
        populateQuizUI();
        refreshProgressBar();
    }
    @Override
    public void onRestart() {
        super.onRestart();
        currentQuestion = 0;
        correctAnswer = 0;
        totalQuestions = 5;
        selectedOption = false;
        refreshProgressBar();
        populateQuizUI();
        refreshNextButton();
        resetOptionsBackgroundColor();
    }
    private void populateQuiz() {
        Quiz quiz1 = new Quiz("Which of the following kernel is used in Android?", "Please select one", "MAC", "Windows", "Linux", "Redhat", "Linux");
        Quiz quiz2 = new Quiz("APK stands for -", "Please select one", "Android Phone Kit", "Android Page Kit", "Android Package Kit", "None of the above", "Android Package Kit");
        Quiz quiz3 = new Quiz("Which of the following is the first callback method that is invoked by the system during an activity life-cycle?", "Please select one", "onClick() method", "onCreate() method", "onStart() method", "onRestart() method", "onCreate() method");
        Quiz quiz4 = new Quiz("We require an AVD to create an emulator. What does AVD stand for?", "Please select one", "Android Virtual device", "Android Virtual display", "Active Virtual display", "Active Virtual device", "Android Virtual device");
        Quiz quiz5 = new Quiz("What is an activity in android?", "Please select one", "android class", "android package", "A single screen in an application with supporting java code", "None of the above", "A single screen in an application with supporting java code");

        quizzes = new ArrayList<>(Arrays.asList(quiz1, quiz2, quiz3, quiz4, quiz5));
    }

    private void populateQuizUI() {
        Quiz quiz = quizzes.get(currentQuestion);
        quizQuestion.setText(quiz.getQuestion());
        quizQuestionDetails.setText(quiz.getQuestionDetails());
        option1Button.setText(quiz.getOption1());
        option2Button.setText(quiz.getOption2());
        option3Button.setText(quiz.getOption3());
        option4Button.setText(quiz.getOption4());
    }

    private void refreshNextButton() {
        if (selectedOption) {
            submitButton.setText(getString(R.string.quiz_next_button));
        } else {
            submitButton.setText(getString(R.string.quiz_submit_button));
        }
    }
    @SuppressLint("SetTextI18n")
    private void refreshProgressBar() {
        quizProgressBar.setProgress(currentQuestion+1);
        currentQuestionNumber.setText(currentQuestion+1+"/"+totalQuestions);
    }

    private void colorCorrectAnswer(Quiz quiz) {
        if (option1Button.getText().toString() == quiz.getCorrectAnswer()) {
            option1Button.setBackgroundColor(getResources().getColor(R.color.green));
        } else if (option2Button.getText().toString() == quiz.getCorrectAnswer()) {
            option2Button.setBackgroundColor(getResources().getColor(R.color.green));
        } else if (option3Button.getText().toString() == quiz.getCorrectAnswer()) {
            option3Button.setBackgroundColor(getResources().getColor(R.color.green));
        } else if (option4Button.getText().toString() == quiz.getCorrectAnswer()) {
            option4Button.setBackgroundColor(getResources().getColor(R.color.green));
        }
    }



    public void option1ButtonPressed(View view) {
        System.out.println("option1ButtonPressed!");
        Quiz quiz = quizzes.get(currentQuestion);
        selectedOption = true;
        if (quiz.getCorrectAnswer() != option1Button.getText().toString()) {
            option1Button.setBackgroundColor(getResources().getColor(R.color.red));
        } else {
            correctAnswer++;
        }
        refreshNextButton();
        colorCorrectAnswer(quiz);
    }

    public void option2ButtonPressed(View view) {
        System.out.println("option2ButtonPressed!");
        Quiz quiz = quizzes.get(currentQuestion);
        if (quiz.getCorrectAnswer() != option2Button.getText().toString()) {
            option2Button.setBackgroundColor(getResources().getColor(R.color.red));
        } else {
            correctAnswer++;
        }
        selectedOption = true;
        refreshNextButton();
        colorCorrectAnswer(quiz);
    }

    public void option3ButtonPressed(View view) {
        System.out.println("option3ButtonPressed!");
        Quiz quiz = quizzes.get(currentQuestion);
        if (quiz.getCorrectAnswer() != option3Button.getText().toString()) {
            option3Button.setBackgroundColor(getResources().getColor(R.color.red));
        } else {
            correctAnswer++;
        }
        selectedOption = true;
        refreshNextButton();
        colorCorrectAnswer(quiz);
    }

    public void option4ButtonPressed(View view) {
        System.out.println("option4ButtonPressed!");
        Quiz quiz = quizzes.get(currentQuestion);
        if (quiz.getCorrectAnswer() != option4Button.getText().toString()) {
            option4Button.setBackgroundColor(getResources().getColor(R.color.red));
        } else {
            correctAnswer++;
        }
        selectedOption = true;
        refreshNextButton();
        colorCorrectAnswer(quiz);
    }
    public void submitButtonPressed(View view) {
        System.out.println("submitButtonPressed!");
        if (!selectedOption) {
            showToast("Please select an answer first");
            return;
        }
        if (currentQuestion == 4) {
            System.out.println("Quiz Done! Moving to next activity");
            Intent resultIntent = new Intent(QuizActivity.this, ResultActivity.class);
            resultIntent.putExtra("username", username);
            resultIntent.putExtra("correctAnswer", correctAnswer);
            resultIntent.putExtra("totalQuestions", totalQuestions);
            QuizActivity.this.startActivity(resultIntent);
            return;
        }
        welcomeTitle.setVisibility(View.GONE);
        currentQuestion++;
        selectedOption = false;
        populateQuizUI();
        refreshNextButton();
        refreshProgressBar();
        resetOptionsBackgroundColor();
    }

    private void resetOptionsBackgroundColor() {
        option1Button.setBackgroundColor(getResources().getColor(R.color.black_200));
        option2Button.setBackgroundColor(getResources().getColor(R.color.black_200));
        option3Button.setBackgroundColor(getResources().getColor(R.color.black_200));
        option4Button.setBackgroundColor(getResources().getColor(R.color.black_200));
    }
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}