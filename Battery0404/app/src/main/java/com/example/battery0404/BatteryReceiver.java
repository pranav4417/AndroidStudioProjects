package com.example.battery0404;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
public class BatteryReceiver extends BroadcastReceiver {
    TextView tview;
    ProgressBar prg;
    BatteryReceiver(TextView tv, ProgressBar progressBar){
        tview = tv;
        prg = progressBar;
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onReceive(Context context, Intent intent) {
        int per = intent.getIntExtra("level",0);
        if(per>=50) {
            tview.setText(per + "%");
            prg.setProgress(per);
            prg.setProgressTintList(ColorStateList.valueOf(Color.GREEN));
        }
        else if(per<50 && per>=20){
            tview.setText(per + "%");
            prg.setProgress(per);
            prg.setProgressTintList(ColorStateList.valueOf(Color.YELLOW));
        } else if (per<20 && per>0) {
            tview.setText(per + "%");
            prg.setProgress(per);
            prg.setProgressTintList(ColorStateList.valueOf(Color.RED));
        }
    }
}