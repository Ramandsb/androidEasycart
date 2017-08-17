package ca.lambtoncollege.easycart.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.ArrayList;

import ca.lambtoncollege.easycart.Products;

/**
 * Created by ramandeepsingh on 2017-08-16.
 */

public class DatabaseOperations extends SQLiteOpenHelper {

    public DatabaseOperations(Context context) {
        super(context, TableData.Tableinfo.DATABASE_NAME, null, database_version);
    }

    public static final int database_version = 2;
    public String CREATE_QUERY = "CREATE TABLE " + TableData.Tableinfo.TABLE_NAME + "(" + TableData.Tableinfo.PRODUCT_ID + " TEXT," +TableData.Tableinfo.PRODUCT_NAME + " TEXT,"+TableData.Tableinfo.PRODUCT_DESCRIPTION + " TEXT);";

    @Override
    public void onCreate(SQLiteDatabase sdb) {
        sdb.execSQL(CREATE_QUERY);
        Log.d("Database operations", "Table created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TableData.Tableinfo.TABLE_NAME);
        onCreate(db);
    }

    public void putInformation(DatabaseOperations dop, String id, String name,String desc)

    {
        SQLiteDatabase SQ = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
            cv.put(TableData.Tableinfo.PRODUCT_ID, id);
        cv.put(TableData.Tableinfo.PRODUCT_NAME, name);
        cv.put(TableData.Tableinfo.PRODUCT_DESCRIPTION, desc);
        long k = SQ.insert(TableData.Tableinfo.TABLE_NAME, null, cv);
        Log.d("Database putLatLon", "true");

    }

    public ArrayList<Products> readData(DatabaseOperations dop) {
        ArrayList<Products> listData = new ArrayList<>();
        SQLiteDatabase SQ = dop.getReadableDatabase();

        Log.d("DatabasRead","");
        String[] coloumns = {TableData.Tableinfo.PRODUCT_ID, TableData.Tableinfo.PRODUCT_NAME,TableData.Tableinfo.PRODUCT_DESCRIPTION,};
        Cursor cursor = SQ.query(TableData.Tableinfo.TABLE_NAME, coloumns, null, null, null, null, null);
//        Cursor cursor = SQ.rawQuery("SELECT * from " + TableData.Tableinfo.TABLE_NAME + " ORDER BY " + TableData.Tableinfo.TIMETOSTART + " ASC", null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                //create a new movie object
                // and retrieve the data from the cursor to be stored in this movie object
                Products item = new Products();
                item.setProduct_id(Integer.valueOf(cursor.getString(cursor.getColumnIndex(TableData.Tableinfo.PRODUCT_ID))));
                item.setProduct_name(cursor.getString(cursor.getColumnIndex(TableData.Tableinfo.PRODUCT_NAME)));
                item.setProduct_description(cursor.getString(cursor.getColumnIndex(TableData.Tableinfo.PRODUCT_DESCRIPTION)));
                listData.add(item);
                Log.d("Database read", "true");
            }
            while (cursor.moveToNext());
        }
        return listData;
    }

    public  void eraseData(DatabaseOperations dop){
        SQLiteDatabase db = dop.getWritableDatabase(); // helper is object extends SQLiteOpenHelper
        db.delete(TableData.Tableinfo.TABLE_NAME, null, null);
        Log.d("Database Erased", "true");
    }

}
