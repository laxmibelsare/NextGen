package com.example.nextgen;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.nextgen.CustomerFragments.HomeFragment;
import com.example.nextgen.VendorFragments.CustomersFragment;
import com.example.nextgen.VendorFragments.DashboardFragment;
import com.example.nextgen.VendorFragments.DeliveriesVendorFragment;
import com.example.nextgen.VendorFragments.PaymentsVendorFragment;
import com.example.nextgen.VendorFragments.VendorProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home_vendorActivity extends AppCompatActivity {

    Toolbar toolbar;
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_vendor);

        // Find views
        toolbar = findViewById(R.id.toolbar);
        bottomNavigation = findViewById(R.id.bottomNavigation);

        // Set Toolbar
        setSupportActionBar(toolbar);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new DashboardFragment())
                    .commit();

            // Select Home item by default
            bottomNavigation.setSelectedItemId(R.id.empty);
        }

        // Bottom Menu Click
        bottomNavigation.setOnItemSelectedListener(item -> {

            Fragment fragment = null;

            int itemId = item.getItemId();


            if (itemId == R.id.home) {
                fragment = new DashboardFragment();

            }
            else if (itemId == R.id.Customers) {
                fragment = new CustomersFragment();

            } else if (itemId == R.id.deliveries) {
                fragment = new DeliveriesVendorFragment();

            } else if (itemId == R.id.Payment) {
                fragment = new PaymentsVendorFragment();

            } else if (itemId == R.id.profile) {
                fragment = new VendorProfileFragment();
            }

            if (fragment != null) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .commit();

                return true;
            }

            return false;
        });
    }

    // Top Toolbar Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.home_menu_vendors, menu);

        return true;
    }

    // Top Menu Click
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemId = item.getItemId();

        if (itemId == R.id.menuHomeBusiness) {

            Toast.makeText(this,
                    "Business Details",
                    Toast.LENGTH_SHORT).show();

            return true;

        } else if (itemId == R.id.menuHomeMyService) {

            Toast.makeText(this,
                    "My Service",
                    Toast.LENGTH_SHORT).show();

            return true;

        } else if (itemId == R.id.menuHomeNotification) {

            Toast.makeText(this,
                    "Notification",
                    Toast.LENGTH_SHORT).show();

            return true;

        } else if (itemId == R.id.menuHomeSettings) {

            Toast.makeText(this,
                    "Settings",
                    Toast.LENGTH_SHORT).show();

            return true;

        } else if (itemId == R.id.menuHomeHelp_Support) {

            Toast.makeText(this,
                    "Help & Support",
                    Toast.LENGTH_SHORT).show();

            return true;

        } else if (itemId == R.id.menuHomeLogout) {

            Toast.makeText(this,
                    "Logout",
                    Toast.LENGTH_SHORT).show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}