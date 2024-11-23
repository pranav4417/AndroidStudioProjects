package com.example.voteelegibility;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText name, date, adhaar;
    Button check;
    int pyear, pmonth, pdate, age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        date = findViewById(R.id.editTextDate);
        adhaar = findViewById(R.id.editTextNumber);
        check = findViewById(R.id.button);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                pyear = c.get(Calendar.YEAR);
                pmonth = c.get(Calendar.MONTH);
                pdate = c.get(Calendar.DATE);
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_DeviceDefault_Dialog, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        // Setting date in DD/MM/YYYY format
                        date.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                        age = pyear - year;
                    }
                }, pyear, pmonth, pdate);
                dialog.show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkEligibility(view);
            }
        });
    }

    //  next activity
    public void checkEligibility(View v) {
        String pname = name.getText().toString();
        String pnum = adhaar.getText().toString();
        Intent in = new Intent(MainActivity.this, ResultActivity.class);
        in.putExtra("Name", pname);
        in.putExtra("Adhaar", pnum);
        in.putExtra("Age", age);
        startActivity(in);
    }
}
