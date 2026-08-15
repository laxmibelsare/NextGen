package com.example.nextgen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class LoginCustomerActivity extends AppCompatActivity
{

    MaterialButton btnLogin;

    TextView SignUp,forgetPass;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_customer);

        btnLogin = findViewById(R.id.btnCustomerLogin);
        SignUp = findViewById(R.id.tvCustomerSignUp);
        forgetPass = findViewById(R.id.tvCustomerForgotPassword);

        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(LoginCustomerActivity.this, home_customerActivity.class);
                startActivity(i);

            }
        });

        SignUp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(LoginCustomerActivity.this, RegistrationCustomerActivity.class);
                startActivity(i);

            }
        });

        forgetPass.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(LoginCustomerActivity.this, ForgetCustomerActivity.class);
                startActivity(i);

            }
        });

    }
}