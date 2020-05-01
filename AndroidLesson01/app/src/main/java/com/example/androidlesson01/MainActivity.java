package com.example.androidlesson01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button bt_Hello, bt_Activity;
    TextView tv_Hello;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_Hello = (TextView) findViewById(R.id.tv_hello);
        tv_Hello.setText("Привет");
        tv_Hello.setGravity(Gravity.CENTER);

        bt_Hello = (Button) findViewById(R.id.bt_hello);
        bt_Hello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_Hello.setText("Как дела?");
            }
        });

        // Homework
        bt_Activity = (Button) findViewById(R.id.bt_activity);
        // When button "bt_activity" is clicked, go to the Rocket Activity
        bt_Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), RocketActivity.class));
            }
        });
    }
}
