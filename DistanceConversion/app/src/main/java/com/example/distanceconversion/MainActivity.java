package com.example.distanceconversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonToMiles = (Button) findViewById(R.id.buttonToMiles);
        Button buttonToKm = (Button) findViewById(R.id.buttonToKm);

        buttonToMiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertDistance("miles");
            }
        });

        buttonToKm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertDistance("km");
            }
        });

    }
    public void convertDistance(String convertTo)  {

        EditText kmInput = (EditText) findViewById(R.id.kilometersInput);
        EditText milesInput = (EditText) findViewById(R.id.milesInput);

        DecimalFormat decimalFormat = new DecimalFormat("#.###");

        if (convertTo.equals("miles")) {
            String kmValue = kmInput.getText().toString();

            if (kmValue.equals("")) {
                milesInput.setText("");
                return;
            }

            double kmParsed = Double.parseDouble(kmValue);
            String convertedMiles = decimalFormat.format(kmParsed * 0.621);

            milesInput.setText(convertedMiles);
        } else {
            String milesValue = milesInput.getText().toString();

            if (milesValue.equals("")) {
                kmInput.setText("");
                return;
            }

            double milesParsed = Double.parseDouble(milesValue);
            String convertedKm = decimalFormat.format(milesParsed * 1.609);

            kmInput.setText(convertedKm);
        }

    }
}
