package com.example.umer.umer21;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.ContentValues;
import android.os.Build;

public class mydbhandler extends SQLiteOpenHelper {

private static final int Database_VERSION =1;
    private static final String DATABASE_NAME ="products.db";
    private static final String TABLE_PRODUCTS="products";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_PRODUCTNAME ="productname";

    public mydbhandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory,Database_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db ) {
        String query ="CREATE TABLE" +TABLE_PRODUCTS +"("
                + COLUMN_ID + "INTERGER PRIMARY KEY AUTOINCREAMENT" +
                COLUMN_PRODUCTNAME + "TEXT" +
                ")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion , int newVersion1) {
db.execSQL("DROP TABLE IF EXIST" +TABLE_PRODUCTS);
        onCreate(db);

    }


    public void addproduct(products product){

        ContentValues Values = new ContentValues();
        Values.put(COLUMN_PRODUCTNAME, product.get_productname());
    SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PRODUCTS , null , Values);
        db.close();
    }
    public void deleteproduct(String productname){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM "+ TABLE_PRODUCTS+"WHERE" +COLUMN_PRODUCTNAME + "=\"" +productname + "\";" );
    }

    public String databaseTOString(){
        String dbString="";
        SQLiteDatabase db = getWritableDatabase();
        String query ="SELECT * FROM "+TABLE_PRODUCTS + "WHERE 1";
        Cursor c= db.rawQuery(query,null);

        c.moveToFirst();

        while (!c.isAfterLast()){
                if(c.getString(c.getColumnIndex("productname"))!= null);
                dbString += c.getString(c.getColumnIndex("productname"));
                dbString +="\n";
}
        db.close();
        return  dbString;

    }
}
