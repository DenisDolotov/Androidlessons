package com.example.p0301_activityresult;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Colors extends AppCompatActivity implements View.OnClickListener {

    Button btnRed;
    Button btnGreen;
    Button btnBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        btnRed = findViewById(R.id.btnRed);
        btnGreen = findViewById(R.id.btnGreen);
        btnBlue = findViewById(R.id.btnBlue);

        btnRed.setOnClickListener(this);
        btnGreen.setOnClickListener(this);
        btnBlue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();

        if (v.getId()==btnRed.getId()){
            intent.putExtra("color", Color.RED);
        }else if (v.getId()==btnGreen.getId()){
            intent.putExtra("color", Color.GREEN);
        }else if (v.getId()==btnBlue.getId()){
            intent.putExtra("color", Color.BLUE);
        }
        
        setResult(RESULT_OK,intent);
        finish();
    }
}
