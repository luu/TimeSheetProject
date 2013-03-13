package com.example.timesheet;

public class Task extends TaskComponent{
	public Task(String name, int id) {
		super(name, id);
	}
	protected ExecutionHistory executionHistory=new ExecutionHistory();
	
	public void viewTaskExecutionHistory(){
		
	}
	public void addExecution(Execution exc){
		executionHistory.addExecution(exc);
	}
}
