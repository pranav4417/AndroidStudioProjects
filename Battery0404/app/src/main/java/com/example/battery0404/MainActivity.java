package com.example.battery0404;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.BatteryManager;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    ProgressBar progress;
    BatteryReceiver BR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
        progress = findViewById(R.id.progressBar);
        Button btn = findViewById(R.id.button);

        // Setting up a click listener for the button to check battery percentage
        btn.setOnClickListener(this::checkBatteryPercentage);
    }

    public void checkBatteryPercentage(View view) {
        BR = new BatteryReceiver(tv, progress);
        registerReceiver(BR, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (BR != null) {
            unregisterReceiver(BR);
        }
    }

    // Custom BroadcastReceiver to handle battery updates
    public static class BatteryReceiver extends BroadcastReceiver {
        private TextView tv;
        private ProgressBar progress;

        public BatteryReceiver(TextView tv, ProgressBar progress) {
            this.tv = tv;
            this.progress = progress;
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

            if (level != -1 && scale != -1) {
                int batteryPercentage = (int) ((level / (float) scale) * 100);
                // Update UI elements
                if (tv != null) {
                    tv.setText("Battery: " + batteryPercentage + "%");
                }
                if (progress != null) {
                    progress.setProgress(batteryPercentage);
                }
            }
        }
    }
}