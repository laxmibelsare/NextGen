package com.example.nextgen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Selection_FormActivity extends AppCompatActivity {

    CardView CustomerArrow, VendorArrow;
    ImageView Scooty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_selection_form);

        CustomerArrow = findViewById(R.id.cvCustomerArrow);
        VendorArrow = findViewById(R.id.cvVendorArrow);
        Scooty = findViewById(R.id.ivScootyMoving);

        CustomerArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Selection_FormActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        VendorArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Selection_FormActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        Animation animation = AnimationUtils.loadAnimation(Selection_FormActivity.this,R.anim.scooty_moving);
        Scooty.startAnimation(animation);

    }
}