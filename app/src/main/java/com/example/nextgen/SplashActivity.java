package com.example.nextgen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    ImageView partTopLeft, partTopRight;
    ImageView partBottomLeft, partBottomRight;
    ImageView finalLogo;

    LinearLayout brandLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        partTopLeft = findViewById(R.id.partTopLeft);
        partTopRight = findViewById(R.id.partTopRight);
        partBottomLeft = findViewById(R.id.partBottomLeft);
        partBottomRight = findViewById(R.id.partBottomRight);

        finalLogo = findViewById(R.id.finalLogo);
        brandLayout = findViewById(R.id.brandLayout);
        partTopLeft.setTranslationX(0);
        partTopLeft.setTranslationY(0);

        partTopRight.setTranslationX(0);
        partTopRight.setTranslationY(0);

        partBottomLeft.setTranslationX(0);
        partBottomLeft.setTranslationY(0);

        partBottomRight.setTranslationX(0);
        partBottomRight.setTranslationY(0);

        partTopLeft.postDelayed(() -> {

            // TOP LEFT
            partTopLeft.animate()
                    .translationX(-450)
                    .translationY(-750)
                    .setDuration(0)
                    .start();

            // TOP RIGHT
            partTopRight.animate()
                    .translationX(450)
                    .translationY(-750)
                    .setDuration(0)
                    .start();

            // BOTTOM LEFT
            partBottomLeft.animate()
                    .translationX(-450)
                    .translationY(750)
                    .setDuration(0)
                    .start();

            // BOTTOM RIGHT
            partBottomRight.animate()
                    .translationX(450)
                    .translationY(750)
                    .setDuration(0)
                    .start();


            // Start all 4 parts coming to center

            partTopLeft.animate()
                    .translationX(0)
                    .translationY(0)
                    .setDuration(1000)
                    .setInterpolator(new AccelerateDecelerateInterpolator())
                    .start();

            partTopRight.animate()
                    .translationX(0)
                    .translationY(0)
                    .setDuration(1000)
                    .setInterpolator(new AccelerateDecelerateInterpolator())
                    .start();

            partBottomLeft.animate()
                    .translationX(0)
                    .translationY(0)
                    .setDuration(1000)
                    .setInterpolator(new AccelerateDecelerateInterpolator())
                    .start();

            partBottomRight.animate()
                    .translationX(0)
                    .translationY(0)
                    .setDuration(1000)
                    .setInterpolator(new AccelerateDecelerateInterpolator())
                    .start();


            // After 1 second show final logo
            partTopLeft.postDelayed(() -> {

                partTopLeft.setVisibility(View.GONE);
                partTopRight.setVisibility(View.GONE);
                partBottomLeft.setVisibility(View.GONE);
                partBottomRight.setVisibility(View.GONE);

                finalLogo.setVisibility(View.VISIBLE);

                finalLogo.setAlpha(0f);
                finalLogo.setScaleX(0.7f);
                finalLogo.setScaleY(0.7f);

                finalLogo.animate()
                        .alpha(1f)
                        .scaleX(1f)
                        .scaleY(1f)
                        .setDuration(600)
                        .start();


                // Show app name
                brandLayout.setAlpha(0f);

                brandLayout.animate()
                        .alpha(1f)
                        .setDuration(500)
                        .setStartDelay(300)
                        .start();


                // Go to next screen
                brandLayout.postDelayed(() -> {

                    Intent intent =
                            new Intent(SplashActivity.this, Selection_FormActivity.class);

                    startActivity(intent);
                    finish();

                }, 1800);

            }, 1000);

        }, 300);
    }
}