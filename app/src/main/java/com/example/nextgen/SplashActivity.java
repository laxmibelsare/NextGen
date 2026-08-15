package com.example.nextgen;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;

public class SplashActivity extends AppCompatActivity {

    ImageView partTopLeft, partTopRight;
    ImageView partBottomLeft, partBottomRight;
    ImageView finalLogo;

    LinearLayout brandLayout;

    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        partTopLeft = findViewById(R.id.partTopLeft);
        partTopRight = findViewById(R.id.partTopRight);
        partBottomLeft = findViewById(R.id.partBottomLeft);
        partBottomRight = findViewById(R.id.partBottomRight);
        lottieAnimationView =findViewById(R.id.lottieGirl);

        TextView txtDailyServe = findViewById(R.id.txtDailyServe);

        SpannableString text = new SpannableString("Daily Serve");

        text.setSpan(
                new ForegroundColorSpan(Color.parseColor("#123B5D")),
                0, 5,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        );

        text.setSpan(
                new ForegroundColorSpan(Color.parseColor("#009688")),
                6, 11,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        );

        txtDailyServe.setText(text);

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
            partTopLeft.animate()
                    .translationX(-450)
                    .translationY(-750)
                    .setDuration(0)
                    .start();

            partTopRight.animate()
                    .translationX(450)
                    .translationY(-750)
                    .setDuration(0)
                    .start();

            partBottomLeft.animate()
                    .translationX(-450)
                    .translationY(750)
                    .setDuration(0)
                    .start();

            partBottomRight.animate()
                    .translationX(450)
                    .translationY(750)
                    .setDuration(0)
                    .start();

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

                brandLayout.setAlpha(0f);

                brandLayout.animate()
                        .alpha(1f)
                        .setDuration(500)
                        .setStartDelay(300)
                        .start();

                brandLayout.postDelayed(() -> {

                    Intent intent = new Intent(SplashActivity.this, Selection_FormActivity.class);
                    startActivity(intent);
                    finish();

                    brandLayout.postDelayed(() -> {

                        lottieAnimationView.setVisibility(View.VISIBLE);

                        lottieAnimationView.setRepeatCount(LottieDrawable.INFINITE);
                        lottieAnimationView.playAnimation();

                    }, 15000);

                }, 1800);

            }, 1000);

        }, 500);
    }
}