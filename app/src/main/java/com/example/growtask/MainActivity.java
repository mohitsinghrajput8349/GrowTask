package com.example.growtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth auth;
    Button logOut;
    TextView textView;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();
        logOut  = findViewById(R.id.logOut);
        textView = findViewById(R.id.textview);
        user= auth.getCurrentUser();
        if(user==null)
        {
            Intent intent = new Intent(getApplicationContext(),logIn.class);
            startActivity(intent);
           finish();
        }
        else
        {
            textView.setText(user.getEmail());

        }
        logOut.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(getApplicationContext(),logIn.class);
            startActivity(intent);
            finish();
        });
    }

    }
