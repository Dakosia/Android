package com.example.androidlesson01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

public class RocketActivity extends AppCompatActivity {

    TextView tv_Help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rocket);

        tv_Help = (TextView) findViewById(R.id.tv_help);
        tv_Help.setText("Помощь начинающим - дело рук самих начинающих");
        // Align text in the center
        tv_Help.setGravity(Gravity.CENTER);
    }
}
