package com.example.assignment1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {
    String tag = "A1-MainActivity";

    TextView display, historyDisplay;
    Button advanceBtn;
    private Calculator calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(tag, "in onCreate");

        display = findViewById(R.id.display);
        advanceBtn = findViewById(R.id.buttonAdvance);
        historyDisplay = findViewById(R.id.history);
    }

    public void operatorClick(View view) {
        String value = ((Button)view).getText().toString();

        if (calc.getClearDisplay()) {
            display.setText(calc.clear());
        }

        calc.push(value);
        display.setText(calc.getUserInput());
    }

    public void cancelClick(View view) {
        display.setText(calc.clear());
    }

    public void equalsClick(View view) {
        String value = ((Button)view).getText().toString();

        String sumString = Integer.toString(calc.calculate());
        Log.d("tag", "sumString Value: " + sumString);

        calc.push(value);
        calc.push(sumString);

        display.setText(calc.getUserInput());

        if (calc.getAdvanceMode()) {
            historyDisplay.setText(calc.updateHistory());
        }
    }

    public void advanceClick(View view) {
        String advanceText = calc.toggleAdvance();

        advanceBtn.setText(advanceText);
        historyDisplay.setText("");
    }

    @Override
    public void onClick(View view) {}

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag, "in onStart()");

        calc = new Calculator();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag, "in onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag, "in onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag, "in onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "in onDestroy");
    }
}