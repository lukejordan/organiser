package org.lukeyj.organiser.view;

import java.util.List;

import org.lukeyj.organiser.entity.BaseTask;

public class OrganiserView {

	public static void displayBoard(BaseTask task) {
		output (task);
		
		List<BaseTask> children = task.getChildren();
		for (BaseTask child : children) {
			displayBoard (child);
		}
	}

	private static void output(BaseTask task) {
		String [] nameSplit = task.getClass().getName().split("\\.");
		String className = nameSplit[nameSplit.length-1];
		System.out.println(className + ": "+ task.getName());
	}

	
}
