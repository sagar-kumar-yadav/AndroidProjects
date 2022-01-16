package com.example.android.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openNumbersList(View view) {
        Intent i = new Intent(this, NumberActivity.class);
        startActivity(i);
    }

    public void openFamilyList(View view) {
        Intent i = new Intent(this, FamilyActivity.class);
        startActivity(i);
    }
}