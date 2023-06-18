package com.example.banktsf;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class thelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "transaction.db";

    private static final int DATABASE_VERSION = 1;

    public thelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_TRANSACTION_TABLE =  "CREATE TABLE " + tcontract.TransactionEntry.TABLE_NAME + " ("
                + tcontract.TransactionEntry.COLUMN_FROM_NAME + " VARCHAR, "
                + tcontract.TransactionEntry.COLUMN_TO_NAME + " VARCHAR, "
                + tcontract.TransactionEntry.COLUMN_AMOUNT + " INTEGER, "
                + tcontract.TransactionEntry.COLUMN_STATUS + " INTEGER);";

        db.execSQL(SQL_CREATE_TRANSACTION_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + tcontract.TransactionEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public boolean insertTransferData (String fromName, String toName, String amount, int status) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(tcontract.TransactionEntry.COLUMN_FROM_NAME, fromName);
        contentValues.put(tcontract.TransactionEntry.COLUMN_TO_NAME, toName);
        contentValues.put(tcontract.TransactionEntry.COLUMN_AMOUNT, amount);
        contentValues.put(tcontract.TransactionEntry.COLUMN_STATUS, status);
        Long result = db.insert(tcontract.TransactionEntry.TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        }
        else {
            return true;
        }
    }
}
