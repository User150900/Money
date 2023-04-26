package com.data;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DeptsIDataStorage extends SQLiteOpenHelper implements DeptsDataStorage {
    private final static String DB_NAME = "depts.dp";
    private final static String TABLE_NAME = "depts";

    private final static String COLUNN_ID = "id";
    private final static String COLUNN_NAME = "name";
    private final static String COLUNN_DATE = "date";
    private final static String COLUNN_MONEY = "money";

    public DeptsIDataStorage(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        dp.execSQL(
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUNN_ID + " INTEGER PRIMARY KEY AUTOINCERMENT, " +
                        COLUNN_NAME + " VARCHAR, " +
                        COLUNN_DATE + "REAL" +
                        ");"
        )

        @Override
        public void onUpgrade (SQLiteDatabase sqLiteDatabase,int i, int i1){
            dp.execSQL("DROP TABLE " + TABLE_NAME);
            onCreate(dp);
        }

        @Override
        public void saveData() {
            SQLiteDatabase database = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(COLUNN_NAME, dept.name);
            contentValues.put(COLUNN_MONEY, dept.money);
            database.insert(TABLE_NAME, null, contentValues);
        }

        @Override
        public Dept getData (int id){
            SQLiteDatabase database = getReadableDatabase();
            Cursor cursor = database.query(TABLE_NAME, null, null, null, null, null, null);
            cursor.moveToPosition(id);
            @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(COLUNN_NAME));
            @SuppressLint("Range") float money = cursor.getFloat(cursor.getColumnIndex(COLUNN_MONEY));
            cursor.close();

            return new Dept(name, money);
        }

        @Override
        public List<Dept> getAllData () {
            SQLiteDatabase database = getReadableDatabase();
            Cursor cursor = database.query(TABLE_NAME, null, null, null, null, null, null);
            ArrayList<Dept> depts = new ArrayList<>();

            if (cursor.moveToFirst()){
                do {

                } while (cursor.moveToNext());
            }
            return depts;
        }

    }
}
