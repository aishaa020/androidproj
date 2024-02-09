package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
public class MainActivity extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MeowBottomNavigation bottomNavigation=findViewById(R.id.bottomNavigation);
        bottomNavigation.add(new MeowBottomNavigation.Model(1 , R.drawable.home));
        bottomNavigation.add(new MeowBottomNavigation.Model(2 , R.drawable.love));
        bottomNavigation.add(new MeowBottomNavigation.Model(3 , R.drawable.add));
        bottomNavigation.add(new MeowBottomNavigation.Model(4 , R.drawable.cart));
        bottomNavigation.add(new MeowBottomNavigation.Model(5 , R.drawable.profile));
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
    }
//    private void setUpcartModels(){
//
//    }
}