package com.example.p0591_datepickerdialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int DIALOG_DATE = 1;
    int myYear = 2011;
    int myMonth = 02;
    int myDay = 03;
    TextView tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDate = findViewById(R.id.tvDate);
    }


    public void onClick(View view) {
        showDialog(DIALOG_DATE);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if(id == DIALOG_DATE){
            DatePickerDialog datePickerDialog = new DatePickerDialog(this,myCallback, myYear,myMonth,myDay);
        }
        return super.onCreateDialog(id);
    }

    DatePickerDialog.OnDateSetListener myCallback = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            myYear = year;
            myMonth = month;
            myDay = dayOfMonth;
            tvDate.setText("Today is " + myDay + "/" + myMonth + "/" + myYear);
        }
    };
}
