package com.example.banktsf;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class ushelper extends SQLiteOpenHelper {

    String TABLE_NAME = uscontract.UserEntry.TABLE_NAME;

    private static final String DATABASE_NAME = "user.db";

    private static final int DATABASE_VERSION = 1;

    public ushelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + uscontract.UserEntry.TABLE_NAME + " ("
                + uscontract.UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + uscontract.UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + uscontract.UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + uscontract.UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + uscontract.UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + uscontract.UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        db.execSQL(SQL_CREATE_USER_TABLE);

        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES(7860, 'Rajesh Kumar', 'rajesh@gmail.com', '7584', '7895641238', 15000)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES(5862, 'Aarti Singh', 'aarti@gmail.com', '1258', '8995641238', 5000)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES(7895, 'Ravi Verma', 'ravi@gmail.com', '8896', '7595645896', 1000)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES(1258, 'Sanjay Sharma', 'sanjay@gmail.com', '7752', '9995640038', 8000)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES(7410, 'Shivani Kumari', 'shivani@gmail.com', '3669', '9095648962', 7500)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES(8529, 'Piyush Joshi', 'piyush@gmail.com', '9985', '8855640238', 6500)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES(3698, 'Yash Pratap', 'yash@gmail.com', '1207', '8895640215', 4500)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES(7853, 'Khushi Jain', 'khushi@gmail.com', '4522', '9985021539', 2500)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES(4562, 'Ritik Sharma', 'ritik@gmail.com', '6582', '9309565238', 10500)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES(2365, 'Rohit Patidar', 'rohit@gmail.com', '5450', '8292591201', 9900)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES(7854, 'Anurag Sharma', 'anurag@gmail.com', '2656', '9015641200', 9800)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES(3621, 'Hitish Kumar', 'hitish@gmail.com', '1203', '9995641999', 11000)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES(1122, 'Naveen Chaturvedi', 'naveen@gmail.com', '5566', '9119541001', 5800)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES(9512, 'Gauri Parashar', 'gauri@gmail.com', '2236', '6254642205', 3500)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES(7530, 'Farhan Khan', 'farhan@gmail.com', '6692', '6893641266', 1010)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + uscontract.UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + uscontract.UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + uscontract.UserEntry.TABLE_NAME + " where " +
                uscontract.UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + uscontract.UserEntry.TABLE_NAME + " set " + uscontract.UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                uscontract.UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}