package com.vaibhavtraders.gstapp.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vaibhavtraders.gstapp.R;

public class StateHolder extends RecyclerView.ViewHolder {
    TextView stateName;
    public StateHolder(@NonNull View itemView) {
        super(itemView);
        stateName = itemView.findViewById(R.id.state_list_item_name);
    }
}
