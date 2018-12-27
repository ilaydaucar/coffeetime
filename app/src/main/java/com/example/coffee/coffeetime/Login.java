package com.example.coffee.coffeetime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    TextView registerInLoginPage;
    Button loginInLoginPage;
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
        loginInLoginPage=findViewById(R.id.loginPageButton);
        loginInLoginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginToMainMenu = new Intent(Login.this,MainMenu.class);
                startActivity(loginToMainMenu);
            }
        });

    }
}
