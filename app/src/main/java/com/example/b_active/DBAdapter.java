package com.example.b_active;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DBAdapter {

    /* 01 Variables ---------------------------------------- */
    private static final String databaseName = "bactive";
    private static final int databaseVersion = 57;

    /* 02 Database variables ------------------------------- */
    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;


    /* 03 Class DbAdapter ---------------------------------- */
    public DBAdapter(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    /* 04 DatabaseHelper ------------------------------------ */
    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, databaseName, null, databaseVersion);
        }

        public void onCreate(SQLiteDatabase db){
            try{
                // Create table goal
                db.execSQL("CREATE TABLE IF NOT EXISTS goal (" +
                        " _id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        " goal_id INT, "+
                        " goal_current_weight INT, "+
                        " goal_target_weight INT, "+
                        " goal_i_want_to VARCHAR, "+
                        " goal_weekly_goal VARCHAR, "+
                        " goal_date DATE, "+
                        " goal_activity_level INT, " +
                        " goal_energy_bmr INT, "+
                        " goal_proteins_bmr INT, "+
                        " goal_carbs_bmr INT, "+
                        " goal_fat_bmr INT, "+
                        " goal_energy_diet INT, "+
                        " goal_proteins_diet INT, "+
                        " goal_carbs_diet INT, "+
                        " goal_fat_diet INT, "+
                        " goal_energy_with_activity INT, "+
                        " goal_proteins_with_activity INT, "+
                        " goal_carbs_with_activity INT, "+
                        " goal_fat_with_activity INT, "+
                        " goal_energy_with_activity_and_diet INT, "+
                        " goal_proteins_with_activity_and_diet INT, "+
                        " goal_carbs_with_activity_and_diet INT, "+
                        " goal_fat_with_activity_and_diet INT, "+
                        " goal_notes VARCHAR);");
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            try{
                // Create tables
                db.execSQL("CREATE TABLE IF NOT EXISTS users (" +
                        " _id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        " user_id INTEGER, " +
                        " user_email VARCHAR," +
                        " user_password VARCHAR, " +
                        " user_salt VARCHAR, " +
                        " user_alias VARCHAR," +
                        " user_dob DATE, " +
                        " user_gender INT, " +
                        " user_location VARHCAR, " +
                        " user_height INT, " +
                        " user_mesurment VARHCAR, " +
                        " user_last_seen TIME," +
                        " user_note VARCHAR);");

            }
            catch (SQLException e) {
                e.printStackTrace();
            }

            try{
                db.execSQL("CREATE TABLE IF NOT EXISTS food_diary_cal_eaten (" +
                        " _id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        " fdce_id INTEGER, " +
                        " fdce_date DATE, " +
                        " fdce_meal_no INT, " +
                        " fdce_eaten_energy INT, " +
                        " fdce_eaten_proteins INT, " +
                        " fdce_eaten_carbs INT, " +
                        " fdce_eaten_fat INT);");
            }
            catch (SQLException e) {
                e.printStackTrace();
            }

            try{
                db.execSQL("CREATE TABLE IF NOT EXISTS food_diary_sum (" +
                        " _id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        " food_diary_sum_id INTEGER, " +
                        " food_diary_sum_date DATE, " +
                        " food_diary_sum_energy INT, " +
                        " food_diary_sum_proteins INT, " +
                        " food_diary_sum_carbs INT, " +
                        " food_diary_sum_fat INT);");
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            try{
                db.execSQL("CREATE TABLE IF NOT EXISTS food_diary (" +
                        " _id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        " fd_id INTEGER," +
                        " fd_date DATE," +
                        " fd_meal_number INT," +
                        " fd_food_id INT," +
                        " fd_serving_size_gram DOUBLE," +
                        " fd_serving_size_gram_mesurment VARCHAR," +
                        " fd_serving_size_pcs DOUBLE," +
                        " fd_serving_size_pcs_mesurment VARCHAR," +
                        " fd_energy_calculated DOUBLE," +
                        " fd_protein_calculated DOUBLE," +
                        " fd_carbohydrates_calculated DOUBLE," +
                        " fd_fat_calculated DOUBLE" +
                        " fd_meal_id INT);");
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            try{
                db.execSQL("CREATE TABLE IF NOT EXISTS categories (" +
                        " _id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        " category_id INTEGER," +
                        " category_name VARCHAR," +
                        " category_parent_id INT," +
                        " category_icon VARCHAR," +
                        " category_note VARCHAR);");

            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                db.execSQL("CREATE TABLE IF NOT EXISTS food (" +
                        " _id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        " food_id INTEGER, " +
                        " food_name VARCHAR," +
                        " food_manufacturer_name VARCHAR," +
                        " food_store VARCHAR," +
                        " food_description VARCHAR," +
                        " food_serving_size_gram DOUBLE," +
                        " food_serving_size_gram_mesurment VARCHAR," +
                        " food_serving_size_pcs DOUBLE," +
                        " food_serving_size_pcs_mesurment VARCHAR," +
                        " food_energy DOUBLE," +
                        " food_proteins DOUBLE," +
                        " food_carbohydrates DOUBLE," +
                        " food_fat DOUBLE," +
                        " food_energy_calculated DOUBLE," +
                        " food_proteins_calculated DOUBLE," +
                        " food_carbohydrates_calculated DOUBLE," +
                        " food_fat_calculated DOUBLE," +
                        " food_user_id INT," +
                        " food_barcode VARCHAR," +
                        " food_category_id INT," +
                        " food_thumb VARCHAR," +
                        " food_image_a VARCHAR," +
                        " food_image_b VARCHAR," +
                        " food_image_c VARCHAR," +
                        " food_last_used DATE," +
                        " food_language VARCHAR," +
                        " food_notes VARCHAR);");
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // ! All tables that are going to be dropped need to be listed here

            db.execSQL("DROP TABLE IF EXISTS goal");
            db.execSQL("DROP TABLE IF EXISTS users");
            db.execSQL("DROP TABLE IF EXISTS food_diary_cal_eaten");
            db.execSQL("DROP TABLE IF EXISTS food_diary_sum");
            db.execSQL("DROP TABLE IF EXISTS food_diary");
            db.execSQL("DROP TABLE IF EXISTS categories");
            db.execSQL("DROP TABLE IF EXISTS food");
            onCreate(db);

            String TAG = "Tag";
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");

        } // end public void onUpgrade
    } // DatabaseHelper

    /* 05 Open database --------------------------------------------------------- */
    public DBAdapter open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    /* 06 Close database --------------------------------------------------------- */
    public void close() {
        DBHelper.close();
    }

    /* 08 Insert data ------------------------------------------------------------ */
    public void insert(String table, String fields, String values){

        try {
            db.execSQL("INSERT INTO " + table +  "(" + fields + ") VALUES (" + values + ")");
        }
        catch(SQLiteException e){
            System.out.println("Insert error: " + e.toString());
            Toast.makeText(context, "Error: " +  e.toString(), Toast.LENGTH_LONG).show();
        }
    }

    /* 09 Count ------------------------------------------------------------------ */
    public int count(String table)
    {
        try {
            Cursor mCount = db.rawQuery("SELECT COUNT(*) FROM " + table + "", null);
            mCount.moveToFirst();
            int count = mCount.getInt(0);
            mCount.close();
            return count;
        }
        catch(SQLiteException e){
            return -1;
        }

    }

}
