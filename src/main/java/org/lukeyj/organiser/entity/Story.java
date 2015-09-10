package org.lukeyj.organiser.entity;


public class Story extends BaseTask {

	public Story (String name) {
		super(name);
	}

	public void createTask(String taskName) {
		Task newTask = new Task (taskName);
		children.add(newTask);
	}

}
