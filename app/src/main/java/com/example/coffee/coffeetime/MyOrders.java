package com.example.coffee.coffeetime;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MyOrders extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myorders);

        Button newOrder = findViewById(R.id.newOrderButton);
        newOrder.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyOrders.this, OrderStep1.class));
            }
        });



        Button reorderButton1 = findViewById(R.id.reorderButton1);
        reorderButton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyOrders.this, OrderStep3.class));
            }
        });

        ImageView imageReorderDescription = (ImageView) findViewById(R.id.imageReorderDescription);
        imageReorderDescription.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "Reorder same coffee selection and store";
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

    }
}
