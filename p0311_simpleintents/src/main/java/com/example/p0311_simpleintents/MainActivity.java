package com.example.p0311_simpleintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnWeb;
    Button btnMap;
    Button btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWeb = findViewById(R.id.btnWeb);
        btnMap = findViewById(R.id.btnMap);
        btnCall = findViewById(R.id.btnCall);

        btnWeb.setOnClickListener(this);
        btnMap.setOnClickListener(this);
        btnCall.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        int i = v.getId();
        if (i == R.id.btnWeb) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://developer.android.com"));
            startActivity(intent);
        } else if (i == R.id.btnMap) {
            intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:55.754283,37.62002"));
            startActivity(intent);
        } else if (i == R.id.btnCall) {
            intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:12345"));
            startActivity(intent);
        }
    }
}
