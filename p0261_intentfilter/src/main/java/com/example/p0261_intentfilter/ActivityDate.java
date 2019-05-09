package com.example.p0261_intentfilter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ActivityDate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        String date = sdf.format(new Date(System.currentTimeMillis()));

        TextView tvDate = findViewById(R.id.tvDate);
        tvDate.setText(date);
    }
}
