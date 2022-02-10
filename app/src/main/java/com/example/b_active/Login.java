package com.example.b_active;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText username,password;
    Button loginBtn;

    DBHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.usernamelogin);
        password = (EditText) findViewById(R.id.passwordlogin);
        loginBtn = (Button) findViewById(R.id.loginbtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("") || pass.equals(""))
                {
                    Toast.makeText(Login.this, "Please enter the credentials", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean access = myDb.passwordcheck(user,pass);
                    if(access == true)
                    {

                    }
                    else
                    {
                        Toast.makeText(Login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}