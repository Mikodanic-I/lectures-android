package com.example.ninjaturtlesquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        ArrayList<Integer> results = getIntent().getIntegerArrayListExtra("ANSWER_RESULTS");

        TextView resultView;
        int correctAnswers = 0;

        // This project would be completely dynamic if there would be dynamically created TextViews and RadioButtons
        // but I currently don't have time to do that so this for-loop will do the job for now.
        for (int i = 0; i < results.size(); i++) {
            String viewName = "result" + i;
            int resultViewId = getResources().getIdentifier(viewName, "id", Results.this.getPackageName());

            resultView = (TextView) findViewById(resultViewId);

            int result = results.get(i);
            String resultText = result == 1 ? "correct" : "incorrect";
            String resultMessage = (i + 1) + ". Question is " + resultText;

            resultView.setText(resultMessage);
            correctAnswers += result;
        }

        TextView correctAnswersView = (TextView) findViewById(R.id.correctAnswers);
        correctAnswersView.setText("Correct answers: " + correctAnswers);
    }
}