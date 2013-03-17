package com.example.timesheet.dbmanager;

import com.example.timesheet.Execution;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class ExecutionDAO extends DAObase{
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
	
	public ExecutionDAO(Context pContext) {
		super(pContext);
	}
	
	/**
	 * @param e ajouter une exécution dans la base
	 */
	public void add(Execution e){
		ContentValues value=new ContentValues();
		value.put(TASK_PARENT, e.getParentID());
		value.put(START_DATE, StringDateOperations.date2String(e.getDateStart()));
		value.put(STOP_DATE, StringDateOperations.date2String(e.getDateEnd()));
		//Ouvrir la base
		open();
		long result=mDb.insert(EXECUTION_TABLE_NAME, null, value);
		close();
	}
	
	/**
	 * Supprimer d'une exécution de la base
	 * @param id de l'exécution à retirer
	 */
	public void remove(long id){
		mDb.delete(EXECUTION_TABLE_NAME, EXECUTION_KEY+"=?", new String[]{String.valueOf(id)});
	}
	/**
	 * modifier une exécution
	 * @param e exécution à modifier
	 */
	public void edit(Execution e){
		ContentValues values=new ContentValues();
		values.put(TASK_PARENT, e.getParentID());
		values.put(START_DATE,StringDateOperations.date2String(e.getDateStart()));
		values.put(STOP_DATE,StringDateOperations.date2String(e.getDateStart()));
		mDb.update(EXECUTION_TABLE_NAME,values, EXECUTION_KEY+"=?", new String[]{String.valueOf(e.getId())});
	}
	/**
	 * Choisir une exécution
	 * @param id
	 */
	public void select(long id){
		Cursor c=mDb.rawQuery("select " + START_DATE +", "+ STOP_DATE, null);
		c.moveToLast();
		
	}
	public Cursor selectAll(){
		open();
		return(mDb.query(EXECUTION_TABLE_NAME,
                new String[] { EXECUTION_KEY,
							START_DATE,
							STOP_DATE }, null, null, null,
	                null, null));
	}
	


}
