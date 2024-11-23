package com.example.electives_selection_application;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText name, rollno;
    private Spinner elec;
    private TextView res;
    private String selectedCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editTextText);
        rollno = findViewById(R.id.editTextText2);
        elec = findViewById(R.id.spinner);
        res = findViewById(R.id.textView3);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.courses,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        elec.setAdapter(adapter);

        // Set up Spinner item selection listener
        elec.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCourse = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle the case when no item is selected if needed
            }
        });

        // Set up button listeners
        Button submitButton = findViewById(R.id.submit);
        Button resetButton = findViewById(R.id.reset);

        submitButton.setOnClickListener(this::displayDetails);
        resetButton.setOnClickListener(this::resetDetails);

        // Handle window insets for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Method to handle the spinner item selection
    public void onSpinnerItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedCourse = parent.getItemAtPosition(position).toString();
    }

    // Method to display details 
    public void displayDetails(View v) {
        String nameText = name.getText().toString();
        String rollNoText = rollno.getText().toString();
        res.setText(String.format("Name: %s\nRoll No: %s\nSelected Course: %s", nameText, rollNoText, selectedCourse));
    }

    // Method to reset details
    public void resetDetails(View v) {
        name.setText("");
        rollno.setText("");
        res.setText("");
    }
}
