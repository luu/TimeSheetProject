package com.example.timesheet.dbmanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public abstract class DAObase {
	/** Version de la base de donn�e*/
	protected final static int VERSION=2;
	
	protected final static String NOM="database.db";
	protected SQLiteDatabase mDb=null;
	protected DatabaseHandler mHandler=null;
	
	public DAObase(Context pContext) {
		this.mHandler=new DatabaseHandler(pContext, NOM, null, VERSION);
	}
	
	public SQLiteDatabase open(){
		mDb=mHandler.getWritableDatabase();
		return mDb;
	}
	
	public void close(){
		mDb.close();
	}

	public SQLiteDatabase getDb(){
		return this.mDb;
	}
}
