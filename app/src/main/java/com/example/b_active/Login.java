package com.example.b_active;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private TextView register;
    private EditText lemail, lpassword;
    private Button signIN;

    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        register = (TextView) findViewById(R.id.register);
        register.setOnClickListener(this);

        signIN = (Button) findViewById(R.id.loginbtn);
        signIN.setOnClickListener(this);

        lemail = (EditText) findViewById(R.id.Emaillogin);
        lpassword = (EditText) findViewById(R.id.passwordlogin);



        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
    }

    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.register:
                startActivity(new Intent(this, Register.class));
                break;

            case R.id.loginbtn:
                userLogin();
                break;

        }
    }

    public void userLogin(){
        String email = lemail.getText().toString().trim();
        String password = lpassword.getText().toString().trim();


        if(email.isEmpty()){
            lemail.setError("Email is required!");
            lemail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            lemail.setError("Please provide valid email!");
            lemail.requestFocus();
            return;
        }


        if(password.isEmpty()){
            lpassword.setError("Password is required!");
            lpassword.requestFocus();
            return;
        }

        if(password.length() < 6) {
            lpassword.setError("Password length should be more than 6 characters!");
            lpassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                if(user.isEmailVerified()){
                    startActivity(new Intent(Login.this, Home.class));
                    progressBar.setVisibility(View.GONE);
                }else{
                    user.sendEmailVerification();
                    Toast.makeText(Login.this, "Check your email to verify your account", Toast.LENGTH_SHORT).show();
                }
                }
                else {
                    Toast.makeText(Login.this, "Login failed! Please try again!", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }
}
