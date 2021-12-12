package com.example.n15.g701;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;

public class MyDatabase extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "book_db.sqlite";
    public static final String TBL_NAME = "Book";
    public static final String COL_BOOK_ID = "Book_Id";
    public static final String COL_BOOK_NAME = "Book_Name";
    public static final String COL_BOOK_MANUFACTURER = "Book_Manufacturer";
    public static final String COL_BOOK_REPRINT = "Book_Reprint";
    public static final String COL_BOOK_PRICE = "Book_Price";
    public static final String COL_BOOK_IMAGE = "Book_Image";


    public MyDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TBL_NAME + "(" + COL_BOOK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_BOOK_NAME + " VARCHAR(100), " + COL_BOOK_PRICE + " FLOAT, " +
                COL_BOOK_MANUFACTURER +  " VARCHAR(100), " + COL_BOOK_REPRINT + " INTERGER, " + COL_BOOK_IMAGE + " BLOB)";
        sqLiteDatabase.execSQL(sql);
    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TBL_NAME);
        onCreate(sqLiteDatabase);
    }

    public void execSql(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    public Cursor getData(String sql){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(sql,null);
    }

    public static byte[] getBitmapAsByteArray(Bitmap bitmap) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        return outputStream.toByteArray();
    }

    public void insertData(String name, String author, int page, float eprice, float price, String publisher, String datetime, String LoaiBia, String size, String category, byte[] image, String summary) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_BOOK_NAME, name);
        cv.put(COL_BOOK_PRICE, price);
        cv.put(COL_BOOK_MANUFACTURER, publisher);
        cv.put(COL_BOOK_IMAGE, image);
        db.insert(TBL_NAME, null, cv);

    }
}
