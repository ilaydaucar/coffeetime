package com.example.coffee.coffeetime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /*
        Button register_test = findViewById(R.id.registerButton);
        register_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistrationPage.class);
                startActivity(intent);
            }
        });

        Button login = findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_login = new Intent(MainActivity.this,Login.class);
                startActivity(intent_login);
            }
        });
*/
       Thread thread = new Thread(){
           @Override
           public void run() {
               try{
                   sleep(2000);
                   Log.d("sleep", "run: sleeped 2 seconds");
               }
               catch (Exception e) {

               }
               finally {
                   Intent intent_login = new Intent(MainActivity.this,Login.class);
                   startActivity(intent_login);
               }
           }
       };thread.start();


    }

}