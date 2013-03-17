package com.example.timesheet;


import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.timesheet.dbmanager.ExecutionDAO;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
	ExpandableListView expandable=null;
	Task task1=new Task("Task1",1);
	Task task2=new Task("Task2",2);
	TaskGroup taskGroup=new TaskGroup("TaskGroup1", 1);
	ExecutionDAO executionDAO=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.task_chronometer);
		executionDAO=new ExecutionDAO(getBaseContext());
		start=(Button) findViewById(R.id.startExecutionButton);
		stop=(Button) findViewById(R.id.stopExecutionButton);
		displayExecution=(TextView) findViewById(R.id.executionChronoView);
		
		start.setOnClickListener(this);
		stop.setOnClickListener(this);

//		//On reprendre la référence de la liste
//		expandable=(ExpandableListView) findViewById(R.id.executionListView);
//		for(int i=0; i<10;i++){
//			task1.addExecution(new Execution(i));
//			task2.addExecution(new Execution(i));
//		}
//		taskGroup.addTask(task1);
//		taskGroup.addTask(task2);
//		ELExecutionAdapter adapter = new ELExecutionAdapter(this, taskGroup);
//
//		expandable.setAdapter(adapter);
	}

	Button start=null;
	Button stop=null;
	TextView displayExecution=null;
	Date dateDebut;
	Date dateFin;
	SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss");

	
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.startExecutionButton:
			dateDebut=new Date();
			//création an execution instance
			Execution e=new Execution();
			e.dateStart=dateDebut;
			e.dateEnd=dateDebut;
			//Ecrire dans la base de donnée
			executionDAO.add(e);

//			Cursor c=executionDAO.getDb().rawQuery("select " + executionDAO.START_DATE +", "+ executionDAO.STOP_DATE+ " from "+executionDAO.EXECUTION_TABLE_NAME);
			//Cursor c=executionDAO.getDb().query(executionDAO.EXECUTION_TABLE_NAME, null, null, null, null, null, null, null);
			SQLiteDatabase maBDD=executionDAO.getDb();
			 Cursor c=executionDAO.selectAll();
				String s=null;

			for(c.moveToFirst(); !c.isAfterLast();
					c.moveToNext()) {
				s=s+c.getString(0)+" "+c.getString(1)+" "+c.getString(2)+" \n";
				displayExecution.setText(s);
					}
			c.close();
			
			break;
		case R.id.stopExecutionButton:
			dateFin=new Date();
			
			displayExecution.setText(displayExecution.getText()+"\n"+f.format(dateDebut)+" "+f.format(dateFin)+" "+(dateFin.getTime()-dateDebut.getTime())/1000);
			break;
		}
			
		
	}
}
