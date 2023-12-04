package com.example.login_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity {

    TextView txtv;
    Button btnlogout;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        String username = getIntent().getStringExtra("usname");
        txtv=findViewById(R.id.txtview);
        txtv.setText("Welcom! "+username);
        btnlogout=findViewById(R.id.button);

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeScreen.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

}