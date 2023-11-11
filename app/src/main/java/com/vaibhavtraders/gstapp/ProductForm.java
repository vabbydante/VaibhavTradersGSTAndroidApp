package com.vaibhavtraders.gstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.vaibhavtraders.gstapp.api.VaibhavTradersAndroidAppApi;
import com.vaibhavtraders.gstapp.model.Product;
import com.vaibhavtraders.gstapp.retrofit.RetrofitService;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductForm extends AppCompatActivity {
    private EditText etProductName;
    private EditText etProductDesc;
    private EditText etProductHsn;
    private EditText etProductUom;
    private EditText etProductStock;
    private EditText etProductGstpercentage;
    private EditText etProductCessPercentage;
    private EditText etProductCessAmount;
    private EditText etProductSellPrice;
    private EditText etProductSellPriceInclTax;
    private EditText etProductPurchasePrice;
    private EditText etProductPurchasePriceInclTax;

    private Button saveProduct;
    private ProgressBar productSaveProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_form);

        initializeComponents();
    }

    private void initializeComponents() {
        etProductName = findViewById(R.id.et_product_name);
        etProductDesc = findViewById(R.id.et_product_desc);
        etProductHsn = findViewById(R.id.et_product_hsn);
        etProductUom = findViewById(R.id.et_product_uom);
        etProductStock = findViewById(R.id.et_product_stock);
        etProductGstpercentage = findViewById(R.id.et_product_gstpercentage);
        etProductCessPercentage = findViewById(R.id.et_product_cesspercentage);
        etProductCessAmount = findViewById(R.id.et_product_cessamount);
        etProductSellPrice = findViewById(R.id.et_product_sellprice);
        etProductSellPriceInclTax = findViewById(R.id.et_product_sellpriceincltax);
        etProductPurchasePrice = findViewById(R.id.et_product_purchaseprice);
        etProductPurchasePriceInclTax = findViewById(R.id.et_product_purchasepriceincltax);
        saveProduct = findViewById(R.id.btn_save_product);
        productSaveProgressBar = findViewById(R.id.progressBarSaveProduct);
        productSaveProgressBar.setVisibility(View.GONE);

        RetrofitService retrofitService = new RetrofitService();
        VaibhavTradersAndroidAppApi vaibhavTradersAndroidAppApi = retrofitService.getRetrofit().create(VaibhavTradersAndroidAppApi.class);

        saveProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String productName = String.valueOf(etProductName.getText());
                String productDesc = String.valueOf(etProductDesc.getText());
                String productHsn = String.valueOf(etProductHsn.getText());
                String productUom = String.valueOf(etProductUom.getText());
                String productStock = String.valueOf(etProductStock.getText());
                String productGstPercentage = String.valueOf(etProductGstpercentage.getText());
                String productCessPercentage = String.valueOf(etProductCessPercentage.getText());
                String productCessAmount = String.valueOf(etProductCessAmount.getText());
                String productSellPrice = String.valueOf(etProductSellPrice.getText());
                String productSellPriceInclTax = String.valueOf(etProductSellPriceInclTax.getText());
                String productPurchasePrice = String.valueOf(etProductPurchasePrice.getText());
                String productPurchasePriceInclTax = String.valueOf(etProductPurchasePriceInclTax.getText());

                Product product = new Product();
                product.setName(productName);
                product.setProductDescription(productDesc);
                product.setHsnHacCode(productHsn);
                product.setUnitOfMeasurement(productUom);
                product.setStock(Integer.valueOf(productStock));
                product.setGstPercentage(Double.valueOf(productGstPercentage));
                if(!"".equals(productCessPercentage)){
                    product.setCessPercentage(Double.valueOf(productCessPercentage));
                } else {
                    product.setCessPercentage(null);
                }

                if(!"".equals(productCessAmount)){
                    product.setCessAmount(Double.valueOf(productCessAmount));
                } else {
                    product.setCessAmount(null);
                }
                product.setSellPrice(Double.valueOf(productSellPrice));
                product.setSellPriceIncludingTax(Double.valueOf(productSellPriceInclTax));
                product.setPurchasePrice(Double.valueOf(productPurchasePrice));
                product.setPurchasePriceIncludingTax(Double.valueOf(productPurchasePriceInclTax));
                
                productSaveProgressBar.setVisibility(View.VISIBLE);
                vaibhavTradersAndroidAppApi.createProduct(product)
                        .enqueue(new Callback<Product>() {
                            @Override
                            public void onResponse(Call<Product> call, Response<Product> response) {
                                Toast.makeText(ProductForm.this, "Save Successful.", Toast.LENGTH_SHORT).show();
                                saveProduct.setText("Save Product");
                                productSaveProgressBar.setVisibility(View.GONE);
                                Logger.getLogger(ProductForm.class.getName()).log(Level.SEVERE, "product response : ", response);
                            }

                            @Override
                            public void onFailure(Call<Product> call, Throwable t) {
                                Toast.makeText(ProductForm.this, "Save Failed!", Toast.LENGTH_SHORT).show();
                                Toast.makeText(ProductForm.this, t.toString(), Toast.LENGTH_SHORT).show();
                                saveProduct.setText("Save Product");
                                productSaveProgressBar.setVisibility(View.GONE);
                                Logger.getLogger(ProductForm.class.getName()).log(Level.SEVERE, "Error Occured.", t);
                            }
                        });
            }
        });
    }
}