package com.example.ninjaturtlesquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public int currentQuestion = 0;

    public ArrayList<Integer> answers = new ArrayList<Integer>();

    ImageView imageQuestion;

    // Define all image names
    public String[] turtleImages = {
            "turtle_donatelo",
            "turtle_leonardo",
            "turtle_michelangelo",
            "turtle_raphael"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageQuestion  = (ImageView)findViewById(R.id.imageQuestion);

        int imageId = getResources().getIdentifier(turtleImages[0], "drawable", MainActivity.this.getPackageName());
        imageQuestion.setImageResource(imageId);
    }

    public void onNextQuestion(View view) {
        Button nextButton = (Button) findViewById(R.id.next_button);

        // Check answer
        RadioGroup radioQuestion = (RadioGroup) findViewById(R.id.radioQuestion);

        int selectedChoiceId = radioQuestion.getCheckedRadioButtonId();

        if (selectedChoiceId == -1) {
            Toast.makeText(this, "You have to choose an option!", Toast.LENGTH_SHORT).show();
            return;
        }

        String choiceValue = view.getResources().getResourceEntryName(selectedChoiceId);

        // 1 represents correct and 0 incorrect answer...
        if (choiceValue.equals(turtleImages[currentQuestion])) {
//            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            answers.add(1);
        } else {
//            Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show();
            answers.add(0);
        }

        // Clear all selections
        radioQuestion.clearCheck();

        // Start results activity
        if (currentQuestion == turtleImages.length - 1) {
            Intent resultsActivity = new Intent(this, Results.class);
            resultsActivity.putIntegerArrayListExtra("ANSWER_RESULTS", answers);

            startActivity(resultsActivity);

            // Reset quiz
            currentQuestion = 0;
            answers = new ArrayList<Integer>();
            nextButton.setText("Next");
            return;
        }

        // Switch to next question
        currentQuestion += 1;
        String imageName = turtleImages[currentQuestion];
        int imageId = getResources().getIdentifier(imageName, "drawable", MainActivity.this.getPackageName());

        imageQuestion.setImageResource(imageId);

        // Change button text when it's the last question
        if (currentQuestion == turtleImages.length - 1) {
            nextButton.setText("Finish");
        }
    }
}