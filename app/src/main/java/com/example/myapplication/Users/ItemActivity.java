package com.example.myapplication.Users;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class ItemActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle saved) {
        super.onCreate(saved);
        setContentView(R.layout.item);
        int index = getIntent().getIntExtra("index", 0);
        Item item = Store.getStore().get(index);
        TextView name = findViewById(R.id.name);
        name.setText(item.getName());
        TextView desc = findViewById(R.id.desc);
        desc.setText(item.getDesc());
    }
}
