package com.example.cakedatetime_pranav0404;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {

    TextView orderSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        // Initialize TextView to display the order summary
        orderSummary = findViewById(R.id.orderSummary);

        // Get the intent that started this activity and extract the data
        Intent intent = getIntent();
        String cakeFlavor = intent.getStringExtra("ITEM");
        String deliveryDate = intent.getStringExtra("DATE");
        String deliveryTime = intent.getStringExtra("TIME");

        // Create an order summary string
        String summary = "Cake Flavor: " + cakeFlavor + "\n" +
                "Delivery Date: " + deliveryDate + "\n" +
                "Delivery Time: " + deliveryTime;

        // Display the order summary in the TextView
        orderSummary.setText(summary);
    }
}
