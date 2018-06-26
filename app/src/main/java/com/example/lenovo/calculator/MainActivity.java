package com.example.lenovo.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    private TextView resultDisplay;
    private TextView temporaryDisplay;

    private Button zero, one, two, three, four, five, six, seven, eight, nine;
    private Button plus, minus, multiply, divide;
    private Button equal, delete;

    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQUAL = 0;

    private char ACTION;

    private double val1 = Double.NaN;
    private double val2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setIDs();

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temporaryDisplay.setText(temporaryDisplay.getText().toString() + "0");
                //concatenating 0 with previosuly typed in number buttons
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temporaryDisplay.setText(temporaryDisplay.getText().toString() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temporaryDisplay.setText(temporaryDisplay.getText().toString() + "2");

            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temporaryDisplay.setText(temporaryDisplay.getText().toString() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temporaryDisplay.setText(temporaryDisplay.getText().toString() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temporaryDisplay.setText(temporaryDisplay.getText().toString() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temporaryDisplay.setText(temporaryDisplay.getText().toString() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temporaryDisplay.setText(temporaryDisplay.getText().toString() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temporaryDisplay.setText(temporaryDisplay.getText().toString() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temporaryDisplay.setText(temporaryDisplay.getText().toString() + "9");
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute(plus);
                ACTION = ADDITION;
                resultDisplay.setText(String.valueOf(val1) + "+");
                temporaryDisplay.setText(null);
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute(minus);
                ACTION = SUBTRACTION;
                resultDisplay.setText(String.valueOf(val1) + "-");
                temporaryDisplay.setText(null);
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute(multiply);
                ACTION = MULTIPLICATION;
                resultDisplay.setText(String.valueOf(val1) + "*");
                temporaryDisplay.setText(null);
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute(divide);
                ACTION = DIVISION;
                resultDisplay.setText(String.valueOf(val1) + "/");
                temporaryDisplay.setText(null);
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute(equal);
                ACTION = EQUAL;
//                resultDisplay.setText(resultDisplay.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                resultDisplay.setText(String.valueOf(val1));
                temporaryDisplay.setText(String.valueOf(val1));
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (temporaryDisplay.getText().toString().length() > 0){
                    CharSequence name = temporaryDisplay.getText().toString();
                    temporaryDisplay.setText(name.subSequence(0, name.length() - 1));
                }

                else{
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    temporaryDisplay.setText(null);
                    resultDisplay.setText(null);
                }
            }
        });


    }

    private void setIDs() {

        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        equal = findViewById(R.id.equal);
        delete = findViewById(R.id.delete);

        resultDisplay = findViewById(R.id.result);
        temporaryDisplay = findViewById(R.id.temp);

    }

    private void compute(View view){
        if (!Double.isNaN(val1)){
            //i.e., val1 exists
            val2 = Double.parseDouble(temporaryDisplay.getText().toString());

            switch (ACTION){
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case SUBTRACTION:
                    val1 = val1 - val2;
                    break;
                case MULTIPLICATION:
                    val1 = val1 * val2;
                    break;
                case DIVISION:
                    val1 = val1 / val2;
                    break;
                case EQUAL:
                    break;
            }
        }

        else{
            //val1 doesn't already exist here
            int id = view.getId();
//            if (id == R.id.zero || id == R.id.one || id == R.id.two || id == R.id.three || id == R.id.four || id == R.id.five || id == R.id.six || id == R.id.seven || id == R.id.eight || id == R.id.nine ){
                val1 = Double.parseDouble(temporaryDisplay.getText().toString());
            }
//            else if(id == R.id.plus || id == R.id.minus || id == R.id.multiply || id == R.id.divide) return;
        }

}