package com.vaibhavtraders.gstapp.api;

import com.vaibhavtraders.gstapp.model.Country;
import com.vaibhavtraders.gstapp.model.Customer;
import com.vaibhavtraders.gstapp.model.DeliveryMode;
import com.vaibhavtraders.gstapp.model.Invoice;
import com.vaibhavtraders.gstapp.model.Product;
import com.vaibhavtraders.gstapp.model.State;
import com.vaibhavtraders.gstapp.model.YearMonthModel;
import com.vaibhavtraders.gstapp.requests.InvoiceCreationUpdationRequest;
import com.vaibhavtraders.gstapp.response.ResponseObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface VaibhavTradersAndroidAppApi {
    // Products
    @POST("/products/add")
    Call<ResponseObject> createProduct(@Body Product product);

    @GET("/products/findall")
    Call<ResponseObject> findAllProducts();

    @POST("/products/deleteproduct")
    Call<ResponseObject> deleteProduct(@Body Product product);

    // Customers
    @POST("/customers/add")
    Call<ResponseObject> createCustomer(@Body Customer customer);

    @GET("/customers/findall")
    Call<ResponseObject> findAllCustomers();

    @POST("/customers/deletecustomer")
    Call<ResponseObject> deleteCustomer(@Body Customer customer);

    // Countries
    @POST("/countries/add")
    Call<ResponseObject> createCountry(@Body Country country);

    @GET("/countries/findall")
    Call<ResponseObject> findAllCountries();

    @POST("/countries/deletecountry")
    Call<ResponseObject> deleteCountry(@Body Country country);

    // Delivery Modes
    @POST("/deliverymodes/add")
    Call<ResponseObject> createDeliveryMode(@Body DeliveryMode deliveryMode);

    @GET("/deliverymodes/findall")
    Call<ResponseObject> findAllDeliveryModes();

    @POST("/deliverymodes/deletedeliverymode")
    Call<ResponseObject> deleteCountry(@Body DeliveryMode deliveryMode);

    // States
    @POST("/states/add")
    Call<ResponseObject> createState(@Body State state);

    @GET("/states/findall")
    Call<ResponseObject> findAllStates();

    @POST("/states/deletestate")
    Call<ResponseObject> deleteState(@Body State state);

    // Invoice
    @POST("/invoice/createInvoice")
    Call<ResponseObject> createInvoice(@Body InvoiceCreationUpdationRequest invoiceCreationUpdationRequest);

    @POST("/invoice/updateInvoice")
    Call<ResponseObject> updateInvoice(@Body InvoiceCreationUpdationRequest invoiceCreationUpdationRequest);

    @POST("/invoice/deleteInvoice")
    Call<ResponseObject> deleteInvoice(@Body Invoice invoice);

    @GET("/invoice")
    Call<ResponseObject> findInvoiceById(@Body Long invoiceId);

    @GET("/invoice/byMonthYear")
    Call<ResponseObject> findInvoicesByMonthYear(@Body YearMonthModel yearMonthModel);

    // Invoice Item

}
