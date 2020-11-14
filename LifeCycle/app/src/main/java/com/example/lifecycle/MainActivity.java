package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onCreate Toast", Toast.LENGTH_SHORT).show();
    }
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onResume Toast", Toast.LENGTH_SHORT).show();
    }
    protected void onStart(){
        super.onStart();
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onStart Toast", Toast.LENGTH_SHORT).show();
    }
    protected void onStop(){
        super.onStop();
        Toast.makeText(this, "onStop Toast", Toast.LENGTH_SHORT).show();
    }
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause Toast", Toast.LENGTH_SHORT).show();
    }
}