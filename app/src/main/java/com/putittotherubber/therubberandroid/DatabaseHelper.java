package com.putittotherubber.therubberandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.putittotherubber.therubberandroid.todo.database.TodoTable;

/**
 * Created by Joseph on 3/4/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_COMMENTS = "comments";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_COMMENT = "comment";


    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_COMMENTS + "( " + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_COMMENT
            + " text not null);";

    private static final String CREATE_USER_TABLE = "create table user"
            + "("
            + "_id" + " integer primary key autoincrement, "
            + "name" + " text not null, "
            + "password" + " text not null, "
            + "modified_time" + " integer not null, "
            + "created_time" + " integer not null " + ")";
    private static final String CREATE_BANK_TABLE = "create table bank"
            + "("
            + "_id" + " integer primary key autoincrement, "
            + "account" + " integer not null, "
            + "title" + " text not null, "
            + "content" + " text not null, "
            + "balance" + " integer not null, "
            + "modified_time" + " integer not null, "
            + "created_time" + " integer not null " + ")";
    private static final String CREATE_BUDGET_TABLE = "create table budget"
            + "("
            + "_id" + " integer primary key autoincrement, "
            + "budget" + " integer not null, "
            + "section" + "text not null, "
            + "title" + " text not null, "
            + "content" + " text not null, "
            + "price" + " integer not null, "
            + "completed" + " integer not null, "
            + "modified_time" + " integer not null, "
            + "created_time" + " integer not null " + ")";
    private static final String CREATE_JOB_TABLE = "create table job"
            + "("
            + "_id" + " integer primary key autoincrement, "
            + "employer" + " text not null, "
            + "title" + " text not null, "
            + "content" + " text not null, "
            + "supervisor" + " text not null, "
            + "sup_number" + " integer, "
            + "tasks" + " text, "
            + "pay" + " integer not null, "
            + "modified_time" + " integer not null, "
            + "created_time" + " integer not null " + ")";
    private static final String CREATE_SCHEDULE_TABLE = "create table schedule"
            + "("
            + "_id" + " integer primary key autoincrement, "
            + "title" + " text not null, "
            + "payment" + "integer not null, "
            + "recurring" + "integer not null, "
            + "amount" + "integer, "
            + "days" + "text, "
            + "content" + " text not null, "
            + "event_date" + " integer, "
            + "modified_time" + " integer not null, "
            + "created_time" + " integer not null " + ")";
    private static final String CREATE_GOAL_TABLE = "create table goal"
            + "("
            + "_id" + " integer primary key autoincrement, "
            + "title" + " text not null, "
            + "content" + " text not null, "
            + "s" + " text not null, "
            + "m" + " text not null, "
            + "a" + " text not null, "
            + "r" + " text not null, "
            + "t" + " text not null, "
            + "completed" + "integer not null, "
            + "modified_time" + " integer not null, "
            + "created_time" + " integer not null " + ")";
    private static final String CREATE_SCHOOL_TABLE = "create table school"
            + "("
            + "_id" + " integer primary key autoincrement, "
            + "title" + " text not null, "
            + "class" + " text, "
            + "homework" + "text, "
            + "due_date" + "text, "
            + "completed" + "integer, "
            + "content" + " text not null, "
            + "modified_time" + " integer not null, "
            + "created_time" + " integer not null " + ")";
//    private static final String CREATE_PROJECT_TABLE = "create table project"
//            + "("
//            + "_id" + " integer primary key autoincrement, "
//            + "title" + " text not null, "
//            + "content" + " text not null, "
//            + "modified_time" + " integer not null, "
//            + "created_time" + " integer not null " + ")";
//    private static final String CREATE_CONTACT_TABLE = "create table contact"
//            + "("
//            + "_id" + " integer primary key autoincrement, "
//            + "title" + " text not null, "
//            + "content" + " text not null, "
//            + "modified_time" + " integer not null, "
//            + "created_time" + " integer not null " + ")";



    private static final String DATABASE_NAME = "comments.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
        TodoTable.onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.w(DatabaseHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS);
        TodoTable.onUpgrade(db, oldVersion, newVersion);
        onCreate(db);

    }

}
