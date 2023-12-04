package com.example.login_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    Button signup, login;
    EditText uname, pass, cnfpass;
    boolean checkall = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signup = findViewById(R.id.signbut);
        login = findViewById(R.id.loginbut);
        uname = findViewById(R.id.uname);
        pass = findViewById(R.id.upass);
        cnfpass = findViewById(R.id.cnfpass);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkall = checkallflied();
                if (checkall) {
                    Intent intent = new Intent(SignUp.this, MainActivity.class);
                    intent.putExtra("usname", uname.getText().toString()); // Use getText().toString() for EditText
                    intent.putExtra("uspass", pass.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }

    public boolean checkallflied() {
        if (uname.length() == 0 || uname.length() < 3) {
            uname.setError("Please Enter valid name");
            return false;
        }
        if (pass.length() == 0 || pass.length() < 3) {
            pass.setError("Please Enter valid Password");
            return false;
        }
        if (!pass.getText().toString().equals(cnfpass.getText().toString())) {
            cnfpass.setError("password does not match");
            return false;
        }
        return true;
    }
}
