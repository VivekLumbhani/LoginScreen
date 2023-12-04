package com.example.login_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button signup,login;
    EditText uname,pass;
    boolean checkall=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signup=findViewById(R.id.signupbtn);
        login=findViewById(R.id.loginbut);
        uname=findViewById(R.id.uname);
        pass=findViewById(R.id.upass);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SignUp.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Logged In!", Toast.LENGTH_SHORT).show();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkall=checkallflied();
                if(checkall){
                    Intent intent=new Intent(MainActivity.this,HomeScreen.class);
                    intent.putExtra("usname",uname.getText().toString());
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Logged In!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public boolean checkallflied(){
        String username = getIntent().getStringExtra("usname");
        String password = getIntent().getStringExtra("uspass");

        if(uname.length()==0 || uname.length()<3 ||!uname.getText().toString().equals(username)){
            uname.setError("Please Enter valid name");
            return false;
        }
        if(pass.length()==0 || pass.length()<3 || !pass.getText().toString().equals(password)){
            pass.setError("Please Enter valid Password");
            return false;
        }
        return true;
    }
}