package com.example.amoi.mycalculatorapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.support.v7.appcompat.R.id.info;

public class MainActivity extends AppCompatActivity {

    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button add;
    private Button multiply;
    private Button divide;
    private Button minus;
    private Button equal;
    private Button clear;
    private TextView number;
    private TextView result;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLY = '*';
    private final char DIVIDE = '/';
    private final char EQU = 0;
    private double val1 = Double.NaN;
    private double val2;
    private char ACTION;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number.setText(number.getText().toString() + "0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number.setText(number.getText().toString() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number.setText(number.getText().toString() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number.setText(number.getText().toString() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number.setText(number.getText().toString() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number.setText(number.getText().toString() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number.setText(number.getText().toString() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number.setText(number.getText().toString() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number.setText(number.getText().toString() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number.setText(number.getText().toString() + "9");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = ADDITION;
                result.setText(String.valueOf(val1)+"+");
                number.setText(null);
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = SUBTRACTION;
                result.setText(String.valueOf(val1)+"-");
                number.setText(null);
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = MULTIPLY;
                result.setText(String.valueOf(val1)+"X");
                number.setText(null);
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = DIVIDE;
                result.setText(String.valueOf(val1)+"/");
                number.setText(null);
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = EQU;
                result.setText(result.getText().toString()+String.valueOf(val2)+"="+String.valueOf(val1));
                // 5+4=9
                number.setText(null);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(number.getText().length()>0){
                    CharSequence name = number.getText().toString();
                    number.setText(name.subSequence(0,name.length()-1));
                }
                else{
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    number.setText(null);
                    result.setText(null);
                }
            }
        });


    }


    private void setupUIViews() {
        one = (Button) findViewById(R.id.one_btn);
        two = (Button) findViewById(R.id.two_btn);
        three = (Button) findViewById(R.id.three_btn);
        four = (Button) findViewById(R.id.four_btn);

        five = (Button) findViewById(R.id.five_btn);
        six = (Button) findViewById(R.id.six_btn);
        seven = (Button) findViewById(R.id.seven_btn);
        eight = (Button) findViewById(R.id.eight_btn);

        nine = (Button) findViewById(R.id.nine_btn);
        zero = (Button) findViewById(R.id.zero_btn);
        equal = (Button) findViewById(R.id.equal_btn);
        add = (Button) findViewById(R.id.add_btn);

        multiply = (Button) findViewById(R.id.multiply_btn);
        clear = (Button) findViewById(R.id.clear_btn);
        minus = (Button) findViewById(R.id.minus_btn);
        divide = (Button) findViewById(R.id.divide_btn);

        result = (TextView) findViewById(R.id.result_tv);
        number = (TextView) findViewById(R.id.number_tv);
    }

    private void compute() {
        if (!Double.isNaN(val1)) {
            val2 = Double.parseDouble(number.getText().toString());

            switch (ACTION) {
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case SUBTRACTION:
                    val1 = val1 - val2;
                    break;
                case MULTIPLY:
                    val1 = val1 * val2;
                    break;
                case DIVIDE:
                    val1 = val1 / val2;
                    break;
                case EQU:
                    break;
            }
        } else {
            val1 = Double.parseDouble(number.getText().toString());
        }

    }
}
