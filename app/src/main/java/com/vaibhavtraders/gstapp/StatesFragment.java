package com.vaibhavtraders.gstapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vaibhavtraders.gstapp.adapter.StateAdapter;
import com.vaibhavtraders.gstapp.api.VaibhavTradersAndroidAppApi;
import com.vaibhavtraders.gstapp.dto.StateDTO;
import com.vaibhavtraders.gstapp.response.ResponseObject;
import com.vaibhavtraders.gstapp.retrofit.RetrofitService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StatesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StatesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;

    public StatesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StatesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StatesFragment newInstance(String param1, String param2) {
        StatesFragment fragment = new StatesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_states, container, false);
        recyclerView = view.findViewById(R.id.state_list_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        FloatingActionButton floatingActionButton = view.findViewById(R.id.add_states_fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(requireContext(), StateForm.class));
            }
        });

        loadStates();
        return view;
    }

    private void loadStates() {
        RetrofitService retrofitService = new RetrofitService();
        VaibhavTradersAndroidAppApi vaibhavTradersAndroidAppApi = retrofitService.getRetrofit().create(VaibhavTradersAndroidAppApi.class);
        vaibhavTradersAndroidAppApi.findAllStates()
                .enqueue(new Callback<ResponseObject>() {
                    @Override
                    public void onResponse(Call<ResponseObject> call, Response<ResponseObject> response) {
                        if(response.isSuccessful()) {
                            ResponseObject responseObject = response.body();
                            if(responseObject != null) {
                                List<StateDTO> stateList = responseObject.getStateDTOList();

                                populateListView(stateList);
                            } else {
                                Toast.makeText(requireContext(), "Error while fetching States list.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseObject> call, Throwable t) {
                        Toast.makeText(requireContext(), "Error while fetching States list.", Toast.LENGTH_SHORT).show();
                        Logger.getLogger(requireContext().getClass().getName()).log(Level.SEVERE, "Error in loadStates()", t);
                    }
                });
    }

    private void populateListView(List<StateDTO> stateList) {
        StateAdapter stateAdapter = new StateAdapter(stateList, requireContext());
        recyclerView.setAdapter(stateAdapter);
    }

    @Override
    public void onResume() {
        loadStates();
        super.onResume();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}