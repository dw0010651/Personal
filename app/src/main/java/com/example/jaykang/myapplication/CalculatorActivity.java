package com.example.jaykang.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalculatorActivity extends Activity {


    protected static final String ACTIVITY_NAME = "CalculatorAcitivity";
    EditText first; //first number
    EditText second; //second number
    Button add; //+
    Button sub; //-
    Button mul; //*
    Button div; ///
    EditText finalVal; //result from arithmetic operations
    double num1;
    double num2;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        Log.i(ACTIVITY_NAME,"In onCreate Method");
        first = (EditText) findViewById(R.id.editText3);
        second = (EditText) findViewById(R.id.editText4);
        finalVal = (EditText) findViewById(R.id.editText5);
        Button add =(Button) findViewById(R.id.addition);
        Button sub =(Button) findViewById(R.id.subtraction);
        Button mul =(Button) findViewById(R.id.multiplication);
        Button div =(Button) findViewById(R.id.division);

        View.OnClickListener clickListener = new View.OnClickListener() {
            public void onClick(View v) {
                num1 = Double.parseDouble(first.getText().toString());
                num2 = Double.parseDouble(second.getText().toString());
                switch (v.getId()){
                    case R.id.addition :
                        result = num1+num2;
                        break;
                    case R.id.subtraction:
                        result = num1-num2;
                        break;
                    case R.id.multiplication:
                        result = num1*num2;
                        break;
                    case R.id.division:
                        result = num1/num2;
                        break;
                }
                String decimal = String.format("%.2f", result);
                finalVal.setText(String.valueOf(decimal));


            }
        };
        add.setOnClickListener(clickListener);
        sub.setOnClickListener(clickListener);
        mul.setOnClickListener(clickListener);
        div.setOnClickListener(clickListener);
    }
}

