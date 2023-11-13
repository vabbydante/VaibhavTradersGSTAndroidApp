package com.vaibhavtraders.gstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vaibhavtraders.gstapp.api.VaibhavTradersAndroidAppApi;
import com.vaibhavtraders.gstapp.dto.CountryDTO;
import com.vaibhavtraders.gstapp.dto.StateDTO;
import com.vaibhavtraders.gstapp.model.Country;
import com.vaibhavtraders.gstapp.model.Customer;
import com.vaibhavtraders.gstapp.model.State;
import com.vaibhavtraders.gstapp.response.ResponseObject;
import com.vaibhavtraders.gstapp.retrofit.RetrofitService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomerForm extends AppCompatActivity {
    EditText companyName, gstin, contactPerson, customerPhone, customerEmail,
            customerPan, customerAddressLine1, customerAddressLine2, customerLandmark,
            customerCity, customerPincode, customerWebsite, customerNote;
    AutoCompleteTextView spinnerState, spinnerCountry;
    Button saveCustomer;
    private List<CountryDTO> countryList;
    private List<StateDTO> stateList;
    ArrayAdapter<CountryDTO> countryAdapter;
    ArrayAdapter<StateDTO> stateAdapter;
    long selectedCountryID;
    long selectedStateID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_form);

        RetrofitService retrofitService = new RetrofitService();
        VaibhavTradersAndroidAppApi vaibhavTradersAndroidAppApi = retrofitService.getRetrofit().create(VaibhavTradersAndroidAppApi.class);

        initializeMappings();
        fetchCountryData();
        fetchStateData();

        saveCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String customerCompanyName = companyName.getText().toString();
                String customerGstin = gstin.getText().toString();
                String customerContactPerson = contactPerson.getText().toString();
                String customerCustomerPhone = customerPhone.getText().toString();
                String customerCustomerEmail = customerEmail.getText().toString();
                String customerCustomerPan = customerPan.getText().toString();
                String customerCustomerAddLine1 = customerAddressLine1.getText().toString();
                String customerCustomerAddLine2 = customerAddressLine2.getText().toString();
                String customerCustomerLandmark = customerLandmark.getText().toString();
                String customerCustomerCity = customerCity.getText().toString();
                String customerCustomerPincode = customerPincode.getText().toString();
                String customerCustomerWebsite = customerWebsite.getText().toString();
                String customerCustomerNote = customerNote.getText().toString();
                // Getting id from spinners :
                String spinnerStateID = String.valueOf(selectedStateID);
                String spinnerCountryID = String.valueOf(selectedCountryID);

                Customer customer = new Customer();
                customer.setCompanyName(customerCompanyName);
                customer.setGstin(customerGstin);
                customer.setContactPerson(customerContactPerson);
                customer.setContactNo(customerCustomerPhone);
                customer.setEmail(customerCustomerEmail);
                customer.setPan(customerCustomerPan);
                customer.setAddressLine1(customerCustomerAddLine1);
                customer.setAddressLine2(customerCustomerAddLine2);
                customer.setLandmark(customerCustomerLandmark);
                customer.setCity(customerCustomerCity);
                customer.setPincode(customerCustomerPincode);
                customer.setWebsite(customerCustomerWebsite);
                customer.setNote(customerCustomerNote);

                State state = new State();
                Country country = new Country();

                state.setStateID(Long.valueOf(spinnerStateID));
                country.setCountryID(Long.valueOf(spinnerCountryID));

                customer.setState(state);
                customer.setCountry(country);

                vaibhavTradersAndroidAppApi.createCustomer(customer)
                        .enqueue(new Callback<Customer>() {
                            @Override
                            public void onResponse(Call<Customer> call, Response<Customer> response) {
                                Toast.makeText(CustomerForm.this, "Save successful!", Toast.LENGTH_SHORT).show();
                                Logger.getLogger(CustomerForm.class.getName()).log(Level.SEVERE, "Product Response : ", response);
                            }

                            @Override
                            public void onFailure(Call<Customer> call, Throwable t) {
                                Toast.makeText(CustomerForm.this, "Save Failed!", Toast.LENGTH_SHORT).show();
                                Logger.getLogger(CustomerForm.class.getName()).log(Level.SEVERE, "Save failed with : ", t);
                            }
                        });
            }
        });

        spinnerCountry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // Get the selected country ID
                CountryDTO selectedCountry = countryAdapter.getItem(position);
                selectedCountryID = selectedCountry.getCountryID();
                // Now you have the selected country ID to send to the server
            }
        });

        spinnerState.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // Get the selected state ID
                StateDTO selectedState = stateAdapter.getItem(position);
                selectedStateID = selectedState.getStateID();
                // Now you have the selected state ID to send to the server
            }
        });
    }

    private void fetchCountryData() {
        RetrofitService retrofitService = new RetrofitService();
        VaibhavTradersAndroidAppApi vaibhavTradersAndroidAppApi = retrofitService.getRetrofit().create(VaibhavTradersAndroidAppApi.class);
        Call<ResponseObject> listOfCountries = vaibhavTradersAndroidAppApi.findAllCountries();

        listOfCountries.enqueue(new Callback<ResponseObject>() {
            @Override
            public void onResponse(Call<ResponseObject> call, Response<ResponseObject> response) {
                if (response.isSuccessful()) {
                    ResponseObject responseObject = response.body();
                    countryList = responseObject.getCountryDTOList();
                    populateCountrySpinner(countryList);
                }
            }

            @Override
            public void onFailure(Call<ResponseObject> call, Throwable t) {
                // Handle failure
            }
        });
    }

    private void fetchStateData() {
        RetrofitService retrofitService = new RetrofitService();
        VaibhavTradersAndroidAppApi vaibhavTradersAndroidAppApi = retrofitService.getRetrofit().create(VaibhavTradersAndroidAppApi.class);
        Call<ResponseObject> listOfStates = vaibhavTradersAndroidAppApi.findAllStates();

        listOfStates.enqueue(new Callback<ResponseObject>() {
            @Override
            public void onResponse(Call<ResponseObject> call, Response<ResponseObject> response) {
                if (response.isSuccessful()) {
                    ResponseObject responseObject = response.body();
                    stateList = responseObject.getStateDTOList();
                    populateStateSpinner(stateList);
                }
            }

            @Override
            public void onFailure(Call<ResponseObject> call, Throwable t) {
                // Handle failure
            }
        });
    }

    private void populateCountrySpinner(List<CountryDTO> countryList) {
        if (countryList != null) {
            countryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countryList);
            countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerCountry.setAdapter(countryAdapter);
        }
    }

    private void populateStateSpinner(List<StateDTO> stateList) {
        if (stateList != null) {
            stateAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, stateList);
            stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerState.setAdapter(stateAdapter);
        }
    }



    private void initializeMappings() {
        companyName = findViewById(R.id.tet_company_name);
        gstin = findViewById(R.id.tet_gstin);
        contactPerson = findViewById(R.id.tet_contact_person);
        customerPhone = findViewById(R.id.tet_phone);
        customerEmail = findViewById(R.id.tet_email);
        customerPan = findViewById(R.id.tet_pan);
        customerAddressLine1 = findViewById(R.id.tet_address_line_1);
        customerAddressLine2 = findViewById(R.id.tet_address_line_2);
        customerLandmark = findViewById(R.id.tet_landmark);
        customerCity = findViewById(R.id.tet_city);
        customerPincode = findViewById(R.id.tet_pincode);
        customerWebsite = findViewById(R.id.tet_website);
        customerNote = findViewById(R.id.tet_note);
        spinnerState = findViewById(R.id.spinner_state);
        spinnerCountry = findViewById(R.id.spinner_country);
        saveCustomer = findViewById(R.id.btn_save_customer);
    }
}