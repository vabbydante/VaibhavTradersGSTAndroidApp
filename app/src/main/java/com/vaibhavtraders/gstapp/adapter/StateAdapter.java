package com.vaibhavtraders.gstapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vaibhavtraders.gstapp.R;
import com.vaibhavtraders.gstapp.dto.StateDTO;

import java.util.List;

public class StateAdapter extends RecyclerView.Adapter<StateHolder>{
    private List<StateDTO> stateList;
    private Context context;

    public StateAdapter(List<StateDTO> stateList, Context context) {
        this.stateList = stateList;
        this.context = context;
    }

    @NonNull
    @Override
    public StateHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_state_item, parent, false);
        return new StateHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StateHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
