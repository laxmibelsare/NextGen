package com.example.nextgen;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.nextgen.CustomerFragments.CustomerProfileFragment;
import com.example.nextgen.CustomerFragments.HomeFragment;
import com.example.nextgen.CustomerFragments.DeliveriesCustomerFragment;
import com.example.nextgen.CustomerFragments.PaymentsCustomerFragment;
import com.example.nextgen.CustomerFragments.SubscriptionsVendorsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class home_customerActivity extends AppCompatActivity {

    Toolbar toolbar;
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_customer);

        // Toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Bottom Navigation
        bottomNavigation = findViewById(R.id.bottomNavigation);

        // Default Home Fragment
        if (savedInstanceState == null) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(
                            R.id.fragment_container,
                            new HomeFragment()
                    )
                    .commit();

            bottomNavigation.setSelectedItemId(R.id.Home);
        }

        // Bottom Navigation Click
        bottomNavigation.setOnItemSelectedListener(item -> {

            Fragment fragment = null;

            int itemId = item.getItemId();

            // HOME
            if (itemId == R.id.Home) {

                fragment = new HomeFragment();

            }

            // DELIVERIES
            else if (itemId == R.id.deliveries) {

                fragment = new DeliveriesCustomerFragment();

            }

            // SUBSCRIPTION
            else if (itemId == R.id.Subscription) {

                fragment = new SubscriptionsVendorsFragment();

            }

            // PAYMENT
            else if (itemId == R.id.Payment) {

                fragment = new PaymentsCustomerFragment();

            }

            // PROFILE
            else if (itemId == R.id.profile) {

                fragment = new CustomerProfileFragment();

            }

            // Open Fragment
            if (fragment != null) {

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(
                                R.id.fragment_container,
                                fragment
                        )
                        .commit();

                return true;
            }

            return false;
        });
    }


    // Toolbar Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(
                R.menu.home_menu_customer,
                menu
        );

        return true;
    }


    // Toolbar Menu Click
    @Override
    public boolean onOptionsItemSelected(
            @NonNull MenuItem item) {

        int itemId = item.getItemId();

        if (itemId == R.id.menuHomeNotification) {

            Toast.makeText(
                    this,
                    "Notifications",
                    Toast.LENGTH_SHORT
            ).show();

            return true;

        } else if (itemId == R.id.menuHomeSettings) {

            Toast.makeText(
                    this,
                    "Settings",
                    Toast.LENGTH_SHORT
            ).show();

            return true;

        } else if (itemId == R.id.menuHomeHelp_Support) {

            Toast.makeText(
                    this,
                    "Help & Support",
                    Toast.LENGTH_SHORT
            ).show();

            return true;

        } else if (itemId == R.id.menuHomeLogout) {

            Toast.makeText(
                    this,
                    "Logout",
                    Toast.LENGTH_SHORT
            ).show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}