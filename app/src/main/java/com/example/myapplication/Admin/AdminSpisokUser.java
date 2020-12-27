package com.example.myapplication.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Model.Users;
import com.example.myapplication.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AdminSpisokUser extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> listData;
    private List<Users> listTemp;
    private DatabaseReference mDataBase;
    private String USER_KEY = "Users";
@Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spisok_user);
        init();
        getDataFromDB();
        setOnClickItem();
        Toast.makeText(this, "Здравствуй админ", Toast.LENGTH_SHORT).show();

    }

    private void init() {
        listView = findViewById(R.id.listView);
        listData = new ArrayList<>();
        listTemp = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        listView.setAdapter(adapter);
        mDataBase = FirebaseDatabase.getInstance().getReference(USER_KEY);
    }

    private void getDataFromDB() {
        ValueEventListener vListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (listData.size() > 0) listData.clear();
                if (listTemp.size() > 0) listData.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Users user = ds.getValue(Users.class);
                    assert user != null;
                    listData.add(user.name);
                    listTemp.add(user);
                }
                adapter.notifyDataSetChanged();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        mDataBase.addValueEventListener(vListener);
    }
    private void setOnClickItem(){
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Users user= listTemp.get(position);
            Intent i =new Intent(AdminSpisokUser.this, AdminUser.class);
            i.putExtra("user_name",user.name);
            i.putExtra("user_phone",user.phone);
            i.putExtra("user_password",user.password);
            startActivity(i);
        }
    });
    }
}