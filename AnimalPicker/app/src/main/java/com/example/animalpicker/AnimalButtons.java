package com.example.animalpicker;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;

public class AnimalButtons extends Activity implements View.OnClickListener {
    HashMap<String, String> animalItems = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LocaleHelper.setLocale(this,  LocaleHelper.getLanguage(this));

        setContentView(R.layout.activity_animal_buttons);

        // Define animals with their keys
        animalItems.put("dog_btn", "dog");
        animalItems.put("horse_btn", "horse");
        animalItems.put("fox_btn", "fox");
        animalItems.put("chicken_btn", "chicken");

        for (String buttonID : animalItems.keySet()) {
            // Get Button view with animal's key
            int buttonViewId = getResources().getIdentifier(buttonID, "id", AnimalButtons.this.getPackageName());
            Button animalButton = (Button) findViewById(buttonViewId);

            // OnClickListener can be set like this because class AnimalButtons is implementing View.OnCLickListener...
            // see Line 13 or this answer https://stackoverflow.com/questions/25905086/multiple-buttons-onclicklistener-android
            animalButton.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        // get button entry name... e.g. dog_btn
        String animalKey = getResources().getResourceEntryName(view.getId());

        // get string's entry name from a hash map
        String animalStringEntryName = animalItems.get(animalKey);

        int animalStringID = getResources().getIdentifier(animalStringEntryName, "string", AnimalButtons.this.getPackageName());

        String yourChoiceText = getString(R.string.your_choice_text);
        String animalName = getString(animalStringID);

        String message = yourChoiceText + " " + animalName;
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}