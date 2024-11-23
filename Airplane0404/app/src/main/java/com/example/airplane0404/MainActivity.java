package com.example.airplane0404;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare the receiver
    AirplaneModeChangedEx receiver;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the TextView
        text = findViewById(R.id.textView);
    }

    @Override
    protected void onStart() {
        super.onStart();

        receiver = new AirplaneModeChangedEx(text);

        registerReceiver(receiver, new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED));
    }


}
