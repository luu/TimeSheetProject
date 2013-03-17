package com.example.timesheet.dbmanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
	public static final String EXECUTION_KEY="id";
	public static final String TASK_PARENT="Tache";
	public static final String START_DATE="Debut";
	public static final String STOP_DATE="Fin";
	public static final String DURATION="Duree";
	public static final String EXECUTION_TABLE_NAME="Execution";
	public static final String EXECUTION_TABLE_CREATE= 
			"CREATE TABLE "+ EXECUTION_TABLE_NAME+ " ("+
			EXECUTION_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
			TASK_PARENT+ " INTEGER, "+
			START_DATE+ " TEXT, "+
			STOP_DATE+ " TEXT, "+
			DURATION+ " TEXT); ";
	public static final String TABLE_DROP = "DROP TABLE IF EXISTS " +
			EXECUTION_TABLE_NAME + ";";
	public DatabaseHandler(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(EXECUTION_TABLE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub
		db.execSQL(TABLE_DROP);
		db.execSQL(EXECUTION_TABLE_CREATE);

	}

}
