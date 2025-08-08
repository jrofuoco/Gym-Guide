package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ProgramScheduleDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ProgramScheduleData.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME_SCHEDULE = "program_schedule";
    private static final String COLUMN_SCHEDULE_ID = "_id";
    private static final String COLUMN_PROGRAM_NAME = "program_name";
    private static final String COLUMN_START_TIME = "start_time";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_DURATION = "duration";
    private static final String COLUMN_AM_PM = "am_pm";  // New column for AM/PM

    private Context context;

    public ProgramScheduleDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            String scheduleTableQuery =
                    "CREATE TABLE " + TABLE_NAME_SCHEDULE +
                            " (" + COLUMN_SCHEDULE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            COLUMN_PROGRAM_NAME + " TEXT, " +
                            COLUMN_START_TIME + " TEXT, " +
                            COLUMN_DATE + " TEXT, " +
                            COLUMN_DURATION + " TEXT, " +
                            COLUMN_AM_PM + " TEXT);";  // Add the new column for AM/PM
            db.execSQL(scheduleTableQuery);
        } catch (Exception e) {
            Toast.makeText(context, "Error creating schedule database: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_SCHEDULE);
            onCreate(db);
        } catch (Exception e) {
            Toast.makeText(context, "Error upgrading schedule database: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public long addClass(String programName, String startTime, String date, String duration, String amPm) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_PROGRAM_NAME, programName);
        cv.put(COLUMN_START_TIME, startTime);
        cv.put(COLUMN_DATE, date);
        cv.put(COLUMN_DURATION, duration);
        cv.put(COLUMN_AM_PM, amPm);  // Add the AM/PM value

        return db.insert(TABLE_NAME_SCHEDULE, null, cv);
    }

    public List<String> getClassInfo() {
        List<String> classInfoList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        try {
            String[] columns = {COLUMN_PROGRAM_NAME, COLUMN_START_TIME, COLUMN_DATE, COLUMN_DURATION, COLUMN_AM_PM};

            Cursor cursor = db.query(TABLE_NAME_SCHEDULE, columns, null, null, null, null, null);

            while (cursor.moveToNext()) {
                @SuppressLint("Range") String programName = cursor.getString(cursor.getColumnIndex(COLUMN_PROGRAM_NAME));
                @SuppressLint("Range") String startTime = cursor.getString(cursor.getColumnIndex(COLUMN_START_TIME));
                @SuppressLint("Range") String date = cursor.getString(cursor.getColumnIndex(COLUMN_DATE));
                @SuppressLint("Range") String duration = cursor.getString(cursor.getColumnIndex(COLUMN_DURATION));
                @SuppressLint("Range") String amPm = cursor.getString(cursor.getColumnIndex(COLUMN_AM_PM));

                String classInfo = programName + ": " + date + ", " + startTime + ", Duration: " + duration + ", " + amPm;
                classInfoList.add(classInfo);
            }

            cursor.close();
        } catch (Exception e) {
            Log.e("YourTag", "Error getting class information", e);
        } finally {
            if (db != null && db.isOpen()) {
                db.close();
            }
        }

        return classInfoList;
    }

    Cursor readAllData() {
        String query = "SELECT * FROM " + TABLE_NAME_SCHEDULE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    public boolean deleteRecordByEmail(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String whereClause = COLUMN_SCHEDULE_ID + " = ?";
        String[] whereArgs = {id};

        try {
            int rowsDeleted = db.delete(TABLE_NAME_SCHEDULE, whereClause, whereArgs);
            return rowsDeleted > 0;
        } catch (Exception e) {
            Log.e("YourTag", "Error deleting record", e);
            return false;
        } finally {
            if (db != null && db.isOpen()) {
                db.close();
            }
        }
    }

}


