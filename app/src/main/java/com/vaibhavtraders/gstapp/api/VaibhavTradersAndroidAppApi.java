package com.vaibhavtraders.gstapp.api;

import com.vaibhavtraders.gstapp.model.Product;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface VaibhavTradersAndroidAppApi {
    // Products
    @POST("/products/add")
    Call<Product> createProduct(@Body Product product);

    
}
