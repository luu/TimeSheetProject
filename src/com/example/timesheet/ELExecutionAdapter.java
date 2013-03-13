package com.example.timesheet;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;


public class ELExecutionAdapter extends BaseExpandableListAdapter {
	Context context;
	private TaskGroup taskGroup;
	private LayoutInflater inflater;

	public ELExecutionAdapter(Context context,TaskGroup taskGroup){
		super();
		this.taskGroup=taskGroup;
		this.context=context;
		inflater = LayoutInflater.from(context);

	}
	@Override
	public Object getChild(int indexGroup, int indexChild) {
		return ((Task)taskGroup.taskComponentList.get(indexGroup)).
				executionHistory.executionList.get(indexChild);
	}

	@Override
	public long getChildId(int indexGroup, int indexChild) {
		return ((Execution)((Task)taskGroup.taskComponentList.get(indexGroup)).
				executionHistory.executionList.get(indexChild)).id;
	}

	@Override
	public View getChildView(int indexGroup, int indexChild, boolean isLastChild, View convertView,
			ViewGroup parent) {
		final Execution execution = (Execution) getChild(indexGroup, indexChild);
		
		ChildViewHolder childViewHolder;
		
        if (convertView == null) {
        	childViewHolder = new ChildViewHolder();
        	
            convertView = inflater.inflate(R.layout.execution_view, null);
            
            childViewHolder.textViewChild = (TextView) convertView.findViewById(R.id.textViewExecution);            
            convertView.setTag(childViewHolder);
        } else {
        	childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        
        childViewHolder.textViewChild.setText("Execution "+execution.id+" : "+execution.duration);
        
        
        return convertView;
	}
	
	@Override
	public int getChildrenCount(int indexGroup) {
		return ((Task)taskGroup.taskComponentList.get(indexGroup)).
				executionHistory.executionList.size();
	}

	@Override
	public Object getGroup(int index) {
		return (Task)taskGroup.taskComponentList.get(index);
	}

	@Override
	public int getGroupCount() {
		return taskGroup.taskComponentList.size();
	}

	@Override
	public long getGroupId(int index) {
		return ((Task)taskGroup.taskComponentList.get(index)).id;
	}

	@Override

	
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		GroupViewHolder gholder;
		
		Task group = (Task) getGroup(groupPosition);
		
        if (convertView == null) {
        	gholder = new GroupViewHolder();
        	
        	convertView = inflater.inflate(R.layout.task_view, null);
        	
        	gholder.textViewGroup = (TextView) convertView.findViewById(R.id.textViewTaskView);
        	
        	convertView.setTag(gholder);
        } else {
        	gholder = (GroupViewHolder) convertView.getTag();
        }
        
        gholder.textViewGroup.setText(group.name);
        
        return convertView;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		return true;
	}
	class ChildViewHolder {
		public TextView textViewChild;
	}
	class GroupViewHolder {
		public TextView textViewGroup;
	}
}
