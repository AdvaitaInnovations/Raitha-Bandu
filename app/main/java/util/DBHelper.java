package util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashMap;


/**
 * Created by Naberly1 on 7/18/2016.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Location";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub


        db.execSQL("create table if not exists yatralocation(lat varchar, lon varchar)");


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);
    }







    public  boolean insertyatralocation(double lat, double lon){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("lat",lat);
        contentValues.put("lon",lon);



    db.delete("yatralocation", "", null);
    db.insert("yatralocation", null, contentValues);
    return true;


}



    public HashMap<String, String> getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("select * from yatralocation", null);
        int count = 0;
        HashMap<String, String> mdata = new HashMap<String, String>();
        if(null != rs)
            if(rs.getCount()>0) {

                rs.moveToFirst();
                String lat = rs.getString(rs.getColumnIndex("lat"));
                String lon = rs.getString(rs.getColumnIndex("lon"));





                mdata.put("lat", lat);
                mdata.put("lon", lon);



                if (!rs.isClosed()) {
                    rs.close();
                }

                return mdata;
            }
          return  null;
    }
















}