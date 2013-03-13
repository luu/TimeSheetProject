package com.example.timesheet;

import java.util.ArrayList;

public class ExecutionHistory {
	protected ArrayList<Execution> executionList=new ArrayList<Execution>();
	public void addExecution(Execution execution){
		this.executionList.add(execution);
	}
	
	public void removeExecution(Execution execution)
	{
		//TODO a optimiser le remove
		this.executionList.remove(execution);
	}
}
