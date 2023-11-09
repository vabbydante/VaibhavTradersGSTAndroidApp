package com.vaibhavtraders.gstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.vaibhavtraders.gstapp.api.VaibhavTradersAndroidAppApi;
import com.vaibhavtraders.gstapp.model.Country;
import com.vaibhavtraders.gstapp.response.ResponseObject;
import com.vaibhavtraders.gstapp.retrofit.RetrofitService;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryForm extends AppCompatActivity {

    private EditText countryEditText;
    private Button saveCountry;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_form);

        initializeComponents();


    }

    private void initializeComponents() {
        countryEditText = findViewById(R.id.et_country_name);
        saveCountry = findViewById(R.id.btn_save_country);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        RetrofitService retrofitService = new RetrofitService();
        VaibhavTradersAndroidAppApi vaibhavTradersAndroidAppApi = retrofitService.getRetrofit().create(VaibhavTradersAndroidAppApi.class);
        saveCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String countryName = String.valueOf(countryEditText.getText());

                Country country = new Country();
                country.setCountryName(countryName);
                saveCountry.setText("");
                progressBar.setVisibility(View.VISIBLE);
                vaibhavTradersAndroidAppApi.createCountry(country)
                        .enqueue(new Callback<Country>() {
                            @Override
                            public void onResponse(Call<Country> call, Response<Country> response) {
                                Toast.makeText(CountryForm.this, "Save Successful!", Toast.LENGTH_SHORT).show();
                                saveCountry.setText("Save Country");
                                progressBar.setVisibility(View.GONE);
                            }

                            @Override
                            public void onFailure(Call<Country> call, Throwable t) {
                                Toast.makeText(CountryForm.this, "Save Failed!", Toast.LENGTH_SHORT).show();
                                Toast.makeText(CountryForm.this, t.toString(), Toast.LENGTH_LONG).show();
                                saveCountry.setText("Save Country");
                                progressBar.setVisibility(View.GONE);
                                Logger.getLogger(CountryForm.class.getName()).log(Level.SEVERE, "Error occured!", t);
                            }
                        });
            }
        });
    }
}