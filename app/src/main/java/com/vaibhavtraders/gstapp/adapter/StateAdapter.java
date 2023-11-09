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

import com.vaibhavtraders.gstapp.R;
import com.vaibhavtraders.gstapp.api.VaibhavTradersAndroidAppApi;
import com.vaibhavtraders.gstapp.dto.StateDTO;
import com.vaibhavtraders.gstapp.model.State;
import com.vaibhavtraders.gstapp.retrofit.RetrofitService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        StateDTO stateDTO = stateList.get(position);
        holder.stateName.setText(stateDTO.getStateName());
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                showDeleteConfirmationDialog(stateDTO);
                return true;
            }
        });
    }

    private void showDeleteConfirmationDialog(StateDTO stateDTO) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Delete State Entry");
        builder.setMessage("Do you want to delete this state entry?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                State state = new State();
                state.setStateID(stateDTO.getStateID());
                state.setStateName(stateDTO.getStateName());
                RetrofitService retrofitService = new RetrofitService();
                VaibhavTradersAndroidAppApi vaibhavTradersAndroidAppApi = retrofitService.getRetrofit().create(VaibhavTradersAndroidAppApi.class);
                vaibhavTradersAndroidAppApi.deleteState(state)
                        .enqueue(new Callback<State>() {
                            @Override
                            public void onResponse(Call<State> call, Response<State> response) {
                                Toast.makeText(context, "Delete Successful.", Toast.LENGTH_SHORT).show();
                                int position = stateList.indexOf(stateDTO);
                                if (position != -1){
                                    stateList.remove(position);
                                    notifyItemRemoved(position);
                                }
                            }

                            @Override
                            public void onFailure(Call<State> call, Throwable t) {
                                Toast.makeText(context, "Delete Failed!", Toast.LENGTH_SHORT).show();
                                Logger.getLogger(context.getClass().getName()).log(Level.SEVERE, "Error occured in showDeleteConfirmationDialog()", t);
                            }
                        });
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    @Override
    public int getItemCount() {
        if(stateList != null) {
            return stateList.size();
        } else {
            return 0;
        }
    }
}
