package com.example.timesheet;

import java.util.ArrayList;

public class TaskGroup extends TaskComponent {
	protected ArrayList<TaskComponent> taskComponentList=new ArrayList<TaskComponent>();
	public TaskGroup(String name, int id) {
		super(name, id);
	}
	public void addTask(Task task){
		this.taskComponentList.add((Task) task);
	}
}
