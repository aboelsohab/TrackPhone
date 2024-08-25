package com.beta.trackphone;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Data";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // تحديث قاعدة البيانات لتخزين حالة الهاتف (Lost أو Stolen)

@Override
public void onCreate(SQLiteDatabase db) {
    // إضافة عمود جديد لتخزين حالة الهاتف
    String ALTER_TABLE = "ALTER TABLE " + "Users" + " ADD COLUMN " + "phoneStatus" + " TEXT";
    db.execSQL(ALTER_TABLE);
    Person.onCreate(db);
}

@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    Person.onUpgrade(db, oldVersion, newVersion);
}

}
