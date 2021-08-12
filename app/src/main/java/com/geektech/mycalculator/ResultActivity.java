package com.geektech.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textView2 = findViewById(R.id.tv_result2);

        String text2 = getIntent().getStringExtra("text_key");
        textView2.setText(text2);

    }
}