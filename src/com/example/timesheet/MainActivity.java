package com.example.timesheet;


import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Bundle;
import android.app.Activity;

import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
	ExpandableListView expandable=null;
	Task task1=new Task("Task1",1);
	Task task2=new Task("Task2",2);
	TaskGroup taskGroup=new TaskGroup("TaskGroup1", 1);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.task_chronometer);
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
			displayExecution.setText(f.format(dateDebut)+" "+f.format(dateDebut));
			break;
		case R.id.stopExecutionButton:
			dateFin=new Date();
			
			displayExecution.setText(displayExecution.getText()+"\n"+f.format(dateDebut)+" "+f.format(dateFin)+" "+(dateFin.getTime()-dateDebut.getTime())/1000);
			break;
		}
			
		
	}
}
