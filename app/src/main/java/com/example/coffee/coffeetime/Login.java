package com.example.coffee.coffeetime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    TextView registerInLoginPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        registerInLoginPage=findViewById(R.id.pleaseRegister);
        registerInLoginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginToRegister = new Intent(Login.this,RegistrationPage.class);
                startActivity(loginToRegister);
            }
        });

    }
}
