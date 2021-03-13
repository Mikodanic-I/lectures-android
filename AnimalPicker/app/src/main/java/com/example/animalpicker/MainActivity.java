package com.example.animalpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LocaleHelper.setLocale(this,  LocaleHelper.getLanguage(this));

        setContentView(R.layout.activity_main);
    }

    public void setHRLocale(View view) {
        LocaleHelper.setLocale(this, "hr");
        Intent intent = getIntent();
        finish();
        startActivity(intent);

        startAnimalButtons();
    }
    public void setENLocale(View view) {
        LocaleHelper.setLocale(this, "en");
        Intent intent = getIntent();
        finish();
        startActivity(intent);

        startAnimalButtons();
    }

    private void startAnimalButtons() {
        Intent animalIntent = new Intent(this, AnimalButtons.class);
        startActivity(animalIntent);
    }
}
