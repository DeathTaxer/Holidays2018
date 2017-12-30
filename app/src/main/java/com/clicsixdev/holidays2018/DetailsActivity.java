package com.clicsixdev.holidays2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView holiday = (TextView) findViewById(R.id.holiday);
        TextView holidayStates = (TextView) findViewById(R.id.holiday_states);

        holiday.setText(getIntent().getStringExtra("holiday"));
        holidayStates.setText(getIntent().getStringExtra("states"));



    }
}
