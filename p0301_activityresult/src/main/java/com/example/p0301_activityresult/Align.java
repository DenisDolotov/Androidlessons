package com.example.p0301_activityresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

public class Align extends AppCompatActivity implements View.OnClickListener {

    Button btnLeft;
    Button btnCenter;
    Button btnRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_align);

        btnLeft = findViewById(R.id.btnLeft);
        btnCenter = findViewById(R.id.btnCenter);
        btnRight = findViewById(R.id.btnRight);

        btnLeft.setOnClickListener(this);
        btnCenter.setOnClickListener(this);
        btnRight.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        if (v.getId()==btnLeft.getId()){
            intent.putExtra("alignment", Gravity.LEFT);
        }else if (v.getId()==btnCenter.getId()){
            intent.putExtra("alignment", Gravity.CENTER);
        }else if (v.getId()==btnRight.getId()){
            intent.putExtra("alignment", Gravity.RIGHT);
        }

        setResult(RESULT_OK,intent);
        finish();
    }
}
