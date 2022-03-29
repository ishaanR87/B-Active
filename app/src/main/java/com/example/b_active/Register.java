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
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity implements View.OnClickListener{

        private TextView banner, registeruser;
        private EditText etfullname, etemail, etpassword;
        private ProgressBar progressbar;

        private FirebaseAuth mAuth;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.register);

                mAuth = FirebaseAuth.getInstance();

                banner = (TextView) findViewById(R.id.registerpage);
                banner.setOnClickListener(this);

                registeruser = (Button) findViewById(R.id.regbtn);
                registeruser.setOnClickListener(this);

                etfullname = (EditText) findViewById(R.id.fullname);
                etfullname.setOnClickListener(this);

                etemail = (EditText) findViewById(R.id.Email);
                etemail.setOnClickListener(this);

                etpassword = (EditText) findViewById(R.id.password);
                etpassword.setOnClickListener(this);

                progressbar = (ProgressBar) findViewById(R.id.progressBar);
                progressbar.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

                switch (v.getId())
                {
                        case R.id.registerpage:
                                startActivity(new Intent(this, Login.class));
                                break;
                        case R.id.regbtn:
                                registerUser();
                                break;

                }
        }

        private void registerUser () {
                String email = etemail.getText().toString().trim();
                String fullname = etfullname.getText().toString().trim();
                String password = etpassword.getText().toString().trim();

                if(fullname.isEmpty()){
                        etfullname.setError("Full name is required!");
                        etfullname.requestFocus();
                        return;
                }

                if(email.isEmpty()){
                        etemail.setError("Email is required!");
                        etemail.requestFocus();
                        return;
                }

                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                        etemail.setError("Please provide valid email!");
                        etemail.requestFocus();
                        return;
                }


                if(password.isEmpty()){
                        etpassword.setError("Password is required!");
                        etpassword.requestFocus();
                        return;
                }

                if(password.length() < 6) {
                        etpassword.setError("Password length should be more than 6 characters!");
                        etpassword.requestFocus();
                        return;
                }

                progressbar.setVisibility(View.VISIBLE);
                mAuth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                        if(task.isSuccessful())
                                        {
                                                User user = new User(fullname,email);

                                                FirebaseDatabase.getInstance().getReference("Users")
                                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                        @Override
                                                        public void onComplete(@NonNull Task<Void> task) {
                                                                if(task.isSuccessful())
                                                                {
                                                                        Toast.makeText(Register.this,"User has been registered successfully", Toast.LENGTH_LONG).show();
                                                                        progressbar.setVisibility(View.GONE);

                                                                } else {
                                                                        Toast.makeText(Register.this,"Failed to register! Try Again!", Toast.LENGTH_LONG).show();
                                                                        progressbar.setVisibility(View.GONE);
                                                                }
                                                        }
                                                });
                                        }else {
                                                Toast.makeText(Register.this,"Failed to register! Try Again!", Toast.LENGTH_LONG).show();
                                                progressbar.setVisibility(View.GONE);
                                        }
                                }
                        });
        }
}