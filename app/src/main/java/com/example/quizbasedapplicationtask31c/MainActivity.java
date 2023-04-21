package com.example.quizbasedapplicationtask31c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import com.google.android.material.textfield.TextInputLayout;
import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button startButton;
    TextInputLayout nameTextInput;
    String username;
    Button calculatorButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        startButton = findViewById(R.id.startButton);
        calculatorButton = findViewById(R.id.calculatorButton);
        nameTextInput = findViewById(R.id.nameInputLayout);
        nameTextInput.getEditText().setText(username);
    }

    public void onStartButtonPressed(View view) {
        System.out.println("Start Button Pressed!");
        String name = nameTextInput.getEditText().getText().toString();
        if (name.matches("")) {
            showToast(getString(R.string.name_empty_error));
            return;
        }
        username = name;
        Intent quizIntent = new Intent(MainActivity.this, QuizActivity.class);
        quizIntent.putExtra("username", name);
        MainActivity.this.startActivity(quizIntent);
    }
    public void onCalculatorButtonPressed(View view) {
        System.out.println("Calculator Button Pressed!");
        Intent calculatorIntent = new Intent(MainActivity.this, CalculatorActivity.class);
        MainActivity.this.startActivity(calculatorIntent);
    }
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}