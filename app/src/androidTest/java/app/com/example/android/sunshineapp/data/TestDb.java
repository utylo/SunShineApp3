package app.com.example.android.sunshineapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.Map;
import java.util.Set;

import app.com.example.android.sunshineapp.WeatherContract;

import static android.test.MoreAsserts.assertEquals;
import static app.com.example.android.sunshineapp.WeatherContract.*;
import static junit.framework.Assert.assertTrue;

/**
 * Created by UTYLO on 3/23/2017.
 */
public class TestDb {



    private Context mContext;

    public long testLocationTable() {


        WeatherDbHelper dbHelper = new  WeatherDbHelper(mContext);

        SQLiteDatabase db = dbHelper.getWritetableDatabase();


        ContentValues testValues = TestUtilities.createNorthPoleLocationValues();

        long locationRowId;
        locationRowId = db.insert(LocationEntry.TABLE_NAME,null,testValues);


        assertTrue(locationRowId != -1);


        Cursor cursor = db.query(
                LocationEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null


        );

        assertTrue("Error:No Records returned from location query",cursor.moveToFirst());


        TestUtilities.validateCurrentRecord("Error:Location Query Validation Failed",
        cursor,testValues);
        
        assertFalse("Error:More than one record returned from location query",
                cursor.moveToNext());

        cursor.close();
        db.close();

        return locationRowId;
        


    }

    private static void assertFalse(String s,boolean b) {
    }
}