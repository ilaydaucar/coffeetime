package com.example.coffee.coffeetime;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.coffee.coffeetime.db.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    TextView registerInLoginPage;
    Button loginInLoginPage;
    EditText  loginEmail;
    EditText loginPassword;
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
        FirebaseDatabase database= FirebaseDatabase.getInstance();
        DatabaseReference mDatabase = database.getReference("users");
        loginEmail=findViewById(R.id.loginEmail);
        loginPassword=findViewById(R.id.loginPassword);
        loginInLoginPage=findViewById(R.id.loginPageButton);
        loginInLoginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent loginToMainMenu = new Intent(Login.this,MainMenu.class);
                startActivity(loginToMainMenu);
            }
        });
      /*  mDatabase.child("email").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);

                Log.d("User", "User name: " + user.getName() + ", email " + user.getEmail());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Failed to read value
                Log.w("Error", "Failed to read value.", databaseError.toException());
            }
        });*/

    }
}
