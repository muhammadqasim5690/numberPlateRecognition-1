package com.aliraza.numberplaterecognition;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class addCarDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car_details);
        getSupportActionBar().setTitle("Add Vehicle Details");
    }
}