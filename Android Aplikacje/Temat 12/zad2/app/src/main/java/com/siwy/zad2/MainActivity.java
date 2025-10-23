package com.siwy.zad2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;
import android.os.Bundle;
import java.util.*;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));

        List<Product> list = Arrays.asList(
                new Product("Chleb", 4.20f), new Product("Masło", 6.50f),
                new Product("Ser", 8.99f), new Product("Szynka", 12.50f),
                new Product("Mleko", 3.00f), new Product("Kawa", 24.00f),
                new Product("Herbata", 8.00f), new Product("Jajka", 12.00f),
                new Product("Cukier", 4.50f), new Product("Mąka", 3.80f)
        );

        rv.setAdapter(new ProductAdapter(list));
    }
}
