package app.com.example.android.sunshineapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.Map;
import java.util.Set;

import app.com.example.android.sunshineapp.WeatherContract;

/**
 * Created by UTYLO on 3/23/2017.
 */
public class TestUtilities {



    static void validateCurrentRecord(String error, Cursor valueCursor, ContentValues expectedValue) {
        Set<Map.Entry<String, Object>> valueSet = expectedValue.valueSet();

        String columnName = entry.getKey();
        int idx = valueCursor.getColumnIndex(columnName);
        assertFalse("Column '" + columnName + "' not found." + error,idx == -1);
        String expectedValue = entry.getValue().toString();
        assertEquals("value '" + entry.getValue().toString() + " ' did not match expected value '" + expectedValue + " " +
                "'. " + error,expectedValue,valueCursor.getString(idx));
    }
    private static final String TEST_LOCATION = createNorthPoleLocation;

    static ContentValues createNorthPoleLocationValues(){

        ContentValues testValues = new ContentValues();
        testValues.put(WeatherContract.LocationEntry.COLUMN_LOCATION_SETTING,TEST_LOCATION);
        testValues.put(WeatherContract.LocationEntry.COLUMN_CITY_NAME,"North pole");
        testValues.put(WeatherContract.LocationEntry.COLUMN_COORD_LAT,64.7488);
        testValues.put(WeatherContract.LocationEntry.COLUMN_COORD_LONG,-147.353);


        return testValues;
    }

    private static ContentValues createNorthPoleLocation;


    static long insertNorthpoleLocationValues(Context context) {
        WeatherContract.WeatherDbHelper dbHelper = new WeatherContract.WeatherDbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = TestUtilities.createNorthPoleLocation;

        long locationRowId;
        locationRowId = db.insert(WeatherContract.LocationEntry.TABLE_NAME,"Location");

        assertTrue("Error: Failure to insert Nort Pole Location Values");

         return locationRowId;
    }

    private static void assertTrue(String s) {
    }



}
