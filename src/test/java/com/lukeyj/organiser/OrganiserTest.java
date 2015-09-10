package com.lukeyj.organiser;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.lukeyj.organiser.entity.BaseTask;
import org.lukeyj.organiser.entity.Organiser;
import org.lukeyj.organiser.entity.Story;
import org.lukeyj.organiser.entity.Task;

public class OrganiserTest {

	final String STORY_NAME = "example story name";
	Story firstStory;
	Organiser organiser;
	
	/*
	 * Display all stories and all Tasks
	 * Display all tasks
	 * Increase priority of story
	 */
	@Before
	public void setup () {

		organiser = new Organiser ("Organiser");
		firstStory = organiser.createStory(STORY_NAME);
	}
	
	@Test
	public void testCreateNewStory () {
		assertEquals(STORY_NAME, firstStory.getName());
	}
	
	@Test
	public void testDisplayFirstStory() {
		List<BaseTask> stories = organiser.getChildren ();
		assertEquals (1, stories.size());
		assertEquals (STORY_NAME, stories.get(0).getName());
		
	}
	
	
	@Test
	public void testRetrieveFirstTask () {
		firstStory.createTask("name of task");
		List<BaseTask> storyTasks = firstStory.getChildren();
		BaseTask firstTask = storyTasks.get(0);
		assertEquals ("name of task", firstTask.getName());
	}
	
	/**
	 * Create new task
	 * Create new story
	 * Retrieve one story
	 * Retrieve one task
	 */
}
