package com.example.p0151_contextmenu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final int MENU_COLOR_RED = 1;
    final int MENU_COLOR_GREEN = 2;
    final int MENU_COLOR_BLUE = 3;

    final int MENU_SIZE_22 = 4;
    final int MENU_SIZE_26 = 5;
    final int MENU_SIZE_30 = 6;

    TextView tvColor, tvSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvColor = (TextView) findViewById(R.id.tvColor);
        tvSize = (TextView) findViewById(R.id.tvSize);

        // для tvColor и tvSize необходимо создавать контекстное меню
        registerForContextMenu(tvColor);
        registerForContextMenu(tvSize);
    }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        int i = v.getId();
        if (i == R.id.tvColor) {
            menu.add(0, MENU_COLOR_RED, 0, "Red");
            menu.add(0, MENU_COLOR_GREEN, 0, "Green");
            menu.add(0, MENU_COLOR_BLUE, 0, "Blue");
        } else if (i == R.id.tvSize) {
            menu.add(0, MENU_SIZE_22, 0, "22");
            menu.add(0, MENU_SIZE_26, 0, "26");
            menu.add(0, MENU_SIZE_30, 0, "30");
        }
    }

    public boolean onContextItemSelected(MenuItem item) {
        int i = item.getItemId();// пункты меню для tvColor
        if (i == MENU_COLOR_RED) {
            tvColor.setTextColor(Color.RED);
            tvColor.setText("Text color = red");
        } else if (i == MENU_COLOR_GREEN) {
            tvColor.setTextColor(Color.GREEN);
            tvColor.setText("Text color = green");
        } else if (i == MENU_COLOR_BLUE) {
            tvColor.setTextColor(Color.BLUE);
            tvColor.setText("Text color = blue");
            // пункты меню для tvSize
        } else if (i == MENU_SIZE_22) {
            tvSize.setTextSize(22);
            tvSize.setText("Text size = 22");
        } else if (i == MENU_SIZE_26) {
            tvSize.setTextSize(26);
            tvSize.setText("Text size = 26");
        } else if (i == MENU_SIZE_30) {
            tvSize.setTextSize(30);
            tvSize.setText("Text size = 30");
        }
        return super.onContextItemSelected(item);
    }

}
