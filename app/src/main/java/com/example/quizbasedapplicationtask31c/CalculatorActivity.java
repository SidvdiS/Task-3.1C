package com.example.quizbasedapplicationtask31c;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {
    EditText num1, num2;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        num1 = findViewById(R.id.number1EditText);
        num2 = findViewById(R.id.number2EditText);
        result = findViewById(R.id.resultTextView);
    }
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    public void handleAdd(View view){
        String firstNumberString = num1.getText().toString();
        if (firstNumberString.matches("")) {
            showToast("You did not enter the first number");
            return;
        }
        String secondNumberString = num2.getText().toString();
        if (secondNumberString.matches("")) {
            showToast("You did not enter the second number");
            return;
        }
        result.setText("Result = "+(Double.valueOf(firstNumberString)+Double.valueOf(secondNumberString)));
    }

    public void handleSub(View view){
        System.out.println("onSubtractButtonPressed");
        String firstNumberString = num1.getText().toString();
        if (firstNumberString.matches("")) {
            showToast("You did not enter the first number");
            return;
        }
        String secondNumberString = num2.getText().toString();
        if (secondNumberString.matches("")) {
            showToast("You did not enter the second number");
            return;
        }
        result.setText("Result = "+(Double.valueOf(firstNumberString)-Double.valueOf(secondNumberString)));
    }
}