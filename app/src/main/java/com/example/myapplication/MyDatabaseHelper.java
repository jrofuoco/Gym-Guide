package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private final Context context;
    private static final String DATABASE_NAME = "UserData.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "user_data";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_FIRSTNAME = "first_name";
    private static final String COLUMN_LASTNAME = "last_name";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_GENDER = "gender";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_REPEATPASSWORD = "repeat_password";

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            String query =
                    "CREATE TABLE " + TABLE_NAME +
                            " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            COLUMN_FIRSTNAME + " TEXT, " +
                            COLUMN_LASTNAME + " TEXT, " +
                            COLUMN_ADDRESS + " TEXT, " +
                            COLUMN_GENDER + " TEXT, " +
                            COLUMN_AGE + " INTEGER, " +
                            COLUMN_EMAIL + " TEXT, " +
                            COLUMN_PASSWORD + " TEXT, " +
                            COLUMN_REPEATPASSWORD + " TEXT);";
            db.execSQL(query);
        } catch (Exception e) {
            Toast.makeText(context, "Error creating database: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        } catch (Exception e) {
            Toast.makeText(context, "Error upgrading database: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    //INSERTING THE NEWLY CREATED ACCOUNTS
    public long addUser(String firstname, String lastname, String address, String gender,
                        int age, String email, String password, String repeatpassword) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_FIRSTNAME, firstname);
        cv.put(COLUMN_LASTNAME, lastname);
        cv.put(COLUMN_ADDRESS, address);
        cv.put(COLUMN_GENDER, gender);
        cv.put(COLUMN_AGE, age);
        cv.put(COLUMN_EMAIL, email);
        cv.put(COLUMN_PASSWORD, password);
        cv.put(COLUMN_REPEATPASSWORD, repeatpassword);

        return db.insert(TABLE_NAME, null, cv);
    }

    //EMAIL AND PASSWORD VALIDATION
    public boolean checkUser(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_ID};
        String selection = COLUMN_EMAIL + " = ?" + " AND " + COLUMN_PASSWORD + " = ?";
        String[] selectionArgs = {email, password};
        String limit = "1";

        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null, limit);
        boolean userExists = (cursor.getCount() > 0);
        cursor.close();
        db.close();
        return userExists;
    }

    // Retrieve Firstname based on Email
    @SuppressLint("Range")
    public String getFirstnameByEmail(String email) {
        String firstname = null;
        SQLiteDatabase db = this.getReadableDatabase();

        try {
            String[] columns = {COLUMN_FIRSTNAME};
            String selection = COLUMN_EMAIL + "=?";
            String[] selectionArgs = {email};

            Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);

            if (cursor.moveToFirst()) {
                firstname = cursor.getString(cursor.getColumnIndex(COLUMN_FIRSTNAME));
            }

            cursor.close();
        } catch (Exception e) {
            // Handle exceptions, log an error, or throw a more specific exception
            Log.e("YourTag", "Error getting first name by email", e);
        } finally {
            // Ensure that the database is closed, even if an exception occurs
            if (db != null && db.isOpen()) {
                db.close();
            }
        }

        return firstname;
    }

    @SuppressLint("Range")
    public String getLastnameByEmail(String email) {
        String lastname = null;

        try (SQLiteDatabase db = this.getReadableDatabase()) {
            String[] columns = {COLUMN_LASTNAME};
            String selection = COLUMN_EMAIL + "=?";
            String[] selectionArgs = {email};

            try (Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null)) {
                if (cursor != null && cursor.moveToFirst()) {
                    lastname = cursor.getString(cursor.getColumnIndex(COLUMN_LASTNAME));
                }
            }
        } catch (Exception e) {
            // Handle exceptions, log an error, or throw a more specific exception
            Log.e("YourTag", "Error getting last name by email", e);
        }

        return lastname;
    }


    Cursor readAllData() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateData(String row_id,
                         String firstname,
                         String lastname,
                         String address,
                         String gender,
                         String age,
                         String email,
                         String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_FIRSTNAME, firstname);
        cv.put(COLUMN_LASTNAME, lastname);
        cv.put(COLUMN_ADDRESS, address);
        cv.put(COLUMN_GENDER, gender);
        cv.put(COLUMN_AGE, age);
        cv.put(COLUMN_EMAIL, email);
        cv.put(COLUMN_PASSWORD, password);

        // Use "_id" instead of "id" in the where clause
        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});
        if (result == -1) {
            Toast.makeText(context, "Update Failed.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Update Successfully.", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean isEmailRegistered(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_EMAIL + "=?", new String[]{email});
        boolean emailExists = cursor.getCount() > 0;
        cursor.close();
        return emailExists;
    }

    void updateDataProfile(String row_id,
                    String firstname,
                    String lastname,
                    String address,
                    String gender,
                    String age,
                    String email,
                    String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_FIRSTNAME, firstname);
        cv.put(COLUMN_LASTNAME, lastname);
        cv.put(COLUMN_ADDRESS, address);
        cv.put(COLUMN_GENDER, gender);
        cv.put(COLUMN_AGE, age);
        cv.put(COLUMN_EMAIL, email);
        cv.put(COLUMN_PASSWORD, password);

        // Use "_id" instead of "id" in the where clause
        long result = db.update(TABLE_NAME, cv, "email=?", new String[]{email});
        if (result == -1) {
            Toast.makeText(context, "Update Failed.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Update Successfully.", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readDataByEmail(String email) {
        String[] columns = {
                COLUMN_ID,
                COLUMN_FIRSTNAME,
                COLUMN_LASTNAME,
                COLUMN_ADDRESS,
                COLUMN_GENDER,
                COLUMN_AGE,
                COLUMN_EMAIL,
                COLUMN_PASSWORD,
        };
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            String selection = COLUMN_EMAIL + "=?";
            String[] selectionArgs = {email};
            cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        }
        return cursor;
    }

}


