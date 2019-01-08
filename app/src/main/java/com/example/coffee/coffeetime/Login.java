package com.example.coffee.coffeetime;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coffee.coffeetime.db.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    private static final String TAG = "LoginActivity";

    TextView loginEmail;
    TextView loginPassword;
    TextView registerInLoginPage;
    Button loginInLoginPage;
    DatabaseReference mDatabase;
    String  emailDatabase;
    String passwordDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginEmail=findViewById(R.id.loginEmail);
        loginPassword=findViewById(R.id.loginPassword);
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
                String password=loginPassword.getText().toString();
                System.out.println("Mail" + password);
                mDatabase=FirebaseDatabase.getInstance().getReference().child("users").child(password);
                mDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        User user = dataSnapshot.getValue(User.class);
                        emailDatabase= user.getEmail();
                        passwordDatabase = user.getPassword();
                        System.out.println("dataMail" + emailDatabase);
                        System.out.println("dataPassword" + passwordDatabase);

                        // Log.d("İlayda" , dataSnapshot.getValue().toString());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                if(loginEmail.getText().toString().equals(emailDatabase) &&loginPassword.getText().toString().equals(passwordDatabase)){
                    Intent loginToMainMenu = new Intent(Login.this,MainMenu.class);
                    startActivity(loginToMainMenu);
                }
                else{
                    Toast.makeText(getBaseContext(),"Email or Password is incorrect. Please try again", Toast.LENGTH_SHORT).show();
                }



            }
        });


    }
}
