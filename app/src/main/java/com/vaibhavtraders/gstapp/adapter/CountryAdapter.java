package com.vaibhavtraders.gstapp.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.vaibhavtraders.gstapp.CountriesFragment;
import com.vaibhavtraders.gstapp.R;
import com.vaibhavtraders.gstapp.api.VaibhavTradersAndroidAppApi;
import com.vaibhavtraders.gstapp.dto.CountryDTO;
import com.vaibhavtraders.gstapp.model.Country;
import com.vaibhavtraders.gstapp.retrofit.RetrofitService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryAdapter extends RecyclerView.Adapter<CountryHolder> {
    private List<CountryDTO> countryList;
    private Context context;

    public CountryAdapter(List<CountryDTO> countryList, Context context){
        this.countryList = countryList;
        this.context = context;
    }

    @NonNull
    @Override
    public CountryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_country_item, parent, false);
        return new CountryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryHolder holder, int position) {
        CountryDTO countryDTO = countryList.get(position);
        holder.countryName.setText(countryDTO.getCountryName());
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                showDeleteConfirmationDialog(countryDTO);
                return true;
            }
        });
    }

    private void showDeleteConfirmationDialog(CountryDTO countryDTO) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Delete Country Entry");
        builder.setMessage("Do you want to delete this country entry?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Delete the country entry here (you need to implement this)
                Country country = new Country();
                country.setCountryID(countryDTO.getCountryID());
                country.setCountryName(countryDTO.getCountryName());
                RetrofitService retrofitService = new RetrofitService();
                VaibhavTradersAndroidAppApi vaibhavTradersAndroidAppApi = retrofitService.getRetrofit().create(VaibhavTradersAndroidAppApi.class);
                vaibhavTradersAndroidAppApi.deleteCountry(country)
                        .enqueue(new Callback<Country>() {
                            @Override
                            public void onResponse(Call<Country> call, Response<Country> response) {
                                Toast.makeText(context, "Delete Successful!", Toast.LENGTH_SHORT).show();
                                // After successful deletion, remove the item from the list and refresh the RecyclerView
                                int position = countryList.indexOf(countryDTO);
                                if (position != -1) {
                                    countryList.remove(position);
                                    notifyItemRemoved(position);
                                }
                            }

                            @Override
                            public void onFailure(Call<Country> call, Throwable t) {
                                Toast.makeText(context, "Delete Failed!", Toast.LENGTH_SHORT).show();
                                Logger.getLogger(context.getClass().getName()).log(Level.SEVERE, "Error occured in showDeleteConfirmationDialog()", t);
                            }
                        });
                // You can use a listener or callback to communicate with the fragment or activity
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); // Dismiss the dialog if the user selects "No"
            }
        });
        builder.create().show();
    }

    @Override
    public int getItemCount() {
        if (countryList != null) {
            return countryList.size();
        } else {
            return 0; // Return 0 when the list is null or empty
        }
    }
}
