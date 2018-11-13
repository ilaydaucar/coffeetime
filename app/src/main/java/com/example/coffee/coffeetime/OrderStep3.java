package com.example.coffee.coffeetime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OrderStep3 extends AppCompatActivity {

    Button buyCoffeeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_step3);
        buyCoffeeButton = findViewById(R.id.buyCoffeeInStepThree);
        buyCoffeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginToMainMenu = new Intent(OrderStep3.this,Barcode.class);
                startActivity(loginToMainMenu);
            }
        });
    }


}
