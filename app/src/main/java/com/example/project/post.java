package com.example.project;

import static android.widget.Toast.LENGTH_LONG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class post extends AppCompatActivity {

    ImageView display_image1;
    EditText Product_name_pv1, quntity1,  Price1, product_status1;
    TextView description1;
    Spinner catagory1;

    Button postt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        display_image1 = findViewById(R.id.display_image1);
        Product_name_pv1 = findViewById(R.id.Product_name_pv1);
        quntity1 = findViewById(R.id.quntity1);
        Price1 = findViewById(R.id.Price1);
        product_status1 = findViewById(R.id.product_status1);
        description1 = findViewById(R.id.description1);
        catagory1 = findViewById(R.id.catagory1);
        postt1 = findViewById(R.id.postt1);


        // Define values and corresponding names
        List<String> values = new ArrayList<>();
        values.add("Select");
        values.add("Sofa");
        values.add("Cabinets");
        values.add("Ovens");
        values.add("Iron Beds");
        values.add("Mattresses");
        values.add("Fridges");
        values.add("Electrical Devices");
        values.add("Desks");



        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, values);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        catagory1.setAdapter(adapter);





        postt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int position = catagory1.getSelectedItemPosition();
                boolean b = catagory1.isSelected();


                if(!b){
                    Toast.makeText(post.this, "Please Select a Category", Toast.LENGTH_SHORT).show();
                }else{
                    if(Product_name_pv1.getText().equals(null)){
                        Toast.makeText(post.this, "Please Enter a Product Name", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        if(quntity1.getText().equals(null)){
                            Toast.makeText(post.this, "Please Enter a Quantity", Toast.LENGTH_SHORT).show();
                        }else{
                            if(Price1.getText().equals(null)){
                                Toast.makeText(post.this, "Please Enter a Price", Toast.LENGTH_SHORT).show();
                            }else{
                                if(product_status1.getText().equals(null)){
                                    Toast.makeText(post.this, "Please Enter a Status", Toast.LENGTH_SHORT).show();
                                }else{
//                                    if(ImageView){
//
//                                    }


                                }
                            }
                        }
                    }

                }


            }
        });

    }



}