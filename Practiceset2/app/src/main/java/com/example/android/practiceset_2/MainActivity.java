package com.example.android.practiceset_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int weekday = 5;
        int weekend = 9;

        int optimalHours = 7 * 8;
        int actualHours = weekday + weekday * 2;
        int solution = optimalHours - actualHours;
        display(solution);
    }

    private void display(int solution) {

    }
}