package com.example.backgroundcolor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton blueButton;
    RadioButton magentaButton;
    RadioButton yellowButton;
    ConstraintLayout layout;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            // action when blue radio button clicked
            case R.id.blueButton:
                if (checked)
                    layout.setBackgroundColor(Color.BLUE);
                editor.putInt("bkc",Color.BLUE);
                break;
            // action when magenta radio button clicked
            case R.id.magentaButton:
                if (checked)
                    layout.setBackgroundColor(Color.MAGENTA);
                editor.putInt("bkc",Color.MAGENTA);
                break;
            // action when yellow radio button clicked
            case R.id.yellowButton:
                if (checked)
                    layout.setBackgroundColor(Color.YELLOW);
                editor.putInt("bkc",Color.YELLOW);
                break;
        }

        // save changes
        editor.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get button and group objects
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        blueButton= (RadioButton)findViewById(R.id.blueButton);
        magentaButton = (RadioButton)findViewById(R.id.magentaButton);
        yellowButton = (RadioButton)findViewById(R.id.yellowButton);

        layout = (ConstraintLayout)findViewById(R.id.layout);

        // load default (last clicked) settings
        pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        editor = pref.edit();

        // set last selected color
        int bkc = pref.getInt("bkc",Color.WHITE);
        layout.setBackgroundColor(bkc);
    }
}

