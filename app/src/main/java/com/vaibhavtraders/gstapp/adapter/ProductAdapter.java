package com.vaibhavtraders.gstapp.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.vaibhavtraders.gstapp.R;
import com.vaibhavtraders.gstapp.api.VaibhavTradersAndroidAppApi;
import com.vaibhavtraders.gstapp.dto.ProductDTO;
import com.vaibhavtraders.gstapp.model.Product;
import com.vaibhavtraders.gstapp.retrofit.RetrofitService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {
    private List<ProductDTO> productList;
    private Context context;

    public ProductAdapter(List<ProductDTO> productList, Context context) {
        this.productList = productList;
        this.context = context;
    }


    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_product_item, parent, false);
        return new ProductHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        ProductDTO productDTO = productList.get(position);
        holder.productName.setText(productDTO.getName());
        holder.hsnCode.setText(productDTO.getHsnHacCode());
        if (!("".equals(String.valueOf(productDTO.getProductType()))) && productDTO.getProductType() != null) {
            holder.productType.setText(String.valueOf(productDTO.getProductType()));
        } else {
            holder.productType.setText("N/A");
        }
        holder.sellPrice.setText(String.valueOf(productDTO.getSellPrice()));
        holder.sellPriceInclTax.setText(String.valueOf(productDTO.getSellPriceIncludingTax()));
        holder.purchasePrice.setText(String.valueOf(productDTO.getSellPrice()));
        holder.purchasePriceInclTax.setText(String.valueOf(productDTO.getPurchasePriceIncludingTax()));
        holder.gstPercentage.setText(String.valueOf(productDTO.getGstPercentage()));
        if (!("".equals(String.valueOf(productDTO.getCessPercentage()))) && productDTO.getCessPercentage() != null) {
            holder.cessPercentage.setText(String.valueOf(productDTO.getCessPercentage()));
        } else {
            holder.cessPercentage.setText("N/A");
        }
        if (!("".equals(String.valueOf(productDTO.getCessAmount()))) && productDTO.getCessAmount() != null) {
            holder.cessAmount.setText(String.valueOf(productDTO.getCessAmount()));
        } else {
            holder.cessAmount.setText("N/A");
        }

        boolean isExpandable = productList.get(position).isExpandable();
        holder.expandableRelativeLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);

        holder.linearLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                showDeleteConfirmationDialog(productDTO);
                return true;
            }
        });
    }

    private void showDeleteConfirmationDialog(ProductDTO productDTO) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Delete Product");
        builder.setMessage("Do you want to delete this Product Entry?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Product product = new Product();
                product.setProductID(productDTO.getProductID());
                RetrofitService retrofitService = new RetrofitService();
                VaibhavTradersAndroidAppApi vaibhavTradersAndroidAppApi = retrofitService.getRetrofit().create(VaibhavTradersAndroidAppApi.class);
                vaibhavTradersAndroidAppApi.deleteProduct(product)
                        .enqueue(new Callback<Product>() {
                            @Override
                            public void onResponse(Call<Product> call, Response<Product> response) {
                                Toast.makeText(context, "Delete Successful!", Toast.LENGTH_SHORT).show();
                                int position = productList.indexOf(productDTO);
                                if(position != -1) {
                                    productList.remove(position);
                                    notifyItemRemoved(position);
                                }
                            }

                            @Override
                            public void onFailure(Call<Product> call, Throwable t) {
                                Toast.makeText(context, "Delete Failed!", Toast.LENGTH_SHORT).show();
                                Logger.getLogger(context.getClass().getName()).log(Level.SEVERE, "Error occurred in showDeleteConfirmationDialog()", t);
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
        return productList != null ? productList.size() : 0;
    }

    public class ProductHolder extends RecyclerView.ViewHolder {
        TextView productName;
        TextView hsnCode;
        TextView productType;
        TextView sellPrice;
        TextView sellPriceInclTax;
        TextView purchasePrice;
        TextView purchasePriceInclTax;
        TextView gstPercentage;
        TextView cessPercentage;
        TextView cessAmount;
        LinearLayout linearLayout;
        RelativeLayout expandableRelativeLayout;
        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.tv_product_name);
            hsnCode = itemView.findViewById(R.id.tv_product_hsn_code);
            productType = itemView.findViewById(R.id.tv_product_type);
            sellPrice = itemView.findViewById(R.id.tv_product_sell_price);
            sellPriceInclTax = itemView.findViewById(R.id.tv_product_sell_price_incl_tax);
            purchasePrice = itemView.findViewById(R.id.tv_product_purchase_price);
            purchasePriceInclTax = itemView.findViewById(R.id.tv_product_purchase_price_incl_tax);
            gstPercentage = itemView.findViewById(R.id.tv_product_gst_percentage);
            cessPercentage = itemView.findViewById(R.id.tv_product_cess_percentage);
            cessAmount = itemView.findViewById(R.id.tv_product_cess_amount);

            linearLayout = itemView.findViewById(R.id.linear_layout_product);
            expandableRelativeLayout = itemView.findViewById(R.id.expandable_relative_layout);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ProductDTO productDTO = productList.get(getAdapterPosition());
                    productDTO.setExpandable(!productDTO.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
