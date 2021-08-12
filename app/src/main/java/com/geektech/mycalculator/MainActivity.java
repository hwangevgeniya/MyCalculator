package com.geektech.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private Integer firstValue, secondValue;
    private String operation;
    private Boolean isResultSuccess = false;
    private Button buttonNewActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tv_result);
        buttonNewActivity = findViewById(R.id.btn_new_activity);



    }

    public void onClickResultNewActivity(){

        buttonNewActivity.setVisibility(View.VISIBLE);

        buttonNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                String text = tvResult.getText().toString();
                intent.putExtra("text_key",text);
                startActivity(intent);
            }
        });

    }

    public void onClickNumber(View view) {
        buttonNewActivity.setVisibility(View.GONE);
        switch (view.getId()){

            case R.id.btn_one:
                textNumber("1");
                break;
            case R.id.btn_two:
                textNumber("2");
                break;
            case R.id.btn_three:
                textNumber("3");
                break;
            case R.id.btn_four:
                textNumber("4");
                break;
            case R.id.btn_five:
                textNumber("5");
                break;
            case R.id.btn_six:
                textNumber("6");
                break;
            case R.id.btn_seven:
                textNumber("7");
                break;
            case R.id.btn_eight:
                textNumber("8");
                break;
            case R.id.btn_nine:
                textNumber("9");
                break;
            case R.id.btn_zero:
                textNumber("0");
                break;
            case R.id.btn_clear:
                tvResult.setText("0");
                break;

        }
    }

    private void textNumber(String number){
        if(isResultSuccess){
            tvResult.setText("");
            isResultSuccess = false;
        }
        if(tvResult.getText().toString().equals("0")){
            tvResult.setText(number);
        } else {
            tvResult.append(number);
        }

    }

    public void onClickOperation(View view) {

        switch (view.getId()){

            case R.id.btn_plus:
                firstValue = Integer.parseInt(tvResult.getText().toString());
                tvResult.setText(firstValue + "+");
                operation = "+";
                buttonNewActivity.setVisibility(View.GONE);
                break;

            case R.id.btn_minus:
                firstValue = Integer.parseInt(tvResult.getText().toString());
                tvResult.setText(firstValue + "-");
                operation = "-";
                buttonNewActivity.setVisibility(View.GONE);
                break;

            case R.id.btn_division:
                firstValue = Integer.parseInt(tvResult.getText().toString());
                tvResult.setText(firstValue + "/");
                operation = "/";
                buttonNewActivity.setVisibility(View.GONE);
                break;

            case R.id.btn_multiply:
                firstValue = Integer.parseInt(tvResult.getText().toString());
                tvResult.setText(firstValue + "*");
                operation = "*";
                buttonNewActivity.setVisibility(View.GONE);
                break;

            case R.id.btn_equal:
                if(operation == "+"){
                String two = tvResult.getText().toString().
                        replace(firstValue + operation, "");
                secondValue = Integer.parseInt(two);
                int result = firstValue + secondValue;
                tvResult.setText(firstValue + operation + secondValue + "=" + result);
                    isResultSuccess = true;
                onClickResultNewActivity();}

                if(operation == "-"){
                    String two = tvResult.getText().toString().
                            replace(firstValue + operation, "");
                    secondValue = Integer.parseInt(two);
                    int result = firstValue - secondValue;
                    tvResult.setText(firstValue + operation + secondValue + "=" + result);
                    isResultSuccess = true;
                    onClickResultNewActivity();}


                if(operation == "/"){
                    String two = tvResult.getText().toString().
                            replace(firstValue + operation, "");
                    secondValue = Integer.parseInt(two);
                    int result = firstValue / secondValue;
                    tvResult.setText(firstValue + operation + secondValue + "=" + result);
                    isResultSuccess = true;
                    onClickResultNewActivity();}

                if(operation == "*"){
                    String two = tvResult.getText().toString().
                            replace(firstValue + operation, "");
                    secondValue = Integer.parseInt(two);
                    int result = firstValue * secondValue;
                    tvResult.setText(firstValue + operation + secondValue + "=" + result);
                    isResultSuccess = true;
                    onClickResultNewActivity();}

                break;

        }

    }
}