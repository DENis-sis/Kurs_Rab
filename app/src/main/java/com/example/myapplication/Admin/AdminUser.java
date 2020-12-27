package com.example.myapplication.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class AdminUser extends AppCompatActivity {
private TextView tvName, tvPhone, tvPassword;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_layout);
        init();
        getIntentMain();
    }
    private void init()
    {
        tvName=findViewById(R.id.tvName);
        tvPhone=findViewById(R.id.tvPhone);
        tvPassword=findViewById(R.id.tvPassword);
    }
private void getIntentMain(){
    Intent i =getIntent();
    if(i!=null)
    {
        tvName.setText(i.getStringExtra("user_name"));
        tvPhone.setText(i.getStringExtra("user_phone"));
        tvPassword.setText(i.getStringExtra("user_password"));
    }
}
}