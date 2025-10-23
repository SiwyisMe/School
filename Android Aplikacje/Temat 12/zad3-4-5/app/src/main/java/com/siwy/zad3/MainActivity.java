package com.siwy.zad3;

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
        //ZADANIE 5
        rv.setLayoutManager(new GridLayoutManager(this, 2));
        //KONIEC
        List<User> users = Arrays.asList(
                new User("Jan Kowalski", R.drawable.avatar1),
                new User("Anna Nowak", R.drawable.avatar2),
                new User("Piotr Zieliński", R.drawable.avatar3)
        );

        rv.setAdapter(new UserAdapter(users));
    }

}
