package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.project.Adabters.CatagorAdabter;
import com.example.project.Adabters.itemAdapter;
import com.example.project.databinding.ActivityMainBinding;
import com.example.project.models.Catagory;
import com.example.project.models.ItemsModel;

import java.util.ArrayList;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
public class MainActivity extends AppCompatActivity {
    Intent intent;
    private ActivityMainBinding binding;
    private ArrayList<Catagory> categories;
    private ArrayList<ItemsModel> items1;
    LottieAnimationView hilottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        MeowBottomNavigation bottomNavigation=findViewById(R.id.bottomNavigation);
        bottomNavigation.add(new MeowBottomNavigation.Model(1 , R.drawable.home));
        bottomNavigation.add(new MeowBottomNavigation.Model(2 , R.drawable.love));
        bottomNavigation.add(new MeowBottomNavigation.Model(3 , R.drawable.add));
        bottomNavigation.add(new MeowBottomNavigation.Model(4 , R.drawable.cart));
        bottomNavigation.add(new MeowBottomNavigation.Model(5 , R.drawable.profile));
        initializeUI();

        categoriesSetUp();
        itemsSetUp();
        bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {

                switch (model.getId()) {
                    case 1:
                        intent = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;

                    case 2:
                        intent = new Intent(MainActivity.this, CheckoutStepOne.class);
                        startActivity(intent);
                        break;

                    case 3:
                        intent = new Intent(MainActivity.this, CheckoutStepTwo.class);
                        startActivity(intent);
                        break;

                    case 4:
                        intent = new Intent(MainActivity.this, CheckoutStepFour.class);
                        startActivity(intent);
                        break;

                    case 5:
                        Intent intent = new Intent(MainActivity.this, CheckoutStepThree.class);
                        startActivity(intent);
                        break;
                }
                return null;

            }
        });

        bottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                // YOUR CODES
                return null;
            }
        });
        hilottie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               hilottie.playAnimation();
            }
        });



    }

    private void initializeUI() {
        TextView textview3 = findViewById(R.id.textview3);
//        TextView home = findViewById(R.id.home);
//        ImageView userimg = findViewById(R.id.userimg);

        hilottie = findViewById(R.id.hilottie);
        hilottie.animate().translationX(0).setDuration(5000).setStartDelay(0);

//        hilottie.playAnimation();


    }

    private void categoriesSetUp() {// this is for catagories adding
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.categoryList.setLayoutManager(linearLayoutManager);

        categories = new ArrayList<>();
        categories.add(new Catagory("Sofa", R.drawable.sofa));
        categories.add(new Catagory("Cabinets", R.drawable.cabinet));
        categories.add(new Catagory("Oven",  R.drawable.oven ));
        categories.add(new Catagory("Iron Beds",  R.drawable.ironbed));
        categories.add(new Catagory("Mattresses",  R.drawable.matress));
        categories.add(new Catagory("Fridge", R.drawable.fridgee));
        categories.add(new Catagory("Electrical Devices",  R.drawable.electrical));
        categories.add(new Catagory("Desks",  R.drawable.desk));


        CatagorAdabter adapter = new CatagorAdabter(this, categories);
        binding.categoryList.setAdapter(adapter);
    }

    private void itemsSetUp() {// this is for catagories adding
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.itemrec.setLayoutManager(linearLayoutManager);

        items1 = new ArrayList<>();
        items1.add(new ItemsModel("Sofa", R.drawable.sofa));
        items1.add(new ItemsModel("Cabinets", R.drawable.cabinet));
        items1.add(new ItemsModel("Oven",  R.drawable.oven ));
        items1.add(new ItemsModel("Iron Beds",  R.drawable.ironbed));
        items1.add(new ItemsModel("Mattresses",  R.drawable.matress));
        items1.add(new ItemsModel("Fridge", R.drawable.fridgee));
        items1.add(new ItemsModel("Electrical Devices",  R.drawable.electrical));
        items1.add(new ItemsModel("Desks",  R.drawable.desk));


        itemAdapter adapter = new itemAdapter(this, items1);
        binding.itemrec.setAdapter(adapter);
    }


}