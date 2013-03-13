package com.example.timesheet;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.text.format.DateFormat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ChronometerTask extends Activity implements OnClickListener {
	Button start=null;
	Button stop=null;
	TextView displayExecution=null;
	Date dateDebut;
	Date dateFin;
	SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd'T'HHmmss");

	public ChronometerTask(){
		start=(Button) findViewById(R.id.startExecutionButton);
		stop=(Button) findViewById(R.id.stopExecutionButton);
		displayExecution=(TextView) findViewById(R.id.executionChronoView);
		
		start.setOnClickListener(this);
		stop.setOnClickListener(this);

	}
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.startExecutionButton:
			dateDebut=new Date();
			displayExecution.setText(f.format(dateDebut)+" "+f.format(dateDebut));
			break;
		case R.id.stopExecutionButton:
			dateFin=new Date();
			displayExecution.setText(displayExecution+"\n"+f.format(dateDebut)+" "+f.format(dateFin));
			break;
		}
			
		
	}
}
