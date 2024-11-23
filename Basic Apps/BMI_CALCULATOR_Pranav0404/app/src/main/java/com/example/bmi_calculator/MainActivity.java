package com.example.bmi_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText wtval, htval;
    Button calc;
    TextView res;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        wtval = findViewById(R.id.wtval);
        htval = findViewById(R.id.htval);
        calc = findViewById(R.id.calc);
        res = findViewById(R.id.out);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float wt = Float.parseFloat(wtval.getText().toString());
                Float ht_m = Float.parseFloat(htval.getText().toString())/100;
                Float bmi = wt/(ht_m*ht_m);
                if(bmi<18.5)
                    res.setText("Your BMI is : "+bmi+"\n Under Weight");
                else if(bmi >=18.5 && bmi < 24.9)
                    res.setText("Your BMI is : "+bmi+"\n Healthy");
                else if(bmi >=24.9 && bmi < 30)
                    res.setText("Your BMI is : "+bmi+"\n over weight");
                else if(bmi > 30)
                    res.setText("Your BMI is : "+bmi+"\n suffering from obesity");

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}