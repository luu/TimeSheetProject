package com.example.timesheet;


import android.os.Bundle;
import android.app.Activity;

import android.widget.ExpandableListView;

public class MainActivity extends Activity {
	ExpandableListView expandable=null;
	Task task1=new Task("Task1",1);
	Task task2=new Task("Task2",2);
	TaskGroup taskGroup=new TaskGroup("TaskGroup1", 1);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//On reprendre la référence de la liste
		expandable=(ExpandableListView) findViewById(R.id.executionListView);
		for(int i=0; i<10;i++){
			task1.addExecution(new Execution(i));
			task2.addExecution(new Execution(i));
		}
		taskGroup.addTask(task1);
		taskGroup.addTask(task2);
		ELExecutionAdapter adapter = new ELExecutionAdapter(this, taskGroup);

		expandable.setAdapter(adapter);
	}

	
}
