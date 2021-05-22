package com.example.calorietracker;

import android.content.Context;

public class DBSetupInsert {

    private final Context context;
public  DBSetupInsert (Context ctx){
            this.context = ctx;


        }

    public void setupInsetToFood(String values) {

        DBAdapter db = new DBAdapter(context);
        db.open();
        db.insert("food",
                "food_id, food_name, food_manufactor_name, food_serving_size, food_serving_measurement, food_serving_name_number, food_serving_name_word, food_energy, food_proteins, food_carbohydrates, food_fat, food_energy_calculated, food_proteins_calculated, food_carbohydrates_calculated, food_fat_calculated, food_user_id, food_barcode, food_category_id, food_thumb, food_image_a, food_image_b, food_image_c, food_notes ",
                values);
         db.close();
        }
    }


  /*



   //variables
    private final Context context;

    // public class ---------------------------------------------------
    public DBSetupInsert(Context ctx) {
    this.context = ctx;
    }





    // Setup  insert food --------------------------------------------------
    // to insert food to food table
    public void setupInsetToFood(String values) {
        DBAdapter db = new DBAdapter(context);
        db.open();

        db.insert("food",
                "food_id, food_name, food_manufactor_name, food_serving_size, food_serving_measurement, food_serving_name_number, food_serving_name_word, food_energy, food_proteins, food_carbohydrates, food_fat, food_energy_calculated, food_proteins_calculated, food_carbohydrates_calculated, food_fat_calculated, food_user_id, food_barcode, food_category_id, food_thumb, food_image_a, food_image_b, food_image_c, food_notes ",
                values);
        db.close();
    }

    // Insert all food into food database ---------------------------------------
    public void insertAllFood() {
        setupInsetToFood("'Null', 'pancake', 'null', '1 pancake', 'gram', '1', 'pcakke', '73.7', '7.9', '57.3', '73.7','null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null'");
    }

   }
    */