package com.example.airplane0404;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.widget.TextView;

public class AirplaneModeChangedEx extends BroadcastReceiver {
    private TextView tview;

    public AirplaneModeChangedEx(TextView tv) {
        tview = tv;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean isAirplaneModeEnabled = intent.getBooleanExtra(Intent.ACTION_AIRPLANE_MODE_CHANGED, false);

        if (isAirplaneModeEnabled) {
            tview.setText("Aeroplane Mode Enabled");
            tview.setTextColor(Color.parseColor("#FF0000"));
        } else {
            tview.setText("Aeroplane Mode Disabled");
            tview.setTextColor(Color.parseColor("#00FF00"));
        }
    }
}
