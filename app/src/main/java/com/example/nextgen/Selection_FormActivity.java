package com.example.nextgen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Selection_FormActivity extends AppCompatActivity {

    CardView CustomerArrow, VendorArrow;
    ImageView Scooty;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_selection_form);

        preferences =
                PreferenceManager.getDefaultSharedPreferences(this);

        CustomerArrow = findViewById(R.id.cvCustomerArrow);
        VendorArrow = findViewById(R.id.cvVendorArrow);
        Scooty = findViewById(R.id.ivScootyMoving);


        // Customer Selection
        CustomerArrow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Selection Form shown/used
                preferences.edit()
                        .putBoolean("isSelectionShown", true)
                        .apply();

                Intent i = new Intent(
                        Selection_FormActivity.this,
                        LoginCustomerActivity.class
                );

                startActivity(i);
                finish();
            }
        });


        // Vendor Selection
        VendorArrow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Selection Form shown/used
                preferences.edit()
                        .putBoolean("isSelectionShown", true)
                        .apply();

                Intent i = new Intent(
                        Selection_FormActivity.this,
                        LoginVendorActivity.class
                );

                startActivity(i);
                finish();
            }
        });


        // Scooty Animation
        Animation animation = AnimationUtils.loadAnimation(
                Selection_FormActivity.this,
                R.anim.scooty_moving
        );

        Scooty.startAnimation(animation);
    }
}