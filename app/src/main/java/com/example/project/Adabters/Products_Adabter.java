package com.example.project.Adabters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;
import com.example.project.databinding.ItemRowBinding;
import com.example.project.databinding.ProductBinding;
import com.example.project.models.Model_Product;

import java.util.List;

public class Products_Adabter extends RecyclerView.Adapter<Products_Adabter.Product_holder>{

    Context context;
    List<Model_Product> Products;

    public Products_Adabter(Context context, List<Model_Product> products) {
        this.context = context;
        Products = products;
    }

    @NonNull
    @Override
    public Product_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Products_Adabter.Product_holder(LayoutInflater.from(context).inflate(R.layout.product, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Product_holder holder, int position) {
        holder.binding.productImage.setImageResource(Products.get(position).getImage());
        holder.binding.productName.setText(Products.get(position).getName());
        holder.binding.productPrice.setText(Products.get(position).getPrice());
        holder.binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        holder.binding.love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return Products.size();
    }

    public static class Product_holder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView nameView;
        TextView priceView;
        Button addView;
        Button loveView;

        ProductBinding binding;

        public Product_holder (@NonNull View itemView) {
            super(itemView);
            binding = ProductBinding.bind(itemView);
            imageView = itemView.findViewById(R.id.product_image);
            nameView = itemView.findViewById(R.id.product_name);
            priceView = itemView.findViewById(R.id.product_price);
            addView = itemView.findViewById(R.id.add_btn);
            loveView = itemView.findViewById(R.id.love);
        }

        public ImageView getImageView() {
            return imageView;
        }

        public void setImageView(ImageView imageView) {
            this.imageView = imageView;
        }

        public TextView getNameView() {
            return nameView;
        }


        public void setNameView(TextView nameView) {
            this.nameView = nameView;
        }

        public TextView getPriceView() {
            return priceView;
        }

        public void setPriceView(TextView priceView) {
            this.priceView = priceView;
        }

        public Button getAddView() {
            return addView;
        }

        public void setAddView(Button addView) {
            this.addView = addView;
        }

        public Button getLoveView() {
            return loveView;
        }

        public void setLoveView(Button loveView) {
            this.loveView = loveView;
        }
    }
}

