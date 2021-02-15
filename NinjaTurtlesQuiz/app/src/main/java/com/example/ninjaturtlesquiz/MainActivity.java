package com.example.ninjaturtlesquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public String[] turtleImages = {
            "turtle_donatelo",
            "turtle_leonardo",
            "turtle_michelangelo",
            "turtle_raphael"
    };
    public int currentQuestion = 0;

    ImageView imageQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageQuestion  = (ImageView)findViewById(R.id.imageQuestion);
        imageQuestion.setImageResource(R.drawable.turtle_donatelo);
    }

    public void onNextQuestion(View v) {
        Toast.makeText(this, "asdasdasd", Toast.LENGTH_SHORT).show();
        currentQuestion += 1;
        String imageName = turtleImages[currentQuestion];
        int imageId = getResources().getIdentifier(imageName, "drawable", MainActivity.this.getPackageName());

        imageQuestion.setImageResource(imageId);
    }
}