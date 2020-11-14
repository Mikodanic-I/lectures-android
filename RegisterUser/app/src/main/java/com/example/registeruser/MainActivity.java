package com.example.registeruser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Made by Ivan Mikodanić", Toast.LENGTH_SHORT).show();

        // get inputs
        final EditText inputFirstName = (EditText) findViewById(R.id.inputFirstName);
        final EditText inputLastName = (EditText) findViewById(R.id.inputLastName);
        final EditText inputEmail = (EditText) findViewById(R.id.inputEmail);

        // get text views where input values are shown
        final TextView shownFirstName = (TextView) findViewById(R.id.shownFirstName);
        final TextView shownLastName = (TextView) findViewById(R.id.shownLastName);
        final TextView shownEmail = (TextView) findViewById(R.id.shownEmail);

        Button registerButton = (Button) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // get input values
                String firstName = inputFirstName.getText().toString();
                String lastName = inputLastName.getText().toString();
                String email = inputEmail.getText().toString();

                // set input values
                shownFirstName.setText(firstName);
                shownLastName.setText(lastName);
                shownEmail.setText(email);

                // close the virtual keyboard
                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);

                try {
                    inputManager.hideSoftInputFromWindow(Objects.requireNonNull(getCurrentFocus()).getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);
                } catch (Exception ignored) {}

            }
        });
    }
}