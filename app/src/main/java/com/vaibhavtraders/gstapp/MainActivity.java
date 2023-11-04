package com.vaibhavtraders.gstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialToolbar materialToolbar = findViewById(R.id.topAppBar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigationView);
        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                drawerLayout.closeDrawer(GravityCompat.START);
                if (id == R.id.nav_home) {
                    Toast.makeText(MainActivity.this, "Home is clicked.", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.nav_profile) {
                    Toast.makeText(MainActivity.this, "Profile is clicked.", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.nav_settings) {
                    Toast.makeText(MainActivity.this, "Settings is clicked.", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.nav_help) {
                    Toast.makeText(MainActivity.this, "Help is clicked.", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.nav_countries) {
                    Toast.makeText(MainActivity.this, "Countries is clicked.", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.nav_customers) {
                    Toast.makeText(MainActivity.this, "Customers is clicked.", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.nav_deliverymodes) {
                    Toast.makeText(MainActivity.this, "Delivery Modes is clicked.", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.nav_products) {
                    Toast.makeText(MainActivity.this, "Products is clicked.", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.nav_states) {
                    Toast.makeText(MainActivity.this, "States is clicked.", Toast.LENGTH_SHORT).show();
                } else {
                    return true;
                }

                return true;
            }
        });
    }
}