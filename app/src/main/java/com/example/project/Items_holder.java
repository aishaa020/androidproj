package com.example.project;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

public class Items_holder extends RecyclerView.ViewHolder{

    ImageView itemimg1;
    TextView txtprice1;

    Button btn_atc1;

    LottieAnimationView likelottie1;



    public Items_holder(@NonNull View itemView) {
        super(itemView);

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
