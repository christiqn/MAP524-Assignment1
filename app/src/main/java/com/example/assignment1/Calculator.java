package com.example.assignment1;


import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class Calculator extends AppCompatActivity {
    String tag = "Calculator Class";

    private List<Character> userInput = new ArrayList<>();
    private int num1;
    private int num2;
    private boolean num1Empty = true, advanceMode = false, clearDisplay = true;
    private char op;
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
        // convert list to string to return. The return value is what the new display will show
        userInputString = userInput.toString().substring(1, 3*userInput.size() - 1).replaceAll(", ", "");

        Log.d("tag", "userInputString Value: " + userInputString);

        Log.d(tag, "in getUserInput()");

        return userInputString;
    }

    int calculate() {
        Log.d(tag, "in calculate()");

        for (int i = 0; i < userInput.size(); i++) {
            if (num1Empty) {
                num1 = Character.getNumericValue(userInput.get(i));
                i++;

                num1Empty = false;
                Log.d("tag", "num1 Value: " + num1);

            }


            op = userInput.get(i);
            i++;

            Log.d("tag", "op Value: " + op);


            num2 = Character.getNumericValue(userInput.get(i));
            Log.d("tag", "num2 Value: " + num2);


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

//        while (!userInput.isEmpty()) {
//            if (num1Empty) {
//                num1 = Character.getNumericValue(userInput.get(0));
//                userInput.remove(0);
//
//                num1Empty = false;
//            }
//
//            op = userInput.get(0);
//            userInput.remove(0);
//
//            num2 = Character.getNumericValue(userInput.get(0));
//            userInput.remove(0);
//
//            if (op == '+') {
//                num1 += num2;
//            }
//            else if (op == '-') {
//                num1 -= num2;
//            }
//            else if (op == '*') {
//                num1 *= num2;
//            }
//            else {
//                num1 /= num2;
//            }
//        }
//
//        num1Empty = true;
//
//        return num1;
    }

    String clear() {
        Log.d(tag, "in clear()");

        userInput.clear();
        num1Empty = true;
//        clearDisplay = true;
        if (clearDisplay) {
            clearDisplay = false;
        }
        else {
            clearDisplay = true;
        }

        return "";
    }

    boolean getClearDisplay() {
        Log.d(tag, "in clearDisplay()");

        return clearDisplay;
    }

    void setClearDisplay() {
        Log.d(tag, "in setClearDisplay()");

        if (clearDisplay) {
            clearDisplay = false;
        }
        else {
            clearDisplay = true;
        }
    }

    String toggleAdvance() {
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
//        String userInputString = getUserInput();

//        historyArr.add(getUserInput());

//        int size = historyArr.length + 1;
//        String[] temp = new String[size];
//
//        for (int i = 0; i < size; i++) {
//            temp[i] = historyArr[i];
//        }
//
//        temp[size] = getUserInput();
//
//        historyArr = new String[size];
//
//        for (int i = 0; i < size + 1; i++) {
//            historyArr[i] = temp[i];
//        }


//        if (history == null) {
//            history = userInputString;
//        }
//        else {
        if (advanceMode) {
            history += userInputString + "\n";
        }
        else {
            history = "";
        }
//        }

        Log.d("tag", "history Value: " + history);

        return history;
    }

//    void addToHistoryArr() {
//        int size = historyArr.length;
//        String[] newArr = new String[size + 1];
//
//        for (int i = 0; i < size; i++) {
//            newArr[i] = historyArr[i];
//        }
//
//        newArr[size + 1] =
//    }

    boolean getAdvanceMode() {
        return advanceMode;
    }
}
