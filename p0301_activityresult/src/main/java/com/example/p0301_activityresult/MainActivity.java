package com.example.p0301_activityresult;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final int REQUEST_CODE_COLOR = 1;
    final int REQUEST_CODE_ALIGN = 2;

    TextView tvText;
    Button btnColor;
    Button btnAlign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvText = findViewById(R.id.tvText);
        btnColor = findViewById(R.id.btnColor);
        btnAlign = findViewById(R.id.btnAlign);

        btnAlign.setOnClickListener(this);
        btnColor.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btnColor.getId()) {
            Intent intent = new Intent(this, Colors.class);
            startActivityForResult(intent,REQUEST_CODE_COLOR);
        } else if (v.getId() == btnAlign.getId()) {
            Intent intent = new Intent(this, Align.class);
            startActivityForResult(intent,REQUEST_CODE_ALIGN);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        // запишем в лог значения requestCode и resultCode
        Log.d("myLogs", "requestCode = " + requestCode + ", resultCode = " + resultCode);
        // если пришло ОК

        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE_COLOR) {
                int color = data.getIntExtra("color", Color.WHITE);
                tvText.setTextColor(color);
            } else if (requestCode == REQUEST_CODE_ALIGN) {
                int align = data.getIntExtra("alignment", Gravity.LEFT);
                tvText.setGravity(align);
            }
            // если вернулось не ОК
        } else {
            Toast.makeText(this, "Wrong result", Toast.LENGTH_SHORT).show();
        }

    }
}
