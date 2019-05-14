package com.example.p0541_customadapter;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ArrayList<Product> products = new ArrayList<>();
    BoxAdapter boxAdapter;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // создаем адаптер
        fillData();
        boxAdapter = new BoxAdapter(this, products);

        // настраиваем список
        ListView lvMain = findViewById(R.id.lvMain);
        lvMain.setAdapter(boxAdapter);
    }

    // генерируем данные для адаптера
    void fillData() {
        for (int i = 1; i <= 20; i++) {
            products.add(new Product("Product " + i, i * 1000,
                    R.drawable.ic_launcher_foreground, false));
        }
    }

    // выводим информацию о корзине
    public void showResult(View v) {
        String result = "Товары в корзине:";
        for (Product p : boxAdapter.getBox()) {
            if (p.isBox())
                result += "\n" + p.getName();
        }
        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
    }
}
