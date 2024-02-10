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

import com.airbnb.lottie.LottieAnimationView;

import com.example.project.R;
import com.example.project.databinding.ItemRowBinding;
import com.example.project.models.ItemsModel;

import java.util.List;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.Items_holder> {

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
        holder.binding.itemimg1.setImageResource(items.get(position).getImg());
        holder.binding.txtprice1.setText(items.get(position).getPrice());
        holder.binding.btnAtc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent

            }
        });
        holder.binding.likelottie1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //holder.getLikelottie1().playAnimation();
                //toast
            }
        });

//        holder.getItemimg1().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //intent
//            }
//        });




    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class Items_holder extends RecyclerView.ViewHolder{

        ImageView itemimg1;
        TextView txtprice1;

        Button btn_atc1;

        LottieAnimationView likelottie1;


        ItemRowBinding binding;
        public Items_holder(@NonNull View itemView) {
            super(itemView);
            binding = ItemRowBinding.bind(itemView);
            itemimg1 = itemView.findViewById(R.id.itemimg1);
            txtprice1 = itemView.findViewById(R.id.txtprice1);
            btn_atc1 = itemView.findViewById(R.id.btn_atc1);
            likelottie1 = itemView.findViewById(R.id.likelottie1);


        }

        public ImageView getItemimg1() {
            return itemimg1;
        }

        public void setItemimg1(ImageView itemimg1) {
            this.itemimg1 = itemimg1;
        }



        public TextView getTxtprice1() {
            return txtprice1;
        }

        public void setTxtprice1(TextView txtprice1) {
            this.txtprice1 = txtprice1;
        }


        public Button getBtn_atc1() {
            return btn_atc1;
        }

        public void setBtn_atc1(Button btn_atc1) {
            this.btn_atc1 = btn_atc1;
        }

        public LottieAnimationView getLikelottie1() {
            return likelottie1;
        }

        public void setLikelottie1(LottieAnimationView likelottie1) {
            this.likelottie1 = likelottie1;
        }
    }

}
