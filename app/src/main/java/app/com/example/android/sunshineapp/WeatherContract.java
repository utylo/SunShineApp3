package app.com.example.android.sunshineapp;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.provider.BaseColumns;
import android.text.format.Time;

/**
 * Created by UTYLO on 3/22/2017.
 */
public class WeatherContract {
    public static long normalizeDate(long startDate) {
        Time time = new Time();
        time.setToNow();
        int julianDay = Time.getJulianDay(startDate,time.gmtoff);
        return time.setJulianDay(julianDay);
    }

    public static final class LocationEntry implements BaseColumns {
        private static final BASE_CONTENT_URI=
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_LOCATION).build();

        private static final CONTENT_AUTHORITY=;
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_LOCATION;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTORITY + "/" + PATH_LOCATION;


        public static final String TABLE_NAME = "location";

        public static final String COLUMN_LOCATION_SETTING = "location_setting";

        public static final String COLUMN_CITY_NAME = "city_name";

        public static final String COLUMN_COORD_LAT = "coord_lat";

        public static final String COLUMN_COORD_LONG = "coord_long";


        public static Uri buildLocationUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI,id);
        }

    }

    public class WeatherDbHelper extends SQLiteOpenHelper {

        private static final int DATABASE_VERSION = 2;

        static final String DATABASE_NAME = "weather.db";

        public WeatherDbHelper(Context context) {
            super(context,DATABASE_NAME,null,DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            final String SQL_CREATE_WEATHER_TABLE = "CREATE TABLE" + WeatherEntry.TABLE_NAME + "(" +


                    WeatherEntry._ID + "INTEGER PRIMARY KEY AUTOINCREMENT," +


                    WeatherEntry.COLUMN_LOC_KEY + "INTEGER NOT NULL," +

                    WeatherEntry.COLUMN_DATE + "INTEGER NOT NULL," +

                    WeatherEntry.COLUMN_SHORT_DESC + "TEXT NOT NULL," +

                    WeatherEntry.COLUMN_WEATHER_ID + "INTEGER NOT NULL," +

                    WeatherEntry.COLUMN_MIN_TEMP + "REAL NOT NULL," +

                    WeatherEntry.COLUMN_MAX_TEMP + "REAL NOT NULL," +

                    WeatherEntry.COLUMN_HUMIDITY + "REAL NOT NULL," +

                    WeatherEntry.COLUMN_PRESSURE + "REAL NOT NULL," +

                    WeatherEntry.COLUMN_WIND_SPEED + "REAL NOT NULL," +

                    WeatherEntry.COLUMN_DEGREES + "REAL NOT NULL" +

                    " FOREIGN KEY(" + WeatherEntry.COLUMN_LOC_KEY + ") REFERENCE" +
                    LocationEntry.TABLE_NAME + "(" + LocationEntry._ID + ")," +

                    "UNIQUE (" + WeatherEntry.COLUMN_DATE + "," +
                    WeatherEntry.COLUMN_LOC_KEY + ")ON CONFLICT REPLACE);";

            sqLiteDatabase.execSQL(SQL_CREATE_WEATHER_TABLE);

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase,int oldVersion,int newVersion) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXITS" + LocationEntry.TABLE_NAME);
            sqLiteDatabase.execSQL("DROP TABLE IF EXITS" + WeatherEntry.TABLE_NAME);
            onCreate(sqLiteDatabase);

        }


        public SQLiteDatabase getWritetableDatabase() {
            return getWritableDatabase();
        }
    }


    public static final class WeatherEntry implements BaseColumns {
        public static final String TABLE_NAME = "weather";

        public static final String COLUMN_LOC_KEY = "location_id";

        public static final String COLUMN_DATE = "date";

        public static final String COLUMN_WEATHER_ID = "weather_id";

        public static final String COLUMN_SHORT_DESC = "short_desc";

        public static final String COLUMN_MIN_TEMP = "min";

        public static final String COLUMN_MAX_TEMP = "max";

        public static final String COLUMN_HUMIDITY = "humidity";

        public static final String COLUMN_PRESSURE = "pressure";

        public static final String COLUMN_WIND_SPEED = "wind";


        public static final String COLUMN_DEGREES = "degree";


        public static Uri buildWeatherUri(long id) {

            return ContentUris.withAppendedId(CONTENT_URI,id);


        }
        public static  Uri buildWeatherLocation(String locationSetting) {return null;}

        public static  Uri buildWeatherLocationWithStartDate(
                String locationSetting,long startDate) {
            long normalizedDate = normalizeDate(startDate);
            return CONTENT_URI.buildUpon().appendPath(locationSetting).appendQueryParameter(COLUMN_DATE,Long.toString(normalizedDate)).build();
        }


        


    }
}
