package com.example.nextgen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class LoginVendorActivity extends AppCompatActivity
{

    MaterialButton btnLogin;

    TextView SignUp,forgetPass;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_vendor);

        btnLogin = findViewById(R.id.btnLogin);
        SignUp = findViewById(R.id.tvSignUp);
        forgetPass = findViewById(R.id.tvForgotPassword);

        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(LoginVendorActivity.this, Home_vendorActivity.class);
                startActivity(i);

            }
        });

        SignUp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(LoginVendorActivity.this,RegistrationVendorActivity.class);
                startActivity(i);

            }
        });

        forgetPass.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(LoginVendorActivity.this,ForgetVendorActivity.class);
                startActivity(i);

            }
        });

    }
}