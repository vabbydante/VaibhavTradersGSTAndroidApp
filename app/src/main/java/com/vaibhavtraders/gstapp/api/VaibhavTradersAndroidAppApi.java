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
    Call<Product> createProduct(@Body Product product);

    @GET("/products/findall")
    Call<ResponseObject> findAllProducts();

    @POST("/products/deleteproduct")
    Call<Product> deleteProduct(@Body Product product);

    // Customers
    @POST("/customers/add")
    Call<Customer> createCustomer(@Body Customer customer);

    @GET("/customers/findall")
    Call<ResponseObject> findAllCustomers();

    @POST("/customers/deletecustomer")
    Call<Customer> deleteCustomer(@Body Customer customer);

    // Countries
    @POST("/countries/add")
    Call<Country> createCountry(@Body Country country);

    @GET("/countries/findall")
    Call<ResponseObject> findAllCountries();

    @POST("/countries/deletecountry")
    Call<Country> deleteCountry(@Body Country country);

    // Delivery Modes
    @POST("/deliverymodes/add")
    Call<DeliveryMode> createDeliveryMode(@Body DeliveryMode deliveryMode);

    @GET("/deliverymodes/findall")
    Call<ResponseObject> findAllDeliveryModes();

    @POST("/deliverymodes/deletedeliverymode")
    Call<DeliveryMode> deleteDeliveryMode(@Body DeliveryMode deliveryMode);

    // States
    @POST("/states/add")
    Call<State> createState(@Body State state);

    @GET("/states/findall")
    Call<ResponseObject> findAllStates();

    @POST("/states/deletestate")
    Call<State> deleteState(@Body State state);

    // Invoice
    @POST("/invoice/createInvoice")
    Call<InvoiceCreationUpdationRequest> createInvoice(@Body InvoiceCreationUpdationRequest invoiceCreationUpdationRequest);

    @POST("/invoice/updateInvoice")
    Call<InvoiceCreationUpdationRequest> updateInvoice(@Body InvoiceCreationUpdationRequest invoiceCreationUpdationRequest);

    @POST("/invoice/deleteInvoice")
    Call<Invoice> deleteInvoice(@Body Invoice invoice);

    @GET("/invoice")
    Call<ResponseObject> findInvoiceById(@Body Long invoiceId);

    @GET("/invoice/byMonthYear")
    Call<ResponseObject> findInvoicesByMonthYear(@Body YearMonthModel yearMonthModel);

    // Invoice Item

}
