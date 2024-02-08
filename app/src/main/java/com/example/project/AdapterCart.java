package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
      holder.cartname.setText(modelCarts.get(position).getItemname());
      holder.cartprice.setText(modelCarts.get(position).getItemprice());
      holder.cartimage.setImageResource(modelCarts.get(position).getItemimage());
      holder.qunatitytxt.setText(modelCarts.get(position).getItemquantity());
    }

    @Override
    public int getItemCount() {
        return modelCarts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView cartimage, additem, removeitem, deleteitem;
        TextView cartname, cartprice;
        EditText qunatitytxt;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            cartimage = itemView.findViewById(R.id.imageView);
            removeitem = itemView.findViewById(R.id.itemdel);
            additem = itemView.findViewById(R.id.increment);
            deleteitem = itemView.findViewById(R.id.itemdel);
            cartname = itemView.findViewById(R.id.textView2);
            cartprice = itemView.findViewById(R.id.textView3);
            qunatitytxt = itemView.findViewById(R.id.display);

        }
    }
}
