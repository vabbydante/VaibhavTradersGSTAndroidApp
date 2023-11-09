package com.vaibhavtraders.gstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.vaibhavtraders.gstapp.api.VaibhavTradersAndroidAppApi;
import com.vaibhavtraders.gstapp.model.Product;
import com.vaibhavtraders.gstapp.retrofit.RetrofitService;

public class ProductForm extends AppCompatActivity {
    private EditText productEditText;
    private Button saveProduct;
    private ProgressBar productSaveProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_form);

        initializeComponents();
    }

    private void initializeComponents() {
        productEditText = findViewById(R.id.et_product_name);
        saveProduct = findViewById(R.id.btn_save_product);
        productSaveProgressBar = findViewById(R.id.progressBarSaveProduct);
        productSaveProgressBar.setVisibility(View.GONE);

        RetrofitService retrofitService = new RetrofitService();
        VaibhavTradersAndroidAppApi vaibhavTradersAndroidAppApi = retrofitService.getRetrofit().create(VaibhavTradersAndroidAppApi.class);

        saveProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String productName = String.valueOf(productEditText.getText());

                Product product = new Product();
                product.setName(productName);
            }
        });
    }
}