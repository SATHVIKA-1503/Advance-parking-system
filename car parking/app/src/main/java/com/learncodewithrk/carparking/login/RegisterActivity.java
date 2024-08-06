package com.learncodewithrk.carparking.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.learncodewithrk.carparking.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    EditText email, pass, pass2;
    Button reg, log;
    TextView log_in;

    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        log_in = (TextView) findViewById(R.id.log_in);
        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent streamIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(streamIntent);
            }
        });





        mAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.r_email);
        pass = findViewById(R.id.r_pass);
        pass2 = findViewById(R.id.r_pass2);

        reg = findViewById(R.id.r_Register);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputCheckFun(email, pass, pass2);
            }
        });

    }

    private void InputCheckFun(EditText email, EditText pass, EditText pass2) {
        String s_email, s_pass, s_pass2;

        s_email = email.getText().toString();
        s_pass = pass.getText().toString();
        s_pass2 = pass2.getText().toString();

        if (s_email.isEmpty() || TextUtils.isEmpty(s_pass) || TextUtils.isEmpty(s_pass2)) {
            Toast.makeText(this, "Something is wrong", Toast.LENGTH_SHORT).show();
        } else {
            CreatingUser(s_email, s_pass);
        }
    }

    private void CreatingUser(String Email, String Password) {
        mAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    //send to new activity

                    mAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(RegisterActivity.this, "Check Your Email id", Toast.LENGTH_SHORT).show();

                                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                                finish();
                            } else {
                                Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}