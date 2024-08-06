package com.learncodewithrk.carparking.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.learncodewithrk.carparking.home.HomeActivity;
import com.learncodewithrk.carparking.R;
import com.google.firebase.auth.FirebaseAuth;

public class LoginandregisterActivity extends AppCompatActivity {
    Button login,register;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginandregister);
        //firebase
        mAuth = FirebaseAuth.getInstance();


        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent streamIntent = new Intent(LoginandregisterActivity.this, LoginActivity.class);
                startActivity(streamIntent);
            }
        });


        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent streamIntent = new Intent(LoginandregisterActivity.this, RegisterActivity.class);
                startActivity(streamIntent);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
            finish();
        }
    }
}