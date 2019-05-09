package com.example.p0331_sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etText;
    Button btnSave;
    Button btnLoad;
    SharedPreferences sPref;

    final String SAVED_TEXT = "saved_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etText = findViewById(R.id.etText);

        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);

        btnLoad = findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(this);

        loadText();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveText();
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btnSave) {
            saveText();
        } else if (i == R.id.btnLoad) {
            loadText();
        }
    }

    private void loadText() {
        sPref = getPreferences(MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_TEXT,"");
        etText.setText(savedText);
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
    }

    private void saveText() {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, etText.getText().toString());
        ed.commit();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }
}
