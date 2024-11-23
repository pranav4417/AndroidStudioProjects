package com.example.cakedatetime_pranav0404;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.R.layout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Spinner ckbox;
    String[] cakes = {"Vanilla", "Strawberry", "Chocolate", "Others"};
    String cflav, datedel, timedel;
    int pYear, pMonth, pDate;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize spinner
        ckbox = findViewById(R.id.ckbox);
        btn = findViewById(R.id.button);
        ImageView calendarImage = findViewById(R.id.imageView);
        ImageView timeImage = findViewById(R.id.imageView2);

        //spinner adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, layout.simple_spinner_item, cakes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ckbox.setAdapter(adapter);

        ckbox.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cflav = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                cflav = "No flavor selected";
            }
        });

        calendarImage.setOnClickListener(v -> selectDate(v));
        timeImage.setOnClickListener(v -> selectTime(v));

        btn.setOnClickListener(v -> placeOrder(v));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Method to select date
    public void selectDate(View v) {
        Calendar c = Calendar.getInstance();
        pYear = c.get(Calendar.YEAR);
        pMonth = c.get(Calendar.MONTH);
        pDate = c.get(Calendar.DATE);

        DatePickerDialog dialog = new DatePickerDialog(this,
                android.R.style.Theme_DeviceDefault_Dialog_Alert,
                (view, year, month, dayOfMonth) -> datedel = dayOfMonth + "/" + (month + 1) + "/" + year,
                pYear, pMonth, pDate);
        dialog.show();
    }

    // Method to select time
    public void selectTime(View v) {
        Calendar c1 = Calendar.getInstance();
        int pHour = c1.get(Calendar.HOUR_OF_DAY);
        int pMinute = c1.get(Calendar.MINUTE);

        TimePickerDialog tdialog = new TimePickerDialog(this, android.R.style.Theme_DeviceDefault_Dialog_Alert, (view, hourOfDay, minute) -> timedel = hourOfDay + ":" + minute, pHour, pMinute, false);
        tdialog.show();
    }

    public void placeOrder(View v) {
        // Fallback in case of null values
        if (cflav == null) cflav = "Default Flavor";
        if (datedel == null) datedel = "No Date Selected";
        if (timedel == null) timedel = "No Time Selected";

        // Intent to start the OrderActivity
        Intent in = new Intent(getApplicationContext(), OrderActivity.class);
        in.putExtra("ITEM", cflav);
        in.putExtra("DATE", datedel);
        in.putExtra("TIME", timedel);
        startActivity(in);
    }
}