package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {
    String tag = "Assignment1";

    TextView display;
    Button zeroBtn, oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn, sixBtn, sevenBtn, eightBtn, nineBtn;
    Button addBtn, subtractBtn, multiplyBtn, divideBtn;
    Button clearBtn, equalsBtn;
    Button advanceBtn;
//    ToggleButton advanceBtn;
    TextView historyDisplay;
    private Calculator calc;
    boolean clearDisplay = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(tag, "in onCreate");

        display = (TextView) findViewById(R.id.display);
        zeroBtn = (Button) findViewById(R.id.buttonZero);
//        zeroBtn.setOnClickListener(this);
        oneBtn = (Button) findViewById(R.id.buttonOne);
//        oneBtn.setOnClickListener(this);
        twoBtn = (Button) findViewById(R.id.buttonTwo);
//        twoBtn.setOnClickListener(this);
        threeBtn = (Button) findViewById(R.id.buttonThree);
//        threeBtn.setOnClickListener(this);
        fourBtn = (Button) findViewById(R.id.buttonFour);
//        fourBtn.setOnClickListener(this);
        fiveBtn = (Button) findViewById(R.id.buttonFive);
//        fiveBtn.setOnClickListener(this);
        sixBtn = (Button) findViewById(R.id.buttonSix);
//        sixBtn.setOnClickListener(this);
        sevenBtn = (Button) findViewById(R.id.buttonSeven);
//        sevenBtn.setOnClickListener(this);
        eightBtn = (Button) findViewById(R.id.buttonEight);
//        eightBtn.setOnClickListener(this);
        nineBtn = (Button) findViewById(R.id.buttonNine);
//        nineBtn.setOnClickListener(this);
        addBtn = (Button) findViewById(R.id.buttonAdd);
//        addBtn.setOnClickListener(this);
        subtractBtn = (Button) findViewById(R.id.buttonSubtract);
//        subtractBtn.setOnClickListener(this);
        multiplyBtn = (Button) findViewById(R.id.buttonMultiply);
//        multiplyBtn.setOnClickListener(this);
        divideBtn = (Button) findViewById(R.id.buttonDivide);
//        divideBtn.setOnClickListener(this);
        clearBtn = (Button) findViewById(R.id.buttonClear);
//        clearBtn.setOnClickListener(this);
        equalsBtn = (Button) findViewById(R.id.buttonEquals);
//        equalsBtn.setOnClickListener(this);
        advanceBtn = (Button) findViewById(R.id.buttonAdvance);
//        advanceBtn = (ToggleButton) findViewById(R.id.buttonAdvance);
//        advanceBtn.setOnClickListener(this);
        historyDisplay = (TextView) findViewById(R.id.history);
//        historyDisplay.setOnClickListener(this);

    }

    public void operClick(View view) {
        String value = ((Button)view).getText().toString();

        if (calc.getClearDisplay()) {
            display.setText(calc.clear());
        }

        calc.push(value);
        display.setText(calc.getUserInput());

//        display.append(value);
//        calc.push(value);
    }

    public void cancelClick(View view) {
        display.setText(calc.clear());
//        calc.clear();
    }

    public void equalsClick(View view) {
        String value = ((Button)view).getText().toString();

//        calc.push(value);
//        display.setText(calc.getUserInput());

        String sumString = Integer.toString(calc.calculate());
        Log.d("tag", "sumString Value: " + sumString);

        calc.push(value);
        calc.push(sumString);

        display.setText(calc.getUserInput());

        if (calc.getAdvanceMode()) {
            historyDisplay.setText(calc.updateHistory());
//            Log.d("tag", "list Value: " );

//            String test = list.toString().substring(1, 1*list.size());//.replaceAll(", ", "\n"));

//            historyDisplay.setText(test);

            // CORRECT SUBSTRING **********************************************
//            historyDisplay.setText(list.toString().substring(1, 3*list.size() - 1));//.replaceAll(", ", "\n"));
//            calc.updateHistory();
        }



//        display.setText(calc.push(value));
//        calc.calculate();
    }

    public void advanceClick(View view) {
        String advanceText = calc.toggleAdvance();

        advanceBtn.setText(advanceText);
        historyDisplay.setText("");
    }





    @Override
    public void onClick(View view) {
//        String value = ((Button)view).getText().toString();
//
//        if (view.getId() == R.id.buttonAdvance) {               // advance
//            if (advanceBtn.isChecked()) {
//                advanceBtn.setChecked(true);
//            }
//            else {
//                advanceBtn.setChecked(false);
//
//                historyDisplay.setText("");
//            }
//        }
//        else if (value.charAt(0) == 'C') {                      // clear
//            display.setText("");
//            calc.clear();
//        }
//        else if (value.charAt(0) == '=') {                      // equals
//            display.append(value);
//
//            int sum = calc.calculate();
//            String sumString = Integer.toString(sum);
//
//            display.append(sumString);
//
//            if (advanceBtn.isChecked()) {
//                historyDisplay.append(display.getText().toString());
//                historyDisplay.append("\n");
//            }
//
//            clearDisplay = true;
//        }
//        else {                                                  // numbers
//            if (clearDisplay) {
//                display.setText("");
//
//                clearDisplay = false;
//            }
//
//            display.append(value);
//            calc.push(value);
//        }
    }

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