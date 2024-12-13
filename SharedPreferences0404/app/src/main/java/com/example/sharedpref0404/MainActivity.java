package com.example.sharedpref0404;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText number;
    Spinner movie;
    Button btn;
    String[] movies = {"ABCD", "JAWAN", "BAHUBALI", "SALAR", "BHRAMAYUGAM"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        number = findViewById(R.id.ticketnum);
        movie = findViewById(R.id.spinner);
        btn = findViewById(R.id.button);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, movies);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        movie.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void saveData() {
        String selectedMovie = movie.getSelectedItem().toString();
        String ticketCount = number.getText().toString();

        if (ticketCount.isEmpty()) {
            Toast.makeText(this, "Please enter the number of tickets", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences sharedPreferences = getSharedPreferences("TicketBookingApp", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("MovieName", selectedMovie);
        editor.putString("NumberOfTickets", ticketCount);
        editor.apply();

        Toast.makeText(this, "Data saved successfully!", Toast.LENGTH_SHORT).show();
    }
    protected void onResume() {
        super.onResume();
        onResumePrivate();
    }

    private void onResumePrivate() {
        SharedPreferences sharedPreferences = getSharedPreferences("TicketBookingApp", MODE_PRIVATE);
        String savedMovie = sharedPreferences.getString("MovieName", "");
        String savedTickets = sharedPreferences.getString("NumberOfTickets", "");

        if (!savedMovie.isEmpty()) {
            ArrayAdapter<String> adapter = (ArrayAdapter<String>) movie.getAdapter();
            int position = adapter.getPosition(savedMovie);
            movie.setSelection(position);
        }

        number.setText(savedTickets);

        if (!savedMovie.isEmpty() || !savedTickets.isEmpty()) {
            Toast.makeText(this, "Data loaded successfully!", Toast.LENGTH_SHORT).show();
        }
    }
}
