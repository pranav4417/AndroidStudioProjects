package com.example.voteelegibility;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
public class ResultActivity extends AppCompatActivity {
    TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        res = findViewById(R.id.result);
        Intent intt = getIntent();
        String r_name = intt.getStringExtra("Name");
        String r_aadhar = intt.getStringExtra("Adhaar");
        int age = intt.getIntExtra("Age", 0);
        if(age>=18)
            res.setText("Name: "+r_name+"\nAadhar Number: "+r_aadhar+"\n You are eligible to vote");
        else
            res.setText("Name: "+r_name+"\nAadhar Number: "+r_aadhar+"\n You are not eligible to vote");
    }
}