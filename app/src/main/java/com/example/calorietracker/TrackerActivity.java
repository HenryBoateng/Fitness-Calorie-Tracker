package com.example.calorietracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import okhttp3.OkHttpClient;

public class TrackerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);

        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.tracker);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.menu:
                        startActivity(new Intent(getApplicationContext()
                                ,MenuActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext()
                                ,ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.tracker:
                        startActivity(new Intent(getApplicationContext()
                                ,TrackerActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.fitness:
                        startActivity(new Intent(getApplicationContext()
                                ,FitnessActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });


        /* Stetho */
        Stetho.initializeWithDefaults(this);

        new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();




        /*Database*/
        DBAdapter db = new DBAdapter(this);
        db.open();

        // setup for food
        //count rows in food
        int numberRows = db.count("food");

        if(numberRows < 1) {
            //run setup

            db.insert("food",
                    "food_id, food_name, food_manufactor_name, food_serving_size, food_serving_measurement, food_energy_calculated",
                    "NULL, 'Egg, whole, raw, fresh', 'Prior', '243.0', 'g', '347'");

            db.insert("food",
                    "food_id, food_name, food_manufactor_name, food_serving_size, food_serving_measurement, food_energy_calculated",
                    "NULL, 'Stake', 'Prior', '243.0', 'g', '232'");
        }

        /*reference food_id, food_name, food_manufactor_name, food_serving_size, food_serving_measurement, food_serving_name_number, food_serving_name_word, food_energy, food_proteins, food_carbohydrates, food_fat, food_energy_calculated, food_proteins_calculated, food_carbohydrates_calculated, food_fat_calculated, food_user_id, food_barcode, food_category_id, food_thumb, food_image_a, food_image_b, food_image_c, food_notes ",*/


               db.close();

    }
}
