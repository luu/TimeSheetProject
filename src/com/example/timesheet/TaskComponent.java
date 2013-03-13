package com.example.timesheet;

public abstract class TaskComponent {
	protected String name;
	protected int id;
	
	public TaskComponent(String name, int id){
		this.name=name;
		this.id=id;
	}
}
