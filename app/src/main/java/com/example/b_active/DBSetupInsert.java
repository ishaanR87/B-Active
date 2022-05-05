package com.example.b_active;

import android.content.Context;
import android.database.sqlite.SQLiteException;

public class DBSetupInsert {

    /* Variables */
    private final Context context;

    /* Public Class ------------------------------------------------------ */
    public DBSetupInsert(Context ctx) {
        this.context = ctx;
    }


    /* Setup Insert To Categories ----------------------------------------- */
    // To insert to category table
    public void setupInsertToCategories(String values) {
        try {
            DBAdapter db = new DBAdapter(context);
            db.open();
            db.insert("categories",
                    "_id, category_name, category_parent_id, category_icon, category_note",
                    values);
            db.close();
        } catch (SQLiteException e) {
            // Toast.makeText(context, "Error; Could not insert categories.", Toast.LENGTH_SHORT).show();
        }
    }

    public void insertAllCategories() {
        setupInsertToCategories("NULL, 'Bread', '0', '', NULL");
        setupInsertToCategories("NULL, 'Bread', '1', '', NULL");
        setupInsertToCategories("NULL, 'Cereals', '1', '', NULL");
        setupInsertToCategories("NULL, 'Frozen bread and rolls', '1', '', NULL");
        setupInsertToCategories("NULL, 'Crispbread', '1', '', NULL");

        // Parent id: 6
        setupInsertToCategories("NULL, 'Dessert and baking', '0', '', NULL");
        setupInsertToCategories("NULL, 'Baking', '6', '', NULL");
        setupInsertToCategories("NULL, 'Biscuit', '6', '', NULL");


        setupInsertToCategories("NULL, 'Drinks', '0', '', NULL");
        setupInsertToCategories("NULL, 'Soda', '9', '', NULL");


        setupInsertToCategories("NULL, 'Fruit and vegetables', '0', '', NULL");
        setupInsertToCategories("NULL, 'Frozen fruits and vegetables', '11', '', NULL");
        setupInsertToCategories("NULL, 'Fruit', '11', '', NULL");
        setupInsertToCategories("NULL, 'Vegetables', '11', '', NULL");
        setupInsertToCategories("NULL, 'Canned fruits and vegetables', '11', '', NULL");


        setupInsertToCategories("NULL, 'Health', '0', '', NULL");
        setupInsertToCategories("NULL, 'Meal substitutes', '16', '', NULL");
        setupInsertToCategories("NULL, 'Protein bars', '16', '', NULL");
        setupInsertToCategories("NULL, 'Protein powder', '16', '', NULL");


        setupInsertToCategories("NULL, 'Meat, chicken and fish', '0', '', NULL");
        setupInsertToCategories("NULL, 'Meat', '20', '', NULL");
        setupInsertToCategories("NULL, 'Chicken', '20', '', NULL");
        setupInsertToCategories("NULL, 'Seafood', '20', '', NULL");


        setupInsertToCategories("NULL, 'Dairy and eggs', '0', '', NULL");
        setupInsertToCategories("NULL, 'Eggs', '24', '', NULL");
        setupInsertToCategories("NULL, 'Cream and sour cream', '24', '', NULL");
        setupInsertToCategories("NULL, 'Yogurt', '24', '', NULL");


        setupInsertToCategories("NULL, 'Dinner', '0', '', NULL");
        setupInsertToCategories("NULL, 'Ready dinner dishes', '28', '', NULL");
        setupInsertToCategories("NULL, 'Pizza', '28', '', NULL");
        setupInsertToCategories("NULL, 'Noodle', '28', '', NULL");
        setupInsertToCategories("NULL, 'Pasta', '28', '', NULL");
        setupInsertToCategories("NULL, 'Rice', '28', '', NULL");
        setupInsertToCategories("NULL, 'Taco', '28', '', NULL");


        setupInsertToCategories("NULL, 'Cheese', '0', '', NULL");
        setupInsertToCategories("NULL, 'Cream cheese', '35', '', NULL");


        setupInsertToCategories("NULL, 'On bread', '0', '', NULL");
        setupInsertToCategories("NULL, 'Cold meats', '37', '', NULL");
        setupInsertToCategories("NULL, 'Sweet spreads', '37', '', NULL");
        setupInsertToCategories("NULL, 'Jam', '37', '', NULL");


        setupInsertToCategories("NULL, 'Snacks', '0', '', NULL");
        setupInsertToCategories("NULL, 'Nuts', '41', '', NULL");
        setupInsertToCategories("NULL, 'Potato chips', '41', '', NULL");
    }


    /* Setup Insert To Food ----------------------------------------------- */
    // To insert food to food table
    public void setupInsertToFood(String values) {

        try {
            DBAdapter db = new DBAdapter(context);
            db.open();
            db.insert("food",
                    "_id, food_name, food_manufacturer_name, food_serving_size_gram, food_serving_size_gram_mesurment, food_serving_size_pcs, food_serving_size_pcs_mesurment, food_energy, food_proteins, food_carbohydrates, food_fat, food_energy_calculated, food_proteins_calculated, food_carbohydrates_calculated, food_fat_calculated, food_user_id, food_barcode, food_category_id, food_thumb, food_image_a, food_image_b, food_image_c, food_notes",
                    values);
            db.close();
        } catch (SQLiteException e) {
            // Toast.makeText(context, "Error; Could not insert food.", Toast.LENGTH_SHORT).show();
        }

    }

    // Insert all food into food database
    public void insertAllFood() {
        setupInsertToFood("NULL, 'White Bread', 'Aulie', '26', 'gram', '1', 'portion', '122', '3.5', '23.4', '1', '32', '1', '6', '0', NULL, NULL, '2', 'aulie_speltlomper_med_havre_thumb.jpg', 'aulie_speltlomper_med_havre_a.jpg', 'aulie_speltlomper_med_havre_b.jpg', 'aulie_speltlomper_med_havre_c.jpg', NULL");
        setupInsertToFood("NULL, 'Oatmeal lightly cooked', 'Axa', '60', 'gram', '60', 'g', '389', '11.4', '63.1', '7.8', '233', '7', '38', '5', NULL, NULL, '3', 'axa_havregryn_lettkokt_thumb.jpg', 'axa_havregryn_lettkokt_a.jpg', 'axa_havregryn_lettkokt_b.jpg', 'axa_havregryn_lettkokt_c.jpg', NULL");
        setupInsertToFood("NULL, 'Axa Oatmeal', 'Axa', '80', 'gram', '80', 'g', '380', '13', '61', '7', '304', '10', '49', '6', NULL, NULL, '3', 'axa_havregryn_store_thumb.jpg', 'axa_havregryn_store_a.jpg', 'axa_havregryn_store_b.jpg', 'axa_havregryn_store_c.jpg', NULL");
        setupInsertToFood("NULL, 'Pitta Bread', 'Hatting', '80', 'gram', '1', 'portion', '251', '8.1', '50', '1.5', '201', '6', '40', '1', NULL, NULL, '4', 'hatting_frosne_pitabrod_thumb.jpg', 'hatting_frosne_pitabrod_a.jpg', 'hatting_frosne_pitabrod_b.jpg', 'hatting_frosne_pitabrod_c.jpg', NULL");
        setupInsertToFood("NULL, 'Coarse Rolls', 'Hvita hjertegod', '70', 'gram', '1', 'portion', '250', '18', '25', '6', '175', '13', '18', '4', NULL, NULL, '4', 'hvita_hjertegod_frosne_ekstra_grove_rundstykker_thumb.jpg', 'hvita_hjertegod_frosne_ekstra_grove_rundstykker_a.jpg', 'hvita_hjertegod_frosne_ekstra_grove_rundstykker_b.jpg', 'hvita_hjertegod_frosne_ekstra_grove_rundstykker_c.jpg', NULL");
        setupInsertToFood("NULL, 'Fiber Balance', 'Wasa', '10', 'gram', '1', 'portion', '330', '14', '43', '5.5', '33', '1', '4', '1', NULL, NULL, '5', 'wasa_fiber_balance_thumb.jpg', 'wasa_fiber_balance_a.jpg', 'wasa_fiber_balance_b.jpg', 'wasa_fiber_balance_c.jpg', NULL");
        setupInsertToFood("NULL, 'Sport +', 'Wasa', '16', 'gram', '1', 'portion', '338', '10.5', '55.5', '3.5', '54', '2', '9', '1', NULL, NULL, '5', 'wasa_sport_pluss_thumb.jpg', 'wasa_sport_pluss_a.jpg', 'wasa_sport_pluss_b.jpg', 'wasa_sport_pluss_c.jpg', NULL");
        setupInsertToFood("NULL, 'Sugar', 'Madhur', '100', 'gram', '100', 'gram', '400', '0', '100', '0', '400', '0', '100', '0', NULL, NULL, '7', 'dan_sukker_sukker_thumb.jpg', 'dan_sukker_sukker_a.jpg', 'dan_sukker_sukker_b.jpg', 'dan_sukker_sukker_c.jpg', NULL");
        setupInsertToFood("NULL, 'Wheat Flour', 'Møllerens', '100', 'gram', '100', 'gram', '341', '10.2', '69.6', '1.6', '341', '10', '70', '2', NULL, NULL, '7', 'moollerens_siktet_hvetemel_thumb.jpg', 'moollerens_siktet_hvetemel_a.jpg', 'moollerens_siktet_hvetemel_b.jpg', 'moollerens_siktet_hvetemel_c.jpg', NULL");
        setupInsertToFood("NULL, 'Ritz Crackers', 'Mondelez Norge', '200', 'gram', '1', 'packet', '490', '7.8', '61', '23', '980', '16', '122', '46', NULL, NULL, '8', 'mondelez_norge_ritz_crackers_thumb.jpg', 'mondelez_norge_ritz_crackers_a.jpg', 'mondelez_norge_ritz_crackers_b.jpg', 'mondelez_norge_ritz_crackers_c.jpg', NULL");
        setupInsertToFood("NULL, 'Battery Energy Drink 50cl', 'Ringnes', '500', 'gram', '1', 'bottle', '50', '0.4', '11.5', '0', '250', '2', '58', '0', NULL, NULL, '10', 'ringnes_battery_energy_drink_50cl_thumb.jpg', 'ringnes_battery_energy_drink_50cl_a.jpg', 'ringnes_battery_energy_drink_50cl_b.jpg', 'ringnes_battery_energy_drink_50cl_c.jpg', NULL");
        setupInsertToFood("NULL, 'Frozen Brokkoli', 'Eldorado', '250', 'gram', '0.5', 'portion', '26', '1.9', '4.2', '0.2', '65', '5', '11', '1', NULL, NULL, '12', 'eldorado_frossen_brokkoliblanding_thumb.jpg', 'eldorado_frossen_brokkoliblanding_a.jpg', 'eldorado_frossen_brokkoliblanding_b.jpg', 'eldorado_frossen_brokkoliblanding_c.jpg', NULL");
        setupInsertToFood("NULL, 'Brokkoli Soup', 'Rema 1000', '225', 'gram', '0.5', 'portion', '27', '2.8', '1.9', '0.5', '61', '6', '4', '1', NULL, NULL, '12', 'rema_1000_frosne_brokkolitopper_thumb.jpg', 'rema_1000_frosne_brokkolitopper_a.jpg', 'rema_1000_frosne_brokkolitopper_b.jpg', 'rema_1000_frosne_brokkolitopper_c.jpg', NULL");
        setupInsertToFood("NULL, 'Red Grapes', 'Bama', '200', 'gram', '0.5', 'packet', '62', '0.7', '13.8', '0.2', '124', '1', '28', '0', NULL, NULL, '13', 'bama_rode_druer_thumb.jpg', 'bama_rode_druer_a.jpg', 'bama_rode_druer_b.jpg', 'bama_rode_druer_c.jpg', NULL");
        setupInsertToFood("NULL, 'Broccoli', 'Bama', '300', 'gram', '0.5', 'portion', '33', '2.8', '7', '0.4', '99', '8', '21', '1', NULL, NULL, '14', 'bama_brokkoli_thumb.jpg', 'bama_brokkoli_a.jpg', 'bama_brokkoli_b.jpg', 'bama_brokkoli_c.jpg', NULL");
        setupInsertToFood("NULL, 'Carrot', 'Bama', '44', 'gram', '1', 'portion', '41', '0.9', '10', '0.2', '18', '0', '4', '0', NULL, NULL, '14', 'bama_gulrot_thumb.jpg', 'bama_gulrot_a.jpg', 'bama_gulrot_b.jpg', 'bama_gulrot_c.jpg', NULL");
        setupInsertToFood("NULL, 'Iceberg mix', 'Bama', '125', 'gram', '0.5', 'packet', '14', '0.8', '2.2', '0.1', '18', '1', '3', '0', NULL, NULL, '14', 'bama_isberg_mix_thumb.jpg', 'bama_isberg_mix_a.jpg', 'bama_isberg_mix_b.jpg', 'bama_isberg_mix_c.jpg', NULL");
        setupInsertToFood("NULL, 'Iceberg salad', 'Bama', '50', 'gram', '1', 'packet', '12', '0.8', '1.5', '0.1', '6', '0', '1', '0', NULL, NULL, '14', 'bama_isbergsalat_thumb.jpg', 'bama_isbergsalat_a.jpg', 'bama_isbergsalat_b.jpg', 'bama_isbergsalat_c.jpg', NULL");
        setupInsertToFood("NULL, 'Mexican Salad', 'Bama', '135', 'gram', '0.5', 'packet', '140', '3', '3.1', '11.2', '189', '4', '4', '15', NULL, NULL, '14', 'bama_meksikansk_salat_thumb.jpg', 'bama_meksikansk_salat_a.jpg', 'bama_meksikansk_salat_b.jpg', 'bama_meksikansk_salat_c.jpg', NULL");
        setupInsertToFood("NULL, 'Paprika', 'Bama', '36', 'gram', '0.25', 'portion', '30', '1', '4.7', '0.4', '11', '0', '2', '0', NULL, NULL, '14', 'bama_rod_paprika_thumb.jpg', 'bama_rod_paprika_a.jpg', 'bama_rod_paprika_b.jpg', 'bama_rod_paprika_c.jpg', NULL");
    }
}