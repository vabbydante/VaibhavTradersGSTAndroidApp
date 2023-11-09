package com.vaibhavtraders.gstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.vaibhavtraders.gstapp.api.VaibhavTradersAndroidAppApi;
import com.vaibhavtraders.gstapp.model.Country;
import com.vaibhavtraders.gstapp.model.State;
import com.vaibhavtraders.gstapp.retrofit.RetrofitService;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StateForm extends AppCompatActivity {
    private EditText stateEditText;
    private Button saveState;
    private ProgressBar stateSaveProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_form);

        initializeComponents();
    }

    private void initializeComponents() {
        stateEditText = findViewById(R.id.et_state_name);
        saveState = findViewById(R.id.btn_save_state);
        stateSaveProgressBar = findViewById(R.id.progressBarSaveState);
        stateSaveProgressBar.setVisibility(View.GONE);

        RetrofitService retrofitService = new RetrofitService();
        VaibhavTradersAndroidAppApi vaibhavTradersAndroidAppApi = retrofitService.getRetrofit().create(VaibhavTradersAndroidAppApi.class);

        saveState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stateName = String.valueOf(stateEditText.getText());

                State state = new State();
                state.setStateName(stateName);
                saveState.setText("");
                stateSaveProgressBar.setVisibility(View.VISIBLE);
                vaibhavTradersAndroidAppApi.createState(state)
                        .enqueue(new Callback<State>() {
                            @Override
                            public void onResponse(Call<State> call, Response<State> response) {
                                Toast.makeText(StateForm.this, "Save Successful!", Toast.LENGTH_SHORT).show();
                                saveState.setText("Save Country");
                                stateSaveProgressBar.setVisibility(View.GONE);
                            }

                            @Override
                            public void onFailure(Call<State> call, Throwable t) {
                                Toast.makeText(StateForm.this, "Save Failed!", Toast.LENGTH_SHORT).show();
                                Toast.makeText(StateForm.this, t.toString(), Toast.LENGTH_LONG).show();
                                saveState.setText("Save Country");
                                stateSaveProgressBar.setVisibility(View.GONE);
                                Logger.getLogger(CountryForm.class.getName()).log(Level.SEVERE, "Error occured!", t);
                            }
                        });
            }
        });
    }
}