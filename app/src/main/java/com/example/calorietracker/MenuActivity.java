package com.example.calorietracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv_result;
    private Button bttn;
    private Bundle savedInstanceState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        et1 = (EditText) findViewById(R.id.et_weight);
        et2 = (EditText) findViewById(R.id.et_height);
        tv_result = (TextView) findViewById(R.id.tv_result);
        bttn = (Button) findViewById(R.id.button);
        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bmi();
            }
        });



        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.menu);
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
    }
    private void bmi () {
        float a,b,c;
        a=Float.parseFloat(et2.getText().toString())/100;
        b=Float.parseFloat(et1.getText().toString());
        c = b / (a * a);
        tv_result.setText(""+ c);

        if(c <= 18.8) {
            Toast.makeText(getApplicationContext(),"You are underweight", Toast.LENGTH_SHORT).show();
        }
        if((c >= 18.8) && (c < 25)) {
            Toast.makeText(getApplicationContext(),"You are Normal", Toast.LENGTH_SHORT).show();
        }
        if (c >= 25) {
            Toast.makeText(getApplicationContext(),"You are overweight", Toast.LENGTH_SHORT).show();
        }

    }

    }
