package com.example.project.Adabters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.Items_holder;
import com.example.project.R;
import com.example.project.models.ItemsModel;

import java.util.List;

public class itemAdapter extends RecyclerView.Adapter<Items_holder> {

    Context context;
    List<ItemsModel> items;

    public itemAdapter(Context context, List<ItemsModel> items) {
        this.context = context;
        this.items = items;
    }


    @NonNull
    @Override
    public Items_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Items_holder(LayoutInflater.from(context).inflate(R.layout.item_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Items_holder holder, int position) {
        holder.getItemimg1().setImageResource(items.get(position).getImg());
        holder.getTxtprice1().setText(items.get(position).getPrice());
//        holder.getBtn_atc1().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //intent
//
//            }
//        });
//        holder.getLikelottie1().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                holder.getLikelottie1().playAnimation();
//                //toast
//            }
//        });

//        holder.getItemimg1().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //intent
//            }
//        });




    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
