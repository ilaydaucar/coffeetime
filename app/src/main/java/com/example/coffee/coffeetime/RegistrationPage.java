package com.example.coffee.coffeetime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RegistrationPage extends AppCompatActivity {
    TextView loginText ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);
        loginText=findViewById(R.id.registerLogin);
        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginRegisterIntent = new Intent(RegistrationPage.this,Login.class);
                startActivity(loginRegisterIntent);
            }
        });
    }
}
