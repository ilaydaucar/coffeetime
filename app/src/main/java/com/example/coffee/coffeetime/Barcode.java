package com.example.coffee.coffeetime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Barcode extends AppCompatActivity {
    Button gotoHomePageInBarcodePage;
    Button gotoMyOrdersInBarcodePage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode);
        gotoHomePageInBarcodePage = findViewById(R.id.homePageButtonBarcode);
        gotoHomePageInBarcodePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginToMainMenu = new Intent(Barcode.this,MainMenu.class);
                startActivity(loginToMainMenu);
            }
        });
        gotoMyOrdersInBarcodePage = findViewById(R.id.myOrdersButtonBarcode);
        gotoMyOrdersInBarcodePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginToMainMenu = new Intent(Barcode.this,MyOrders.class);
                startActivity(loginToMainMenu);
            }
        });
    }
}
