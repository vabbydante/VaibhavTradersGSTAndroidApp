package com.vaibhavtraders.gstapp.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vaibhavtraders.gstapp.R;

public class CountryHolder extends RecyclerView.ViewHolder {

    TextView countryName;

    public CountryHolder(@NonNull View itemView) {
        super(itemView);
        countryName = itemView.findViewById(R.id.country_list_item_name);
    }
}
