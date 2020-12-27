package com.example.myapplication.Users;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.Calendar;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle saved) {
        super.onCreate(saved);
        setContentView(R.layout.add);
    }

    public void save(View view) {
        EditText edit = this.findViewById(R.id.name);
        EditText desc = this.findViewById(R.id.desc);
        Item item = new Item(edit.getText().toString(), Calendar.getInstance());
        item.setDesc(desc.getText().toString());
        Store.getStore().add(item);
        Intent intent = new Intent(this.getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }
}
