package com.example.android.on_demandfooddeliveryapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.ScriptGroup;

import com.example.android.on_demandfooddeliveryapp.model.RestaurantModel;

import java.io.InputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Restaurant List");
    }

}