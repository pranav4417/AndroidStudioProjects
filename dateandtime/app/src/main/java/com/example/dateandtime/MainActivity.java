package com.example.dateandtime;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    ImageView time,date;
    TextView dateres, timeres;
    Button submit;
    private String seldate,seltime;
    EditText editTexttime, editTextdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        time = findViewById(R.id.imageView);
        date = findViewById(R.id.imageView2);
        submit = findViewById(R.id.sub);
        dateres = findViewById(R.id.dateres);
        timeres = findViewById(R.id.timeres);
        editTexttime = findViewById(R.id.editTextTime);
        editTextdate = findViewById(R.id.editTextDate);

        date.setOnClickListener(v -> seldate());
        time.setOnClickListener(v -> seltime());
        editTexttime.setOnClickListener(v -> seltime());
        editTextdate.setOnClickListener(v -> seldate());

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, resact.class);
                in.putExtra("date",seldate);
                in.putExtra("time",seltime);
                startActivity(in);

            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void seldate()    {
        Calendar c = Calendar.getInstance();
        int py,pm,pd;
        py = c.get(Calendar.YEAR);
        pm = c.get(Calendar.MONTH);
        pd = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dt = new DatePickerDialog(MainActivity.this,(view, year, month, dayOfMonth) -> {
            String date = dayOfMonth+"/"+(month+1)+"/"+year;
            seldate = date;
            dateres.setText(date);
            editTextdate.setText(date);

        },py,pm,pd);
        dt.show();
    }
    private void seltime()    {
        Calendar c = Calendar.getInstance();
        int pHour, pMinute;
        pHour = c.get(Calendar.HOUR_OF_DAY);
        pMinute = c.get(Calendar.MINUTE);
        TimePickerDialog tm = new TimePickerDialog(MainActivity.this,(view, hourOfDay, minute) -> {
            String time = pHour+":"+pMinute;
            seltime = time;
            timeres.setText(time);
            editTexttime.setText(time);
        },pHour,pMinute,false);
        tm.show();
    }
}