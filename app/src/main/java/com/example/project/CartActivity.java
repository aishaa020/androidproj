package com.example.project;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class CartActivity extends AppCompatActivity {

//    ArrayList<ModelCart> cartmodels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        RecyclerView cart_view = findViewById(R.id.cart_view);
    }
//    private void setUpcartModels(){
//
//    }
}