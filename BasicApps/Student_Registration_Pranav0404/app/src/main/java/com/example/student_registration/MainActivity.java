package com.example.student_registration;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText name, fname;
    AutoCompleteTextView autoCompleteTextView;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button button;
    String[] places = {"Chennai","Hyderabad","Banglore","Pune","Nizamabad"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editTextText);
        fname = findViewById(R.id.editTextText2);
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView2);
        radioGroup = findViewById(R.id.radioGroup);
        button = findViewById(R.id.button);
        ArrayAdapter adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.select_dialog_item,places);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setThreshold(1);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton = findViewById(checkedId);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the selected RadioButton from the RadioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedId);

                // Build the result string as a sentence
                String res = "Name: " + name.getText().toString() +
                        ", Father's Name: " + fname.getText().toString() +
                        ", Location: " + autoCompleteTextView.getText().toString() +
                        ", Gender: " + (selectedRadioButton != null ? selectedRadioButton.getText().toString() : "Not selected") +
                        ".";

                // Show the result in a Toast
                Toast.makeText(MainActivity.this, res, Toast.LENGTH_SHORT).show();
            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}