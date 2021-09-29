package com.example.assignment1;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Calculator extends AppCompatActivity {
    String tag = "A1-Calculator";

    private final List<Character> userInput = new ArrayList<>();
    private int num1;
    private boolean num1Empty = true, advanceMode = false, clearDisplay = true;
    private String userInputString;
    private String history = "";

    void push(String value) {
        Log.d(tag, "in push()");

        // add value to list
        for (int i = 0; i < value.length(); i++) {
            userInput.add(value.charAt(i));
        }
    }

    String getUserInput() {
        Log.d(tag, "in getUserInput()");

        // convert list to string to return. The return value is what the new display will show
        userInputString = userInput.toString().substring(1, 3*userInput.size() - 1).replaceAll(", ", "");

        return userInputString;
    }

    int calculate() {
        Log.d(tag, "in calculate()");

        for (int i = 0; i < userInput.size(); i++) {
            if (num1Empty) {
                num1 = Character.getNumericValue(userInput.get(i));
                i++;

                num1Empty = false;
            }

            char op = userInput.get(i);
            i++;

            int num2 = Character.getNumericValue(userInput.get(i));

            if (op == '+') {
                num1 += num2;
            }
            else if (op == '-') {
                num1 -= num2;
            }
            else if (op == '*') {
                num1 *= num2;
            }
            else {
                num1 /= num2;
            }
        }

        clearDisplay = true;
        num1Empty = true;

        return num1;
    }

    String clear() {
        Log.d(tag, "in clear()");

        userInput.clear();
        num1Empty = true;
        clearDisplay = !clearDisplay;

        return "";
    }

    boolean getClearDisplay() {
        Log.d(tag, "in clearDisplay()");

        return clearDisplay;
    }

    String toggleAdvance() {
        Log.d(tag, "in toggleAdvance()");

        String ret;

        if (advanceMode) {
            advanceMode = false;

            history = "";

            ret = "ADVANCE - WITH HISTORY";
        }
        else {
            advanceMode = true;

            ret = "STANDARD - NO HISTORY";
        }

        return ret;
    }

    String updateHistory() {
        if (advanceMode) {
            history += userInputString + "\n";
        }
        else {
            history = "";
        }

        return history;
    }

    boolean getAdvanceMode() {
        return advanceMode;
    }
}
