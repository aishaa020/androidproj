package com.example.project.Adabters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;
import com.example.project.databinding.CartRowBinding;
import com.example.project.databinding.ItemRowBinding;
import com.example.project.models.ModelCart;

import java.util.List;

public class AdapterCart extends RecyclerView.Adapter<AdapterCart.ViewHolder>{

    Context context;
    List<ModelCart> modelCarts;

    public AdapterCart(Context context, List<ModelCart> modelCarts){
        this.context = context;
        this.modelCarts = modelCarts;
    }


    @NonNull
    @Override
    public AdapterCart.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cart_row, parent, false );
        return new AdapterCart.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCart.ViewHolder holder, int position) {
      holder.binding.imageView.setImageResource(modelCarts.get(position).getItemimage());
      holder.binding.textView2.setText(modelCarts.get(position).getItemname());
      holder.binding.textView3.setText(modelCarts.get(position).getItemprice());
      holder.binding.decrement.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              //increment quantity
          }
      });
      holder.binding.display.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              //display quantity
          }
      });
      holder.binding.decrement.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              //decrement the quantity
          }
      });
     holder.binding.itemdel.setImageResource(modelCarts.get(position).getItemimage());
     holder.binding.itemdel.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

         }
     });
    }

    @Override
    public int getItemCount() {
        return modelCarts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView cartimage, additem, removeitem, deleteitem;
        TextView cartname, cartprice;
        EditText qunatitytxt;

        Button check1btn;

        CartRowBinding binding;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            binding = CartRowBinding.bind(itemView);
            cartimage = itemView.findViewById(R.id.imageView);
            removeitem = itemView.findViewById(R.id.itemdel);
            additem = itemView.findViewById(R.id.increment);
            deleteitem = itemView.findViewById(R.id.itemdel);
            cartname = itemView.findViewById(R.id.textView2);
            cartprice = itemView.findViewById(R.id.textView3);
            qunatitytxt = itemView.findViewById(R.id.display);
            check1btn = itemView.findViewById(R.id.check1btn);

        }


    }
}
