package com.db;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHandler {
	public static final String OBJECT = "object";
	public static final String NUMBER = "numbers";
	public static final String STORAGE_ID = "storageid";
	
	public static final String TABLE_NAME = "mytable";
	public static final String DATA_BASE_NAME = "mydatabase";
	public static int DATABASE_VERSION = 1;
	public static final String TABLE_CREATE = "create table mytable(object text not null, numbers text not null, storageid text not null);";

	DataBaseHelper dbhelper;
	Context ctx;
	SQLiteDatabase db;
	
	public DataHandler(Context ctx){
		this.ctx = ctx;
		dbhelper = new DataBaseHelper(ctx);
	}//end DataHandler
	
private static class DataBaseHelper extends SQLiteOpenHelper{
		
		public DataBaseHelper(Context ctx){
			super(ctx, DATA_BASE_NAME, null, DATABASE_VERSION);
		}//end Public DataBaseHelper
		
		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			try{
				db.execSQL(TABLE_CREATE);
			}catch(SQLException e){
				e.printStackTrace();}
		}//end onCreate
	
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXIST mytable");
			onCreate(db);
		}//end onUpgrade
	}//end DataBaseHelper

		//Open Database method
		public DataHandler open(){
			db = dbhelper.getWritableDatabase();
			return this;
		}//end open()
		
		//Close Database
		public void close(){
			dbhelper.close();
		}//end close
	
		//Insert data into Database
		public long insertData(String object, String numbers, String storageid){
			ContentValues content = new ContentValues();
			content.put(OBJECT, object);
			content.put(NUMBER, numbers);
			content.put(STORAGE_ID, storageid);
			return db.insertOrThrow(TABLE_NAME, null, content);
		}//end Insert data
		
		//Retrieve Data
		public Cursor returnData(){
			return db.query(TABLE_NAME,	new String[]{OBJECT, NUMBER, STORAGE_ID},null, null, null, null, null );
		}//end returnData
}
