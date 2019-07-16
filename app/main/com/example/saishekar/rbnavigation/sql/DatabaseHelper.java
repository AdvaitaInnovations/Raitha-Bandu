package com.example.saishekar.rbnavigation.sql;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.saishekar.rbnavigation.Model.Login;
import com.example.saishekar.rbnavigation.Model.User;

import java.util.ArrayList;
import java.util.List;
//
//public class DatabaseHelper extends SQLiteOpenHelper {
//
//    // Database Version
//    private static final int DATABASE_VERSION = 1;
//
//    // Database Name
//    private static final String DATABASE_NAME = "UserManager.db";
//
//    // User table name
//    private static final String TABLE_USER = "user";
//
//    // User Table Columns names
//    private static final String COLUMN_USER_ID = "user_id";
//    private static final String COLUMN_USER_NAME = "user_name";
//    private static final String COLUMN_USER_EMAIL = "user_email";
//    private static final String COLUMN_USER_PASSWORD = "user_password";
//
//    // create table sql query
//    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
//            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
//            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")";
//
//    // drop table sql query
//    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;
//
//    /**
//     * Constructor
//     *
//     * @param context
//     */
//    public DatabaseHelper(Context context) {
//        super(context, DATABASE_NAME, null, 1);
//    }
//
//
//    @Override
//
//    public void onCreate(SQLiteDatabase db) {
//        // TODO Auto-generated method stub
//        db.execSQL("create table if not exists user(data text)");
//
//
//    }
//
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        // TODO Auto-generated method stub
//        db.execSQL("DROP TABLE IF EXISTS user");
//        onCreate(db);
//    }
//    public int numberOfRows() {
//        SQLiteDatabase db = this.getReadableDatabase();
//        int numRows = (int) DatabaseUtils.queryNumEntries(db, "user");
//        return numRows;
//    }
//
//
//
//    /**
//     * This method is to create user record
//     *
//     * @param user
//     */
//    public void addUser(User user) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_USER_NAME, user.getName());
//        values.put(COLUMN_USER_EMAIL, user.getEmail());
//        values.put(COLUMN_USER_PASSWORD, user.getPassword());
//
//        // Inserting Row
//        db.insert(TABLE_USER, null, values);
//        db.close();
//    }
//
//    /**
//     * This method is to fetch all user and return the list of user records
//     *
//     * @return list
//     */
//    public List<User> getAllUser() {
//        // array of columns to fetch
//        String[] columns = {
//                COLUMN_USER_ID,
//                COLUMN_USER_EMAIL,
//                COLUMN_USER_NAME,
//                COLUMN_USER_PASSWORD
//        };
//        // sorting orders
//        String sortOrder =
//                COLUMN_USER_NAME + " ASC";
//        List<User> userList = new ArrayList<User>();
//
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        // query the user table
//        /**
//         * Here query function is used to fetch records from user table this function works like we use sql query.
//         * SQL query equivalent to this query function is
//         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
//         */
//        Cursor cursor = db.query(TABLE_USER, //Table to query
//                columns,    //columns to return
//                null,        //columns for the WHERE clause
//                null,        //The values for the WHERE clause
//                null,       //group the rows
//                null,       //filter by row groups
//                sortOrder); //The sort order
//
//
//        // Traversing through all rows and adding to list
//        if (cursor.moveToFirst()) {
//            do {
//                User user = new User();
//                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID))));
//                user.setName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
//                user.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL)));
//                user.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)));
//                // Adding user record to list
//                userList.add(user);
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        db.close();
//
//        // return user list
//        return userList;
//    }
//
//    /**
//     * This method to update user record
//     *
//     * @param user
//     */
//    public void updateUser(User user) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_USER_NAME, user.getName());
//        values.put(COLUMN_USER_EMAIL, user.getEmail());
//        values.put(COLUMN_USER_PASSWORD, user.getPassword());
//
//        // updating row
//        db.update(TABLE_USER, values, COLUMN_USER_ID + " = ?",
//                new String[]{String.valueOf(user.getId())});
//        db.close();
//    }
//
//    /**
//     * This method is to delete user record
//     *
//     * @param user
//     */
//    public void deleteUser(User user) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        // delete user record by id
//        db.delete(TABLE_USER, COLUMN_USER_ID + " = ?",
//                new String[]{String.valueOf(user.getId())});
//        db.close();
//    }
//
//    /**
//     * This method to check user exist or not
//     *
//     * @param email
//     * @return true/false
//     */
//    public boolean checkUser(String email) {
//
//        // array of columns to fetch
//        String[] columns = {
//                COLUMN_USER_ID
//        };
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        // selection criteria
//        String selection = COLUMN_USER_EMAIL + " = ?";
//
//        // selection argument
//        String[] selectionArgs = {email};
//
//        // query user table with condition
//        /**
//         * Here query function is used to fetch records from user table this function works like we use sql query.
//         * SQL query equivalent to this query function is
//         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
//         */
//        Cursor cursor = db.query(TABLE_USER, //Table to query
//                columns,                    //columns to return
//                selection,                  //columns for the WHERE clause
//                selectionArgs,              //The values for the WHERE clause
//                null,                       //group the rows
//                null,                      //filter by row groups
//                null);                      //The sort order
//        int cursorCount = cursor.getCount();
//        cursor.close();
//        db.close();
//
//        if (cursorCount > 0) {
//            return true;
//        }
//
//        return false;
//    }
//
//    /**
//     * This method to check user exist or not
//     *
//     * @param email
//     * @param password
//     * @return true/false
//     */
//    public boolean checkUser(String email, String password) {
//
//        // array of columns to fetch
//        String[] columns = {
//                COLUMN_USER_ID
//        };
//        SQLiteDatabase db = this.getReadableDatabase();
//        // selection criteria
//        String selection = COLUMN_USER_EMAIL + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";
//
//        // selection arguments
//        String[] selectionArgs = {email, password};
//
//        // query user table with conditions
//        /**
//         * Here query function is used to fetch records from user table this function works like we use sql query.
//         * SQL query equivalent to this query function is
//         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
//         */
//        Cursor cursor = db.query(TABLE_USER, //Table to query
//                columns,                    //columns to return
//                selection,                  //columns for the WHERE clause
//                selectionArgs,              //The values for the WHERE clause
//                null,                       //group the rows
//                null,                       //filter by row groups
//                null);                      //The sort order
//
//        int cursorCount = cursor.getCount();
//
//        cursor.close();
//        db.close();
//        if (cursorCount > 0) {
//            return true;
//        }
//
//        return false;
//    }
//
//
//    public boolean insertuser(String data) {
//        // TODO Auto-generated method stu
//
//        try {
//            SQLiteDatabase db = this.getWritableDatabase();
//            ContentValues contentValues = new ContentValues();
//            contentValues.put("data", data);
//
//
//            db.delete("user", "", null);
//            db.insert("user", null, contentValues);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//
//    public User getData() {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor rs = db.rawQuery("select * from user", null);
//        User user = new User();
//
//        rs.moveToFirst();
//        try {
//            String data = rs.getString(rs.getColumnIndex("data"));
//
//            JSONObject jsonObject = new JSONObject(data);
////            JSONArray jsonArray = new JSONArray(data);
////            for (int i = 0; i < jsonArray.length(); i++) {
////                JSONObject jsonObject = new JSONObject(jsonArray.getString(0));
//            // String fname=jsonObject.getString("fname");
//            //user.setFname(fname);
//
//            user.setUid(jsonObject.getInt("uid"));
//
//            user.setFname(jsonObject.getString("fname"));
//            user.setLname(jsonObject.getString("lname"));
//            user.setEmail(jsonObject.getString("email"));
//            user.setPassword(jsonObject.getString("password"));
//            user.setStatus(jsonObject.getString("status"));
//            user.setRole(jsonObject.getString("roleid"));
//            user.setName(jsonObject.getString("name"));
//            double lat, lon;
//            try {
//                lat = Double.parseDouble(jsonObject.getString("lat"));
//                lon = Double.parseDouble(jsonObject.getString("lon"));
//
//            } catch (NumberFormatException e) {
//                lat = 0;
//                lon = 0;
//            }
//            user.setLat(lat);
//            user.setLon(lon);
//            user.setGcm_code(jsonObject.getString("gcm_code"));
//            user.setPhoneno(jsonObject.getString("phoneno"));
//            user.setCdate(jsonObject.getString("cdate"));
//            user.setProfileImage(jsonObject.getString("userimage"));
//            user.setDivision(jsonObject.getString("division"));
//
//            if (jsonObject.has("otp")) {
//                user.setOtp(jsonObject.getString("otp"));
//            }
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//        if (!rs.isClosed()) {
//            rs.close();
//        }
//        return user;
//    }
//
//    public boolean deletetable(String table) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(table, "", null);
//        return true;
//    }
//
//
//}


public class DatabaseHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "RaithaBandu.db";

    //Table name
    private static final String TABLE_LOGIN = "Login";
    private static final String TABLE_USER = "User";


    // Login Table Columns names

    private static final String COLUMN_LOGIN_NAME = "login_name";
    private static final String COLUMN_LOGIN_PHONE = "login_phone";
    private static final String COLUMN_LOGIN_PASSWORD = "login_password";

    //Common Column Values
    private static final String COLUMN_USER_ID = "user_id";
    private static final String KEY_CREATED_AT = "created_at";


    //User Table Column Names
    private  static  final String COLUMN_USER_NAME="user_name";
    private static final String COLUMN_USER_PHONE="user_phone";
    private static final String COLUMN_USER_ADDRESS="user_Address";
    private static final String COLUMN_LAND_DETAILS="user_land_details";

    // create table sql query
    private String CREATE_LOGIN_TABLE = "CREATE TABLE " + TABLE_LOGIN+ "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_LOGIN_NAME + " TEXT,"
            + COLUMN_LOGIN_PHONE + " INTEGER," + COLUMN_LOGIN_PASSWORD + " TEXT," + KEY_CREATED_AT
            + " DATETIME" + ")";


    // create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_PHONE + " INTEGER," + COLUMN_USER_ADDRESS + " TEXT,"
            + COLUMN_LAND_DETAILS + " INTEGER," + KEY_CREATED_AT
            + " DATETIME" + ")";

    // drop table sql query
    private String DROP_LOGIN_TABLE = "DROP TABLE IF EXISTS " + TABLE_LOGIN;
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    /**
     * Constructor
     *
     * @param context
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_LOGIN_TABLE);
        db.execSQL(CREATE_USER_TABLE);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exist
        db.execSQL(DROP_LOGIN_TABLE);
        db.execSQL(CREATE_USER_TABLE);
        // Create tables again
        onCreate(db);

    }

    /**
     * This method is to create user record
     *
     * @param login
     */
    public void addLogin(Login login) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_LOGIN_NAME, login.getName());
        values.put(COLUMN_LOGIN_PHONE, login.getPhone());
        values.put(COLUMN_LOGIN_PASSWORD, login.getPassword());

        // Inserting Row
        db.insert(TABLE_LOGIN, null, values);
        db.close();
    }

    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values1 = new ContentValues();
        values1.put(COLUMN_LOGIN_NAME, user.getName());
        values1.put(COLUMN_LOGIN_PHONE, user.getPhone());
        values1.put(COLUMN_LOGIN_PASSWORD, user.getPassword());

        // Inserting Row
        db.insert(TABLE_USER, null, values1);
        db.close();
    }

    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    public List<Login> getAllLoginUser() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID,
                COLUMN_LOGIN_PHONE,
                COLUMN_LOGIN_NAME,
                COLUMN_LOGIN_PASSWORD
        };
        // sorting orders
        String sortOrder =
                COLUMN_LOGIN_NAME + " ASC";
        List<Login> loginuserList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_LOGIN, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Login login = new Login();
                login.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID))));
                login.setName(cursor.getString(cursor.getColumnIndex(COLUMN_LOGIN_NAME)));
                login.setPhone(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_LOGIN_PHONE))));
                login.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_LOGIN_PASSWORD)));
                // Adding user record to list
                loginuserList.add(login);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return loginuserList;
    }

    public List<User> getAllUser() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID,
                COLUMN_USER_PHONE,
                COLUMN_USER_NAME,
                COLUMN_USER_ADDRESS,
                COLUMN_LAND_DETAILS
        };
        // sorting orders
        String sortOrder =
                COLUMN_USER_NAME + " ASC";
        List<User> userList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID))));
                user.setName(cursor.getString(cursor.getColumnIndex(COLUMN_LOGIN_NAME)));
                user.setPhone(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_LOGIN_PHONE))));
                user.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_LOGIN_PASSWORD)));
                // Adding user record to list
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userList;
    }


    public List<User> getAllToDos() {
        List<User> todos = new ArrayList<User>();
        String selectQuery = "SELECT  * FROM " + TABLE_USER;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                User td = new User();
                td.setId(c.getInt((c.getColumnIndex(COLUMN_USER_ID))));
                td.setName(c.getString(c.getColumnIndex(COLUMN_LOGIN_NAME)));
                td.setPhone(Integer.parseInt(c.getString(c.getColumnIndex(COLUMN_LOGIN_PHONE))));
                td.setPassword(c.getString(c.getColumnIndex(COLUMN_LOGIN_PASSWORD)));
                // adding to todo list
                todos.add(td);
            } while (c.moveToNext());
        }

        return todos;
    }
    /**
     * This method to update user record
     *
     * @param user
     */
    public void updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_LOGIN_NAME, user.getName());
        values.put(COLUMN_LOGIN_PHONE, user.getPhone());
        values.put(COLUMN_LOGIN_PASSWORD, user.getPassword());

        // updating row
        db.update(TABLE_LOGIN, values, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }

    /**
     * This method is to delete user record
     *
     * @param user
     */
    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_LOGIN, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }

    /**
     * This method to check user exist or not
     *
     * @param email
     * @return true/false
     */
    public boolean checkUser(String email) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_LOGIN_PHONE + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_LOGIN, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    /**
     * This method to check user exist or not
     *
     * @param phone
     * @param password
     * @return true/false
     */
    public boolean checkUser(String phone, String password) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_LOGIN_PHONE + " = ?" + " AND " + COLUMN_LOGIN_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {phone, password};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_LOGIN, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }
}